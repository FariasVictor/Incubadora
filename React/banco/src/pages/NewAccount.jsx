import React, {Component} from 'react';
import axios from '../utils/httpClient';

import Field from '../components/Field';
import SubmitButtons from '../components/SubmitButtons';

class NewAccount extends Component {
  state = {
    account: {
      balance: "",
      availableOverdraft: "",
      maxOverdraft: ""
    },
    errors: {},
    globalError: ""
  }
  handleChange = (event) => {
    let field = event.target.name;
    let value = event.target.value;

    this.setState(({account}) => ({
      account: {
        ...account,
        [field]: value
      }
    }))
  }

  handleSubmit = (event) => {
    axios
      .post("/", this.state.account)
      .then(() => this.props.history.push("/"))
    event.preventDefault();
  }

  render() {
    const {account, errors, globalError} = this.state;
    return (
      <div>
        <form onSubmit={this.handleSubmit}>
          <Field
            name="balance"
            label="Saldo"
            value={account.balance}
            errors={errors["balance"]}
            onChange={this.handleChange}/>
          <Field
            name="maxOverdraft"
            label="Limite"
            value={account.maxOverdraft}
            errors={errors["maxOverdraft"]}
            onChange={this.handleChange}/>
          <input type="hidden" name="availableOverdraft" value={account.maxOverdraft}/>
          
          <SubmitButtons/>
         
        </form>
      </div>
    );
  }
}

export default NewAccount;