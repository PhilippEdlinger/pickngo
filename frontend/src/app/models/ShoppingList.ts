import { Menu } from "./Menu";
import { Product } from "./Product";

export interface Orders {
    menus: [
        {
            menu: Menu;
            amount: number;
        }
    ]
    products: [
        {
            product: Product;
            amount: number;
        }
    ]
}