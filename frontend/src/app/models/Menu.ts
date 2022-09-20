import { Product } from "./Product";

export interface Menu {
    title: String;
    description: String;
    price: number;
    products: Product[];
}