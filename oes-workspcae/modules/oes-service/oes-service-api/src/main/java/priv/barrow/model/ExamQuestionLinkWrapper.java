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
 * This class is a wrapper for {@link ExamQuestionLink}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ExamQuestionLink
 * @generated
 */
@ProviderType
public class ExamQuestionLinkWrapper implements ExamQuestionLink,
	ModelWrapper<ExamQuestionLink> {
	public ExamQuestionLinkWrapper(ExamQuestionLink examQuestionLink) {
		_examQuestionLink = examQuestionLink;
	}

	@Override
	public Class<?> getModelClass() {
		return ExamQuestionLink.class;
	}

	@Override
	public String getModelClassName() {
		return ExamQuestionLink.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("examRecordId", getExamRecordId());
		attributes.put("questionRecordId", getQuestionRecordId());
		attributes.put("questionRecordVersion", getQuestionRecordVersion());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long examRecordId = (Long)attributes.get("examRecordId");

		if (examRecordId != null) {
			setExamRecordId(examRecordId);
		}

		Long questionRecordId = (Long)attributes.get("questionRecordId");

		if (questionRecordId != null) {
			setQuestionRecordId(questionRecordId);
		}

		String questionRecordVersion = (String)attributes.get(
				"questionRecordVersion");

		if (questionRecordVersion != null) {
			setQuestionRecordVersion(questionRecordVersion);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _examQuestionLink.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _examQuestionLink.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _examQuestionLink.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _examQuestionLink.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<priv.barrow.model.ExamQuestionLink> toCacheModel() {
		return _examQuestionLink.toCacheModel();
	}

	@Override
	public int compareTo(priv.barrow.model.ExamQuestionLink examQuestionLink) {
		return _examQuestionLink.compareTo(examQuestionLink);
	}

	@Override
	public int hashCode() {
		return _examQuestionLink.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _examQuestionLink.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new ExamQuestionLinkWrapper((ExamQuestionLink)_examQuestionLink.clone());
	}

	/**
	* Returns the question record version of this exam question link.
	*
	* @return the question record version of this exam question link
	*/
	@Override
	public java.lang.String getQuestionRecordVersion() {
		return _examQuestionLink.getQuestionRecordVersion();
	}

	@Override
	public java.lang.String toString() {
		return _examQuestionLink.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _examQuestionLink.toXmlString();
	}

	/**
	* Returns the exam record ID of this exam question link.
	*
	* @return the exam record ID of this exam question link
	*/
	@Override
	public long getExamRecordId() {
		return _examQuestionLink.getExamRecordId();
	}

	/**
	* Returns the question record ID of this exam question link.
	*
	* @return the question record ID of this exam question link
	*/
	@Override
	public long getQuestionRecordId() {
		return _examQuestionLink.getQuestionRecordId();
	}

	@Override
	public priv.barrow.model.ExamQuestionLink toEscapedModel() {
		return new ExamQuestionLinkWrapper(_examQuestionLink.toEscapedModel());
	}

	@Override
	public priv.barrow.model.ExamQuestionLink toUnescapedModel() {
		return new ExamQuestionLinkWrapper(_examQuestionLink.toUnescapedModel());
	}

	/**
	* Returns the primary key of this exam question link.
	*
	* @return the primary key of this exam question link
	*/
	@Override
	public priv.barrow.service.persistence.ExamQuestionLinkPK getPrimaryKey() {
		return _examQuestionLink.getPrimaryKey();
	}

	@Override
	public void persist() {
		_examQuestionLink.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_examQuestionLink.setCachedModel(cachedModel);
	}

	/**
	* Sets the exam record ID of this exam question link.
	*
	* @param examRecordId the exam record ID of this exam question link
	*/
	@Override
	public void setExamRecordId(long examRecordId) {
		_examQuestionLink.setExamRecordId(examRecordId);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_examQuestionLink.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_examQuestionLink.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_examQuestionLink.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_examQuestionLink.setNew(n);
	}

	/**
	* Sets the primary key of this exam question link.
	*
	* @param primaryKey the primary key of this exam question link
	*/
	@Override
	public void setPrimaryKey(
		priv.barrow.service.persistence.ExamQuestionLinkPK primaryKey) {
		_examQuestionLink.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_examQuestionLink.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the question record ID of this exam question link.
	*
	* @param questionRecordId the question record ID of this exam question link
	*/
	@Override
	public void setQuestionRecordId(long questionRecordId) {
		_examQuestionLink.setQuestionRecordId(questionRecordId);
	}

	/**
	* Sets the question record version of this exam question link.
	*
	* @param questionRecordVersion the question record version of this exam question link
	*/
	@Override
	public void setQuestionRecordVersion(java.lang.String questionRecordVersion) {
		_examQuestionLink.setQuestionRecordVersion(questionRecordVersion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ExamQuestionLinkWrapper)) {
			return false;
		}

		ExamQuestionLinkWrapper examQuestionLinkWrapper = (ExamQuestionLinkWrapper)obj;

		if (Objects.equals(_examQuestionLink,
					examQuestionLinkWrapper._examQuestionLink)) {
			return true;
		}

		return false;
	}

	@Override
	public ExamQuestionLink getWrappedModel() {
		return _examQuestionLink;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _examQuestionLink.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _examQuestionLink.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_examQuestionLink.resetOriginalValues();
	}

	private final ExamQuestionLink _examQuestionLink;
}