package controller;

import exception.StudentNotFoundException;
import lombok.RequiredArgsConstructor;
import model.Grade;
import model.Student;
import org.springframework.web.bind.annotation.*;
import service.StudentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("student")
public class StudentController {
    private final StudentService studentService;

    @GetMapping("grades/{studentId}")
    public List<Grade> getAllGradesByStudent(@PathVariable Integer studentId) throws StudentNotFoundException {
        return studentService.getAllGradesByStudent(studentId);
    }

    @PutMapping("grades/add/{studentId}/{grade}")
    public void addGrade(@PathVariable Grade grade, @PathVariable Integer studentId) throws StudentNotFoundException {
        studentService.addGrade(grade, studentId);
    }

    @GetMapping("gradesGreaterThanEight")
    public List<Student> getAllStudentsGradesGreaterThanEight(@PathVariable Integer id) {
        return studentService.getAllStudentsGradesGreaterThanEight();
    }

    @GetMapping("highestGraded")
    public Student getHighestGradedStudent() {
        return studentService.getHighestGradedStudent();
    }
}
