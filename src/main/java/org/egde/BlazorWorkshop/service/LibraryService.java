package org.egde.BlazorWorkshop.service;

import org.egde.BlazorWorkshop.domain.Status;
import org.egde.BlazorWorkshop.domain.dto.BookDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;

import java.util.ArrayList;
import java.util.List;

@Component
public class LibraryService {
    private List<BookDto> books = new ArrayList<>();

    public LibraryService() {

    }

    public void addBook(BookDto bookDto) {
        books.add(bookDto);
    }

    public List<BookDto> getBooks() {
        return books;
    }

    public BookDto getBook(Integer id) {
        if (id == null) {
            throw new RestClientException("ID missing", new HttpClientErrorException(HttpStatus.BAD_REQUEST));
        }

        return books.get(id);
    }

    public void rentBook(Integer id) {
        if (id == null) {
            throw new RestClientException("ID missing", new HttpClientErrorException(HttpStatus.BAD_REQUEST));
        }

        if (books.get(id).getStatus() == Status.AVAILABLE) {
            books.get(id).setStatus(Status.RENTED);
        } else {
            throw new RestClientException("Cannot rent an already rented book",
                    new HttpClientErrorException(HttpStatus.BAD_REQUEST));
        }
    }

    public void deliverBook(Integer id) {
        if (id == null) {
            throw new RestClientException("ID missing", new HttpClientErrorException(HttpStatus.BAD_REQUEST));
        }

        if (books.get(id).getStatus() == Status.RENTED) {
            books.get(id).setStatus(Status.AVAILABLE);
        } else {
            throw new RestClientException("Cannot delivered an available book",
                    new HttpClientErrorException(HttpStatus.BAD_REQUEST));
        }
    }

    public void deleteBook(Integer id) {
        if (id == null) {
            throw new RestClientException("ID missing", new HttpClientErrorException(HttpStatus.BAD_REQUEST));
        }

        books.remove(id.intValue());
    }
}
