import { OrderItem} from "./OrderItem";
import { User } from "./User";

export class Order {
    id: number;
    orderPosition: number;
    orderStatus: string;
    timeOfOrder: Date;
    planedToPickTime: Date = new Date();
    readyToPickTime: Date;
    msg: string;
    customer: User | null;
    phoneNr: String;
    employee: User;
    orderItems: OrderItem[] = [];
}