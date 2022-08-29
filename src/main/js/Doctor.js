import React, { useState } from "react";
import Button from "./Button";

const Doctor = ({
  name,
  description,
  startTime,
  endTime,
  handleDeleteDoctor,
  currentDepartmentName,
}) => {
  const [isHoverDoctor, setIsHoverDoctor] = useState(false);
  return (
    <div
      className="department-card"
      onMouseEnter={() => setIsHoverDoctor(true)}
      onMouseLeave={() => setIsHoverDoctor(false)}
    >
      <h1>{name}</h1>
      <p>{description}</p>
      <p>{startTime}</p>
      <p>{endTime}</p>
      {isHoverDoctor && (
        <button
          onClick={() => handleDeleteDoctor(currentDepartmentName)}
          className="delete-department-btn"
        >
          X
        </button>
      )}
      <Button action={() => console.log("dasd")} btnText="Appointment" />
    </div>
  );
};

export default Doctor;
