package blog.controllers;


import blog.models.Post;
import blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {


    @Autowired
    private PostService postService;

    @RequestMapping("/")
    public String index(Model model){
        //initiate the home page..

        List<Post> last5Post = postService.findLatest5();
        model.addAttribute("lastest5posts",last5Post);

        List<Post> last3Posts =
                last5Post.stream().limit(3).collect(Collectors.toList());
        model.addAttribute("lastest3Posts",last3Posts);


        return "index";
    }

}
