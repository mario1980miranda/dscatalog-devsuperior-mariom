import { render, screen } from '@testing-library/react';
import { Router, useParams } from 'react-router-dom';
import history from 'util/history';
import Form from '../Form';

jest.mock('react-router-dom', () => ({
  ...jest.requireActual('react-router-dom'),
  useParams: jest.fn(),
}));

describe('ProductForm - test for create', () => {
  beforeEach(() => {
    (useParams as jest.Mock).mockReturnValue({
      productId: 'create',
    });
  });

  test('Form should render', () => {
    // ARRANGER

    // ACT
    render(
      <Router history={history}>
        <Form />
      </Router>
    );

    const nameInput = screen.getAllByTestId('name');
    const priceInput = screen.getAllByTestId('price');
    const imgUrlInput = screen.getAllByTestId('imgUrl');
    const descriptionInput = screen.getAllByTestId('description');

    // ASSERT
  });
});
