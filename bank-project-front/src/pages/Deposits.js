// import React, {Component} from 'react';
// import Field from '../components/Field'
// import SubmitButtons from '../components/SubmitButtons'
// import axios from '../utils/httpClient';

// class Deposits extends Component {
//   state = {
//     account: {
//       value: ""
//     },
//     errors: []
//   }

//   retrieveAccountId = () => this.props.match.params.id

//   handleSubmit = (event) => {
//     event.preventDefault();

//     axios.put(`/deposit/${this.retrieveAccountId()}`, this.state.account)
//     .then(() => this.props.history.push("/"))
//     //   .catch(({ response }) => {     if (response.status === 400) {
//     // this.setState({errors: response.data.errors})     }   })
//   }

//   handleChange = (event) => {
//     let field = event.target.name;
//     let value = event.target.value;

//     this.setState(({account}) => ({
//       account: {
//         ...account,
//         [field]: value
//       }
//     }))
//   }

//   render() {
//     const {account, errors} = this.state;
//     return (
//       <form onSubmit={this.handleSubmit}>
//         <Field
//           name="value"
//           label="Novo limite"
//           value={account.value}
//           // errors={errors[0].defaultMessage}
//           onChange={this.handleChange}/>
//         <SubmitButtons/>

//       </form>

//     )
//   }
// }

// export default Deposits;