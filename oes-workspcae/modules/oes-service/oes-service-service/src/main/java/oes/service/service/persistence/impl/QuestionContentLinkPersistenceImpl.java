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

package oes.service.service.persistence.impl;

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

import oes.service.exception.NoSuchQuestionContentLinkException;

import oes.service.model.QuestionContentLink;
import oes.service.model.impl.QuestionContentLinkImpl;
import oes.service.model.impl.QuestionContentLinkModelImpl;

import oes.service.service.persistence.QuestionContentLinkPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the question content link service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuestionContentLinkPersistence
 * @see oes.service.service.persistence.QuestionContentLinkUtil
 * @generated
 */
@ProviderType
public class QuestionContentLinkPersistenceImpl extends BasePersistenceImpl<QuestionContentLink>
	implements QuestionContentLinkPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link QuestionContentLinkUtil} to access the question content link persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = QuestionContentLinkImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(QuestionContentLinkModelImpl.ENTITY_CACHE_ENABLED,
			QuestionContentLinkModelImpl.FINDER_CACHE_ENABLED,
			QuestionContentLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(QuestionContentLinkModelImpl.ENTITY_CACHE_ENABLED,
			QuestionContentLinkModelImpl.FINDER_CACHE_ENABLED,
			QuestionContentLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(QuestionContentLinkModelImpl.ENTITY_CACHE_ENABLED,
			QuestionContentLinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public QuestionContentLinkPersistenceImpl() {
		setModelClass(QuestionContentLink.class);
	}

	/**
	 * Caches the question content link in the entity cache if it is enabled.
	 *
	 * @param questionContentLink the question content link
	 */
	@Override
	public void cacheResult(QuestionContentLink questionContentLink) {
		entityCache.putResult(QuestionContentLinkModelImpl.ENTITY_CACHE_ENABLED,
			QuestionContentLinkImpl.class, questionContentLink.getPrimaryKey(),
			questionContentLink);

		questionContentLink.resetOriginalValues();
	}

	/**
	 * Caches the question content links in the entity cache if it is enabled.
	 *
	 * @param questionContentLinks the question content links
	 */
	@Override
	public void cacheResult(List<QuestionContentLink> questionContentLinks) {
		for (QuestionContentLink questionContentLink : questionContentLinks) {
			if (entityCache.getResult(
						QuestionContentLinkModelImpl.ENTITY_CACHE_ENABLED,
						QuestionContentLinkImpl.class,
						questionContentLink.getPrimaryKey()) == null) {
				cacheResult(questionContentLink);
			}
			else {
				questionContentLink.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all question content links.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(QuestionContentLinkImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the question content link.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(QuestionContentLink questionContentLink) {
		entityCache.removeResult(QuestionContentLinkModelImpl.ENTITY_CACHE_ENABLED,
			QuestionContentLinkImpl.class, questionContentLink.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<QuestionContentLink> questionContentLinks) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (QuestionContentLink questionContentLink : questionContentLinks) {
			entityCache.removeResult(QuestionContentLinkModelImpl.ENTITY_CACHE_ENABLED,
				QuestionContentLinkImpl.class,
				questionContentLink.getPrimaryKey());
		}
	}

	/**
	 * Creates a new question content link with the primary key. Does not add the question content link to the database.
	 *
	 * @param questionOrder the primary key for the new question content link
	 * @return the new question content link
	 */
	@Override
	public QuestionContentLink create(long questionOrder) {
		QuestionContentLink questionContentLink = new QuestionContentLinkImpl();

		questionContentLink.setNew(true);
		questionContentLink.setPrimaryKey(questionOrder);

		return questionContentLink;
	}

	/**
	 * Removes the question content link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param questionOrder the primary key of the question content link
	 * @return the question content link that was removed
	 * @throws NoSuchQuestionContentLinkException if a question content link with the primary key could not be found
	 */
	@Override
	public QuestionContentLink remove(long questionOrder)
		throws NoSuchQuestionContentLinkException {
		return remove((Serializable)questionOrder);
	}

	/**
	 * Removes the question content link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the question content link
	 * @return the question content link that was removed
	 * @throws NoSuchQuestionContentLinkException if a question content link with the primary key could not be found
	 */
	@Override
	public QuestionContentLink remove(Serializable primaryKey)
		throws NoSuchQuestionContentLinkException {
		Session session = null;

		try {
			session = openSession();

			QuestionContentLink questionContentLink = (QuestionContentLink)session.get(QuestionContentLinkImpl.class,
					primaryKey);

			if (questionContentLink == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchQuestionContentLinkException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(questionContentLink);
		}
		catch (NoSuchQuestionContentLinkException nsee) {
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
	protected QuestionContentLink removeImpl(
		QuestionContentLink questionContentLink) {
		questionContentLink = toUnwrappedModel(questionContentLink);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(questionContentLink)) {
				questionContentLink = (QuestionContentLink)session.get(QuestionContentLinkImpl.class,
						questionContentLink.getPrimaryKeyObj());
			}

			if (questionContentLink != null) {
				session.delete(questionContentLink);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (questionContentLink != null) {
			clearCache(questionContentLink);
		}

		return questionContentLink;
	}

	@Override
	public QuestionContentLink updateImpl(
		QuestionContentLink questionContentLink) {
		questionContentLink = toUnwrappedModel(questionContentLink);

		boolean isNew = questionContentLink.isNew();

		Session session = null;

		try {
			session = openSession();

			if (questionContentLink.isNew()) {
				session.save(questionContentLink);

				questionContentLink.setNew(false);
			}
			else {
				questionContentLink = (QuestionContentLink)session.merge(questionContentLink);
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

		entityCache.putResult(QuestionContentLinkModelImpl.ENTITY_CACHE_ENABLED,
			QuestionContentLinkImpl.class, questionContentLink.getPrimaryKey(),
			questionContentLink, false);

		questionContentLink.resetOriginalValues();

		return questionContentLink;
	}

	protected QuestionContentLink toUnwrappedModel(
		QuestionContentLink questionContentLink) {
		if (questionContentLink instanceof QuestionContentLinkImpl) {
			return questionContentLink;
		}

		QuestionContentLinkImpl questionContentLinkImpl = new QuestionContentLinkImpl();

		questionContentLinkImpl.setNew(questionContentLink.isNew());
		questionContentLinkImpl.setPrimaryKey(questionContentLink.getPrimaryKey());

		questionContentLinkImpl.setQuestionOrder(questionContentLink.getQuestionOrder());
		questionContentLinkImpl.setDdmContentId(questionContentLink.getDdmContentId());

		return questionContentLinkImpl;
	}

	/**
	 * Returns the question content link with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the question content link
	 * @return the question content link
	 * @throws NoSuchQuestionContentLinkException if a question content link with the primary key could not be found
	 */
	@Override
	public QuestionContentLink findByPrimaryKey(Serializable primaryKey)
		throws NoSuchQuestionContentLinkException {
		QuestionContentLink questionContentLink = fetchByPrimaryKey(primaryKey);

		if (questionContentLink == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchQuestionContentLinkException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return questionContentLink;
	}

	/**
	 * Returns the question content link with the primary key or throws a {@link NoSuchQuestionContentLinkException} if it could not be found.
	 *
	 * @param questionOrder the primary key of the question content link
	 * @return the question content link
	 * @throws NoSuchQuestionContentLinkException if a question content link with the primary key could not be found
	 */
	@Override
	public QuestionContentLink findByPrimaryKey(long questionOrder)
		throws NoSuchQuestionContentLinkException {
		return findByPrimaryKey((Serializable)questionOrder);
	}

	/**
	 * Returns the question content link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the question content link
	 * @return the question content link, or <code>null</code> if a question content link with the primary key could not be found
	 */
	@Override
	public QuestionContentLink fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(QuestionContentLinkModelImpl.ENTITY_CACHE_ENABLED,
				QuestionContentLinkImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		QuestionContentLink questionContentLink = (QuestionContentLink)serializable;

		if (questionContentLink == null) {
			Session session = null;

			try {
				session = openSession();

				questionContentLink = (QuestionContentLink)session.get(QuestionContentLinkImpl.class,
						primaryKey);

				if (questionContentLink != null) {
					cacheResult(questionContentLink);
				}
				else {
					entityCache.putResult(QuestionContentLinkModelImpl.ENTITY_CACHE_ENABLED,
						QuestionContentLinkImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(QuestionContentLinkModelImpl.ENTITY_CACHE_ENABLED,
					QuestionContentLinkImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return questionContentLink;
	}

	/**
	 * Returns the question content link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param questionOrder the primary key of the question content link
	 * @return the question content link, or <code>null</code> if a question content link with the primary key could not be found
	 */
	@Override
	public QuestionContentLink fetchByPrimaryKey(long questionOrder) {
		return fetchByPrimaryKey((Serializable)questionOrder);
	}

	@Override
	public Map<Serializable, QuestionContentLink> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, QuestionContentLink> map = new HashMap<Serializable, QuestionContentLink>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			QuestionContentLink questionContentLink = fetchByPrimaryKey(primaryKey);

			if (questionContentLink != null) {
				map.put(primaryKey, questionContentLink);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(QuestionContentLinkModelImpl.ENTITY_CACHE_ENABLED,
					QuestionContentLinkImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (QuestionContentLink)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_QUESTIONCONTENTLINK_WHERE_PKS_IN);

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

			for (QuestionContentLink questionContentLink : (List<QuestionContentLink>)q.list()) {
				map.put(questionContentLink.getPrimaryKeyObj(),
					questionContentLink);

				cacheResult(questionContentLink);

				uncachedPrimaryKeys.remove(questionContentLink.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(QuestionContentLinkModelImpl.ENTITY_CACHE_ENABLED,
					QuestionContentLinkImpl.class, primaryKey, nullModel);
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
	 * Returns all the question content links.
	 *
	 * @return the question content links
	 */
	@Override
	public List<QuestionContentLink> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<QuestionContentLink> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<QuestionContentLink> findAll(int start, int end,
		OrderByComparator<QuestionContentLink> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<QuestionContentLink> findAll(int start, int end,
		OrderByComparator<QuestionContentLink> orderByComparator,
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

		List<QuestionContentLink> list = null;

		if (retrieveFromCache) {
			list = (List<QuestionContentLink>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_QUESTIONCONTENTLINK);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_QUESTIONCONTENTLINK;

				if (pagination) {
					sql = sql.concat(QuestionContentLinkModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<QuestionContentLink>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<QuestionContentLink>)QueryUtil.list(q,
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
	 * Removes all the question content links from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (QuestionContentLink questionContentLink : findAll()) {
			remove(questionContentLink);
		}
	}

	/**
	 * Returns the number of question content links.
	 *
	 * @return the number of question content links
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_QUESTIONCONTENTLINK);

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
		return QuestionContentLinkModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the question content link persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(QuestionContentLinkImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_QUESTIONCONTENTLINK = "SELECT questionContentLink FROM QuestionContentLink questionContentLink";
	private static final String _SQL_SELECT_QUESTIONCONTENTLINK_WHERE_PKS_IN = "SELECT questionContentLink FROM QuestionContentLink questionContentLink WHERE questionOrder IN (";
	private static final String _SQL_COUNT_QUESTIONCONTENTLINK = "SELECT COUNT(questionContentLink) FROM QuestionContentLink questionContentLink";
	private static final String _ORDER_BY_ENTITY_ALIAS = "questionContentLink.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No QuestionContentLink exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(QuestionContentLinkPersistenceImpl.class);
}