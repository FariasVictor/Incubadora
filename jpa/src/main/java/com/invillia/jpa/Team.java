package com.invillia.jpa;

import javax.persistence.*;
import java.util.List;
import java.util.StringJoiner;

@Entity
@Table(name = "team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name",nullable=false,length=255)
    private String name;

    //@OneToMany(mappedBy = "team")
    //private List<com.invillia.jpa.Member> member;

    public Team(){
    }

    public Team(String name){
        this.name=name;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", "com.invillia.jpa.Team(", ")")
                .add("id=" + id)
                .add("name=" + name)
                .toString();
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
}
