package com.prady.shipping;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShippingRepository extends JpaRepository<ShippingData, Long> {
    ShippingData findByOrderId(Long orderId);

    List<ShippingData> findByShippingStatus(ShippingStatus shippingStatus);

}
