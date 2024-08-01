package tech.joelf.e_commerce_api.enums;

public enum OrderStatus {
    WAITING_PAYMENT(1L),
    PAID(2L),
    SHIPPED(3L),
    DELIVERED(3L),
    CANCELED(5L);

    private Long code;

    OrderStatus(Long code) {
        this.code = code;
    }
}
