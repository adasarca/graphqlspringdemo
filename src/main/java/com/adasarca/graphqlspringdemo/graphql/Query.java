package com.adasarca.graphqlspringdemo.graphql;

import com.adasarca.graphqlspringdemo.dao.PostDao;
import com.adasarca.graphqlspringdemo.model.Post;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Query implements GraphQLQueryResolver {

    private final PostDao postDao;

    @Autowired
    public Query(PostDao postDao) {
        this.postDao = postDao;
    }

    public List<Post> getRecentPosts(int count, int offset) {
        return postDao.getRecentPosts(count, offset);
    }
}
