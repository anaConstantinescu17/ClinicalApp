import React from "react";
import Button from "./Button";

const Header = ({ action, btnText, action2, showDepartments }) => {
  return (
    <div className="app-header">
      <h2 className="title">Unconventional clinic</h2>
      {!showDepartments && (
        <Button btnText="Departments" action={() => action2()} />
      )}
      <Button btnText={btnText} action={() => action()} />
    </div>
  );
};

export default Header;
