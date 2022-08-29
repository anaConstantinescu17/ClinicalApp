import React, { useState, useEffect } from "react";
import ReactDOM from "react-dom";
import Layout from "./Layout";
import Header from "./Header";
import Departments from "./Departments";
import { BrowserRouter, Routes, Route, Link } from "react-router-dom";
import AddDepartmentForm from "./AddDepartmentForm";
import Doctors from "./Doctors";
import AddDoctorForm from "./AddDoctorForm";

const App = () => {
  const [departments, setDepartments] = useState([]);
  const [doctors, setDoctors] = useState([]);
  const [btnText, setBtnTxt] = useState("Departments");
  const [departmentForm, setDepartmentForm] = useState(false);
  const [doctorForm, setDoctorForm] = useState(false);
  const [showDepartments, setShowDepartments] = useState(true);
  const [currentDepartmentName, setCurrentDepartmentName] = useState("");

  const getDepartmentsData = async () => {
    const request = await fetch("/api/department/all");
    const data = await request.json();
    setDepartments(data);
  };

  const getDoctorsData = async (departmentName) => {
    const request = await fetch(`/api/department/${departmentName}/doctors`);
    const data = await request.json();
    setDoctors(data);
    setShowDepartments(false);
  };

  const removeStateDepartment = (departmentName) => {
    const newDepartments = departments.filter(
      (department) => department.name !== departmentName
    );
    setDepartments(newDepartments);
  };

  const handleBtnClick = () => {
    switch (btnText) {
      case "Departments": {
        getDepartmentsData();
        setBtnTxt("Add Department");
        break;
      }
      case "Add Department": {
        setDepartmentForm(true);
        break;
      }
      case "Add Doctor": {
        setDoctorForm(true);
        break;
      }
    }
  };

  return (
    // <Layout>
    //   <Routes>
    //     <Route
    //       exact
    //       path="/"
    //          element={<Header action={handleBtnClick} btnText={btnText} />}

    //      // element={<div>header</div>}
    //     />
    //     <Route
    //       exact
    //       path="/departments"
    //       element={
    //         // <Departments
    //         //   artments={departments}
    //         //   removeStateDepartment={removeStateDepartment}
    //         // />
    //         <div>dep</div>
    //       }
    //     />
    //   </Routes>
    // </Layout>

    <Layout>
      <Header
        action={handleBtnClick}
        btnText={btnText}
        action2={setShowDepartments}
        showDepartments={showDepartments}
        setBtnTxt={setBtnTxt}
      />

      {showDepartments && (
        <Departments
          departments={departments}
          removeStateDepartment={removeStateDepartment}
          getDoctorsData={getDoctorsData}
          setBtnTxt={setBtnTxt}
          setCurrentDepartmentName={setCurrentDepartmentName}
        />
      )}
      <AddDepartmentForm
        isOpen={departmentForm}
        close={() => setDepartmentForm(false)}
        resetDepartments={() => getDepartmentsData()}
      />

      <AddDoctorForm
        isOpen={doctorForm}
        close={() => setDoctorForm(false)}
        resetDoctors={() => getDoctorsData(currentDepartmentName)}
        currentDepartmentName={currentDepartmentName}
      />

      {!showDepartments && (
        <Doctors
          doctors={doctors}
          currentDepartmentName={currentDepartmentName}
          getDoctorsData={getDepartmentsData}
        />
      )}
    </Layout>
  );
};

export default App;

ReactDOM.render(
  <BrowserRouter>
    <App />
  </BrowserRouter>,
  document.getElementById("react")
);
