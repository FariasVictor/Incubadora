import React, { Component } from "react";
import axios from "../utils/httpClient";
import { Link } from 'react-router-dom';


class ListAccount extends Component {

  state = {
    accounts: []
  }
  retrieveAccounts() {
    axios
      .get("/")
      .then(({ data }) => {
        this.setState({ accounts: data })
      })
  }

  deleteAccount(id) {
    axios
      .delete(`/${id}`)
      .then(() => this.retrieveAccounts());
  }

  componentDidMount() {
    this.retrieveAccounts();
  }

  render() {

    return (
      <div>
        <h1 className="page-title text-center">Contas</h1>
        <table className="table table-sm table-striped table-hover">
          <thead className="thead-dark">
            <tr className="text-center">
              <th>ID</th>
              <th>Saldo</th>
              <th>Limite Disponível</th>
              <th>Limite Máximo</th>
              <th></th>
            </tr>
          </thead>
          <tbody>
            {this.state.accounts.map(account =>
              <tr className="" key={account.id}>
                <td className="align-middle "><strong>{account.id}</strong></td>
                <td className="align-middle">R$ {account.balance}</td>
                <td className="align-middle">R$ {account.availableOverdraft}</td>
                <td className="align-middle">R$ {account.maxOverdraft}</td>
                <td className="btn-group">
                  <Link to={`/edit/${account.id}`} className="btn btn-primary">Alterar Limite</Link>
                  <button className="btn btn-danger" onClick={() => this.deleteAccount(account.id)}>Excluir</button>
                  <div className="operations"></div>
                </td>
                
              </tr>
            )}
          </tbody>
        </table>
        <Link to="/new" className="btn btn-primary">Adicionar Conta</Link>
      </div>
    );
  }
}

export default ListAccount;