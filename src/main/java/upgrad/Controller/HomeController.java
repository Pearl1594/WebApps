package upgrad.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import upgrad.model.Post;

import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String getAllPosts(Model model){
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

        List<Post> posts = new ArrayList<Post>();
        posts.add(post1);
        posts.add(post2);
        posts.add(post3);
        model.addAttribute("Posts",posts);
        return "index";
    }
}
