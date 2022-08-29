import React, { useState } from "react";
import Doctor from "./Doctor";

const Doctors = ({ doctors }) => {
  return (
    <div className="department-wrapper">
      {doctors.map((doctor) => (
        <Doctor
          key={doctor.name}
          name={doctor.name}
          description={doctor.description}
          startTime={doctor.startTime}
          endTime={doctor.endTime}
        />
      ))}
    </div>
  );
};

export default Doctors;
