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
 * Provides the local service utility for StudentExamLink. This utility wraps
 * {@link priv.barrow.service.impl.StudentExamLinkLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see StudentExamLinkLocalService
 * @see priv.barrow.service.base.StudentExamLinkLocalServiceBaseImpl
 * @see priv.barrow.service.impl.StudentExamLinkLocalServiceImpl
 * @generated
 */
@ProviderType
public class StudentExamLinkLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link priv.barrow.service.impl.StudentExamLinkLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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
	* Returns the number of student exam links.
	*
	* @return the number of student exam links
	*/
	public static int getStudentExamLinksCount() {
		return getService().getStudentExamLinksCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link priv.barrow.model.impl.StudentExamLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link priv.barrow.model.impl.StudentExamLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static java.util.List<priv.barrow.model.StudentExamLink> findByExamRecordId(
		long examRecordId) {
		return getService().findByExamRecordId(examRecordId);
	}

	public static java.util.List<priv.barrow.model.StudentExamLink> findByExamRecordIdAndDone(
		long examRecordId, boolean done) {
		return getService().findByExamRecordIdAndDone(examRecordId, done);
	}

	public static java.util.List<priv.barrow.model.StudentExamLink> findByExamRecordIdAndStudentId(
		long examRecordId, long studentId) {
		return getService()
				   .findByExamRecordIdAndStudentId(examRecordId, studentId);
	}

	public static java.util.List<priv.barrow.model.StudentExamLink> findByStudentId(
		long studentId) {
		return getService().findByStudentId(studentId);
	}

	public static java.util.List<priv.barrow.model.StudentExamLink> findByStudentIdAndStatus(
		long studentId, boolean inProgress, boolean done) {
		return getService().findByStudentIdAndStatus(studentId, inProgress, done);
	}

	/**
	* Returns a range of all the student exam links.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link priv.barrow.model.impl.StudentExamLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of student exam links
	* @param end the upper bound of the range of student exam links (not inclusive)
	* @return the range of student exam links
	*/
	public static java.util.List<priv.barrow.model.StudentExamLink> getStudentExamLinks(
		int start, int end) {
		return getService().getStudentExamLinks(start, end);
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
	* Adds the student exam link to the database. Also notifies the appropriate model listeners.
	*
	* @param studentExamLink the student exam link
	* @return the student exam link that was added
	*/
	public static priv.barrow.model.StudentExamLink addStudentExamLink(
		priv.barrow.model.StudentExamLink studentExamLink) {
		return getService().addStudentExamLink(studentExamLink);
	}

	/**
	* Creates a new student exam link with the primary key. Does not add the student exam link to the database.
	*
	* @param studentExamLinkPK the primary key for the new student exam link
	* @return the new student exam link
	*/
	public static priv.barrow.model.StudentExamLink createStudentExamLink(
		priv.barrow.service.persistence.StudentExamLinkPK studentExamLinkPK) {
		return getService().createStudentExamLink(studentExamLinkPK);
	}

	/**
	* Deletes the student exam link from the database. Also notifies the appropriate model listeners.
	*
	* @param studentExamLink the student exam link
	* @return the student exam link that was removed
	*/
	public static priv.barrow.model.StudentExamLink deleteStudentExamLink(
		priv.barrow.model.StudentExamLink studentExamLink) {
		return getService().deleteStudentExamLink(studentExamLink);
	}

	/**
	* Deletes the student exam link with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param studentExamLinkPK the primary key of the student exam link
	* @return the student exam link that was removed
	* @throws PortalException if a student exam link with the primary key could not be found
	*/
	public static priv.barrow.model.StudentExamLink deleteStudentExamLink(
		priv.barrow.service.persistence.StudentExamLinkPK studentExamLinkPK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteStudentExamLink(studentExamLinkPK);
	}

	public static priv.barrow.model.StudentExamLink fetchStudentExamLink(
		priv.barrow.service.persistence.StudentExamLinkPK studentExamLinkPK) {
		return getService().fetchStudentExamLink(studentExamLinkPK);
	}

	/**
	* Returns the student exam link with the primary key.
	*
	* @param studentExamLinkPK the primary key of the student exam link
	* @return the student exam link
	* @throws PortalException if a student exam link with the primary key could not be found
	*/
	public static priv.barrow.model.StudentExamLink getStudentExamLink(
		priv.barrow.service.persistence.StudentExamLinkPK studentExamLinkPK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getStudentExamLink(studentExamLinkPK);
	}

	/**
	* Updates the student exam link in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param studentExamLink the student exam link
	* @return the student exam link that was updated
	*/
	public static priv.barrow.model.StudentExamLink updateStudentExamLink(
		priv.barrow.model.StudentExamLink studentExamLink) {
		return getService().updateStudentExamLink(studentExamLink);
	}

	public static StudentExamLinkLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<StudentExamLinkLocalService, StudentExamLinkLocalService> _serviceTracker =
		ServiceTrackerFactory.open(StudentExamLinkLocalService.class);
}