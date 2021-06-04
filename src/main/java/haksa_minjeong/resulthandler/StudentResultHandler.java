package haksa_minjeong.resulthandler;

import java.util.Map;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;

import haksa_minjeong.dto.Student;

public class StudentResultHandler implements ResultHandler<Student> {
	private Map<Integer, String> map;
    
    public StudentResultHandler(Map<Integer, String> map) {
        this.map = map;
    }

	@Override
	public void handleResult(ResultContext<? extends Student> resultContext) {
		Student student = resultContext.getResultObject();
        map.put(student.getStudId(), student.getName());        
	}

}