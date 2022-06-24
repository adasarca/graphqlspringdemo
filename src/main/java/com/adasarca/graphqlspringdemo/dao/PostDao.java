package com.adasarca.graphqlspringdemo.dao;

import com.adasarca.graphqlspringdemo.model.Post;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostDao {

    private final List<Post> posts;

    public PostDao() {
        this.posts = new LinkedList<>();

        for (int i = 1; i <= 5; i++)
            for (int j = 1; j <= i; j++) {
                Post post = new Post();
                post.setId("Post-" + i + "-" + j);
                post.setAuthorId("Author" + i);
                post.setTitle("Title " + i + " " + j);
                post.setText("Text " + i + " " + j);
                post.setCategory("Category-" + j);
                posts.add(post);
            }
    }

    public List<Post> getRecentPosts(int count, int offset) {
        return posts.stream().skip(offset).limit(count).collect(Collectors.toList());
    }

    public List<Post> getAuthorPosts(String authorId) {
        return posts.stream().filter(post -> post.getAuthorId().equals(authorId)).collect(Collectors.toList());
    }

    public void savePost(Post post) {
        posts.add(0, post);
    }
}
