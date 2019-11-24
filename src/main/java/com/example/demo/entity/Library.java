package com.example.demo.entity;

import io.crnk.core.resource.annotations.JsonApiField;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;

import javax.persistence.*;
import java.util.List;

@JsonApiResource(type = "libraries")
@Entity
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonApiId
    private Long id;

    @ManyToMany
    @JsonApiRelation
    private List<Book> books;

    public Long getId() {
        return id;
    }

    public Library setId(Long id) {
        this.id = id;
        return this;
    }

    public List<Book> getBooks() {
        return books;
    }

    public Library setBooks(List<Book> books) {
        this.books = books;
        return this;
    }
}
