import React, { useState } from "react";

const AddForm = ({ isOpen, close, resetDepartments }) => {
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
      method: "POST",
      body: JSON.stringify(inputs),
      headers: {
        "Content-type": "application/json; charset=UTF-8",
      },
    });
    close();
    resetDepartments();
  };

  if (!isOpen) return null;
  return (
    <div className="form-wrapper">
      <button onClick={() => close()}>X</button>
      <form onSubmit={handleSubmit}>
        <label>
          Enter department:
          <input
            type="text"
            name="name"
            value={inputs.name || ""}
            onChange={handleChange}
          />
        </label>
        <label>
          Enter description:
          <input
            type="text"
            name="description"
            value={inputs.description || ""}
            onChange={handleChange}
          />
        </label>
        <input type="submit" />
      </form>
    </div>
  );
};

export default AddForm;
