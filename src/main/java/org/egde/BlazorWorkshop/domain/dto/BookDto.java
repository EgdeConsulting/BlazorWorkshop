package org.egde.BlazorWorkshop.domain.dto;

import org.egde.BlazorWorkshop.domain.Status;

public class BookDto {

    private String name;
    private Status status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public static BookDto.Builder with() {
        return new Builder();
    }

    public static class Builder {
        private BookDto bookDto = new BookDto();

        public Builder() {
        }

        public Builder name(String name) {
            bookDto.name = name;
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
