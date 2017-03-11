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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import priv.barrow.exception.NoSuchStudentExamLinkException;

import priv.barrow.model.StudentExamLink;

/**
 * The persistence interface for the student exam link service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see priv.barrow.service.persistence.impl.StudentExamLinkPersistenceImpl
 * @see StudentExamLinkUtil
 * @generated
 */
@ProviderType
public interface StudentExamLinkPersistence extends BasePersistence<StudentExamLink> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StudentExamLinkUtil} to access the student exam link persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the student exam links where examRecordId = &#63;.
	*
	* @param examRecordId the exam record ID
	* @return the matching student exam links
	*/
	public java.util.List<StudentExamLink> findByExamRecordId(long examRecordId);

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
	public java.util.List<StudentExamLink> findByExamRecordId(
		long examRecordId, int start, int end);

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
	public java.util.List<StudentExamLink> findByExamRecordId(
		long examRecordId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StudentExamLink> orderByComparator);

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
	public java.util.List<StudentExamLink> findByExamRecordId(
		long examRecordId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StudentExamLink> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first student exam link in the ordered set where examRecordId = &#63;.
	*
	* @param examRecordId the exam record ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student exam link
	* @throws NoSuchStudentExamLinkException if a matching student exam link could not be found
	*/
	public StudentExamLink findByExamRecordId_First(long examRecordId,
		com.liferay.portal.kernel.util.OrderByComparator<StudentExamLink> orderByComparator)
		throws NoSuchStudentExamLinkException;

	/**
	* Returns the first student exam link in the ordered set where examRecordId = &#63;.
	*
	* @param examRecordId the exam record ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student exam link, or <code>null</code> if a matching student exam link could not be found
	*/
	public StudentExamLink fetchByExamRecordId_First(long examRecordId,
		com.liferay.portal.kernel.util.OrderByComparator<StudentExamLink> orderByComparator);

	/**
	* Returns the last student exam link in the ordered set where examRecordId = &#63;.
	*
	* @param examRecordId the exam record ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student exam link
	* @throws NoSuchStudentExamLinkException if a matching student exam link could not be found
	*/
	public StudentExamLink findByExamRecordId_Last(long examRecordId,
		com.liferay.portal.kernel.util.OrderByComparator<StudentExamLink> orderByComparator)
		throws NoSuchStudentExamLinkException;

	/**
	* Returns the last student exam link in the ordered set where examRecordId = &#63;.
	*
	* @param examRecordId the exam record ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student exam link, or <code>null</code> if a matching student exam link could not be found
	*/
	public StudentExamLink fetchByExamRecordId_Last(long examRecordId,
		com.liferay.portal.kernel.util.OrderByComparator<StudentExamLink> orderByComparator);

	/**
	* Returns the student exam links before and after the current student exam link in the ordered set where examRecordId = &#63;.
	*
	* @param studentExamLinkPK the primary key of the current student exam link
	* @param examRecordId the exam record ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next student exam link
	* @throws NoSuchStudentExamLinkException if a student exam link with the primary key could not be found
	*/
	public StudentExamLink[] findByExamRecordId_PrevAndNext(
		priv.barrow.service.persistence.StudentExamLinkPK studentExamLinkPK,
		long examRecordId,
		com.liferay.portal.kernel.util.OrderByComparator<StudentExamLink> orderByComparator)
		throws NoSuchStudentExamLinkException;

	/**
	* Removes all the student exam links where examRecordId = &#63; from the database.
	*
	* @param examRecordId the exam record ID
	*/
	public void removeByExamRecordId(long examRecordId);

	/**
	* Returns the number of student exam links where examRecordId = &#63;.
	*
	* @param examRecordId the exam record ID
	* @return the number of matching student exam links
	*/
	public int countByExamRecordId(long examRecordId);

	/**
	* Returns all the student exam links where studentId = &#63;.
	*
	* @param studentId the student ID
	* @return the matching student exam links
	*/
	public java.util.List<StudentExamLink> findByStudentId(long studentId);

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
	public java.util.List<StudentExamLink> findByStudentId(long studentId,
		int start, int end);

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
	public java.util.List<StudentExamLink> findByStudentId(long studentId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StudentExamLink> orderByComparator);

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
	public java.util.List<StudentExamLink> findByStudentId(long studentId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StudentExamLink> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first student exam link in the ordered set where studentId = &#63;.
	*
	* @param studentId the student ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student exam link
	* @throws NoSuchStudentExamLinkException if a matching student exam link could not be found
	*/
	public StudentExamLink findByStudentId_First(long studentId,
		com.liferay.portal.kernel.util.OrderByComparator<StudentExamLink> orderByComparator)
		throws NoSuchStudentExamLinkException;

	/**
	* Returns the first student exam link in the ordered set where studentId = &#63;.
	*
	* @param studentId the student ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student exam link, or <code>null</code> if a matching student exam link could not be found
	*/
	public StudentExamLink fetchByStudentId_First(long studentId,
		com.liferay.portal.kernel.util.OrderByComparator<StudentExamLink> orderByComparator);

	/**
	* Returns the last student exam link in the ordered set where studentId = &#63;.
	*
	* @param studentId the student ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student exam link
	* @throws NoSuchStudentExamLinkException if a matching student exam link could not be found
	*/
	public StudentExamLink findByStudentId_Last(long studentId,
		com.liferay.portal.kernel.util.OrderByComparator<StudentExamLink> orderByComparator)
		throws NoSuchStudentExamLinkException;

	/**
	* Returns the last student exam link in the ordered set where studentId = &#63;.
	*
	* @param studentId the student ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student exam link, or <code>null</code> if a matching student exam link could not be found
	*/
	public StudentExamLink fetchByStudentId_Last(long studentId,
		com.liferay.portal.kernel.util.OrderByComparator<StudentExamLink> orderByComparator);

	/**
	* Returns the student exam links before and after the current student exam link in the ordered set where studentId = &#63;.
	*
	* @param studentExamLinkPK the primary key of the current student exam link
	* @param studentId the student ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next student exam link
	* @throws NoSuchStudentExamLinkException if a student exam link with the primary key could not be found
	*/
	public StudentExamLink[] findByStudentId_PrevAndNext(
		priv.barrow.service.persistence.StudentExamLinkPK studentExamLinkPK,
		long studentId,
		com.liferay.portal.kernel.util.OrderByComparator<StudentExamLink> orderByComparator)
		throws NoSuchStudentExamLinkException;

	/**
	* Removes all the student exam links where studentId = &#63; from the database.
	*
	* @param studentId the student ID
	*/
	public void removeByStudentId(long studentId);

	/**
	* Returns the number of student exam links where studentId = &#63;.
	*
	* @param studentId the student ID
	* @return the number of matching student exam links
	*/
	public int countByStudentId(long studentId);

	/**
	* Returns all the student exam links where studentId = &#63; and inProgress = &#63; and done = &#63;.
	*
	* @param studentId the student ID
	* @param inProgress the in progress
	* @param done the done
	* @return the matching student exam links
	*/
	public java.util.List<StudentExamLink> findByStudentIdAndStatus(
		long studentId, boolean inProgress, boolean done);

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
	public java.util.List<StudentExamLink> findByStudentIdAndStatus(
		long studentId, boolean inProgress, boolean done, int start, int end);

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
	public java.util.List<StudentExamLink> findByStudentIdAndStatus(
		long studentId, boolean inProgress, boolean done, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StudentExamLink> orderByComparator);

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
	public java.util.List<StudentExamLink> findByStudentIdAndStatus(
		long studentId, boolean inProgress, boolean done, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StudentExamLink> orderByComparator,
		boolean retrieveFromCache);

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
	public StudentExamLink findByStudentIdAndStatus_First(long studentId,
		boolean inProgress, boolean done,
		com.liferay.portal.kernel.util.OrderByComparator<StudentExamLink> orderByComparator)
		throws NoSuchStudentExamLinkException;

	/**
	* Returns the first student exam link in the ordered set where studentId = &#63; and inProgress = &#63; and done = &#63;.
	*
	* @param studentId the student ID
	* @param inProgress the in progress
	* @param done the done
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student exam link, or <code>null</code> if a matching student exam link could not be found
	*/
	public StudentExamLink fetchByStudentIdAndStatus_First(long studentId,
		boolean inProgress, boolean done,
		com.liferay.portal.kernel.util.OrderByComparator<StudentExamLink> orderByComparator);

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
	public StudentExamLink findByStudentIdAndStatus_Last(long studentId,
		boolean inProgress, boolean done,
		com.liferay.portal.kernel.util.OrderByComparator<StudentExamLink> orderByComparator)
		throws NoSuchStudentExamLinkException;

	/**
	* Returns the last student exam link in the ordered set where studentId = &#63; and inProgress = &#63; and done = &#63;.
	*
	* @param studentId the student ID
	* @param inProgress the in progress
	* @param done the done
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student exam link, or <code>null</code> if a matching student exam link could not be found
	*/
	public StudentExamLink fetchByStudentIdAndStatus_Last(long studentId,
		boolean inProgress, boolean done,
		com.liferay.portal.kernel.util.OrderByComparator<StudentExamLink> orderByComparator);

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
	public StudentExamLink[] findByStudentIdAndStatus_PrevAndNext(
		priv.barrow.service.persistence.StudentExamLinkPK studentExamLinkPK,
		long studentId, boolean inProgress, boolean done,
		com.liferay.portal.kernel.util.OrderByComparator<StudentExamLink> orderByComparator)
		throws NoSuchStudentExamLinkException;

	/**
	* Removes all the student exam links where studentId = &#63; and inProgress = &#63; and done = &#63; from the database.
	*
	* @param studentId the student ID
	* @param inProgress the in progress
	* @param done the done
	*/
	public void removeByStudentIdAndStatus(long studentId, boolean inProgress,
		boolean done);

	/**
	* Returns the number of student exam links where studentId = &#63; and inProgress = &#63; and done = &#63;.
	*
	* @param studentId the student ID
	* @param inProgress the in progress
	* @param done the done
	* @return the number of matching student exam links
	*/
	public int countByStudentIdAndStatus(long studentId, boolean inProgress,
		boolean done);

	/**
	* Returns all the student exam links where examRecordId = &#63; and studentId = &#63;.
	*
	* @param examRecordId the exam record ID
	* @param studentId the student ID
	* @return the matching student exam links
	*/
	public java.util.List<StudentExamLink> findByExamRecordIdAndStudentId(
		long examRecordId, long studentId);

	/**
	* Returns a range of all the student exam links where examRecordId = &#63; and studentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StudentExamLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param examRecordId the exam record ID
	* @param studentId the student ID
	* @param start the lower bound of the range of student exam links
	* @param end the upper bound of the range of student exam links (not inclusive)
	* @return the range of matching student exam links
	*/
	public java.util.List<StudentExamLink> findByExamRecordIdAndStudentId(
		long examRecordId, long studentId, int start, int end);

	/**
	* Returns an ordered range of all the student exam links where examRecordId = &#63; and studentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StudentExamLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param examRecordId the exam record ID
	* @param studentId the student ID
	* @param start the lower bound of the range of student exam links
	* @param end the upper bound of the range of student exam links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching student exam links
	*/
	public java.util.List<StudentExamLink> findByExamRecordIdAndStudentId(
		long examRecordId, long studentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StudentExamLink> orderByComparator);

	/**
	* Returns an ordered range of all the student exam links where examRecordId = &#63; and studentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StudentExamLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param examRecordId the exam record ID
	* @param studentId the student ID
	* @param start the lower bound of the range of student exam links
	* @param end the upper bound of the range of student exam links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching student exam links
	*/
	public java.util.List<StudentExamLink> findByExamRecordIdAndStudentId(
		long examRecordId, long studentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StudentExamLink> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first student exam link in the ordered set where examRecordId = &#63; and studentId = &#63;.
	*
	* @param examRecordId the exam record ID
	* @param studentId the student ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student exam link
	* @throws NoSuchStudentExamLinkException if a matching student exam link could not be found
	*/
	public StudentExamLink findByExamRecordIdAndStudentId_First(
		long examRecordId, long studentId,
		com.liferay.portal.kernel.util.OrderByComparator<StudentExamLink> orderByComparator)
		throws NoSuchStudentExamLinkException;

	/**
	* Returns the first student exam link in the ordered set where examRecordId = &#63; and studentId = &#63;.
	*
	* @param examRecordId the exam record ID
	* @param studentId the student ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student exam link, or <code>null</code> if a matching student exam link could not be found
	*/
	public StudentExamLink fetchByExamRecordIdAndStudentId_First(
		long examRecordId, long studentId,
		com.liferay.portal.kernel.util.OrderByComparator<StudentExamLink> orderByComparator);

	/**
	* Returns the last student exam link in the ordered set where examRecordId = &#63; and studentId = &#63;.
	*
	* @param examRecordId the exam record ID
	* @param studentId the student ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student exam link
	* @throws NoSuchStudentExamLinkException if a matching student exam link could not be found
	*/
	public StudentExamLink findByExamRecordIdAndStudentId_Last(
		long examRecordId, long studentId,
		com.liferay.portal.kernel.util.OrderByComparator<StudentExamLink> orderByComparator)
		throws NoSuchStudentExamLinkException;

	/**
	* Returns the last student exam link in the ordered set where examRecordId = &#63; and studentId = &#63;.
	*
	* @param examRecordId the exam record ID
	* @param studentId the student ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student exam link, or <code>null</code> if a matching student exam link could not be found
	*/
	public StudentExamLink fetchByExamRecordIdAndStudentId_Last(
		long examRecordId, long studentId,
		com.liferay.portal.kernel.util.OrderByComparator<StudentExamLink> orderByComparator);

	/**
	* Returns the student exam links before and after the current student exam link in the ordered set where examRecordId = &#63; and studentId = &#63;.
	*
	* @param studentExamLinkPK the primary key of the current student exam link
	* @param examRecordId the exam record ID
	* @param studentId the student ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next student exam link
	* @throws NoSuchStudentExamLinkException if a student exam link with the primary key could not be found
	*/
	public StudentExamLink[] findByExamRecordIdAndStudentId_PrevAndNext(
		priv.barrow.service.persistence.StudentExamLinkPK studentExamLinkPK,
		long examRecordId, long studentId,
		com.liferay.portal.kernel.util.OrderByComparator<StudentExamLink> orderByComparator)
		throws NoSuchStudentExamLinkException;

	/**
	* Removes all the student exam links where examRecordId = &#63; and studentId = &#63; from the database.
	*
	* @param examRecordId the exam record ID
	* @param studentId the student ID
	*/
	public void removeByExamRecordIdAndStudentId(long examRecordId,
		long studentId);

	/**
	* Returns the number of student exam links where examRecordId = &#63; and studentId = &#63;.
	*
	* @param examRecordId the exam record ID
	* @param studentId the student ID
	* @return the number of matching student exam links
	*/
	public int countByExamRecordIdAndStudentId(long examRecordId, long studentId);

	/**
	* Caches the student exam link in the entity cache if it is enabled.
	*
	* @param studentExamLink the student exam link
	*/
	public void cacheResult(StudentExamLink studentExamLink);

	/**
	* Caches the student exam links in the entity cache if it is enabled.
	*
	* @param studentExamLinks the student exam links
	*/
	public void cacheResult(java.util.List<StudentExamLink> studentExamLinks);

	/**
	* Creates a new student exam link with the primary key. Does not add the student exam link to the database.
	*
	* @param studentExamLinkPK the primary key for the new student exam link
	* @return the new student exam link
	*/
	public StudentExamLink create(
		priv.barrow.service.persistence.StudentExamLinkPK studentExamLinkPK);

	/**
	* Removes the student exam link with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param studentExamLinkPK the primary key of the student exam link
	* @return the student exam link that was removed
	* @throws NoSuchStudentExamLinkException if a student exam link with the primary key could not be found
	*/
	public StudentExamLink remove(
		priv.barrow.service.persistence.StudentExamLinkPK studentExamLinkPK)
		throws NoSuchStudentExamLinkException;

	public StudentExamLink updateImpl(StudentExamLink studentExamLink);

	/**
	* Returns the student exam link with the primary key or throws a {@link NoSuchStudentExamLinkException} if it could not be found.
	*
	* @param studentExamLinkPK the primary key of the student exam link
	* @return the student exam link
	* @throws NoSuchStudentExamLinkException if a student exam link with the primary key could not be found
	*/
	public StudentExamLink findByPrimaryKey(
		priv.barrow.service.persistence.StudentExamLinkPK studentExamLinkPK)
		throws NoSuchStudentExamLinkException;

	/**
	* Returns the student exam link with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param studentExamLinkPK the primary key of the student exam link
	* @return the student exam link, or <code>null</code> if a student exam link with the primary key could not be found
	*/
	public StudentExamLink fetchByPrimaryKey(
		priv.barrow.service.persistence.StudentExamLinkPK studentExamLinkPK);

	@Override
	public java.util.Map<java.io.Serializable, StudentExamLink> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the student exam links.
	*
	* @return the student exam links
	*/
	public java.util.List<StudentExamLink> findAll();

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
	public java.util.List<StudentExamLink> findAll(int start, int end);

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
	public java.util.List<StudentExamLink> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StudentExamLink> orderByComparator);

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
	public java.util.List<StudentExamLink> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StudentExamLink> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the student exam links from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of student exam links.
	*
	* @return the number of student exam links
	*/
	public int countAll();
}