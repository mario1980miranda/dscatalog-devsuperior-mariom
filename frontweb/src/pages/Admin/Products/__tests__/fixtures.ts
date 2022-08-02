import { rest } from 'msw';
import { setupServer } from 'msw/node';
import { BASE_URL } from 'util/requests';

const findCategoriesResponse = {
  content: [
    {
      id: 3,
      name: 'Computadores',
    },
    {
      id: 2,
      name: 'Eletrônicos',
    },
    {
      id: 1,
      name: 'Livros',
    },
  ],
  pageable: {
    sort: {
      sorted: true,
      unsorted: false,
      empty: false,
    },
    offset: 0,
    pageNumber: 0,
    pageSize: 10,
    paged: true,
    unpaged: false,
  },
  last: true,
  totalPages: 1,
  totalElements: 3,
  size: 10,
  number: 0,
  sort: {
    sorted: true,
    unsorted: false,
    empty: false,
  },
  first: true,
  numberOfElements: 3,
  empty: false,
};

export const server = setupServer(
  // Describe the requests to mock.
  rest.get(`${BASE_URL}/categories`, (req, res, ctx) => {
    return res(ctx.status(200), ctx.json(findCategoriesResponse));
  })
);
