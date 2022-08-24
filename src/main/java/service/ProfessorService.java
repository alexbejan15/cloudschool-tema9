package service;

import exception.ProfessorNotFoundException;
import lombok.RequiredArgsConstructor;

import model.Course;
import model.Professor;
import org.springframework.stereotype.Service;
import repository.ProfessorRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfessorService {
    private final ProfessorRepository professorRepository;

    public List<Course> getAllCoursesByProfessor(Integer professorId) throws ProfessorNotFoundException {
        Optional<Professor> optionalProfessor = professorRepository.findById(professorId);
        if(optionalProfessor.isEmpty()){
            throw new ProfessorNotFoundException();
        }
        else {
            return optionalProfessor.get().getCourses();
        }
    }
}
