package ru.vrn.dreamteam.qm.persistense;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.vrn.dreamteam.qm.persistense.entity.Hero;
import ru.vrn.dreamteam.qm.persistense.entity.QuestMaster;

import java.util.List;

@Repository
public interface HeroRepository extends CrudRepository<Hero, Long> {
    public List<Hero> findByFamilyId(Long id);
}
