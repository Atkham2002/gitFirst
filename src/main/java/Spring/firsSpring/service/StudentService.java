package Spring.firsSpring.service;

import Spring.firsSpring.dto.ResponseDto;
import Spring.firsSpring.dto.StudentDto;

import java.util.List;

public interface StudentService {

    ResponseDto addStudent(StudentDto studentDto);

    List<StudentDto> getAll();

    ResponseDto updateStudent(StudentDto studentDto);

    ResponseDto deleteStudent(Integer id);
}
