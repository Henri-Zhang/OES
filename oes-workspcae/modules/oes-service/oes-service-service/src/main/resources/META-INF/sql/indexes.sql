create index IX_B992FEA6 on OES_ExamQuestionLink (examRecordId);

create index IX_D2C6A24F on OES_QuestionRecordLink (ddlRecordId);

create index IX_3671C3DD on OES_StudentExam (examRecordId);
create index IX_3AED8188 on OES_StudentExam (studentId);

create index IX_533C47F7 on OES_StudentExamLink (examRecordId);
create index IX_4D979514 on OES_StudentExamLink (inProgress, done);
create index IX_4E0F030A on OES_StudentExamLink (studentId, inProgress, done);

create index IX_84F2581D on OES_StudentTeacherLink (studentId);