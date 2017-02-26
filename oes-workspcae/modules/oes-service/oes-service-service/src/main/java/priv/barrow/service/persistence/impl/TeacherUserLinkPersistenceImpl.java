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

import priv.barrow.exception.NoSuchTeacherUserLinkException;

import priv.barrow.model.TeacherUserLink;
import priv.barrow.model.impl.TeacherUserLinkImpl;
import priv.barrow.model.impl.TeacherUserLinkModelImpl;

import priv.barrow.service.persistence.TeacherUserLinkPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the teacher user link service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TeacherUserLinkPersistence
 * @see priv.barrow.service.persistence.TeacherUserLinkUtil
 * @generated
 */
@ProviderType
public class TeacherUserLinkPersistenceImpl extends BasePersistenceImpl<TeacherUserLink>
	implements TeacherUserLinkPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TeacherUserLinkUtil} to access the teacher user link persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TeacherUserLinkImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TeacherUserLinkModelImpl.ENTITY_CACHE_ENABLED,
			TeacherUserLinkModelImpl.FINDER_CACHE_ENABLED,
			TeacherUserLinkImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TeacherUserLinkModelImpl.ENTITY_CACHE_ENABLED,
			TeacherUserLinkModelImpl.FINDER_CACHE_ENABLED,
			TeacherUserLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TeacherUserLinkModelImpl.ENTITY_CACHE_ENABLED,
			TeacherUserLinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public TeacherUserLinkPersistenceImpl() {
		setModelClass(TeacherUserLink.class);
	}

	/**
	 * Caches the teacher user link in the entity cache if it is enabled.
	 *
	 * @param teacherUserLink the teacher user link
	 */
	@Override
	public void cacheResult(TeacherUserLink teacherUserLink) {
		entityCache.putResult(TeacherUserLinkModelImpl.ENTITY_CACHE_ENABLED,
			TeacherUserLinkImpl.class, teacherUserLink.getPrimaryKey(),
			teacherUserLink);

		teacherUserLink.resetOriginalValues();
	}

	/**
	 * Caches the teacher user links in the entity cache if it is enabled.
	 *
	 * @param teacherUserLinks the teacher user links
	 */
	@Override
	public void cacheResult(List<TeacherUserLink> teacherUserLinks) {
		for (TeacherUserLink teacherUserLink : teacherUserLinks) {
			if (entityCache.getResult(
						TeacherUserLinkModelImpl.ENTITY_CACHE_ENABLED,
						TeacherUserLinkImpl.class,
						teacherUserLink.getPrimaryKey()) == null) {
				cacheResult(teacherUserLink);
			}
			else {
				teacherUserLink.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all teacher user links.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TeacherUserLinkImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the teacher user link.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TeacherUserLink teacherUserLink) {
		entityCache.removeResult(TeacherUserLinkModelImpl.ENTITY_CACHE_ENABLED,
			TeacherUserLinkImpl.class, teacherUserLink.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TeacherUserLink> teacherUserLinks) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TeacherUserLink teacherUserLink : teacherUserLinks) {
			entityCache.removeResult(TeacherUserLinkModelImpl.ENTITY_CACHE_ENABLED,
				TeacherUserLinkImpl.class, teacherUserLink.getPrimaryKey());
		}
	}

	/**
	 * Creates a new teacher user link with the primary key. Does not add the teacher user link to the database.
	 *
	 * @param teacherNumber the primary key for the new teacher user link
	 * @return the new teacher user link
	 */
	@Override
	public TeacherUserLink create(long teacherNumber) {
		TeacherUserLink teacherUserLink = new TeacherUserLinkImpl();

		teacherUserLink.setNew(true);
		teacherUserLink.setPrimaryKey(teacherNumber);

		return teacherUserLink;
	}

	/**
	 * Removes the teacher user link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param teacherNumber the primary key of the teacher user link
	 * @return the teacher user link that was removed
	 * @throws NoSuchTeacherUserLinkException if a teacher user link with the primary key could not be found
	 */
	@Override
	public TeacherUserLink remove(long teacherNumber)
		throws NoSuchTeacherUserLinkException {
		return remove((Serializable)teacherNumber);
	}

	/**
	 * Removes the teacher user link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the teacher user link
	 * @return the teacher user link that was removed
	 * @throws NoSuchTeacherUserLinkException if a teacher user link with the primary key could not be found
	 */
	@Override
	public TeacherUserLink remove(Serializable primaryKey)
		throws NoSuchTeacherUserLinkException {
		Session session = null;

		try {
			session = openSession();

			TeacherUserLink teacherUserLink = (TeacherUserLink)session.get(TeacherUserLinkImpl.class,
					primaryKey);

			if (teacherUserLink == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTeacherUserLinkException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(teacherUserLink);
		}
		catch (NoSuchTeacherUserLinkException nsee) {
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
	protected TeacherUserLink removeImpl(TeacherUserLink teacherUserLink) {
		teacherUserLink = toUnwrappedModel(teacherUserLink);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(teacherUserLink)) {
				teacherUserLink = (TeacherUserLink)session.get(TeacherUserLinkImpl.class,
						teacherUserLink.getPrimaryKeyObj());
			}

			if (teacherUserLink != null) {
				session.delete(teacherUserLink);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (teacherUserLink != null) {
			clearCache(teacherUserLink);
		}

		return teacherUserLink;
	}

	@Override
	public TeacherUserLink updateImpl(TeacherUserLink teacherUserLink) {
		teacherUserLink = toUnwrappedModel(teacherUserLink);

		boolean isNew = teacherUserLink.isNew();

		Session session = null;

		try {
			session = openSession();

			if (teacherUserLink.isNew()) {
				session.save(teacherUserLink);

				teacherUserLink.setNew(false);
			}
			else {
				teacherUserLink = (TeacherUserLink)session.merge(teacherUserLink);
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

		entityCache.putResult(TeacherUserLinkModelImpl.ENTITY_CACHE_ENABLED,
			TeacherUserLinkImpl.class, teacherUserLink.getPrimaryKey(),
			teacherUserLink, false);

		teacherUserLink.resetOriginalValues();

		return teacherUserLink;
	}

	protected TeacherUserLink toUnwrappedModel(TeacherUserLink teacherUserLink) {
		if (teacherUserLink instanceof TeacherUserLinkImpl) {
			return teacherUserLink;
		}

		TeacherUserLinkImpl teacherUserLinkImpl = new TeacherUserLinkImpl();

		teacherUserLinkImpl.setNew(teacherUserLink.isNew());
		teacherUserLinkImpl.setPrimaryKey(teacherUserLink.getPrimaryKey());

		teacherUserLinkImpl.setTeacherNumber(teacherUserLink.getTeacherNumber());
		teacherUserLinkImpl.setUserId(teacherUserLink.getUserId());

		return teacherUserLinkImpl;
	}

	/**
	 * Returns the teacher user link with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the teacher user link
	 * @return the teacher user link
	 * @throws NoSuchTeacherUserLinkException if a teacher user link with the primary key could not be found
	 */
	@Override
	public TeacherUserLink findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTeacherUserLinkException {
		TeacherUserLink teacherUserLink = fetchByPrimaryKey(primaryKey);

		if (teacherUserLink == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTeacherUserLinkException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return teacherUserLink;
	}

	/**
	 * Returns the teacher user link with the primary key or throws a {@link NoSuchTeacherUserLinkException} if it could not be found.
	 *
	 * @param teacherNumber the primary key of the teacher user link
	 * @return the teacher user link
	 * @throws NoSuchTeacherUserLinkException if a teacher user link with the primary key could not be found
	 */
	@Override
	public TeacherUserLink findByPrimaryKey(long teacherNumber)
		throws NoSuchTeacherUserLinkException {
		return findByPrimaryKey((Serializable)teacherNumber);
	}

	/**
	 * Returns the teacher user link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the teacher user link
	 * @return the teacher user link, or <code>null</code> if a teacher user link with the primary key could not be found
	 */
	@Override
	public TeacherUserLink fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(TeacherUserLinkModelImpl.ENTITY_CACHE_ENABLED,
				TeacherUserLinkImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		TeacherUserLink teacherUserLink = (TeacherUserLink)serializable;

		if (teacherUserLink == null) {
			Session session = null;

			try {
				session = openSession();

				teacherUserLink = (TeacherUserLink)session.get(TeacherUserLinkImpl.class,
						primaryKey);

				if (teacherUserLink != null) {
					cacheResult(teacherUserLink);
				}
				else {
					entityCache.putResult(TeacherUserLinkModelImpl.ENTITY_CACHE_ENABLED,
						TeacherUserLinkImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(TeacherUserLinkModelImpl.ENTITY_CACHE_ENABLED,
					TeacherUserLinkImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return teacherUserLink;
	}

	/**
	 * Returns the teacher user link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param teacherNumber the primary key of the teacher user link
	 * @return the teacher user link, or <code>null</code> if a teacher user link with the primary key could not be found
	 */
	@Override
	public TeacherUserLink fetchByPrimaryKey(long teacherNumber) {
		return fetchByPrimaryKey((Serializable)teacherNumber);
	}

	@Override
	public Map<Serializable, TeacherUserLink> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, TeacherUserLink> map = new HashMap<Serializable, TeacherUserLink>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			TeacherUserLink teacherUserLink = fetchByPrimaryKey(primaryKey);

			if (teacherUserLink != null) {
				map.put(primaryKey, teacherUserLink);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(TeacherUserLinkModelImpl.ENTITY_CACHE_ENABLED,
					TeacherUserLinkImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (TeacherUserLink)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_TEACHERUSERLINK_WHERE_PKS_IN);

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

			for (TeacherUserLink teacherUserLink : (List<TeacherUserLink>)q.list()) {
				map.put(teacherUserLink.getPrimaryKeyObj(), teacherUserLink);

				cacheResult(teacherUserLink);

				uncachedPrimaryKeys.remove(teacherUserLink.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(TeacherUserLinkModelImpl.ENTITY_CACHE_ENABLED,
					TeacherUserLinkImpl.class, primaryKey, nullModel);
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
	 * Returns all the teacher user links.
	 *
	 * @return the teacher user links
	 */
	@Override
	public List<TeacherUserLink> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the teacher user links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TeacherUserLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of teacher user links
	 * @param end the upper bound of the range of teacher user links (not inclusive)
	 * @return the range of teacher user links
	 */
	@Override
	public List<TeacherUserLink> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the teacher user links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TeacherUserLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of teacher user links
	 * @param end the upper bound of the range of teacher user links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of teacher user links
	 */
	@Override
	public List<TeacherUserLink> findAll(int start, int end,
		OrderByComparator<TeacherUserLink> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the teacher user links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TeacherUserLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of teacher user links
	 * @param end the upper bound of the range of teacher user links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of teacher user links
	 */
	@Override
	public List<TeacherUserLink> findAll(int start, int end,
		OrderByComparator<TeacherUserLink> orderByComparator,
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

		List<TeacherUserLink> list = null;

		if (retrieveFromCache) {
			list = (List<TeacherUserLink>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_TEACHERUSERLINK);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TEACHERUSERLINK;

				if (pagination) {
					sql = sql.concat(TeacherUserLinkModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TeacherUserLink>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TeacherUserLink>)QueryUtil.list(q,
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
	 * Removes all the teacher user links from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TeacherUserLink teacherUserLink : findAll()) {
			remove(teacherUserLink);
		}
	}

	/**
	 * Returns the number of teacher user links.
	 *
	 * @return the number of teacher user links
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TEACHERUSERLINK);

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
		return TeacherUserLinkModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the teacher user link persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(TeacherUserLinkImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_TEACHERUSERLINK = "SELECT teacherUserLink FROM TeacherUserLink teacherUserLink";
	private static final String _SQL_SELECT_TEACHERUSERLINK_WHERE_PKS_IN = "SELECT teacherUserLink FROM TeacherUserLink teacherUserLink WHERE teacherNumber IN (";
	private static final String _SQL_COUNT_TEACHERUSERLINK = "SELECT COUNT(teacherUserLink) FROM TeacherUserLink teacherUserLink";
	private static final String _ORDER_BY_ENTITY_ALIAS = "teacherUserLink.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TeacherUserLink exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(TeacherUserLinkPersistenceImpl.class);
}