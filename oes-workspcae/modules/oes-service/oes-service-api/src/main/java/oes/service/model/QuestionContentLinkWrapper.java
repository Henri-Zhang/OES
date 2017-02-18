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

package oes.service.model;

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
 * This class is a wrapper for {@link QuestionContentLink}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuestionContentLink
 * @generated
 */
@ProviderType
public class QuestionContentLinkWrapper implements QuestionContentLink,
	ModelWrapper<QuestionContentLink> {
	public QuestionContentLinkWrapper(QuestionContentLink questionContentLink) {
		_questionContentLink = questionContentLink;
	}

	@Override
	public Class<?> getModelClass() {
		return QuestionContentLink.class;
	}

	@Override
	public String getModelClassName() {
		return QuestionContentLink.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("questionOrder", getQuestionOrder());
		attributes.put("ddmContentId", getDdmContentId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long questionOrder = (Long)attributes.get("questionOrder");

		if (questionOrder != null) {
			setQuestionOrder(questionOrder);
		}

		Long ddmContentId = (Long)attributes.get("ddmContentId");

		if (ddmContentId != null) {
			setDdmContentId(ddmContentId);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _questionContentLink.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _questionContentLink.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _questionContentLink.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _questionContentLink.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<oes.service.model.QuestionContentLink> toCacheModel() {
		return _questionContentLink.toCacheModel();
	}

	@Override
	public int compareTo(
		oes.service.model.QuestionContentLink questionContentLink) {
		return _questionContentLink.compareTo(questionContentLink);
	}

	@Override
	public int hashCode() {
		return _questionContentLink.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _questionContentLink.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new QuestionContentLinkWrapper((QuestionContentLink)_questionContentLink.clone());
	}

	@Override
	public java.lang.String toString() {
		return _questionContentLink.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _questionContentLink.toXmlString();
	}

	/**
	* Returns the ddm content ID of this question content link.
	*
	* @return the ddm content ID of this question content link
	*/
	@Override
	public long getDdmContentId() {
		return _questionContentLink.getDdmContentId();
	}

	/**
	* Returns the primary key of this question content link.
	*
	* @return the primary key of this question content link
	*/
	@Override
	public long getPrimaryKey() {
		return _questionContentLink.getPrimaryKey();
	}

	/**
	* Returns the question order of this question content link.
	*
	* @return the question order of this question content link
	*/
	@Override
	public long getQuestionOrder() {
		return _questionContentLink.getQuestionOrder();
	}

	@Override
	public oes.service.model.QuestionContentLink toEscapedModel() {
		return new QuestionContentLinkWrapper(_questionContentLink.toEscapedModel());
	}

	@Override
	public oes.service.model.QuestionContentLink toUnescapedModel() {
		return new QuestionContentLinkWrapper(_questionContentLink.toUnescapedModel());
	}

	@Override
	public void persist() {
		_questionContentLink.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_questionContentLink.setCachedModel(cachedModel);
	}

	/**
	* Sets the ddm content ID of this question content link.
	*
	* @param ddmContentId the ddm content ID of this question content link
	*/
	@Override
	public void setDdmContentId(long ddmContentId) {
		_questionContentLink.setDdmContentId(ddmContentId);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_questionContentLink.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_questionContentLink.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_questionContentLink.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_questionContentLink.setNew(n);
	}

	/**
	* Sets the primary key of this question content link.
	*
	* @param primaryKey the primary key of this question content link
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_questionContentLink.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_questionContentLink.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the question order of this question content link.
	*
	* @param questionOrder the question order of this question content link
	*/
	@Override
	public void setQuestionOrder(long questionOrder) {
		_questionContentLink.setQuestionOrder(questionOrder);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof QuestionContentLinkWrapper)) {
			return false;
		}

		QuestionContentLinkWrapper questionContentLinkWrapper = (QuestionContentLinkWrapper)obj;

		if (Objects.equals(_questionContentLink,
					questionContentLinkWrapper._questionContentLink)) {
			return true;
		}

		return false;
	}

	@Override
	public QuestionContentLink getWrappedModel() {
		return _questionContentLink;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _questionContentLink.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _questionContentLink.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_questionContentLink.resetOriginalValues();
	}

	private final QuestionContentLink _questionContentLink;
}