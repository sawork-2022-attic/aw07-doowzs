import { Box, Button, Image, Text } from "@chakra-ui/react";
import { Product } from "./types";

export const ProductInfo = ({
  product,
  add,
}: {
  product: Product;
  add: () => void;
}) => {
  return (
    <>
      <Box my={4}>
        <Text>{product.name}</Text>
        <Box display="flex">
          <Image src={product.image} height={20} />
          <Button onClick={add}>Add</Button>
        </Box>
      </Box>
    </>
  );
};

export const ProductComp = ({
  products,
  addItem,
}: {
  products: Product[];
  addItem: (productId: string, amount: number) => void;
}) => {
  return (
    <>
      <Box my={3}>
        <Text>Products</Text>
        <Box>
          {products.map((product, index) => (
            <ProductInfo
              key={index}
              product={product}
              add={() => addItem(product.id, 1)}
            />
          ))}
        </Box>
      </Box>
    </>
  );
};
