package dev.spangler.elearningplatform.models;

import dev.spangler.elearningplatform.models.resource.Resource;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "lectures")
public class Lecture extends BaseEntity {

    private String name;

    // This is the inverse-owner of the relation
    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;

    // This is a bidirectional relation
    @OneToOne
    @JoinColumn(name = "resource_id")
    private Resource resource;
}
