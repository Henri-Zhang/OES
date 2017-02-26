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

package priv.barrow.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link TeacherUserLink}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TeacherUserLink
 * @generated
 */
@ProviderType
public class TeacherUserLinkWrapper implements TeacherUserLink,
	ModelWrapper<TeacherUserLink> {
	public TeacherUserLinkWrapper(TeacherUserLink teacherUserLink) {
		_teacherUserLink = teacherUserLink;
	}

	@Override
	public Class<?> getModelClass() {
		return TeacherUserLink.class;
	}

	@Override
	public String getModelClassName() {
		return TeacherUserLink.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("teacherNumber", getTeacherNumber());
		attributes.put("userId", getUserId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long teacherNumber = (Long)attributes.get("teacherNumber");

		if (teacherNumber != null) {
			setTeacherNumber(teacherNumber);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _teacherUserLink.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _teacherUserLink.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _teacherUserLink.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _teacherUserLink.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<priv.barrow.model.TeacherUserLink> toCacheModel() {
		return _teacherUserLink.toCacheModel();
	}

	@Override
	public int compareTo(priv.barrow.model.TeacherUserLink teacherUserLink) {
		return _teacherUserLink.compareTo(teacherUserLink);
	}

	@Override
	public int hashCode() {
		return _teacherUserLink.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _teacherUserLink.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new TeacherUserLinkWrapper((TeacherUserLink)_teacherUserLink.clone());
	}

	/**
	* Returns the user uuid of this teacher user link.
	*
	* @return the user uuid of this teacher user link
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _teacherUserLink.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _teacherUserLink.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _teacherUserLink.toXmlString();
	}

	/**
	* Returns the primary key of this teacher user link.
	*
	* @return the primary key of this teacher user link
	*/
	@Override
	public long getPrimaryKey() {
		return _teacherUserLink.getPrimaryKey();
	}

	/**
	* Returns the teacher number of this teacher user link.
	*
	* @return the teacher number of this teacher user link
	*/
	@Override
	public long getTeacherNumber() {
		return _teacherUserLink.getTeacherNumber();
	}

	/**
	* Returns the user ID of this teacher user link.
	*
	* @return the user ID of this teacher user link
	*/
	@Override
	public long getUserId() {
		return _teacherUserLink.getUserId();
	}

	@Override
	public priv.barrow.model.TeacherUserLink toEscapedModel() {
		return new TeacherUserLinkWrapper(_teacherUserLink.toEscapedModel());
	}

	@Override
	public priv.barrow.model.TeacherUserLink toUnescapedModel() {
		return new TeacherUserLinkWrapper(_teacherUserLink.toUnescapedModel());
	}

	@Override
	public void persist() {
		_teacherUserLink.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_teacherUserLink.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_teacherUserLink.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_teacherUserLink.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_teacherUserLink.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_teacherUserLink.setNew(n);
	}

	/**
	* Sets the primary key of this teacher user link.
	*
	* @param primaryKey the primary key of this teacher user link
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_teacherUserLink.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_teacherUserLink.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the teacher number of this teacher user link.
	*
	* @param teacherNumber the teacher number of this teacher user link
	*/
	@Override
	public void setTeacherNumber(long teacherNumber) {
		_teacherUserLink.setTeacherNumber(teacherNumber);
	}

	/**
	* Sets the user ID of this teacher user link.
	*
	* @param userId the user ID of this teacher user link
	*/
	@Override
	public void setUserId(long userId) {
		_teacherUserLink.setUserId(userId);
	}

	/**
	* Sets the user uuid of this teacher user link.
	*
	* @param userUuid the user uuid of this teacher user link
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_teacherUserLink.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TeacherUserLinkWrapper)) {
			return false;
		}

		TeacherUserLinkWrapper teacherUserLinkWrapper = (TeacherUserLinkWrapper)obj;

		if (Objects.equals(_teacherUserLink,
					teacherUserLinkWrapper._teacherUserLink)) {
			return true;
		}

		return false;
	}

	@Override
	public TeacherUserLink getWrappedModel() {
		return _teacherUserLink;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _teacherUserLink.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _teacherUserLink.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_teacherUserLink.resetOriginalValues();
	}

	private final TeacherUserLink _teacherUserLink;
}