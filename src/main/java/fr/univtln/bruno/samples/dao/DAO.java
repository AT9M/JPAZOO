package fr.univtln.bruno.samples.dao;

import fr.univtln.bruno.samples.animals.Animal;
import fr.univtln.bruno.samples.entity.SimpleEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public interface DAO<T extends SimpleEntity> extends AutoCloseable {

    EntityManager getEntityManager();

    default void persist(T E) {
        getEntityManager().persist(E);
    }

    default T merge(T animal) {
        return getEntityManager().merge(animal);
    }

    default void refresh(T animal) {
        getEntityManager().refresh(animal);
    }

    default void clear() {
        getEntityManager().clear();
    }

    default Animal find(long id) {
        return getEntityManager().find(Animal.class, id);
    }

    @Override
    default void close() {
        getEntityManager().close();
    }

    default void flush() {
        getEntityManager().flush();
    }

    default EntityTransaction getTransaction() {
        return getEntityManager().getTransaction();
    }


}