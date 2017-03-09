create table OES_ExamData (
	PK LONG not null primary key,
	examId LONG,
	studentId LONG,
	questionOrder LONG,
	result VARCHAR(75) null
);

create table OES_ExamQuestionLink (
	examRecordId LONG not null,
	questionRecordId LONG not null,
	questionRecordVersion VARCHAR(75) null,
	primary key (examRecordId, questionRecordId)
);

create table OES_QuestionRecordLink (
	questionOrder LONG not null primary key,
	ddlRecordId LONG,
	active_ BOOLEAN,
	questionDescription VARCHAR(75) null
);

create table OES_StudentExamLink (
	examRecordId LONG not null,
	studentId LONG not null,
	inProgress BOOLEAN,
	done BOOLEAN,
	primary key (examRecordId, studentId)
);

create table OES_StudentTeacherLink (
	studentId LONG not null primary key,
	teacherId LONG
);

create table OES_Teacher (
	teacherNumber LONG not null primary key,
	userId LONG
);

create table OES_TeacherUserLink (
	teacherNumber LONG not null primary key,
	userId LONG
);