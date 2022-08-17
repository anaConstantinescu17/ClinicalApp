package com.clinic.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;
@Entity
@NoArgsConstructor
@Getter
@Setter

@EqualsAndHashCode
@Table(name = "department")
public class Department {
    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    public String description;

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY, orphanRemoval = true)
    public List<Doctor> doctors;

    @Override
    public String toString() {
        return "Department{" +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", doctors=" + doctors +
                '}';
    }
}
