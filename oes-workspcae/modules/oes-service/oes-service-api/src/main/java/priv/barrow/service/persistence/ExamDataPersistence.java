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

import priv.barrow.exception.NoSuchExamDataException;

import priv.barrow.model.ExamData;

/**
 * The persistence interface for the exam data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see priv.barrow.service.persistence.impl.ExamDataPersistenceImpl
 * @see ExamDataUtil
 * @generated
 */
@ProviderType
public interface ExamDataPersistence extends BasePersistence<ExamData> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ExamDataUtil} to access the exam data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the exam datas where examId = &#63; and studentId = &#63; and questionOrder = &#63;.
	*
	* @param examId the exam ID
	* @param studentId the student ID
	* @param questionOrder the question order
	* @return the matching exam datas
	*/
	public java.util.List<ExamData> findByExamIdAndStudentIdAndQuestionOrder(
		long examId, long studentId, long questionOrder);

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
	public java.util.List<ExamData> findByExamIdAndStudentIdAndQuestionOrder(
		long examId, long studentId, long questionOrder, int start, int end);

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
	public java.util.List<ExamData> findByExamIdAndStudentIdAndQuestionOrder(
		long examId, long studentId, long questionOrder, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ExamData> orderByComparator);

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
	public java.util.List<ExamData> findByExamIdAndStudentIdAndQuestionOrder(
		long examId, long studentId, long questionOrder, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ExamData> orderByComparator,
		boolean retrieveFromCache);

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
	public ExamData findByExamIdAndStudentIdAndQuestionOrder_First(
		long examId, long studentId, long questionOrder,
		com.liferay.portal.kernel.util.OrderByComparator<ExamData> orderByComparator)
		throws NoSuchExamDataException;

	/**
	* Returns the first exam data in the ordered set where examId = &#63; and studentId = &#63; and questionOrder = &#63;.
	*
	* @param examId the exam ID
	* @param studentId the student ID
	* @param questionOrder the question order
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching exam data, or <code>null</code> if a matching exam data could not be found
	*/
	public ExamData fetchByExamIdAndStudentIdAndQuestionOrder_First(
		long examId, long studentId, long questionOrder,
		com.liferay.portal.kernel.util.OrderByComparator<ExamData> orderByComparator);

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
	public ExamData findByExamIdAndStudentIdAndQuestionOrder_Last(long examId,
		long studentId, long questionOrder,
		com.liferay.portal.kernel.util.OrderByComparator<ExamData> orderByComparator)
		throws NoSuchExamDataException;

	/**
	* Returns the last exam data in the ordered set where examId = &#63; and studentId = &#63; and questionOrder = &#63;.
	*
	* @param examId the exam ID
	* @param studentId the student ID
	* @param questionOrder the question order
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching exam data, or <code>null</code> if a matching exam data could not be found
	*/
	public ExamData fetchByExamIdAndStudentIdAndQuestionOrder_Last(
		long examId, long studentId, long questionOrder,
		com.liferay.portal.kernel.util.OrderByComparator<ExamData> orderByComparator);

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
	public ExamData[] findByExamIdAndStudentIdAndQuestionOrder_PrevAndNext(
		long PK, long examId, long studentId, long questionOrder,
		com.liferay.portal.kernel.util.OrderByComparator<ExamData> orderByComparator)
		throws NoSuchExamDataException;

	/**
	* Removes all the exam datas where examId = &#63; and studentId = &#63; and questionOrder = &#63; from the database.
	*
	* @param examId the exam ID
	* @param studentId the student ID
	* @param questionOrder the question order
	*/
	public void removeByExamIdAndStudentIdAndQuestionOrder(long examId,
		long studentId, long questionOrder);

	/**
	* Returns the number of exam datas where examId = &#63; and studentId = &#63; and questionOrder = &#63;.
	*
	* @param examId the exam ID
	* @param studentId the student ID
	* @param questionOrder the question order
	* @return the number of matching exam datas
	*/
	public int countByExamIdAndStudentIdAndQuestionOrder(long examId,
		long studentId, long questionOrder);

	/**
	* Caches the exam data in the entity cache if it is enabled.
	*
	* @param examData the exam data
	*/
	public void cacheResult(ExamData examData);

	/**
	* Caches the exam datas in the entity cache if it is enabled.
	*
	* @param examDatas the exam datas
	*/
	public void cacheResult(java.util.List<ExamData> examDatas);

	/**
	* Creates a new exam data with the primary key. Does not add the exam data to the database.
	*
	* @param PK the primary key for the new exam data
	* @return the new exam data
	*/
	public ExamData create(long PK);

	/**
	* Removes the exam data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PK the primary key of the exam data
	* @return the exam data that was removed
	* @throws NoSuchExamDataException if a exam data with the primary key could not be found
	*/
	public ExamData remove(long PK) throws NoSuchExamDataException;

	public ExamData updateImpl(ExamData examData);

	/**
	* Returns the exam data with the primary key or throws a {@link NoSuchExamDataException} if it could not be found.
	*
	* @param PK the primary key of the exam data
	* @return the exam data
	* @throws NoSuchExamDataException if a exam data with the primary key could not be found
	*/
	public ExamData findByPrimaryKey(long PK) throws NoSuchExamDataException;

	/**
	* Returns the exam data with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PK the primary key of the exam data
	* @return the exam data, or <code>null</code> if a exam data with the primary key could not be found
	*/
	public ExamData fetchByPrimaryKey(long PK);

	@Override
	public java.util.Map<java.io.Serializable, ExamData> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the exam datas.
	*
	* @return the exam datas
	*/
	public java.util.List<ExamData> findAll();

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
	public java.util.List<ExamData> findAll(int start, int end);

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
	public java.util.List<ExamData> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ExamData> orderByComparator);

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
	public java.util.List<ExamData> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ExamData> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the exam datas from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of exam datas.
	*
	* @return the number of exam datas
	*/
	public int countAll();
}