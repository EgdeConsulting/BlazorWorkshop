package org.egde.BlazorWorkshop.domain.dto;

import org.egde.BlazorWorkshop.domain.Status;
import org.springframework.lang.NonNull;

public class BookDto {
    @NonNull
    private String name = "";
    @NonNull
    private String author = "";
    @NonNull
    private Status status = Status.AVAILABLE;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public static Builder with() {
        return new Builder();
    }

    public static final class Builder {
        private BookDto bookDto;

        private Builder() {
            bookDto = new BookDto();
        }

        public Builder name(String name) {
            bookDto.name = name;
            return this;
        }

        public Builder author(String author) {
            bookDto.author = author;
            return this;
        }

        public Builder status(Status status) {
            bookDto.status = status;
            return this;
        }

        public BookDto build() {
            return bookDto;
        }
    }
}
