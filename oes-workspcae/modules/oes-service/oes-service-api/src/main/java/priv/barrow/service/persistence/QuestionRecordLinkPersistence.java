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

import priv.barrow.exception.NoSuchQuestionRecordLinkException;

import priv.barrow.model.QuestionRecordLink;

/**
 * The persistence interface for the question record link service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see priv.barrow.service.persistence.impl.QuestionRecordLinkPersistenceImpl
 * @see QuestionRecordLinkUtil
 * @generated
 */
@ProviderType
public interface QuestionRecordLinkPersistence extends BasePersistence<QuestionRecordLink> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link QuestionRecordLinkUtil} to access the question record link persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the question record links where ddlRecordId = &#63;.
	*
	* @param ddlRecordId the ddl record ID
	* @return the matching question record links
	*/
	public java.util.List<QuestionRecordLink> findByDdlRecordId(
		long ddlRecordId);

	/**
	* Returns a range of all the question record links where ddlRecordId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link QuestionRecordLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ddlRecordId the ddl record ID
	* @param start the lower bound of the range of question record links
	* @param end the upper bound of the range of question record links (not inclusive)
	* @return the range of matching question record links
	*/
	public java.util.List<QuestionRecordLink> findByDdlRecordId(
		long ddlRecordId, int start, int end);

	/**
	* Returns an ordered range of all the question record links where ddlRecordId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link QuestionRecordLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ddlRecordId the ddl record ID
	* @param start the lower bound of the range of question record links
	* @param end the upper bound of the range of question record links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching question record links
	*/
	public java.util.List<QuestionRecordLink> findByDdlRecordId(
		long ddlRecordId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QuestionRecordLink> orderByComparator);

	/**
	* Returns an ordered range of all the question record links where ddlRecordId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link QuestionRecordLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ddlRecordId the ddl record ID
	* @param start the lower bound of the range of question record links
	* @param end the upper bound of the range of question record links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching question record links
	*/
	public java.util.List<QuestionRecordLink> findByDdlRecordId(
		long ddlRecordId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QuestionRecordLink> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first question record link in the ordered set where ddlRecordId = &#63;.
	*
	* @param ddlRecordId the ddl record ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching question record link
	* @throws NoSuchQuestionRecordLinkException if a matching question record link could not be found
	*/
	public QuestionRecordLink findByDdlRecordId_First(long ddlRecordId,
		com.liferay.portal.kernel.util.OrderByComparator<QuestionRecordLink> orderByComparator)
		throws NoSuchQuestionRecordLinkException;

	/**
	* Returns the first question record link in the ordered set where ddlRecordId = &#63;.
	*
	* @param ddlRecordId the ddl record ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching question record link, or <code>null</code> if a matching question record link could not be found
	*/
	public QuestionRecordLink fetchByDdlRecordId_First(long ddlRecordId,
		com.liferay.portal.kernel.util.OrderByComparator<QuestionRecordLink> orderByComparator);

	/**
	* Returns the last question record link in the ordered set where ddlRecordId = &#63;.
	*
	* @param ddlRecordId the ddl record ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching question record link
	* @throws NoSuchQuestionRecordLinkException if a matching question record link could not be found
	*/
	public QuestionRecordLink findByDdlRecordId_Last(long ddlRecordId,
		com.liferay.portal.kernel.util.OrderByComparator<QuestionRecordLink> orderByComparator)
		throws NoSuchQuestionRecordLinkException;

	/**
	* Returns the last question record link in the ordered set where ddlRecordId = &#63;.
	*
	* @param ddlRecordId the ddl record ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching question record link, or <code>null</code> if a matching question record link could not be found
	*/
	public QuestionRecordLink fetchByDdlRecordId_Last(long ddlRecordId,
		com.liferay.portal.kernel.util.OrderByComparator<QuestionRecordLink> orderByComparator);

	/**
	* Returns the question record links before and after the current question record link in the ordered set where ddlRecordId = &#63;.
	*
	* @param questionOrder the primary key of the current question record link
	* @param ddlRecordId the ddl record ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next question record link
	* @throws NoSuchQuestionRecordLinkException if a question record link with the primary key could not be found
	*/
	public QuestionRecordLink[] findByDdlRecordId_PrevAndNext(
		long questionOrder, long ddlRecordId,
		com.liferay.portal.kernel.util.OrderByComparator<QuestionRecordLink> orderByComparator)
		throws NoSuchQuestionRecordLinkException;

	/**
	* Removes all the question record links where ddlRecordId = &#63; from the database.
	*
	* @param ddlRecordId the ddl record ID
	*/
	public void removeByDdlRecordId(long ddlRecordId);

	/**
	* Returns the number of question record links where ddlRecordId = &#63;.
	*
	* @param ddlRecordId the ddl record ID
	* @return the number of matching question record links
	*/
	public int countByDdlRecordId(long ddlRecordId);

	/**
	* Caches the question record link in the entity cache if it is enabled.
	*
	* @param questionRecordLink the question record link
	*/
	public void cacheResult(QuestionRecordLink questionRecordLink);

	/**
	* Caches the question record links in the entity cache if it is enabled.
	*
	* @param questionRecordLinks the question record links
	*/
	public void cacheResult(
		java.util.List<QuestionRecordLink> questionRecordLinks);

	/**
	* Creates a new question record link with the primary key. Does not add the question record link to the database.
	*
	* @param questionOrder the primary key for the new question record link
	* @return the new question record link
	*/
	public QuestionRecordLink create(long questionOrder);

	/**
	* Removes the question record link with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param questionOrder the primary key of the question record link
	* @return the question record link that was removed
	* @throws NoSuchQuestionRecordLinkException if a question record link with the primary key could not be found
	*/
	public QuestionRecordLink remove(long questionOrder)
		throws NoSuchQuestionRecordLinkException;

	public QuestionRecordLink updateImpl(QuestionRecordLink questionRecordLink);

	/**
	* Returns the question record link with the primary key or throws a {@link NoSuchQuestionRecordLinkException} if it could not be found.
	*
	* @param questionOrder the primary key of the question record link
	* @return the question record link
	* @throws NoSuchQuestionRecordLinkException if a question record link with the primary key could not be found
	*/
	public QuestionRecordLink findByPrimaryKey(long questionOrder)
		throws NoSuchQuestionRecordLinkException;

	/**
	* Returns the question record link with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param questionOrder the primary key of the question record link
	* @return the question record link, or <code>null</code> if a question record link with the primary key could not be found
	*/
	public QuestionRecordLink fetchByPrimaryKey(long questionOrder);

	@Override
	public java.util.Map<java.io.Serializable, QuestionRecordLink> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the question record links.
	*
	* @return the question record links
	*/
	public java.util.List<QuestionRecordLink> findAll();

	/**
	* Returns a range of all the question record links.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link QuestionRecordLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of question record links
	* @param end the upper bound of the range of question record links (not inclusive)
	* @return the range of question record links
	*/
	public java.util.List<QuestionRecordLink> findAll(int start, int end);

	/**
	* Returns an ordered range of all the question record links.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link QuestionRecordLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of question record links
	* @param end the upper bound of the range of question record links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of question record links
	*/
	public java.util.List<QuestionRecordLink> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QuestionRecordLink> orderByComparator);

	/**
	* Returns an ordered range of all the question record links.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link QuestionRecordLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of question record links
	* @param end the upper bound of the range of question record links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of question record links
	*/
	public java.util.List<QuestionRecordLink> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QuestionRecordLink> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the question record links from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of question record links.
	*
	* @return the number of question record links
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}