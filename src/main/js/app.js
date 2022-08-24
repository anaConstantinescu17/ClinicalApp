import React, { useState, useEffect } from "react";
import ReactDOM from "react-dom";
import Layout from "./Layout";
import Header from "./Header";
import Departments from "./Departments";
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";

const App = () => {
  const [departments, setDepartments] = useState([]);
  const [doctors, setDoctors] = useState();
  const [btnText, setBtnTxt] = useState("Departments");

  const getDepartmentsData = async () => {
    const request = await fetch("/api/department/all");
    const data = await request.json();
    setDepartments(data);
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
        console.log("Working on it...");
        break;
      }
    }
  };
  return (
    // <Router>
    //   <Layout>
    //     <Routes>
    //       <Route exact path="/" element={<Header />} />
    //       <Route exact path="/#/departments" element={<Departments />} />
    //     </Routes>
    //   </Layout>
    // </Router>

    <Layout>
      <Header action={handleBtnClick} btnText={btnText} />
      <Departments
        departments={departments}
        removeStateDepartment={removeStateDepartment}
      />
    </Layout>
  );
};

export default App;

ReactDOM.render(<App />, document.getElementById("react"));
