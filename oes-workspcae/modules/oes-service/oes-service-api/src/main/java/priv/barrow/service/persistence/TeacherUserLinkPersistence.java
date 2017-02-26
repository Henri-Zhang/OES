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

import priv.barrow.exception.NoSuchTeacherUserLinkException;

import priv.barrow.model.TeacherUserLink;

/**
 * The persistence interface for the teacher user link service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see priv.barrow.service.persistence.impl.TeacherUserLinkPersistenceImpl
 * @see TeacherUserLinkUtil
 * @generated
 */
@ProviderType
public interface TeacherUserLinkPersistence extends BasePersistence<TeacherUserLink> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TeacherUserLinkUtil} to access the teacher user link persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the teacher user link in the entity cache if it is enabled.
	*
	* @param teacherUserLink the teacher user link
	*/
	public void cacheResult(TeacherUserLink teacherUserLink);

	/**
	* Caches the teacher user links in the entity cache if it is enabled.
	*
	* @param teacherUserLinks the teacher user links
	*/
	public void cacheResult(java.util.List<TeacherUserLink> teacherUserLinks);

	/**
	* Creates a new teacher user link with the primary key. Does not add the teacher user link to the database.
	*
	* @param teacherNumber the primary key for the new teacher user link
	* @return the new teacher user link
	*/
	public TeacherUserLink create(long teacherNumber);

	/**
	* Removes the teacher user link with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param teacherNumber the primary key of the teacher user link
	* @return the teacher user link that was removed
	* @throws NoSuchTeacherUserLinkException if a teacher user link with the primary key could not be found
	*/
	public TeacherUserLink remove(long teacherNumber)
		throws NoSuchTeacherUserLinkException;

	public TeacherUserLink updateImpl(TeacherUserLink teacherUserLink);

	/**
	* Returns the teacher user link with the primary key or throws a {@link NoSuchTeacherUserLinkException} if it could not be found.
	*
	* @param teacherNumber the primary key of the teacher user link
	* @return the teacher user link
	* @throws NoSuchTeacherUserLinkException if a teacher user link with the primary key could not be found
	*/
	public TeacherUserLink findByPrimaryKey(long teacherNumber)
		throws NoSuchTeacherUserLinkException;

	/**
	* Returns the teacher user link with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param teacherNumber the primary key of the teacher user link
	* @return the teacher user link, or <code>null</code> if a teacher user link with the primary key could not be found
	*/
	public TeacherUserLink fetchByPrimaryKey(long teacherNumber);

	@Override
	public java.util.Map<java.io.Serializable, TeacherUserLink> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the teacher user links.
	*
	* @return the teacher user links
	*/
	public java.util.List<TeacherUserLink> findAll();

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
	public java.util.List<TeacherUserLink> findAll(int start, int end);

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
	public java.util.List<TeacherUserLink> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TeacherUserLink> orderByComparator);

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
	public java.util.List<TeacherUserLink> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TeacherUserLink> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the teacher user links from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of teacher user links.
	*
	* @return the number of teacher user links
	*/
	public int countAll();
}