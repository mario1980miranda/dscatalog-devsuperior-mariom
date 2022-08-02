import { render, screen } from '@testing-library/react';
import userEvent from '@testing-library/user-event';
import { Router, useParams } from 'react-router-dom';
import history from 'util/history';
import Form from '../Form';
import { server } from './fixtures';
import selectEvent from 'react-select-event';

beforeAll(() => server.listen());
afterEach(() => server.resetHandlers());
afterAll(() => server.close());

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

  test('Form should render', async () => {
    // ARRANGER

    // ACT
    render(
      <Router history={history}>
        <Form />
      </Router>
    );

    const nameInput = screen.getByTestId("name");
    const priceInput = screen.getByTestId("price");
    const imgUrlInput = screen.getByTestId("imgUrl");
    const descriptionInput = screen.getByTestId("description");
    const categoriesInput = screen.getByLabelText("Categorias");

    userEvent.type(nameInput, 'Computador');
    userEvent.type(priceInput, '5000.12');
    userEvent.type(imgUrlInput, 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/8-big.jpg');
    userEvent.type(descriptionInput, 'Computador muito bom');

    await selectEvent.select(categoriesInput, ['Eletrônicos','Computadores']);

    // ASSERT
  });
});
