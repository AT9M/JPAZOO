package fr.univtln.bruno.samples.structures;

import fr.univtln.bruno.samples.entity.SimpleEntity;
import fr.univtln.bruno.samples.humains.ZooKeeper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.persistence.annotations.CascadeOnDelete;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@DiscriminatorValue("CHIEN")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@CascadeOnDelete
public class Zoo implements SimpleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    @NotNull
    @Size(min = 3)
    private String name;


    @OneToMany
    private List<ZooKeeper> ZOOKeeper;

}
