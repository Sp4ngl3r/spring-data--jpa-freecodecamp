package dev.spangler.elearningplatform.models.resource;

import dev.spangler.elearningplatform.models.BaseEntity;
import dev.spangler.elearningplatform.models.Lecture;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "resource_type")

//@Inheritance(strategy = InheritanceType.JOINED)

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "resources")
public class Resource extends BaseEntity {

    private String name;

    private int size;

    private String url;

    // This is a bidirectional relation
    @OneToOne
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;
}


