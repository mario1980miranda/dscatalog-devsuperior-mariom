# Pas-à-pas pour ce projet

## Instaler NodeJs

Dans ce projet on doit utiliser la version 14.18.2.

<https://nodejs.org/download/release/v14.18.2/>

Crocher l'option "automatic tools for native modules".

## En utilisant gitbash terminal

`node -v`

## Instaler Yarn

<https://classic.yarnpkg.com/en/docs/install>

## Extensions VsCode

+ Color Highlight
+ ESLint
+ JSX HTML <tags/>
+ Visual Studio IntelliCode

## Créer un projet ReactJS

`yarn create react-app frontweb --template typescript`

**Atention:** Supprimer le dossier **.git** au besoin

## Rétrograder pour conserver la compatibilité

`yarn add react@17.0.2 react-dom@17.0.2 @types/react@17.0.0 @types/react-dom@17.0.0`

+ Supprimer ficher yarn.lock
+ Supprimer dossier node_modules
+ Réinstaller tout avec le command "yarn"

## Mettre à jour le fichier index.tsx

```javascript
import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';

ReactDOM.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>,
  document.getElementById('root')
);
```

## Nettoyer le projet

### Dans le dossier public supprimer :

+ logo...png
+ manifest.json
+ robots.txt

### Dans le fichier index.html :

+ Supprimer les commentaires

### Dans le dossier src supprimer :

+ App.test.tsx
+ logo.svg
+ reportWebVitals.ts
+ setupTests.ts

### Dans le fichier App.css

+ Supprimer le contenu

### Dans le fichier App.tsx :

+ L'import du React n'est pas nécessaire dès la version 17
+ Nettoyer le contenu html de la fonction jsx

### Supprimer le fichier index.css

### Dans le fichier index.tsx

+ Supprimer les commentaires
+ Supprimer l'appel à reportWebVitals();

### Dans le ficher tsconfig.json

Ajoute dans l’item **"compilerOptions"**  pour faciliter l'import de composants

```json
"baseUrl": "./src",
```

## Ajouter Bootstrap

### Dans le projet executer le command :

`yarn add bootstrap`

### Dans le ficher index.tsx

+ Ajoute l'import avant d'import App

```javascript
import 'bootstrap/dist/css/bootstrap.css';
```

+ yarn start pour vérifier si cela marche

## Personnaliser Bootstrap

`yarn add node-sass@4.14.1`

### Créer le fichier custom.scss

+ Dans public > src créer les dossiers :
    + assets > styles
+ Créer le fichier custom.scss avec le contenu :

```css
$theme-colors: (
  'primary': #407bff,
);

$body-bg: #e5e5e5;
$body-color: #263238;

@import '~bootstrap/scss/bootstrap.scss';
```

+ Supprimer l'import du bootstrap dans le fichier index.tsx

### Dans le fichier App.tsx ajouter l'import :

+ import './assets/styles/custom.scss';

## Instaler Prettier - Code formateur :

### Dans le dossier src

+ Créer le fichier .prettierrc
```json
{
  "tabWidth": 2,
  "useTabs": false,
  "singleQuote": true
}
```

### Dans VSCode

+ Installer l'extension prettier code formatter
+ shift + alt + F pour formater

## Références à propos de Bootstrap

+ Bootstrap Breakpoints
+ Bootstrap Containers
+ Bootstrap Grid System

## Références à propos de Flexbox

+ <https://www.w3schools.com/css/css3_flexbox.asp>
+ <https://flexboxfroggy.com/>
+ <https://css-tricks.com/snippets/css/a-guide-to-flexbox>

## Google fonts

+ <https://fonts.google.com/>

# Créer composants

## Navbar

+ Créer dossier
    + src > components > Navbar
+ Créer fichier
    + index.tsx
    + Créer la fonction Navbar (vérifier le code)
+ Dans le fichier App.tsx
    + Import du composant

**Attention:** Les noms des composants doivent toujours avoir le même nom du dossier.

### Button humbuger menu

#### Ajouter le code default dans le component Navbar

```javascript
<button
  className="navbar-toggler"
  type="button"
  data-bs-toggle="collapse"
  data-bs-target="#dscatalog-navbar"
  aria-controls="dscatalog-navbar"
  aria-expanded="false"
  aria-label="Toggle navigation"
>
  <span className="navbar-toggler-icon"></span>
</button>
```

