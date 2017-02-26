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
 * This class is a wrapper for {@link StudentTeacherLink}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StudentTeacherLink
 * @generated
 */
@ProviderType
public class StudentTeacherLinkWrapper implements StudentTeacherLink,
	ModelWrapper<StudentTeacherLink> {
	public StudentTeacherLinkWrapper(StudentTeacherLink studentTeacherLink) {
		_studentTeacherLink = studentTeacherLink;
	}

	@Override
	public Class<?> getModelClass() {
		return StudentTeacherLink.class;
	}

	@Override
	public String getModelClassName() {
		return StudentTeacherLink.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("studentId", getStudentId());
		attributes.put("teacherId", getTeacherId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long studentId = (Long)attributes.get("studentId");

		if (studentId != null) {
			setStudentId(studentId);
		}

		Long teacherId = (Long)attributes.get("teacherId");

		if (teacherId != null) {
			setTeacherId(teacherId);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _studentTeacherLink.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _studentTeacherLink.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _studentTeacherLink.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _studentTeacherLink.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<priv.barrow.model.StudentTeacherLink> toCacheModel() {
		return _studentTeacherLink.toCacheModel();
	}

	@Override
	public int compareTo(
		priv.barrow.model.StudentTeacherLink studentTeacherLink) {
		return _studentTeacherLink.compareTo(studentTeacherLink);
	}

	@Override
	public int hashCode() {
		return _studentTeacherLink.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _studentTeacherLink.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new StudentTeacherLinkWrapper((StudentTeacherLink)_studentTeacherLink.clone());
	}

	@Override
	public java.lang.String toString() {
		return _studentTeacherLink.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _studentTeacherLink.toXmlString();
	}

	/**
	* Returns the primary key of this student teacher link.
	*
	* @return the primary key of this student teacher link
	*/
	@Override
	public long getPrimaryKey() {
		return _studentTeacherLink.getPrimaryKey();
	}

	/**
	* Returns the student ID of this student teacher link.
	*
	* @return the student ID of this student teacher link
	*/
	@Override
	public long getStudentId() {
		return _studentTeacherLink.getStudentId();
	}

	/**
	* Returns the teacher ID of this student teacher link.
	*
	* @return the teacher ID of this student teacher link
	*/
	@Override
	public long getTeacherId() {
		return _studentTeacherLink.getTeacherId();
	}

	@Override
	public priv.barrow.model.StudentTeacherLink toEscapedModel() {
		return new StudentTeacherLinkWrapper(_studentTeacherLink.toEscapedModel());
	}

	@Override
	public priv.barrow.model.StudentTeacherLink toUnescapedModel() {
		return new StudentTeacherLinkWrapper(_studentTeacherLink.toUnescapedModel());
	}

	@Override
	public void persist() {
		_studentTeacherLink.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_studentTeacherLink.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_studentTeacherLink.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_studentTeacherLink.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_studentTeacherLink.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_studentTeacherLink.setNew(n);
	}

	/**
	* Sets the primary key of this student teacher link.
	*
	* @param primaryKey the primary key of this student teacher link
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_studentTeacherLink.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_studentTeacherLink.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the student ID of this student teacher link.
	*
	* @param studentId the student ID of this student teacher link
	*/
	@Override
	public void setStudentId(long studentId) {
		_studentTeacherLink.setStudentId(studentId);
	}

	/**
	* Sets the teacher ID of this student teacher link.
	*
	* @param teacherId the teacher ID of this student teacher link
	*/
	@Override
	public void setTeacherId(long teacherId) {
		_studentTeacherLink.setTeacherId(teacherId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StudentTeacherLinkWrapper)) {
			return false;
		}

		StudentTeacherLinkWrapper studentTeacherLinkWrapper = (StudentTeacherLinkWrapper)obj;

		if (Objects.equals(_studentTeacherLink,
					studentTeacherLinkWrapper._studentTeacherLink)) {
			return true;
		}

		return false;
	}

	@Override
	public StudentTeacherLink getWrappedModel() {
		return _studentTeacherLink;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _studentTeacherLink.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _studentTeacherLink.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_studentTeacherLink.resetOriginalValues();
	}

	private final StudentTeacherLink _studentTeacherLink;
}