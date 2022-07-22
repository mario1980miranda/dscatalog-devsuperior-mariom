import ProductPrice from 'components/ProductPrice';
import CategoryBadge from '../CategoryBadge';
import { Product } from 'types/product';

import './styles.css';

type Props = {
  product: Product;
};

const ProductCrudCard = ({ product }: Props) => {
  return (
    <div className="base-card product-crud-card">
      <div className="product-crud-card-top-container">
        <img src={product.imgUrl} alt={product.name} />
      </div>
      <div>
        <div className="product-crud-card-bottom-container">
          <h6>{product.name}</h6>
          <ProductPrice price={product.price} />
        </div>
        <div className="product-crud-card-categories-container">
          {product.categories.map((category) => (
            <CategoryBadge key={category.id} name={category.name} />
          ))}
        </div>
      </div>
    </div>
  );
};

export default ProductCrudCard;
