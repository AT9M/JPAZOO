package fr.univtln.bruno.samples.maladies;

import fr.univtln.bruno.samples.annotation.MyAnnotation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@DiscriminatorValue("PATHOLOGIE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@MyAnnotation(name = "Pathologies")
@Builder
public class Pathologie{
    @Size(min = 2, max = 100)
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
}
