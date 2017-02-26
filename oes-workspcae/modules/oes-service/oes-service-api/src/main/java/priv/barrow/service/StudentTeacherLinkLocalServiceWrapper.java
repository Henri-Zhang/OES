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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link StudentTeacherLinkLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see StudentTeacherLinkLocalService
 * @generated
 */
@ProviderType
public class StudentTeacherLinkLocalServiceWrapper
	implements StudentTeacherLinkLocalService,
		ServiceWrapper<StudentTeacherLinkLocalService> {
	public StudentTeacherLinkLocalServiceWrapper(
		StudentTeacherLinkLocalService studentTeacherLinkLocalService) {
		_studentTeacherLinkLocalService = studentTeacherLinkLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _studentTeacherLinkLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _studentTeacherLinkLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _studentTeacherLinkLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _studentTeacherLinkLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _studentTeacherLinkLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of student teacher links.
	*
	* @return the number of student teacher links
	*/
	@Override
	public int getStudentTeacherLinksCount() {
		return _studentTeacherLinkLocalService.getStudentTeacherLinksCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _studentTeacherLinkLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _studentTeacherLinkLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link priv.barrow.model.impl.StudentTeacherLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _studentTeacherLinkLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link priv.barrow.model.impl.StudentTeacherLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _studentTeacherLinkLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns a range of all the student teacher links.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link priv.barrow.model.impl.StudentTeacherLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of student teacher links
	* @param end the upper bound of the range of student teacher links (not inclusive)
	* @return the range of student teacher links
	*/
	@Override
	public java.util.List<priv.barrow.model.StudentTeacherLink> getStudentTeacherLinks(
		int start, int end) {
		return _studentTeacherLinkLocalService.getStudentTeacherLinks(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _studentTeacherLinkLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _studentTeacherLinkLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	/**
	* Adds the student teacher link to the database. Also notifies the appropriate model listeners.
	*
	* @param studentTeacherLink the student teacher link
	* @return the student teacher link that was added
	*/
	@Override
	public priv.barrow.model.StudentTeacherLink addStudentTeacherLink(
		priv.barrow.model.StudentTeacherLink studentTeacherLink) {
		return _studentTeacherLinkLocalService.addStudentTeacherLink(studentTeacherLink);
	}

	/**
	* Creates a new student teacher link with the primary key. Does not add the student teacher link to the database.
	*
	* @param studentId the primary key for the new student teacher link
	* @return the new student teacher link
	*/
	@Override
	public priv.barrow.model.StudentTeacherLink createStudentTeacherLink(
		long studentId) {
		return _studentTeacherLinkLocalService.createStudentTeacherLink(studentId);
	}

	/**
	* Deletes the student teacher link with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param studentId the primary key of the student teacher link
	* @return the student teacher link that was removed
	* @throws PortalException if a student teacher link with the primary key could not be found
	*/
	@Override
	public priv.barrow.model.StudentTeacherLink deleteStudentTeacherLink(
		long studentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _studentTeacherLinkLocalService.deleteStudentTeacherLink(studentId);
	}

	/**
	* Deletes the student teacher link from the database. Also notifies the appropriate model listeners.
	*
	* @param studentTeacherLink the student teacher link
	* @return the student teacher link that was removed
	*/
	@Override
	public priv.barrow.model.StudentTeacherLink deleteStudentTeacherLink(
		priv.barrow.model.StudentTeacherLink studentTeacherLink) {
		return _studentTeacherLinkLocalService.deleteStudentTeacherLink(studentTeacherLink);
	}

	@Override
	public priv.barrow.model.StudentTeacherLink fetchStudentTeacherLink(
		long studentId) {
		return _studentTeacherLinkLocalService.fetchStudentTeacherLink(studentId);
	}

	/**
	* Returns the student teacher link with the primary key.
	*
	* @param studentId the primary key of the student teacher link
	* @return the student teacher link
	* @throws PortalException if a student teacher link with the primary key could not be found
	*/
	@Override
	public priv.barrow.model.StudentTeacherLink getStudentTeacherLink(
		long studentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _studentTeacherLinkLocalService.getStudentTeacherLink(studentId);
	}

	/**
	* Updates the student teacher link in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param studentTeacherLink the student teacher link
	* @return the student teacher link that was updated
	*/
	@Override
	public priv.barrow.model.StudentTeacherLink updateStudentTeacherLink(
		priv.barrow.model.StudentTeacherLink studentTeacherLink) {
		return _studentTeacherLinkLocalService.updateStudentTeacherLink(studentTeacherLink);
	}

	@Override
	public StudentTeacherLinkLocalService getWrappedService() {
		return _studentTeacherLinkLocalService;
	}

	@Override
	public void setWrappedService(
		StudentTeacherLinkLocalService studentTeacherLinkLocalService) {
		_studentTeacherLinkLocalService = studentTeacherLinkLocalService;
	}

	private StudentTeacherLinkLocalService _studentTeacherLinkLocalService;
}