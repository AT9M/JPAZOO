package fr.univtln.bruno.samples.dao;

import fr.univtln.bruno.samples.structures.Zoo;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor(staticName = "of")
public class StructureDAO extends AbstractDAO<Zoo> {
    @Override
    public Class<Zoo> getmytype() {
        return Zoo.class;
    }
}
