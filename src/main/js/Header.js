import React from "react";
import Button from "./Button";
import {Link, useLocation} from 'react-router-dom';

const Header = ({}) => {
    const location = useLocation();
    let button = null;
    const departmentsButton = <Link to="/departments"><Button btnText="Departments"/></Link>;
    switch (location.pathname) {
        case "/departments": {
            button = <Link to="/add-departments"><Button btnText="Add department"/></Link>;
            break;
        }
        case "/add-departments": {
            button = departmentsButton;
            break;
        }
        default:
            button = departmentsButton;
    }
  return (
    <div className="app-header">
      <h2 className="title">Unconventional clinic6</h2>
      {button}
    </div>
  );
};

export default Header;
