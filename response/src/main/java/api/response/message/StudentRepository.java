package api.response.message;

import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {
    private static final Map<Long, Student> school = new HashMap<>();
    private static long seq = 0L;

    public List<Student> findAll() {
        List<Student> list = new ArrayList<>(school.values());
        Collections.sort(list, Comparator.comparing(Student::getGrade));

        return new ArrayList<>(list);
    }

    public List<Student> selected(int grade) {
        List<Student> list = new ArrayList<>(school.values());
        List<Student> selected = list.stream().filter(check -> check.getGrade() == grade).collect(Collectors.toList());
        Collections.sort(selected, Comparator.comparing(Student::getGrade));
        return new ArrayList<>(selected);
    }

    public Long size() {
        return seq;
    }

    public Student save(Student student) {
        school.put(++seq, student);
        return student;
    }


}
