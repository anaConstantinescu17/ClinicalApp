import React, { useState } from "react";

const AddDepartmentForm = ({ close, resetDepartments }) => {
  const [inputs, setInputs] = useState({});

  const handleChange = (event) => {
    const name = event.target.name;
    const value = event.target.value;
    setInputs((values) => ({ ...values, [name]: value }));
  };

  const handleSubmit = async (event) => {
    event.preventDefault();

    console.log(JSON.stringify(inputs));
    await fetch("/api/department/add", {
      method: "PUT",
      body: JSON.stringify(inputs),
      headers: {
        "Content-type": "application/json; charset=UTF-8",
      },
      credentials: 'include',
    });
    close();
    resetDepartments();
  };

  // const styles = {
  //   display: "flex",
  //   alignItems: "center",
  //   justifyContent: "center",
  //   height: "100vh",
  // };

  return (
    <div className="form-wrapper">
      <button onClick={() => close()} className="delete-department-btn">
        X
      </button>
      <form onSubmit={handleSubmit}>
        <label>
          <h2 className="title">Enter department:</h2>
          <br></br>
          <input
            type="text"
            name="name"
            value={inputs.name || ""}
            onChange={handleChange}
            className="pressBtn"
          />
        </label>
        <label>
          <h2 className="title">Enter description:</h2>
          <br></br>
          <input
            type="text"
            name="description"
            value={inputs.description || ""}
            onChange={handleChange}
            className="pressBtn"
          />
        </label>
        <input type="submit" value="Submit" className="actionBtn" />
      </form>
    </div>
  );
};

export default AddDepartmentForm;
