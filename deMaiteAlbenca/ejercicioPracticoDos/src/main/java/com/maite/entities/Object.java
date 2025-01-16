package com.maite.entities;

import jakarta.persistence.*;
//Entidad y parametros
@Entity
public class Object {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    private String name;
    //constructor
    public Object() {
    }
    //getters and setters
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //otros metodos

    //to string
    
}
