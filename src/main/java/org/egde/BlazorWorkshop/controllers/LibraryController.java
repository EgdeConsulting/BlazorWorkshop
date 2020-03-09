package org.egde.BlazorWorkshop.controllers;

import org.egde.BlazorWorkshop.domain.dto.BookDto;
import org.egde.BlazorWorkshop.service.LibraryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/api/library")
public class LibraryController {

    private LibraryService libraryService;

    @Inject
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @PostMapping(value = "/addbook", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addBook(@RequestBody BookDto bookDto) {
        if (bookDto == null) {
            throw new RestClientException("BookDto not found in request",
                    new HttpClientErrorException(HttpStatus.BAD_REQUEST));
        }

        libraryService.addBook(bookDto);
    }

    @GetMapping(value = "/{bookid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public BookDto getBook(Integer bookid) {
        return libraryService.getBook(bookid);
    }

    @GetMapping(value = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BookDto> getBooks() {
        return libraryService.getBooks();
    }

    @PostMapping(value = "/rent/{bookid}")
    public void rentBook(Integer bookid) {
        libraryService.rentBook(bookid);
    }

    @PostMapping(value = "/deliver/{bookid}")
    public void deliverBook(Integer bookid) {
        libraryService.deliverBook(bookid);
    }

    @DeleteMapping(value = "/deletebook/{bookid}")
    public void deleteBook(Integer bookid) {
        libraryService.deleteBook(bookid);
    }
}
