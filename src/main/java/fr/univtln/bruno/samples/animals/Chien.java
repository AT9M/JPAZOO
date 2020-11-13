package fr.univtln.bruno.samples.animals;

import fr.univtln.bruno.samples.maladies.Pathologie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.eclipse.persistence.annotations.CascadeOnDelete;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@DiscriminatorValue("CHIEN")
@Data
@NoArgsConstructor
@AllArgsConstructor
@CascadeOnDelete

@NamedQuery(name="chien.DELETE", query = "SELECT chien FROM  Chien chien  where chien.name=:name")
@SuperBuilder
public class Chien extends Animal {
    @Min(1)
    @Max(18)
    private int age;


    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Pathologie> Pathos;



    public static void DELETE(String name){
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("test");
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("chien.DELETE");
        query.setParameter("name",name);
        List<Chien> CHIEN = (List<Chien>) query.getResultList();
        for (Chien chien:CHIEN) { em.remove(chien); }
    }

}
