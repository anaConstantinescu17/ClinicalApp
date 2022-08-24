import React, { useState } from "react";
import Button from "./Button";

const Department = ({ name, description, deleteDepartment }) => {
  const [isHover, setIsHover] = useState(false);

  return (
    <div
      className="department-card"
      onMouseEnter={() => setIsHover(true)}
      onMouseLeave={() => setIsHover(false)}
    >
      <h1>{name}</h1>
      <p>{description}</p>
      {isHover && (
        <button
          onClick={() => deleteDepartment(name)}
          className="delete-department-btn"
        >
          X
        </button>
      )}
      <Button
        onClick={() => console.log("dasd")}
        btnText="Check the department"
      />
    </div>
  );
};

export default Department;
