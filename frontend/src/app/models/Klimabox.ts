import { Product } from "./Product";

export interface Klimabox {
    id: number;
    product: Product;
    discount: number;
    number: number;
    fromDate: Date;
    toDate: Date;
    quantity: number;
}