package it.epicode.u5w2d2pratica.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AutoreDto {
    @NotEmpty(message = "il nome non può essere nullo o vuoto")
    private String nome;
    @NotEmpty(message = "il cognome non può essere nullo o vuoto")
    private String cognome;
    @NotEmpty(message = "l'email non può essere nullo o vuoto")
    private String email;
    @NotNull(message = "la data di nascita non può essere nulla")
    private LocalDate dataDiNascita;
}
