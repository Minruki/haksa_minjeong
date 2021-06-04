package haksa_minjeong.service;

import java.util.Map;

import haksa_minjeong.dto.Student;

public interface StudentService {
	Map<Integer, Student>  selectStudentForMap();
	
	Map<Integer, String>  selectStudentForMap(int studId);
    Map<Integer, Student> selectStudentForMap2(int studId);
}