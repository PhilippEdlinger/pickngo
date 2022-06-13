import { Menu } from "./Menu";
import { Product } from "./Product";

export interface ShoppingList {
    menus: [
        {
            menuId: number;
            amount: number;
        }
    ]
}