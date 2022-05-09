import { Container, Divider, Text } from "@chakra-ui/react";
import axios from "axios";
import { useCallback, useEffect, useState } from "react";
import { CartComp } from "./Cart";
import { ProductComp } from "./Product";
import { Cart, Checkout, Product } from "./types";

const App = () => {
  const [cart, setCart] = useState<Cart>();
  const [products, setProducts] = useState<Product[]>();

  const addItem = useCallback((productId: string, amount: number) => {
    axios
      .post<Cart>(
        `http://localhost:8080/api/carts/items/${productId}?amount=${amount}`,
        {
          productId: productId,
          amount: amount,
        },
        { withCredentials: true },
      )
      .then((response) => {
        setCart(response.data);
      })
      .catch(console.error);
  }, []);

  const removeItem = useCallback((productId: string) => {
    axios
      .delete<Cart>(`http://localhost:8080/api/carts/items/${productId}`, {
        withCredentials: true,
      })
      .then((response) => {
        setCart(response.data);
      })
      .catch(console.error);
  }, []);

  const checkout = useCallback(() => {
    axios
      .post<Checkout>(
        "http://localhost:8080/api/carts/checkout",
        {},
        { withCredentials: true },
      )
      .then((response) => {
        window.alert(`total is ${response.data.total}`);
        setCart({
          items: [],
        });
      })
      .catch(console.error);
  }, []);

  useEffect(() => {
    axios
      .get<Product[]>("http://localhost:8080/api/products")
      .then((response) => {
        setProducts(response.data);
      })
      .catch(console.error);
    axios
      .get<Cart>("http://localhost:8080/api/carts", {
        withCredentials: true,
      })
      .then((response) => {
        setCart(response.data);
      })
      .catch(console.error);
  }, []);

  return (
    <Container my={10}>
      <Text>MicroPos React Client</Text>
      <Divider my={5} />
      {cart && (
        <CartComp cart={cart} removeItem={removeItem} checkout={checkout} />
      )}
      <Divider my={5} />
      {products && (
        <>
          {products.length === 0 ? (
            <Text>Products is empty!</Text>
          ) : (
            <ProductComp products={products} addItem={addItem} />
          )}
        </>
      )}
    </Container>
  );
};

export default App;
