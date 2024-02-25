package ru.vrn.dreamteam.qm.persistense;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.vrn.dreamteam.qm.persistense.entity.Tavern;

import java.util.List;

@Repository
public interface TavernRepository extends CrudRepository<Tavern, Long> {
    public List<Tavern> findByFamilyId(Long id);
}
