package it.epicode.u5w2d2pratica.service;


import it.epicode.u5w2d2pratica.dto.BlogDto;
import it.epicode.u5w2d2pratica.exception.BlogNotFoundException;
import it.epicode.u5w2d2pratica.model.Blog;
import it.epicode.u5w2d2pratica.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private BlogService blogService;

    @Autowired
    private AutoreService autoreservice;

    public Blog saveBlog(BlogDto blogDto){
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

    public Blog updateBlog(int id, BlogDto blogDto)throws BlogNotFoundException{
        Blog blogDaCercare = getBlog(id);
        blogDaCercare.setCategoria(blogDto.getCategoria());
        blogDaCercare.setTitolo(blogDto.getTitolo());
        blogDaCercare.setContenuto(blogDto.getContenuto());
        blogDaCercare.setCover(blogDto.getContenuto());
        blogDaCercare.setTempoDiLettura(blogDto.getTempoDiLettura());
        return blogDaCercare;
    }

    public void deleteBlog(int id)throws BlogNotFoundException{
        Blog blogDaRimuovere = getBlog(id);
        blogRepository.delete(blogDaRimuovere);
    }
}
