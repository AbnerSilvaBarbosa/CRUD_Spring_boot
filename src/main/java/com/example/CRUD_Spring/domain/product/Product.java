package com.example.CRUD_Spring.domain.product;

import com.example.CRUD_Spring.DTO.RequestProductDTO;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "product")
@Entity(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;
    private int price_in_cents;
    private boolean active;

    public Product(RequestProductDTO requestProductDTO){
        this.name = requestProductDTO.name();
        this.price_in_cents = requestProductDTO.price_in_cents();
    }
}
