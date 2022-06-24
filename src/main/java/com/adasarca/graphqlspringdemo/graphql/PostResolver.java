package com.adasarca.graphqlspringdemo.graphql;

import com.adasarca.graphqlspringdemo.dao.AuthorDao;
import com.adasarca.graphqlspringdemo.model.Author;
import com.adasarca.graphqlspringdemo.model.Post;
import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostResolver implements GraphQLResolver<Post> {

    private final AuthorDao authorDao;

    @Autowired
    public PostResolver(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    public Author getAuthor(Post post) {
        return authorDao.get(post.getAuthorId());
    }
}
