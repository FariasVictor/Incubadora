import React, { Component } from 'react';
import axios from '../utils/httpClient';

class ListCustomer extends Component {
    state = {
        customers: []
    }
    retrieveCustomers = () => {
        axios.get('/customer').then(({ data }) => {
            this.setState({ customers: data })
        })
    }

    componentDidMount() {
        this.retrieveCustomers();
    }
    render() {
        return <table className="table table-sm table-striped table-hover">
            <thead className="thead-dark">
                <th>ID</th>
                <th>Nome</th>
                <th>CPF</th>
            </thead>
            <tbody>
                {this.state.customers.map((customer) =>
                    <tr>
                        <td>{customer.id}</td>
                        <td>{customer.name}</td>
                        <td>{customer.cpf}</td>
                    </tr>
                )}
            </tbody>
        </table>
    }
}

export default ListCustomer;