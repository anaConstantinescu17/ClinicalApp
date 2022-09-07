import React, { useState, useEffect } from "react";
import ReactDOM from "react-dom";
import Layout from "./Layout";
import Header from "./Header";
import Departments from "./Departments";
import {BrowserRouter, Routes, Route, Link, HashRouter, useNavigate} from "react-router-dom";
import AddDepartmentForm from "./AddDepartmentForm";
import Doctors from "./Doctors";
import AddDoctorForm from "./AddDoctorForm";

const App = () => {
  const [departments, setDepartments] = useState([]);
  const [doctors, setDoctors] = useState([]);
  const [btnText, setBtnTxt] = useState("Departments");
  const [departmentForm, setDepartmentForm] = useState(false);
  const [doctorForm, setDoctorForm] = useState(false);
  const [currentDepartmentName, setCurrentDepartmentName] = useState("");
  const navigate = useNavigate();

  const getDepartmentsData = async () => {
    const request = await fetch("/api/department/all");
    const data = await request.json();
    setDepartments(data);
  };

  function goToDepartments() {
    navigate("/departments", { replace: true })
  }

  const getDoctorsData = async (departmentName) => {
    const request = await fetch(`/api/department/${departmentName}/doctors`);
    const data = await request.json();
    setDoctors(data);
    // setShowDepartments(false);
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
    <Layout>
      <Header/>
      <Routes>
        <Route path="/" element={<div>Welcome!</div>} />
        <Route path="departments"
           element={
             <Departments
              departments={departments}
              removeStateDepartment={removeStateDepartment}
              getDoctorsData={getDoctorsData}
              setBtnTxt={setBtnTxt}
              setCurrentDepartmentName={setCurrentDepartmentName}
             />
           }
        />
        <Route path="add-departments"
           element={
             <AddDepartmentForm
               close={() => goToDepartments()}
               resetDepartments={() => {
                 getDepartmentsData();
                 navigate("/departments", { replace: true });
               }}
             />
           }
        />
      </Routes>



      <AddDoctorForm
        isOpen={doctorForm}
        close={() => setDoctorForm(false)}
        resetDoctors={() => getDoctorsData(currentDepartmentName)}
        currentDepartmentName={currentDepartmentName}
      />

      {/*{!showDepartments && (*/}
        <Doctors
          doctors={doctors}
          currentDepartmentName={currentDepartmentName}
          getDoctorsData={getDoctorsData}
        />
      {/*)}*/}
    </Layout>
  );
};



export default App;

ReactDOM.render(
  <HashRouter>
    <App />
  </HashRouter>,
  document.getElementById("react")
);
