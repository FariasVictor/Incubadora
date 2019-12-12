import React, { Component } from 'react';
import Field from '../components/Field';
import SubmitButtons from '../components/SubmitButtons';
import axios from '../utils/httpClient';

class Withdraw extends Component {
  state = {
    operationRequest: {
      value: ""
    },
    errors: []
  }
  
  retrieveAccountId = () => this.props.match.params.id

  handleSubmit = (event) => {
    event.preventDefault();
    axios
      .put(`withdraw/${this.retrieveAccountId()}`,this.state.operationRequest)
      .then(() => this.props.history.push("/"))
  }


  handleChange = event => {
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
          label="Valor do saque"
          value={this.state.operationRequest.value}
          onChange={this.handleChange}
          errors={errors["value"]} />
        <SubmitButtons />
      </form>
    );
  }
}

export default Withdraw;