import React, {Component} from "react";
import axios from "../utils/httpClient";
import {Link} from 'react-router-dom';

class ListAccount extends Component {

  state = {
    accounts: []
  }
  retrieveAccounts() {
    axios
      .get("/account")
      .then(({data}) => {
        this.setState({accounts: data})
      })
  }

  deleteAccount(id) {
    axios
      .delete(`/account/${id}`)
      .then(() => this.retrieveAccounts());
  }

  componentDidMount() {
    this.retrieveAccounts();
  }
adadsd
  render() {

    return (
      <div>
        <h1 className="page-title text-center">Contas</h1>
        <table className="table table-sm table-striped table-hover">
          <thead className="thead-dark">
            <tr className="text-center">
              <th>ID</th>
              <th>Cliente</th>
              <th>Saldo</th>
              <th>Limite Disponível</th>
              <th>Limite Máximo</th>
              <th></th>
            </tr>
          </thead>
          <tbody>
            {this
              .state
              .accounts
              .map(account => <tr className="" key={account.id}>
                <td className="align-middle text-center">
                  <strong>{account.id}</strong>
                </td>
                <td className="align-middle">{account.customer.name}</td>
                <td className="align-middle">R$ {account.balance}</td>
                <td className="align-middle">R$ {account.availableOverdraft}</td>
                <td className="align-middle">R$ {account.maxOverdraft}</td>
                <td>
                  {/* <button className="operations btn btn-success" dataToggle="collapse">Operaçoes</button> */}
                  <div className="btn btn-group">
                    <Link
                      style={{
                      backgroundColor: '#698AFF'
                    }}
                      className="btn text-white"
                      to={`deposit/${account.id}`}>Depositar</Link>
                    <Link
                      style={{
                      backgroundColor: '#f4511e'
                    }}
                      className="btn text-white"
                      to={`withdraw/${account.id}`}>Sacar</Link>
                  </div>
                  <div className="btn btn-group">
                    <Link to={`/edit/${account.id}`} className="btn btn-primary">Alterar Limite</Link>
                    <button
                      className="btn btn-danger"
                      onClick={() => this.deleteAccount(account.id)}>Excluir</button>
                  </div>
                </td>
              </tr>)}
          </tbody>
        </table>
        <Link to="/new" className="btn btn-primary">Adicionar Conta</Link>
      </div>
    );
  }
}

export default ListAccount;