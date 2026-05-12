package group.emir.order_service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {

    private final OrderKafkaProducer orderKafkaProducer;


    public void saveOrder(Order order) {
        // saving to Database ...
        orderKafkaProducer.sendOrderToKafka(order);
        log.info("Order successfully saved: id={}", order.orderId());
    }
}
