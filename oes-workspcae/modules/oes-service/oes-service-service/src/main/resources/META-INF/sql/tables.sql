create table OES_ExamQuestionLink (
	examRecordId LONG not null,
	questionRecordId LONG not null,
	questionRecordVersion VARCHAR(75) null,
	primary key (examRecordId, questionRecordId)
);

create table OES_QuestionRecordLink (
	questionOrder LONG not null primary key,
	ddlRecordId LONG
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