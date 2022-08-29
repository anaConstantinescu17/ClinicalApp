import React, { useState } from "react";
import Doctor from "./Doctor";

const Doctors = ({ doctors, currentDepartmentName, getDoctorsData }) => {
  const handleDeleteDoctor = async (depName, doctor) => {
    await fetch(`/api/doctors/${depName}/delete`, {
      method: "DELETE",
      body: JSON.stringify(doctor),
      headers: {
        "Content-type": "application/json; charset=UTF-8",
      },
    }).then(() => getDoctorsData(currentDepartmentName));
  };
  return (
    <div className="department-wrapper">
      {doctors.map((doctor) => (
        <Doctor
          key={doctor.name}
          name={doctor.name}
          description={doctor.description}
          startTime={doctor.startTime}
          endTime={doctor.endTime}
          handleDeleteDoctor={handleDeleteDoctor}
          currentDepartmentName={currentDepartmentName}
        />
      ))}
    </div>
  );
};

export default Doctors;
