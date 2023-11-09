package com.prady.shipping;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class ShippingData {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long shippingId;


        @NotNull
        @Column(unique=true)
        private Long orderId;

        private String emailId;

        private String address;

        private  ShippingStatus shippingStatus;
}
