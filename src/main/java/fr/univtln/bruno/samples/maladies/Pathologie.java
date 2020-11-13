package fr.univtln.bruno.samples.maladies;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.persistence.annotations.CascadeOnDelete;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@DiscriminatorValue("PATHOLOGIE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pathologie{
    @Size(min = 5, max = 100)
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
}
