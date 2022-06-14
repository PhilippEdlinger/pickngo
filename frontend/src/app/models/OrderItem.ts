import { OrderItemID } from "./OrderItemID";
import { Product } from "./Product";

export class OrderItem {
    orderItemId: OrderItemID;
    quantity: number = 1;
}