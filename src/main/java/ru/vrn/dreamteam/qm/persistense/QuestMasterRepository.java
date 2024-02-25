package ru.vrn.dreamteam.qm.persistense;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.vrn.dreamteam.qm.persistense.entity.QuestMaster;

import java.util.List;

@Repository
public interface QuestMasterRepository extends CrudRepository<QuestMaster, Long> {
    public List<QuestMaster> findByFamilyId(Long id);
}
