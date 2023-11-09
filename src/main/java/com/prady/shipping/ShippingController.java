package com.prady.shipping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class ShippingController {

   @Autowired
   private ShippingRepository shippingRepository;

    @PostMapping("/shipping")
    ShippingData initiateShipping(@RequestBody  ShippingData shippingData ) {
        shippingData.setShippingStatus(ShippingStatus.SHIPPING_INITIATED);
        return shippingRepository.save(shippingData);
    }

    @GetMapping( "/shipping/{orderId}")
    ShippingData getShippingData(@PathVariable("orderId") Long orderId){
        return shippingRepository.findByOrderId(orderId);
    }

    // Schedule a task to update the status to SHIPPING_COMPLETED after 5 seconds
    @Scheduled(fixedDelay = 20000) // 5000 milliseconds (5 seconds)
    public void completeShipping() {
        // Retrieve a shipping entry to update (you can use a specific ID or criteria)
        List<ShippingData> shippingDataList = shippingRepository.findByShippingStatus(ShippingStatus.SHIPPING_INITIATED);
        for (ShippingData shippingDataToUpdate: shippingDataList) {
                shippingDataToUpdate.setShippingStatus(ShippingStatus.SHIPPING_COMPLETE);
                shippingRepository.save(shippingDataToUpdate);
        }


    }

}
