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
@Table(name = "sections")
public class Section extends BaseEntity {

    private String name;

    private int sectionOrder;

    // This is the inverse-owner of the relation
    @ManyToOne
    @JoinColumn(name = "courses_id")
    private Course course;

    // This is the owner of the relation
    @OneToMany(mappedBy = "section")
    private List<Lecture> lectures;
}
