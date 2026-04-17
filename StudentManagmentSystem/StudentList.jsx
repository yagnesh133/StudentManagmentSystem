import { useEffect, useState } from "react";
import { getStudents, deleteStudent } from "./StudentService";

function StudentList({ onEdit, reload }) {
  const [students, setStudents] = useState([]);

  const loadStudents = async () => {
    const data = await getStudents();
    setStudents(data);
  };

  useEffect(() => {
    loadStudents();
  }, [reload]);

  const handleDelete = async (id) => {
    await deleteStudent(id);
    loadStudents();
  };

  return (
    <div>
      <h2>📋 Student List</h2>

      <table border="1" style={{ margin: "auto" }}>
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>RollNo</th>
            <th>Actions</th>
          </tr>
        </thead>

        <tbody>
          {students.length > 0 ? (
            students.map((s) => (
              <tr key={s.id}>
                <td>{s.id}</td>
                <td>{s.name}</td>
                <td>{s.rollNo}</td>
                <td>
                  <button onClick={() => onEdit(s)}>Edit</button>
                  <button onClick={() => handleDelete(s.id)}>
                    Delete
                  </button>
                </td>
              </tr>
            ))
          ) : (
            <tr>
              <td colSpan="4">No students found</td>
            </tr>
          )}
        </tbody>
      </table>
    </div>
  );
}

export default StudentList;