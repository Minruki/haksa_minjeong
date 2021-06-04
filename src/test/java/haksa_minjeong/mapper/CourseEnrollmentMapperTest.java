package haksa_minjeong.mapper;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import haksa_minjeong.config.ContextRoot;
import haksa_minjeong.dto.Course;
import haksa_minjeong.dto.CourseEnrollment;
import haksa_minjeong.dto.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ContextRoot.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CourseEnrollmentMapperTest {
	private static final Log log = LogFactory.getLog(TutorMapperTest.class);
	@Autowired
	private CourseEnrollmentMapper mapper;

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test01SelectCourseEnrollmentById() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		CourseEnrollment courseEnrollment = new CourseEnrollment(new Student(1), new Course(1));
		CourseEnrollment res = mapper.selectCourseEnrollmentById(courseEnrollment);
		Assert.assertNotNull(res);
	}

	@Test
	public void test02InsertCourseEnrollment() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		CourseEnrollment newCourseEnrollment = new CourseEnrollment(new Student(1), new Course(3));
		int res = mapper.insertCourseEnrollment(newCourseEnrollment);
		Assert.assertEquals(1, res);
	}

	@Test
	public void test03UpdateCourseEnrollment() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("old_courseId", 3);
		map.put("old_studId", 1);
		map.put("new_courseId", 3);
		map.put("new_studId", 2);
		int res = mapper.updateCourseEnrollment(map);
		Assert.assertEquals(1, res);
	}

	@Test
	public void test04DeleteCourseEnrollment() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		CourseEnrollment delCourseEnrollment = new CourseEnrollment(new Student(2), new Course(3));
		int res = mapper.deleteCourseEnrollment(delCourseEnrollment);
		Assert.assertEquals(1, res);
	}
}