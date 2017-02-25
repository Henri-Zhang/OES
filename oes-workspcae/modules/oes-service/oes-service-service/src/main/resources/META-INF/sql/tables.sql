create table OES_ExamQuestionLink (
	examRecordId LONG not null primary key,
	questionRecordId LONG,
	questionRecordVersion VARCHAR(75) null
);

create table OES_QuestionRecordLink (
	questionOrder LONG not null primary key,
	ddlRecordId LONG
);