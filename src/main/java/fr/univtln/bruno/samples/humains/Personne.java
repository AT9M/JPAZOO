package fr.univtln.bruno.samples.humains;

import fr.univtln.bruno.samples.entity.SimpleEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.eclipse.persistence.annotations.CascadeOnDelete;

import javax.persistence.*;

@Entity
//@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="TYPE_ENTITE")
@DiscriminatorValue("PERSONNE")
@Data
@CascadeOnDelete
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Personne implements SimpleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

}
