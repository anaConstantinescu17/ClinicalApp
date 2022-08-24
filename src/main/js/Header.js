import React from "react";
import Button from "./Button";

const Header = ({ action, btnText }) => {
  return (
    <div className="app-header">
      <h2 className="title">Unconventional clinic</h2>
      <Button btnText={btnText} action={() => action()} />
    </div>
  );
};

export default Header;
