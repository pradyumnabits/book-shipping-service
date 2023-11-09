package com.prady.shipping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Slf4j
@Component
public class OrderCreationConsumer {


    @Autowired
    private ShippingRepository shippingRepository;
     @Bean
     public Consumer<ShippingData> onOrderCreation() {
         return (shippingData) -> {
           log.info("Received the value {} in OrderCreationConsumer", shippingData);
             shippingData.setShippingStatus(ShippingStatus.SHIPPING_INITIATED);
             shippingRepository.save(shippingData);
         };
     }
}