package it.epicode.u5w2d2pratica.controller;

import it.epicode.u5w2d2pratica.exception.AutoreNotFoundException;
import it.epicode.u5w2d2pratica.model.Autore;
import it.epicode.u5w2d2pratica.service.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AutoreController {

    @Autowired
    private AutoreService autoreService;

    @PostMapping("/autori")
    @ResponseStatus(HttpStatus.CREATED)
    public Autore saveautore(@RequestBody Autore autore){

        return autoreService.saveAutore(autore);

    }
    @GetMapping("/autori/{id}")
    public Autore getAutore(@PathVariable int id)throws AutoreNotFoundException {

        return autoreService.getAutore(id);
    }

    @GetMapping("/autori")
    public List<Autore> getAllAutori(){
        return autoreService.getAllAutori();
    }

    @PutMapping("/autore/{id}")
    public Autore updateAutore(@PathVariable int id, @RequestBody Autore autore)throws AutoreNotFoundException{
        return autoreService.updateAutore(id, autore);
    }


    @DeleteMapping("/autori/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAutore(@PathVariable int id)throws AutoreNotFoundException{
        autoreService.deleteAutore(id);
    }

}
