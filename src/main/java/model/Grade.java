package model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Grade {
    @Id
    Integer id;

    public Integer grade;
}
