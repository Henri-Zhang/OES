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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

/**
 * The base model interface for the ExamData service. Represents a row in the &quot;OES_ExamData&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link priv.barrow.model.impl.ExamDataModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link priv.barrow.model.impl.ExamDataImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ExamData
 * @see priv.barrow.model.impl.ExamDataImpl
 * @see priv.barrow.model.impl.ExamDataModelImpl
 * @generated
 */
@ProviderType
public interface ExamDataModel extends BaseModel<ExamData> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a exam data model instance should use the {@link ExamData} interface instead.
	 */

	/**
	 * Returns the primary key of this exam data.
	 *
	 * @return the primary key of this exam data
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this exam data.
	 *
	 * @param primaryKey the primary key of this exam data
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the pk of this exam data.
	 *
	 * @return the pk of this exam data
	 */
	public long getPK();

	/**
	 * Sets the pk of this exam data.
	 *
	 * @param PK the pk of this exam data
	 */
	public void setPK(long PK);

	/**
	 * Returns the exam ID of this exam data.
	 *
	 * @return the exam ID of this exam data
	 */
	public long getExamId();

	/**
	 * Sets the exam ID of this exam data.
	 *
	 * @param examId the exam ID of this exam data
	 */
	public void setExamId(long examId);

	/**
	 * Returns the student ID of this exam data.
	 *
	 * @return the student ID of this exam data
	 */
	public long getStudentId();

	/**
	 * Sets the student ID of this exam data.
	 *
	 * @param studentId the student ID of this exam data
	 */
	public void setStudentId(long studentId);

	/**
	 * Returns the question order of this exam data.
	 *
	 * @return the question order of this exam data
	 */
	public long getQuestionOrder();

	/**
	 * Sets the question order of this exam data.
	 *
	 * @param questionOrder the question order of this exam data
	 */
	public void setQuestionOrder(long questionOrder);

	/**
	 * Returns the result of this exam data.
	 *
	 * @return the result of this exam data
	 */
	@AutoEscape
	public String getResult();

	/**
	 * Sets the result of this exam data.
	 *
	 * @param result the result of this exam data
	 */
	public void setResult(String result);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(priv.barrow.model.ExamData examData);

	@Override
	public int hashCode();

	@Override
	public CacheModel<priv.barrow.model.ExamData> toCacheModel();

	@Override
	public priv.barrow.model.ExamData toEscapedModel();

	@Override
	public priv.barrow.model.ExamData toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}