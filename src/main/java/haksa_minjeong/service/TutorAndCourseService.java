package haksa_minjeong.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import haksa_minjeong.dto.Course;
import haksa_minjeong.dto.Tutor;
import haksa_minjeong.mapper.CourseMapper;
import haksa_minjeong.mapper.TutorMapper;

@Service
public class TutorAndCourseService {
	@Autowired
    private TutorMapper tMapper;

    @Autowired
    private CourseMapper cMapper;
    
    @Transactional
    public void trJoinTutorAndCourse(Tutor tutor, Course course) {
        int res = tMapper.insertTutor(tutor);
        res += cMapper.insertCourse(course);
        if (res !=2 ) throw new RuntimeException();
    }
    
    @Transactional
    public void trRemoveTutorAndCourse(int tutorId, int courseId) {
        int res = cMapper.deleteCourse(courseId);
        res += tMapper.deleteTutor(tutorId);
        if (res !=2 ) throw new RuntimeException();
    }

}