#### Référencer le button dans la collection d'éléments ul/li avec la tag id

`<div className="collapse navbar-collapse" id="dscatalog-navbar">`

#### Importer le javascript du bootstrap

`import 'bootstrap/js/src/collapse.js';`

#### Ajouter le theme dark au composant Navbar

`navbar-dark`
```javascript
<nav className="navbar navbar-expand-md navbar-dark bg-primary main-nav">
```

#### Modifier la hauteur de la barre de navigation pour le contenu dynamique dans les styles

```css
.main-nav {
    padding-left: 40px;
    min-height: 70px;
}
```

## React Router DOM

### Installer

```yarn add react-router-dom@5.2.0 @types/react-router-dom@5.1.7```

**Attention** Pour supprimer : ```yarn remove react-router-dom @types/react-router-dom```

### Créer le composant Routes dans le dossier src

```typescript
import Navbar from "components/Navbar";
import Admin from "pages/Admin";
import Catalog from "pages/Catalog";
import Home from "pages/Home";
import { BrowserRouter, Route, Switch } from "react-router-dom";

const Routes = () => (
    <BrowserRouter>
        <Navbar />
        <Switch>
            <Route path="/" exact>
                <Home />
            </Route>
            <Route path="/products">
                <Catalog />
            </Route>
            <Route path="/admin">
                <Admin />
            </Route>
        </Switch>
    </BrowserRouter>
);

export default Routes;
```

### Utiliser Link et NavLink du react-router-dom au lieu de <a>

```typescript
import "./styles.css";
import 'bootstrap/js/src/collapse.js';
import { Link, NavLink } from "react-router-dom";

const Navbar = () => {
  return (
    <nav className="navbar navbar-expand-md navbar-dark bg-primary main-nav">
      <div className="container-fluid">
        <Link to="/" className="nav-logo-text">
          <h4>DS Catalog</h4>
        </Link>
        <button
          className="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#dscatalog-navbar"
          aria-controls="dscatalog-navbar"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span className="navbar-toggler-icon"></span>
        </button>

        <div className="collapse navbar-collapse" id="dscatalog-navbar">
          <ul className="navbar-nav offset-md-2 main-menu">
            <li>
              <NavLink to="/" activeClassName="active" exact>
                ACCUEIL
              </NavLink>
            </li>
            <li>
              <NavLink to="/products">CATALOGUE</NavLink>
            </li>
            <li>
              <NavLink to="/admin">ADMIN</NavLink>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  );
};

export default Navbar;
```

## Props, State et Life Cycle

<https://pt-br.reactjs.org/docs/components-and-props.html>

<https://pt-br.reactjs.org/docs/state-and-lifecycle.html>

### Exemple d'utilisation

Props est un objet ou un type de donnée, qui sera transférée parmi les composants.
Par exemple, Product est un attribut d'un Props, ainsi comme "product.price" est un Props
pour Product Price.

```typescript
import './styles.css';
import ProductPrice from 'components/ProductPrice';
import { Product } from 'types/product';

type Props = {
    product : Product;
}

const ProductCard = ({product} : Props) => {
    return(
        <div className="base-card product-card">
            <div className="card-top-container">
                <img src={product.imgUrl} alt={product.name} />
            </div>
            <div className="card-bottom-container">
                <h6>{product.name}</h6>
                <ProductPrice price={product.price} />
            </div>
        </div>
    );
}

export default ProductCard;
```

## Axios

```yarn add axios```

### Exemple d'utilisation

Axios est la bibliothèque responsable des appels REST à notre API Java.

### Interface centrale

```typescript
export const requestBackend = (config: AxiosRequestConfig) => {
  const headers = config.withCredentials
    ? {
        ...config.headers,
        Authorization: 'Bearer ' + getAuthData().access_token,
      }
    : config.headers;

  return axios({ ...config, baseURL: BASE_URL, headers: headers });
};
```

### Utilisation

Dans un UseEffect on utilise l'opération requestBackend(AxiosRequestConfig), qui
à la fin est un appel Axios. 
Finalement, modifier l'état de la page/composant.

