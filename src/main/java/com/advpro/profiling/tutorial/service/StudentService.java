package com.advpro.profiling.tutorial.service;

import com.advpro.profiling.tutorial.model.Student;
import com.advpro.profiling.tutorial.model.StudentCourse;
import com.advpro.profiling.tutorial.repository.StudentCourseRepository;
import com.advpro.profiling.tutorial.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.Comparator;

/**
 * @author muhammad.khadafi
 */
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentCourseRepository studentCourseRepository;


    public List<StudentCourse> getAllStudentsWithCourses() {
        List<Student> students = studentRepository.findAll();

        Map<Long, Student> studentMap = students.stream()
                .collect(Collectors.toMap(Student::getId, student -> student));

        List<StudentCourse> allStudentCourses = studentCourseRepository.findByStudentIdIn(
                studentMap.keySet());

        return allStudentCourses.stream()
            .map(sc -> {
                if (sc.getStudent() != null && sc.getStudent().getId() != null) {
                    sc.setStudent(studentMap.get(sc.getStudent().getId()));
                }
                return sc;
            })
            .collect(Collectors.toList());
    }

    public Optional<Student> findStudentWithHighestGpa() {
        return studentRepository.findTopByOrderByGpaDesc();
    }

    public String joinStudentNames() {
        List<Student> students = studentRepository.findAll();

        return students.stream()
                .map(Student::getName)
                .collect(Collectors.joining(", "));
    }
}

