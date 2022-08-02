import { act, render, screen, waitFor } from '@testing-library/react';
import { Router } from 'react-router-dom';
import history from 'util/history';
import Catalog from '..';

describe('Catalog page tests', () => {
  test('Should render Catalog page first state with loading...', () => {
    // ARRANGER

    // ACT
    render(
      <Router history={history}>
        <Catalog />
      </Router>
    );

    // ASSERT
    expect(screen.getByText('Catálogo de produtos')).toBeInTheDocument();
  });

  test('Should render Catalog with products with async call', async () => {
    act(() => {
        render(
          <Router history={history}>
            <Catalog />
          </Router>
        );
    });

    expect(screen.getByText('Catálogo de produtos')).toBeInTheDocument();
    await waitFor(() =>
      expect(screen.getByText('Smart TV')).toBeInTheDocument()
    );
  });
});
