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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import priv.barrow.service.ClpSerializer;
import priv.barrow.service.QuestionRecordLinkLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @generated
 */
@ProviderType
public class QuestionRecordLinkClp extends BaseModelImpl<QuestionRecordLink>
	implements QuestionRecordLink {
	public QuestionRecordLinkClp() {
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
	public long getPrimaryKey() {
		return _questionOrder;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setQuestionOrder(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _questionOrder;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("questionOrder", getQuestionOrder());
		attributes.put("ddlRecordId", getDdlRecordId());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

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

		_entityCacheEnabled = GetterUtil.getBoolean("entityCacheEnabled");
		_finderCacheEnabled = GetterUtil.getBoolean("finderCacheEnabled");
	}

	@Override
	public long getQuestionOrder() {
		return _questionOrder;
	}

	@Override
	public void setQuestionOrder(long questionOrder) {
		_questionOrder = questionOrder;

		if (_questionRecordLinkRemoteModel != null) {
			try {
				Class<?> clazz = _questionRecordLinkRemoteModel.getClass();

				Method method = clazz.getMethod("setQuestionOrder", long.class);

				method.invoke(_questionRecordLinkRemoteModel, questionOrder);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDdlRecordId() {
		return _ddlRecordId;
	}

	@Override
	public void setDdlRecordId(long ddlRecordId) {
		_ddlRecordId = ddlRecordId;

		if (_questionRecordLinkRemoteModel != null) {
			try {
				Class<?> clazz = _questionRecordLinkRemoteModel.getClass();

				Method method = clazz.getMethod("setDdlRecordId", long.class);

				method.invoke(_questionRecordLinkRemoteModel, ddlRecordId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getQuestionRecordLinkRemoteModel() {
		return _questionRecordLinkRemoteModel;
	}

	public void setQuestionRecordLinkRemoteModel(
		BaseModel<?> questionRecordLinkRemoteModel) {
		_questionRecordLinkRemoteModel = questionRecordLinkRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _questionRecordLinkRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_questionRecordLinkRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() {
		if (this.isNew()) {
			QuestionRecordLinkLocalServiceUtil.addQuestionRecordLink(this);
		}
		else {
			QuestionRecordLinkLocalServiceUtil.updateQuestionRecordLink(this);
		}
	}

	@Override
	public QuestionRecordLink toEscapedModel() {
		return (QuestionRecordLink)ProxyUtil.newProxyInstance(QuestionRecordLink.class.getClassLoader(),
			new Class[] { QuestionRecordLink.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		QuestionRecordLinkClp clone = new QuestionRecordLinkClp();

		clone.setQuestionOrder(getQuestionOrder());
		clone.setDdlRecordId(getDdlRecordId());

		return clone;
	}

	@Override
	public int compareTo(QuestionRecordLink questionRecordLink) {
		long primaryKey = questionRecordLink.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof QuestionRecordLinkClp)) {
			return false;
		}

		QuestionRecordLinkClp questionRecordLink = (QuestionRecordLinkClp)obj;

		long primaryKey = questionRecordLink.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _entityCacheEnabled;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _finderCacheEnabled;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{questionOrder=");
		sb.append(getQuestionOrder());
		sb.append(", ddlRecordId=");
		sb.append(getDdlRecordId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("priv.barrow.model.QuestionRecordLink");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>questionOrder</column-name><column-value><![CDATA[");
		sb.append(getQuestionOrder());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ddlRecordId</column-name><column-value><![CDATA[");
		sb.append(getDdlRecordId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _questionOrder;
	private long _ddlRecordId;
	private BaseModel<?> _questionRecordLinkRemoteModel;
	private Class<?> _clpSerializerClass = ClpSerializer.class;
	private boolean _entityCacheEnabled;
	private boolean _finderCacheEnabled;
}