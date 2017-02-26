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
 * Provides the local service utility for TeacherUserLink. This utility wraps
 * {@link priv.barrow.service.impl.TeacherUserLinkLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see TeacherUserLinkLocalService
 * @see priv.barrow.service.base.TeacherUserLinkLocalServiceBaseImpl
 * @see priv.barrow.service.impl.TeacherUserLinkLocalServiceImpl
 * @generated
 */
@ProviderType
public class TeacherUserLinkLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link priv.barrow.service.impl.TeacherUserLinkLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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
	* Returns the number of teacher user links.
	*
	* @return the number of teacher user links
	*/
	public static int getTeacherUserLinksCount() {
		return getService().getTeacherUserLinksCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link priv.barrow.model.impl.TeacherUserLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link priv.barrow.model.impl.TeacherUserLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	/**
	* Returns a range of all the teacher user links.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link priv.barrow.model.impl.TeacherUserLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of teacher user links
	* @param end the upper bound of the range of teacher user links (not inclusive)
	* @return the range of teacher user links
	*/
	public static java.util.List<priv.barrow.model.TeacherUserLink> getTeacherUserLinks(
		int start, int end) {
		return getService().getTeacherUserLinks(start, end);
	}

	public static java.util.List<priv.barrow.model.TeacherUserLink> searchTeacherUsers(
		java.lang.String keyword) {
		return getService().searchTeacherUsers(keyword);
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
	* Adds the teacher user link to the database. Also notifies the appropriate model listeners.
	*
	* @param teacherUserLink the teacher user link
	* @return the teacher user link that was added
	*/
	public static priv.barrow.model.TeacherUserLink addTeacherUserLink(
		priv.barrow.model.TeacherUserLink teacherUserLink) {
		return getService().addTeacherUserLink(teacherUserLink);
	}

	/**
	* Creates a new teacher user link with the primary key. Does not add the teacher user link to the database.
	*
	* @param teacherNumber the primary key for the new teacher user link
	* @return the new teacher user link
	*/
	public static priv.barrow.model.TeacherUserLink createTeacherUserLink(
		long teacherNumber) {
		return getService().createTeacherUserLink(teacherNumber);
	}

	/**
	* Deletes the teacher user link with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param teacherNumber the primary key of the teacher user link
	* @return the teacher user link that was removed
	* @throws PortalException if a teacher user link with the primary key could not be found
	*/
	public static priv.barrow.model.TeacherUserLink deleteTeacherUserLink(
		long teacherNumber)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteTeacherUserLink(teacherNumber);
	}

	/**
	* Deletes the teacher user link from the database. Also notifies the appropriate model listeners.
	*
	* @param teacherUserLink the teacher user link
	* @return the teacher user link that was removed
	*/
	public static priv.barrow.model.TeacherUserLink deleteTeacherUserLink(
		priv.barrow.model.TeacherUserLink teacherUserLink) {
		return getService().deleteTeacherUserLink(teacherUserLink);
	}

	public static priv.barrow.model.TeacherUserLink fetchTeacherUserLink(
		long teacherNumber) {
		return getService().fetchTeacherUserLink(teacherNumber);
	}

	/**
	* Returns the teacher user link with the primary key.
	*
	* @param teacherNumber the primary key of the teacher user link
	* @return the teacher user link
	* @throws PortalException if a teacher user link with the primary key could not be found
	*/
	public static priv.barrow.model.TeacherUserLink getTeacherUserLink(
		long teacherNumber)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getTeacherUserLink(teacherNumber);
	}

	/**
	* Updates the teacher user link in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param teacherUserLink the teacher user link
	* @return the teacher user link that was updated
	*/
	public static priv.barrow.model.TeacherUserLink updateTeacherUserLink(
		priv.barrow.model.TeacherUserLink teacherUserLink) {
		return getService().updateTeacherUserLink(teacherUserLink);
	}

	public static TeacherUserLinkLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TeacherUserLinkLocalService, TeacherUserLinkLocalService> _serviceTracker =
		ServiceTrackerFactory.open(TeacherUserLinkLocalService.class);
}