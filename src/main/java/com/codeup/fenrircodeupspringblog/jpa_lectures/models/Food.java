package com.codeup.fenrircodeupspringblog.jpa_lectures.models;

import jakarta.persistence.*;

@Entity
@Table(name = "foods")
public class Food {

    //Step one to identify it as a "table" is to use the @Entity annotation above the class signature

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(length = 50)
    private String type;

    @Column
    private int calories;

    @OneToOne
    private Chef owner;

    public Food() {
    }

    public Food(Long id, String name, String type, int calories) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.calories = calories;
    }

    public Food(String name, String type, int calories) {
        this.name = name;
        this.type = type;
        this.calories = calories;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
}
