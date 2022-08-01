import { render, screen } from "@testing-library/react";
import ProductPrice from "..";

describe('ProductPrice',() => {
    test('should render ProductPrice with R$', () => {

        var price = 10;

        render(<ProductPrice price={price} />);

        expect(screen.getByText('R$')).toBeInTheDocument();
    });

    test('should have two decimal numbers', () => {

        var price = 10;

        render(<ProductPrice price={price} />);

        expect(screen.getByText('10,00')).toBeInTheDocument();
    });
});