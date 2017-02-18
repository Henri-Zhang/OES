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

package oes.service.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import oes.service.exception.NoSuchQuestionContentLinkException;

import oes.service.model.QuestionContentLink;

/**
 * The persistence interface for the question content link service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see oes.service.service.persistence.impl.QuestionContentLinkPersistenceImpl
 * @see QuestionContentLinkUtil
 * @generated
 */
@ProviderType
public interface QuestionContentLinkPersistence extends BasePersistence<QuestionContentLink> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link QuestionContentLinkUtil} to access the question content link persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the question content link in the entity cache if it is enabled.
	*
	* @param questionContentLink the question content link
	*/
	public void cacheResult(QuestionContentLink questionContentLink);

	/**
	* Caches the question content links in the entity cache if it is enabled.
	*
	* @param questionContentLinks the question content links
	*/
	public void cacheResult(
		java.util.List<QuestionContentLink> questionContentLinks);

	/**
	* Creates a new question content link with the primary key. Does not add the question content link to the database.
	*
	* @param questionOrder the primary key for the new question content link
	* @return the new question content link
	*/
	public QuestionContentLink create(long questionOrder);

	/**
	* Removes the question content link with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param questionOrder the primary key of the question content link
	* @return the question content link that was removed
	* @throws NoSuchQuestionContentLinkException if a question content link with the primary key could not be found
	*/
	public QuestionContentLink remove(long questionOrder)
		throws NoSuchQuestionContentLinkException;

	public QuestionContentLink updateImpl(
		QuestionContentLink questionContentLink);

	/**
	* Returns the question content link with the primary key or throws a {@link NoSuchQuestionContentLinkException} if it could not be found.
	*
	* @param questionOrder the primary key of the question content link
	* @return the question content link
	* @throws NoSuchQuestionContentLinkException if a question content link with the primary key could not be found
	*/
	public QuestionContentLink findByPrimaryKey(long questionOrder)
		throws NoSuchQuestionContentLinkException;

	/**
	* Returns the question content link with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param questionOrder the primary key of the question content link
	* @return the question content link, or <code>null</code> if a question content link with the primary key could not be found
	*/
	public QuestionContentLink fetchByPrimaryKey(long questionOrder);

	@Override
	public java.util.Map<java.io.Serializable, QuestionContentLink> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the question content links.
	*
	* @return the question content links
	*/
	public java.util.List<QuestionContentLink> findAll();

	/**
	* Returns a range of all the question content links.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link QuestionContentLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of question content links
	* @param end the upper bound of the range of question content links (not inclusive)
	* @return the range of question content links
	*/
	public java.util.List<QuestionContentLink> findAll(int start, int end);

	/**
	* Returns an ordered range of all the question content links.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link QuestionContentLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of question content links
	* @param end the upper bound of the range of question content links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of question content links
	*/
	public java.util.List<QuestionContentLink> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QuestionContentLink> orderByComparator);

	/**
	* Returns an ordered range of all the question content links.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link QuestionContentLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of question content links
	* @param end the upper bound of the range of question content links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of question content links
	*/
	public java.util.List<QuestionContentLink> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QuestionContentLink> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the question content links from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of question content links.
	*
	* @return the number of question content links
	*/
	public int countAll();
}