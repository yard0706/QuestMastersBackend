package ru.vrn.dreamteam.qm.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.vrn.dreamteam.qm.persistense.*;
import ru.vrn.dreamteam.qm.persistense.entity.*;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class MainController {
    @Autowired
    private FamilyRepository familyRepository;
    @Autowired
    private TavernRepository tavernRepository;
    @Autowired
    private QuestRepository questRepository;
    @Autowired
    private QuestMasterRepository qmRepository;
    @Autowired
    private HeroRepository heroRepository;

    @CrossOrigin
    @RequestMapping("/family/{id}/{questMasterId}")
    public Family getFamilyByMainQuestMaster(@PathVariable Long id, @PathVariable Long questMasterId) {
        Family family = familyRepository.findById(id).orElse(null);
        QuestMaster bossQuestMaster = qmRepository.findById(questMasterId).orElse(null);
        if (bossQuestMaster!=null && bossQuestMaster.getBoss())
            if (family!=null && family.getQuestMasters().contains(bossQuestMaster))
                return family;
            else System.out.println("no such quest master in this family");
        else System.out.println("no such quest master or QM not boss");
        return null;
    }

    @CrossOrigin
    @RequestMapping("/tavern/{familyid}")
    public Tavern getTavern(@PathVariable Long familyid) {
        List<Tavern> taverns = tavernRepository.findByFamilyId(familyid);
        if (taverns != null && !taverns.isEmpty())
            return tavernRepository.findByFamilyId(familyid).get(0);
        System.out.println("NO SUCH TAVERN");
        return null;
    }

    @CrossOrigin
    @PostMapping("/tavern/save")
    public Tavern saveHeroes(@RequestBody Tavern tavern) {
        return (Tavern) tavernRepository.save(tavern);
    }

    @CrossOrigin
    @RequestMapping("/qms/{familyid}")
    public List<QuestMaster> getQuestsMasters(@PathVariable Long familyid) {
        return qmRepository.findByFamilyId(familyid);
    }


    @CrossOrigin
    @PostMapping("/qms/save")
    public List<QuestMaster> saveQuestsMasters(@RequestBody List<QuestMaster> questMasters) {
        return (List<QuestMaster>) qmRepository.saveAll(questMasters);
    }


    @CrossOrigin
    @RequestMapping("/heroes/{familyid}")
    public List<Hero> getHeroes(@PathVariable Long familyid) {
        return heroRepository.findByFamilyId(familyid);
    }

    @CrossOrigin
    @PostMapping("/heroes/save")
    public List<Hero> saveHeroes(@RequestBody List<Hero> heroes) {
        return (List<Hero>) heroRepository.saveAll(heroes);
    }

    @CrossOrigin
    @PostMapping("/family/save")
    public Family saveFamily(@RequestBody Family family) {
        return familyRepository.save(family);
    }

    @CrossOrigin
    @PostMapping("/quests/save")
    public Quest saveQuest(@RequestBody Quest quest) {
        return questRepository.save(quest);
    }

    @CrossOrigin
    @RequestMapping("/quests/{familyid}")
    public List<Quest> getQuests(@PathVariable Long familyid) {
        return questRepository.findByFamilyId(familyid);
    }

    @CrossOrigin
    @RequestMapping("/quest/{id}")
    public Quest getQuest(@PathVariable Long id) {
        return questRepository.findById(id).orElse(new Quest());
    }

    @CrossOrigin
    @RequestMapping("/quest/delete/{id}")
    public void deleteQuest(@PathVariable Long id) {
        questRepository.deleteById(id);
    }

    @RequestMapping("/test")
    public String test() {

        QuestMaster questMaster = new QuestMaster("Vasya", "Batya");
        questMaster = qmRepository.save(questMaster);
        Set<QuestMaster> qms = new HashSet<>();
            qms.add(questMaster);
        Hero hero1 = new Hero("Masha");
        hero1 = heroRepository.save(hero1);
        Set<Hero> heroes = new HashSet<>();
            heroes.add(hero1);
        Family family = new Family("Our family");
        family.setHeroes(heroes);
        family.setQuestMasters(qms);


        Quest quest1 = new Quest("New very intresting task");
            quest1.setHero(hero1);
            quest1.setQuestMaster(questMaster);
            quest1.setStatus("IN_ACTION");
        quest1 = questRepository.save(quest1);

        Quest quest2 = new Quest("Another very intresting task");
            quest2.setQuestMaster(questMaster);
            quest2.setStatus("WAIT_FOR_HERO");
        quest2 = questRepository.save(quest2);

        Set<Quest> quests = new HashSet<>();
            quests.add(quest1);
            quests.add(quest2);
        Tavern tavern = new Tavern();
        tavern.setQuests(quests);
        tavern = tavernRepository.save(tavern);
        family.setTavern(tavern);


        System.out.println("Before family save");
        familyRepository.save(family);
        System.out.println("After family save");

        return "test text";
    }

    @RequestMapping("/test1")
    public String test1() {


        Family family = new Family("Our family");
        System.out.println("Before family save");
        familyRepository.save(family);
        System.out.println("After family save");
        QuestMaster questMaster = new QuestMaster("Vasya", "Batya");
        questMaster.setBoss(true);
        questMaster.setFamily(family);
        questMaster = qmRepository.save(questMaster);

        return "test text";
    }
}
