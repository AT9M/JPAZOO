package fr.univtln.bruno.samples.animals;


import fr.univtln.bruno.samples.entity.SimpleEntity;
import fr.univtln.bruno.samples.structures.Zoo;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.eclipse.persistence.annotations.CascadeOnDelete;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
//@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name="TYPE_ENTITE")
@DiscriminatorValue("ANIMAL")
@Data
@CascadeOnDelete
@NoArgsConstructor
@AllArgsConstructor


@NamedQueries({
        @NamedQuery(name="animal.AllAninmal", query = "select animal from Animal animal"),
        @NamedQuery(name = "animal.FindAnimal",query = "select animal from Animal animal where animal.id=:id"),
        @NamedQuery(name = "animal.Findbyzoo",query = "select animal from Animal animal where animal.zoo=:zoo")
})

@SuperBuilder
public class Animal implements SimpleEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    @Size(min = 5, max = 100)
    private String name;


    @ManyToOne
    private Zoo zoo;

    //////////////////////////////////////////////////

    public Zoo getManyToOne() {
        return zoo;
    }

    public void setManyToOne(Zoo manyToOne) {
        this.zoo = manyToOne;
    }

    public static Animal FindAnimal(long id){
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("test");
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("animal.FindAnimal");
        query.setParameter("id",id);
        return (Animal) query.getSingleResult();
    }

    public static List FindAnimalInzoo(Zoo zoo){
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("test");
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("animal.Findbyzoo");
        query.setParameter("zoo",zoo);
        return  query.getResultList();
    }

}
