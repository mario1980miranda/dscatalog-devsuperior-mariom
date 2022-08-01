import { render, screen } from '@testing-library/react';
import { Product } from 'types/product';
import ProductCard from '..';

describe('ProductCard tests', () => {
  test('should render ProductPrice with name', () => {
    const item = {
      id: 1,
      name: 'Nome do produto',
      description: 'Descriçao do produto',
      price: 10,
      imgUrl: 'Imagem do produto',
    } as Product;

    render(<ProductCard product={item} />);

    expect(screen.getByText(item.name)).toBeInTheDocument();
  });

  test('should render ProductPrice with image element', () => {
    const item = {
      id: 1,
      name: 'Nome do produto',
      description: 'Descriçao do produto',
      price: 10,
      imgUrl: 'Imagem do produto',
    } as Product;

    render(<ProductCard product={item} />);

    expect(screen.getByAltText(item.name)).toBeInTheDocument();
  });

  test('should render ProductPrice with R$', () => {
    var item = {
      id: 1,
      name: 'Nome do produto',
      description: 'Descriçao do produto',
      price: 10,
      imgUrl: 'Imagem do produto',
    } as Product;

    render(<ProductCard product={item} />);

    expect(screen.getByText('R$')).toBeInTheDocument();
  });

  test('price should have 2 decimal numbers', () => {
    var item = {
      id: 1,
      name: 'Nome do produto',
      description: 'Descriçao do produto',
      price: 2345.67,
      imgUrl: 'Imagem do produto',
    } as Product;

    render(<ProductCard product={item} />);

    expect(screen.getByText('2.345,67')).toBeInTheDocument();
  });
});
