package com.codeup.fenrircodeupspringblog.jpa_lectures.models;


import jakarta.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String employeName;

    @Column
    private String section;

    @ManyToOne
    @JoinColumn (name = "chef_id")
    private Chef boss;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
