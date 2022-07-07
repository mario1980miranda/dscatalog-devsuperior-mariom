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

## Axios

```yarn add axios```

