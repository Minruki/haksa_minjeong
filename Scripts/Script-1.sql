drop database if exists haksa_minjeong;
create database if not exists haksa_minjeong;

-- 주소
CREATE TABLE haksa_minjeong.addresses (
	addr_id INT(11)     NOT NULL COMMENT '주소코드', -- 주소코드
	street  VARCHAR(50) NOT NULL COMMENT '도로', -- 도로
	city    VARCHAR(50) NOT NULL COMMENT '시', -- 시
	state   VARCHAR(50) NOT NULL COMMENT '구', -- 구
	zip     VARCHAR(10) NULL     COMMENT '우편번호', -- 우편번호
	country VARCHAR(50) NOT NULL COMMENT '읍' -- 읍
)
COMMENT '주소';

-- 주소
ALTER TABLE haksa_minjeong.addresses
	ADD CONSTRAINT PK_addresses -- 주소 기본키
		PRIMARY KEY (
			addr_id -- 주소코드
		);

-- 학생
CREATE TABLE haksa_minjeong.students (
	stud_id  INT(11)     NOT NULL COMMENT '학생코드', -- 학생코드
	name     VARCHAR(50) NOT NULL COMMENT '이름', -- 이름
	email    VARCHAR(50) NOT NULL COMMENT '이메일', -- 이메일
	phone    VARCHAR(15) NULL     COMMENT '연락처', -- 연락처
	dob      DATE        NULL     COMMENT '생일', -- 생일
	bio      LONGTEXT    NULL     COMMENT '자기소개', -- 자기소개
	pic      BLOB        NULL     COMMENT '사진', -- 사진
	addr_id  INT(11)     NULL     COMMENT '주소', -- 주소
	addr_id2 INT(11)     NULL     COMMENT '주소코드' -- 주소코드
)
COMMENT '학생';

-- 학생
ALTER TABLE haksa_minjeong.students
	ADD CONSTRAINT PK_students -- 학생 기본키
		PRIMARY KEY (
			stud_id -- 학생코드
		);

-- 교수
CREATE TABLE haksa_minjeong.tutors (
	tutor_id INT(11)     NOT NULL COMMENT '교수번호', -- 교수번호
	name     VARCHAR(50) NOT NULL COMMENT '이름', -- 이름
	email    VARCHAR(50) NOT NULL COMMENT '이메일', -- 이메일
	phone    VARCHAR(15) NULL     COMMENT '연락처', -- 연락처
	dob      DATE        NULL     COMMENT '생일', -- 생일
	bio      LONGTEXT    NULL     COMMENT '교수소개', -- 교수소개
	pic      BLOB        NULL     COMMENT '사진', -- 사진
	addr_id  INT(11)     NULL     COMMENT '주소', -- 주소
	addr_id2 INT(11)     NULL     COMMENT '주소코드' -- 주소코드
)
COMMENT '교수';

-- 교수
ALTER TABLE haksa_minjeong.tutors
	ADD CONSTRAINT PK_tutors -- 교수 기본키
		PRIMARY KEY (
			tutor_id -- 교수번호
		);

-- 과목
CREATE TABLE haksa_minjeong.courses (
	course_id   INT(11)      NOT NULL COMMENT '과목코드', -- 과목코드
	name        VARCHAR(100) NOT NULL COMMENT '과목명', -- 과목명
	description VARCHAR(512) NULL     COMMENT '설명', -- 설명
	start_date  DATE         NULL     COMMENT '시작일', -- 시작일
	end_date    DATE         NULL     COMMENT '종료일', -- 종료일
	tutor_id    INT(11)      NOT NULL COMMENT '담당교수' -- 담당교수
)
COMMENT '과목';

-- 과목
ALTER TABLE haksa_minjeong.courses
	ADD CONSTRAINT PK_courses -- 과목 기본키
		PRIMARY KEY (
			course_id -- 과목코드
		);

-- 수강등록
CREATE TABLE haksa_minjeong.course_enrollment (
	course_id INT(11) NOT NULL COMMENT '과목코드', -- 과목코드
	stud_id   INT(11) NOT NULL COMMENT '학생코드' -- 학생코드
)
COMMENT '수강등록';

-- 수강등록
ALTER TABLE haksa_minjeong.course_enrollment
	ADD CONSTRAINT PK_course_enrollment -- 수강등록 기본키
		PRIMARY KEY (
			course_id, -- 과목코드
			stud_id    -- 학생코드
		);

-- 학생
ALTER TABLE haksa_minjeong.students
	ADD CONSTRAINT FK_addresses_TO_students -- 주소 -> 학생
		FOREIGN KEY (
			addr_id2 -- 주소코드
		)
		REFERENCES haksa_minjeong.addresses ( -- 주소
			addr_id -- 주소코드
		);

-- 교수
ALTER TABLE haksa_minjeong.tutors
	ADD CONSTRAINT FK_addresses_TO_tutors -- 주소 -> 교수
		FOREIGN KEY (
			addr_id2 -- 주소코드
		)
		REFERENCES haksa_minjeong.addresses ( -- 주소
			addr_id -- 주소코드
		);

-- 수강등록
ALTER TABLE haksa_minjeong.course_enrollment
	ADD CONSTRAINT FK_students_TO_course_enrollment -- 학생 -> 수강등록
		FOREIGN KEY (
			stud_id -- 학생코드
		)
		REFERENCES haksa_minjeong.students ( -- 학생
			stud_id -- 학생코드
		);

-- 수강등록
ALTER TABLE haksa_minjeong.course_enrollment
	ADD CONSTRAINT FK_courses_TO_course_enrollment -- 과목 -> 수강등록
		FOREIGN KEY (
			course_id -- 과목코드
		)
		REFERENCES haksa_minjeong.courses ( -- 과목
			course_id -- 과목코드
		);