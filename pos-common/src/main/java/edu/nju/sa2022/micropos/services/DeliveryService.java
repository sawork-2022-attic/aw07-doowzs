package edu.nju.sa2022.micropos.services;

import edu.nju.sa2022.micropos.models.Delivery;

import java.util.List;

public interface DeliveryService {

    List<Delivery> findDeliveriesByOrderId(String orderId);

    Delivery findDelivery(String deliveryId);

    Delivery createDelivery(Delivery delivery);

}
