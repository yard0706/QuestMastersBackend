package ru.vrn.dreamteam.qm.persistense.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class QuestMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private String familyMemberKind;
    private Integer treasury;
    private Boolean boss;
    @ManyToOne
    private Family family;
    @JsonIgnore
    @OneToMany(mappedBy = "questMaster")
    private List<Quest> quests;

    public QuestMaster(String name, String familyMemberKind) {
        this.name = name;
        this.familyMemberKind = familyMemberKind;
    }

    public QuestMaster() {
    }

    @Override
    public String toString() {
        return "QuestMaster{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", familyMemberKind='" + familyMemberKind + '\'' +
                ", treasury=" + treasury +
                ", boss=" + boss +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFamilyMemberKind() {
        return familyMemberKind;
    }

    public void setFamilyMemberKind(String familyMemberKind) {
        this.familyMemberKind = familyMemberKind;
    }

    public Integer getTreasury() {
        return treasury;
    }

    public void setTreasury(Integer treasury) {
        this.treasury = treasury;
    }

    public Boolean getBoss() {
        return boss;
    }

    public void setBoss(Boolean boss) {
        this.boss = boss;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QuestMaster that)) return false;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public List<Quest> getQuests() {
        return quests;
    }

    public void setQuests(List<Quest> quests) {
        this.quests = quests;
    }
}
