package upgrad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upgrad.model.Post;

import java.util.ArrayList;
import java.util.Date;

@Service
public class PostService {

    @Autowired(required = true)
    public ArrayList<Post>  getAllPosts(){
        Post post1 = new Post();
        post1.setTitle("Post 1");
        post1.setBody("This is the First Post!");
        post1.setDate(new Date());

        Post post2 = new Post();
        post2.setTitle("Post 2");
        post2.setBody("This is the Second Post!");
        post2.setDate(new Date());

        Post post3 = new Post();
        post3.setTitle("Post 3");
        post3.setBody("This is the Third Post!");
        post3.setDate(new Date());

        ArrayList<Post> posts = new ArrayList<Post>();
        posts.add(post1);
        posts.add(post2);
        posts.add(post3);

        return posts;
    }

    public ArrayList<Post> getOnePost() {
        ArrayList<Post> posts = new ArrayList<Post>();
        Post post1 = new Post();
        post1.setTitle("User Post");
        post1.setBody("This is your first Post!");
        post1.setDate(new Date());
        posts.add(post1);
        return posts;
    }
}