```typescript
<code>...</code>
const Catalog = () => {
  const [page, setPage] = useState<SpringPage<Product>>();
  const [isLoading, setIsLoading] = useState(false);

  useEffect(() => {
    const params: AxiosRequestConfig = {
      method: "GET",
      url: "/products",
      params: {
        page: 0,
        size: 12,
      }
    };

    setIsLoading(true);
    requestBackend(params)
      .then((response) => {
        setPage(response.data);
      })
      .finally(() => {
        setIsLoading(false);
      });
  }, []);
<code>...</code>
```

## Loaders

```yarn add react-content-loader```

source : <https://github.com/danilowoz/react-content-loader>

### Exemple d'utilisation

Est une image avec l'extension SVG qui on va montrer pendant la période de chargement des
données de la page et quand ce processus finir, on le change pour le fragment html pertinent.

```typescript
<code>...</code>

  const { productId } = useParams<UrlParams>();
  const [product, setProduct] = useState<Product>();
  const [isLoading, setIsLoading] = useState(false);

  useEffect(() => {
*1* setIsLoading(true);
    axios
      .get(`${BASE_URL}/products/${productId}`)
      .then((response) => setProduct(response.data))
      .finally(() => {
        setIsLoading(false);
      });
  }, [productId]);

<code>...</code>

  <div className="col-xl-6">
*2* {isLoading ? (
      <ProductDetailsLoader />
    ) : (
      <div className="description-container">
        <h2>Descrição do produto</h2>
        <p>{product?.description}</p>
      </div>
    )}
  </div>
```
*1* - On change l'état du composant pour isLoading comme vrai.
*2* - Pendant l'appel à l'API externe on montre le composant de chargement, l'image svg.

## React Hook Form

```yarn add react-hook-form```

### Exemple d'utilisation

Literalement on va crocher les elements d'une formulaire au composant ou à la page en 
utilisant l'atribut "name" du html.
Il est possible de valider les champs du formulaire.

```typescript
<code>...</code>

*3*type FormData = {
  username: string;
  password: string;
};

<code>...</code>

*4*const {
    register,
*6* handleSubmit,
    formState: { errors },
  } = useForm<FormData>();
*5*const onSubmit = (formData: FormData) => {
    requestBackendLogin(formData)
      .then((response) => {
        saveAuthData(response.data);
        setHasError(false);
        setAuthContextData({
          authenticated: true,
          tokenData: getTokenData(),
        });
        history.replace(from);
      })
      .catch((error) => {
        setHasError(true);
        console.log('ERROR', error);
      });
  };  

<code>...</code>

*6*   <form onSubmit={handleSubmit(onSubmit)}>
        <div className="mb-4">
          <input
*1*         {...register('username', {
              required: 'Campo obrigatório',
              pattern: {
                value: /^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,}$/i,
                message: 'Email inválido',
              },
            })}
            type="text"
            className={`form-control base-input ${
              errors.username ? `is-invalid` : ''
            }`}
            placeholder="Email"
*2*         name="username"
          />
          <div className="invalid-feedback d-block">
            {errors.username?.message}
          </div>
        </div>

<code>...</code>
```

*1* - Le expression "...register" contient plusieurs options pour valider et pour attribuer les valeurs des
champs aux composants du type FormData dans notre exemple.
*2* - Note que le nom du champ est le même qu'on utilise dans le 'hook' FormData, usename dans ce cas.
*3* - On déclare le type FormData.
*4* - Dans le composant, on déclare l'UseForm.
*5* - La fonction du formulaire pour l'événement "Submit", qui va exécuter les validations avant d'appeler
l'API
*6* - handleSubmit c'est le nom de la fonction interne du 'react-hook-form', on l'utilise comme bonne pratique
de standardisation.

## Query String

Pour utiliser x-www-form-urlencoded dans les requêtes OAuth 2.0

```yarn add qs @types/qs```

### Exemple d'utilisation

```typescript
<code>...</code>

export const requestBackendLogin = (loginData: LoginData) => {
  const headers = {
    'Content-Type': 'application/x-www-form-urlencoded',
    Authorization: basicHeader(),
  };

  const data = qs.stringify({
    ...loginData,
    grant_type: 'password',
  });

  return axios({
    method: 'POST',
    baseURL: BASE_URL,
    url: '/oauth/token',
    data: data,
    headers: headers,
  });
};

<code>...</code>
```

