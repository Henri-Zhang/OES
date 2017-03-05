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

import priv.barrow.model.ExamQuestionLink;

import java.util.List;

/**
 * The persistence utility for the exam question link service. This utility wraps {@link priv.barrow.service.persistence.impl.ExamQuestionLinkPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ExamQuestionLinkPersistence
 * @see priv.barrow.service.persistence.impl.ExamQuestionLinkPersistenceImpl
 * @generated
 */
@ProviderType
public class ExamQuestionLinkUtil {
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
	public static void clearCache(ExamQuestionLink examQuestionLink) {
		getPersistence().clearCache(examQuestionLink);
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
	public static List<ExamQuestionLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ExamQuestionLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ExamQuestionLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ExamQuestionLink> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ExamQuestionLink update(ExamQuestionLink examQuestionLink) {
		return getPersistence().update(examQuestionLink);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ExamQuestionLink update(ExamQuestionLink examQuestionLink,
		ServiceContext serviceContext) {
		return getPersistence().update(examQuestionLink, serviceContext);
	}

	/**
	* Returns all the exam question links where examRecordId = &#63;.
	*
	* @param examRecordId the exam record ID
	* @return the matching exam question links
	*/
	public static List<ExamQuestionLink> findByexamRecordId(long examRecordId) {
		return getPersistence().findByexamRecordId(examRecordId);
	}

	/**
	* Returns a range of all the exam question links where examRecordId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExamQuestionLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param examRecordId the exam record ID
	* @param start the lower bound of the range of exam question links
	* @param end the upper bound of the range of exam question links (not inclusive)
	* @return the range of matching exam question links
	*/
	public static List<ExamQuestionLink> findByexamRecordId(long examRecordId,
		int start, int end) {
		return getPersistence().findByexamRecordId(examRecordId, start, end);
	}

	/**
	* Returns an ordered range of all the exam question links where examRecordId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExamQuestionLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param examRecordId the exam record ID
	* @param start the lower bound of the range of exam question links
	* @param end the upper bound of the range of exam question links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching exam question links
	*/
	public static List<ExamQuestionLink> findByexamRecordId(long examRecordId,
		int start, int end,
		OrderByComparator<ExamQuestionLink> orderByComparator) {
		return getPersistence()
				   .findByexamRecordId(examRecordId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the exam question links where examRecordId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExamQuestionLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param examRecordId the exam record ID
	* @param start the lower bound of the range of exam question links
	* @param end the upper bound of the range of exam question links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching exam question links
	*/
	public static List<ExamQuestionLink> findByexamRecordId(long examRecordId,
		int start, int end,
		OrderByComparator<ExamQuestionLink> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByexamRecordId(examRecordId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first exam question link in the ordered set where examRecordId = &#63;.
	*
	* @param examRecordId the exam record ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching exam question link
	* @throws NoSuchExamQuestionLinkException if a matching exam question link could not be found
	*/
	public static ExamQuestionLink findByexamRecordId_First(long examRecordId,
		OrderByComparator<ExamQuestionLink> orderByComparator)
		throws priv.barrow.exception.NoSuchExamQuestionLinkException {
		return getPersistence()
				   .findByexamRecordId_First(examRecordId, orderByComparator);
	}

	/**
	* Returns the first exam question link in the ordered set where examRecordId = &#63;.
	*
	* @param examRecordId the exam record ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching exam question link, or <code>null</code> if a matching exam question link could not be found
	*/
	public static ExamQuestionLink fetchByexamRecordId_First(
		long examRecordId, OrderByComparator<ExamQuestionLink> orderByComparator) {
		return getPersistence()
				   .fetchByexamRecordId_First(examRecordId, orderByComparator);
	}

	/**
	* Returns the last exam question link in the ordered set where examRecordId = &#63;.
	*
	* @param examRecordId the exam record ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching exam question link
	* @throws NoSuchExamQuestionLinkException if a matching exam question link could not be found
	*/
	public static ExamQuestionLink findByexamRecordId_Last(long examRecordId,
		OrderByComparator<ExamQuestionLink> orderByComparator)
		throws priv.barrow.exception.NoSuchExamQuestionLinkException {
		return getPersistence()
				   .findByexamRecordId_Last(examRecordId, orderByComparator);
	}

	/**
	* Returns the last exam question link in the ordered set where examRecordId = &#63;.
	*
	* @param examRecordId the exam record ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching exam question link, or <code>null</code> if a matching exam question link could not be found
	*/
	public static ExamQuestionLink fetchByexamRecordId_Last(long examRecordId,
		OrderByComparator<ExamQuestionLink> orderByComparator) {
		return getPersistence()
				   .fetchByexamRecordId_Last(examRecordId, orderByComparator);
	}

	/**
	* Returns the exam question links before and after the current exam question link in the ordered set where examRecordId = &#63;.
	*
	* @param examQuestionLinkPK the primary key of the current exam question link
	* @param examRecordId the exam record ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next exam question link
	* @throws NoSuchExamQuestionLinkException if a exam question link with the primary key could not be found
	*/
	public static ExamQuestionLink[] findByexamRecordId_PrevAndNext(
		priv.barrow.service.persistence.ExamQuestionLinkPK examQuestionLinkPK,
		long examRecordId, OrderByComparator<ExamQuestionLink> orderByComparator)
		throws priv.barrow.exception.NoSuchExamQuestionLinkException {
		return getPersistence()
				   .findByexamRecordId_PrevAndNext(examQuestionLinkPK,
			examRecordId, orderByComparator);
	}

	/**
	* Removes all the exam question links where examRecordId = &#63; from the database.
	*
	* @param examRecordId the exam record ID
	*/
	public static void removeByexamRecordId(long examRecordId) {
		getPersistence().removeByexamRecordId(examRecordId);
	}

	/**
	* Returns the number of exam question links where examRecordId = &#63;.
	*
	* @param examRecordId the exam record ID
	* @return the number of matching exam question links
	*/
	public static int countByexamRecordId(long examRecordId) {
		return getPersistence().countByexamRecordId(examRecordId);
	}

	/**
	* Caches the exam question link in the entity cache if it is enabled.
	*
	* @param examQuestionLink the exam question link
	*/
	public static void cacheResult(ExamQuestionLink examQuestionLink) {
		getPersistence().cacheResult(examQuestionLink);
	}

	/**
	* Caches the exam question links in the entity cache if it is enabled.
	*
	* @param examQuestionLinks the exam question links
	*/
	public static void cacheResult(List<ExamQuestionLink> examQuestionLinks) {
		getPersistence().cacheResult(examQuestionLinks);
	}

	/**
	* Creates a new exam question link with the primary key. Does not add the exam question link to the database.
	*
	* @param examQuestionLinkPK the primary key for the new exam question link
	* @return the new exam question link
	*/
	public static ExamQuestionLink create(
		priv.barrow.service.persistence.ExamQuestionLinkPK examQuestionLinkPK) {
		return getPersistence().create(examQuestionLinkPK);
	}

	/**
	* Removes the exam question link with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param examQuestionLinkPK the primary key of the exam question link
	* @return the exam question link that was removed
	* @throws NoSuchExamQuestionLinkException if a exam question link with the primary key could not be found
	*/
	public static ExamQuestionLink remove(
		priv.barrow.service.persistence.ExamQuestionLinkPK examQuestionLinkPK)
		throws priv.barrow.exception.NoSuchExamQuestionLinkException {
		return getPersistence().remove(examQuestionLinkPK);
	}

	public static ExamQuestionLink updateImpl(ExamQuestionLink examQuestionLink) {
		return getPersistence().updateImpl(examQuestionLink);
	}

	/**
	* Returns the exam question link with the primary key or throws a {@link NoSuchExamQuestionLinkException} if it could not be found.
	*
	* @param examQuestionLinkPK the primary key of the exam question link
	* @return the exam question link
	* @throws NoSuchExamQuestionLinkException if a exam question link with the primary key could not be found
	*/
	public static ExamQuestionLink findByPrimaryKey(
		priv.barrow.service.persistence.ExamQuestionLinkPK examQuestionLinkPK)
		throws priv.barrow.exception.NoSuchExamQuestionLinkException {
		return getPersistence().findByPrimaryKey(examQuestionLinkPK);
	}

	/**
	* Returns the exam question link with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param examQuestionLinkPK the primary key of the exam question link
	* @return the exam question link, or <code>null</code> if a exam question link with the primary key could not be found
	*/
	public static ExamQuestionLink fetchByPrimaryKey(
		priv.barrow.service.persistence.ExamQuestionLinkPK examQuestionLinkPK) {
		return getPersistence().fetchByPrimaryKey(examQuestionLinkPK);
	}

	public static java.util.Map<java.io.Serializable, ExamQuestionLink> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the exam question links.
	*
	* @return the exam question links
	*/
	public static List<ExamQuestionLink> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<ExamQuestionLink> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<ExamQuestionLink> findAll(int start, int end,
		OrderByComparator<ExamQuestionLink> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<ExamQuestionLink> findAll(int start, int end,
		OrderByComparator<ExamQuestionLink> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the exam question links from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of exam question links.
	*
	* @return the number of exam question links
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ExamQuestionLinkPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ExamQuestionLinkPersistence, ExamQuestionLinkPersistence> _serviceTracker =
		ServiceTrackerFactory.open(ExamQuestionLinkPersistence.class);
}