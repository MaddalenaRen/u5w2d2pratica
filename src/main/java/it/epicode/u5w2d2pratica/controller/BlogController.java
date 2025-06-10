package it.epicode.u5w2d2pratica.controller;

import it.epicode.u5w2d2pratica.exception.BlogNotFoundException;
import it.epicode.u5w2d2pratica.model.Blog;
import it.epicode.u5w2d2pratica.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class BlogController {
    @Autowired
    private BlogService blogService;

    @PostMapping("/blogs")
    @ResponseStatus(HttpStatus.CREATED)
    public Blog saveBlog(@RequestBody Blog blog){
        return blogService.saveBlog(blog);

    }

    @GetMapping("/blogs/{id}")
    public Blog getId (@PathVariable int id)throws BlogNotFoundException {
        return blogService.getBlog(id);
    }

    @GetMapping("/blogs")
    public List<Blog> getAllBlog(){
        return blogService.getAllBlog();
    }

    @PutMapping("/blogs/{id}")
    public Blog updateBlog(@PathVariable int id, Blog blog)throws BlogNotFoundException{
        return blogService.updateBlog(id,blog);
    }

    @DeleteMapping("/blogs/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBlog(@PathVariable int id)throws BlogNotFoundException{
        blogService.deleteBlog(id);

    }






}
