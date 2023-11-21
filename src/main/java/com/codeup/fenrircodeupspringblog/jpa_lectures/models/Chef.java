package com.codeup.fenrircodeupspringblog.jpa_lectures.models;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Chef {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String name;

    @OneToMany (cascade = CascadeType.ALL, mappedBy = "boss")
    private List<Employee> staff;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
