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

package priv.barrow.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for ExamData. This utility wraps
 * {@link priv.barrow.service.impl.ExamDataLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ExamDataLocalService
 * @see priv.barrow.service.base.ExamDataLocalServiceBaseImpl
 * @see priv.barrow.service.impl.ExamDataLocalServiceImpl
 * @generated
 */
@ProviderType
public class ExamDataLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link priv.barrow.service.impl.ExamDataLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of exam datas.
	*
	* @return the number of exam datas
	*/
	public static int getExamDatasCount() {
		return getService().getExamDatasCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link priv.barrow.model.impl.ExamDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link priv.barrow.model.impl.ExamDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	public static java.util.List<priv.barrow.model.ExamData> findByExamIdAndStudentId(
		long examId, long studentId) {
		return getService().findByExamIdAndStudentId(examId, studentId);
	}

	public static java.util.List<priv.barrow.model.ExamData> findByExamIdAndStudentIdAndQuestionOrder(
		long examId, long studentId, long questionOrder) {
		return getService()
				   .findByExamIdAndStudentIdAndQuestionOrder(examId, studentId,
			questionOrder);
	}

	/**
	* Returns a range of all the exam datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link priv.barrow.model.impl.ExamDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of exam datas
	* @param end the upper bound of the range of exam datas (not inclusive)
	* @return the range of exam datas
	*/
	public static java.util.List<priv.barrow.model.ExamData> getExamDatas(
		int start, int end) {
		return getService().getExamDatas(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	/**
	* Adds the exam data to the database. Also notifies the appropriate model listeners.
	*
	* @param examData the exam data
	* @return the exam data that was added
	*/
	public static priv.barrow.model.ExamData addExamData(
		priv.barrow.model.ExamData examData) {
		return getService().addExamData(examData);
	}

	/**
	* Creates a new exam data with the primary key. Does not add the exam data to the database.
	*
	* @param PK the primary key for the new exam data
	* @return the new exam data
	*/
	public static priv.barrow.model.ExamData createExamData(long PK) {
		return getService().createExamData(PK);
	}

	/**
	* Deletes the exam data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PK the primary key of the exam data
	* @return the exam data that was removed
	* @throws PortalException if a exam data with the primary key could not be found
	*/
	public static priv.barrow.model.ExamData deleteExamData(long PK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteExamData(PK);
	}

	/**
	* Deletes the exam data from the database. Also notifies the appropriate model listeners.
	*
	* @param examData the exam data
	* @return the exam data that was removed
	*/
	public static priv.barrow.model.ExamData deleteExamData(
		priv.barrow.model.ExamData examData) {
		return getService().deleteExamData(examData);
	}

	public static priv.barrow.model.ExamData fetchExamData(long PK) {
		return getService().fetchExamData(PK);
	}

	/**
	* Returns the exam data with the primary key.
	*
	* @param PK the primary key of the exam data
	* @return the exam data
	* @throws PortalException if a exam data with the primary key could not be found
	*/
	public static priv.barrow.model.ExamData getExamData(long PK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getExamData(PK);
	}

	/**
	* Updates the exam data in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param examData the exam data
	* @return the exam data that was updated
	*/
	public static priv.barrow.model.ExamData updateExamData(
		priv.barrow.model.ExamData examData) {
		return getService().updateExamData(examData);
	}

	public static ExamDataLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ExamDataLocalService, ExamDataLocalService> _serviceTracker =
		ServiceTrackerFactory.open(ExamDataLocalService.class);
}