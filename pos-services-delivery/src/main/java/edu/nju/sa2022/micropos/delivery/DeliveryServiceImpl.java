package edu.nju.sa2022.micropos.delivery;

import edu.nju.sa2022.micropos.models.Delivery;
import edu.nju.sa2022.micropos.services.DeliveryService;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepository deliveryRepository;

    public DeliveryServiceImpl(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    @Override
    public List<Delivery> findDeliveriesByOrderId(String orderId) {
        return deliveryRepository
                .findAllByOrderId(orderId);
    }

    @Override
    public Delivery findDelivery(String deliveryId) {
        return deliveryRepository
                .findById(deliveryId)
                .orElse(null);
    }

    @Override
    public Delivery createDelivery(Delivery delivery) {
        delivery = deliveryRepository.save(delivery);
        log.info(String.format("Order delivered: %s", delivery.getOrderId()));
        return delivery;
    }

}
