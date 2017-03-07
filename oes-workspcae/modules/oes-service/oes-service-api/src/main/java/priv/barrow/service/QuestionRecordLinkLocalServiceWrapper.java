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
 * Provides a wrapper for {@link QuestionRecordLinkLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see QuestionRecordLinkLocalService
 * @generated
 */
@ProviderType
public class QuestionRecordLinkLocalServiceWrapper
	implements QuestionRecordLinkLocalService,
		ServiceWrapper<QuestionRecordLinkLocalService> {
	public QuestionRecordLinkLocalServiceWrapper(
		QuestionRecordLinkLocalService questionRecordLinkLocalService) {
		_questionRecordLinkLocalService = questionRecordLinkLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _questionRecordLinkLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _questionRecordLinkLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _questionRecordLinkLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _questionRecordLinkLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _questionRecordLinkLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public int countSearchQuestionReocrdLinks(long questionOrderStart,
		long questionOrderEnd, java.sql.Timestamp updateDateStart,
		java.sql.Timestamp updateDateEnd, java.lang.String questionKeyword,
		java.lang.String userNameKeyword) {
		return _questionRecordLinkLocalService.countSearchQuestionReocrdLinks(questionOrderStart,
			questionOrderEnd, updateDateStart, updateDateEnd, questionKeyword,
			userNameKeyword);
	}

	/**
	* Returns the number of question record links.
	*
	* @return the number of question record links
	*/
	@Override
	public int getQuestionRecordLinksCount() {
		return _questionRecordLinkLocalService.getQuestionRecordLinksCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _questionRecordLinkLocalService.getOSGiServiceIdentifier();
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
		return _questionRecordLinkLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link priv.barrow.model.impl.QuestionRecordLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _questionRecordLinkLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link priv.barrow.model.impl.QuestionRecordLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _questionRecordLinkLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	@Override
	public java.util.List<priv.barrow.model.QuestionRecordLink> findByDdlRecordId(
		long ddlRecordId) {
		return _questionRecordLinkLocalService.findByDdlRecordId(ddlRecordId);
	}

	@Override
	public java.util.List<priv.barrow.model.QuestionRecordLink> findRandomQuestionReocrdLinks(
		int count) {
		return _questionRecordLinkLocalService.findRandomQuestionReocrdLinks(count);
	}

	@Override
	public java.util.List<priv.barrow.model.QuestionRecordLink> findRecentUpdateQuestionReocrdLinks(
		int count) {
		return _questionRecordLinkLocalService.findRecentUpdateQuestionReocrdLinks(count);
	}

	/**
	* Returns a range of all the question record links.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link priv.barrow.model.impl.QuestionRecordLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of question record links
	* @param end the upper bound of the range of question record links (not inclusive)
	* @return the range of question record links
	*/
	@Override
	public java.util.List<priv.barrow.model.QuestionRecordLink> getQuestionRecordLinks(
		int start, int end) {
		return _questionRecordLinkLocalService.getQuestionRecordLinks(start, end);
	}

	@Override
	public java.util.List<priv.barrow.model.QuestionRecordLink> searchQuestionReocrdLinks(
		long questionOrderStart, long questionOrderEnd,
		java.sql.Timestamp updateDateStart, java.sql.Timestamp updateDateEnd,
		java.lang.String questionKeyword, java.lang.String userNameKeyword,
		long start, long end) {
		return _questionRecordLinkLocalService.searchQuestionReocrdLinks(questionOrderStart,
			questionOrderEnd, updateDateStart, updateDateEnd, questionKeyword,
			userNameKeyword, start, end);
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
		return _questionRecordLinkLocalService.dynamicQueryCount(dynamicQuery);
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
		return _questionRecordLinkLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	/**
	* Adds the question record link to the database. Also notifies the appropriate model listeners.
	*
	* @param questionRecordLink the question record link
	* @return the question record link that was added
	*/
	@Override
	public priv.barrow.model.QuestionRecordLink addQuestionRecordLink(
		priv.barrow.model.QuestionRecordLink questionRecordLink) {
		return _questionRecordLinkLocalService.addQuestionRecordLink(questionRecordLink);
	}

	/**
	* Creates a new question record link with the primary key. Does not add the question record link to the database.
	*
	* @param questionOrder the primary key for the new question record link
	* @return the new question record link
	*/
	@Override
	public priv.barrow.model.QuestionRecordLink createQuestionRecordLink(
		long questionOrder) {
		return _questionRecordLinkLocalService.createQuestionRecordLink(questionOrder);
	}

	/**
	* Deletes the question record link with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param questionOrder the primary key of the question record link
	* @return the question record link that was removed
	* @throws PortalException if a question record link with the primary key could not be found
	*/
	@Override
	public priv.barrow.model.QuestionRecordLink deleteQuestionRecordLink(
		long questionOrder)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _questionRecordLinkLocalService.deleteQuestionRecordLink(questionOrder);
	}

	/**
	* Deletes the question record link from the database. Also notifies the appropriate model listeners.
	*
	* @param questionRecordLink the question record link
	* @return the question record link that was removed
	*/
	@Override
	public priv.barrow.model.QuestionRecordLink deleteQuestionRecordLink(
		priv.barrow.model.QuestionRecordLink questionRecordLink) {
		return _questionRecordLinkLocalService.deleteQuestionRecordLink(questionRecordLink);
	}

	@Override
	public priv.barrow.model.QuestionRecordLink fetchQuestionRecordLink(
		long questionOrder) {
		return _questionRecordLinkLocalService.fetchQuestionRecordLink(questionOrder);
	}

	/**
	* Returns the question record link with the primary key.
	*
	* @param questionOrder the primary key of the question record link
	* @return the question record link
	* @throws PortalException if a question record link with the primary key could not be found
	*/
	@Override
	public priv.barrow.model.QuestionRecordLink getQuestionRecordLink(
		long questionOrder)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _questionRecordLinkLocalService.getQuestionRecordLink(questionOrder);
	}

	/**
	* Updates the question record link in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param questionRecordLink the question record link
	* @return the question record link that was updated
	*/
	@Override
	public priv.barrow.model.QuestionRecordLink updateQuestionRecordLink(
		priv.barrow.model.QuestionRecordLink questionRecordLink) {
		return _questionRecordLinkLocalService.updateQuestionRecordLink(questionRecordLink);
	}

	@Override
	public void addQuestionRecordLink(long recordId,
		java.lang.String questionDescription) {
		_questionRecordLinkLocalService.addQuestionRecordLink(recordId,
			questionDescription);
	}

	@Override
	public QuestionRecordLinkLocalService getWrappedService() {
		return _questionRecordLinkLocalService;
	}

	@Override
	public void setWrappedService(
		QuestionRecordLinkLocalService questionRecordLinkLocalService) {
		_questionRecordLinkLocalService = questionRecordLinkLocalService;
	}

	private QuestionRecordLinkLocalService _questionRecordLinkLocalService;
}