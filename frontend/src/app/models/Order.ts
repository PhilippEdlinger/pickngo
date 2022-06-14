import { OrderItem} from "./OrderItem";
import { Product } from "./Product";

export class Order {
    id: number;
    planedToPickTime: Date;
    customer: {
        id: number;
    };
    orderItems: OrderItem[] = [];
}