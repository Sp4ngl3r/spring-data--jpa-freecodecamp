package dev.spangler.elearningplatform.repository;

import dev.spangler.elearningplatform.models.Author;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long>, JpaSpecificationExecutor<Author> {

    // SELECT * FROM authors WHERE first_name = "..." and last_name = "...";
    List<Author> findAllByFirstNameAndLastName(String firstName, String lastName);

    // SELECT * FROM authors WHERE first_name = "...";
    List<Author> findAllByFirstNameIgnoreCase(String firstName);

    // SELECT * FROM authors WHERE first_name like "%...%";
    List<Author> findAllByFirstNameContainingIgnoreCase(String firstName);

    // SELECT * FROM authors WHERE first_name like "...%";
    List<Author> findAllByFirstNameStartingWithIgnoreCase(String firstName);

    // SELECT * FROM authors WHERE first_name like "%...";
    List<Author> findAllByFirstNameEndingWithIgnoreCase(String firstName);

    // SELECT * FROM authors WHERE first_name in ('...', '...', '...');
    List<Author> findAllByFirstNameInIgnoreCase(List<String> firstNames);

    @Modifying
    @Transactional
    @Query("UPDATE Author a set a.age=:age where a.id=:id")
    void updateAge(@Param("id") Long id, @Param("age") Integer age);

    @Modifying
    @Transactional
    @Query("UPDATE Author a set a.age=:age")
    void updateAllAuthorsAge(@Param("age") Integer age);

    @Transactional
    List<Author> findByAgeGreaterThanNamedQuery(@Param("age") int age);

    @Transactional
    @Modifying
    void updateAllAgeNamedQuery(@Param("age") int age);
}
