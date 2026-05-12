package group.emir.order_service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderKafkaProducer {

    private final KafkaTemplate<String, Order> kafkaTemplate;

    public void sendOrderToKafka(Order order) {
        kafkaTemplate.send("orders", order);
        log.info("Order sent to Kafka: id = {}", order.orderId());
    }
}
