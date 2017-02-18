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

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import oes.service.model.QuestionContentLink;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the question content link service. This utility wraps {@link oes.service.service.persistence.impl.QuestionContentLinkPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuestionContentLinkPersistence
 * @see oes.service.service.persistence.impl.QuestionContentLinkPersistenceImpl
 * @generated
 */
@ProviderType
public class QuestionContentLinkUtil {
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
	public static void clearCache(QuestionContentLink questionContentLink) {
		getPersistence().clearCache(questionContentLink);
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
	public static List<QuestionContentLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<QuestionContentLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<QuestionContentLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<QuestionContentLink> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static QuestionContentLink update(
		QuestionContentLink questionContentLink) {
		return getPersistence().update(questionContentLink);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static QuestionContentLink update(
		QuestionContentLink questionContentLink, ServiceContext serviceContext) {
		return getPersistence().update(questionContentLink, serviceContext);
	}

	/**
	* Caches the question content link in the entity cache if it is enabled.
	*
	* @param questionContentLink the question content link
	*/
	public static void cacheResult(QuestionContentLink questionContentLink) {
		getPersistence().cacheResult(questionContentLink);
	}

	/**
	* Caches the question content links in the entity cache if it is enabled.
	*
	* @param questionContentLinks the question content links
	*/
	public static void cacheResult(
		List<QuestionContentLink> questionContentLinks) {
		getPersistence().cacheResult(questionContentLinks);
	}

	/**
	* Creates a new question content link with the primary key. Does not add the question content link to the database.
	*
	* @param questionOrder the primary key for the new question content link
	* @return the new question content link
	*/
	public static QuestionContentLink create(long questionOrder) {
		return getPersistence().create(questionOrder);
	}

	/**
	* Removes the question content link with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param questionOrder the primary key of the question content link
	* @return the question content link that was removed
	* @throws NoSuchQuestionContentLinkException if a question content link with the primary key could not be found
	*/
	public static QuestionContentLink remove(long questionOrder)
		throws oes.service.exception.NoSuchQuestionContentLinkException {
		return getPersistence().remove(questionOrder);
	}

	public static QuestionContentLink updateImpl(
		QuestionContentLink questionContentLink) {
		return getPersistence().updateImpl(questionContentLink);
	}

	/**
	* Returns the question content link with the primary key or throws a {@link NoSuchQuestionContentLinkException} if it could not be found.
	*
	* @param questionOrder the primary key of the question content link
	* @return the question content link
	* @throws NoSuchQuestionContentLinkException if a question content link with the primary key could not be found
	*/
	public static QuestionContentLink findByPrimaryKey(long questionOrder)
		throws oes.service.exception.NoSuchQuestionContentLinkException {
		return getPersistence().findByPrimaryKey(questionOrder);
	}

	/**
	* Returns the question content link with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param questionOrder the primary key of the question content link
	* @return the question content link, or <code>null</code> if a question content link with the primary key could not be found
	*/
	public static QuestionContentLink fetchByPrimaryKey(long questionOrder) {
		return getPersistence().fetchByPrimaryKey(questionOrder);
	}

	public static java.util.Map<java.io.Serializable, QuestionContentLink> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the question content links.
	*
	* @return the question content links
	*/
	public static List<QuestionContentLink> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<QuestionContentLink> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<QuestionContentLink> findAll(int start, int end,
		OrderByComparator<QuestionContentLink> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<QuestionContentLink> findAll(int start, int end,
		OrderByComparator<QuestionContentLink> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the question content links from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of question content links.
	*
	* @return the number of question content links
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static QuestionContentLinkPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<QuestionContentLinkPersistence, QuestionContentLinkPersistence> _serviceTracker =
		ServiceTrackerFactory.open(QuestionContentLinkPersistence.class);
}