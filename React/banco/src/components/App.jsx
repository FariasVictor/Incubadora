import React from 'react';

import {BrowserRouter, Route, Switch} from 'react-router-dom'

import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css'

import ListAccount from '../pages/ListAccount';
import NewAccount from '../pages/NewAccount';
import EditAccount from '../pages/EditAccount';

function App() {
  return (
    <div style={{marginTop: 50}} className="container">
      <BrowserRouter>
        <Switch>
          <Route path="/" exact component={ListAccount}/>
          <Route path="/new" exact component={NewAccount}/>
          <Route path="/edit/:id" exact component={EditAccount}/>
        </Switch>
      </BrowserRouter>
    </div>
  );
}

export default App;
