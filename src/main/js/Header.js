import React from "react";
import Button from "./Button";
import { Link } from "react-router-dom";

const Header = () => {
  return (
    <div className="app-header">
      <h2 className="title">Unconventional clinic</h2>
      <Button btnText="Departments" action={() => console.log("Clicked!")} />
    </div>
  );
};

export default Header;
