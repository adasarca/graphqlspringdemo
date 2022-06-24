package com.adasarca.graphqlspringdemo.graphql;

import com.adasarca.graphqlspringdemo.dao.PostDao;
import com.adasarca.graphqlspringdemo.model.Post;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class Mutation implements GraphQLMutationResolver {

    private final PostDao postDao;

    @Autowired
    public Mutation(PostDao postDao) {
        this.postDao = postDao;
    }

    public Post writePost(String title, String text, String category, String authorId) {
        Post post = new Post();
        post.setId(UUID.randomUUID().toString());
        post.setTitle(title);
        post.setText(text);
        post.setCategory(category);
        post.setAuthorId(authorId);
        postDao.savePost(post);

        return post;
    }
}
