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
 * This class is a wrapper for {@link ExamData}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ExamData
 * @generated
 */
@ProviderType
public class ExamDataWrapper implements ExamData, ModelWrapper<ExamData> {
	public ExamDataWrapper(ExamData examData) {
		_examData = examData;
	}

	@Override
	public Class<?> getModelClass() {
		return ExamData.class;
	}

	@Override
	public String getModelClassName() {
		return ExamData.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("PK", getPK());
		attributes.put("examId", getExamId());
		attributes.put("studentId", getStudentId());
		attributes.put("questionOrder", getQuestionOrder());
		attributes.put("result", getResult());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long PK = (Long)attributes.get("PK");

		if (PK != null) {
			setPK(PK);
		}

		Long examId = (Long)attributes.get("examId");

		if (examId != null) {
			setExamId(examId);
		}

		Long studentId = (Long)attributes.get("studentId");

		if (studentId != null) {
			setStudentId(studentId);
		}

		Long questionOrder = (Long)attributes.get("questionOrder");

		if (questionOrder != null) {
			setQuestionOrder(questionOrder);
		}

		String result = (String)attributes.get("result");

		if (result != null) {
			setResult(result);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _examData.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _examData.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _examData.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _examData.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<priv.barrow.model.ExamData> toCacheModel() {
		return _examData.toCacheModel();
	}

	@Override
	public int compareTo(priv.barrow.model.ExamData examData) {
		return _examData.compareTo(examData);
	}

	@Override
	public int hashCode() {
		return _examData.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _examData.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new ExamDataWrapper((ExamData)_examData.clone());
	}

	/**
	* Returns the result of this exam data.
	*
	* @return the result of this exam data
	*/
	@Override
	public java.lang.String getResult() {
		return _examData.getResult();
	}

	@Override
	public java.lang.String toString() {
		return _examData.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _examData.toXmlString();
	}

	/**
	* Returns the exam ID of this exam data.
	*
	* @return the exam ID of this exam data
	*/
	@Override
	public long getExamId() {
		return _examData.getExamId();
	}

	/**
	* Returns the pk of this exam data.
	*
	* @return the pk of this exam data
	*/
	@Override
	public long getPK() {
		return _examData.getPK();
	}

	/**
	* Returns the primary key of this exam data.
	*
	* @return the primary key of this exam data
	*/
	@Override
	public long getPrimaryKey() {
		return _examData.getPrimaryKey();
	}

	/**
	* Returns the question order of this exam data.
	*
	* @return the question order of this exam data
	*/
	@Override
	public long getQuestionOrder() {
		return _examData.getQuestionOrder();
	}

	/**
	* Returns the student ID of this exam data.
	*
	* @return the student ID of this exam data
	*/
	@Override
	public long getStudentId() {
		return _examData.getStudentId();
	}

	@Override
	public priv.barrow.model.ExamData toEscapedModel() {
		return new ExamDataWrapper(_examData.toEscapedModel());
	}

	@Override
	public priv.barrow.model.ExamData toUnescapedModel() {
		return new ExamDataWrapper(_examData.toUnescapedModel());
	}

	@Override
	public void persist() {
		_examData.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_examData.setCachedModel(cachedModel);
	}

	/**
	* Sets the exam ID of this exam data.
	*
	* @param examId the exam ID of this exam data
	*/
	@Override
	public void setExamId(long examId) {
		_examData.setExamId(examId);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_examData.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_examData.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_examData.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_examData.setNew(n);
	}

	/**
	* Sets the pk of this exam data.
	*
	* @param PK the pk of this exam data
	*/
	@Override
	public void setPK(long PK) {
		_examData.setPK(PK);
	}

	/**
	* Sets the primary key of this exam data.
	*
	* @param primaryKey the primary key of this exam data
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_examData.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_examData.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the question order of this exam data.
	*
	* @param questionOrder the question order of this exam data
	*/
	@Override
	public void setQuestionOrder(long questionOrder) {
		_examData.setQuestionOrder(questionOrder);
	}

	/**
	* Sets the result of this exam data.
	*
	* @param result the result of this exam data
	*/
	@Override
	public void setResult(java.lang.String result) {
		_examData.setResult(result);
	}

	/**
	* Sets the student ID of this exam data.
	*
	* @param studentId the student ID of this exam data
	*/
	@Override
	public void setStudentId(long studentId) {
		_examData.setStudentId(studentId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ExamDataWrapper)) {
			return false;
		}

		ExamDataWrapper examDataWrapper = (ExamDataWrapper)obj;

		if (Objects.equals(_examData, examDataWrapper._examData)) {
			return true;
		}

		return false;
	}

	@Override
	public ExamData getWrappedModel() {
		return _examData;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _examData.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _examData.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_examData.resetOriginalValues();
	}

	private final ExamData _examData;
}