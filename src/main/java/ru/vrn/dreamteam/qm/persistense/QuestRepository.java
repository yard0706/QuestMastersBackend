package ru.vrn.dreamteam.qm.persistense;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.vrn.dreamteam.qm.persistense.entity.Quest;

import java.util.List;

@Repository
public interface QuestRepository extends CrudRepository<Quest, Long> {
    public List<Quest> findByFamilyId(Long id);
}
