import React, { Component } from 'react';
import Field from '../components/Field';
import SubmitButtons from '../components/SubmitButtons';
import axios from '../utils/httpClient';

class Deposit extends Component {
  state = {
    operationRequest: {
      value: ""
    },
    errors: []
  }

  retrieveAccount = () => this.props.match.params.id;
  
  handleSubmit = (event) => {
    event.preventDefault();
    axios.put(`/deposit/${this.retrieveAccount()}`, this.state.operationRequest)
      .then(()=>this.props.history.push("/"))
      .catch(({ response }) => {
        if (response.status === 400) {
          this.setState({ errors: response.data })
        }
      })
  }

  handleChange = (event) => {
    let field = event.target.name
    let value = event.target.value

    this.setState(({ operationRequest }) => ({
      operationRequest: {
        ...operationRequest,
        [field]: value
      }
    }));
  }

  render() {
    const { operationRequest, errors } = this.state;
    return (
      <form onSubmit={this.handleSubmit}>
        <Field
          name="value"
          label="Valor do depósito"
          value={
            operationRequest.value}
          onChange={this.handleChange}
          errors={errors["value"]} />
        <SubmitButtons />
      </form>
    );
  }
}

export default Deposit;