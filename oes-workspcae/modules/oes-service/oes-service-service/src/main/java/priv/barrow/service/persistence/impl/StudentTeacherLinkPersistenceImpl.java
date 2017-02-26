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

import priv.barrow.exception.NoSuchStudentTeacherLinkException;

import priv.barrow.model.StudentTeacherLink;
import priv.barrow.model.impl.StudentTeacherLinkImpl;
import priv.barrow.model.impl.StudentTeacherLinkModelImpl;

import priv.barrow.service.persistence.StudentTeacherLinkPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the student teacher link service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StudentTeacherLinkPersistence
 * @see priv.barrow.service.persistence.StudentTeacherLinkUtil
 * @generated
 */
@ProviderType
public class StudentTeacherLinkPersistenceImpl extends BasePersistenceImpl<StudentTeacherLink>
	implements StudentTeacherLinkPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StudentTeacherLinkUtil} to access the student teacher link persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StudentTeacherLinkImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StudentTeacherLinkModelImpl.ENTITY_CACHE_ENABLED,
			StudentTeacherLinkModelImpl.FINDER_CACHE_ENABLED,
			StudentTeacherLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StudentTeacherLinkModelImpl.ENTITY_CACHE_ENABLED,
			StudentTeacherLinkModelImpl.FINDER_CACHE_ENABLED,
			StudentTeacherLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StudentTeacherLinkModelImpl.ENTITY_CACHE_ENABLED,
			StudentTeacherLinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TEACHERID =
		new FinderPath(StudentTeacherLinkModelImpl.ENTITY_CACHE_ENABLED,
			StudentTeacherLinkModelImpl.FINDER_CACHE_ENABLED,
			StudentTeacherLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByteacherId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEACHERID =
		new FinderPath(StudentTeacherLinkModelImpl.ENTITY_CACHE_ENABLED,
			StudentTeacherLinkModelImpl.FINDER_CACHE_ENABLED,
			StudentTeacherLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByteacherId",
			new String[] { Long.class.getName() },
			StudentTeacherLinkModelImpl.STUDENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TEACHERID = new FinderPath(StudentTeacherLinkModelImpl.ENTITY_CACHE_ENABLED,
			StudentTeacherLinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByteacherId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the student teacher links where studentId = &#63;.
	 *
	 * @param studentId the student ID
	 * @return the matching student teacher links
	 */
	@Override
	public List<StudentTeacherLink> findByteacherId(long studentId) {
		return findByteacherId(studentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the student teacher links where studentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StudentTeacherLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param studentId the student ID
	 * @param start the lower bound of the range of student teacher links
	 * @param end the upper bound of the range of student teacher links (not inclusive)
	 * @return the range of matching student teacher links
	 */
	@Override
	public List<StudentTeacherLink> findByteacherId(long studentId, int start,
		int end) {
		return findByteacherId(studentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the student teacher links where studentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StudentTeacherLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param studentId the student ID
	 * @param start the lower bound of the range of student teacher links
	 * @param end the upper bound of the range of student teacher links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching student teacher links
	 */
	@Override
	public List<StudentTeacherLink> findByteacherId(long studentId, int start,
		int end, OrderByComparator<StudentTeacherLink> orderByComparator) {
		return findByteacherId(studentId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the student teacher links where studentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StudentTeacherLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param studentId the student ID
	 * @param start the lower bound of the range of student teacher links
	 * @param end the upper bound of the range of student teacher links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching student teacher links
	 */
	@Override
	public List<StudentTeacherLink> findByteacherId(long studentId, int start,
		int end, OrderByComparator<StudentTeacherLink> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEACHERID;
			finderArgs = new Object[] { studentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TEACHERID;
			finderArgs = new Object[] { studentId, start, end, orderByComparator };
		}

		List<StudentTeacherLink> list = null;

		if (retrieveFromCache) {
			list = (List<StudentTeacherLink>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (StudentTeacherLink studentTeacherLink : list) {
					if ((studentId != studentTeacherLink.getStudentId())) {
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

			query.append(_SQL_SELECT_STUDENTTEACHERLINK_WHERE);

			query.append(_FINDER_COLUMN_TEACHERID_STUDENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StudentTeacherLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(studentId);

				if (!pagination) {
					list = (List<StudentTeacherLink>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<StudentTeacherLink>)QueryUtil.list(q,
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
	 * Returns the first student teacher link in the ordered set where studentId = &#63;.
	 *
	 * @param studentId the student ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student teacher link
	 * @throws NoSuchStudentTeacherLinkException if a matching student teacher link could not be found
	 */
	@Override
	public StudentTeacherLink findByteacherId_First(long studentId,
		OrderByComparator<StudentTeacherLink> orderByComparator)
		throws NoSuchStudentTeacherLinkException {
		StudentTeacherLink studentTeacherLink = fetchByteacherId_First(studentId,
				orderByComparator);

		if (studentTeacherLink != null) {
			return studentTeacherLink;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("studentId=");
		msg.append(studentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStudentTeacherLinkException(msg.toString());
	}

	/**
	 * Returns the first student teacher link in the ordered set where studentId = &#63;.
	 *
	 * @param studentId the student ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student teacher link, or <code>null</code> if a matching student teacher link could not be found
	 */
	@Override
	public StudentTeacherLink fetchByteacherId_First(long studentId,
		OrderByComparator<StudentTeacherLink> orderByComparator) {
		List<StudentTeacherLink> list = findByteacherId(studentId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last student teacher link in the ordered set where studentId = &#63;.
	 *
	 * @param studentId the student ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student teacher link
	 * @throws NoSuchStudentTeacherLinkException if a matching student teacher link could not be found
	 */
	@Override
	public StudentTeacherLink findByteacherId_Last(long studentId,
		OrderByComparator<StudentTeacherLink> orderByComparator)
		throws NoSuchStudentTeacherLinkException {
		StudentTeacherLink studentTeacherLink = fetchByteacherId_Last(studentId,
				orderByComparator);

		if (studentTeacherLink != null) {
			return studentTeacherLink;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("studentId=");
		msg.append(studentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStudentTeacherLinkException(msg.toString());
	}

	/**
	 * Returns the last student teacher link in the ordered set where studentId = &#63;.
	 *
	 * @param studentId the student ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student teacher link, or <code>null</code> if a matching student teacher link could not be found
	 */
	@Override
	public StudentTeacherLink fetchByteacherId_Last(long studentId,
		OrderByComparator<StudentTeacherLink> orderByComparator) {
		int count = countByteacherId(studentId);

		if (count == 0) {
			return null;
		}

		List<StudentTeacherLink> list = findByteacherId(studentId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the student teacher links where studentId = &#63; from the database.
	 *
	 * @param studentId the student ID
	 */
	@Override
	public void removeByteacherId(long studentId) {
		for (StudentTeacherLink studentTeacherLink : findByteacherId(
				studentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(studentTeacherLink);
		}
	}

	/**
	 * Returns the number of student teacher links where studentId = &#63;.
	 *
	 * @param studentId the student ID
	 * @return the number of matching student teacher links
	 */
	@Override
	public int countByteacherId(long studentId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TEACHERID;

		Object[] finderArgs = new Object[] { studentId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STUDENTTEACHERLINK_WHERE);

			query.append(_FINDER_COLUMN_TEACHERID_STUDENTID_2);

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

	private static final String _FINDER_COLUMN_TEACHERID_STUDENTID_2 = "studentTeacherLink.studentId = ?";

	public StudentTeacherLinkPersistenceImpl() {
		setModelClass(StudentTeacherLink.class);
	}

	/**
	 * Caches the student teacher link in the entity cache if it is enabled.
	 *
	 * @param studentTeacherLink the student teacher link
	 */
	@Override
	public void cacheResult(StudentTeacherLink studentTeacherLink) {
		entityCache.putResult(StudentTeacherLinkModelImpl.ENTITY_CACHE_ENABLED,
			StudentTeacherLinkImpl.class, studentTeacherLink.getPrimaryKey(),
			studentTeacherLink);

		studentTeacherLink.resetOriginalValues();
	}

	/**
	 * Caches the student teacher links in the entity cache if it is enabled.
	 *
	 * @param studentTeacherLinks the student teacher links
	 */
	@Override
	public void cacheResult(List<StudentTeacherLink> studentTeacherLinks) {
		for (StudentTeacherLink studentTeacherLink : studentTeacherLinks) {
			if (entityCache.getResult(
						StudentTeacherLinkModelImpl.ENTITY_CACHE_ENABLED,
						StudentTeacherLinkImpl.class,
						studentTeacherLink.getPrimaryKey()) == null) {
				cacheResult(studentTeacherLink);
			}
			else {
				studentTeacherLink.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all student teacher links.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(StudentTeacherLinkImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the student teacher link.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StudentTeacherLink studentTeacherLink) {
		entityCache.removeResult(StudentTeacherLinkModelImpl.ENTITY_CACHE_ENABLED,
			StudentTeacherLinkImpl.class, studentTeacherLink.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<StudentTeacherLink> studentTeacherLinks) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StudentTeacherLink studentTeacherLink : studentTeacherLinks) {
			entityCache.removeResult(StudentTeacherLinkModelImpl.ENTITY_CACHE_ENABLED,
				StudentTeacherLinkImpl.class, studentTeacherLink.getPrimaryKey());
		}
	}

	/**
	 * Creates a new student teacher link with the primary key. Does not add the student teacher link to the database.
	 *
	 * @param studentId the primary key for the new student teacher link
	 * @return the new student teacher link
	 */
	@Override
	public StudentTeacherLink create(long studentId) {
		StudentTeacherLink studentTeacherLink = new StudentTeacherLinkImpl();

		studentTeacherLink.setNew(true);
		studentTeacherLink.setPrimaryKey(studentId);

		return studentTeacherLink;
	}

	/**
	 * Removes the student teacher link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param studentId the primary key of the student teacher link
	 * @return the student teacher link that was removed
	 * @throws NoSuchStudentTeacherLinkException if a student teacher link with the primary key could not be found
	 */
	@Override
	public StudentTeacherLink remove(long studentId)
		throws NoSuchStudentTeacherLinkException {
		return remove((Serializable)studentId);
	}

	/**
	 * Removes the student teacher link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the student teacher link
	 * @return the student teacher link that was removed
	 * @throws NoSuchStudentTeacherLinkException if a student teacher link with the primary key could not be found
	 */
	@Override
	public StudentTeacherLink remove(Serializable primaryKey)
		throws NoSuchStudentTeacherLinkException {
		Session session = null;

		try {
			session = openSession();

			StudentTeacherLink studentTeacherLink = (StudentTeacherLink)session.get(StudentTeacherLinkImpl.class,
					primaryKey);

			if (studentTeacherLink == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStudentTeacherLinkException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(studentTeacherLink);
		}
		catch (NoSuchStudentTeacherLinkException nsee) {
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
	protected StudentTeacherLink removeImpl(
		StudentTeacherLink studentTeacherLink) {
		studentTeacherLink = toUnwrappedModel(studentTeacherLink);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(studentTeacherLink)) {
				studentTeacherLink = (StudentTeacherLink)session.get(StudentTeacherLinkImpl.class,
						studentTeacherLink.getPrimaryKeyObj());
			}

			if (studentTeacherLink != null) {
				session.delete(studentTeacherLink);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (studentTeacherLink != null) {
			clearCache(studentTeacherLink);
		}

		return studentTeacherLink;
	}

	@Override
	public StudentTeacherLink updateImpl(StudentTeacherLink studentTeacherLink) {
		studentTeacherLink = toUnwrappedModel(studentTeacherLink);

		boolean isNew = studentTeacherLink.isNew();

		StudentTeacherLinkModelImpl studentTeacherLinkModelImpl = (StudentTeacherLinkModelImpl)studentTeacherLink;

		Session session = null;

		try {
			session = openSession();

			if (studentTeacherLink.isNew()) {
				session.save(studentTeacherLink);

				studentTeacherLink.setNew(false);
			}
			else {
				studentTeacherLink = (StudentTeacherLink)session.merge(studentTeacherLink);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !StudentTeacherLinkModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((studentTeacherLinkModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEACHERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						studentTeacherLinkModelImpl.getOriginalStudentId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_TEACHERID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEACHERID,
					args);

				args = new Object[] { studentTeacherLinkModelImpl.getStudentId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_TEACHERID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEACHERID,
					args);
			}
		}

		entityCache.putResult(StudentTeacherLinkModelImpl.ENTITY_CACHE_ENABLED,
			StudentTeacherLinkImpl.class, studentTeacherLink.getPrimaryKey(),
			studentTeacherLink, false);

		studentTeacherLink.resetOriginalValues();

		return studentTeacherLink;
	}

	protected StudentTeacherLink toUnwrappedModel(
		StudentTeacherLink studentTeacherLink) {
		if (studentTeacherLink instanceof StudentTeacherLinkImpl) {
			return studentTeacherLink;
		}

		StudentTeacherLinkImpl studentTeacherLinkImpl = new StudentTeacherLinkImpl();

		studentTeacherLinkImpl.setNew(studentTeacherLink.isNew());
		studentTeacherLinkImpl.setPrimaryKey(studentTeacherLink.getPrimaryKey());

		studentTeacherLinkImpl.setStudentId(studentTeacherLink.getStudentId());
		studentTeacherLinkImpl.setTeacherId(studentTeacherLink.getTeacherId());

		return studentTeacherLinkImpl;
	}

	/**
	 * Returns the student teacher link with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the student teacher link
	 * @return the student teacher link
	 * @throws NoSuchStudentTeacherLinkException if a student teacher link with the primary key could not be found
	 */
	@Override
	public StudentTeacherLink findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStudentTeacherLinkException {
		StudentTeacherLink studentTeacherLink = fetchByPrimaryKey(primaryKey);

		if (studentTeacherLink == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStudentTeacherLinkException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return studentTeacherLink;
	}

	/**
	 * Returns the student teacher link with the primary key or throws a {@link NoSuchStudentTeacherLinkException} if it could not be found.
	 *
	 * @param studentId the primary key of the student teacher link
	 * @return the student teacher link
	 * @throws NoSuchStudentTeacherLinkException if a student teacher link with the primary key could not be found
	 */
	@Override
	public StudentTeacherLink findByPrimaryKey(long studentId)
		throws NoSuchStudentTeacherLinkException {
		return findByPrimaryKey((Serializable)studentId);
	}

	/**
	 * Returns the student teacher link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the student teacher link
	 * @return the student teacher link, or <code>null</code> if a student teacher link with the primary key could not be found
	 */
	@Override
	public StudentTeacherLink fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(StudentTeacherLinkModelImpl.ENTITY_CACHE_ENABLED,
				StudentTeacherLinkImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		StudentTeacherLink studentTeacherLink = (StudentTeacherLink)serializable;

		if (studentTeacherLink == null) {
			Session session = null;

			try {
				session = openSession();

				studentTeacherLink = (StudentTeacherLink)session.get(StudentTeacherLinkImpl.class,
						primaryKey);

				if (studentTeacherLink != null) {
					cacheResult(studentTeacherLink);
				}
				else {
					entityCache.putResult(StudentTeacherLinkModelImpl.ENTITY_CACHE_ENABLED,
						StudentTeacherLinkImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(StudentTeacherLinkModelImpl.ENTITY_CACHE_ENABLED,
					StudentTeacherLinkImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return studentTeacherLink;
	}

	/**
	 * Returns the student teacher link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param studentId the primary key of the student teacher link
	 * @return the student teacher link, or <code>null</code> if a student teacher link with the primary key could not be found
	 */
	@Override
	public StudentTeacherLink fetchByPrimaryKey(long studentId) {
		return fetchByPrimaryKey((Serializable)studentId);
	}

	@Override
	public Map<Serializable, StudentTeacherLink> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, StudentTeacherLink> map = new HashMap<Serializable, StudentTeacherLink>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			StudentTeacherLink studentTeacherLink = fetchByPrimaryKey(primaryKey);

			if (studentTeacherLink != null) {
				map.put(primaryKey, studentTeacherLink);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(StudentTeacherLinkModelImpl.ENTITY_CACHE_ENABLED,
					StudentTeacherLinkImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (StudentTeacherLink)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_STUDENTTEACHERLINK_WHERE_PKS_IN);

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

			for (StudentTeacherLink studentTeacherLink : (List<StudentTeacherLink>)q.list()) {
				map.put(studentTeacherLink.getPrimaryKeyObj(),
					studentTeacherLink);

				cacheResult(studentTeacherLink);

				uncachedPrimaryKeys.remove(studentTeacherLink.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(StudentTeacherLinkModelImpl.ENTITY_CACHE_ENABLED,
					StudentTeacherLinkImpl.class, primaryKey, nullModel);
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
	 * Returns all the student teacher links.
	 *
	 * @return the student teacher links
	 */
	@Override
	public List<StudentTeacherLink> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the student teacher links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StudentTeacherLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of student teacher links
	 * @param end the upper bound of the range of student teacher links (not inclusive)
	 * @return the range of student teacher links
	 */
	@Override
	public List<StudentTeacherLink> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the student teacher links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StudentTeacherLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of student teacher links
	 * @param end the upper bound of the range of student teacher links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of student teacher links
	 */
	@Override
	public List<StudentTeacherLink> findAll(int start, int end,
		OrderByComparator<StudentTeacherLink> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the student teacher links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StudentTeacherLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of student teacher links
	 * @param end the upper bound of the range of student teacher links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of student teacher links
	 */
	@Override
	public List<StudentTeacherLink> findAll(int start, int end,
		OrderByComparator<StudentTeacherLink> orderByComparator,
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

		List<StudentTeacherLink> list = null;

		if (retrieveFromCache) {
			list = (List<StudentTeacherLink>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_STUDENTTEACHERLINK);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STUDENTTEACHERLINK;

				if (pagination) {
					sql = sql.concat(StudentTeacherLinkModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<StudentTeacherLink>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<StudentTeacherLink>)QueryUtil.list(q,
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
	 * Removes all the student teacher links from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (StudentTeacherLink studentTeacherLink : findAll()) {
			remove(studentTeacherLink);
		}
	}

	/**
	 * Returns the number of student teacher links.
	 *
	 * @return the number of student teacher links
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_STUDENTTEACHERLINK);

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
		return StudentTeacherLinkModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the student teacher link persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(StudentTeacherLinkImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_STUDENTTEACHERLINK = "SELECT studentTeacherLink FROM StudentTeacherLink studentTeacherLink";
	private static final String _SQL_SELECT_STUDENTTEACHERLINK_WHERE_PKS_IN = "SELECT studentTeacherLink FROM StudentTeacherLink studentTeacherLink WHERE studentId IN (";
	private static final String _SQL_SELECT_STUDENTTEACHERLINK_WHERE = "SELECT studentTeacherLink FROM StudentTeacherLink studentTeacherLink WHERE ";
	private static final String _SQL_COUNT_STUDENTTEACHERLINK = "SELECT COUNT(studentTeacherLink) FROM StudentTeacherLink studentTeacherLink";
	private static final String _SQL_COUNT_STUDENTTEACHERLINK_WHERE = "SELECT COUNT(studentTeacherLink) FROM StudentTeacherLink studentTeacherLink WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "studentTeacherLink.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No StudentTeacherLink exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No StudentTeacherLink exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(StudentTeacherLinkPersistenceImpl.class);
}