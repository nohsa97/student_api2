package api.response.controller;

import api.response.exceptions.CustomException;
import api.response.exceptions.ErrorCode;
import api.response.exceptions.InputRestriction;
import api.response.message.ApiResponse;
import api.response.message.Student;
import api.response.message.StudentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/school")
@RequiredArgsConstructor
public class BasicController {

    private final StudentRepository studentRepository;
    private ObjectMapper objectMapper = new ObjectMapper();


    @GetMapping("/list")
    @ResponseBody
    public ApiResponse<Student> getList() throws IOException {

        ApiResponse<Student> apiResponse = new ApiResponse<>();
        ApiResponse.Status ok = new ApiResponse.Status(ErrorCode.OK);
        ApiResponse.Metadata Mok = new ApiResponse.Metadata(studentRepository.size());

        apiResponse.setStatus(ok);
        apiResponse.setMetadata(Mok);
        apiResponse.setResults(studentRepository.findAll());

        return apiResponse;
    }

    @GetMapping("/{grade}")
    @ResponseBody
    public Object selected(@PathVariable int grade) throws IOException {

        if(grade > 5) {
            return new CustomException(ErrorCode.SERVER_ERROR, "Grade는 6이상을 입력할 수 없습니다.", new InputRestriction(6));
        }

        List<Student> selected = studentRepository.selected(grade);

        ApiResponse<Student> apiResponse = new ApiResponse<>();
        ApiResponse.Status ok = new ApiResponse.Status(ErrorCode.OK);
        ApiResponse.Metadata Mok = new ApiResponse.Metadata(Long.valueOf(selected.size()));

        apiResponse.setStatus(ok);
        apiResponse.setMetadata(Mok);
        apiResponse.setResults(selected);

        return apiResponse;
    }

    @PostMapping("/save")
    @ResponseBody
    public Object saveStudent(@RequestBody Student student) throws IOException {
        if(student.getGrade() > 5) {
            return new CustomException(ErrorCode.SERVER_ERROR, "Grade는 6이상을 입력할 수 없습니다.", new InputRestriction(6));
        }


        Student save = studentRepository.save(student);

        ApiResponse<Student> apiResponse = new ApiResponse<>();
        ApiResponse.Status ok = new ApiResponse.Status(ErrorCode.OK);
        ApiResponse.Metadata Mok = new ApiResponse.Metadata(studentRepository.size());
        List<Student> list = new ArrayList<>(studentRepository.findAll());


        apiResponse.setStatus(ok);
        apiResponse.setMetadata(Mok);
        apiResponse.setResults(list);

        return apiResponse;
    }
}
