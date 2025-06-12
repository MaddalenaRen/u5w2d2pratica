package it.epicode.u5w2d2pratica.dto;
import it.epicode.u5w2d2pratica.model.Autore;

import lombok.Data;

@Data
public class BlogDto {
    private String categoria;
    private String titolo;
    private String contenuto;
    private int tempoDiLettura;
    private Autore autore;

}
