package ru.vrn.dreamteam.qm.persistense.entity;

import jakarta.persistence.*;

@Entity
public class Quest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private Integer cost = 0;
    private Integer diamonds = 0;
    private String status = "NEW";
    @ManyToOne
    private Tavern tavern;
    @OneToOne
    private QuestMaster questMaster;
    @OneToOne
    private Hero hero;
    @ManyToOne
    private Family family;

    public Quest(String title) {
        this.title = title;
    }

    public Quest() {
    }

    @Override
    public String toString() {
        return "Quest{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                ", diamonds=" + diamonds +
                ", status='" + status + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getDiamonds() {
        return diamonds;
    }

    public void setDiamonds(Integer diamonds) {
        this.diamonds = diamonds;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public QuestMaster getQuestMaster() {
        return questMaster;
    }

    public void setQuestMaster(QuestMaster questMaster) {
        this.questMaster = questMaster;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public Tavern getTavern() {
        return tavern;
    }

    public void setTavern(Tavern tavern) {
        this.tavern = tavern;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }
}
