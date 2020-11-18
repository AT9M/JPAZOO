package fr.univtln.bruno.samples.dao;

import fr.univtln.bruno.samples.animals.Animal;
import fr.univtln.bruno.samples.humains.Personne;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.EntityTransaction;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor(staticName = "of")
public class HumainDAO extends AbstractDAO<Personne>{


    @Override
    public Class<Personne> getmytype() {
        return Personne.class;
    }
}
