package service;

import lombok.RequiredArgsConstructor;
import model.Course;
import org.springframework.stereotype.Service;
import repository.CourseRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    public List<Course> getAllCoursesWithCreditPointsGreaterThanThree() {
        return  courseRepository.findAll().stream().filter((Course course) -> {return course.getCreditPoints()>=3;})
                .collect(Collectors.toList());
    }
}
