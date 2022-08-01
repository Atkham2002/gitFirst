package Spring.firsSpring.controller;

import Spring.firsSpring.dto.ResponseDto;
import Spring.firsSpring.dto.StudentDto;
import Spring.firsSpring.service.impl.StudentServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentServiceImpl studentService;

    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseDto addStudent(@RequestBody StudentDto studentDto){
        StudentDto StudentDto;
        return studentService.addStudent(studentDto);

    }

    @GetMapping
    public List<StudentDto> getStudent(){

        return studentService.getAll();
    }


    //Patch Put
    @PatchMapping
    public ResponseDto updateStudent(@RequestBody StudentDto studentDto){

        return studentService.updateStudent(studentDto);
    }

    @DeleteMapping("/{id}")
    public ResponseDto delete(@PathVariable Integer id){
        return studentService.deleteStudent(id);
    }
}
