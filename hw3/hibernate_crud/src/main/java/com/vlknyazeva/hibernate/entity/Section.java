package com.vlknyazeva.hibernate.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "section", schema = "public", catalog = "jdbc_hw")
public class Section {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Basic
    @Column(name = "name", nullable = true, length = -1)
    private String name;

    @ManyToMany(mappedBy = "sections")
    @ToString.Exclude
    private Set<Child> children = new HashSet<>();
}
