package controller;

import lombok.RequiredArgsConstructor;
import model.Course;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.CourseService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("course")
public class CourseController {
    private final CourseService courseService;

    @GetMapping("all/greaterThanThree")
    public List<Course> getAllCoursesWithCreditPointsGreaterThanThree() {
        return courseService.getAllCoursesWithCreditPointsGreaterThanThree();
    }
}
