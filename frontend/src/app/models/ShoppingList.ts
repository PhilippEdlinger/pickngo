import { Menu } from "./Menu";
import { Product } from "./Product";

export interface Orders {
    products: [
        {
            productId: number;
            amount: number;
        }
    ]
}