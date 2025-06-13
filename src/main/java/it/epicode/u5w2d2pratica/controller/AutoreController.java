package it.epicode.u5w2d2pratica.controller;


import it.epicode.u5w2d2pratica.dto.AutoreDto;
import it.epicode.u5w2d2pratica.exception.NonTrovatoException;
import it.epicode.u5w2d2pratica.exception.ValidationException;
import it.epicode.u5w2d2pratica.model.Autore;
import it.epicode.u5w2d2pratica.service.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/autori")
public class AutoreController {

    @Autowired
    private AutoreService autoreService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Autore saveAutore(@RequestBody @Validated AutoreDto autoreDto, BindingResult bindingResult)
            throws NonTrovatoException, ValidationException {

        if(bindingResult.hasErrors()){
            throw new ValidationException(bindingResult.getAllErrors().stream().
                    map(objectError ->objectError.getDefaultMessage()).
                    reduce("",(e,s)->e+s));
        }

        return autoreService.saveAutore(autoreDto);
    }

    @GetMapping("")
    public Page<Autore> getAutori(@RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "10") int size,
                                  @RequestParam(defaultValue = "id") String sortBy){

        return autoreService.getAutori(page, size, sortBy);
    }

    @GetMapping("/{id}")
    public Autore getAutore(@PathVariable int id) throws NonTrovatoException {
        return autoreService.getAutore(id);
    }
    @PutMapping("/{id}")
    public Autore updateAutore(@PathVariable int id,@RequestBody @Validated  AutoreDto autoreDto, BindingResult bindingResult) throws NonTrovatoException, ValidationException {
        if(bindingResult.hasErrors()){
            throw new ValidationException(bindingResult.getAllErrors().stream().
                    map(objectError ->objectError.getDefaultMessage()).
                    reduce("",(e,s)->e+s));
        }
        return autoreService.updateAutore(id, autoreDto);
    }

    @DeleteMapping("/{id}")
    public void deleteAutore(@PathVariable int id) throws NonTrovatoException {
        autoreService.deleteAutore(id);
    }

    @PatchMapping("/{id}")
    public String patchAutore(@PathVariable int id,@RequestBody MultipartFile file) throws NonTrovatoException, IOException {
        return autoreService.patchAutore(id, file);


    }
}