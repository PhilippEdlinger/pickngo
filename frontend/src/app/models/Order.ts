import { OrderItem} from "./OrderItem";
import { User } from "./User";

export class Order {
    id: number;
    planedToPickTime: Date = new Date();
    customer: User;
    phoneNr: String;
    orderItems: OrderItem[] = [];
}