package dev.spangler.elearningplatform.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "courses")
public class Course extends BaseEntity {
    
    private String name;

    private String description;

    // This is the owner of the relation
    @ManyToMany
    @JoinTable(
            name = "courses_authors",
            // define owner's primary key below
            joinColumns = {@JoinColumn(name = "course_id")},
            // define inverse owner's primary key below
            inverseJoinColumns = {@JoinColumn(name = "author_id")}
    )
    private List<Author> authors;

    // This is the owner of the relation
    @OneToMany(mappedBy = "course")
    private List<Section> sections;
}
