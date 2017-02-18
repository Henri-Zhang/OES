create table Question_QuestionContentLink (
	questionOrder LONG not null primary key,
	ddmContentId LONG
);

create table oes_QuestionContentLink (
	questionOrder LONG not null primary key,
	ddmContentId LONG
);

create table oes_questioncontentlink (
	questionOrder int8 not null primary key,
	ddmContentId int8 not null
);