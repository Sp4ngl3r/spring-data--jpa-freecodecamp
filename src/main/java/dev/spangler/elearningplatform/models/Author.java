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
@NamedQueries({
        @NamedQuery(
                name = "Author.findByAgeGreaterThanNamedQuery",
                query = "select a from Author a where a.age >= :age"
        ),
        @NamedQuery(
                name = "Author.updateAllAgeNamedQuery",
                query = "update Author a set a.age = :age"
        )
})
@Table(name = "authors")
public class Author extends BaseEntity {
    // The primary keys are always defined with Wrapper classes because default value of Wrapper class is null
    // which is needed for Data Persistence libraries to create new record.

//    Defining Primary key auto generation strategy using SEQUENCE
//
//    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "author_sequence")
//    @SequenceGenerator(name = "author_sequence", sequenceName = "author_sequence", allocationSize = 1)

//    Defining Primary key auto generation strategy using TABLE
//
//    @GeneratedValue(strategy = GenerationType.TABLE,generator = "author_table_sequence")
//    @TableGenerator(
//            name = "author_table_sequence",
//            table = "author_id_sequence_generator",
//            pkColumnName = "id_name",
//            valueColumnName = "id_value",
//            allocationSize = 3
//    )

    private String firstName;

    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    private int age;

    // This is the inverse owner of the relationship
    @ManyToMany(mappedBy = "authors", fetch = FetchType.EAGER)
    private List<Course> courses;
}
