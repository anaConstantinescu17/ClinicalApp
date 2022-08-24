import React from "react";

const Button = ({ btnText, action }) => (
  <button className="actionBtn" onClick={action}>
    {btnText}
  </button>
);

export default Button;
