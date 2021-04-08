package com.ul.api.repository.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class ProjectStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String status;
    @Column(name = "DATE_CREATED")
    private LocalDateTime dateCreated;
    @Column(name = "ARCHIVED")
    private Boolean archived;

    public ProjectStatus() {
    }

}
