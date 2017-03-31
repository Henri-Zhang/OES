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

package priv.barrow.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import priv.barrow.exception.NoSuchStudentExamLinkException;

import priv.barrow.model.StudentExamLink;
import priv.barrow.model.impl.StudentExamLinkImpl;
import priv.barrow.model.impl.StudentExamLinkModelImpl;

import priv.barrow.service.persistence.StudentExamLinkPK;
import priv.barrow.service.persistence.StudentExamLinkPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the student exam link service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StudentExamLinkPersistence
 * @see priv.barrow.service.persistence.StudentExamLinkUtil
 * @generated
 */
@ProviderType
public class StudentExamLinkPersistenceImpl extends BasePersistenceImpl<StudentExamLink>
	implements StudentExamLinkPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StudentExamLinkUtil} to access the student exam link persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StudentExamLinkImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StudentExamLinkModelImpl.ENTITY_CACHE_ENABLED,
			StudentExamLinkModelImpl.FINDER_CACHE_ENABLED,
			StudentExamLinkImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StudentExamLinkModelImpl.ENTITY_CACHE_ENABLED,
			StudentExamLinkModelImpl.FINDER_CACHE_ENABLED,
			StudentExamLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StudentExamLinkModelImpl.ENTITY_CACHE_ENABLED,
			StudentExamLinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EXAMRECORDID =
		new FinderPath(StudentExamLinkModelImpl.ENTITY_CACHE_ENABLED,
			StudentExamLinkModelImpl.FINDER_CACHE_ENABLED,
			StudentExamLinkImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByExamRecordId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EXAMRECORDID =
		new FinderPath(StudentExamLinkModelImpl.ENTITY_CACHE_ENABLED,
			StudentExamLinkModelImpl.FINDER_CACHE_ENABLED,
			StudentExamLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByExamRecordId",
			new String[] { Long.class.getName() },
			StudentExamLinkModelImpl.EXAMRECORDID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EXAMRECORDID = new FinderPath(StudentExamLinkModelImpl.ENTITY_CACHE_ENABLED,
			StudentExamLinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByExamRecordId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the student exam links where examRecordId = &#63;.
	 *
	 * @param examRecordId the exam record ID
	 * @return the matching student exam links
	 */
	@Override
	public List<StudentExamLink> findByExamRecordId(long examRecordId) {
		return findByExamRecordId(examRecordId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<StudentExamLink> findByExamRecordId(long examRecordId,
		int start, int end) {
		return findByExamRecordId(examRecordId, start, end, null);
	}

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
	@Override
	public List<StudentExamLink> findByExamRecordId(long examRecordId,
		int start, int end, OrderByComparator<StudentExamLink> orderByComparator) {
		return findByExamRecordId(examRecordId, start, end, orderByComparator,
			true);
	}

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
	@Override
	public List<StudentExamLink> findByExamRecordId(long examRecordId,
		int start, int end,
		OrderByComparator<StudentExamLink> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EXAMRECORDID;
			finderArgs = new Object[] { examRecordId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EXAMRECORDID;
			finderArgs = new Object[] {
					examRecordId,
					
					start, end, orderByComparator
				};
		}

		List<StudentExamLink> list = null;

		if (retrieveFromCache) {
			list = (List<StudentExamLink>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (StudentExamLink studentExamLink : list) {
					if ((examRecordId != studentExamLink.getExamRecordId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_STUDENTEXAMLINK_WHERE);

			query.append(_FINDER_COLUMN_EXAMRECORDID_EXAMRECORDID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StudentExamLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(examRecordId);

				if (!pagination) {
					list = (List<StudentExamLink>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<StudentExamLink>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first student exam link in the ordered set where examRecordId = &#63;.
	 *
	 * @param examRecordId the exam record ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student exam link
	 * @throws NoSuchStudentExamLinkException if a matching student exam link could not be found
	 */
	@Override
	public StudentExamLink findByExamRecordId_First(long examRecordId,
		OrderByComparator<StudentExamLink> orderByComparator)
		throws NoSuchStudentExamLinkException {
		StudentExamLink studentExamLink = fetchByExamRecordId_First(examRecordId,
				orderByComparator);

		if (studentExamLink != null) {
			return studentExamLink;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("examRecordId=");
		msg.append(examRecordId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStudentExamLinkException(msg.toString());
	}

	/**
	 * Returns the first student exam link in the ordered set where examRecordId = &#63;.
	 *
	 * @param examRecordId the exam record ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student exam link, or <code>null</code> if a matching student exam link could not be found
	 */
	@Override
	public StudentExamLink fetchByExamRecordId_First(long examRecordId,
		OrderByComparator<StudentExamLink> orderByComparator) {
		List<StudentExamLink> list = findByExamRecordId(examRecordId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last student exam link in the ordered set where examRecordId = &#63;.
	 *
	 * @param examRecordId the exam record ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student exam link
	 * @throws NoSuchStudentExamLinkException if a matching student exam link could not be found
	 */
	@Override
	public StudentExamLink findByExamRecordId_Last(long examRecordId,
		OrderByComparator<StudentExamLink> orderByComparator)
		throws NoSuchStudentExamLinkException {
		StudentExamLink studentExamLink = fetchByExamRecordId_Last(examRecordId,
				orderByComparator);

		if (studentExamLink != null) {
			return studentExamLink;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("examRecordId=");
		msg.append(examRecordId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStudentExamLinkException(msg.toString());
	}

	/**
	 * Returns the last student exam link in the ordered set where examRecordId = &#63;.
	 *
	 * @param examRecordId the exam record ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student exam link, or <code>null</code> if a matching student exam link could not be found
	 */
	@Override
	public StudentExamLink fetchByExamRecordId_Last(long examRecordId,
		OrderByComparator<StudentExamLink> orderByComparator) {
		int count = countByExamRecordId(examRecordId);

		if (count == 0) {
			return null;
		}

		List<StudentExamLink> list = findByExamRecordId(examRecordId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the student exam links before and after the current student exam link in the ordered set where examRecordId = &#63;.
	 *
	 * @param studentExamLinkPK the primary key of the current student exam link
	 * @param examRecordId the exam record ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next student exam link
	 * @throws NoSuchStudentExamLinkException if a student exam link with the primary key could not be found
	 */
	@Override
	public StudentExamLink[] findByExamRecordId_PrevAndNext(
		StudentExamLinkPK studentExamLinkPK, long examRecordId,
		OrderByComparator<StudentExamLink> orderByComparator)
		throws NoSuchStudentExamLinkException {
		StudentExamLink studentExamLink = findByPrimaryKey(studentExamLinkPK);

		Session session = null;

		try {
			session = openSession();

			StudentExamLink[] array = new StudentExamLinkImpl[3];

			array[0] = getByExamRecordId_PrevAndNext(session, studentExamLink,
					examRecordId, orderByComparator, true);

			array[1] = studentExamLink;

			array[2] = getByExamRecordId_PrevAndNext(session, studentExamLink,
					examRecordId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected StudentExamLink getByExamRecordId_PrevAndNext(Session session,
		StudentExamLink studentExamLink, long examRecordId,
		OrderByComparator<StudentExamLink> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STUDENTEXAMLINK_WHERE);

		query.append(_FINDER_COLUMN_EXAMRECORDID_EXAMRECORDID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(StudentExamLinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(examRecordId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(studentExamLink);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StudentExamLink> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the student exam links where examRecordId = &#63; from the database.
	 *
	 * @param examRecordId the exam record ID
	 */
	@Override
	public void removeByExamRecordId(long examRecordId) {
		for (StudentExamLink studentExamLink : findByExamRecordId(
				examRecordId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(studentExamLink);
		}
	}

	/**
	 * Returns the number of student exam links where examRecordId = &#63;.
	 *
	 * @param examRecordId the exam record ID
	 * @return the number of matching student exam links
	 */
	@Override
	public int countByExamRecordId(long examRecordId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EXAMRECORDID;

		Object[] finderArgs = new Object[] { examRecordId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STUDENTEXAMLINK_WHERE);

			query.append(_FINDER_COLUMN_EXAMRECORDID_EXAMRECORDID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(examRecordId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_EXAMRECORDID_EXAMRECORDID_2 = "studentExamLink.id.examRecordId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EXAMRECORDIDANDDONE =
		new FinderPath(StudentExamLinkModelImpl.ENTITY_CACHE_ENABLED,
			StudentExamLinkModelImpl.FINDER_CACHE_ENABLED,
			StudentExamLinkImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByExamRecordIdAndDone",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EXAMRECORDIDANDDONE =
		new FinderPath(StudentExamLinkModelImpl.ENTITY_CACHE_ENABLED,
			StudentExamLinkModelImpl.FINDER_CACHE_ENABLED,
			StudentExamLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByExamRecordIdAndDone",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			StudentExamLinkModelImpl.EXAMRECORDID_COLUMN_BITMASK |
			StudentExamLinkModelImpl.DONE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EXAMRECORDIDANDDONE = new FinderPath(StudentExamLinkModelImpl.ENTITY_CACHE_ENABLED,
			StudentExamLinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByExamRecordIdAndDone",
			new String[] { Long.class.getName(), Boolean.class.getName() });

	/**
	 * Returns all the student exam links where examRecordId = &#63; and done = &#63;.
	 *
	 * @param examRecordId the exam record ID
	 * @param done the done
	 * @return the matching student exam links
	 */
	@Override
	public List<StudentExamLink> findByExamRecordIdAndDone(long examRecordId,
		boolean done) {
		return findByExamRecordIdAndDone(examRecordId, done, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the student exam links where examRecordId = &#63; and done = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StudentExamLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param examRecordId the exam record ID
	 * @param done the done
	 * @param start the lower bound of the range of student exam links
	 * @param end the upper bound of the range of student exam links (not inclusive)
	 * @return the range of matching student exam links
	 */
	@Override
	public List<StudentExamLink> findByExamRecordIdAndDone(long examRecordId,
		boolean done, int start, int end) {
		return findByExamRecordIdAndDone(examRecordId, done, start, end, null);
	}

	/**
	 * Returns an ordered range of all the student exam links where examRecordId = &#63; and done = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StudentExamLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param examRecordId the exam record ID
	 * @param done the done
	 * @param start the lower bound of the range of student exam links
	 * @param end the upper bound of the range of student exam links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching student exam links
	 */
	@Override
	public List<StudentExamLink> findByExamRecordIdAndDone(long examRecordId,
		boolean done, int start, int end,
		OrderByComparator<StudentExamLink> orderByComparator) {
		return findByExamRecordIdAndDone(examRecordId, done, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the student exam links where examRecordId = &#63; and done = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StudentExamLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param examRecordId the exam record ID
	 * @param done the done
	 * @param start the lower bound of the range of student exam links
	 * @param end the upper bound of the range of student exam links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching student exam links
	 */
	@Override
	public List<StudentExamLink> findByExamRecordIdAndDone(long examRecordId,
		boolean done, int start, int end,
		OrderByComparator<StudentExamLink> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EXAMRECORDIDANDDONE;
			finderArgs = new Object[] { examRecordId, done };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EXAMRECORDIDANDDONE;
			finderArgs = new Object[] {
					examRecordId, done,
					
					start, end, orderByComparator
				};
		}

		List<StudentExamLink> list = null;

		if (retrieveFromCache) {
			list = (List<StudentExamLink>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (StudentExamLink studentExamLink : list) {
					if ((examRecordId != studentExamLink.getExamRecordId()) ||
							(done != studentExamLink.getDone())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_STUDENTEXAMLINK_WHERE);

			query.append(_FINDER_COLUMN_EXAMRECORDIDANDDONE_EXAMRECORDID_2);

			query.append(_FINDER_COLUMN_EXAMRECORDIDANDDONE_DONE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StudentExamLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(examRecordId);

				qPos.add(done);

				if (!pagination) {
					list = (List<StudentExamLink>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<StudentExamLink>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first student exam link in the ordered set where examRecordId = &#63; and done = &#63;.
	 *
	 * @param examRecordId the exam record ID
	 * @param done the done
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student exam link
	 * @throws NoSuchStudentExamLinkException if a matching student exam link could not be found
	 */
	@Override
	public StudentExamLink findByExamRecordIdAndDone_First(long examRecordId,
		boolean done, OrderByComparator<StudentExamLink> orderByComparator)
		throws NoSuchStudentExamLinkException {
		StudentExamLink studentExamLink = fetchByExamRecordIdAndDone_First(examRecordId,
				done, orderByComparator);

		if (studentExamLink != null) {
			return studentExamLink;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("examRecordId=");
		msg.append(examRecordId);

		msg.append(", done=");
		msg.append(done);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStudentExamLinkException(msg.toString());
	}

	/**
	 * Returns the first student exam link in the ordered set where examRecordId = &#63; and done = &#63;.
	 *
	 * @param examRecordId the exam record ID
	 * @param done the done
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student exam link, or <code>null</code> if a matching student exam link could not be found
	 */
	@Override
	public StudentExamLink fetchByExamRecordIdAndDone_First(long examRecordId,
		boolean done, OrderByComparator<StudentExamLink> orderByComparator) {
		List<StudentExamLink> list = findByExamRecordIdAndDone(examRecordId,
				done, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last student exam link in the ordered set where examRecordId = &#63; and done = &#63;.
	 *
	 * @param examRecordId the exam record ID
	 * @param done the done
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student exam link
	 * @throws NoSuchStudentExamLinkException if a matching student exam link could not be found
	 */
	@Override
	public StudentExamLink findByExamRecordIdAndDone_Last(long examRecordId,
		boolean done, OrderByComparator<StudentExamLink> orderByComparator)
		throws NoSuchStudentExamLinkException {
		StudentExamLink studentExamLink = fetchByExamRecordIdAndDone_Last(examRecordId,
				done, orderByComparator);

		if (studentExamLink != null) {
			return studentExamLink;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("examRecordId=");
		msg.append(examRecordId);

		msg.append(", done=");
		msg.append(done);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStudentExamLinkException(msg.toString());
	}

	/**
	 * Returns the last student exam link in the ordered set where examRecordId = &#63; and done = &#63;.
	 *
	 * @param examRecordId the exam record ID
	 * @param done the done
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student exam link, or <code>null</code> if a matching student exam link could not be found
	 */
	@Override
	public StudentExamLink fetchByExamRecordIdAndDone_Last(long examRecordId,
		boolean done, OrderByComparator<StudentExamLink> orderByComparator) {
		int count = countByExamRecordIdAndDone(examRecordId, done);

		if (count == 0) {
			return null;
		}

		List<StudentExamLink> list = findByExamRecordIdAndDone(examRecordId,
				done, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the student exam links before and after the current student exam link in the ordered set where examRecordId = &#63; and done = &#63;.
	 *
	 * @param studentExamLinkPK the primary key of the current student exam link
	 * @param examRecordId the exam record ID
	 * @param done the done
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next student exam link
	 * @throws NoSuchStudentExamLinkException if a student exam link with the primary key could not be found
	 */
	@Override
	public StudentExamLink[] findByExamRecordIdAndDone_PrevAndNext(
		StudentExamLinkPK studentExamLinkPK, long examRecordId, boolean done,
		OrderByComparator<StudentExamLink> orderByComparator)
		throws NoSuchStudentExamLinkException {
		StudentExamLink studentExamLink = findByPrimaryKey(studentExamLinkPK);

		Session session = null;

		try {
			session = openSession();

			StudentExamLink[] array = new StudentExamLinkImpl[3];

			array[0] = getByExamRecordIdAndDone_PrevAndNext(session,
					studentExamLink, examRecordId, done, orderByComparator, true);

			array[1] = studentExamLink;

			array[2] = getByExamRecordIdAndDone_PrevAndNext(session,
					studentExamLink, examRecordId, done, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected StudentExamLink getByExamRecordIdAndDone_PrevAndNext(
		Session session, StudentExamLink studentExamLink, long examRecordId,
		boolean done, OrderByComparator<StudentExamLink> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_STUDENTEXAMLINK_WHERE);

		query.append(_FINDER_COLUMN_EXAMRECORDIDANDDONE_EXAMRECORDID_2);

		query.append(_FINDER_COLUMN_EXAMRECORDIDANDDONE_DONE_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(StudentExamLinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(examRecordId);

		qPos.add(done);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(studentExamLink);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StudentExamLink> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the student exam links where examRecordId = &#63; and done = &#63; from the database.
	 *
	 * @param examRecordId the exam record ID
	 * @param done the done
	 */
	@Override
	public void removeByExamRecordIdAndDone(long examRecordId, boolean done) {
		for (StudentExamLink studentExamLink : findByExamRecordIdAndDone(
				examRecordId, done, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(studentExamLink);
		}
	}

	/**
	 * Returns the number of student exam links where examRecordId = &#63; and done = &#63;.
	 *
	 * @param examRecordId the exam record ID
	 * @param done the done
	 * @return the number of matching student exam links
	 */
	@Override
	public int countByExamRecordIdAndDone(long examRecordId, boolean done) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EXAMRECORDIDANDDONE;

		Object[] finderArgs = new Object[] { examRecordId, done };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_STUDENTEXAMLINK_WHERE);

			query.append(_FINDER_COLUMN_EXAMRECORDIDANDDONE_EXAMRECORDID_2);

			query.append(_FINDER_COLUMN_EXAMRECORDIDANDDONE_DONE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(examRecordId);

				qPos.add(done);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_EXAMRECORDIDANDDONE_EXAMRECORDID_2 =
		"studentExamLink.id.examRecordId = ? AND ";
	private static final String _FINDER_COLUMN_EXAMRECORDIDANDDONE_DONE_2 = "studentExamLink.done = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STUDENTID =
		new FinderPath(StudentExamLinkModelImpl.ENTITY_CACHE_ENABLED,
			StudentExamLinkModelImpl.FINDER_CACHE_ENABLED,
			StudentExamLinkImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByStudentId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STUDENTID =
		new FinderPath(StudentExamLinkModelImpl.ENTITY_CACHE_ENABLED,
			StudentExamLinkModelImpl.FINDER_CACHE_ENABLED,
			StudentExamLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStudentId",
			new String[] { Long.class.getName() },
			StudentExamLinkModelImpl.STUDENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STUDENTID = new FinderPath(StudentExamLinkModelImpl.ENTITY_CACHE_ENABLED,
			StudentExamLinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStudentId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the student exam links where studentId = &#63;.
	 *
	 * @param studentId the student ID
	 * @return the matching student exam links
	 */
	@Override
	public List<StudentExamLink> findByStudentId(long studentId) {
		return findByStudentId(studentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

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
	@Override
	public List<StudentExamLink> findByStudentId(long studentId, int start,
		int end) {
		return findByStudentId(studentId, start, end, null);
	}

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
	@Override
	public List<StudentExamLink> findByStudentId(long studentId, int start,
		int end, OrderByComparator<StudentExamLink> orderByComparator) {
		return findByStudentId(studentId, start, end, orderByComparator, true);
	}

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
	@Override
	public List<StudentExamLink> findByStudentId(long studentId, int start,
		int end, OrderByComparator<StudentExamLink> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STUDENTID;
			finderArgs = new Object[] { studentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STUDENTID;
			finderArgs = new Object[] { studentId, start, end, orderByComparator };
		}

		List<StudentExamLink> list = null;

		if (retrieveFromCache) {
			list = (List<StudentExamLink>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (StudentExamLink studentExamLink : list) {
					if ((studentId != studentExamLink.getStudentId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_STUDENTEXAMLINK_WHERE);

			query.append(_FINDER_COLUMN_STUDENTID_STUDENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StudentExamLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(studentId);

				if (!pagination) {
					list = (List<StudentExamLink>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<StudentExamLink>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first student exam link in the ordered set where studentId = &#63;.
	 *
	 * @param studentId the student ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student exam link
	 * @throws NoSuchStudentExamLinkException if a matching student exam link could not be found
	 */
	@Override
	public StudentExamLink findByStudentId_First(long studentId,
		OrderByComparator<StudentExamLink> orderByComparator)
		throws NoSuchStudentExamLinkException {
		StudentExamLink studentExamLink = fetchByStudentId_First(studentId,
				orderByComparator);

		if (studentExamLink != null) {
			return studentExamLink;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("studentId=");
		msg.append(studentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStudentExamLinkException(msg.toString());
	}

	/**
	 * Returns the first student exam link in the ordered set where studentId = &#63;.
	 *
	 * @param studentId the student ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student exam link, or <code>null</code> if a matching student exam link could not be found
	 */
	@Override
	public StudentExamLink fetchByStudentId_First(long studentId,
		OrderByComparator<StudentExamLink> orderByComparator) {
		List<StudentExamLink> list = findByStudentId(studentId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last student exam link in the ordered set where studentId = &#63;.
	 *
	 * @param studentId the student ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student exam link
	 * @throws NoSuchStudentExamLinkException if a matching student exam link could not be found
	 */
	@Override
	public StudentExamLink findByStudentId_Last(long studentId,
		OrderByComparator<StudentExamLink> orderByComparator)
		throws NoSuchStudentExamLinkException {
		StudentExamLink studentExamLink = fetchByStudentId_Last(studentId,
				orderByComparator);

		if (studentExamLink != null) {
			return studentExamLink;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("studentId=");
		msg.append(studentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStudentExamLinkException(msg.toString());
	}

	/**
	 * Returns the last student exam link in the ordered set where studentId = &#63;.
	 *
	 * @param studentId the student ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student exam link, or <code>null</code> if a matching student exam link could not be found
	 */
	@Override
	public StudentExamLink fetchByStudentId_Last(long studentId,
		OrderByComparator<StudentExamLink> orderByComparator) {
		int count = countByStudentId(studentId);

		if (count == 0) {
			return null;
		}

		List<StudentExamLink> list = findByStudentId(studentId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the student exam links before and after the current student exam link in the ordered set where studentId = &#63;.
	 *
	 * @param studentExamLinkPK the primary key of the current student exam link
	 * @param studentId the student ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next student exam link
	 * @throws NoSuchStudentExamLinkException if a student exam link with the primary key could not be found
	 */
	@Override
	public StudentExamLink[] findByStudentId_PrevAndNext(
		StudentExamLinkPK studentExamLinkPK, long studentId,
		OrderByComparator<StudentExamLink> orderByComparator)
		throws NoSuchStudentExamLinkException {
		StudentExamLink studentExamLink = findByPrimaryKey(studentExamLinkPK);

		Session session = null;

		try {
			session = openSession();

			StudentExamLink[] array = new StudentExamLinkImpl[3];

			array[0] = getByStudentId_PrevAndNext(session, studentExamLink,
					studentId, orderByComparator, true);

			array[1] = studentExamLink;

			array[2] = getByStudentId_PrevAndNext(session, studentExamLink,
					studentId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected StudentExamLink getByStudentId_PrevAndNext(Session session,
		StudentExamLink studentExamLink, long studentId,
		OrderByComparator<StudentExamLink> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STUDENTEXAMLINK_WHERE);

		query.append(_FINDER_COLUMN_STUDENTID_STUDENTID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(StudentExamLinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(studentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(studentExamLink);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StudentExamLink> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the student exam links where studentId = &#63; from the database.
	 *
	 * @param studentId the student ID
	 */
	@Override
	public void removeByStudentId(long studentId) {
		for (StudentExamLink studentExamLink : findByStudentId(studentId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(studentExamLink);
		}
	}

	/**
	 * Returns the number of student exam links where studentId = &#63;.
	 *
	 * @param studentId the student ID
	 * @return the number of matching student exam links
	 */
	@Override
	public int countByStudentId(long studentId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STUDENTID;

		Object[] finderArgs = new Object[] { studentId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STUDENTEXAMLINK_WHERE);

			query.append(_FINDER_COLUMN_STUDENTID_STUDENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(studentId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_STUDENTID_STUDENTID_2 = "studentExamLink.id.studentId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STUDENTIDANDSTATUS =
		new FinderPath(StudentExamLinkModelImpl.ENTITY_CACHE_ENABLED,
			StudentExamLinkModelImpl.FINDER_CACHE_ENABLED,
			StudentExamLinkImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByStudentIdAndStatus",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STUDENTIDANDSTATUS =
		new FinderPath(StudentExamLinkModelImpl.ENTITY_CACHE_ENABLED,
			StudentExamLinkModelImpl.FINDER_CACHE_ENABLED,
			StudentExamLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByStudentIdAndStatus",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Boolean.class.getName()
			},
			StudentExamLinkModelImpl.STUDENTID_COLUMN_BITMASK |
			StudentExamLinkModelImpl.INPROGRESS_COLUMN_BITMASK |
			StudentExamLinkModelImpl.DONE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STUDENTIDANDSTATUS = new FinderPath(StudentExamLinkModelImpl.ENTITY_CACHE_ENABLED,
			StudentExamLinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByStudentIdAndStatus",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Boolean.class.getName()
			});

	/**
	 * Returns all the student exam links where studentId = &#63; and inProgress = &#63; and done = &#63;.
	 *
	 * @param studentId the student ID
	 * @param inProgress the in progress
	 * @param done the done
	 * @return the matching student exam links
	 */
	@Override
	public List<StudentExamLink> findByStudentIdAndStatus(long studentId,
		boolean inProgress, boolean done) {
		return findByStudentIdAndStatus(studentId, inProgress, done,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<StudentExamLink> findByStudentIdAndStatus(long studentId,
		boolean inProgress, boolean done, int start, int end) {
		return findByStudentIdAndStatus(studentId, inProgress, done, start,
			end, null);
	}

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
	@Override
	public List<StudentExamLink> findByStudentIdAndStatus(long studentId,
		boolean inProgress, boolean done, int start, int end,
		OrderByComparator<StudentExamLink> orderByComparator) {
		return findByStudentIdAndStatus(studentId, inProgress, done, start,
			end, orderByComparator, true);
	}

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
	@Override
	public List<StudentExamLink> findByStudentIdAndStatus(long studentId,
		boolean inProgress, boolean done, int start, int end,
		OrderByComparator<StudentExamLink> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STUDENTIDANDSTATUS;
			finderArgs = new Object[] { studentId, inProgress, done };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STUDENTIDANDSTATUS;
			finderArgs = new Object[] {
					studentId, inProgress, done,
					
					start, end, orderByComparator
				};
		}

		List<StudentExamLink> list = null;

		if (retrieveFromCache) {
			list = (List<StudentExamLink>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (StudentExamLink studentExamLink : list) {
					if ((studentId != studentExamLink.getStudentId()) ||
							(inProgress != studentExamLink.getInProgress()) ||
							(done != studentExamLink.getDone())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_STUDENTEXAMLINK_WHERE);

			query.append(_FINDER_COLUMN_STUDENTIDANDSTATUS_STUDENTID_2);

			query.append(_FINDER_COLUMN_STUDENTIDANDSTATUS_INPROGRESS_2);

			query.append(_FINDER_COLUMN_STUDENTIDANDSTATUS_DONE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StudentExamLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(studentId);

				qPos.add(inProgress);

				qPos.add(done);

				if (!pagination) {
					list = (List<StudentExamLink>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<StudentExamLink>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

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
	@Override
	public StudentExamLink findByStudentIdAndStatus_First(long studentId,
		boolean inProgress, boolean done,
		OrderByComparator<StudentExamLink> orderByComparator)
		throws NoSuchStudentExamLinkException {
		StudentExamLink studentExamLink = fetchByStudentIdAndStatus_First(studentId,
				inProgress, done, orderByComparator);

		if (studentExamLink != null) {
			return studentExamLink;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("studentId=");
		msg.append(studentId);

		msg.append(", inProgress=");
		msg.append(inProgress);

		msg.append(", done=");
		msg.append(done);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStudentExamLinkException(msg.toString());
	}

	/**
	 * Returns the first student exam link in the ordered set where studentId = &#63; and inProgress = &#63; and done = &#63;.
	 *
	 * @param studentId the student ID
	 * @param inProgress the in progress
	 * @param done the done
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student exam link, or <code>null</code> if a matching student exam link could not be found
	 */
	@Override
	public StudentExamLink fetchByStudentIdAndStatus_First(long studentId,
		boolean inProgress, boolean done,
		OrderByComparator<StudentExamLink> orderByComparator) {
		List<StudentExamLink> list = findByStudentIdAndStatus(studentId,
				inProgress, done, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public StudentExamLink findByStudentIdAndStatus_Last(long studentId,
		boolean inProgress, boolean done,
		OrderByComparator<StudentExamLink> orderByComparator)
		throws NoSuchStudentExamLinkException {
		StudentExamLink studentExamLink = fetchByStudentIdAndStatus_Last(studentId,
				inProgress, done, orderByComparator);

		if (studentExamLink != null) {
			return studentExamLink;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("studentId=");
		msg.append(studentId);

		msg.append(", inProgress=");
		msg.append(inProgress);

		msg.append(", done=");
		msg.append(done);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStudentExamLinkException(msg.toString());
	}

	/**
	 * Returns the last student exam link in the ordered set where studentId = &#63; and inProgress = &#63; and done = &#63;.
	 *
	 * @param studentId the student ID
	 * @param inProgress the in progress
	 * @param done the done
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student exam link, or <code>null</code> if a matching student exam link could not be found
	 */
	@Override
	public StudentExamLink fetchByStudentIdAndStatus_Last(long studentId,
		boolean inProgress, boolean done,
		OrderByComparator<StudentExamLink> orderByComparator) {
		int count = countByStudentIdAndStatus(studentId, inProgress, done);

		if (count == 0) {
			return null;
		}

		List<StudentExamLink> list = findByStudentIdAndStatus(studentId,
				inProgress, done, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public StudentExamLink[] findByStudentIdAndStatus_PrevAndNext(
		StudentExamLinkPK studentExamLinkPK, long studentId,
		boolean inProgress, boolean done,
		OrderByComparator<StudentExamLink> orderByComparator)
		throws NoSuchStudentExamLinkException {
		StudentExamLink studentExamLink = findByPrimaryKey(studentExamLinkPK);

		Session session = null;

		try {
			session = openSession();

			StudentExamLink[] array = new StudentExamLinkImpl[3];

			array[0] = getByStudentIdAndStatus_PrevAndNext(session,
					studentExamLink, studentId, inProgress, done,
					orderByComparator, true);

			array[1] = studentExamLink;

			array[2] = getByStudentIdAndStatus_PrevAndNext(session,
					studentExamLink, studentId, inProgress, done,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected StudentExamLink getByStudentIdAndStatus_PrevAndNext(
		Session session, StudentExamLink studentExamLink, long studentId,
		boolean inProgress, boolean done,
		OrderByComparator<StudentExamLink> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_STUDENTEXAMLINK_WHERE);

		query.append(_FINDER_COLUMN_STUDENTIDANDSTATUS_STUDENTID_2);

		query.append(_FINDER_COLUMN_STUDENTIDANDSTATUS_INPROGRESS_2);

		query.append(_FINDER_COLUMN_STUDENTIDANDSTATUS_DONE_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(StudentExamLinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(studentId);

		qPos.add(inProgress);

		qPos.add(done);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(studentExamLink);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StudentExamLink> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the student exam links where studentId = &#63; and inProgress = &#63; and done = &#63; from the database.
	 *
	 * @param studentId the student ID
	 * @param inProgress the in progress
	 * @param done the done
	 */
	@Override
	public void removeByStudentIdAndStatus(long studentId, boolean inProgress,
		boolean done) {
		for (StudentExamLink studentExamLink : findByStudentIdAndStatus(
				studentId, inProgress, done, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(studentExamLink);
		}
	}

	/**
	 * Returns the number of student exam links where studentId = &#63; and inProgress = &#63; and done = &#63;.
	 *
	 * @param studentId the student ID
	 * @param inProgress the in progress
	 * @param done the done
	 * @return the number of matching student exam links
	 */
	@Override
	public int countByStudentIdAndStatus(long studentId, boolean inProgress,
		boolean done) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STUDENTIDANDSTATUS;

		Object[] finderArgs = new Object[] { studentId, inProgress, done };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_STUDENTEXAMLINK_WHERE);

			query.append(_FINDER_COLUMN_STUDENTIDANDSTATUS_STUDENTID_2);

			query.append(_FINDER_COLUMN_STUDENTIDANDSTATUS_INPROGRESS_2);

			query.append(_FINDER_COLUMN_STUDENTIDANDSTATUS_DONE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(studentId);

				qPos.add(inProgress);

				qPos.add(done);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_STUDENTIDANDSTATUS_STUDENTID_2 = "studentExamLink.id.studentId = ? AND ";
	private static final String _FINDER_COLUMN_STUDENTIDANDSTATUS_INPROGRESS_2 = "studentExamLink.inProgress = ? AND ";
	private static final String _FINDER_COLUMN_STUDENTIDANDSTATUS_DONE_2 = "studentExamLink.done = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EXAMRECORDIDANDSTUDENTID =
		new FinderPath(StudentExamLinkModelImpl.ENTITY_CACHE_ENABLED,
			StudentExamLinkModelImpl.FINDER_CACHE_ENABLED,
			StudentExamLinkImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByExamRecordIdAndStudentId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EXAMRECORDIDANDSTUDENTID =
		new FinderPath(StudentExamLinkModelImpl.ENTITY_CACHE_ENABLED,
			StudentExamLinkModelImpl.FINDER_CACHE_ENABLED,
			StudentExamLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByExamRecordIdAndStudentId",
			new String[] { Long.class.getName(), Long.class.getName() },
			StudentExamLinkModelImpl.EXAMRECORDID_COLUMN_BITMASK |
			StudentExamLinkModelImpl.STUDENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EXAMRECORDIDANDSTUDENTID =
		new FinderPath(StudentExamLinkModelImpl.ENTITY_CACHE_ENABLED,
			StudentExamLinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByExamRecordIdAndStudentId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the student exam links where examRecordId = &#63; and studentId = &#63;.
	 *
	 * @param examRecordId the exam record ID
	 * @param studentId the student ID
	 * @return the matching student exam links
	 */
	@Override
	public List<StudentExamLink> findByExamRecordIdAndStudentId(
		long examRecordId, long studentId) {
		return findByExamRecordIdAndStudentId(examRecordId, studentId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<StudentExamLink> findByExamRecordIdAndStudentId(
		long examRecordId, long studentId, int start, int end) {
		return findByExamRecordIdAndStudentId(examRecordId, studentId, start,
			end, null);
	}

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
	@Override
	public List<StudentExamLink> findByExamRecordIdAndStudentId(
		long examRecordId, long studentId, int start, int end,
		OrderByComparator<StudentExamLink> orderByComparator) {
		return findByExamRecordIdAndStudentId(examRecordId, studentId, start,
			end, orderByComparator, true);
	}

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
	@Override
	public List<StudentExamLink> findByExamRecordIdAndStudentId(
		long examRecordId, long studentId, int start, int end,
		OrderByComparator<StudentExamLink> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EXAMRECORDIDANDSTUDENTID;
			finderArgs = new Object[] { examRecordId, studentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EXAMRECORDIDANDSTUDENTID;
			finderArgs = new Object[] {
					examRecordId, studentId,
					
					start, end, orderByComparator
				};
		}

		List<StudentExamLink> list = null;

		if (retrieveFromCache) {
			list = (List<StudentExamLink>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (StudentExamLink studentExamLink : list) {
					if ((examRecordId != studentExamLink.getExamRecordId()) ||
							(studentId != studentExamLink.getStudentId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_STUDENTEXAMLINK_WHERE);

			query.append(_FINDER_COLUMN_EXAMRECORDIDANDSTUDENTID_EXAMRECORDID_2);

			query.append(_FINDER_COLUMN_EXAMRECORDIDANDSTUDENTID_STUDENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StudentExamLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(examRecordId);

				qPos.add(studentId);

				if (!pagination) {
					list = (List<StudentExamLink>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<StudentExamLink>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first student exam link in the ordered set where examRecordId = &#63; and studentId = &#63;.
	 *
	 * @param examRecordId the exam record ID
	 * @param studentId the student ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student exam link
	 * @throws NoSuchStudentExamLinkException if a matching student exam link could not be found
	 */
	@Override
	public StudentExamLink findByExamRecordIdAndStudentId_First(
		long examRecordId, long studentId,
		OrderByComparator<StudentExamLink> orderByComparator)
		throws NoSuchStudentExamLinkException {
		StudentExamLink studentExamLink = fetchByExamRecordIdAndStudentId_First(examRecordId,
				studentId, orderByComparator);

		if (studentExamLink != null) {
			return studentExamLink;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("examRecordId=");
		msg.append(examRecordId);

		msg.append(", studentId=");
		msg.append(studentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStudentExamLinkException(msg.toString());
	}

	/**
	 * Returns the first student exam link in the ordered set where examRecordId = &#63; and studentId = &#63;.
	 *
	 * @param examRecordId the exam record ID
	 * @param studentId the student ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student exam link, or <code>null</code> if a matching student exam link could not be found
	 */
	@Override
	public StudentExamLink fetchByExamRecordIdAndStudentId_First(
		long examRecordId, long studentId,
		OrderByComparator<StudentExamLink> orderByComparator) {
		List<StudentExamLink> list = findByExamRecordIdAndStudentId(examRecordId,
				studentId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last student exam link in the ordered set where examRecordId = &#63; and studentId = &#63;.
	 *
	 * @param examRecordId the exam record ID
	 * @param studentId the student ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student exam link
	 * @throws NoSuchStudentExamLinkException if a matching student exam link could not be found
	 */
	@Override
	public StudentExamLink findByExamRecordIdAndStudentId_Last(
		long examRecordId, long studentId,
		OrderByComparator<StudentExamLink> orderByComparator)
		throws NoSuchStudentExamLinkException {
		StudentExamLink studentExamLink = fetchByExamRecordIdAndStudentId_Last(examRecordId,
				studentId, orderByComparator);

		if (studentExamLink != null) {
			return studentExamLink;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("examRecordId=");
		msg.append(examRecordId);

		msg.append(", studentId=");
		msg.append(studentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStudentExamLinkException(msg.toString());
	}

	/**
	 * Returns the last student exam link in the ordered set where examRecordId = &#63; and studentId = &#63;.
	 *
	 * @param examRecordId the exam record ID
	 * @param studentId the student ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student exam link, or <code>null</code> if a matching student exam link could not be found
	 */
	@Override
	public StudentExamLink fetchByExamRecordIdAndStudentId_Last(
		long examRecordId, long studentId,
		OrderByComparator<StudentExamLink> orderByComparator) {
		int count = countByExamRecordIdAndStudentId(examRecordId, studentId);

		if (count == 0) {
			return null;
		}

		List<StudentExamLink> list = findByExamRecordIdAndStudentId(examRecordId,
				studentId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public StudentExamLink[] findByExamRecordIdAndStudentId_PrevAndNext(
		StudentExamLinkPK studentExamLinkPK, long examRecordId, long studentId,
		OrderByComparator<StudentExamLink> orderByComparator)
		throws NoSuchStudentExamLinkException {
		StudentExamLink studentExamLink = findByPrimaryKey(studentExamLinkPK);

		Session session = null;

		try {
			session = openSession();

			StudentExamLink[] array = new StudentExamLinkImpl[3];

			array[0] = getByExamRecordIdAndStudentId_PrevAndNext(session,
					studentExamLink, examRecordId, studentId,
					orderByComparator, true);

			array[1] = studentExamLink;

			array[2] = getByExamRecordIdAndStudentId_PrevAndNext(session,
					studentExamLink, examRecordId, studentId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected StudentExamLink getByExamRecordIdAndStudentId_PrevAndNext(
		Session session, StudentExamLink studentExamLink, long examRecordId,
		long studentId, OrderByComparator<StudentExamLink> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_STUDENTEXAMLINK_WHERE);

		query.append(_FINDER_COLUMN_EXAMRECORDIDANDSTUDENTID_EXAMRECORDID_2);

		query.append(_FINDER_COLUMN_EXAMRECORDIDANDSTUDENTID_STUDENTID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(StudentExamLinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(examRecordId);

		qPos.add(studentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(studentExamLink);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StudentExamLink> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the student exam links where examRecordId = &#63; and studentId = &#63; from the database.
	 *
	 * @param examRecordId the exam record ID
	 * @param studentId the student ID
	 */
	@Override
	public void removeByExamRecordIdAndStudentId(long examRecordId,
		long studentId) {
		for (StudentExamLink studentExamLink : findByExamRecordIdAndStudentId(
				examRecordId, studentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(studentExamLink);
		}
	}

	/**
	 * Returns the number of student exam links where examRecordId = &#63; and studentId = &#63;.
	 *
	 * @param examRecordId the exam record ID
	 * @param studentId the student ID
	 * @return the number of matching student exam links
	 */
	@Override
	public int countByExamRecordIdAndStudentId(long examRecordId, long studentId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EXAMRECORDIDANDSTUDENTID;

		Object[] finderArgs = new Object[] { examRecordId, studentId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_STUDENTEXAMLINK_WHERE);

			query.append(_FINDER_COLUMN_EXAMRECORDIDANDSTUDENTID_EXAMRECORDID_2);

			query.append(_FINDER_COLUMN_EXAMRECORDIDANDSTUDENTID_STUDENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(examRecordId);

				qPos.add(studentId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_EXAMRECORDIDANDSTUDENTID_EXAMRECORDID_2 =
		"studentExamLink.id.examRecordId = ? AND ";
	private static final String _FINDER_COLUMN_EXAMRECORDIDANDSTUDENTID_STUDENTID_2 =
		"studentExamLink.id.studentId = ?";

	public StudentExamLinkPersistenceImpl() {
		setModelClass(StudentExamLink.class);
	}

	/**
	 * Caches the student exam link in the entity cache if it is enabled.
	 *
	 * @param studentExamLink the student exam link
	 */
	@Override
	public void cacheResult(StudentExamLink studentExamLink) {
		entityCache.putResult(StudentExamLinkModelImpl.ENTITY_CACHE_ENABLED,
			StudentExamLinkImpl.class, studentExamLink.getPrimaryKey(),
			studentExamLink);

		studentExamLink.resetOriginalValues();
	}

	/**
	 * Caches the student exam links in the entity cache if it is enabled.
	 *
	 * @param studentExamLinks the student exam links
	 */
	@Override
	public void cacheResult(List<StudentExamLink> studentExamLinks) {
		for (StudentExamLink studentExamLink : studentExamLinks) {
			if (entityCache.getResult(
						StudentExamLinkModelImpl.ENTITY_CACHE_ENABLED,
						StudentExamLinkImpl.class,
						studentExamLink.getPrimaryKey()) == null) {
				cacheResult(studentExamLink);
			}
			else {
				studentExamLink.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all student exam links.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(StudentExamLinkImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the student exam link.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StudentExamLink studentExamLink) {
		entityCache.removeResult(StudentExamLinkModelImpl.ENTITY_CACHE_ENABLED,
			StudentExamLinkImpl.class, studentExamLink.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<StudentExamLink> studentExamLinks) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StudentExamLink studentExamLink : studentExamLinks) {
			entityCache.removeResult(StudentExamLinkModelImpl.ENTITY_CACHE_ENABLED,
				StudentExamLinkImpl.class, studentExamLink.getPrimaryKey());
		}
	}

	/**
	 * Creates a new student exam link with the primary key. Does not add the student exam link to the database.
	 *
	 * @param studentExamLinkPK the primary key for the new student exam link
	 * @return the new student exam link
	 */
	@Override
	public StudentExamLink create(StudentExamLinkPK studentExamLinkPK) {
		StudentExamLink studentExamLink = new StudentExamLinkImpl();

		studentExamLink.setNew(true);
		studentExamLink.setPrimaryKey(studentExamLinkPK);

		return studentExamLink;
	}

	/**
	 * Removes the student exam link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param studentExamLinkPK the primary key of the student exam link
	 * @return the student exam link that was removed
	 * @throws NoSuchStudentExamLinkException if a student exam link with the primary key could not be found
	 */
	@Override
	public StudentExamLink remove(StudentExamLinkPK studentExamLinkPK)
		throws NoSuchStudentExamLinkException {
		return remove((Serializable)studentExamLinkPK);
	}

	/**
	 * Removes the student exam link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the student exam link
	 * @return the student exam link that was removed
	 * @throws NoSuchStudentExamLinkException if a student exam link with the primary key could not be found
	 */
	@Override
	public StudentExamLink remove(Serializable primaryKey)
		throws NoSuchStudentExamLinkException {
		Session session = null;

		try {
			session = openSession();

			StudentExamLink studentExamLink = (StudentExamLink)session.get(StudentExamLinkImpl.class,
					primaryKey);

			if (studentExamLink == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStudentExamLinkException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(studentExamLink);
		}
		catch (NoSuchStudentExamLinkException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected StudentExamLink removeImpl(StudentExamLink studentExamLink) {
		studentExamLink = toUnwrappedModel(studentExamLink);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(studentExamLink)) {
				studentExamLink = (StudentExamLink)session.get(StudentExamLinkImpl.class,
						studentExamLink.getPrimaryKeyObj());
			}

			if (studentExamLink != null) {
				session.delete(studentExamLink);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (studentExamLink != null) {
			clearCache(studentExamLink);
		}

		return studentExamLink;
	}

	@Override
	public StudentExamLink updateImpl(StudentExamLink studentExamLink) {
		studentExamLink = toUnwrappedModel(studentExamLink);

		boolean isNew = studentExamLink.isNew();

		StudentExamLinkModelImpl studentExamLinkModelImpl = (StudentExamLinkModelImpl)studentExamLink;

		Session session = null;

		try {
			session = openSession();

			if (studentExamLink.isNew()) {
				session.save(studentExamLink);

				studentExamLink.setNew(false);
			}
			else {
				studentExamLink = (StudentExamLink)session.merge(studentExamLink);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !StudentExamLinkModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((studentExamLinkModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EXAMRECORDID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						studentExamLinkModelImpl.getOriginalExamRecordId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EXAMRECORDID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EXAMRECORDID,
					args);

				args = new Object[] { studentExamLinkModelImpl.getExamRecordId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EXAMRECORDID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EXAMRECORDID,
					args);
			}

			if ((studentExamLinkModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EXAMRECORDIDANDDONE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						studentExamLinkModelImpl.getOriginalExamRecordId(),
						studentExamLinkModelImpl.getOriginalDone()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EXAMRECORDIDANDDONE,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EXAMRECORDIDANDDONE,
					args);

				args = new Object[] {
						studentExamLinkModelImpl.getExamRecordId(),
						studentExamLinkModelImpl.getDone()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EXAMRECORDIDANDDONE,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EXAMRECORDIDANDDONE,
					args);
			}

			if ((studentExamLinkModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STUDENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						studentExamLinkModelImpl.getOriginalStudentId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_STUDENTID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STUDENTID,
					args);

				args = new Object[] { studentExamLinkModelImpl.getStudentId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_STUDENTID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STUDENTID,
					args);
			}

			if ((studentExamLinkModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STUDENTIDANDSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						studentExamLinkModelImpl.getOriginalStudentId(),
						studentExamLinkModelImpl.getOriginalInProgress(),
						studentExamLinkModelImpl.getOriginalDone()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_STUDENTIDANDSTATUS,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STUDENTIDANDSTATUS,
					args);

				args = new Object[] {
						studentExamLinkModelImpl.getStudentId(),
						studentExamLinkModelImpl.getInProgress(),
						studentExamLinkModelImpl.getDone()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_STUDENTIDANDSTATUS,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STUDENTIDANDSTATUS,
					args);
			}

			if ((studentExamLinkModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EXAMRECORDIDANDSTUDENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						studentExamLinkModelImpl.getOriginalExamRecordId(),
						studentExamLinkModelImpl.getOriginalStudentId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EXAMRECORDIDANDSTUDENTID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EXAMRECORDIDANDSTUDENTID,
					args);

				args = new Object[] {
						studentExamLinkModelImpl.getExamRecordId(),
						studentExamLinkModelImpl.getStudentId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EXAMRECORDIDANDSTUDENTID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EXAMRECORDIDANDSTUDENTID,
					args);
			}
		}

		entityCache.putResult(StudentExamLinkModelImpl.ENTITY_CACHE_ENABLED,
			StudentExamLinkImpl.class, studentExamLink.getPrimaryKey(),
			studentExamLink, false);

		studentExamLink.resetOriginalValues();

		return studentExamLink;
	}

	protected StudentExamLink toUnwrappedModel(StudentExamLink studentExamLink) {
		if (studentExamLink instanceof StudentExamLinkImpl) {
			return studentExamLink;
		}

		StudentExamLinkImpl studentExamLinkImpl = new StudentExamLinkImpl();

		studentExamLinkImpl.setNew(studentExamLink.isNew());
		studentExamLinkImpl.setPrimaryKey(studentExamLink.getPrimaryKey());

		studentExamLinkImpl.setExamRecordId(studentExamLink.getExamRecordId());
		studentExamLinkImpl.setStudentId(studentExamLink.getStudentId());
		studentExamLinkImpl.setInProgress(studentExamLink.isInProgress());
		studentExamLinkImpl.setDone(studentExamLink.isDone());

		return studentExamLinkImpl;
	}

	/**
	 * Returns the student exam link with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the student exam link
	 * @return the student exam link
	 * @throws NoSuchStudentExamLinkException if a student exam link with the primary key could not be found
	 */
	@Override
	public StudentExamLink findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStudentExamLinkException {
		StudentExamLink studentExamLink = fetchByPrimaryKey(primaryKey);

		if (studentExamLink == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStudentExamLinkException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return studentExamLink;
	}

	/**
	 * Returns the student exam link with the primary key or throws a {@link NoSuchStudentExamLinkException} if it could not be found.
	 *
	 * @param studentExamLinkPK the primary key of the student exam link
	 * @return the student exam link
	 * @throws NoSuchStudentExamLinkException if a student exam link with the primary key could not be found
	 */
	@Override
	public StudentExamLink findByPrimaryKey(StudentExamLinkPK studentExamLinkPK)
		throws NoSuchStudentExamLinkException {
		return findByPrimaryKey((Serializable)studentExamLinkPK);
	}

	/**
	 * Returns the student exam link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the student exam link
	 * @return the student exam link, or <code>null</code> if a student exam link with the primary key could not be found
	 */
	@Override
	public StudentExamLink fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(StudentExamLinkModelImpl.ENTITY_CACHE_ENABLED,
				StudentExamLinkImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		StudentExamLink studentExamLink = (StudentExamLink)serializable;

		if (studentExamLink == null) {
			Session session = null;

			try {
				session = openSession();

				studentExamLink = (StudentExamLink)session.get(StudentExamLinkImpl.class,
						primaryKey);

				if (studentExamLink != null) {
					cacheResult(studentExamLink);
				}
				else {
					entityCache.putResult(StudentExamLinkModelImpl.ENTITY_CACHE_ENABLED,
						StudentExamLinkImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(StudentExamLinkModelImpl.ENTITY_CACHE_ENABLED,
					StudentExamLinkImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return studentExamLink;
	}

	/**
	 * Returns the student exam link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param studentExamLinkPK the primary key of the student exam link
	 * @return the student exam link, or <code>null</code> if a student exam link with the primary key could not be found
	 */
	@Override
	public StudentExamLink fetchByPrimaryKey(
		StudentExamLinkPK studentExamLinkPK) {
		return fetchByPrimaryKey((Serializable)studentExamLinkPK);
	}

	@Override
	public Map<Serializable, StudentExamLink> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, StudentExamLink> map = new HashMap<Serializable, StudentExamLink>();

		for (Serializable primaryKey : primaryKeys) {
			StudentExamLink studentExamLink = fetchByPrimaryKey(primaryKey);

			if (studentExamLink != null) {
				map.put(primaryKey, studentExamLink);
			}
		}

		return map;
	}

	/**
	 * Returns all the student exam links.
	 *
	 * @return the student exam links
	 */
	@Override
	public List<StudentExamLink> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<StudentExamLink> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<StudentExamLink> findAll(int start, int end,
		OrderByComparator<StudentExamLink> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<StudentExamLink> findAll(int start, int end,
		OrderByComparator<StudentExamLink> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<StudentExamLink> list = null;

		if (retrieveFromCache) {
			list = (List<StudentExamLink>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_STUDENTEXAMLINK);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STUDENTEXAMLINK;

				if (pagination) {
					sql = sql.concat(StudentExamLinkModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<StudentExamLink>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<StudentExamLink>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the student exam links from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (StudentExamLink studentExamLink : findAll()) {
			remove(studentExamLink);
		}
	}

	/**
	 * Returns the number of student exam links.
	 *
	 * @return the number of student exam links
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_STUDENTEXAMLINK);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return StudentExamLinkModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the student exam link persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(StudentExamLinkImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_STUDENTEXAMLINK = "SELECT studentExamLink FROM StudentExamLink studentExamLink";
	private static final String _SQL_SELECT_STUDENTEXAMLINK_WHERE = "SELECT studentExamLink FROM StudentExamLink studentExamLink WHERE ";
	private static final String _SQL_COUNT_STUDENTEXAMLINK = "SELECT COUNT(studentExamLink) FROM StudentExamLink studentExamLink";
	private static final String _SQL_COUNT_STUDENTEXAMLINK_WHERE = "SELECT COUNT(studentExamLink) FROM StudentExamLink studentExamLink WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "studentExamLink.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No StudentExamLink exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No StudentExamLink exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(StudentExamLinkPersistenceImpl.class);
}