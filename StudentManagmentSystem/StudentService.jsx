const BASE_URL = "http://localhost:8080/Stdent";

// GET all students
export const getStudents = async () => {
  const res = await fetch(BASE_URL);

  if (!res.ok) {
    throw new Error("Failed to fetch students");
  }

  return await res.json();
};

// ADD student
export const addStudent = async (student) => {
  const res = await fetch(BASE_URL, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(student),
  });

  if (!res.ok) {
    throw new Error("Failed to add student");
  }

  return await res.json();
};

// DELETE student
export const deleteStudent = async (id) => {
  const res = await fetch(`${BASE_URL}/${id}`, {
    method: "DELETE",
  });

  if (!res.ok) {
    throw new Error("Failed to delete student");
  }
};

// UPDATE student
export const updateStudent = async (id, student) => {
  const res = await fetch(`${BASE_URL}/${id}`, {
    method: "PUT",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(student),
  });

  if (!res.ok) {
    throw new Error("Failed to update student");
  }

  return await res.json();
};