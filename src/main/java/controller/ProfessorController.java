package controller;

import exception.ProfessorNotFoundException;
import lombok.RequiredArgsConstructor;
import model.Course;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.ProfessorService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("professor")
public class ProfessorController {
    private final ProfessorService professorService;

    @GetMapping("courses/{professorId}")
    public List<Course> getAllCoursesByProfessor(@PathVariable Integer professorId) throws ProfessorNotFoundException {
        return professorService.getAllCoursesByProfessor(professorId);
    }
}
