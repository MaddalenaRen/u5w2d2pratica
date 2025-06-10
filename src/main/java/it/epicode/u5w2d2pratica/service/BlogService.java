package it.epicode.u5w2d2pratica.service;


import it.epicode.u5w2d2pratica.exception.BlogNotFoundException;
import it.epicode.u5w2d2pratica.model.Blog;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BlogService {
    private List<Blog> blogs = new ArrayList<>();

    public Blog saveBlog(Blog blog){
        blog.setId(new Random().nextInt(1,2000));
        blog.setCover("https://picsum.photos/200/300");
        blogs.add(blog);
        return blog;

    }

    public Blog getBlog(int id)throws BlogNotFoundException{
        return blogs.stream().filter(blog -> blog.getId() == id).findFirst().
                orElseThrow(()-> new BlogNotFoundException("Blog: " + id + " non trovato"));
    }

    public List<Blog> getAllBlog(){
        return blogs;
    }

    public Blog updateBlog(int id, Blog blog)throws BlogNotFoundException{
        Blog blogDaCercare = getBlog(id);
        blogDaCercare.setCategoria(blog.getCategoria());
        blogDaCercare.setTitolo(blog.getTitolo());
        blogDaCercare.setContenuto(blog.getContenuto());
        blogDaCercare.setCover(blog.getContenuto());
        blogDaCercare.setTempoDiLettura(blog.getTempoDiLettura());
        return blogDaCercare;
    }

    public void deleteBlog(int id)throws BlogNotFoundException{
        Blog blogDaRimuovere = getBlog(id);
        blogs.remove(blogDaRimuovere);
    }
}
