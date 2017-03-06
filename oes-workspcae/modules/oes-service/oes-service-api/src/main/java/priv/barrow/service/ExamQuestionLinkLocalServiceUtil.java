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
 * Provides the local service utility for ExamQuestionLink. This utility wraps
 * {@link priv.barrow.service.impl.ExamQuestionLinkLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ExamQuestionLinkLocalService
 * @see priv.barrow.service.base.ExamQuestionLinkLocalServiceBaseImpl
 * @see priv.barrow.service.impl.ExamQuestionLinkLocalServiceImpl
 * @generated
 */
@ProviderType
public class ExamQuestionLinkLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link priv.barrow.service.impl.ExamQuestionLinkLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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
	* Returns the number of exam question links.
	*
	* @return the number of exam question links
	*/
	public static int getExamQuestionLinksCount() {
		return getService().getExamQuestionLinksCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link priv.barrow.model.impl.ExamQuestionLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link priv.barrow.model.impl.ExamQuestionLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static java.util.List<priv.barrow.model.ExamQuestionLink> findByexamRecordId(
		long examRecordId) {
		return getService().findByexamRecordId(examRecordId);
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
	public static java.util.List<priv.barrow.model.ExamQuestionLink> getExamQuestionLinks(
		int start, int end) {
		return getService().getExamQuestionLinks(start, end);
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
	* Adds the exam question link to the database. Also notifies the appropriate model listeners.
	*
	* @param examQuestionLink the exam question link
	* @return the exam question link that was added
	*/
	public static priv.barrow.model.ExamQuestionLink addExamQuestionLink(
		priv.barrow.model.ExamQuestionLink examQuestionLink) {
		return getService().addExamQuestionLink(examQuestionLink);
	}

	/**
	* Creates a new exam question link with the primary key. Does not add the exam question link to the database.
	*
	* @param examQuestionLinkPK the primary key for the new exam question link
	* @return the new exam question link
	*/
	public static priv.barrow.model.ExamQuestionLink createExamQuestionLink(
		priv.barrow.service.persistence.ExamQuestionLinkPK examQuestionLinkPK) {
		return getService().createExamQuestionLink(examQuestionLinkPK);
	}

	/**
	* Deletes the exam question link from the database. Also notifies the appropriate model listeners.
	*
	* @param examQuestionLink the exam question link
	* @return the exam question link that was removed
	*/
	public static priv.barrow.model.ExamQuestionLink deleteExamQuestionLink(
		priv.barrow.model.ExamQuestionLink examQuestionLink) {
		return getService().deleteExamQuestionLink(examQuestionLink);
	}

	/**
	* Deletes the exam question link with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param examQuestionLinkPK the primary key of the exam question link
	* @return the exam question link that was removed
	* @throws PortalException if a exam question link with the primary key could not be found
	*/
	public static priv.barrow.model.ExamQuestionLink deleteExamQuestionLink(
		priv.barrow.service.persistence.ExamQuestionLinkPK examQuestionLinkPK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteExamQuestionLink(examQuestionLinkPK);
	}

	public static priv.barrow.model.ExamQuestionLink fetchExamQuestionLink(
		priv.barrow.service.persistence.ExamQuestionLinkPK examQuestionLinkPK) {
		return getService().fetchExamQuestionLink(examQuestionLinkPK);
	}

	/**
	* Returns the exam question link with the primary key.
	*
	* @param examQuestionLinkPK the primary key of the exam question link
	* @return the exam question link
	* @throws PortalException if a exam question link with the primary key could not be found
	*/
	public static priv.barrow.model.ExamQuestionLink getExamQuestionLink(
		priv.barrow.service.persistence.ExamQuestionLinkPK examQuestionLinkPK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getExamQuestionLink(examQuestionLinkPK);
	}

	/**
	* Updates the exam question link in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param examQuestionLink the exam question link
	* @return the exam question link that was updated
	*/
	public static priv.barrow.model.ExamQuestionLink updateExamQuestionLink(
		priv.barrow.model.ExamQuestionLink examQuestionLink) {
		return getService().updateExamQuestionLink(examQuestionLink);
	}

	public static ExamQuestionLinkLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ExamQuestionLinkLocalService, ExamQuestionLinkLocalService> _serviceTracker =
		ServiceTrackerFactory.open(ExamQuestionLinkLocalService.class);
}