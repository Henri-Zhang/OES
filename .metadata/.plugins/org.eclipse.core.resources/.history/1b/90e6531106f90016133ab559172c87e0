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
public class QuestionRecordLinkSoap implements Serializable {
	public static QuestionRecordLinkSoap toSoapModel(QuestionRecordLink model) {
		QuestionRecordLinkSoap soapModel = new QuestionRecordLinkSoap();

		soapModel.setQuestionOrder(model.getQuestionOrder());
		soapModel.setDdlRecordId(model.getDdlRecordId());

		return soapModel;
	}

	public static QuestionRecordLinkSoap[] toSoapModels(
		QuestionRecordLink[] models) {
		QuestionRecordLinkSoap[] soapModels = new QuestionRecordLinkSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static QuestionRecordLinkSoap[][] toSoapModels(
		QuestionRecordLink[][] models) {
		QuestionRecordLinkSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new QuestionRecordLinkSoap[models.length][models[0].length];
		}
		else {
			soapModels = new QuestionRecordLinkSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static QuestionRecordLinkSoap[] toSoapModels(
		List<QuestionRecordLink> models) {
		List<QuestionRecordLinkSoap> soapModels = new ArrayList<QuestionRecordLinkSoap>(models.size());

		for (QuestionRecordLink model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new QuestionRecordLinkSoap[soapModels.size()]);
	}

	public QuestionRecordLinkSoap() {
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

	public long getDdlRecordId() {
		return _ddlRecordId;
	}

	public void setDdlRecordId(long ddlRecordId) {
		_ddlRecordId = ddlRecordId;
	}

	private long _questionOrder;
	private long _ddlRecordId;
}