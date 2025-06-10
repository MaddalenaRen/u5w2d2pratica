package it.epicode.u5w2d2pratica.service;

import it.epicode.u5w2d2pratica.exception.AutoreNotFoundException;
import it.epicode.u5w2d2pratica.model.Autore;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AutoreService {
    private List<Autore> autori = new ArrayList<>();

    public Autore saveAutore(Autore autore){
        autore.setId(new Random().nextInt(1,2000));
        autore.setAvatar("https://ui-avatars.com/api/?name=" + autore.getNome() + " + " + autore.getCognome());
        autori.add(autore);
        return autore;

    }

    public Autore getAutore(int id)throws AutoreNotFoundException{
        return autori.stream().filter(autore -> autore.getId() == id).findFirst().
                 orElseThrow(() -> new AutoreNotFoundException("Autore: " + id + "non trovato"));
    }

    public List<Autore> getAllAutori(){
        return autori;
    }

    public Autore updateAutore(int id,Autore autore)throws AutoreNotFoundException{
        Autore autoreDaCercare = getAutore(id);
        autoreDaCercare.setNome(autore.getNome());
        autoreDaCercare.setCognome(autore.getCognome());
        autoreDaCercare.setEmail(autore.getEmail());
        autoreDaCercare.setDataDiNascita(autore.getDataDiNascita());
        autoreDaCercare.setAvatar("https://ui-avatars.com/api/?name=" + autore.getNome() + " + " + autore.getCognome());
        return autoreDaCercare;
    }

    public void deleteAutore(int id)throws AutoreNotFoundException{
        Autore autoreDaRimuovere = getAutore(id);
        autori.remove(autoreDaRimuovere);

    }


}
