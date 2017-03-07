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
 * This class is a wrapper for {@link StudentExamLink}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StudentExamLink
 * @generated
 */
@ProviderType
public class StudentExamLinkWrapper implements StudentExamLink,
	ModelWrapper<StudentExamLink> {
	public StudentExamLinkWrapper(StudentExamLink studentExamLink) {
		_studentExamLink = studentExamLink;
	}

	@Override
	public Class<?> getModelClass() {
		return StudentExamLink.class;
	}

	@Override
	public String getModelClassName() {
		return StudentExamLink.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("examRecordId", getExamRecordId());
		attributes.put("studentId", getStudentId());
		attributes.put("inProgress", getInProgress());
		attributes.put("done", getDone());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long examRecordId = (Long)attributes.get("examRecordId");

		if (examRecordId != null) {
			setExamRecordId(examRecordId);
		}

		Long studentId = (Long)attributes.get("studentId");

		if (studentId != null) {
			setStudentId(studentId);
		}

		Boolean inProgress = (Boolean)attributes.get("inProgress");

		if (inProgress != null) {
			setInProgress(inProgress);
		}

		Boolean done = (Boolean)attributes.get("done");

		if (done != null) {
			setDone(done);
		}
	}

	/**
	* Returns the done of this student exam link.
	*
	* @return the done of this student exam link
	*/
	@Override
	public boolean getDone() {
		return _studentExamLink.getDone();
	}

	/**
	* Returns the in progress of this student exam link.
	*
	* @return the in progress of this student exam link
	*/
	@Override
	public boolean getInProgress() {
		return _studentExamLink.getInProgress();
	}

	@Override
	public boolean isCachedModel() {
		return _studentExamLink.isCachedModel();
	}

	/**
	* Returns <code>true</code> if this student exam link is done.
	*
	* @return <code>true</code> if this student exam link is done; <code>false</code> otherwise
	*/
	@Override
	public boolean isDone() {
		return _studentExamLink.isDone();
	}

	@Override
	public boolean isEscapedModel() {
		return _studentExamLink.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this student exam link is in progress.
	*
	* @return <code>true</code> if this student exam link is in progress; <code>false</code> otherwise
	*/
	@Override
	public boolean isInProgress() {
		return _studentExamLink.isInProgress();
	}

	@Override
	public boolean isNew() {
		return _studentExamLink.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _studentExamLink.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<priv.barrow.model.StudentExamLink> toCacheModel() {
		return _studentExamLink.toCacheModel();
	}

	@Override
	public int compareTo(priv.barrow.model.StudentExamLink studentExamLink) {
		return _studentExamLink.compareTo(studentExamLink);
	}

	@Override
	public int hashCode() {
		return _studentExamLink.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _studentExamLink.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new StudentExamLinkWrapper((StudentExamLink)_studentExamLink.clone());
	}

	@Override
	public java.lang.String toString() {
		return _studentExamLink.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _studentExamLink.toXmlString();
	}

	/**
	* Returns the exam record ID of this student exam link.
	*
	* @return the exam record ID of this student exam link
	*/
	@Override
	public long getExamRecordId() {
		return _studentExamLink.getExamRecordId();
	}

	/**
	* Returns the student ID of this student exam link.
	*
	* @return the student ID of this student exam link
	*/
	@Override
	public long getStudentId() {
		return _studentExamLink.getStudentId();
	}

	@Override
	public priv.barrow.model.StudentExamLink toEscapedModel() {
		return new StudentExamLinkWrapper(_studentExamLink.toEscapedModel());
	}

	@Override
	public priv.barrow.model.StudentExamLink toUnescapedModel() {
		return new StudentExamLinkWrapper(_studentExamLink.toUnescapedModel());
	}

	/**
	* Returns the primary key of this student exam link.
	*
	* @return the primary key of this student exam link
	*/
	@Override
	public priv.barrow.service.persistence.StudentExamLinkPK getPrimaryKey() {
		return _studentExamLink.getPrimaryKey();
	}

	@Override
	public void persist() {
		_studentExamLink.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_studentExamLink.setCachedModel(cachedModel);
	}

	/**
	* Sets whether this student exam link is done.
	*
	* @param done the done of this student exam link
	*/
	@Override
	public void setDone(boolean done) {
		_studentExamLink.setDone(done);
	}

	/**
	* Sets the exam record ID of this student exam link.
	*
	* @param examRecordId the exam record ID of this student exam link
	*/
	@Override
	public void setExamRecordId(long examRecordId) {
		_studentExamLink.setExamRecordId(examRecordId);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_studentExamLink.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_studentExamLink.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_studentExamLink.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets whether this student exam link is in progress.
	*
	* @param inProgress the in progress of this student exam link
	*/
	@Override
	public void setInProgress(boolean inProgress) {
		_studentExamLink.setInProgress(inProgress);
	}

	@Override
	public void setNew(boolean n) {
		_studentExamLink.setNew(n);
	}

	/**
	* Sets the primary key of this student exam link.
	*
	* @param primaryKey the primary key of this student exam link
	*/
	@Override
	public void setPrimaryKey(
		priv.barrow.service.persistence.StudentExamLinkPK primaryKey) {
		_studentExamLink.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_studentExamLink.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the student ID of this student exam link.
	*
	* @param studentId the student ID of this student exam link
	*/
	@Override
	public void setStudentId(long studentId) {
		_studentExamLink.setStudentId(studentId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StudentExamLinkWrapper)) {
			return false;
		}

		StudentExamLinkWrapper studentExamLinkWrapper = (StudentExamLinkWrapper)obj;

		if (Objects.equals(_studentExamLink,
					studentExamLinkWrapper._studentExamLink)) {
			return true;
		}

		return false;
	}

	@Override
	public StudentExamLink getWrappedModel() {
		return _studentExamLink;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _studentExamLink.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _studentExamLink.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_studentExamLink.resetOriginalValues();
	}

	private final StudentExamLink _studentExamLink;
}