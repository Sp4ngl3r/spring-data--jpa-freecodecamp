package dev.spangler.elearningplatform.repository.resource;

import dev.spangler.elearningplatform.models.resource.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Long> {
}
