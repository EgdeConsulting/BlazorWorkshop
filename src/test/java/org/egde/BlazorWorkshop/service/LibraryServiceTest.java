package org.egde.BlazorWorkshop.service;

import org.egde.BlazorWorkshop.domain.Status;
import org.egde.BlazorWorkshop.domain.dto.BookDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LibraryServiceTest {

    private BookDto bookDto;

    @Before
    public void setUp() {
        bookDto = BookDto.with()
                .status(Status.AVAILABLE)
                .name("Hitchhikers guide to the galaxy")
                .build();
    }

    @Test
    public void shouldAddBooksToList() {

    }
}
