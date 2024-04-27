package dev.spangler.elearningplatform.models.resource;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

//@DiscriminatorValue(value = "VIDEO")

//@PrimaryKeyJoinColumn(name = "video_id")
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Video extends Resource {

    private int length;
}
