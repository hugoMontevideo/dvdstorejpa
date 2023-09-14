package com.simplon.dvdstore.repositories;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
//@NoArgsConstructor
@AllArgsConstructor
@Table(name="dvdstore")
public class DvdRepositoryModel {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="genre")
    private String genre;

    public DvdRepositoryModel(){};

    public DvdRepositoryModel(String name, String genre) {
        this.name = name;
        this.genre = genre;
    }


    @Override
    public String toString() {
        return "DvdRepositoryModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
