package blog.controllers;

import blog.forms.PostForm;
import blog.forms.RegisterForm;
import blog.models.Post;
import blog.services.NotificationService;
import blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.sql.Date;
import java.util.List;


@Controller
public class PostController {

    @Autowired
    PostService postService;

    @Autowired
    NotificationService notificationService;

    /**
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/posts/view/{id}")
    public String view(@PathVariable("id") Long id, Model model){
        Post post = postService.findById(id);

        if(post ==null)
        {
            notificationService.addErrorMessage("cannot find post #"+id);
            return "redirect:/";

        }

        model.addAttribute("post",post);

        return "posts/view";

    }

    /**
     * the all posts will be shown in here.
     * let's see what's happening once run it..:)
     * you are thing about the meaning when you carefully read this comments
     * actually I am understand the exactly means for these comments when I wrote these code,
     * but it's working now, I wound not be change it,
     * @param model
     * @return
     */
    @RequestMapping("/posts/index")
    public String viewAllPosts(Model model){

        List<Post> posts = postService.findAll();

        model.addAttribute("posts", posts);
        return "/posts/index";
    }

    /**
     * initial the new post page..
     * @param model
     * @return
     */
    @RequestMapping(value = "/posts/create", method = RequestMethod.GET)
    public String initPostIndex(Model model){
        return "/posts/create";
    }

    @RequestMapping(value = "/posts/create", method = RequestMethod.POST)
    public String createNewPost(@Valid  PostForm postForm,
                                BindingResult bindingResult){
        //convert dto to entity object.

        Post post = new Post();
        post.setTitle(postForm.getTitle());
        post.setBody(postForm.getBody());
        post.setDate(Date.valueOf("2018-07-04"));

        //create new post in the db.
        postService.create(post);
        return "/posts/create";

    }

}
