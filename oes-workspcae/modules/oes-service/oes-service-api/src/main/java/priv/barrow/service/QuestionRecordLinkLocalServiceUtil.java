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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.service.InvokableLocalService;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * Provides the local service utility for QuestionRecordLink. This utility wraps
 * {@link priv.barrow.service.impl.QuestionRecordLinkLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see QuestionRecordLinkLocalService
 * @see priv.barrow.service.base.QuestionRecordLinkLocalServiceBaseImpl
 * @see priv.barrow.service.impl.QuestionRecordLinkLocalServiceImpl
 * @generated
 */
@ProviderType
public class QuestionRecordLinkLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link priv.barrow.service.impl.QuestionRecordLinkLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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
	* Returns the number of question record links.
	*
	* @return the number of question record links
	*/
	public static int getQuestionRecordLinksCount() {
		return getService().getQuestionRecordLinksCount();
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link priv.barrow.model.impl.QuestionRecordLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link priv.barrow.model.impl.QuestionRecordLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static java.util.List<priv.barrow.model.QuestionRecordLink> finderRecentUpdateQuestionRecordLinks(
		int count) {
		return getService().finderRecentUpdateQuestionRecordLinks(count);
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
	public static java.util.List<priv.barrow.model.QuestionRecordLink> getQuestionRecordLinks(
		int start, int end) {
		return getService().getQuestionRecordLinks(start, end);
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
	* Adds the question record link to the database. Also notifies the appropriate model listeners.
	*
	* @param questionRecordLink the question record link
	* @return the question record link that was added
	*/
	public static priv.barrow.model.QuestionRecordLink addQuestionRecordLink(
		priv.barrow.model.QuestionRecordLink questionRecordLink) {
		return getService().addQuestionRecordLink(questionRecordLink);
	}

	/**
	* Creates a new question record link with the primary key. Does not add the question record link to the database.
	*
	* @param questionOrder the primary key for the new question record link
	* @return the new question record link
	*/
	public static priv.barrow.model.QuestionRecordLink createQuestionRecordLink(
		long questionOrder) {
		return getService().createQuestionRecordLink(questionOrder);
	}

	/**
	* Deletes the question record link with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param questionOrder the primary key of the question record link
	* @return the question record link that was removed
	* @throws PortalException if a question record link with the primary key could not be found
	*/
	public static priv.barrow.model.QuestionRecordLink deleteQuestionRecordLink(
		long questionOrder)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteQuestionRecordLink(questionOrder);
	}

	/**
	* Deletes the question record link from the database. Also notifies the appropriate model listeners.
	*
	* @param questionRecordLink the question record link
	* @return the question record link that was removed
	*/
	public static priv.barrow.model.QuestionRecordLink deleteQuestionRecordLink(
		priv.barrow.model.QuestionRecordLink questionRecordLink) {
		return getService().deleteQuestionRecordLink(questionRecordLink);
	}

	public static priv.barrow.model.QuestionRecordLink fetchQuestionRecordLink(
		long questionOrder) {
		return getService().fetchQuestionRecordLink(questionOrder);
	}

	/**
	* Returns the question record link with the primary key.
	*
	* @param questionOrder the primary key of the question record link
	* @return the question record link
	* @throws PortalException if a question record link with the primary key could not be found
	*/
	public static priv.barrow.model.QuestionRecordLink getQuestionRecordLink(
		long questionOrder)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getQuestionRecordLink(questionOrder);
	}

	/**
	* Updates the question record link in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param questionRecordLink the question record link
	* @return the question record link that was updated
	*/
	public static priv.barrow.model.QuestionRecordLink updateQuestionRecordLink(
		priv.barrow.model.QuestionRecordLink questionRecordLink) {
		return getService().updateQuestionRecordLink(questionRecordLink);
	}

	public static void clearService() {
		_service = null;
	}

	public static QuestionRecordLinkLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					QuestionRecordLinkLocalService.class.getName());

			if (invokableLocalService instanceof QuestionRecordLinkLocalService) {
				_service = (QuestionRecordLinkLocalService)invokableLocalService;
			}
			else {
				_service = new QuestionRecordLinkLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(QuestionRecordLinkLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	private static QuestionRecordLinkLocalService _service;
}