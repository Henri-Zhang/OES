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

import priv.barrow.model.StudentTeacherLink;

import java.util.List;

/**
 * The persistence utility for the student teacher link service. This utility wraps {@link priv.barrow.service.persistence.impl.StudentTeacherLinkPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StudentTeacherLinkPersistence
 * @see priv.barrow.service.persistence.impl.StudentTeacherLinkPersistenceImpl
 * @generated
 */
@ProviderType
public class StudentTeacherLinkUtil {
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
	public static void clearCache(StudentTeacherLink studentTeacherLink) {
		getPersistence().clearCache(studentTeacherLink);
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
	public static List<StudentTeacherLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<StudentTeacherLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<StudentTeacherLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<StudentTeacherLink> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static StudentTeacherLink update(
		StudentTeacherLink studentTeacherLink) {
		return getPersistence().update(studentTeacherLink);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static StudentTeacherLink update(
		StudentTeacherLink studentTeacherLink, ServiceContext serviceContext) {
		return getPersistence().update(studentTeacherLink, serviceContext);
	}

	/**
	* Returns all the student teacher links where studentId = &#63;.
	*
	* @param studentId the student ID
	* @return the matching student teacher links
	*/
	public static List<StudentTeacherLink> findByteacherId(long studentId) {
		return getPersistence().findByteacherId(studentId);
	}

	/**
	* Returns a range of all the student teacher links where studentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StudentTeacherLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param studentId the student ID
	* @param start the lower bound of the range of student teacher links
	* @param end the upper bound of the range of student teacher links (not inclusive)
	* @return the range of matching student teacher links
	*/
	public static List<StudentTeacherLink> findByteacherId(long studentId,
		int start, int end) {
		return getPersistence().findByteacherId(studentId, start, end);
	}

	/**
	* Returns an ordered range of all the student teacher links where studentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StudentTeacherLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param studentId the student ID
	* @param start the lower bound of the range of student teacher links
	* @param end the upper bound of the range of student teacher links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching student teacher links
	*/
	public static List<StudentTeacherLink> findByteacherId(long studentId,
		int start, int end,
		OrderByComparator<StudentTeacherLink> orderByComparator) {
		return getPersistence()
				   .findByteacherId(studentId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the student teacher links where studentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StudentTeacherLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param studentId the student ID
	* @param start the lower bound of the range of student teacher links
	* @param end the upper bound of the range of student teacher links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching student teacher links
	*/
	public static List<StudentTeacherLink> findByteacherId(long studentId,
		int start, int end,
		OrderByComparator<StudentTeacherLink> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByteacherId(studentId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first student teacher link in the ordered set where studentId = &#63;.
	*
	* @param studentId the student ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student teacher link
	* @throws NoSuchStudentTeacherLinkException if a matching student teacher link could not be found
	*/
	public static StudentTeacherLink findByteacherId_First(long studentId,
		OrderByComparator<StudentTeacherLink> orderByComparator)
		throws priv.barrow.exception.NoSuchStudentTeacherLinkException {
		return getPersistence()
				   .findByteacherId_First(studentId, orderByComparator);
	}

	/**
	* Returns the first student teacher link in the ordered set where studentId = &#63;.
	*
	* @param studentId the student ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student teacher link, or <code>null</code> if a matching student teacher link could not be found
	*/
	public static StudentTeacherLink fetchByteacherId_First(long studentId,
		OrderByComparator<StudentTeacherLink> orderByComparator) {
		return getPersistence()
				   .fetchByteacherId_First(studentId, orderByComparator);
	}

	/**
	* Returns the last student teacher link in the ordered set where studentId = &#63;.
	*
	* @param studentId the student ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student teacher link
	* @throws NoSuchStudentTeacherLinkException if a matching student teacher link could not be found
	*/
	public static StudentTeacherLink findByteacherId_Last(long studentId,
		OrderByComparator<StudentTeacherLink> orderByComparator)
		throws priv.barrow.exception.NoSuchStudentTeacherLinkException {
		return getPersistence()
				   .findByteacherId_Last(studentId, orderByComparator);
	}

	/**
	* Returns the last student teacher link in the ordered set where studentId = &#63;.
	*
	* @param studentId the student ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student teacher link, or <code>null</code> if a matching student teacher link could not be found
	*/
	public static StudentTeacherLink fetchByteacherId_Last(long studentId,
		OrderByComparator<StudentTeacherLink> orderByComparator) {
		return getPersistence()
				   .fetchByteacherId_Last(studentId, orderByComparator);
	}

	/**
	* Removes all the student teacher links where studentId = &#63; from the database.
	*
	* @param studentId the student ID
	*/
	public static void removeByteacherId(long studentId) {
		getPersistence().removeByteacherId(studentId);
	}

	/**
	* Returns the number of student teacher links where studentId = &#63;.
	*
	* @param studentId the student ID
	* @return the number of matching student teacher links
	*/
	public static int countByteacherId(long studentId) {
		return getPersistence().countByteacherId(studentId);
	}

	/**
	* Caches the student teacher link in the entity cache if it is enabled.
	*
	* @param studentTeacherLink the student teacher link
	*/
	public static void cacheResult(StudentTeacherLink studentTeacherLink) {
		getPersistence().cacheResult(studentTeacherLink);
	}

	/**
	* Caches the student teacher links in the entity cache if it is enabled.
	*
	* @param studentTeacherLinks the student teacher links
	*/
	public static void cacheResult(List<StudentTeacherLink> studentTeacherLinks) {
		getPersistence().cacheResult(studentTeacherLinks);
	}

	/**
	* Creates a new student teacher link with the primary key. Does not add the student teacher link to the database.
	*
	* @param studentId the primary key for the new student teacher link
	* @return the new student teacher link
	*/
	public static StudentTeacherLink create(long studentId) {
		return getPersistence().create(studentId);
	}

	/**
	* Removes the student teacher link with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param studentId the primary key of the student teacher link
	* @return the student teacher link that was removed
	* @throws NoSuchStudentTeacherLinkException if a student teacher link with the primary key could not be found
	*/
	public static StudentTeacherLink remove(long studentId)
		throws priv.barrow.exception.NoSuchStudentTeacherLinkException {
		return getPersistence().remove(studentId);
	}

	public static StudentTeacherLink updateImpl(
		StudentTeacherLink studentTeacherLink) {
		return getPersistence().updateImpl(studentTeacherLink);
	}

	/**
	* Returns the student teacher link with the primary key or throws a {@link NoSuchStudentTeacherLinkException} if it could not be found.
	*
	* @param studentId the primary key of the student teacher link
	* @return the student teacher link
	* @throws NoSuchStudentTeacherLinkException if a student teacher link with the primary key could not be found
	*/
	public static StudentTeacherLink findByPrimaryKey(long studentId)
		throws priv.barrow.exception.NoSuchStudentTeacherLinkException {
		return getPersistence().findByPrimaryKey(studentId);
	}

	/**
	* Returns the student teacher link with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param studentId the primary key of the student teacher link
	* @return the student teacher link, or <code>null</code> if a student teacher link with the primary key could not be found
	*/
	public static StudentTeacherLink fetchByPrimaryKey(long studentId) {
		return getPersistence().fetchByPrimaryKey(studentId);
	}

	public static java.util.Map<java.io.Serializable, StudentTeacherLink> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the student teacher links.
	*
	* @return the student teacher links
	*/
	public static List<StudentTeacherLink> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the student teacher links.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StudentTeacherLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of student teacher links
	* @param end the upper bound of the range of student teacher links (not inclusive)
	* @return the range of student teacher links
	*/
	public static List<StudentTeacherLink> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the student teacher links.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StudentTeacherLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of student teacher links
	* @param end the upper bound of the range of student teacher links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of student teacher links
	*/
	public static List<StudentTeacherLink> findAll(int start, int end,
		OrderByComparator<StudentTeacherLink> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the student teacher links.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StudentTeacherLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of student teacher links
	* @param end the upper bound of the range of student teacher links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of student teacher links
	*/
	public static List<StudentTeacherLink> findAll(int start, int end,
		OrderByComparator<StudentTeacherLink> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the student teacher links from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of student teacher links.
	*
	* @return the number of student teacher links
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static StudentTeacherLinkPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<StudentTeacherLinkPersistence, StudentTeacherLinkPersistence> _serviceTracker =
		ServiceTrackerFactory.open(StudentTeacherLinkPersistence.class);
}