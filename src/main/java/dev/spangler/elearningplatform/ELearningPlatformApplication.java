package dev.spangler.elearningplatform;

import dev.spangler.elearningplatform.models.Author;
import dev.spangler.elearningplatform.models.resource.Video;
import dev.spangler.elearningplatform.repository.AuthorRepository;
import dev.spangler.elearningplatform.repository.resource.VideoRepository;
import dev.spangler.elearningplatform.specification.AuthorSpecification;
import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;

@SpringBootApplication
public class ELearningPlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(ELearningPlatformApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(
            AuthorRepository authorRepository,
            VideoRepository videoRepository

    ) {
        return args -> {

            Faker faker = new Faker();

            for (int i = 0; i < 50; i++) {

                Author author = Author
                        .builder()
                        .firstName(faker.name().firstName())
                        .lastName(faker.name().lastName())
                        .email(faker.name().name() + "@email.com")
                        .age(faker.number().numberBetween(18, 50))
                        .createdAt(LocalDateTime.now())
                        .build();

//                authorRepository.save(author);

                Video video = Video
                        .builder()
                        .name(faker.name().name())
                        .length(faker.number().randomDigitNotZero())
                        .createdAt(LocalDateTime.now())
                        .build();

//                videoRepository.save(video);
            }

            // Update with Author id with 36
            Author authorToBeUpdated = Author
                    .builder()
                    .id(36L)
                    .firstName("Rock")
                    .lastName("Paper")
                    .age(12)
                    .email("rock@email.com")
                    .createdAt(LocalDateTime.now().plusMonths(3))
                    .build();
//            authorRepository.save(authorToBeUpdated);

            // Update Author age using id
//            authorRepository.updateAge(21L, 13);

            // Set all authors age to 13
//            authorRepository.updateAllAuthorsAge(13);

            // Print out all the Authors with age more than 10
//            authorRepository
//                    .findByAgeGreaterThanNamedQuery(40)
//                    .forEach(System.out::println);

//            authorRepository.updateAllAgeNamedQuery(13);

            Specification<Author> authorSpecification1 = Specification
                    .where(AuthorSpecification.isAge(33))
                    .and(AuthorSpecification.isFirstName("Alva"))
                    .or(AuthorSpecification.isLastName("Roob"));

            Specification<Author> authorSpecification2 = Specification
                    .where(AuthorSpecification.inFirstName("let"))
                    .or(AuthorSpecification.inLastName("int"));

            authorRepository
                    .findAll(authorSpecification1)
                    .forEach(System.out::println);

            authorRepository
                    .findAll(authorSpecification2)
                    .forEach(System.out::println);


        };
    }
}
