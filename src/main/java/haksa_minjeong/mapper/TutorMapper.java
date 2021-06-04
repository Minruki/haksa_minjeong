package haksa_minjeong.mapper;

import haksa_minjeong.dto.Tutor;

public interface TutorMapper {
	Tutor selectTutorByTutorId(Tutor tutor);

	/* Transaction */
	Tutor selectTutorById(Tutor tutor);

	int insertTutor(Tutor tutor);

	int deleteTutor(int tutorId);

}