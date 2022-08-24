package model;

import com.sun.istack.NotNull;
import exception.NoGradesException;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @NotNull
    @OneToMany
    List<Grade> grades;

    public Integer getAnnualAverageGrade() throws NoGradesException {
        if(grades.isEmpty()) {
            throw new NoGradesException();
        }
        else {
            Integer averageGrade = 0;
            for(Grade grade : grades) {
                averageGrade += grade.getGrade();
            }
            return averageGrade/grades.size();
        }
    }

}
