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

import priv.barrow.exception.NoSuchStudentTeacherLinkException;

import priv.barrow.model.StudentTeacherLink;

/**
 * The persistence interface for the student teacher link service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see priv.barrow.service.persistence.impl.StudentTeacherLinkPersistenceImpl
 * @see StudentTeacherLinkUtil
 * @generated
 */
@ProviderType
public interface StudentTeacherLinkPersistence extends BasePersistence<StudentTeacherLink> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StudentTeacherLinkUtil} to access the student teacher link persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the student teacher links where studentId = &#63;.
	*
	* @param studentId the student ID
	* @return the matching student teacher links
	*/
	public java.util.List<StudentTeacherLink> findByteacherId(long studentId);

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
	public java.util.List<StudentTeacherLink> findByteacherId(long studentId,
		int start, int end);

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
	public java.util.List<StudentTeacherLink> findByteacherId(long studentId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StudentTeacherLink> orderByComparator);

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
	public java.util.List<StudentTeacherLink> findByteacherId(long studentId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StudentTeacherLink> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first student teacher link in the ordered set where studentId = &#63;.
	*
	* @param studentId the student ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student teacher link
	* @throws NoSuchStudentTeacherLinkException if a matching student teacher link could not be found
	*/
	public StudentTeacherLink findByteacherId_First(long studentId,
		com.liferay.portal.kernel.util.OrderByComparator<StudentTeacherLink> orderByComparator)
		throws NoSuchStudentTeacherLinkException;

	/**
	* Returns the first student teacher link in the ordered set where studentId = &#63;.
	*
	* @param studentId the student ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student teacher link, or <code>null</code> if a matching student teacher link could not be found
	*/
	public StudentTeacherLink fetchByteacherId_First(long studentId,
		com.liferay.portal.kernel.util.OrderByComparator<StudentTeacherLink> orderByComparator);

	/**
	* Returns the last student teacher link in the ordered set where studentId = &#63;.
	*
	* @param studentId the student ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student teacher link
	* @throws NoSuchStudentTeacherLinkException if a matching student teacher link could not be found
	*/
	public StudentTeacherLink findByteacherId_Last(long studentId,
		com.liferay.portal.kernel.util.OrderByComparator<StudentTeacherLink> orderByComparator)
		throws NoSuchStudentTeacherLinkException;

	/**
	* Returns the last student teacher link in the ordered set where studentId = &#63;.
	*
	* @param studentId the student ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student teacher link, or <code>null</code> if a matching student teacher link could not be found
	*/
	public StudentTeacherLink fetchByteacherId_Last(long studentId,
		com.liferay.portal.kernel.util.OrderByComparator<StudentTeacherLink> orderByComparator);

	/**
	* Removes all the student teacher links where studentId = &#63; from the database.
	*
	* @param studentId the student ID
	*/
	public void removeByteacherId(long studentId);

	/**
	* Returns the number of student teacher links where studentId = &#63;.
	*
	* @param studentId the student ID
	* @return the number of matching student teacher links
	*/
	public int countByteacherId(long studentId);

	/**
	* Caches the student teacher link in the entity cache if it is enabled.
	*
	* @param studentTeacherLink the student teacher link
	*/
	public void cacheResult(StudentTeacherLink studentTeacherLink);

	/**
	* Caches the student teacher links in the entity cache if it is enabled.
	*
	* @param studentTeacherLinks the student teacher links
	*/
	public void cacheResult(
		java.util.List<StudentTeacherLink> studentTeacherLinks);

	/**
	* Creates a new student teacher link with the primary key. Does not add the student teacher link to the database.
	*
	* @param studentId the primary key for the new student teacher link
	* @return the new student teacher link
	*/
	public StudentTeacherLink create(long studentId);

	/**
	* Removes the student teacher link with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param studentId the primary key of the student teacher link
	* @return the student teacher link that was removed
	* @throws NoSuchStudentTeacherLinkException if a student teacher link with the primary key could not be found
	*/
	public StudentTeacherLink remove(long studentId)
		throws NoSuchStudentTeacherLinkException;

	public StudentTeacherLink updateImpl(StudentTeacherLink studentTeacherLink);

	/**
	* Returns the student teacher link with the primary key or throws a {@link NoSuchStudentTeacherLinkException} if it could not be found.
	*
	* @param studentId the primary key of the student teacher link
	* @return the student teacher link
	* @throws NoSuchStudentTeacherLinkException if a student teacher link with the primary key could not be found
	*/
	public StudentTeacherLink findByPrimaryKey(long studentId)
		throws NoSuchStudentTeacherLinkException;

	/**
	* Returns the student teacher link with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param studentId the primary key of the student teacher link
	* @return the student teacher link, or <code>null</code> if a student teacher link with the primary key could not be found
	*/
	public StudentTeacherLink fetchByPrimaryKey(long studentId);

	@Override
	public java.util.Map<java.io.Serializable, StudentTeacherLink> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the student teacher links.
	*
	* @return the student teacher links
	*/
	public java.util.List<StudentTeacherLink> findAll();

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
	public java.util.List<StudentTeacherLink> findAll(int start, int end);

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
	public java.util.List<StudentTeacherLink> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StudentTeacherLink> orderByComparator);

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
	public java.util.List<StudentTeacherLink> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StudentTeacherLink> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the student teacher links from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of student teacher links.
	*
	* @return the number of student teacher links
	*/
	public int countAll();
}