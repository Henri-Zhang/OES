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

package priv.barrow.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import priv.barrow.model.TeacherUserLink;

import java.util.List;

/**
 * The persistence utility for the teacher user link service. This utility wraps {@link priv.barrow.service.persistence.impl.TeacherUserLinkPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TeacherUserLinkPersistence
 * @see priv.barrow.service.persistence.impl.TeacherUserLinkPersistenceImpl
 * @generated
 */
@ProviderType
public class TeacherUserLinkUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(TeacherUserLink teacherUserLink) {
		getPersistence().clearCache(teacherUserLink);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TeacherUserLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TeacherUserLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TeacherUserLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TeacherUserLink> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TeacherUserLink update(TeacherUserLink teacherUserLink) {
		return getPersistence().update(teacherUserLink);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TeacherUserLink update(TeacherUserLink teacherUserLink,
		ServiceContext serviceContext) {
		return getPersistence().update(teacherUserLink, serviceContext);
	}

	/**
	* Caches the teacher user link in the entity cache if it is enabled.
	*
	* @param teacherUserLink the teacher user link
	*/
	public static void cacheResult(TeacherUserLink teacherUserLink) {
		getPersistence().cacheResult(teacherUserLink);
	}

	/**
	* Caches the teacher user links in the entity cache if it is enabled.
	*
	* @param teacherUserLinks the teacher user links
	*/
	public static void cacheResult(List<TeacherUserLink> teacherUserLinks) {
		getPersistence().cacheResult(teacherUserLinks);
	}

	/**
	* Creates a new teacher user link with the primary key. Does not add the teacher user link to the database.
	*
	* @param teacherNumber the primary key for the new teacher user link
	* @return the new teacher user link
	*/
	public static TeacherUserLink create(long teacherNumber) {
		return getPersistence().create(teacherNumber);
	}

	/**
	* Removes the teacher user link with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param teacherNumber the primary key of the teacher user link
	* @return the teacher user link that was removed
	* @throws NoSuchTeacherUserLinkException if a teacher user link with the primary key could not be found
	*/
	public static TeacherUserLink remove(long teacherNumber)
		throws priv.barrow.exception.NoSuchTeacherUserLinkException {
		return getPersistence().remove(teacherNumber);
	}

	public static TeacherUserLink updateImpl(TeacherUserLink teacherUserLink) {
		return getPersistence().updateImpl(teacherUserLink);
	}

	/**
	* Returns the teacher user link with the primary key or throws a {@link NoSuchTeacherUserLinkException} if it could not be found.
	*
	* @param teacherNumber the primary key of the teacher user link
	* @return the teacher user link
	* @throws NoSuchTeacherUserLinkException if a teacher user link with the primary key could not be found
	*/
	public static TeacherUserLink findByPrimaryKey(long teacherNumber)
		throws priv.barrow.exception.NoSuchTeacherUserLinkException {
		return getPersistence().findByPrimaryKey(teacherNumber);
	}

	/**
	* Returns the teacher user link with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param teacherNumber the primary key of the teacher user link
	* @return the teacher user link, or <code>null</code> if a teacher user link with the primary key could not be found
	*/
	public static TeacherUserLink fetchByPrimaryKey(long teacherNumber) {
		return getPersistence().fetchByPrimaryKey(teacherNumber);
	}

	public static java.util.Map<java.io.Serializable, TeacherUserLink> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the teacher user links.
	*
	* @return the teacher user links
	*/
	public static List<TeacherUserLink> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the teacher user links.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TeacherUserLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of teacher user links
	* @param end the upper bound of the range of teacher user links (not inclusive)
	* @return the range of teacher user links
	*/
	public static List<TeacherUserLink> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the teacher user links.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TeacherUserLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of teacher user links
	* @param end the upper bound of the range of teacher user links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of teacher user links
	*/
	public static List<TeacherUserLink> findAll(int start, int end,
		OrderByComparator<TeacherUserLink> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the teacher user links.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TeacherUserLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of teacher user links
	* @param end the upper bound of the range of teacher user links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of teacher user links
	*/
	public static List<TeacherUserLink> findAll(int start, int end,
		OrderByComparator<TeacherUserLink> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the teacher user links from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of teacher user links.
	*
	* @return the number of teacher user links
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TeacherUserLinkPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TeacherUserLinkPersistence, TeacherUserLinkPersistence> _serviceTracker =
		ServiceTrackerFactory.open(TeacherUserLinkPersistence.class);
}