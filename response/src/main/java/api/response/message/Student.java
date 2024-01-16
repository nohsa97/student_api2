package api.response.message;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Student {
    private String name;
    private int grade;

    public Student() {
    }

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }
}
