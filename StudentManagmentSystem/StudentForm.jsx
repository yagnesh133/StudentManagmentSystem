import { useState, useEffect } from "react";
import { addStudent, updateStudent } from "./StudentService";

function StudentForm({ selectedStudent, refresh }) {
  const [student, setStudent] = useState({
    name: "",
    email: "",
  });

  useEffect(() => {
    if (selectedStudent) {
      setStudent(selectedStudent);
    }
  }, [selectedStudent]);

  const handleChange = (e) => {
    setStudent({ ...student, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (student.id) {
      await updateStudent(student.id, student);
    } else {
      await addStudent(student);
    }

    refresh();
    setStudent({ name: "", email: "" });
  };

  return (
    <div style={{ marginBottom: "20px" }}>
      <h2>{student.id ? "✏️ Edit Student" : "➕ Add Student"}</h2>

      <form onSubmit={handleSubmit}>
        <input
          type="text"
          name="name"
          value={student.name}
          onChange={handleChange}
          placeholder="Enter Name"
        />

        <input
          type="email"
          name="email"
          value={student.email}
          onChange={handleChange}
          placeholder="Enter Email"
        />

        <button type="submit">Save</button>
      </form>
    </div>
  );
}

export default StudentForm;