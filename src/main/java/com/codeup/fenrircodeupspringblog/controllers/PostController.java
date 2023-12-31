package com.codeup.fenrircodeupspringblog.controllers;

import com.codeup.fenrircodeupspringblog.models.Post;
import com.codeup.fenrircodeupspringblog.models.User;
import com.codeup.fenrircodeupspringblog.repositories.PostRepository;
import com.codeup.fenrircodeupspringblog.repositories.UserRepository;
import com.codeup.fenrircodeupspringblog.services.EmailService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private PostRepository postDao;
    private UserRepository userDao;
    private EmailService emailService;

    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailService) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
    }

    @GetMapping("/posts")
    public String allPosts(Model model) {
        model.addAttribute("posts", postDao.findAll());

        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String onePost(@PathVariable long id,  Model model) {
        Post post = postDao.getReferenceById(id);
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String showCreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post) {
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();


        User user = userDao.getReferenceById(loggedInUser.getId());

        post.setUser(user);

        postDao.save(post);

        emailService.prepareAndSend(post, "Post Created", "Hello, your post has been created!");

        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String showEditForm(@PathVariable long id, Model model) {
        Post post = postDao.getReferenceById(id);
        model.addAttribute("post", post);

        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String editPost(@ModelAttribute Post post) {
        postDao.save(post);

        return "redirect:/posts";
    }

}