## JWT Decoder

```yarn add jwt-decode @types/jwt-decode```

```typescript
export const getTokenData = (): TokenData | undefined => {
  try {
    return jwtDecode(getAuthData().access_token) as TokenData;
  } catch (error) {
    return undefined;
  }
};
```

# La communication entre les composants - Context API

Fournir des états globaux pour l'application, il peut être observé par d'autres composants.

## Les 3 étapes

### 1 Créer un contexte global

Dans notre cas, le 'src/AuthContext.ts' sera le contexte global :

```typescript
import { createContext } from 'react';
import { TokenData } from 'util/auth';

export type AuthContextData = {
  authenticated: boolean;
  tokenData?: TokenData;
};

export type AuthContextType = {
  authContextData: AuthContextData;
  setAuthContextData: (authContextData: AuthContextData) => void;
};

export const AuthContext = createContext<AuthContextType>({
  authContextData: {
    authenticated: false,
  },
  setAuthContextData: () => null,
});
```
*Note* - "createContext" du react nous permettra de lui exposer par toute l'application.
*Note* - "setAuthContextData" nous permettra modifier l'état du composant.

Dans l’événement de la connexion (Login), on modifie l'état du AuthContext :

```typescript
  const onSubmit = (formData: FormData) => {
    requestBackendLogin(formData)
      .then((response) => {
        saveAuthData(response.data);
        setHasError(false);
        setAuthContextData({
          authenticated: true,
          tokenData: getTokenData(),
        });
        history.replace(from);
      })
      .catch((error) => {
        setHasError(true);
        console.log('ERROR', error);
      });
  };
  ```

Le composant "Navbar" observe aussi les changements au niveau AuthContext :

```typescript
const Navbar = () => {
  const { authContextData, setAuthContextData } = useContext(AuthContext);

  useEffect(() => {
    if (isAuthenticated()) {
      setAuthContextData({
        authenticated: true,
        tokenData: getTokenData(),
      });
    } else {
      setAuthContextData({
        authenticated: false,
      });
    }
  }, [setAuthContextData]);

  const handleLogoutClick = (event: React.MouseEvent<HTMLAnchorElement>) => {
    event.preventDefault();
    removeAuthData();
    setAuthContextData({
      authenticated: false,
    });
    history.replace('/');
  };

<code>...</code>

  <div className="nav-login-logout">
    {authContextData.authenticated ? (
      <>
        <span className="nav-user-name">
          {authContextData.tokenData?.user_name}
        </span>
        <a href="#logout" onClick={handleLogoutClick}>
          LOGOUT
        </a>
      </>
    ) : (
      <Link to="/admin/auth">LOGIN</Link>
    )}
  </div>

<code>...</code>
```

### 2 Fournir ce contexte global

Créer un "useState" dans le App.tsx

```typescript
import './assets/styles/custom.scss';
import './App.css';
import Routes from 'Routes';
import { useState } from 'react';
import { AuthContext, AuthContextData } from 'AuthContext';

const App = () => {
  const [authContextData, setAuthContextData] = useState<AuthContextData>({
    authenticated: false,
  });

  return (
    <AuthContext.Provider value={{ authContextData, setAuthContextData }}>
      <Routes />
    </AuthContext.Provider>
  );
};

export default App;
```

*Note* - "<AuthContext.Provider value={{ authContextData, setAuthContextData }}>"

### 3 Accéder à ce contexte global

À l'intérieur de n'importe quel composant.

```typescript
  const { authContextData, setAuthContextData } = useContext(AuthContext);
```

```typescript
<code>...</code>

const Login = () => {
  const location = useLocation<LocationState>();
  const { from } = location.state || { from: { pathname: '/admin' } };
  const { setAuthContextData } = useContext(AuthContext);
  const [hasError, setHasError] = useState(false);
  const history = useHistory();
  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm<FormData>();

  const onSubmit = (formData: FormData) => {
    requestBackendLogin(formData)
      .then((response) => {
        saveAuthData(response.data);
        setHasError(false);
        setAuthContextData({
          authenticated: true,
          tokenData: getTokenData(),
        });
        history.replace(from);
      })
      .catch((error) => {
        setHasError(true);
        console.log('ERROR', error);
      });
  };

<code>...</code>
```
