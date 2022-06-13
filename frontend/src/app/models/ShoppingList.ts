import { Menu } from "./Menu";
import { Product } from "./Product";

export interface Orders {
    menus: [
        {
            menuId: number;
            amount: number;
        }
    ]
    products: [
        {
            productId: number;
            amount: number;
        }
    ]
}