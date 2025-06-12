package it.epicode.u5w2d2pratica.service;

import it.epicode.u5w2d2pratica.dto.AutoreDto;
import it.epicode.u5w2d2pratica.exception.AutoreNotFoundException;
import it.epicode.u5w2d2pratica.model.Autore;
import it.epicode.u5w2d2pratica.model.Blog;
import it.epicode.u5w2d2pratica.repository.AutoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AutoreService {
    @Autowired
    private AutoreRepository autoreRepository;

//    @Autowired
//    private BlogService blogService;

    public Autore saveAutore(AutoreDto autoreDto)throws AutoreNotFoundException{
//        Blog blog = blogService.getBlog(autoreDto.getBlogId());
        Autore autore = new Autore();
        autore.setAvatar("https://ui-avatars.com/api/?name=" + autore.getNome() + " + " + autore.getCognome());
        autore.setNome(autoreDto.getNome());
        autore.setCognome(autoreDto.getCognome());
        autore.setEmail(autoreDto.getEmail());
        autore.setDataDiNascita(autoreDto.getDataDiNascita());
        return autoreRepository.save(autore);

    }

    public Autore getAutore(int id)throws AutoreNotFoundException{
        return autoreRepository.findById(id).
                orElseThrow(() -> new AutoreNotFoundException("Autore: " + id + "non trovato"));
    }

    public Page<Autore> getAllAutori(int page, int size, String sortBy){
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return autoreRepository.findAll(pageable);

    }

    public Autore updateAutore(int id,AutoreDto autoreDto)throws AutoreNotFoundException{
        Autore autoreDaAggiornare = getAutore(id);
        autoreDaAggiornare.setNome(autoreDto.getNome());
        autoreDaAggiornare.setCognome(autoreDto.getCognome());
        autoreDaAggiornare.setEmail(autoreDto.getEmail());
        autoreDaAggiornare.setDataDiNascita(autoreDto.getDataDiNascita());
        autoreDaAggiornare.setAvatar("https://ui-avatars.com/api/?name=" + autoreDto.getNome() + "  " + autoreDto.getCognome());
//        if(autoreDaAggiornare.getId()!=autoreDto.getBlogId()){
//           Blog blog = blogService.getBlog(autoreDto.getBlogId());
//            autoreDaAggiornare.setBlogs(blog);
//        }

        return autoreRepository.save(autoreDaAggiornare);
    }


    }

    public void deleteAutore(int id)throws AutoreNotFoundException{
        Autore autoreDaRimuovere = getAutore(id);
        autoreRepository.dele

    }


}
