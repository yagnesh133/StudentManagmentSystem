package com.example.restart.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class StudentMan {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
private String name;
private Long rollNo;
  public StudentMan(){

  }
  public StudentMan(String name,Long rollNo){
    this.name=name;
    this.rollNo=rollNo;
  }
  public Long getId(){
    return id; 
  }
 public void setName(String name){
    this.name=name;
 }
 public String getName(){
    return name;
 }
 public void setRollNo(Long rollNo) {   
    this.rollNo = rollNo;
}

public Long getRollNo() {              
    return rollNo;
}
 
}
