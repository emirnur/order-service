package group.emir.order_service;

public record Order(
        String orderId,
        String product,
        String quantity
) {
}
