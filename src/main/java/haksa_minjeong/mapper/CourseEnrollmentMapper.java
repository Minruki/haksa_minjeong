package haksa_minjeong.mapper;

import java.util.Map;

import haksa_minjeong.dto.CourseEnrollment;

public interface CourseEnrollmentMapper {
	CourseEnrollment selectCourseEnrollmentById(CourseEnrollment courseEnrollment);

	int insertCourseEnrollment(CourseEnrollment courseEnrollment);

	int updateCourseEnrollment(Map<String, Integer> map);

	int deleteCourseEnrollment(CourseEnrollment courseEnrollment);
}
