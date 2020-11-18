package fr.univtln.bruno.samples;

import fr.univtln.bruno.samples.animals.Aigle;
import fr.univtln.bruno.samples.animals.Animal;
import fr.univtln.bruno.samples.animals.Chien;
import fr.univtln.bruno.samples.animals.Vache;
import fr.univtln.bruno.samples.annotation.MyAnnotation;
import fr.univtln.bruno.samples.dao.AnimalDAO;
import fr.univtln.bruno.samples.dao.HumainDAO;
import fr.univtln.bruno.samples.dao.StructureDAO;
import fr.univtln.bruno.samples.humains.Personne;
import fr.univtln.bruno.samples.humains.ZooKeeper;
import fr.univtln.bruno.samples.maladies.Pathologie;
import fr.univtln.bruno.samples.structures.Zoo;



import javax.persistence.EntityTransaction;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import java.lang.annotation.Annotation;
import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static Properties properties = new Properties();

    static {
        properties.setProperty("test", "test");
    }



    public static void main( String[] args )
    {
        ///CREATE DATA///
        Pathologie pathos1 = Pathologie.builder().name("Cancer").build();
        Pathologie pathos2 = Pathologie.builder().name("Rage").build();
        List<Pathologie> maladie =new ArrayList<>();

        maladie.add(pathos1);
        maladie.add(pathos2);


        ZooKeeper zooKeeper1 = ZooKeeper.builder().nom("Jack").build();
        ZooKeeper zooKeeper2 = ZooKeeper.builder().nom("John").build();



        List<ZooKeeper> zooKeeperList = new ArrayList<>();
        zooKeeperList.add(zooKeeper1);zooKeeperList.add(zooKeeper2);

        Zoo zoo = Zoo.builder().name("Zoo Fauverie Du Mont Faron").ZOOKeeper(zooKeeperList).build();

        Animal animal = Animal.builder().name("Christophe").zoo(zoo).build();
        Animal animal1 = Animal.builder().name("Pierre").zoo(zoo).build();


        Aigle aigle = Aigle.builder().name("America").age(5).zoo(zoo).build();

        Chien chien = Chien.builder().name("Hector").age(7).Pathos(maladie).zoo(zoo).build();

        Vache vache = Vache.builder().name("Germaine").age(55).zoo(zoo).build();


        ///ANNOTATION///
        Class zooClass= zoo.getClass();
        MyAnnotation zooClassAnnotation = (MyAnnotation) zooClass.getAnnotation(MyAnnotation.class);
        System.out.println(zooClassAnnotation.name());

        Class animalClass= animal.getClass();
        MyAnnotation AnimalANnt = (MyAnnotation) animalClass.getAnnotation(MyAnnotation.class);
        System.out.println(AnimalANnt.name());

        ////VALIDATION////
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

        List<Animal> entities = new ArrayList<>();
        entities.add(aigle);entities.add(vache);
        entities.add(chien);entities.add(animal);
        entities.add(animal1);

        for (Animal a:entities) {
            Set<ConstraintViolation<Animal>> v = validator.validate(a);
            System.out.println(v);
        }

        List<Personne> entities2 = new ArrayList<>();
        entities2.add(zooKeeper1);entities2.add(zooKeeper2);

        for (Personne p:entities2) {
            Set<ConstraintViolation<Personne>> v = validator.validate(p);
            System.out.println(v);
        }


        ///DATABASE///
        try (HumainDAO humainDAO = HumainDAO.of()) {

            EntityTransaction transaction = humainDAO.getTransaction();

            transaction.begin();

            humainDAO.persist(zooKeeper1);
            humainDAO.persist(zooKeeper2);

            transaction.commit();

        }

        try (StructureDAO structureDAO = StructureDAO.of()) {

            EntityTransaction transaction = structureDAO.getTransaction();

            transaction.begin();

            structureDAO.persist(zoo);

            transaction.commit();

        }



        try (AnimalDAO animalDAO = AnimalDAO.of()) {

            EntityTransaction transaction = animalDAO.getTransaction();

            transaction.begin();

            animalDAO.persist(animal);
            animalDAO.persist(chien);
            animalDAO.persist(animal1);
            animalDAO.persist(vache);
            animalDAO.persist(aigle);
            transaction.commit();

        }

    }
}
