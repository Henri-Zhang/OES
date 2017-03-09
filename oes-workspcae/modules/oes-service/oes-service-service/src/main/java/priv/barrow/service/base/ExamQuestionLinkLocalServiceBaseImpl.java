/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package priv.barrow.service.base;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalServiceRegistry;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import priv.barrow.model.ExamQuestionLink;

import priv.barrow.service.ExamQuestionLinkLocalService;
import priv.barrow.service.persistence.ExamDataPersistence;
import priv.barrow.service.persistence.ExamQuestionLinkPK;
import priv.barrow.service.persistence.ExamQuestionLinkPersistence;
import priv.barrow.service.persistence.QuestionRecordLinkFinder;
import priv.barrow.service.persistence.QuestionRecordLinkPersistence;
import priv.barrow.service.persistence.StudentExamLinkPersistence;
import priv.barrow.service.persistence.StudentTeacherLinkPersistence;
import priv.barrow.service.persistence.TeacherUserLinkFinder;
import priv.barrow.service.persistence.TeacherUserLinkPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the exam question link local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link priv.barrow.service.impl.ExamQuestionLinkLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see priv.barrow.service.impl.ExamQuestionLinkLocalServiceImpl
 * @see priv.barrow.service.ExamQuestionLinkLocalServiceUtil
 * @generated
 */
