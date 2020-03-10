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
}
