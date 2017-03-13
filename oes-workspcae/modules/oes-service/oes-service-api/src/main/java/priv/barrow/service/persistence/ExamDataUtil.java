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

import priv.barrow.model.ExamData;

import java.util.List;

/**
 * The persistence utility for the exam data service. This utility wraps {@link priv.barrow.service.persistence.impl.ExamDataPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ExamDataPersistence
 * @see priv.barrow.service.persistence.impl.ExamDataPersistenceImpl
 * @generated
 */
@ProviderType
public class ExamDataUtil {
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
	public static void clearCache(ExamData examData) {
		getPersistence().clearCache(examData);
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
	public static List<ExamData> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ExamData> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ExamData> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ExamData> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ExamData update(ExamData examData) {
		return getPersistence().update(examData);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ExamData update(ExamData examData,
		ServiceContext serviceContext) {
		return getPersistence().update(examData, serviceContext);
	}

	/**
	* Returns all the exam datas where examId = &#63; and studentId = &#63; and questionOrder = &#63;.
	*
	* @param examId the exam ID
	* @param studentId the student ID
	* @param questionOrder the question order
	* @return the matching exam datas
	*/
	public static List<ExamData> findByExamIdAndStudentIdAndQuestionOrder(
		long examId, long studentId, long questionOrder) {
		return getPersistence()
				   .findByExamIdAndStudentIdAndQuestionOrder(examId, studentId,
			questionOrder);
	}

	/**
	* Returns a range of all the exam datas where examId = &#63; and studentId = &#63; and questionOrder = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExamDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param examId the exam ID
	* @param studentId the student ID
	* @param questionOrder the question order
	* @param start the lower bound of the range of exam datas
	* @param end the upper bound of the range of exam datas (not inclusive)
	* @return the range of matching exam datas
	*/
	public static List<ExamData> findByExamIdAndStudentIdAndQuestionOrder(
		long examId, long studentId, long questionOrder, int start, int end) {
		return getPersistence()
				   .findByExamIdAndStudentIdAndQuestionOrder(examId, studentId,
			questionOrder, start, end);
	}

	/**
	* Returns an ordered range of all the exam datas where examId = &#63; and studentId = &#63; and questionOrder = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExamDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param examId the exam ID
	* @param studentId the student ID
	* @param questionOrder the question order
	* @param start the lower bound of the range of exam datas
	* @param end the upper bound of the range of exam datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching exam datas
	*/
	public static List<ExamData> findByExamIdAndStudentIdAndQuestionOrder(
		long examId, long studentId, long questionOrder, int start, int end,
		OrderByComparator<ExamData> orderByComparator) {
		return getPersistence()
				   .findByExamIdAndStudentIdAndQuestionOrder(examId, studentId,
			questionOrder, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the exam datas where examId = &#63; and studentId = &#63; and questionOrder = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExamDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param examId the exam ID
	* @param studentId the student ID
	* @param questionOrder the question order
	* @param start the lower bound of the range of exam datas
	* @param end the upper bound of the range of exam datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching exam datas
	*/
	public static List<ExamData> findByExamIdAndStudentIdAndQuestionOrder(
		long examId, long studentId, long questionOrder, int start, int end,
		OrderByComparator<ExamData> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByExamIdAndStudentIdAndQuestionOrder(examId, studentId,
			questionOrder, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first exam data in the ordered set where examId = &#63; and studentId = &#63; and questionOrder = &#63;.
	*
	* @param examId the exam ID
	* @param studentId the student ID
	* @param questionOrder the question order
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching exam data
	* @throws NoSuchExamDataException if a matching exam data could not be found
	*/
	public static ExamData findByExamIdAndStudentIdAndQuestionOrder_First(
		long examId, long studentId, long questionOrder,
		OrderByComparator<ExamData> orderByComparator)
		throws priv.barrow.exception.NoSuchExamDataException {
		return getPersistence()
				   .findByExamIdAndStudentIdAndQuestionOrder_First(examId,
			studentId, questionOrder, orderByComparator);
	}

	/**
	* Returns the first exam data in the ordered set where examId = &#63; and studentId = &#63; and questionOrder = &#63;.
	*
	* @param examId the exam ID
	* @param studentId the student ID
	* @param questionOrder the question order
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching exam data, or <code>null</code> if a matching exam data could not be found
	*/
	public static ExamData fetchByExamIdAndStudentIdAndQuestionOrder_First(
		long examId, long studentId, long questionOrder,
		OrderByComparator<ExamData> orderByComparator) {
		return getPersistence()
				   .fetchByExamIdAndStudentIdAndQuestionOrder_First(examId,
			studentId, questionOrder, orderByComparator);
	}

	/**
	* Returns the last exam data in the ordered set where examId = &#63; and studentId = &#63; and questionOrder = &#63;.
	*
	* @param examId the exam ID
	* @param studentId the student ID
	* @param questionOrder the question order
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching exam data
	* @throws NoSuchExamDataException if a matching exam data could not be found
	*/
	public static ExamData findByExamIdAndStudentIdAndQuestionOrder_Last(
		long examId, long studentId, long questionOrder,
		OrderByComparator<ExamData> orderByComparator)
		throws priv.barrow.exception.NoSuchExamDataException {
		return getPersistence()
				   .findByExamIdAndStudentIdAndQuestionOrder_Last(examId,
			studentId, questionOrder, orderByComparator);
	}

	/**
	* Returns the last exam data in the ordered set where examId = &#63; and studentId = &#63; and questionOrder = &#63;.
	*
	* @param examId the exam ID
	* @param studentId the student ID
	* @param questionOrder the question order
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching exam data, or <code>null</code> if a matching exam data could not be found
	*/
	public static ExamData fetchByExamIdAndStudentIdAndQuestionOrder_Last(
		long examId, long studentId, long questionOrder,
		OrderByComparator<ExamData> orderByComparator) {
		return getPersistence()
				   .fetchByExamIdAndStudentIdAndQuestionOrder_Last(examId,
			studentId, questionOrder, orderByComparator);
	}

	/**
	* Returns the exam datas before and after the current exam data in the ordered set where examId = &#63; and studentId = &#63; and questionOrder = &#63;.
	*
	* @param PK the primary key of the current exam data
	* @param examId the exam ID
	* @param studentId the student ID
	* @param questionOrder the question order
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next exam data
	* @throws NoSuchExamDataException if a exam data with the primary key could not be found
	*/
	public static ExamData[] findByExamIdAndStudentIdAndQuestionOrder_PrevAndNext(
		long PK, long examId, long studentId, long questionOrder,
		OrderByComparator<ExamData> orderByComparator)
		throws priv.barrow.exception.NoSuchExamDataException {
		return getPersistence()
				   .findByExamIdAndStudentIdAndQuestionOrder_PrevAndNext(PK,
			examId, studentId, questionOrder, orderByComparator);
	}

	/**
	* Removes all the exam datas where examId = &#63; and studentId = &#63; and questionOrder = &#63; from the database.
	*
	* @param examId the exam ID
	* @param studentId the student ID
	* @param questionOrder the question order
	*/
	public static void removeByExamIdAndStudentIdAndQuestionOrder(long examId,
		long studentId, long questionOrder) {
		getPersistence()
			.removeByExamIdAndStudentIdAndQuestionOrder(examId, studentId,
			questionOrder);
	}

	/**
	* Returns the number of exam datas where examId = &#63; and studentId = &#63; and questionOrder = &#63;.
	*
	* @param examId the exam ID
	* @param studentId the student ID
	* @param questionOrder the question order
	* @return the number of matching exam datas
	*/
	public static int countByExamIdAndStudentIdAndQuestionOrder(long examId,
		long studentId, long questionOrder) {
		return getPersistence()
				   .countByExamIdAndStudentIdAndQuestionOrder(examId,
			studentId, questionOrder);
	}

	/**
	* Returns all the exam datas where examId = &#63; and studentId = &#63;.
	*
	* @param examId the exam ID
	* @param studentId the student ID
	* @return the matching exam datas
	*/
	public static List<ExamData> findByExamIdAndStudentId(long examId,
		long studentId) {
		return getPersistence().findByExamIdAndStudentId(examId, studentId);
	}

	/**
	* Returns a range of all the exam datas where examId = &#63; and studentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExamDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param examId the exam ID
	* @param studentId the student ID
	* @param start the lower bound of the range of exam datas
	* @param end the upper bound of the range of exam datas (not inclusive)
	* @return the range of matching exam datas
	*/
	public static List<ExamData> findByExamIdAndStudentId(long examId,
		long studentId, int start, int end) {
		return getPersistence()
				   .findByExamIdAndStudentId(examId, studentId, start, end);
	}

	/**
	* Returns an ordered range of all the exam datas where examId = &#63; and studentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExamDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param examId the exam ID
	* @param studentId the student ID
	* @param start the lower bound of the range of exam datas
	* @param end the upper bound of the range of exam datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching exam datas
	*/
	public static List<ExamData> findByExamIdAndStudentId(long examId,
		long studentId, int start, int end,
		OrderByComparator<ExamData> orderByComparator) {
		return getPersistence()
				   .findByExamIdAndStudentId(examId, studentId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the exam datas where examId = &#63; and studentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExamDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param examId the exam ID
	* @param studentId the student ID
	* @param start the lower bound of the range of exam datas
	* @param end the upper bound of the range of exam datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching exam datas
	*/
	public static List<ExamData> findByExamIdAndStudentId(long examId,
		long studentId, int start, int end,
		OrderByComparator<ExamData> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByExamIdAndStudentId(examId, studentId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first exam data in the ordered set where examId = &#63; and studentId = &#63;.
	*
	* @param examId the exam ID
	* @param studentId the student ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching exam data
	* @throws NoSuchExamDataException if a matching exam data could not be found
	*/
	public static ExamData findByExamIdAndStudentId_First(long examId,
		long studentId, OrderByComparator<ExamData> orderByComparator)
		throws priv.barrow.exception.NoSuchExamDataException {
		return getPersistence()
				   .findByExamIdAndStudentId_First(examId, studentId,
			orderByComparator);
	}

	/**
	* Returns the first exam data in the ordered set where examId = &#63; and studentId = &#63;.
	*
	* @param examId the exam ID
	* @param studentId the student ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching exam data, or <code>null</code> if a matching exam data could not be found
	*/
	public static ExamData fetchByExamIdAndStudentId_First(long examId,
		long studentId, OrderByComparator<ExamData> orderByComparator) {
		return getPersistence()
				   .fetchByExamIdAndStudentId_First(examId, studentId,
			orderByComparator);
	}

	/**
	* Returns the last exam data in the ordered set where examId = &#63; and studentId = &#63;.
	*
	* @param examId the exam ID
	* @param studentId the student ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching exam data
	* @throws NoSuchExamDataException if a matching exam data could not be found
	*/
	public static ExamData findByExamIdAndStudentId_Last(long examId,
		long studentId, OrderByComparator<ExamData> orderByComparator)
		throws priv.barrow.exception.NoSuchExamDataException {
		return getPersistence()
				   .findByExamIdAndStudentId_Last(examId, studentId,
			orderByComparator);
	}

	/**
	* Returns the last exam data in the ordered set where examId = &#63; and studentId = &#63;.
	*
	* @param examId the exam ID
	* @param studentId the student ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching exam data, or <code>null</code> if a matching exam data could not be found
	*/
	public static ExamData fetchByExamIdAndStudentId_Last(long examId,
		long studentId, OrderByComparator<ExamData> orderByComparator) {
		return getPersistence()
				   .fetchByExamIdAndStudentId_Last(examId, studentId,
			orderByComparator);
	}

	/**
	* Returns the exam datas before and after the current exam data in the ordered set where examId = &#63; and studentId = &#63;.
	*
	* @param PK the primary key of the current exam data
	* @param examId the exam ID
	* @param studentId the student ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next exam data
	* @throws NoSuchExamDataException if a exam data with the primary key could not be found
	*/
	public static ExamData[] findByExamIdAndStudentId_PrevAndNext(long PK,
		long examId, long studentId,
		OrderByComparator<ExamData> orderByComparator)
		throws priv.barrow.exception.NoSuchExamDataException {
		return getPersistence()
				   .findByExamIdAndStudentId_PrevAndNext(PK, examId, studentId,
			orderByComparator);
	}

	/**
	* Removes all the exam datas where examId = &#63; and studentId = &#63; from the database.
	*
	* @param examId the exam ID
	* @param studentId the student ID
	*/
	public static void removeByExamIdAndStudentId(long examId, long studentId) {
		getPersistence().removeByExamIdAndStudentId(examId, studentId);
	}

	/**
	* Returns the number of exam datas where examId = &#63; and studentId = &#63;.
	*
	* @param examId the exam ID
	* @param studentId the student ID
	* @return the number of matching exam datas
	*/
	public static int countByExamIdAndStudentId(long examId, long studentId) {
		return getPersistence().countByExamIdAndStudentId(examId, studentId);
	}

	/**
	* Caches the exam data in the entity cache if it is enabled.
	*
	* @param examData the exam data
	*/
	public static void cacheResult(ExamData examData) {
		getPersistence().cacheResult(examData);
	}

	/**
	* Caches the exam datas in the entity cache if it is enabled.
	*
	* @param examDatas the exam datas
	*/
	public static void cacheResult(List<ExamData> examDatas) {
		getPersistence().cacheResult(examDatas);
	}

	/**
	* Creates a new exam data with the primary key. Does not add the exam data to the database.
	*
	* @param PK the primary key for the new exam data
	* @return the new exam data
	*/
	public static ExamData create(long PK) {
		return getPersistence().create(PK);
	}

	/**
	* Removes the exam data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PK the primary key of the exam data
	* @return the exam data that was removed
	* @throws NoSuchExamDataException if a exam data with the primary key could not be found
	*/
	public static ExamData remove(long PK)
		throws priv.barrow.exception.NoSuchExamDataException {
		return getPersistence().remove(PK);
	}

	public static ExamData updateImpl(ExamData examData) {
		return getPersistence().updateImpl(examData);
	}

	/**
	* Returns the exam data with the primary key or throws a {@link NoSuchExamDataException} if it could not be found.
	*
	* @param PK the primary key of the exam data
	* @return the exam data
	* @throws NoSuchExamDataException if a exam data with the primary key could not be found
	*/
	public static ExamData findByPrimaryKey(long PK)
		throws priv.barrow.exception.NoSuchExamDataException {
		return getPersistence().findByPrimaryKey(PK);
	}

	/**
	* Returns the exam data with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PK the primary key of the exam data
	* @return the exam data, or <code>null</code> if a exam data with the primary key could not be found
	*/
	public static ExamData fetchByPrimaryKey(long PK) {
		return getPersistence().fetchByPrimaryKey(PK);
	}

	public static java.util.Map<java.io.Serializable, ExamData> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the exam datas.
	*
	* @return the exam datas
	*/
	public static List<ExamData> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the exam datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExamDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of exam datas
	* @param end the upper bound of the range of exam datas (not inclusive)
	* @return the range of exam datas
	*/
	public static List<ExamData> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the exam datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExamDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of exam datas
	* @param end the upper bound of the range of exam datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of exam datas
	*/
	public static List<ExamData> findAll(int start, int end,
		OrderByComparator<ExamData> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the exam datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExamDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of exam datas
	* @param end the upper bound of the range of exam datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of exam datas
	*/
	public static List<ExamData> findAll(int start, int end,
		OrderByComparator<ExamData> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the exam datas from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of exam datas.
	*
	* @return the number of exam datas
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ExamDataPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ExamDataPersistence, ExamDataPersistence> _serviceTracker =
		ServiceTrackerFactory.open(ExamDataPersistence.class);
}