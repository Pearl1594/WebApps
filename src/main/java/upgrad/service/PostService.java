package upgrad.service;

import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upgrad.model.Post;
import upgrad.repository.PostRepository;

import javax.persistence.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PostService {
    @PersistenceUnit(unitName = "techblog")
    private EntityManagerFactory emf;
    @Autowired
    private PostRepository repository;

    public PostService() { System.out.println("***** Post Service *****");}

    @Autowired(required = true)
    public List<Post>  getAllPosts(){

        return  repository.getAllPosts();
        /*Replaced by jpa code*/
       /* Post post1 = new Post();
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
        posts.add(post3);*/

        //ArrayList<Post> posts = new ArrayList<Post>();

        /* moved to repository layer */
       /* EntityManager em = emf.createEntityManager();
        TypedQuery<Post> query = em.createQuery("select p from Post p" ,Post.class);
        List<Post> resultList = query.getResultList();*/

        /*Connection connection = null;
       try {
           Class.forName("org.postgresql.Driver");
           connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BlogPosts","postgres","1234");
           Statement statement = connection.createStatement();
           ResultSet rs = statement.executeQuery("select * FROM posts");
           while (rs.next()){
               Post post = new Post();
               post.setTitle(rs.getString("title"));
               post.setBody(rs.getString("body"));
               posts.add(post);
           }

       }
       catch (ClassNotFoundException |SQLException e){
           e.printStackTrace();
       }
       finally {
           try {
               connection.close();
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }
        return posts;
        return resultList;*/
    }

    public Post getOnePost() {
        //ArrayList<Post> posts = new ArrayList<Post>();
        // replaced by jdbc api
        /*Post post1 = new Post();
        post1.setTitle("User Post");
        post1.setBody("This is your first Post!");
        post1.setDate(new Date());
        posts.add(post1);
        return posts;*/

        // following jdbc code is replaced by jpa

        /*Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BlogPosts","postgres","1234");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * FROM posts where id=4");
            while (rs.next()){
                Post post = new Post();
                post.setTitle(rs.getString("title"));
                post.setBody(rs.getString("body"));
                posts.add(post);
            }

        }
        catch (ClassNotFoundException |SQLException e){
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return posts;*/
        return repository.getLatestPost();
    }

    // to save the post submitted by the form
    public void createPost(Post newPost) {
        newPost.setDate(new Date());
        repository.createPost(newPost);
        System.out.println("New Post: "+newPost);
    }


    public Post getPost(Integer postId){
        return repository.getPost(postId);
    }

    public void updatePost(Post updatedPost) {
        updatedPost.setDate(new Date());
        repository.updatePost(updatedPost);
    }

    public void deletePost(Integer postId){
        repository.deletePost(postId);
    }
}
