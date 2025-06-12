package it.epicode.u5w2d2pratica.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
public class BlogPost {
    @Id
    @GeneratedValue
    private int id;
    private String categoria;
    private String titolo;
    private String cover;
    private String contenuto;
    private int tempoDiLettura;

    @ManyToOne
    @JoinColumn(name = "autore_id")
    private Autore autore;
}
