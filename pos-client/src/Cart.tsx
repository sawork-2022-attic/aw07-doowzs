import { Box, Button, Text } from "@chakra-ui/react";
import { Cart, Item } from "./types";

export const CartItem = ({
  item,
  remove,
}: {
  item: Item;
  remove: () => void;
}) => {
  return (
    <>
      <Box>
        <Text>
          {item.product.name} x {item.quantity}
        </Text>
        <Button onClick={remove}>Remove</Button>
      </Box>
    </>
  );
};

export const CartComp = ({
  cart,
  removeItem,
  checkout,
}: {
  cart: Cart;
  removeItem: (productId: string) => void;
  checkout: () => void;
}) => {
  return (
    <>
      <Box my={3}>
        <Text>Cart</Text>
        {cart.items.length === 0 ? (
          <Text>Cart is empty!</Text>
        ) : (
          <Box>
            {cart.items.map((item, index) => (
              <CartItem
                key={index}
                item={item}
                remove={() => removeItem(item.product.id)}
              />
            ))}
          </Box>
        )}
        <Box my={3}>
          <Button width="full" onClick={checkout}>
            Checkout
          </Button>
        </Box>
      </Box>
    </>
  );
};
