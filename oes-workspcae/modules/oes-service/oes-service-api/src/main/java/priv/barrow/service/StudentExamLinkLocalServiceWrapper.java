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
 * Provides a wrapper for {@link StudentExamLinkLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see StudentExamLinkLocalService
 * @generated
 */
@ProviderType
public class StudentExamLinkLocalServiceWrapper
	implements StudentExamLinkLocalService,
		ServiceWrapper<StudentExamLinkLocalService> {
	public StudentExamLinkLocalServiceWrapper(
		StudentExamLinkLocalService studentExamLinkLocalService) {
		_studentExamLinkLocalService = studentExamLinkLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _studentExamLinkLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _studentExamLinkLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _studentExamLinkLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _studentExamLinkLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _studentExamLinkLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of student exam links.
	*
	* @return the number of student exam links
	*/
	@Override
	public int getStudentExamLinksCount() {
		return _studentExamLinkLocalService.getStudentExamLinksCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _studentExamLinkLocalService.getOSGiServiceIdentifier();
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
		return _studentExamLinkLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _studentExamLinkLocalService.dynamicQuery(dynamicQuery, start,
			end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _studentExamLinkLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	@Override
	public java.util.List<priv.barrow.model.StudentExamLink> findByExamRecordId(
		long examRecordId) {
		return _studentExamLinkLocalService.findByExamRecordId(examRecordId);
	}

	@Override
	public java.util.List<priv.barrow.model.StudentExamLink> findByExamRecordIdAndStudentId(
		long examRecordId, long studentId) {
		return _studentExamLinkLocalService.findByExamRecordIdAndStudentId(examRecordId,
			studentId);
	}

	@Override
	public java.util.List<priv.barrow.model.StudentExamLink> findByStudentId(
		long studentId) {
		return _studentExamLinkLocalService.findByStudentId(studentId);
	}

	@Override
	public java.util.List<priv.barrow.model.StudentExamLink> findByStudentIdAndStatus(
		long studentId, boolean inProgress, boolean done) {
		return _studentExamLinkLocalService.findByStudentIdAndStatus(studentId,
			inProgress, done);
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
	@Override
	public java.util.List<priv.barrow.model.StudentExamLink> getStudentExamLinks(
		int start, int end) {
		return _studentExamLinkLocalService.getStudentExamLinks(start, end);
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
		return _studentExamLinkLocalService.dynamicQueryCount(dynamicQuery);
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
		return _studentExamLinkLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	/**
	* Adds the student exam link to the database. Also notifies the appropriate model listeners.
	*
	* @param studentExamLink the student exam link
	* @return the student exam link that was added
	*/
	@Override
	public priv.barrow.model.StudentExamLink addStudentExamLink(
		priv.barrow.model.StudentExamLink studentExamLink) {
		return _studentExamLinkLocalService.addStudentExamLink(studentExamLink);
	}

	/**
	* Creates a new student exam link with the primary key. Does not add the student exam link to the database.
	*
	* @param studentExamLinkPK the primary key for the new student exam link
	* @return the new student exam link
	*/
	@Override
	public priv.barrow.model.StudentExamLink createStudentExamLink(
		priv.barrow.service.persistence.StudentExamLinkPK studentExamLinkPK) {
		return _studentExamLinkLocalService.createStudentExamLink(studentExamLinkPK);
	}

	/**
	* Deletes the student exam link from the database. Also notifies the appropriate model listeners.
	*
	* @param studentExamLink the student exam link
	* @return the student exam link that was removed
	*/
	@Override
	public priv.barrow.model.StudentExamLink deleteStudentExamLink(
		priv.barrow.model.StudentExamLink studentExamLink) {
		return _studentExamLinkLocalService.deleteStudentExamLink(studentExamLink);
	}

	/**
	* Deletes the student exam link with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param studentExamLinkPK the primary key of the student exam link
	* @return the student exam link that was removed
	* @throws PortalException if a student exam link with the primary key could not be found
	*/
	@Override
	public priv.barrow.model.StudentExamLink deleteStudentExamLink(
		priv.barrow.service.persistence.StudentExamLinkPK studentExamLinkPK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _studentExamLinkLocalService.deleteStudentExamLink(studentExamLinkPK);
	}

	@Override
	public priv.barrow.model.StudentExamLink fetchStudentExamLink(
		priv.barrow.service.persistence.StudentExamLinkPK studentExamLinkPK) {
		return _studentExamLinkLocalService.fetchStudentExamLink(studentExamLinkPK);
	}

	/**
	* Returns the student exam link with the primary key.
	*
	* @param studentExamLinkPK the primary key of the student exam link
	* @return the student exam link
	* @throws PortalException if a student exam link with the primary key could not be found
	*/
	@Override
	public priv.barrow.model.StudentExamLink getStudentExamLink(
		priv.barrow.service.persistence.StudentExamLinkPK studentExamLinkPK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _studentExamLinkLocalService.getStudentExamLink(studentExamLinkPK);
	}

	/**
	* Updates the student exam link in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param studentExamLink the student exam link
	* @return the student exam link that was updated
	*/
	@Override
	public priv.barrow.model.StudentExamLink updateStudentExamLink(
		priv.barrow.model.StudentExamLink studentExamLink) {
		return _studentExamLinkLocalService.updateStudentExamLink(studentExamLink);
	}

	@Override
	public StudentExamLinkLocalService getWrappedService() {
		return _studentExamLinkLocalService;
	}

	@Override
	public void setWrappedService(
		StudentExamLinkLocalService studentExamLinkLocalService) {
		_studentExamLinkLocalService = studentExamLinkLocalService;
	}

	private StudentExamLinkLocalService _studentExamLinkLocalService;
}