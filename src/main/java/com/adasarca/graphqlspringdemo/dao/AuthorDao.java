package com.adasarca.graphqlspringdemo.dao;

import com.adasarca.graphqlspringdemo.model.Author;
import org.checkerframework.checker.units.qual.A;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class AuthorDao {

    private final List<Author> authors;

    public AuthorDao() {
        this.authors = new LinkedList<>();

        for (int i = 1; i <= 5; i++) {
            Author author = new Author();
            author.setId("Author" + i);
            char x = (char)('A' + i - 1);
            author.setName("Author Name " + x);
            this.authors.add(author);
        }
    }

    public Author get(String id) {
        for (Author author : this.authors)
            if (author.getId().equals(id))
                return author;
        return null;
    }
}
