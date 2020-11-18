package fr.univtln.bruno.samples.dao;

import fr.univtln.bruno.samples.animals.Animal;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor(staticName = "of")
public class AnimalDAO extends AbstractDAO<Animal> {
    public List<Animal> findByName(String name) {
        return getEntityManager().createNamedQuery("animal.AllAninmal")
                .getResultList();
    }

    @Override
    public Class<Animal> getmytype() {
        return Animal.class;
    }
}
