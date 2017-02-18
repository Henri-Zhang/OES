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

package oes.service.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link QuestionContentLinkLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see QuestionContentLinkLocalService
 * @generated
 */
@ProviderType
public class QuestionContentLinkLocalServiceWrapper
	implements QuestionContentLinkLocalService,
		ServiceWrapper<QuestionContentLinkLocalService> {
	public QuestionContentLinkLocalServiceWrapper(
		QuestionContentLinkLocalService questionContentLinkLocalService) {
		_questionContentLinkLocalService = questionContentLinkLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _questionContentLinkLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _questionContentLinkLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _questionContentLinkLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _questionContentLinkLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _questionContentLinkLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of question content links.
	*
	* @return the number of question content links
	*/
	@Override
	public int getQuestionContentLinksCount() {
		return _questionContentLinkLocalService.getQuestionContentLinksCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _questionContentLinkLocalService.getOSGiServiceIdentifier();
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
		return _questionContentLinkLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link oes.service.model.impl.QuestionContentLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _questionContentLinkLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link oes.service.model.impl.QuestionContentLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _questionContentLinkLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	@Override
	public java.util.List<oes.service.model.QuestionContentLink> findRecentUpdateQuestionContentLinks(
		int count) {
		return _questionContentLinkLocalService.findRecentUpdateQuestionContentLinks(count);
	}

	/**
	* Returns a range of all the question content links.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link oes.service.model.impl.QuestionContentLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of question content links
	* @param end the upper bound of the range of question content links (not inclusive)
	* @return the range of question content links
	*/
	@Override
	public java.util.List<oes.service.model.QuestionContentLink> getQuestionContentLinks(
		int start, int end) {
		return _questionContentLinkLocalService.getQuestionContentLinks(start,
			end);
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
		return _questionContentLinkLocalService.dynamicQueryCount(dynamicQuery);
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
		return _questionContentLinkLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	/**
	* Adds the question content link to the database. Also notifies the appropriate model listeners.
	*
	* @param questionContentLink the question content link
	* @return the question content link that was added
	*/
	@Override
	public oes.service.model.QuestionContentLink addQuestionContentLink(
		oes.service.model.QuestionContentLink questionContentLink) {
		return _questionContentLinkLocalService.addQuestionContentLink(questionContentLink);
	}

	/**
	* Creates a new question content link with the primary key. Does not add the question content link to the database.
	*
	* @param questionOrder the primary key for the new question content link
	* @return the new question content link
	*/
	@Override
	public oes.service.model.QuestionContentLink createQuestionContentLink(
		long questionOrder) {
		return _questionContentLinkLocalService.createQuestionContentLink(questionOrder);
	}

	/**
	* Deletes the question content link with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param questionOrder the primary key of the question content link
	* @return the question content link that was removed
	* @throws PortalException if a question content link with the primary key could not be found
	*/
	@Override
	public oes.service.model.QuestionContentLink deleteQuestionContentLink(
		long questionOrder)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _questionContentLinkLocalService.deleteQuestionContentLink(questionOrder);
	}

	/**
	* Deletes the question content link from the database. Also notifies the appropriate model listeners.
	*
	* @param questionContentLink the question content link
	* @return the question content link that was removed
	*/
	@Override
	public oes.service.model.QuestionContentLink deleteQuestionContentLink(
		oes.service.model.QuestionContentLink questionContentLink) {
		return _questionContentLinkLocalService.deleteQuestionContentLink(questionContentLink);
	}

	@Override
	public oes.service.model.QuestionContentLink fetchQuestionContentLink(
		long questionOrder) {
		return _questionContentLinkLocalService.fetchQuestionContentLink(questionOrder);
	}

	/**
	* Returns the question content link with the primary key.
	*
	* @param questionOrder the primary key of the question content link
	* @return the question content link
	* @throws PortalException if a question content link with the primary key could not be found
	*/
	@Override
	public oes.service.model.QuestionContentLink getQuestionContentLink(
		long questionOrder)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _questionContentLinkLocalService.getQuestionContentLink(questionOrder);
	}

	/**
	* Updates the question content link in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param questionContentLink the question content link
	* @return the question content link that was updated
	*/
	@Override
	public oes.service.model.QuestionContentLink updateQuestionContentLink(
		oes.service.model.QuestionContentLink questionContentLink) {
		return _questionContentLinkLocalService.updateQuestionContentLink(questionContentLink);
	}

	@Override
	public QuestionContentLinkLocalService getWrappedService() {
		return _questionContentLinkLocalService;
	}

	@Override
	public void setWrappedService(
		QuestionContentLinkLocalService questionContentLinkLocalService) {
		_questionContentLinkLocalService = questionContentLinkLocalService;
	}

	private QuestionContentLinkLocalService _questionContentLinkLocalService;
}