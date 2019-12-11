import React, {Component} from 'react';
import Field from '../components/Field'
import {Link} from 'react-router-dom'

import SubmitButtons from '../components/SubmitButtons'

import axios from '../utils/httpClient';

class EditAccount extends Component {
  state = {
    account: {
      maxOverdraft: "",
      id: ""
    },
    errors: []
  }

  retrieveAccountId = () => this.props.match.params.id

  handleSubmit = (event) => {
    event.preventDefault();

    axios.put(`/${this.retrieveAccountId()}`, this.state.account).then(() => this.props.history.push("/"))
    //   .catch(({ response }) => {     if (response.status === 400) {
    // this.setState({errors: response.data})     }   })
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

  render() {
    const {book, errors} = this.state;
    return (
      <form onSubmit={this.handleSubmit}>
        <Field
          name="maxOverdraft"
          label="Novo limite"
          value={this.state.account.maxOverdraft}
          errors={errors["maxOverdraft"]}
          onChange={this.handleChange}/>
        <SubmitButtons/>

      </form>

    )
  }
}

export default EditAccount;