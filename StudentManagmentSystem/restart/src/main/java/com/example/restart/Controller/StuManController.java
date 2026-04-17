package com.example.restart.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restart.Entity.StudentMan;
import com.example.restart.Services.StudentManServices;

@RestController
@RequestMapping("Stdent")
@CrossOrigin(origins = "http://localhost:5173")
public class StuManController {

    public final StudentManServices sms;

    public StuManController(StudentManServices sms) {
        this.sms = sms;
    }

    // GET all students → GET /Stdent
    @GetMapping
    public List<StudentMan> get() {
        return sms.getInfo();
    }

    // GET student by ID → GET /Stdent/{id}
    @GetMapping("/{id}")
    public ResponseEntity<StudentMan> getById(@PathVariable Long id) {
        StudentMan student = sms.FindById(id);
        if (student != null) {
            return ResponseEntity.ok(student);
        }
        return ResponseEntity.notFound().build();
    }

    // POST create new student → POST /Stdent
    @PostMapping
    public StudentMan post(@RequestBody StudentMan pos) {
        return sms.saveInfo(pos);
    }

    // PUT update student by ID → PUT /Stdent/{id}
    @PutMapping("/{id}")
    public ResponseEntity<StudentMan> update(@PathVariable Long id, @RequestBody StudentMan stu) {
        try {
            StudentMan updated = sms.updateinfo(id, stu);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE student by ID → DELETE /Stdent/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        StudentMan student = sms.FindById(id);
        if (student != null) {
            sms.delById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}