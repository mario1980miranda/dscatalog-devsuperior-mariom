import './styles.css';

const Form = () => {
  return (
    <div className="product-crud-container">
      <div className="base-card product-crud-form-card">
        <h1 className="product-crud-form-title">Dados do produto</h1>
        <form action="">
          <div className="row product-crud-inputs-container">
            <div className="col-lg-6 product-crud-inputs-left-container">
              <div className="product-crud-input margin-bottom-30">
                <input type="text" className="form-control base-input" />
              </div>
              <div className="product-crud-input margin-bottom-30">
                <input type="text" className="form-control base-input" />
              </div>
              <div className="product-crud-input">
                <input type="text" className="form-control base-input" />
              </div>
            </div>
            <div className="col-lg-6">
              <textarea
                cols={30}
                rows={10}
                className="form-control base-input"
              ></textarea>
            </div>
          </div>
          <div className="product-crud-buttons-container">
            <button className="btn btn-outline-danger">CANCELAR</button>
            <button className="btn btn-primary">SALVAR</button>
          </div>
        </form>
      </div>
    </div>
  );
};

export default Form;
