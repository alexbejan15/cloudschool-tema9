package controller;

import exception.SpecialtyNotFoundException;
import exception.StudentNotFoundException;
import lombok.RequiredArgsConstructor;
import model.Specialty;
import model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.SpecialyService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("specialty")
public class SpecialtyController {
    private final SpecialyService specialyService;

    @GetMapping("all/{specialtyId}")
    public List<Student> getAllStudentsBySpecialty(@PathVariable Integer specialtyId) throws SpecialtyNotFoundException {
        return specialyService.getAllStudentsBySpecialty(specialtyId);
    }

    @GetMapping("withMostStudents")
    public Specialty getSpecialtyWithMostStudents() throws SpecialtyNotFoundException {
        return specialyService.getSpecialtyWithMostStudents();
    }

    @GetMapping("averageGrade/{specialyId}")
    public Integer getSpecialtyAverageGrade(@PathVariable Integer specialyId) throws SpecialtyNotFoundException {
        return specialyService.getSpecialtyAverageGrade(specialyId);
    }

    @GetMapping("highestGradedStudentBySpecialty/{specialtyId}")
    public Student getHighestGradedStudentBySpecialty(@PathVariable Integer specialtyId) throws StudentNotFoundException, SpecialtyNotFoundException {
        return specialyService.getHighestGradedStudentBySpecialty(specialtyId);
    }
}
