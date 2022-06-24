package com.adasarca.graphqlspringdemo.graphql;

import com.adasarca.graphqlspringdemo.dao.PostDao;
import com.adasarca.graphqlspringdemo.model.Author;
import com.adasarca.graphqlspringdemo.model.Post;
import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorResolver implements GraphQLResolver<Author> {

    private final PostDao postDao;

    @Autowired
    public AuthorResolver(PostDao postDao) {
        this.postDao = postDao;
    }

    public List<Post> getPosts(Author author) {
        return postDao.getAuthorPosts(author.getId());
    }
}
