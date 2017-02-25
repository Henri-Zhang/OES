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
 * Provides a wrapper for {@link ExamQuestionLinkLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ExamQuestionLinkLocalService
 * @generated
 */
@ProviderType
public class ExamQuestionLinkLocalServiceWrapper
	implements ExamQuestionLinkLocalService,
		ServiceWrapper<ExamQuestionLinkLocalService> {
	public ExamQuestionLinkLocalServiceWrapper(
		ExamQuestionLinkLocalService examQuestionLinkLocalService) {
		_examQuestionLinkLocalService = examQuestionLinkLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _examQuestionLinkLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _examQuestionLinkLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _examQuestionLinkLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _examQuestionLinkLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _examQuestionLinkLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of exam question links.
	*
	* @return the number of exam question links
	*/
	@Override
	public int getExamQuestionLinksCount() {
		return _examQuestionLinkLocalService.getExamQuestionLinksCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _examQuestionLinkLocalService.getOSGiServiceIdentifier();
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
		return _examQuestionLinkLocalService.dynamicQuery(dynamicQuery);
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
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _examQuestionLinkLocalService.dynamicQuery(dynamicQuery, start,
			end);
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
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _examQuestionLinkLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
	public java.util.List<priv.barrow.model.ExamQuestionLink> getExamQuestionLinks(
		int start, int end) {
		return _examQuestionLinkLocalService.getExamQuestionLinks(start, end);
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
		return _examQuestionLinkLocalService.dynamicQueryCount(dynamicQuery);
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
		return _examQuestionLinkLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	/**
	* Adds the exam question link to the database. Also notifies the appropriate model listeners.
	*
	* @param examQuestionLink the exam question link
	* @return the exam question link that was added
	*/
	@Override
	public priv.barrow.model.ExamQuestionLink addExamQuestionLink(
		priv.barrow.model.ExamQuestionLink examQuestionLink) {
		return _examQuestionLinkLocalService.addExamQuestionLink(examQuestionLink);
	}

	/**
	* Creates a new exam question link with the primary key. Does not add the exam question link to the database.
	*
	* @param examRecordId the primary key for the new exam question link
	* @return the new exam question link
	*/
	@Override
	public priv.barrow.model.ExamQuestionLink createExamQuestionLink(
		long examRecordId) {
		return _examQuestionLinkLocalService.createExamQuestionLink(examRecordId);
	}

	/**
	* Deletes the exam question link with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param examRecordId the primary key of the exam question link
	* @return the exam question link that was removed
	* @throws PortalException if a exam question link with the primary key could not be found
	*/
	@Override
	public priv.barrow.model.ExamQuestionLink deleteExamQuestionLink(
		long examRecordId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _examQuestionLinkLocalService.deleteExamQuestionLink(examRecordId);
	}

	/**
	* Deletes the exam question link from the database. Also notifies the appropriate model listeners.
	*
	* @param examQuestionLink the exam question link
	* @return the exam question link that was removed
	*/
	@Override
	public priv.barrow.model.ExamQuestionLink deleteExamQuestionLink(
		priv.barrow.model.ExamQuestionLink examQuestionLink) {
		return _examQuestionLinkLocalService.deleteExamQuestionLink(examQuestionLink);
	}

	@Override
	public priv.barrow.model.ExamQuestionLink fetchExamQuestionLink(
		long examRecordId) {
		return _examQuestionLinkLocalService.fetchExamQuestionLink(examRecordId);
	}

	/**
	* Returns the exam question link with the primary key.
	*
	* @param examRecordId the primary key of the exam question link
	* @return the exam question link
	* @throws PortalException if a exam question link with the primary key could not be found
	*/
	@Override
	public priv.barrow.model.ExamQuestionLink getExamQuestionLink(
		long examRecordId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _examQuestionLinkLocalService.getExamQuestionLink(examRecordId);
	}

	/**
	* Updates the exam question link in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param examQuestionLink the exam question link
	* @return the exam question link that was updated
	*/
	@Override
	public priv.barrow.model.ExamQuestionLink updateExamQuestionLink(
		priv.barrow.model.ExamQuestionLink examQuestionLink) {
		return _examQuestionLinkLocalService.updateExamQuestionLink(examQuestionLink);
	}

	@Override
	public ExamQuestionLinkLocalService getWrappedService() {
		return _examQuestionLinkLocalService;
	}

	@Override
	public void setWrappedService(
		ExamQuestionLinkLocalService examQuestionLinkLocalService) {
		_examQuestionLinkLocalService = examQuestionLinkLocalService;
	}

	private ExamQuestionLinkLocalService _examQuestionLinkLocalService;
}