package edu.nju.sa2022.micropos.delivery;

import edu.nju.sa2022.micropos.delivery.api.DeliveriesApi;
import edu.nju.sa2022.micropos.delivery.dto.DeliveryDto;
import edu.nju.sa2022.micropos.models.Delivery;
import edu.nju.sa2022.micropos.services.DeliveryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class DeliveryController implements DeliveriesApi {

    private final DeliveryService deliveryService;
    private final DeliveryMapper deliveryMapper;

    public DeliveryController(DeliveryService deliveryService,
                              DeliveryMapper deliveryMapper) {
        this.deliveryService = deliveryService;
        this.deliveryMapper = deliveryMapper;
    }

    @Override
    public ResponseEntity<List<DeliveryDto>> listDeliveriesByOrderId(String orderId) {
        List<Delivery> deliveries = deliveryService.findDeliveriesByOrderId(orderId);
        return new ResponseEntity<>(deliveryMapper.toDeliveryDtos(deliveries), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DeliveryDto> findDelivery(String deliveryId) {
        Delivery delivery = deliveryService.findDelivery(deliveryId);
        return new ResponseEntity<>(deliveryMapper.toDeliveryDto(delivery), HttpStatus.OK);
    }
}
