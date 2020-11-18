package fr.univtln.bruno.samples.animals;

import fr.univtln.bruno.samples.entity.SimpleEntity;
import fr.univtln.bruno.samples.maladies.Pathologie;
import fr.univtln.bruno.samples.annotation.MyAnnotation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.eclipse.persistence.annotations.CascadeOnDelete;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Entity
@DiscriminatorValue("AIGLE")
@Data
@CascadeOnDelete
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@MyAnnotation(name = "Aigle")
public class Aigle extends Animal implements SimpleEntity {

    @Min(1)
    @Max(30)
    private int age;


    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Pathologie> Pathos;


}
