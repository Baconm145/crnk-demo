package com.example.demo.resourceRepository;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.resource.list.ResourceList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookResourceRepository extends ResourceRepositoryBase<Book, Long> {
    private BookRepository bookRepository;

    @Autowired
    public BookResourceRepository(BookRepository bookRepository) {
        super(Book.class);
        this.bookRepository = bookRepository;
    }

    @Override
    public ResourceList<Book> findAll(QuerySpec querySpec) {
        return querySpec.apply(bookRepository.findAll());
    }

    @Override
    public <S extends Book> S create(S resource) {
        return bookRepository.save(resource);
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
}
