package fr.univtln.bruno.samples.humains;

import fr.univtln.bruno.samples.entity.SimpleEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@DiscriminatorColumn(name="TYPE_ENTITE")
@DiscriminatorValue("ZOOKEEPER")
@Data

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ZooKeeper extends Personne implements SimpleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    @NotNull
    @Size(min = 2, max = 20)
    private String nom;


}
