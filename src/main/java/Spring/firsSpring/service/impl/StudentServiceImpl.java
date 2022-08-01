package Spring.firsSpring.service.impl;

import Spring.firsSpring.dto.ResponseDto;
import Spring.firsSpring.dto.StudentDto;
import Spring.firsSpring.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


@Service
public class StudentServiceImpl implements StudentService {

    public static ArrayList<StudentDto> students = new ArrayList<>();


    @Override
    public ResponseDto addStudent(StudentDto studentDto) {
        students.add(studentDto);

        return ResponseDto.builder()
                .code(0)
                .success(true)
                .message("Successfully saved")
                .build();
    }

    @Override
    public List<StudentDto> getAll() {

        return students;
    }

    @Override
    public ResponseDto updateStudent(StudentDto studentDto) {
        for (StudentDto s : students){
            if (s.getId().equals(studentDto.getId())){
                if (studentDto.getName() != null) s.setName(studentDto.getName());
                if (studentDto.getAge() != null) s.setAge(studentDto.getAge());
                if (studentDto.getBirthdate() != null) s.setBirthdate(studentDto.getBirthdate());
                if (studentDto.getCourse() != null) s.setCourse(studentDto.getCourse());

                return ResponseDto.builder()
                        .code(0)
                        .success(true)
                        .message("Successfully saved")
                        .build();
            }
        }

        return ResponseDto.builder()
                .code(-1)
                .success(false)
                .message("Data not found!")
                .build();
    }

    @Override
    public ResponseDto deleteStudent(Integer id) {
        CopyOnWriteArrayList<StudentDto> cw = new CopyOnWriteArrayList<>(students);

        for (StudentDto student : cw){
            if (student.getId().equals(id)){
                students.remove(student);
                return ResponseDto.builder()
                        .code(0)
                        .success(true)
                        .message("Successfully delet")
                        .build();
            }
        }

        return ResponseDto.builder()
                .code(-1)
                .success(false)
                .message("Data not found!")
                .build();
    }
}
