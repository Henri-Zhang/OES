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

import priv.barrow.exception.NoSuchExamQuestionLinkException;

import priv.barrow.model.ExamQuestionLink;

/**
 * The persistence interface for the exam question link service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see priv.barrow.service.persistence.impl.ExamQuestionLinkPersistenceImpl
 * @see ExamQuestionLinkUtil
 * @generated
 */
@ProviderType
public interface ExamQuestionLinkPersistence extends BasePersistence<ExamQuestionLink> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ExamQuestionLinkUtil} to access the exam question link persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the exam question link in the entity cache if it is enabled.
	*
	* @param examQuestionLink the exam question link
	*/
	public void cacheResult(ExamQuestionLink examQuestionLink);

	/**
	* Caches the exam question links in the entity cache if it is enabled.
	*
	* @param examQuestionLinks the exam question links
	*/
	public void cacheResult(java.util.List<ExamQuestionLink> examQuestionLinks);

	/**
	* Creates a new exam question link with the primary key. Does not add the exam question link to the database.
	*
	* @param examRecordId the primary key for the new exam question link
	* @return the new exam question link
	*/
	public ExamQuestionLink create(long examRecordId);

	/**
	* Removes the exam question link with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param examRecordId the primary key of the exam question link
	* @return the exam question link that was removed
	* @throws NoSuchExamQuestionLinkException if a exam question link with the primary key could not be found
	*/
	public ExamQuestionLink remove(long examRecordId)
		throws NoSuchExamQuestionLinkException;

	public ExamQuestionLink updateImpl(ExamQuestionLink examQuestionLink);

	/**
	* Returns the exam question link with the primary key or throws a {@link NoSuchExamQuestionLinkException} if it could not be found.
	*
	* @param examRecordId the primary key of the exam question link
	* @return the exam question link
	* @throws NoSuchExamQuestionLinkException if a exam question link with the primary key could not be found
	*/
	public ExamQuestionLink findByPrimaryKey(long examRecordId)
		throws NoSuchExamQuestionLinkException;

	/**
	* Returns the exam question link with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param examRecordId the primary key of the exam question link
	* @return the exam question link, or <code>null</code> if a exam question link with the primary key could not be found
	*/
	public ExamQuestionLink fetchByPrimaryKey(long examRecordId);

	@Override
	public java.util.Map<java.io.Serializable, ExamQuestionLink> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the exam question links.
	*
	* @return the exam question links
	*/
	public java.util.List<ExamQuestionLink> findAll();

	/**
	* Returns a range of all the exam question links.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExamQuestionLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of exam question links
	* @param end the upper bound of the range of exam question links (not inclusive)
	* @return the range of exam question links
	*/
	public java.util.List<ExamQuestionLink> findAll(int start, int end);

	/**
	* Returns an ordered range of all the exam question links.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExamQuestionLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of exam question links
	* @param end the upper bound of the range of exam question links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of exam question links
	*/
	public java.util.List<ExamQuestionLink> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ExamQuestionLink> orderByComparator);

	/**
	* Returns an ordered range of all the exam question links.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExamQuestionLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of exam question links
	* @param end the upper bound of the range of exam question links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of exam question links
	*/
	public java.util.List<ExamQuestionLink> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ExamQuestionLink> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the exam question links from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of exam question links.
	*
	* @return the number of exam question links
	*/
	public int countAll();
}