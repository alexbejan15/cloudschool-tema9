package service;

import exception.NoGradesException;
import exception.SpecialtyNotFoundException;
import exception.StudentNotFoundException;
import lombok.RequiredArgsConstructor;
import model.Specialty;
import model.Student;
import org.springframework.stereotype.Service;
import repository.SpecialyRepository;
import repository.StudentRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SpecialyService {
    private final SpecialyRepository specialyRepository;
    private final StudentRepository studentRepository;

    public List<Student> getAllStudentsBySpecialty(Integer specialtyId) throws SpecialtyNotFoundException {
        Optional<Specialty> optionalSpecialty = specialyRepository.findById(specialtyId);

        if(optionalSpecialty.isEmpty()) {
            throw new SpecialtyNotFoundException();
        }
        else {
            return optionalSpecialty.get().getStudents();
        }
    }

    public Specialty getSpecialtyWithMostStudents() throws SpecialtyNotFoundException {
        Optional<Specialty> optionalSpecialty = specialyRepository.findAll()
                .stream()
                .max(Comparator.comparing(nr -> nr.getStudents().size()));
        if(optionalSpecialty.isEmpty()) {
            throw new SpecialtyNotFoundException();
        }
        else {
            return optionalSpecialty.get();
        }
    }

    public Integer getSpecialtyAverageGrade(Integer specialtyId) throws SpecialtyNotFoundException {
        Optional<Specialty> optionalSpecialty = specialyRepository.findById(specialtyId);
        if(optionalSpecialty.isEmpty()) {
            throw new SpecialtyNotFoundException();
        }
        else {
            Integer sum = optionalSpecialty.get().getStudents().stream().mapToInt(nr -> {
                try {
                    return nr.getAnnualAverageGrade();
                } catch (NoGradesException e) {
                    throw new RuntimeException(e);
                }
            }).sum();
            return sum / optionalSpecialty.get().getStudents().size();
        }
    }


    public Student getHighestGradedStudentBySpecialty(Integer specialtyId) throws SpecialtyNotFoundException, StudentNotFoundException {
        Optional<Specialty> optionalSpecialty = specialyRepository.findById(specialtyId);
        if(optionalSpecialty.isEmpty()) {
            throw new SpecialtyNotFoundException();
        }
        else {
            Optional<Student> optionalStudent = optionalSpecialty.get().getStudents()
                    .stream()
                    .max(Comparator.comparing(student -> {
                        try {
                            return student.getAnnualAverageGrade();
                        } catch (NoGradesException e) {
                            throw new RuntimeException(e);
                        }
                    }));
            if(optionalSpecialty.isEmpty()){
                throw new StudentNotFoundException();
            }
            else {
                return optionalStudent.get();
            }
        }
    }
}
