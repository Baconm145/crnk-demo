package com.example.demo.entity;

import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;

import javax.persistence.*;
import java.util.List;

@JsonApiResource(type = "users")
@Entity
@Table(name = "users")
public class User {
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

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public List<Book> getBooks() {
        return books;
    }

    public User setBooks(List<Book> books) {
        this.books = books;
        return this;
    }
}
