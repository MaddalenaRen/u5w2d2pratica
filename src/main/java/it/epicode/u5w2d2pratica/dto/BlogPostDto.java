package it.epicode.u5w2d3pratica.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BlogPostDto {
    @NotEmpty(message = "la categoria non può essere nulla o vuota")
    private String categoria;
    @NotEmpty(message = "il titolo non può essere nullo o vuoto")
    private String titolo;
    @NotEmpty(message = "il contenuto non può essere nullo o vuoto")
    private String contenuto;
    @NotNull(message = "il tempo di lettura non può essere null0")
    private int tempoDiLettura;
    @NotNull(message = "l'id dell'autorie non può essere nullo")
    private int autoreId;
}
