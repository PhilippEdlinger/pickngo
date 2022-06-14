import { Product } from "./Product";

export interface Order {
    id: number;
    planedToPickTime: Date;
    msg: String;
    customer: {
        id: number
    };
    orderItems: [
        {
            orderItemID: {
                orderET: {
                    id: number
                },
                product: Product;
                quantity: number;
                message: String;
            },

        }
    ]
}