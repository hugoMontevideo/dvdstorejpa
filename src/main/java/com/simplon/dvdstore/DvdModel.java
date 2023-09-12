package com.simplon.dvdstore;

import jakarta.persistence.*;
import lombok.*;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="dvdstore")
public class DvdModel {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="genre")
    private String genre;

    public DvdModel(String name, String genre) {
        this.name = name;
        this.genre = genre;
    }
}
