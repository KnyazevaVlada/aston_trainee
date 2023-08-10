package com.vlknyazeva.hibernate.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "child", schema = "public", catalog = "jdbc_hw")
public class Child {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Basic
    @Column(name = "name", nullable = true, length = -1)
    private String name;
    @Basic
    @Column(name = "surname", nullable = true, length = -1)
    private String surname;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "child_section",
            joinColumns = {@JoinColumn(name = "child_id")},
            inverseJoinColumns = {@JoinColumn(name = "section_id")}
    )
    @ToString.Exclude
    private List<Section> sections = new ArrayList<>();
}
