package fr.univtln.bruno.samples.animals;


import fr.univtln.bruno.samples.maladies.Pathologie;
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
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@DiscriminatorValue("VACHE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@CascadeOnDelete
@SuperBuilder
public class Vache extends Animal{

    @Min(1)
    @Max(1000)
    private int age;



    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Pathologie> Pathos;

}
