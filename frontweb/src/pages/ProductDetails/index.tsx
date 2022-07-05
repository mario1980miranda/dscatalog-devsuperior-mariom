import { ReactComponent as ArrowIcon } from 'assets/images/arrow.svg';
import ProductPrice from 'components/ProductPrice';

const ProductDetails = () => {
    return(
        <div className="product-details-container">
            <div className="product-details-card">
                <div className="goback-container">
                    <ArrowIcon />
                    <h2>Voltar</h2>
                </div>
                <div className="row">
                    <div className="col-xl-6">
                        <div className="img-container">
                            <img src="https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/4-big.jpg" alt="Nome do produto" />
                            <ProductPrice price={234.56} />
                        </div>
                    </div>
                    <div className="col-xl-6">
                        <div className="description-container">
                            <h1>Descrição do produto</h1>
                            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Aut, consequatur.</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default ProductDetails;
