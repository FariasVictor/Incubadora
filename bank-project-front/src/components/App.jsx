import React from 'react';

import {BrowserRouter, Route, Switch} from 'react-router-dom'

import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css'
import './Accounts.css'

import ListAccount from '../pages/ListAccount';
import NewAccount from '../pages/NewAccount';
import EditAccount from '../pages/EditAccount';
import Deposit from '../pages/Deposit';
import Withdraw from '../pages/Withdraw';
import ListCustomer from '../pages/ListCustomer'

function App() {
  return (
    <div style={{marginTop: 50}} className="container">
      <BrowserRouter>
        <Switch>
          <Route path="/" exact component={ListAccount}/>
          <Route path="/new" exact component={NewAccount}/>
          <Route path="/edit/:id" exact component={EditAccount}/>
          <Route path="/withdraw/:id" exact component={Withdraw}/>
          <Route path="/deposit/:id" exact component={Deposit}/>
          <Route path="/customer" exact component={ListCustomer}/>
        </Switch>
      </BrowserRouter>
    </div>
  );
}

export default App;
