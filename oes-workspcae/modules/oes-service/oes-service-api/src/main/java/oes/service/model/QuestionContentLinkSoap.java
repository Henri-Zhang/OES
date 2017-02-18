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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class QuestionContentLinkSoap implements Serializable {
	public static QuestionContentLinkSoap toSoapModel(QuestionContentLink model) {
		QuestionContentLinkSoap soapModel = new QuestionContentLinkSoap();

		soapModel.setQuestionOrder(model.getQuestionOrder());
		soapModel.setDdmContentId(model.getDdmContentId());

		return soapModel;
	}

	public static QuestionContentLinkSoap[] toSoapModels(
		QuestionContentLink[] models) {
		QuestionContentLinkSoap[] soapModels = new QuestionContentLinkSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static QuestionContentLinkSoap[][] toSoapModels(
		QuestionContentLink[][] models) {
		QuestionContentLinkSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new QuestionContentLinkSoap[models.length][models[0].length];
		}
		else {
			soapModels = new QuestionContentLinkSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static QuestionContentLinkSoap[] toSoapModels(
		List<QuestionContentLink> models) {
		List<QuestionContentLinkSoap> soapModels = new ArrayList<QuestionContentLinkSoap>(models.size());

		for (QuestionContentLink model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new QuestionContentLinkSoap[soapModels.size()]);
	}

	public QuestionContentLinkSoap() {
	}

	public long getPrimaryKey() {
		return _questionOrder;
	}

	public void setPrimaryKey(long pk) {
		setQuestionOrder(pk);
	}

	public long getQuestionOrder() {
		return _questionOrder;
	}

	public void setQuestionOrder(long questionOrder) {
		_questionOrder = questionOrder;
	}

	public long getDdmContentId() {
		return _ddmContentId;
	}

	public void setDdmContentId(long ddmContentId) {
		_ddmContentId = ddmContentId;
	}

	private long _questionOrder;
	private long _ddmContentId;
}