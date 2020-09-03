package org.egde.BlazorWorkshop.service;

import org.egde.BlazorWorkshop.domain.Status;
import org.egde.BlazorWorkshop.domain.dto.BookDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Component
public class LibraryService {
    private List<BookDto> books = new ArrayList<>();

    public LibraryService() {
        books.add(BookDto.with()
            .name("Lord of the Rings")
            .author("J. R. R. Tolkien")
            .status(Status.AVAILABLE)
            .build()
        );
        books.add(BookDto.with()
            .name("Harry Potter and the Philosophers Stone")
            .author("J. K. Rowling")
            .status(Status.AVAILABLE)
            .build()
        );
        books.add(BookDto.with()
                .name("Hitchhikers Guide to the Galaxy")
                .author("Douglas Adams")
                .status(Status.RENTED)
                .build()
        );
    }

    public void addBook(BookDto bookDto) {
        books.add(bookDto);
    }

    public List<BookDto> getBooks() {
        return books;
    }

    public BookDto getBook(Integer id) {
        if (id == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID missing");
        }
        BookDto book;
        try {
            book = books.get(id);
        } catch (IndexOutOfBoundsException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Couldn't find a book with id " + id);
        }

        if (book == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Couldn't find a book with id " + id);
        }

        return book;
    }

    public void rentBook(Integer id) {
        if (id == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID missing");
        }

        try {
            if (books.get(id).getStatus() == Status.AVAILABLE) {
                books.get(id).setStatus(Status.RENTED);
            } else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cannot rent an already rented book");
            }
        } catch (IndexOutOfBoundsException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Couldn't find a book with id " + id);
        }
    }

    public void deliverBook(Integer id) {
        if (id == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID missing");
        }

        if (books.get(id).getStatus() == Status.RENTED) {
            books.get(id).setStatus(Status.AVAILABLE);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cannot deliver an available book");
        }
    }

    public void deleteBook(Integer id) {
        if (id == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID missing");
        }

        books.remove(id.intValue());
    }
}
