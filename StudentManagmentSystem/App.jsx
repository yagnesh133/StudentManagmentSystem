import { useState } from "react";
import StudentList from "./StudentList";
import StudentForm from "./StudentForm";

function App() {
  const [selectedStudent, setSelectedStudent] = useState(null);
  const [reload, setReload] = useState(false);

  const refresh = () => {
    setReload(!reload);
    setSelectedStudent(null);
  };

  return (
    <div style={{ textAlign: "center" }}>
      <h1>📚 Student Management System</h1>

      <StudentForm selectedStudent={selectedStudent} refresh={refresh} />

      <hr />

      <StudentList
        reload={reload}
        onEdit={(student) => setSelectedStudent(student)}
      />
    </div>
  );
}

export default App;