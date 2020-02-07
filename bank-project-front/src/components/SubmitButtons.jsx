import React from 'react';
import {Link} from 'react-router-dom';

const SubmitButtons = () => (
  <div className="btn-group">
    <Link to="/" className="btn btn-primary">Voltar</Link>
    <button type="submit" className="btn btn-success">Enviar</button>
  </div>
);

export default SubmitButtons;