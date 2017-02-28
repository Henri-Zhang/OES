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
 * This class is a wrapper for {@link QuestionRecordLink}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuestionRecordLink
 * @generated
 */
@ProviderType
public class QuestionRecordLinkWrapper implements QuestionRecordLink,
	ModelWrapper<QuestionRecordLink> {
	public QuestionRecordLinkWrapper(QuestionRecordLink questionRecordLink) {
		_questionRecordLink = questionRecordLink;
	}

	@Override
	public Class<?> getModelClass() {
		return QuestionRecordLink.class;
	}

	@Override
	public String getModelClassName() {
		return QuestionRecordLink.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("questionOrder", getQuestionOrder());
		attributes.put("ddlRecordId", getDdlRecordId());
		attributes.put("active", getActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long questionOrder = (Long)attributes.get("questionOrder");

		if (questionOrder != null) {
			setQuestionOrder(questionOrder);
		}

		Long ddlRecordId = (Long)attributes.get("ddlRecordId");

		if (ddlRecordId != null) {
			setDdlRecordId(ddlRecordId);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}
	}

	/**
	* Returns the active of this question record link.
	*
	* @return the active of this question record link
	*/
	@Override
	public boolean getActive() {
		return _questionRecordLink.getActive();
	}

	/**
	* Returns <code>true</code> if this question record link is active.
	*
	* @return <code>true</code> if this question record link is active; <code>false</code> otherwise
	*/
	@Override
	public boolean isActive() {
		return _questionRecordLink.isActive();
	}

	@Override
	public boolean isCachedModel() {
		return _questionRecordLink.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _questionRecordLink.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _questionRecordLink.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _questionRecordLink.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<priv.barrow.model.QuestionRecordLink> toCacheModel() {
		return _questionRecordLink.toCacheModel();
	}

	@Override
	public int compareTo(
		priv.barrow.model.QuestionRecordLink questionRecordLink) {
		return _questionRecordLink.compareTo(questionRecordLink);
	}

	@Override
	public int hashCode() {
		return _questionRecordLink.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _questionRecordLink.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new QuestionRecordLinkWrapper((QuestionRecordLink)_questionRecordLink.clone());
	}

	@Override
	public java.lang.String toString() {
		return _questionRecordLink.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _questionRecordLink.toXmlString();
	}

	/**
	* Returns the ddl record ID of this question record link.
	*
	* @return the ddl record ID of this question record link
	*/
	@Override
	public long getDdlRecordId() {
		return _questionRecordLink.getDdlRecordId();
	}

	/**
	* Returns the primary key of this question record link.
	*
	* @return the primary key of this question record link
	*/
	@Override
	public long getPrimaryKey() {
		return _questionRecordLink.getPrimaryKey();
	}

	/**
	* Returns the question order of this question record link.
	*
	* @return the question order of this question record link
	*/
	@Override
	public long getQuestionOrder() {
		return _questionRecordLink.getQuestionOrder();
	}

	@Override
	public priv.barrow.model.QuestionRecordLink toEscapedModel() {
		return new QuestionRecordLinkWrapper(_questionRecordLink.toEscapedModel());
	}

	@Override
	public priv.barrow.model.QuestionRecordLink toUnescapedModel() {
		return new QuestionRecordLinkWrapper(_questionRecordLink.toUnescapedModel());
	}

	@Override
	public void persist() {
		_questionRecordLink.persist();
	}

	/**
	* Sets whether this question record link is active.
	*
	* @param active the active of this question record link
	*/
	@Override
	public void setActive(boolean active) {
		_questionRecordLink.setActive(active);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_questionRecordLink.setCachedModel(cachedModel);
	}

	/**
	* Sets the ddl record ID of this question record link.
	*
	* @param ddlRecordId the ddl record ID of this question record link
	*/
	@Override
	public void setDdlRecordId(long ddlRecordId) {
		_questionRecordLink.setDdlRecordId(ddlRecordId);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_questionRecordLink.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_questionRecordLink.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_questionRecordLink.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_questionRecordLink.setNew(n);
	}

	/**
	* Sets the primary key of this question record link.
	*
	* @param primaryKey the primary key of this question record link
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_questionRecordLink.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_questionRecordLink.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the question order of this question record link.
	*
	* @param questionOrder the question order of this question record link
	*/
	@Override
	public void setQuestionOrder(long questionOrder) {
		_questionRecordLink.setQuestionOrder(questionOrder);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof QuestionRecordLinkWrapper)) {
			return false;
		}

		QuestionRecordLinkWrapper questionRecordLinkWrapper = (QuestionRecordLinkWrapper)obj;

		if (Objects.equals(_questionRecordLink,
					questionRecordLinkWrapper._questionRecordLink)) {
			return true;
		}

		return false;
	}

	@Override
	public QuestionRecordLink getWrappedModel() {
		return _questionRecordLink;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _questionRecordLink.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _questionRecordLink.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_questionRecordLink.resetOriginalValues();
	}

	private final QuestionRecordLink _questionRecordLink;
}