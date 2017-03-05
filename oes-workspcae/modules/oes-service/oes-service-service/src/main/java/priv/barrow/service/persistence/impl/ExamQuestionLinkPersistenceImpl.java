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

import priv.barrow.exception.NoSuchExamQuestionLinkException;

import priv.barrow.model.ExamQuestionLink;
import priv.barrow.model.impl.ExamQuestionLinkImpl;
import priv.barrow.model.impl.ExamQuestionLinkModelImpl;

import priv.barrow.service.persistence.ExamQuestionLinkPK;
import priv.barrow.service.persistence.ExamQuestionLinkPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the exam question link service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ExamQuestionLinkPersistence
 * @see priv.barrow.service.persistence.ExamQuestionLinkUtil
 * @generated
 */
@ProviderType
public class ExamQuestionLinkPersistenceImpl extends BasePersistenceImpl<ExamQuestionLink>
	implements ExamQuestionLinkPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ExamQuestionLinkUtil} to access the exam question link persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ExamQuestionLinkImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ExamQuestionLinkModelImpl.ENTITY_CACHE_ENABLED,
			ExamQuestionLinkModelImpl.FINDER_CACHE_ENABLED,
			ExamQuestionLinkImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ExamQuestionLinkModelImpl.ENTITY_CACHE_ENABLED,
			ExamQuestionLinkModelImpl.FINDER_CACHE_ENABLED,
			ExamQuestionLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ExamQuestionLinkModelImpl.ENTITY_CACHE_ENABLED,
			ExamQuestionLinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EXAMRECORDID =
		new FinderPath(ExamQuestionLinkModelImpl.ENTITY_CACHE_ENABLED,
			ExamQuestionLinkModelImpl.FINDER_CACHE_ENABLED,
			ExamQuestionLinkImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByexamRecordId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EXAMRECORDID =
		new FinderPath(ExamQuestionLinkModelImpl.ENTITY_CACHE_ENABLED,
			ExamQuestionLinkModelImpl.FINDER_CACHE_ENABLED,
			ExamQuestionLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByexamRecordId",
			new String[] { Long.class.getName() },
			ExamQuestionLinkModelImpl.EXAMRECORDID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EXAMRECORDID = new FinderPath(ExamQuestionLinkModelImpl.ENTITY_CACHE_ENABLED,
			ExamQuestionLinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByexamRecordId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the exam question links where examRecordId = &#63;.
	 *
	 * @param examRecordId the exam record ID
	 * @return the matching exam question links
	 */
	@Override
	public List<ExamQuestionLink> findByexamRecordId(long examRecordId) {
		return findByexamRecordId(examRecordId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<ExamQuestionLink> findByexamRecordId(long examRecordId,
		int start, int end) {
		return findByexamRecordId(examRecordId, start, end, null);
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
	@Override
	public List<ExamQuestionLink> findByexamRecordId(long examRecordId,
		int start, int end,
		OrderByComparator<ExamQuestionLink> orderByComparator) {
		return findByexamRecordId(examRecordId, start, end, orderByComparator,
			true);
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
	@Override
	public List<ExamQuestionLink> findByexamRecordId(long examRecordId,
		int start, int end,
		OrderByComparator<ExamQuestionLink> orderByComparator,
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

		List<ExamQuestionLink> list = null;

		if (retrieveFromCache) {
			list = (List<ExamQuestionLink>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ExamQuestionLink examQuestionLink : list) {
					if ((examRecordId != examQuestionLink.getExamRecordId())) {
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

			query.append(_SQL_SELECT_EXAMQUESTIONLINK_WHERE);

			query.append(_FINDER_COLUMN_EXAMRECORDID_EXAMRECORDID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ExamQuestionLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(examRecordId);

				if (!pagination) {
					list = (List<ExamQuestionLink>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ExamQuestionLink>)QueryUtil.list(q,
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
	 * Returns the first exam question link in the ordered set where examRecordId = &#63;.
	 *
	 * @param examRecordId the exam record ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching exam question link
	 * @throws NoSuchExamQuestionLinkException if a matching exam question link could not be found
	 */
	@Override
	public ExamQuestionLink findByexamRecordId_First(long examRecordId,
		OrderByComparator<ExamQuestionLink> orderByComparator)
		throws NoSuchExamQuestionLinkException {
		ExamQuestionLink examQuestionLink = fetchByexamRecordId_First(examRecordId,
				orderByComparator);

		if (examQuestionLink != null) {
			return examQuestionLink;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("examRecordId=");
		msg.append(examRecordId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchExamQuestionLinkException(msg.toString());
	}

	/**
	 * Returns the first exam question link in the ordered set where examRecordId = &#63;.
	 *
	 * @param examRecordId the exam record ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching exam question link, or <code>null</code> if a matching exam question link could not be found
	 */
	@Override
	public ExamQuestionLink fetchByexamRecordId_First(long examRecordId,
		OrderByComparator<ExamQuestionLink> orderByComparator) {
		List<ExamQuestionLink> list = findByexamRecordId(examRecordId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last exam question link in the ordered set where examRecordId = &#63;.
	 *
	 * @param examRecordId the exam record ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching exam question link
	 * @throws NoSuchExamQuestionLinkException if a matching exam question link could not be found
	 */
	@Override
	public ExamQuestionLink findByexamRecordId_Last(long examRecordId,
		OrderByComparator<ExamQuestionLink> orderByComparator)
		throws NoSuchExamQuestionLinkException {
		ExamQuestionLink examQuestionLink = fetchByexamRecordId_Last(examRecordId,
				orderByComparator);

		if (examQuestionLink != null) {
			return examQuestionLink;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("examRecordId=");
		msg.append(examRecordId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchExamQuestionLinkException(msg.toString());
	}

	/**
	 * Returns the last exam question link in the ordered set where examRecordId = &#63;.
	 *
	 * @param examRecordId the exam record ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching exam question link, or <code>null</code> if a matching exam question link could not be found
	 */
	@Override
	public ExamQuestionLink fetchByexamRecordId_Last(long examRecordId,
		OrderByComparator<ExamQuestionLink> orderByComparator) {
		int count = countByexamRecordId(examRecordId);

		if (count == 0) {
			return null;
		}

		List<ExamQuestionLink> list = findByexamRecordId(examRecordId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ExamQuestionLink[] findByexamRecordId_PrevAndNext(
		ExamQuestionLinkPK examQuestionLinkPK, long examRecordId,
		OrderByComparator<ExamQuestionLink> orderByComparator)
		throws NoSuchExamQuestionLinkException {
		ExamQuestionLink examQuestionLink = findByPrimaryKey(examQuestionLinkPK);

		Session session = null;

		try {
			session = openSession();

			ExamQuestionLink[] array = new ExamQuestionLinkImpl[3];

			array[0] = getByexamRecordId_PrevAndNext(session, examQuestionLink,
					examRecordId, orderByComparator, true);

			array[1] = examQuestionLink;

			array[2] = getByexamRecordId_PrevAndNext(session, examQuestionLink,
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

	protected ExamQuestionLink getByexamRecordId_PrevAndNext(Session session,
		ExamQuestionLink examQuestionLink, long examRecordId,
		OrderByComparator<ExamQuestionLink> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EXAMQUESTIONLINK_WHERE);

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
			query.append(ExamQuestionLinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(examRecordId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(examQuestionLink);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ExamQuestionLink> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the exam question links where examRecordId = &#63; from the database.
	 *
	 * @param examRecordId the exam record ID
	 */
	@Override
	public void removeByexamRecordId(long examRecordId) {
		for (ExamQuestionLink examQuestionLink : findByexamRecordId(
				examRecordId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(examQuestionLink);
		}
	}

	/**
	 * Returns the number of exam question links where examRecordId = &#63;.
	 *
	 * @param examRecordId the exam record ID
	 * @return the number of matching exam question links
	 */
	@Override
	public int countByexamRecordId(long examRecordId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EXAMRECORDID;

		Object[] finderArgs = new Object[] { examRecordId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EXAMQUESTIONLINK_WHERE);

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

	private static final String _FINDER_COLUMN_EXAMRECORDID_EXAMRECORDID_2 = "examQuestionLink.id.examRecordId = ?";

	public ExamQuestionLinkPersistenceImpl() {
		setModelClass(ExamQuestionLink.class);
	}

	/**
	 * Caches the exam question link in the entity cache if it is enabled.
	 *
	 * @param examQuestionLink the exam question link
	 */
	@Override
	public void cacheResult(ExamQuestionLink examQuestionLink) {
		entityCache.putResult(ExamQuestionLinkModelImpl.ENTITY_CACHE_ENABLED,
			ExamQuestionLinkImpl.class, examQuestionLink.getPrimaryKey(),
			examQuestionLink);

		examQuestionLink.resetOriginalValues();
	}

	/**
	 * Caches the exam question links in the entity cache if it is enabled.
	 *
	 * @param examQuestionLinks the exam question links
	 */
	@Override
	public void cacheResult(List<ExamQuestionLink> examQuestionLinks) {
		for (ExamQuestionLink examQuestionLink : examQuestionLinks) {
			if (entityCache.getResult(
						ExamQuestionLinkModelImpl.ENTITY_CACHE_ENABLED,
						ExamQuestionLinkImpl.class,
						examQuestionLink.getPrimaryKey()) == null) {
				cacheResult(examQuestionLink);
			}
			else {
				examQuestionLink.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all exam question links.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ExamQuestionLinkImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the exam question link.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ExamQuestionLink examQuestionLink) {
		entityCache.removeResult(ExamQuestionLinkModelImpl.ENTITY_CACHE_ENABLED,
			ExamQuestionLinkImpl.class, examQuestionLink.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ExamQuestionLink> examQuestionLinks) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ExamQuestionLink examQuestionLink : examQuestionLinks) {
			entityCache.removeResult(ExamQuestionLinkModelImpl.ENTITY_CACHE_ENABLED,
				ExamQuestionLinkImpl.class, examQuestionLink.getPrimaryKey());
		}
	}

	/**
	 * Creates a new exam question link with the primary key. Does not add the exam question link to the database.
	 *
	 * @param examQuestionLinkPK the primary key for the new exam question link
	 * @return the new exam question link
	 */
	@Override
	public ExamQuestionLink create(ExamQuestionLinkPK examQuestionLinkPK) {
		ExamQuestionLink examQuestionLink = new ExamQuestionLinkImpl();

		examQuestionLink.setNew(true);
		examQuestionLink.setPrimaryKey(examQuestionLinkPK);

		return examQuestionLink;
	}

	/**
	 * Removes the exam question link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param examQuestionLinkPK the primary key of the exam question link
	 * @return the exam question link that was removed
	 * @throws NoSuchExamQuestionLinkException if a exam question link with the primary key could not be found
	 */
	@Override
	public ExamQuestionLink remove(ExamQuestionLinkPK examQuestionLinkPK)
		throws NoSuchExamQuestionLinkException {
		return remove((Serializable)examQuestionLinkPK);
	}

	/**
	 * Removes the exam question link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the exam question link
	 * @return the exam question link that was removed
	 * @throws NoSuchExamQuestionLinkException if a exam question link with the primary key could not be found
	 */
	@Override
	public ExamQuestionLink remove(Serializable primaryKey)
		throws NoSuchExamQuestionLinkException {
		Session session = null;

		try {
			session = openSession();

			ExamQuestionLink examQuestionLink = (ExamQuestionLink)session.get(ExamQuestionLinkImpl.class,
					primaryKey);

			if (examQuestionLink == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchExamQuestionLinkException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(examQuestionLink);
		}
		catch (NoSuchExamQuestionLinkException nsee) {
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
	protected ExamQuestionLink removeImpl(ExamQuestionLink examQuestionLink) {
		examQuestionLink = toUnwrappedModel(examQuestionLink);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(examQuestionLink)) {
				examQuestionLink = (ExamQuestionLink)session.get(ExamQuestionLinkImpl.class,
						examQuestionLink.getPrimaryKeyObj());
			}

			if (examQuestionLink != null) {
				session.delete(examQuestionLink);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (examQuestionLink != null) {
			clearCache(examQuestionLink);
		}

		return examQuestionLink;
	}

	@Override
	public ExamQuestionLink updateImpl(ExamQuestionLink examQuestionLink) {
		examQuestionLink = toUnwrappedModel(examQuestionLink);

		boolean isNew = examQuestionLink.isNew();

		ExamQuestionLinkModelImpl examQuestionLinkModelImpl = (ExamQuestionLinkModelImpl)examQuestionLink;

		Session session = null;

		try {
			session = openSession();

			if (examQuestionLink.isNew()) {
				session.save(examQuestionLink);

				examQuestionLink.setNew(false);
			}
			else {
				examQuestionLink = (ExamQuestionLink)session.merge(examQuestionLink);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ExamQuestionLinkModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((examQuestionLinkModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EXAMRECORDID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						examQuestionLinkModelImpl.getOriginalExamRecordId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EXAMRECORDID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EXAMRECORDID,
					args);

				args = new Object[] { examQuestionLinkModelImpl.getExamRecordId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EXAMRECORDID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EXAMRECORDID,
					args);
			}
		}

		entityCache.putResult(ExamQuestionLinkModelImpl.ENTITY_CACHE_ENABLED,
			ExamQuestionLinkImpl.class, examQuestionLink.getPrimaryKey(),
			examQuestionLink, false);

		examQuestionLink.resetOriginalValues();

		return examQuestionLink;
	}

	protected ExamQuestionLink toUnwrappedModel(
		ExamQuestionLink examQuestionLink) {
		if (examQuestionLink instanceof ExamQuestionLinkImpl) {
			return examQuestionLink;
		}

		ExamQuestionLinkImpl examQuestionLinkImpl = new ExamQuestionLinkImpl();

		examQuestionLinkImpl.setNew(examQuestionLink.isNew());
		examQuestionLinkImpl.setPrimaryKey(examQuestionLink.getPrimaryKey());

		examQuestionLinkImpl.setExamRecordId(examQuestionLink.getExamRecordId());
		examQuestionLinkImpl.setQuestionRecordId(examQuestionLink.getQuestionRecordId());
		examQuestionLinkImpl.setQuestionRecordVersion(examQuestionLink.getQuestionRecordVersion());

		return examQuestionLinkImpl;
	}

	/**
	 * Returns the exam question link with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the exam question link
	 * @return the exam question link
	 * @throws NoSuchExamQuestionLinkException if a exam question link with the primary key could not be found
	 */
	@Override
	public ExamQuestionLink findByPrimaryKey(Serializable primaryKey)
		throws NoSuchExamQuestionLinkException {
		ExamQuestionLink examQuestionLink = fetchByPrimaryKey(primaryKey);

		if (examQuestionLink == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchExamQuestionLinkException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return examQuestionLink;
	}

	/**
	 * Returns the exam question link with the primary key or throws a {@link NoSuchExamQuestionLinkException} if it could not be found.
	 *
	 * @param examQuestionLinkPK the primary key of the exam question link
	 * @return the exam question link
	 * @throws NoSuchExamQuestionLinkException if a exam question link with the primary key could not be found
	 */
	@Override
	public ExamQuestionLink findByPrimaryKey(
		ExamQuestionLinkPK examQuestionLinkPK)
		throws NoSuchExamQuestionLinkException {
		return findByPrimaryKey((Serializable)examQuestionLinkPK);
	}

	/**
	 * Returns the exam question link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the exam question link
	 * @return the exam question link, or <code>null</code> if a exam question link with the primary key could not be found
	 */
	@Override
	public ExamQuestionLink fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(ExamQuestionLinkModelImpl.ENTITY_CACHE_ENABLED,
				ExamQuestionLinkImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		ExamQuestionLink examQuestionLink = (ExamQuestionLink)serializable;

		if (examQuestionLink == null) {
			Session session = null;

			try {
				session = openSession();

				examQuestionLink = (ExamQuestionLink)session.get(ExamQuestionLinkImpl.class,
						primaryKey);

				if (examQuestionLink != null) {
					cacheResult(examQuestionLink);
				}
				else {
					entityCache.putResult(ExamQuestionLinkModelImpl.ENTITY_CACHE_ENABLED,
						ExamQuestionLinkImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ExamQuestionLinkModelImpl.ENTITY_CACHE_ENABLED,
					ExamQuestionLinkImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return examQuestionLink;
	}

	/**
	 * Returns the exam question link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param examQuestionLinkPK the primary key of the exam question link
	 * @return the exam question link, or <code>null</code> if a exam question link with the primary key could not be found
	 */
	@Override
	public ExamQuestionLink fetchByPrimaryKey(
		ExamQuestionLinkPK examQuestionLinkPK) {
		return fetchByPrimaryKey((Serializable)examQuestionLinkPK);
	}

	@Override
	public Map<Serializable, ExamQuestionLink> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, ExamQuestionLink> map = new HashMap<Serializable, ExamQuestionLink>();

		for (Serializable primaryKey : primaryKeys) {
			ExamQuestionLink examQuestionLink = fetchByPrimaryKey(primaryKey);

			if (examQuestionLink != null) {
				map.put(primaryKey, examQuestionLink);
			}
		}

		return map;
	}

	/**
	 * Returns all the exam question links.
	 *
	 * @return the exam question links
	 */
	@Override
	public List<ExamQuestionLink> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ExamQuestionLink> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<ExamQuestionLink> findAll(int start, int end,
		OrderByComparator<ExamQuestionLink> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<ExamQuestionLink> findAll(int start, int end,
		OrderByComparator<ExamQuestionLink> orderByComparator,
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

		List<ExamQuestionLink> list = null;

		if (retrieveFromCache) {
			list = (List<ExamQuestionLink>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_EXAMQUESTIONLINK);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EXAMQUESTIONLINK;

				if (pagination) {
					sql = sql.concat(ExamQuestionLinkModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ExamQuestionLink>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ExamQuestionLink>)QueryUtil.list(q,
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
	 * Removes all the exam question links from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ExamQuestionLink examQuestionLink : findAll()) {
			remove(examQuestionLink);
		}
	}

	/**
	 * Returns the number of exam question links.
	 *
	 * @return the number of exam question links
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_EXAMQUESTIONLINK);

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
		return ExamQuestionLinkModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the exam question link persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(ExamQuestionLinkImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_EXAMQUESTIONLINK = "SELECT examQuestionLink FROM ExamQuestionLink examQuestionLink";
	private static final String _SQL_SELECT_EXAMQUESTIONLINK_WHERE = "SELECT examQuestionLink FROM ExamQuestionLink examQuestionLink WHERE ";
	private static final String _SQL_COUNT_EXAMQUESTIONLINK = "SELECT COUNT(examQuestionLink) FROM ExamQuestionLink examQuestionLink";
	private static final String _SQL_COUNT_EXAMQUESTIONLINK_WHERE = "SELECT COUNT(examQuestionLink) FROM ExamQuestionLink examQuestionLink WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "examQuestionLink.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ExamQuestionLink exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ExamQuestionLink exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(ExamQuestionLinkPersistenceImpl.class);
}