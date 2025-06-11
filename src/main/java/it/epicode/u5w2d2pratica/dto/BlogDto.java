package it.epicode.u5w2d2pratica.dto;

import it.epicode.u5w2d2pratica.model.Autore;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class BlogDto {
    private String categoria;
    private String titolo;
    private String cover;
    private int tempoDiLettura;
    private Autore autore;

}
