import React, { Component } from 'react';
import axios from '../utils/httpClient';

import Field from '../components/Field';
import SubmitButtons from '../components/SubmitButtons';

class NewAccount extends Component {
  state = {
    account: {
      balance: "",
      maxOverdraft: ""
    },
    errors: [],
  }
  handleChange = (event) => {
    let field = event.target.name;
    let value = event.target.value;

    this.setState(({ account }) => ({
      account: {
        ...account,
        [field]: value
      }
    }))
  }

  handleSubmit = (event) => {
    event.preventDefault();
    axios
      .post("/", this.state.account)
      .then(() => this.props.history.push("/"))
      .catch(({ response }) => {
        if (response.status === 400) {
          this.setState({ errors: response.data})
        }
      })
  }

  render() {
    const { account, errors } = this.state;

    return (
      <div>
        <form onSubmit={this.handleSubmit}>
          <Field
            name="balance"
            label="Saldo"
            value={account.balance}
            onChange={this.handleChange}
            errors={errors["balance"]}
            //?.charAt(0)+errors["balance"]?.slice(1) } 
            // errors["balance"]?.charAt(0).toUpperCase()
            />
          <Field
            name="maxOverdraft"
            label="Limite"
            value={account.maxOverdraft}
            onChange={this.handleChange} 
            errors={errors["maxOverdraft"]}
            />
          <SubmitButtons />
          {/* {this.errorsListing(errors).map(
            message.replace(message.charAt(0),message.charAt(0).toUpperCase)
            (message) => <span className="form-text text-danger">{message.charAt(0).toUpperCase() + message.slice(1)}</span>
          )} */}
        </form>
      </div>
    );
  }
}

export default NewAccount;