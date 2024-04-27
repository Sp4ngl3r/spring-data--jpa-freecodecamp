package dev.spangler.elearningplatform.specification;

import dev.spangler.elearningplatform.models.Author;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class AuthorSpecification {

    public static Specification<Author> isAge(int age) {

        return (Root<Author> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) -> {
            if (age < 0) {
                return null;
            }

            return criteriaBuilder.equal(root.get("age"), age);
        };

    }

    public static Specification<Author> isFirstName(String firstName) {

        return (Root<Author> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) -> {

            if (firstName == null) {
                return null;
            }

            return criteriaBuilder.equal(root.get("firstName"), firstName);
        };
    }

    public static Specification<Author> isLastName(String lastName) {

        return (Root<Author> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) -> {

            if (lastName == null) {
                return null;
            }

            return criteriaBuilder.equal(root.get("lastName"), lastName);
        };
    }

    public static Specification<Author> inFirstName(String firstName) {

        return (Root<Author> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) -> {

            if (firstName == null) {
                return null;
            }

            return criteriaBuilder.like(root.get("firstName"), "%" + firstName + "%");
        };
    }

    public static Specification<Author> inLastName(String lastName) {

        return (Root<Author> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) -> {

            if (lastName == null) {
                return null;
            }

            return criteriaBuilder.like(root.get("lastName"), "%" + lastName + "%");
        };
    }
}
