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

import priv.barrow.service.persistence.ExamQuestionLinkPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
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
	 * @param examRecordId the primary key for the new exam question link
	 * @return the new exam question link
	 */
	@Override
	public ExamQuestionLink create(long examRecordId) {
		ExamQuestionLink examQuestionLink = new ExamQuestionLinkImpl();

		examQuestionLink.setNew(true);
		examQuestionLink.setPrimaryKey(examRecordId);

		return examQuestionLink;
	}

	/**
	 * Removes the exam question link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param examRecordId the primary key of the exam question link
	 * @return the exam question link that was removed
	 * @throws NoSuchExamQuestionLinkException if a exam question link with the primary key could not be found
	 */
	@Override
	public ExamQuestionLink remove(long examRecordId)
		throws NoSuchExamQuestionLinkException {
		return remove((Serializable)examRecordId);
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

		if (isNew) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
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
	 * @param examRecordId the primary key of the exam question link
	 * @return the exam question link
	 * @throws NoSuchExamQuestionLinkException if a exam question link with the primary key could not be found
	 */
	@Override
	public ExamQuestionLink findByPrimaryKey(long examRecordId)
		throws NoSuchExamQuestionLinkException {
		return findByPrimaryKey((Serializable)examRecordId);
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
	 * @param examRecordId the primary key of the exam question link
	 * @return the exam question link, or <code>null</code> if a exam question link with the primary key could not be found
	 */
	@Override
	public ExamQuestionLink fetchByPrimaryKey(long examRecordId) {
		return fetchByPrimaryKey((Serializable)examRecordId);
	}

	@Override
	public Map<Serializable, ExamQuestionLink> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, ExamQuestionLink> map = new HashMap<Serializable, ExamQuestionLink>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			ExamQuestionLink examQuestionLink = fetchByPrimaryKey(primaryKey);

			if (examQuestionLink != null) {
				map.put(primaryKey, examQuestionLink);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(ExamQuestionLinkModelImpl.ENTITY_CACHE_ENABLED,
					ExamQuestionLinkImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (ExamQuestionLink)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_EXAMQUESTIONLINK_WHERE_PKS_IN);

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

			for (ExamQuestionLink examQuestionLink : (List<ExamQuestionLink>)q.list()) {
				map.put(examQuestionLink.getPrimaryKeyObj(), examQuestionLink);

				cacheResult(examQuestionLink);

				uncachedPrimaryKeys.remove(examQuestionLink.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(ExamQuestionLinkModelImpl.ENTITY_CACHE_ENABLED,
					ExamQuestionLinkImpl.class, primaryKey, nullModel);
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
	private static final String _SQL_SELECT_EXAMQUESTIONLINK_WHERE_PKS_IN = "SELECT examQuestionLink FROM ExamQuestionLink examQuestionLink WHERE examRecordId IN (";
	private static final String _SQL_COUNT_EXAMQUESTIONLINK = "SELECT COUNT(examQuestionLink) FROM ExamQuestionLink examQuestionLink";
	private static final String _ORDER_BY_ENTITY_ALIAS = "examQuestionLink.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ExamQuestionLink exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(ExamQuestionLinkPersistenceImpl.class);
}