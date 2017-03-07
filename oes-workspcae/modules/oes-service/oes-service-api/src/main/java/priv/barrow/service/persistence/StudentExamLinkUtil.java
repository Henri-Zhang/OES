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

import priv.barrow.model.StudentExamLink;

import java.util.List;

/**
 * The persistence utility for the student exam link service. This utility wraps {@link priv.barrow.service.persistence.impl.StudentExamLinkPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StudentExamLinkPersistence
 * @see priv.barrow.service.persistence.impl.StudentExamLinkPersistenceImpl
 * @generated
 */
@ProviderType
public class StudentExamLinkUtil {
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
	public static void clearCache(StudentExamLink studentExamLink) {
		getPersistence().clearCache(studentExamLink);
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
	public static List<StudentExamLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<StudentExamLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<StudentExamLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<StudentExamLink> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static StudentExamLink update(StudentExamLink studentExamLink) {
		return getPersistence().update(studentExamLink);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static StudentExamLink update(StudentExamLink studentExamLink,
		ServiceContext serviceContext) {
		return getPersistence().update(studentExamLink, serviceContext);
	}

	/**
	* Returns all the student exam links where examRecordId = &#63;.
	*
	* @param examRecordId the exam record ID
	* @return the matching student exam links
	*/
	public static List<StudentExamLink> findByExamRecordId(long examRecordId) {
		return getPersistence().findByExamRecordId(examRecordId);
	}

	/**
	* Returns a range of all the student exam links where examRecordId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StudentExamLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param examRecordId the exam record ID
	* @param start the lower bound of the range of student exam links
	* @param end the upper bound of the range of student exam links (not inclusive)
	* @return the range of matching student exam links
	*/
	public static List<StudentExamLink> findByExamRecordId(long examRecordId,
		int start, int end) {
		return getPersistence().findByExamRecordId(examRecordId, start, end);
	}

	/**
	* Returns an ordered range of all the student exam links where examRecordId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StudentExamLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param examRecordId the exam record ID
	* @param start the lower bound of the range of student exam links
	* @param end the upper bound of the range of student exam links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching student exam links
	*/
	public static List<StudentExamLink> findByExamRecordId(long examRecordId,
		int start, int end, OrderByComparator<StudentExamLink> orderByComparator) {
		return getPersistence()
				   .findByExamRecordId(examRecordId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the student exam links where examRecordId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StudentExamLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param examRecordId the exam record ID
	* @param start the lower bound of the range of student exam links
	* @param end the upper bound of the range of student exam links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching student exam links
	*/
	public static List<StudentExamLink> findByExamRecordId(long examRecordId,
		int start, int end,
		OrderByComparator<StudentExamLink> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByExamRecordId(examRecordId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first student exam link in the ordered set where examRecordId = &#63;.
	*
	* @param examRecordId the exam record ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student exam link
	* @throws NoSuchStudentExamLinkException if a matching student exam link could not be found
	*/
	public static StudentExamLink findByExamRecordId_First(long examRecordId,
		OrderByComparator<StudentExamLink> orderByComparator)
		throws priv.barrow.exception.NoSuchStudentExamLinkException {
		return getPersistence()
				   .findByExamRecordId_First(examRecordId, orderByComparator);
	}

	/**
	* Returns the first student exam link in the ordered set where examRecordId = &#63;.
	*
	* @param examRecordId the exam record ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student exam link, or <code>null</code> if a matching student exam link could not be found
	*/
	public static StudentExamLink fetchByExamRecordId_First(long examRecordId,
		OrderByComparator<StudentExamLink> orderByComparator) {
		return getPersistence()
				   .fetchByExamRecordId_First(examRecordId, orderByComparator);
	}

	/**
	* Returns the last student exam link in the ordered set where examRecordId = &#63;.
	*
	* @param examRecordId the exam record ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student exam link
	* @throws NoSuchStudentExamLinkException if a matching student exam link could not be found
	*/
	public static StudentExamLink findByExamRecordId_Last(long examRecordId,
		OrderByComparator<StudentExamLink> orderByComparator)
		throws priv.barrow.exception.NoSuchStudentExamLinkException {
		return getPersistence()
				   .findByExamRecordId_Last(examRecordId, orderByComparator);
	}

	/**
	* Returns the last student exam link in the ordered set where examRecordId = &#63;.
	*
	* @param examRecordId the exam record ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student exam link, or <code>null</code> if a matching student exam link could not be found
	*/
	public static StudentExamLink fetchByExamRecordId_Last(long examRecordId,
		OrderByComparator<StudentExamLink> orderByComparator) {
		return getPersistence()
				   .fetchByExamRecordId_Last(examRecordId, orderByComparator);
	}

	/**
	* Returns the student exam links before and after the current student exam link in the ordered set where examRecordId = &#63;.
	*
	* @param studentExamLinkPK the primary key of the current student exam link
	* @param examRecordId the exam record ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next student exam link
	* @throws NoSuchStudentExamLinkException if a student exam link with the primary key could not be found
	*/
	public static StudentExamLink[] findByExamRecordId_PrevAndNext(
		priv.barrow.service.persistence.StudentExamLinkPK studentExamLinkPK,
		long examRecordId, OrderByComparator<StudentExamLink> orderByComparator)
		throws priv.barrow.exception.NoSuchStudentExamLinkException {
		return getPersistence()
				   .findByExamRecordId_PrevAndNext(studentExamLinkPK,
			examRecordId, orderByComparator);
	}

	/**
	* Removes all the student exam links where examRecordId = &#63; from the database.
	*
	* @param examRecordId the exam record ID
	*/
	public static void removeByExamRecordId(long examRecordId) {
		getPersistence().removeByExamRecordId(examRecordId);
	}

	/**
	* Returns the number of student exam links where examRecordId = &#63;.
	*
	* @param examRecordId the exam record ID
	* @return the number of matching student exam links
	*/
	public static int countByExamRecordId(long examRecordId) {
		return getPersistence().countByExamRecordId(examRecordId);
	}

	/**
	* Returns all the student exam links where studentId = &#63;.
	*
	* @param studentId the student ID
	* @return the matching student exam links
	*/
	public static List<StudentExamLink> findByStudentId(long studentId) {
		return getPersistence().findByStudentId(studentId);
	}

	/**
	* Returns a range of all the student exam links where studentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StudentExamLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param studentId the student ID
	* @param start the lower bound of the range of student exam links
	* @param end the upper bound of the range of student exam links (not inclusive)
	* @return the range of matching student exam links
	*/
	public static List<StudentExamLink> findByStudentId(long studentId,
		int start, int end) {
		return getPersistence().findByStudentId(studentId, start, end);
	}

	/**
	* Returns an ordered range of all the student exam links where studentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StudentExamLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param studentId the student ID
	* @param start the lower bound of the range of student exam links
	* @param end the upper bound of the range of student exam links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching student exam links
	*/
	public static List<StudentExamLink> findByStudentId(long studentId,
		int start, int end, OrderByComparator<StudentExamLink> orderByComparator) {
		return getPersistence()
				   .findByStudentId(studentId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the student exam links where studentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StudentExamLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param studentId the student ID
	* @param start the lower bound of the range of student exam links
	* @param end the upper bound of the range of student exam links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching student exam links
	*/
	public static List<StudentExamLink> findByStudentId(long studentId,
		int start, int end,
		OrderByComparator<StudentExamLink> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByStudentId(studentId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first student exam link in the ordered set where studentId = &#63;.
	*
	* @param studentId the student ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student exam link
	* @throws NoSuchStudentExamLinkException if a matching student exam link could not be found
	*/
	public static StudentExamLink findByStudentId_First(long studentId,
		OrderByComparator<StudentExamLink> orderByComparator)
		throws priv.barrow.exception.NoSuchStudentExamLinkException {
		return getPersistence()
				   .findByStudentId_First(studentId, orderByComparator);
	}

	/**
	* Returns the first student exam link in the ordered set where studentId = &#63;.
	*
	* @param studentId the student ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student exam link, or <code>null</code> if a matching student exam link could not be found
	*/
	public static StudentExamLink fetchByStudentId_First(long studentId,
		OrderByComparator<StudentExamLink> orderByComparator) {
		return getPersistence()
				   .fetchByStudentId_First(studentId, orderByComparator);
	}

	/**
	* Returns the last student exam link in the ordered set where studentId = &#63;.
	*
	* @param studentId the student ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student exam link
	* @throws NoSuchStudentExamLinkException if a matching student exam link could not be found
	*/
	public static StudentExamLink findByStudentId_Last(long studentId,
		OrderByComparator<StudentExamLink> orderByComparator)
		throws priv.barrow.exception.NoSuchStudentExamLinkException {
		return getPersistence()
				   .findByStudentId_Last(studentId, orderByComparator);
	}

	/**
	* Returns the last student exam link in the ordered set where studentId = &#63;.
	*
	* @param studentId the student ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student exam link, or <code>null</code> if a matching student exam link could not be found
	*/
	public static StudentExamLink fetchByStudentId_Last(long studentId,
		OrderByComparator<StudentExamLink> orderByComparator) {
		return getPersistence()
				   .fetchByStudentId_Last(studentId, orderByComparator);
	}

	/**
	* Returns the student exam links before and after the current student exam link in the ordered set where studentId = &#63;.
	*
	* @param studentExamLinkPK the primary key of the current student exam link
	* @param studentId the student ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next student exam link
	* @throws NoSuchStudentExamLinkException if a student exam link with the primary key could not be found
	*/
	public static StudentExamLink[] findByStudentId_PrevAndNext(
		priv.barrow.service.persistence.StudentExamLinkPK studentExamLinkPK,
		long studentId, OrderByComparator<StudentExamLink> orderByComparator)
		throws priv.barrow.exception.NoSuchStudentExamLinkException {
		return getPersistence()
				   .findByStudentId_PrevAndNext(studentExamLinkPK, studentId,
			orderByComparator);
	}

	/**
	* Removes all the student exam links where studentId = &#63; from the database.
	*
	* @param studentId the student ID
	*/
	public static void removeByStudentId(long studentId) {
		getPersistence().removeByStudentId(studentId);
	}

	/**
	* Returns the number of student exam links where studentId = &#63;.
	*
	* @param studentId the student ID
	* @return the number of matching student exam links
	*/
	public static int countByStudentId(long studentId) {
		return getPersistence().countByStudentId(studentId);
	}

	/**
	* Returns all the student exam links where studentId = &#63; and inProgress = &#63; and done = &#63;.
	*
	* @param studentId the student ID
	* @param inProgress the in progress
	* @param done the done
	* @return the matching student exam links
	*/
	public static List<StudentExamLink> findByStudentIdAndStatus(
		long studentId, boolean inProgress, boolean done) {
		return getPersistence()
				   .findByStudentIdAndStatus(studentId, inProgress, done);
	}

	/**
	* Returns a range of all the student exam links where studentId = &#63; and inProgress = &#63; and done = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StudentExamLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param studentId the student ID
	* @param inProgress the in progress
	* @param done the done
	* @param start the lower bound of the range of student exam links
	* @param end the upper bound of the range of student exam links (not inclusive)
	* @return the range of matching student exam links
	*/
	public static List<StudentExamLink> findByStudentIdAndStatus(
		long studentId, boolean inProgress, boolean done, int start, int end) {
		return getPersistence()
				   .findByStudentIdAndStatus(studentId, inProgress, done,
			start, end);
	}

	/**
	* Returns an ordered range of all the student exam links where studentId = &#63; and inProgress = &#63; and done = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StudentExamLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param studentId the student ID
	* @param inProgress the in progress
	* @param done the done
	* @param start the lower bound of the range of student exam links
	* @param end the upper bound of the range of student exam links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching student exam links
	*/
	public static List<StudentExamLink> findByStudentIdAndStatus(
		long studentId, boolean inProgress, boolean done, int start, int end,
		OrderByComparator<StudentExamLink> orderByComparator) {
		return getPersistence()
				   .findByStudentIdAndStatus(studentId, inProgress, done,
			start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the student exam links where studentId = &#63; and inProgress = &#63; and done = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StudentExamLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param studentId the student ID
	* @param inProgress the in progress
	* @param done the done
	* @param start the lower bound of the range of student exam links
	* @param end the upper bound of the range of student exam links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching student exam links
	*/
	public static List<StudentExamLink> findByStudentIdAndStatus(
		long studentId, boolean inProgress, boolean done, int start, int end,
		OrderByComparator<StudentExamLink> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByStudentIdAndStatus(studentId, inProgress, done,
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first student exam link in the ordered set where studentId = &#63; and inProgress = &#63; and done = &#63;.
	*
	* @param studentId the student ID
	* @param inProgress the in progress
	* @param done the done
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student exam link
	* @throws NoSuchStudentExamLinkException if a matching student exam link could not be found
	*/
	public static StudentExamLink findByStudentIdAndStatus_First(
		long studentId, boolean inProgress, boolean done,
		OrderByComparator<StudentExamLink> orderByComparator)
		throws priv.barrow.exception.NoSuchStudentExamLinkException {
		return getPersistence()
				   .findByStudentIdAndStatus_First(studentId, inProgress, done,
			orderByComparator);
	}

	/**
	* Returns the first student exam link in the ordered set where studentId = &#63; and inProgress = &#63; and done = &#63;.
	*
	* @param studentId the student ID
	* @param inProgress the in progress
	* @param done the done
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student exam link, or <code>null</code> if a matching student exam link could not be found
	*/
	public static StudentExamLink fetchByStudentIdAndStatus_First(
		long studentId, boolean inProgress, boolean done,
		OrderByComparator<StudentExamLink> orderByComparator) {
		return getPersistence()
				   .fetchByStudentIdAndStatus_First(studentId, inProgress,
			done, orderByComparator);
	}

	/**
	* Returns the last student exam link in the ordered set where studentId = &#63; and inProgress = &#63; and done = &#63;.
	*
	* @param studentId the student ID
	* @param inProgress the in progress
	* @param done the done
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student exam link
	* @throws NoSuchStudentExamLinkException if a matching student exam link could not be found
	*/
	public static StudentExamLink findByStudentIdAndStatus_Last(
		long studentId, boolean inProgress, boolean done,
		OrderByComparator<StudentExamLink> orderByComparator)
		throws priv.barrow.exception.NoSuchStudentExamLinkException {
		return getPersistence()
				   .findByStudentIdAndStatus_Last(studentId, inProgress, done,
			orderByComparator);
	}

	/**
	* Returns the last student exam link in the ordered set where studentId = &#63; and inProgress = &#63; and done = &#63;.
	*
	* @param studentId the student ID
	* @param inProgress the in progress
	* @param done the done
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student exam link, or <code>null</code> if a matching student exam link could not be found
	*/
	public static StudentExamLink fetchByStudentIdAndStatus_Last(
		long studentId, boolean inProgress, boolean done,
		OrderByComparator<StudentExamLink> orderByComparator) {
		return getPersistence()
				   .fetchByStudentIdAndStatus_Last(studentId, inProgress, done,
			orderByComparator);
	}

	/**
	* Returns the student exam links before and after the current student exam link in the ordered set where studentId = &#63; and inProgress = &#63; and done = &#63;.
	*
	* @param studentExamLinkPK the primary key of the current student exam link
	* @param studentId the student ID
	* @param inProgress the in progress
	* @param done the done
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next student exam link
	* @throws NoSuchStudentExamLinkException if a student exam link with the primary key could not be found
	*/
	public static StudentExamLink[] findByStudentIdAndStatus_PrevAndNext(
		priv.barrow.service.persistence.StudentExamLinkPK studentExamLinkPK,
		long studentId, boolean inProgress, boolean done,
		OrderByComparator<StudentExamLink> orderByComparator)
		throws priv.barrow.exception.NoSuchStudentExamLinkException {
		return getPersistence()
				   .findByStudentIdAndStatus_PrevAndNext(studentExamLinkPK,
			studentId, inProgress, done, orderByComparator);
	}

	/**
	* Removes all the student exam links where studentId = &#63; and inProgress = &#63; and done = &#63; from the database.
	*
	* @param studentId the student ID
	* @param inProgress the in progress
	* @param done the done
	*/
	public static void removeByStudentIdAndStatus(long studentId,
		boolean inProgress, boolean done) {
		getPersistence().removeByStudentIdAndStatus(studentId, inProgress, done);
	}

	/**
	* Returns the number of student exam links where studentId = &#63; and inProgress = &#63; and done = &#63;.
	*
	* @param studentId the student ID
	* @param inProgress the in progress
	* @param done the done
	* @return the number of matching student exam links
	*/
	public static int countByStudentIdAndStatus(long studentId,
		boolean inProgress, boolean done) {
		return getPersistence()
				   .countByStudentIdAndStatus(studentId, inProgress, done);
	}

	/**
	* Caches the student exam link in the entity cache if it is enabled.
	*
	* @param studentExamLink the student exam link
	*/
	public static void cacheResult(StudentExamLink studentExamLink) {
		getPersistence().cacheResult(studentExamLink);
	}

	/**
	* Caches the student exam links in the entity cache if it is enabled.
	*
	* @param studentExamLinks the student exam links
	*/
	public static void cacheResult(List<StudentExamLink> studentExamLinks) {
		getPersistence().cacheResult(studentExamLinks);
	}

	/**
	* Creates a new student exam link with the primary key. Does not add the student exam link to the database.
	*
	* @param studentExamLinkPK the primary key for the new student exam link
	* @return the new student exam link
	*/
	public static StudentExamLink create(
		priv.barrow.service.persistence.StudentExamLinkPK studentExamLinkPK) {
		return getPersistence().create(studentExamLinkPK);
	}

	/**
	* Removes the student exam link with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param studentExamLinkPK the primary key of the student exam link
	* @return the student exam link that was removed
	* @throws NoSuchStudentExamLinkException if a student exam link with the primary key could not be found
	*/
	public static StudentExamLink remove(
		priv.barrow.service.persistence.StudentExamLinkPK studentExamLinkPK)
		throws priv.barrow.exception.NoSuchStudentExamLinkException {
		return getPersistence().remove(studentExamLinkPK);
	}

	public static StudentExamLink updateImpl(StudentExamLink studentExamLink) {
		return getPersistence().updateImpl(studentExamLink);
	}

	/**
	* Returns the student exam link with the primary key or throws a {@link NoSuchStudentExamLinkException} if it could not be found.
	*
	* @param studentExamLinkPK the primary key of the student exam link
	* @return the student exam link
	* @throws NoSuchStudentExamLinkException if a student exam link with the primary key could not be found
	*/
	public static StudentExamLink findByPrimaryKey(
		priv.barrow.service.persistence.StudentExamLinkPK studentExamLinkPK)
		throws priv.barrow.exception.NoSuchStudentExamLinkException {
		return getPersistence().findByPrimaryKey(studentExamLinkPK);
	}

	/**
	* Returns the student exam link with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param studentExamLinkPK the primary key of the student exam link
	* @return the student exam link, or <code>null</code> if a student exam link with the primary key could not be found
	*/
	public static StudentExamLink fetchByPrimaryKey(
		priv.barrow.service.persistence.StudentExamLinkPK studentExamLinkPK) {
		return getPersistence().fetchByPrimaryKey(studentExamLinkPK);
	}

	public static java.util.Map<java.io.Serializable, StudentExamLink> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the student exam links.
	*
	* @return the student exam links
	*/
	public static List<StudentExamLink> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the student exam links.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StudentExamLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of student exam links
	* @param end the upper bound of the range of student exam links (not inclusive)
	* @return the range of student exam links
	*/
	public static List<StudentExamLink> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the student exam links.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StudentExamLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of student exam links
	* @param end the upper bound of the range of student exam links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of student exam links
	*/
	public static List<StudentExamLink> findAll(int start, int end,
		OrderByComparator<StudentExamLink> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the student exam links.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StudentExamLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of student exam links
	* @param end the upper bound of the range of student exam links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of student exam links
	*/
	public static List<StudentExamLink> findAll(int start, int end,
		OrderByComparator<StudentExamLink> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the student exam links from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of student exam links.
	*
	* @return the number of student exam links
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static StudentExamLinkPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<StudentExamLinkPersistence, StudentExamLinkPersistence> _serviceTracker =
		ServiceTrackerFactory.open(StudentExamLinkPersistence.class);
}