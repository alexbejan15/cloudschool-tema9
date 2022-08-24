package service;

import exception.NoGradesException;
import exception.StudentNotFoundException;
import lombok.RequiredArgsConstructor;
import model.Grade;
import model.Student;
import org.springframework.stereotype.Service;
import repository.StudentRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Grade> getAllGradesByStudent(Integer studendId) throws StudentNotFoundException {
        Optional<Student> optionalStudent = studentRepository.findById(studendId);
        if(optionalStudent.isEmpty()) {
            throw new StudentNotFoundException();
        }
        else {
            return optionalStudent.get().getGrades();
        }
    }

    public void addGrade(Grade grade, Integer studendId) throws StudentNotFoundException {
        Optional<Student> optionalStudent = studentRepository.findById(studendId);
        if(optionalStudent.isEmpty()) {
            throw new StudentNotFoundException();
        }
        else {
            optionalStudent.get().getGrades().add(grade);
            studentRepository.save(optionalStudent.get());
        }
    }

    public List<Student> getAllStudentsGradesGreaterThanEight() {
        return studentRepository.findAll().stream().filter((Student student) -> {
            try {
                return student.getAnnualAverageGrade() >= 8;
            } catch (NoGradesException e) {
                e.printStackTrace();
            }
            return false;
        }).collect(Collectors.toList());
    }

    public Student getHighestGradedStudent() {
        return studentRepository.findAll()
                .stream()
                .max(Comparator.comparing(student -> {
                    try {
                        return student.getAnnualAverageGrade();
                    } catch (NoGradesException e) {
                        throw new RuntimeException(e);
                    }
                })).get();
    }
}
