package ru.vrn.dreamteam.qm.persistense;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.vrn.dreamteam.qm.persistense.entity.Family;
@Repository
public interface FamilyRepository extends CrudRepository<Family, Long> {
}
