import React, { useState } from "react";
import Doctor from "./Doctor";

const Doctors = ({ doctors, currentDepartmentName, getDoctorsData }) => {
  const [doctor, setDoctor] = useState();
  const handleDeleteDoctor = async (depName) => {
    await fetch(`/api/doctor/${depName}/delete`, {
      method: "DELETE",
      body: JSON.stringify(doctor),
      headers: {
        "Content-type": "application/json; charset=UTF-8",
      },
    }).then(getDoctorsData());
  };
  return (
    <div className="department-wrapper">
      {doctors.map(
        (doctor) => (
          setDoctor(doctor),
          (
            <Doctor
              key={doctor.name}
              name={doctor.name}
              description={doctor.description}
              startTime={doctor.startTime}
              endTime={doctor.endTime}
              handleDeleteDoctor={handleDeleteDoctor}
              currentDepartmentName={currentDepartmentName}
            />
          )
        )
      )}
    </div>
  );
};

export default Doctors;
