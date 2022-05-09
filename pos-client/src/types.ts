export type Cart = {
  items: Item[];
};

export type Checkout = {
  total: number;
};

export type Item = {
  product: Product;
  quantity: number;
};

export type Product = {
  id: string;
  name: string;
  price: number;
  image: string;
};
