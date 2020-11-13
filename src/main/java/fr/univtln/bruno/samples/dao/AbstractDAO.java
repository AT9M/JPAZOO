package fr.univtln.bruno.samples.dao;

import fr.univtln.bruno.samples.App;
import fr.univtln.bruno.samples.entity.SimpleEntity;
import lombok.Getter;


import javax.persistence.EntityManager;
import javax.persistence.Persistence;
@Getter
public abstract class  AbstractDAO<T extends SimpleEntity> implements DAO<T>{
    private EntityManager entityManager = Persistence
                                          .createEntityManagerFactory(App.properties.getProperty("test")).createEntityManager();

}