@ProviderType
public abstract class ExamQuestionLinkLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements ExamQuestionLinkLocalService,
		IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link priv.barrow.service.ExamQuestionLinkLocalServiceUtil} to access the exam question link local service.
	 */

	/**
	 * Adds the exam question link to the database. Also notifies the appropriate model listeners.
	 *
	 * @param examQuestionLink the exam question link
	 * @return the exam question link that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ExamQuestionLink addExamQuestionLink(
		ExamQuestionLink examQuestionLink) {
		examQuestionLink.setNew(true);

		return examQuestionLinkPersistence.update(examQuestionLink);
	}

	/**
	 * Creates a new exam question link with the primary key. Does not add the exam question link to the database.
	 *
	 * @param examQuestionLinkPK the primary key for the new exam question link
	 * @return the new exam question link
	 */
	@Override
	public ExamQuestionLink createExamQuestionLink(
		ExamQuestionLinkPK examQuestionLinkPK) {
		return examQuestionLinkPersistence.create(examQuestionLinkPK);
	}

	/**
	 * Deletes the exam question link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param examQuestionLinkPK the primary key of the exam question link
	 * @return the exam question link that was removed
	 * @throws PortalException if a exam question link with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ExamQuestionLink deleteExamQuestionLink(
		ExamQuestionLinkPK examQuestionLinkPK) throws PortalException {
		return examQuestionLinkPersistence.remove(examQuestionLinkPK);
	}

	/**
	 * Deletes the exam question link from the database. Also notifies the appropriate model listeners.
	 *
	 * @param examQuestionLink the exam question link
	 * @return the exam question link that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ExamQuestionLink deleteExamQuestionLink(
		ExamQuestionLink examQuestionLink) {
		return examQuestionLinkPersistence.remove(examQuestionLink);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(ExamQuestionLink.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return examQuestionLinkPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link priv.barrow.model.impl.ExamQuestionLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end) {
		return examQuestionLinkPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link priv.barrow.model.impl.ExamQuestionLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator) {
		return examQuestionLinkPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return examQuestionLinkPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) {
		return examQuestionLinkPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public ExamQuestionLink fetchExamQuestionLink(
		ExamQuestionLinkPK examQuestionLinkPK) {
		return examQuestionLinkPersistence.fetchByPrimaryKey(examQuestionLinkPK);
	}

	/**
	 * Returns the exam question link with the primary key.
	 *
	 * @param examQuestionLinkPK the primary key of the exam question link
	 * @return the exam question link
	 * @throws PortalException if a exam question link with the primary key could not be found
	 */
	@Override
	public ExamQuestionLink getExamQuestionLink(
		ExamQuestionLinkPK examQuestionLinkPK) throws PortalException {
		return examQuestionLinkPersistence.findByPrimaryKey(examQuestionLinkPK);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery = new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(examQuestionLinkLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(ExamQuestionLink.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"primaryKey.examRecordId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery = new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(examQuestionLinkLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(ExamQuestionLink.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"primaryKey.examRecordId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {
		actionableDynamicQuery.setBaseLocalService(examQuestionLinkLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(ExamQuestionLink.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"primaryKey.examRecordId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return examQuestionLinkLocalService.deleteExamQuestionLink((ExamQuestionLink)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return examQuestionLinkPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the exam question links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link priv.barrow.model.impl.ExamQuestionLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of exam question links
	 * @param end the upper bound of the range of exam question links (not inclusive)
	 * @return the range of exam question links
	 */
	@Override
	public List<ExamQuestionLink> getExamQuestionLinks(int start, int end) {
		return examQuestionLinkPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of exam question links.
	 *
	 * @return the number of exam question links
	 */
	@Override
	public int getExamQuestionLinksCount() {
		return examQuestionLinkPersistence.countAll();
	}

	/**
	 * Updates the exam question link in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param examQuestionLink the exam question link
	 * @return the exam question link that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ExamQuestionLink updateExamQuestionLink(
		ExamQuestionLink examQuestionLink) {
		return examQuestionLinkPersistence.update(examQuestionLink);
	}

	/**
	 * Returns the exam data local service.
	 *
	 * @return the exam data local service
	 */
	public priv.barrow.service.ExamDataLocalService getExamDataLocalService() {
		return examDataLocalService;
	}

	/**
	 * Sets the exam data local service.
	 *
	 * @param examDataLocalService the exam data local service
	 */
	public void setExamDataLocalService(
		priv.barrow.service.ExamDataLocalService examDataLocalService) {
		this.examDataLocalService = examDataLocalService;
	}

	/**
	 * Returns the exam data persistence.
	 *
	 * @return the exam data persistence
	 */
	public ExamDataPersistence getExamDataPersistence() {
		return examDataPersistence;
	}

	/**
	 * Sets the exam data persistence.
	 *
	 * @param examDataPersistence the exam data persistence
	 */
	public void setExamDataPersistence(ExamDataPersistence examDataPersistence) {
		this.examDataPersistence = examDataPersistence;
	}

	/**
	 * Returns the exam question link local service.
	 *
	 * @return the exam question link local service
	 */
	public ExamQuestionLinkLocalService getExamQuestionLinkLocalService() {
		return examQuestionLinkLocalService;
	}

	/**
	 * Sets the exam question link local service.
	 *
	 * @param examQuestionLinkLocalService the exam question link local service
	 */
	public void setExamQuestionLinkLocalService(
		ExamQuestionLinkLocalService examQuestionLinkLocalService) {
		this.examQuestionLinkLocalService = examQuestionLinkLocalService;
	}

	/**
	 * Returns the exam question link persistence.
	 *
	 * @return the exam question link persistence
	 */
	public ExamQuestionLinkPersistence getExamQuestionLinkPersistence() {
		return examQuestionLinkPersistence;
	}

	/**
	 * Sets the exam question link persistence.
	 *
	 * @param examQuestionLinkPersistence the exam question link persistence
	 */
	public void setExamQuestionLinkPersistence(
		ExamQuestionLinkPersistence examQuestionLinkPersistence) {
		this.examQuestionLinkPersistence = examQuestionLinkPersistence;
	}

	/**
	 * Returns the question record link local service.
	 *
	 * @return the question record link local service
	 */
	public priv.barrow.service.QuestionRecordLinkLocalService getQuestionRecordLinkLocalService() {
		return questionRecordLinkLocalService;
	}

	/**
	 * Sets the question record link local service.
	 *
	 * @param questionRecordLinkLocalService the question record link local service
	 */
	public void setQuestionRecordLinkLocalService(
		priv.barrow.service.QuestionRecordLinkLocalService questionRecordLinkLocalService) {
		this.questionRecordLinkLocalService = questionRecordLinkLocalService;
	}

	/**
	 * Returns the question record link persistence.
	 *
	 * @return the question record link persistence
	 */
	public QuestionRecordLinkPersistence getQuestionRecordLinkPersistence() {
		return questionRecordLinkPersistence;
	}

	/**
	 * Sets the question record link persistence.
	 *
	 * @param questionRecordLinkPersistence the question record link persistence
	 */
	public void setQuestionRecordLinkPersistence(
		QuestionRecordLinkPersistence questionRecordLinkPersistence) {
		this.questionRecordLinkPersistence = questionRecordLinkPersistence;
	}

	/**
	 * Returns the question record link finder.
	 *
	 * @return the question record link finder
	 */
	public QuestionRecordLinkFinder getQuestionRecordLinkFinder() {
		return questionRecordLinkFinder;
	}

	/**
	 * Sets the question record link finder.
	 *
	 * @param questionRecordLinkFinder the question record link finder
	 */
	public void setQuestionRecordLinkFinder(
		QuestionRecordLinkFinder questionRecordLinkFinder) {
		this.questionRecordLinkFinder = questionRecordLinkFinder;
	}

	/**
	 * Returns the student exam link local service.
	 *
	 * @return the student exam link local service
	 */
	public priv.barrow.service.StudentExamLinkLocalService getStudentExamLinkLocalService() {
		return studentExamLinkLocalService;
	}

	/**
	 * Sets the student exam link local service.
	 *
	 * @param studentExamLinkLocalService the student exam link local service
	 */
	public void setStudentExamLinkLocalService(
		priv.barrow.service.StudentExamLinkLocalService studentExamLinkLocalService) {
		this.studentExamLinkLocalService = studentExamLinkLocalService;
	}

	/**
	 * Returns the student exam link persistence.
	 *
	 * @return the student exam link persistence
	 */
	public StudentExamLinkPersistence getStudentExamLinkPersistence() {
		return studentExamLinkPersistence;
	}

	/**
	 * Sets the student exam link persistence.
	 *
	 * @param studentExamLinkPersistence the student exam link persistence
	 */
	public void setStudentExamLinkPersistence(
		StudentExamLinkPersistence studentExamLinkPersistence) {
		this.studentExamLinkPersistence = studentExamLinkPersistence;
	}

	/**
	 * Returns the student teacher link local service.
	 *
	 * @return the student teacher link local service
	 */
	public priv.barrow.service.StudentTeacherLinkLocalService getStudentTeacherLinkLocalService() {
		return studentTeacherLinkLocalService;
	}

	/**
	 * Sets the student teacher link local service.
	 *
	 * @param studentTeacherLinkLocalService the student teacher link local service
	 */
	public void setStudentTeacherLinkLocalService(
		priv.barrow.service.StudentTeacherLinkLocalService studentTeacherLinkLocalService) {
		this.studentTeacherLinkLocalService = studentTeacherLinkLocalService;
	}

	/**
	 * Returns the student teacher link persistence.
	 *
	 * @return the student teacher link persistence
	 */
	public StudentTeacherLinkPersistence getStudentTeacherLinkPersistence() {
		return studentTeacherLinkPersistence;
	}

	/**
	 * Sets the student teacher link persistence.
	 *
	 * @param studentTeacherLinkPersistence the student teacher link persistence
	 */
	public void setStudentTeacherLinkPersistence(
		StudentTeacherLinkPersistence studentTeacherLinkPersistence) {
		this.studentTeacherLinkPersistence = studentTeacherLinkPersistence;
	}

	/**
	 * Returns the teacher user link local service.
	 *
	 * @return the teacher user link local service
	 */
	public priv.barrow.service.TeacherUserLinkLocalService getTeacherUserLinkLocalService() {
		return teacherUserLinkLocalService;
	}

	/**
	 * Sets the teacher user link local service.
	 *
	 * @param teacherUserLinkLocalService the teacher user link local service
	 */
	public void setTeacherUserLinkLocalService(
		priv.barrow.service.TeacherUserLinkLocalService teacherUserLinkLocalService) {
		this.teacherUserLinkLocalService = teacherUserLinkLocalService;
	}

	/**
	 * Returns the teacher user link persistence.
	 *
	 * @return the teacher user link persistence
	 */
	public TeacherUserLinkPersistence getTeacherUserLinkPersistence() {
		return teacherUserLinkPersistence;
	}

	/**
	 * Sets the teacher user link persistence.
	 *
	 * @param teacherUserLinkPersistence the teacher user link persistence
	 */
	public void setTeacherUserLinkPersistence(
		TeacherUserLinkPersistence teacherUserLinkPersistence) {
		this.teacherUserLinkPersistence = teacherUserLinkPersistence;
	}

	/**
	 * Returns the teacher user link finder.
	 *
	 * @return the teacher user link finder
	 */
	public TeacherUserLinkFinder getTeacherUserLinkFinder() {
		return teacherUserLinkFinder;
	}

	/**
	 * Sets the teacher user link finder.
	 *
	 * @param teacherUserLinkFinder the teacher user link finder
	 */
	public void setTeacherUserLinkFinder(
		TeacherUserLinkFinder teacherUserLinkFinder) {
		this.teacherUserLinkFinder = teacherUserLinkFinder;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService getClassNameLocalService() {
		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService) {
		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {
		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		persistedModelLocalServiceRegistry.register("priv.barrow.model.ExamQuestionLink",
			examQuestionLinkLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"priv.barrow.model.ExamQuestionLink");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return ExamQuestionLinkLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return ExamQuestionLink.class;
	}

	protected String getModelClassName() {
		return ExamQuestionLink.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = examQuestionLinkPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = priv.barrow.service.ExamDataLocalService.class)
	protected priv.barrow.service.ExamDataLocalService examDataLocalService;
	@BeanReference(type = ExamDataPersistence.class)
	protected ExamDataPersistence examDataPersistence;
	@BeanReference(type = ExamQuestionLinkLocalService.class)
	protected ExamQuestionLinkLocalService examQuestionLinkLocalService;
	@BeanReference(type = ExamQuestionLinkPersistence.class)
	protected ExamQuestionLinkPersistence examQuestionLinkPersistence;
	@BeanReference(type = priv.barrow.service.QuestionRecordLinkLocalService.class)
	protected priv.barrow.service.QuestionRecordLinkLocalService questionRecordLinkLocalService;
	@BeanReference(type = QuestionRecordLinkPersistence.class)
	protected QuestionRecordLinkPersistence questionRecordLinkPersistence;
	@BeanReference(type = QuestionRecordLinkFinder.class)
	protected QuestionRecordLinkFinder questionRecordLinkFinder;
	@BeanReference(type = priv.barrow.service.StudentExamLinkLocalService.class)
	protected priv.barrow.service.StudentExamLinkLocalService studentExamLinkLocalService;
	@BeanReference(type = StudentExamLinkPersistence.class)
	protected StudentExamLinkPersistence studentExamLinkPersistence;
	@BeanReference(type = priv.barrow.service.StudentTeacherLinkLocalService.class)
	protected priv.barrow.service.StudentTeacherLinkLocalService studentTeacherLinkLocalService;
	@BeanReference(type = StudentTeacherLinkPersistence.class)
	protected StudentTeacherLinkPersistence studentTeacherLinkPersistence;
	@BeanReference(type = priv.barrow.service.TeacherUserLinkLocalService.class)
	protected priv.barrow.service.TeacherUserLinkLocalService teacherUserLinkLocalService;
	@BeanReference(type = TeacherUserLinkPersistence.class)
	protected TeacherUserLinkPersistence teacherUserLinkPersistence;
	@BeanReference(type = TeacherUserLinkFinder.class)
	protected TeacherUserLinkFinder teacherUserLinkFinder;
	@ServiceReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@ServiceReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@ServiceReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry persistedModelLocalServiceRegistry;
}