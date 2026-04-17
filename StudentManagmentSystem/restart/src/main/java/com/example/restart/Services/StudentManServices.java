package com.example.restart.Services;

import java.util.List;


import java.util.Optional;
import org.springframework.stereotype.Service;

import com.example.restart.Entity.StudentMan;
import com.example.restart.repository.StudentManrepository;

@Service
public class StudentManServices {
 public final StudentManrepository smRepo;
 public StudentManServices(StudentManrepository smRepo){
     this.smRepo=smRepo;
 }
 public StudentMan saveInfo(StudentMan stu){
    return smRepo.save(stu);
 }
  public List<StudentMan> getInfo(){
    return smRepo.findAll();
  }
  public StudentMan FindById(Long Id){
   return smRepo.findById(Id).orElse(null);
  }
  public void delById(Long Id){
     smRepo.deleteById(Id);
  }
  public StudentMan updateinfo(Long Id,StudentMan stu){
    Optional<StudentMan>stuopt=smRepo.findById(Id);
    if(stuopt.isPresent()){
      StudentMan val=stuopt.get();
      val.setName(stu.getName());
      val.setRollNo(stu.getRollNo());
      return smRepo.save(val);
    }
    else{
         throw new RuntimeException("Student not found with id: " + Id);
    }
  }
}
