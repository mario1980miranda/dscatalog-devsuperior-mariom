import { AxiosRequestConfig } from 'axios';
import { useForm } from 'react-hook-form';
import { Product } from 'types/product';
import { requestBackend } from 'util/requests';
import './styles.css';

const Form = () => {
  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm<Product>();

  const onSubmit = (formData: Product) => {
    const config: AxiosRequestConfig = {
      method: 'POST',
      url: '/products',
      data: formData,
      withCredentials: true,
    };

    requestBackend(config)
      .then((response) => {
        console.log(response.data);
      })
      .catch((error) => {
        console.log('ERROR', error);
      });
  };

  return (
    <div className="product-crud-container">
      <div className="base-card product-crud-form-card">
        <h1 className="product-crud-form-title">Dados do produto</h1>
        <form onSubmit={handleSubmit(onSubmit)}>
          <div className="row product-crud-inputs-container">
            <div className="col-lg-6 product-crud-inputs-left-container">
              <div className="product-crud-input margin-bottom-30">
                <input
                  {...register('name', {
                    required: 'Campo obrigatório',
                  })}
                  type="text"
                  className={`form-control base-input ${
                    errors.name ? `is-invalid` : ''
                  }`}
                  placeholder="Nome do produto"
                  name="name"
                />
                <div className="invalid-feedback d-block">
                  {errors.name?.message}
                </div>
              </div>
              <div className="product-crud-input margin-bottom-30">
                <input type="text" className="form-control base-input" />
              </div>
              <div className="product-crud-input">
                <input type="text" className="form-control base-input" />
              </div>
            </div>
            <div className="col-lg-6">
              <div>
                <textarea
                  cols={30}
                  rows={10}
                  className="form-control base-input h-auto"
                />
              </div>
            </div>
          </div>
          <div className="product-crud-buttons-container">
            <button className="btn btn-outline-danger product-crud-buttom">
              CANCELAR
            </button>
            <button className="btn btn-primary text-white product-crud-buttom">
              SALVAR
            </button>
          </div>
        </form>
      </div>
    </div>
  );
};

export default Form;
