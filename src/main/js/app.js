import React, { useState, useEffect } from "react";
import ReactDOM from "react-dom";
import Layout from "./Layout";
import Header from "./Header";
import Departments from "./Departments";
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";

const App = () => {
  const [departments, setDepartments] = useState([]);
  const [doctors, setDoctors] = useState();

  useEffect(() => {
    const getDepartmentsData = async () => {
      const request = await fetch("/api/department/all");
      const data = await request.json();
      setDepartments(data);
    };
    getDepartmentsData();
  }, []);
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
      <Header />
      <Departments departments={departments} />
    </Layout>
  );
};

export default App;

ReactDOM.render(<App />, document.getElementById("react"));
