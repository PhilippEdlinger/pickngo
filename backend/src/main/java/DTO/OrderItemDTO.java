package DTO;

public class OrderItemDTO {
    private Long order_id;
    private Long product_id;
    private Integer quantity;
    private String message;

    public OrderItemDTO() {
    }

    public OrderItemDTO(Long order_id, Long product_id, Integer quantity, String message) {
        this.order_id = order_id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.message = message;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
