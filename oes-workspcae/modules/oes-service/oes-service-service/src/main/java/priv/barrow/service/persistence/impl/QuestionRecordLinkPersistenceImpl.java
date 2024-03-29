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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import priv.barrow.exception.NoSuchQuestionRecordLinkException;

import priv.barrow.model.QuestionRecordLink;
import priv.barrow.model.impl.QuestionRecordLinkImpl;
import priv.barrow.model.impl.QuestionRecordLinkModelImpl;

import priv.barrow.service.persistence.QuestionRecordLinkPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the question record link service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuestionRecordLinkPersistence
 * @see priv.barrow.service.persistence.QuestionRecordLinkUtil
 * @generated
 */
@ProviderType
public class QuestionRecordLinkPersistenceImpl extends BasePersistenceImpl<QuestionRecordLink>
	implements QuestionRecordLinkPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link QuestionRecordLinkUtil} to access the question record link persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = QuestionRecordLinkImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(QuestionRecordLinkModelImpl.ENTITY_CACHE_ENABLED,
			QuestionRecordLinkModelImpl.FINDER_CACHE_ENABLED,
			QuestionRecordLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(QuestionRecordLinkModelImpl.ENTITY_CACHE_ENABLED,
			QuestionRecordLinkModelImpl.FINDER_CACHE_ENABLED,
			QuestionRecordLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(QuestionRecordLinkModelImpl.ENTITY_CACHE_ENABLED,
			QuestionRecordLinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DDLRECORDID =
		new FinderPath(QuestionRecordLinkModelImpl.ENTITY_CACHE_ENABLED,
			QuestionRecordLinkModelImpl.FINDER_CACHE_ENABLED,
			QuestionRecordLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDdlRecordId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DDLRECORDID =
		new FinderPath(QuestionRecordLinkModelImpl.ENTITY_CACHE_ENABLED,
			QuestionRecordLinkModelImpl.FINDER_CACHE_ENABLED,
			QuestionRecordLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDdlRecordId",
			new String[] { Long.class.getName() },
			QuestionRecordLinkModelImpl.DDLRECORDID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DDLRECORDID = new FinderPath(QuestionRecordLinkModelImpl.ENTITY_CACHE_ENABLED,
			QuestionRecordLinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDdlRecordId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the question record links where ddlRecordId = &#63;.
	 *
	 * @param ddlRecordId the ddl record ID
	 * @return the matching question record links
	 */
	@Override
	public List<QuestionRecordLink> findByDdlRecordId(long ddlRecordId) {
		return findByDdlRecordId(ddlRecordId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<QuestionRecordLink> findByDdlRecordId(long ddlRecordId,
		int start, int end) {
		return findByDdlRecordId(ddlRecordId, start, end, null);
	}

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
	@Override
	public List<QuestionRecordLink> findByDdlRecordId(long ddlRecordId,
		int start, int end,
		OrderByComparator<QuestionRecordLink> orderByComparator) {
		return findByDdlRecordId(ddlRecordId, start, end, orderByComparator,
			true);
	}

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
	@Override
	public List<QuestionRecordLink> findByDdlRecordId(long ddlRecordId,
		int start, int end,
		OrderByComparator<QuestionRecordLink> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DDLRECORDID;
			finderArgs = new Object[] { ddlRecordId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DDLRECORDID;
			finderArgs = new Object[] { ddlRecordId, start, end, orderByComparator };
		}

		List<QuestionRecordLink> list = null;

		if (retrieveFromCache) {
			list = (List<QuestionRecordLink>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (QuestionRecordLink questionRecordLink : list) {
					if ((ddlRecordId != questionRecordLink.getDdlRecordId())) {
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

			query.append(_SQL_SELECT_QUESTIONRECORDLINK_WHERE);

			query.append(_FINDER_COLUMN_DDLRECORDID_DDLRECORDID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(QuestionRecordLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ddlRecordId);

				if (!pagination) {
					list = (List<QuestionRecordLink>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<QuestionRecordLink>)QueryUtil.list(q,
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
	 * Returns the first question record link in the ordered set where ddlRecordId = &#63;.
	 *
	 * @param ddlRecordId the ddl record ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching question record link
	 * @throws NoSuchQuestionRecordLinkException if a matching question record link could not be found
	 */
	@Override
	public QuestionRecordLink findByDdlRecordId_First(long ddlRecordId,
		OrderByComparator<QuestionRecordLink> orderByComparator)
		throws NoSuchQuestionRecordLinkException {
		QuestionRecordLink questionRecordLink = fetchByDdlRecordId_First(ddlRecordId,
				orderByComparator);

		if (questionRecordLink != null) {
			return questionRecordLink;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ddlRecordId=");
		msg.append(ddlRecordId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchQuestionRecordLinkException(msg.toString());
	}

	/**
	 * Returns the first question record link in the ordered set where ddlRecordId = &#63;.
	 *
	 * @param ddlRecordId the ddl record ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching question record link, or <code>null</code> if a matching question record link could not be found
	 */
	@Override
	public QuestionRecordLink fetchByDdlRecordId_First(long ddlRecordId,
		OrderByComparator<QuestionRecordLink> orderByComparator) {
		List<QuestionRecordLink> list = findByDdlRecordId(ddlRecordId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last question record link in the ordered set where ddlRecordId = &#63;.
	 *
	 * @param ddlRecordId the ddl record ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching question record link
	 * @throws NoSuchQuestionRecordLinkException if a matching question record link could not be found
	 */
	@Override
	public QuestionRecordLink findByDdlRecordId_Last(long ddlRecordId,
		OrderByComparator<QuestionRecordLink> orderByComparator)
		throws NoSuchQuestionRecordLinkException {
		QuestionRecordLink questionRecordLink = fetchByDdlRecordId_Last(ddlRecordId,
				orderByComparator);

		if (questionRecordLink != null) {
			return questionRecordLink;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ddlRecordId=");
		msg.append(ddlRecordId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchQuestionRecordLinkException(msg.toString());
	}

	/**
	 * Returns the last question record link in the ordered set where ddlRecordId = &#63;.
	 *
	 * @param ddlRecordId the ddl record ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching question record link, or <code>null</code> if a matching question record link could not be found
	 */
	@Override
	public QuestionRecordLink fetchByDdlRecordId_Last(long ddlRecordId,
		OrderByComparator<QuestionRecordLink> orderByComparator) {
		int count = countByDdlRecordId(ddlRecordId);

		if (count == 0) {
			return null;
		}

		List<QuestionRecordLink> list = findByDdlRecordId(ddlRecordId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the question record links before and after the current question record link in the ordered set where ddlRecordId = &#63;.
	 *
	 * @param questionOrder the primary key of the current question record link
	 * @param ddlRecordId the ddl record ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next question record link
	 * @throws NoSuchQuestionRecordLinkException if a question record link with the primary key could not be found
	 */
	@Override
	public QuestionRecordLink[] findByDdlRecordId_PrevAndNext(
		long questionOrder, long ddlRecordId,
		OrderByComparator<QuestionRecordLink> orderByComparator)
		throws NoSuchQuestionRecordLinkException {
		QuestionRecordLink questionRecordLink = findByPrimaryKey(questionOrder);

		Session session = null;

		try {
			session = openSession();

			QuestionRecordLink[] array = new QuestionRecordLinkImpl[3];

			array[0] = getByDdlRecordId_PrevAndNext(session,
					questionRecordLink, ddlRecordId, orderByComparator, true);

			array[1] = questionRecordLink;

			array[2] = getByDdlRecordId_PrevAndNext(session,
					questionRecordLink, ddlRecordId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected QuestionRecordLink getByDdlRecordId_PrevAndNext(Session session,
		QuestionRecordLink questionRecordLink, long ddlRecordId,
		OrderByComparator<QuestionRecordLink> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_QUESTIONRECORDLINK_WHERE);

		query.append(_FINDER_COLUMN_DDLRECORDID_DDLRECORDID_2);

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
			query.append(QuestionRecordLinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(ddlRecordId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(questionRecordLink);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<QuestionRecordLink> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the question record links where ddlRecordId = &#63; from the database.
	 *
	 * @param ddlRecordId the ddl record ID
	 */
	@Override
	public void removeByDdlRecordId(long ddlRecordId) {
		for (QuestionRecordLink questionRecordLink : findByDdlRecordId(
				ddlRecordId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(questionRecordLink);
		}
	}

	/**
	 * Returns the number of question record links where ddlRecordId = &#63;.
	 *
	 * @param ddlRecordId the ddl record ID
	 * @return the number of matching question record links
	 */
	@Override
	public int countByDdlRecordId(long ddlRecordId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DDLRECORDID;

		Object[] finderArgs = new Object[] { ddlRecordId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_QUESTIONRECORDLINK_WHERE);

			query.append(_FINDER_COLUMN_DDLRECORDID_DDLRECORDID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ddlRecordId);

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

	private static final String _FINDER_COLUMN_DDLRECORDID_DDLRECORDID_2 = "questionRecordLink.ddlRecordId = ?";

	public QuestionRecordLinkPersistenceImpl() {
		setModelClass(QuestionRecordLink.class);
	}

	/**
	 * Caches the question record link in the entity cache if it is enabled.
	 *
	 * @param questionRecordLink the question record link
	 */
	@Override
	public void cacheResult(QuestionRecordLink questionRecordLink) {
		entityCache.putResult(QuestionRecordLinkModelImpl.ENTITY_CACHE_ENABLED,
			QuestionRecordLinkImpl.class, questionRecordLink.getPrimaryKey(),
			questionRecordLink);

		questionRecordLink.resetOriginalValues();
	}

	/**
	 * Caches the question record links in the entity cache if it is enabled.
	 *
	 * @param questionRecordLinks the question record links
	 */
	@Override
	public void cacheResult(List<QuestionRecordLink> questionRecordLinks) {
		for (QuestionRecordLink questionRecordLink : questionRecordLinks) {
			if (entityCache.getResult(
						QuestionRecordLinkModelImpl.ENTITY_CACHE_ENABLED,
						QuestionRecordLinkImpl.class,
						questionRecordLink.getPrimaryKey()) == null) {
				cacheResult(questionRecordLink);
			}
			else {
				questionRecordLink.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all question record links.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(QuestionRecordLinkImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the question record link.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(QuestionRecordLink questionRecordLink) {
		entityCache.removeResult(QuestionRecordLinkModelImpl.ENTITY_CACHE_ENABLED,
			QuestionRecordLinkImpl.class, questionRecordLink.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<QuestionRecordLink> questionRecordLinks) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (QuestionRecordLink questionRecordLink : questionRecordLinks) {
			entityCache.removeResult(QuestionRecordLinkModelImpl.ENTITY_CACHE_ENABLED,
				QuestionRecordLinkImpl.class, questionRecordLink.getPrimaryKey());
		}
	}

	/**
	 * Creates a new question record link with the primary key. Does not add the question record link to the database.
	 *
	 * @param questionOrder the primary key for the new question record link
	 * @return the new question record link
	 */
	@Override
	public QuestionRecordLink create(long questionOrder) {
		QuestionRecordLink questionRecordLink = new QuestionRecordLinkImpl();

		questionRecordLink.setNew(true);
		questionRecordLink.setPrimaryKey(questionOrder);

		return questionRecordLink;
	}

	/**
	 * Removes the question record link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param questionOrder the primary key of the question record link
	 * @return the question record link that was removed
	 * @throws NoSuchQuestionRecordLinkException if a question record link with the primary key could not be found
	 */
	@Override
	public QuestionRecordLink remove(long questionOrder)
		throws NoSuchQuestionRecordLinkException {
		return remove((Serializable)questionOrder);
	}

	/**
	 * Removes the question record link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the question record link
	 * @return the question record link that was removed
	 * @throws NoSuchQuestionRecordLinkException if a question record link with the primary key could not be found
	 */
	@Override
	public QuestionRecordLink remove(Serializable primaryKey)
		throws NoSuchQuestionRecordLinkException {
		Session session = null;

		try {
			session = openSession();

			QuestionRecordLink questionRecordLink = (QuestionRecordLink)session.get(QuestionRecordLinkImpl.class,
					primaryKey);

			if (questionRecordLink == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchQuestionRecordLinkException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(questionRecordLink);
		}
		catch (NoSuchQuestionRecordLinkException nsee) {
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
	protected QuestionRecordLink removeImpl(
		QuestionRecordLink questionRecordLink) {
		questionRecordLink = toUnwrappedModel(questionRecordLink);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(questionRecordLink)) {
				questionRecordLink = (QuestionRecordLink)session.get(QuestionRecordLinkImpl.class,
						questionRecordLink.getPrimaryKeyObj());
			}

			if (questionRecordLink != null) {
				session.delete(questionRecordLink);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (questionRecordLink != null) {
			clearCache(questionRecordLink);
		}

		return questionRecordLink;
	}

	@Override
	public QuestionRecordLink updateImpl(QuestionRecordLink questionRecordLink) {
		questionRecordLink = toUnwrappedModel(questionRecordLink);

		boolean isNew = questionRecordLink.isNew();

		QuestionRecordLinkModelImpl questionRecordLinkModelImpl = (QuestionRecordLinkModelImpl)questionRecordLink;

		Session session = null;

		try {
			session = openSession();

			if (questionRecordLink.isNew()) {
				session.save(questionRecordLink);

				questionRecordLink.setNew(false);
			}
			else {
				questionRecordLink = (QuestionRecordLink)session.merge(questionRecordLink);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !QuestionRecordLinkModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((questionRecordLinkModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DDLRECORDID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						questionRecordLinkModelImpl.getOriginalDdlRecordId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DDLRECORDID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DDLRECORDID,
					args);

				args = new Object[] { questionRecordLinkModelImpl.getDdlRecordId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DDLRECORDID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DDLRECORDID,
					args);
			}
		}

		entityCache.putResult(QuestionRecordLinkModelImpl.ENTITY_CACHE_ENABLED,
			QuestionRecordLinkImpl.class, questionRecordLink.getPrimaryKey(),
			questionRecordLink, false);

		questionRecordLink.resetOriginalValues();

		return questionRecordLink;
	}

	protected QuestionRecordLink toUnwrappedModel(
		QuestionRecordLink questionRecordLink) {
		if (questionRecordLink instanceof QuestionRecordLinkImpl) {
			return questionRecordLink;
		}

		QuestionRecordLinkImpl questionRecordLinkImpl = new QuestionRecordLinkImpl();

		questionRecordLinkImpl.setNew(questionRecordLink.isNew());
		questionRecordLinkImpl.setPrimaryKey(questionRecordLink.getPrimaryKey());

		questionRecordLinkImpl.setQuestionOrder(questionRecordLink.getQuestionOrder());
		questionRecordLinkImpl.setDdlRecordId(questionRecordLink.getDdlRecordId());
		questionRecordLinkImpl.setActive(questionRecordLink.isActive());
		questionRecordLinkImpl.setQuestionDescription(questionRecordLink.getQuestionDescription());

		return questionRecordLinkImpl;
	}

	/**
	 * Returns the question record link with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the question record link
	 * @return the question record link
	 * @throws NoSuchQuestionRecordLinkException if a question record link with the primary key could not be found
	 */
	@Override
	public QuestionRecordLink findByPrimaryKey(Serializable primaryKey)
		throws NoSuchQuestionRecordLinkException {
		QuestionRecordLink questionRecordLink = fetchByPrimaryKey(primaryKey);

		if (questionRecordLink == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchQuestionRecordLinkException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return questionRecordLink;
	}

	/**
	 * Returns the question record link with the primary key or throws a {@link NoSuchQuestionRecordLinkException} if it could not be found.
	 *
	 * @param questionOrder the primary key of the question record link
	 * @return the question record link
	 * @throws NoSuchQuestionRecordLinkException if a question record link with the primary key could not be found
	 */
	@Override
	public QuestionRecordLink findByPrimaryKey(long questionOrder)
		throws NoSuchQuestionRecordLinkException {
		return findByPrimaryKey((Serializable)questionOrder);
	}

	/**
	 * Returns the question record link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the question record link
	 * @return the question record link, or <code>null</code> if a question record link with the primary key could not be found
	 */
	@Override
	public QuestionRecordLink fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(QuestionRecordLinkModelImpl.ENTITY_CACHE_ENABLED,
				QuestionRecordLinkImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		QuestionRecordLink questionRecordLink = (QuestionRecordLink)serializable;

		if (questionRecordLink == null) {
			Session session = null;

			try {
				session = openSession();

				questionRecordLink = (QuestionRecordLink)session.get(QuestionRecordLinkImpl.class,
						primaryKey);

				if (questionRecordLink != null) {
					cacheResult(questionRecordLink);
				}
				else {
					entityCache.putResult(QuestionRecordLinkModelImpl.ENTITY_CACHE_ENABLED,
						QuestionRecordLinkImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(QuestionRecordLinkModelImpl.ENTITY_CACHE_ENABLED,
					QuestionRecordLinkImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return questionRecordLink;
	}

	/**
	 * Returns the question record link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param questionOrder the primary key of the question record link
	 * @return the question record link, or <code>null</code> if a question record link with the primary key could not be found
	 */
	@Override
	public QuestionRecordLink fetchByPrimaryKey(long questionOrder) {
		return fetchByPrimaryKey((Serializable)questionOrder);
	}

	@Override
	public Map<Serializable, QuestionRecordLink> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, QuestionRecordLink> map = new HashMap<Serializable, QuestionRecordLink>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			QuestionRecordLink questionRecordLink = fetchByPrimaryKey(primaryKey);

			if (questionRecordLink != null) {
				map.put(primaryKey, questionRecordLink);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(QuestionRecordLinkModelImpl.ENTITY_CACHE_ENABLED,
					QuestionRecordLinkImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (QuestionRecordLink)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_QUESTIONRECORDLINK_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(String.valueOf(primaryKey));

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (QuestionRecordLink questionRecordLink : (List<QuestionRecordLink>)q.list()) {
				map.put(questionRecordLink.getPrimaryKeyObj(),
					questionRecordLink);

				cacheResult(questionRecordLink);

				uncachedPrimaryKeys.remove(questionRecordLink.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(QuestionRecordLinkModelImpl.ENTITY_CACHE_ENABLED,
					QuestionRecordLinkImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the question record links.
	 *
	 * @return the question record links
	 */
	@Override
	public List<QuestionRecordLink> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<QuestionRecordLink> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<QuestionRecordLink> findAll(int start, int end,
		OrderByComparator<QuestionRecordLink> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<QuestionRecordLink> findAll(int start, int end,
		OrderByComparator<QuestionRecordLink> orderByComparator,
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

		List<QuestionRecordLink> list = null;

		if (retrieveFromCache) {
			list = (List<QuestionRecordLink>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_QUESTIONRECORDLINK);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_QUESTIONRECORDLINK;

				if (pagination) {
					sql = sql.concat(QuestionRecordLinkModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<QuestionRecordLink>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<QuestionRecordLink>)QueryUtil.list(q,
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
	 * Removes all the question record links from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (QuestionRecordLink questionRecordLink : findAll()) {
			remove(questionRecordLink);
		}
	}

	/**
	 * Returns the number of question record links.
	 *
	 * @return the number of question record links
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_QUESTIONRECORDLINK);

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
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return QuestionRecordLinkModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the question record link persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(QuestionRecordLinkImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_QUESTIONRECORDLINK = "SELECT questionRecordLink FROM QuestionRecordLink questionRecordLink";
	private static final String _SQL_SELECT_QUESTIONRECORDLINK_WHERE_PKS_IN = "SELECT questionRecordLink FROM QuestionRecordLink questionRecordLink WHERE questionOrder IN (";
	private static final String _SQL_SELECT_QUESTIONRECORDLINK_WHERE = "SELECT questionRecordLink FROM QuestionRecordLink questionRecordLink WHERE ";
	private static final String _SQL_COUNT_QUESTIONRECORDLINK = "SELECT COUNT(questionRecordLink) FROM QuestionRecordLink questionRecordLink";
	private static final String _SQL_COUNT_QUESTIONRECORDLINK_WHERE = "SELECT COUNT(questionRecordLink) FROM QuestionRecordLink questionRecordLink WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "questionRecordLink.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No QuestionRecordLink exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No QuestionRecordLink exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(QuestionRecordLinkPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"active"
			});
}