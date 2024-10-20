package com.example.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Student getStudent(Long id){
        Optional<Student> student = studentRepository.findById(id);
        if (student.isEmpty()) {
            return null;
        }
        return student.get();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentByEmail=studentRepository.findStudentByEmail(student.getEmail());
        if (studentByEmail.isPresent()) {
            throw new IllegalStateException("email already in use");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        boolean exists = studentRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("student does not exist");
        }
        studentRepository.deleteById(id);
    }
    @Transactional
    public void updateStudent(Long studentId,String name,String email) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(()->new IllegalStateException(
                    "student with id "+studentId+" does not exist"));
        if (name!=null && name.length()>0 && !Objects.equals(student.getName(),name)) {

            student.setName(name);
        }
        if (email!=null && email.length()>0 && !Objects.equals(student.getEmail(),email)) {
            Optional<Student> studentByEmail=studentRepository.findStudentByEmail(email);
            if (studentByEmail.isPresent()) {
                throw new IllegalStateException("email already in use");
            }
            student.setEmail(email);
        }
        studentRepository.save(student);
    }
}
