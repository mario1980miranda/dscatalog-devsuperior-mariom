import { ReactComponent as ArrowIcon } from 'assets/images/arrow.svg';
import ReactPaginate from 'react-paginate';

import './styles.css';

const Pagination = () => {
  return (
    <ReactPaginate
      pageCount={10}
      pageRangeDisplayed={3}
      marginPagesDisplayed={1}
      containerClassName="pagination-container"
      pageLinkClassName="pagination-item"
      breakClassName="pagination-item"
      previousLabel={<ArrowIcon />}
      previousClassName="arrow-previous"
      nextLabel={<ArrowIcon />}
      nextClassName="arrow-next"
      activeLinkClassName="pagination-link-active"
      disabledClassName="arrow-inactive"
    />
  );
};

export default Pagination;
