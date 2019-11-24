package com.example.demo.entity;

import io.crnk.core.resource.annotations.JsonApiField;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonApiResource(type = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonApiId
    private Long id;

    @Column
    @JsonApiField
    private String description;

    @ManyToMany
    @JsonApiRelation
    private List<Library> libraries;

    @ManyToMany
    @JsonApiRelation
    private List<User> authors;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonApiRelation
    private Publisher publisher;

    public Long getId() {
        return id;
    }

    public Book setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Book setDescription(String description) {
        this.description = description;
        return this;
    }

    public List<Library> getLibraries() {
        return libraries;
    }

    public Book setLibraries(List<Library> libraries) {
        this.libraries = libraries;
        return this;
    }

    public List<User> getAuthors() {
        return authors;
    }

    public Book setAuthors(List<User> authors) {
        this.authors = authors;
        return this;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public Book setPublisher(Publisher publisher) {
        this.publisher = publisher;
        return this;
    }
}
