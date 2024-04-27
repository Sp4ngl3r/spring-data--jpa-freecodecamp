package dev.spangler.elearningplatform.models.orders;

import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @EmbeddedId
    private OrderId id;

    // This can be used in other DAOs as well, hence eliminating code duplication
    @Embedded
    private Address address;

    private String orderInfo;

    private String orderDescription;
}
