import { formatPrice } from 'util/formatters';

describe('formatPrice for positive numbers', () => {
  test('formatPrice should format number pt-BR when given 10.0', () => {
    const value = 10.1;

    const result = formatPrice(value);

    expect(result).toEqual('10,10');
  });

  test('formatPrice should format number pt-BR when given 0.1', () => {
    const value = 0.1;

    const result = formatPrice(value);

    expect(result).toEqual('0,10');
  });
});

describe('formatPrice for non positive numbers', () => {
  test('formatPrice should format number pt-BR when given 0', () => {
    const value = 0;

    const result = formatPrice(value);

    expect(result).toEqual('0,00');
  });

  test('formatPrice should format number pt-BR when given -5.1', () => {
    const value = -5.1;

    const result = formatPrice(value);

    expect(result).toEqual('-5,10');
  });
});
