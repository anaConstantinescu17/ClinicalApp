import React from "react";
import Department from "./Department";

const Departments = ({ departments }) => {
  return (
    <div className="department-wrapper">
      {departments.map((department) => (
        <Department
          key={department.name}
          name={department.name}
          description={department.description}
        />
      ))}
    </div>
  );
};
export default Departments;
