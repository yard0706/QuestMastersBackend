package ru.vrn.dreamteam.qm.persistense.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
public class Family {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "family")
    private Set<Hero> heroes;
    @JsonIgnore
    @OneToMany(mappedBy = "family")
    private Set<QuestMaster> questMasters;

    @JsonIgnore
    @OneToMany(mappedBy = "family")
    private List<Quest> quests;

    @JsonIgnore
    @OneToOne(mappedBy = "family")
    private Tavern tavern;
    private String description;

    public Family(String name) {
        this.name = name;
    }

    public Family() {
    }

    @Override
    public String toString() {
        return "Family{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", heroes=" + heroes +
                ", questMasters=" + questMasters +
                ", tavern=" + tavern +
                ", description='" + description + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Hero> getHeroes() {
        return heroes;
    }

    public void setHeroes(Set<Hero> heroes) {
        this.heroes = heroes;
    }

    public Set<QuestMaster> getQuestMasters() {
        return questMasters;
    }

    public void setQuestMasters(Set<QuestMaster> questMasters) {
        this.questMasters = questMasters;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Tavern getTavern() {
        return tavern;
    }

    public void setTavern(Tavern tavern) {
        this.tavern = tavern;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Quest> getQuests() {
        return quests;
    }

    public void setQuests(List<Quest> quests) {
        this.quests = quests;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Family family)) return false;
        return Objects.equals(getId(), family.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
