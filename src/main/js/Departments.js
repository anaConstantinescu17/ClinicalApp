import React, { useState } from "react";
import Department from "./Department";

const Departments = ({ departments, removeStateDepartment }) => {
  const [department, setDepartment] = useState();
  const handleDeleteDepartment = async (departmentName) => {
    await fetch(`/api/department/${departmentName}/delete`, {
      method: "DELETE",
    }).then(removeStateDepartment(departmentName));
  };

  return (
    <div className="department-wrapper">
      {departments.map((department) => (
        <Department
          key={department.name}
          name={department.name}
          description={department.description}
          deleteDepartment={handleDeleteDepartment}
        />
      ))}
    </div>
  );
};
export default Departments;
