import React from "react";

const Field = ({ name, label, value, errors, onChange }) =>

    <div className="form-group row col-sm-4">
        <label htmlFor={name}>{label}</label>
        <input type="text"
            name={name}
            className="form-control"
            value={value}
            onChange={onChange}
        />
        <span className="form-text text-danger">{errors}</span>       
    </div>


export default Field;