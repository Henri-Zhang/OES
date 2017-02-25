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
public class ExamQuestionLinkSoap implements Serializable {
	public static ExamQuestionLinkSoap toSoapModel(ExamQuestionLink model) {
		ExamQuestionLinkSoap soapModel = new ExamQuestionLinkSoap();

		soapModel.setExamRecordId(model.getExamRecordId());
		soapModel.setQuestionRecordId(model.getQuestionRecordId());
		soapModel.setQuestionRecordVersion(model.getQuestionRecordVersion());

		return soapModel;
	}

	public static ExamQuestionLinkSoap[] toSoapModels(ExamQuestionLink[] models) {
		ExamQuestionLinkSoap[] soapModels = new ExamQuestionLinkSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ExamQuestionLinkSoap[][] toSoapModels(
		ExamQuestionLink[][] models) {
		ExamQuestionLinkSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ExamQuestionLinkSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ExamQuestionLinkSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ExamQuestionLinkSoap[] toSoapModels(
		List<ExamQuestionLink> models) {
		List<ExamQuestionLinkSoap> soapModels = new ArrayList<ExamQuestionLinkSoap>(models.size());

		for (ExamQuestionLink model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ExamQuestionLinkSoap[soapModels.size()]);
	}

	public ExamQuestionLinkSoap() {
	}

	public long getPrimaryKey() {
		return _examRecordId;
	}

	public void setPrimaryKey(long pk) {
		setExamRecordId(pk);
	}

	public long getExamRecordId() {
		return _examRecordId;
	}

	public void setExamRecordId(long examRecordId) {
		_examRecordId = examRecordId;
	}

	public long getQuestionRecordId() {
		return _questionRecordId;
	}

	public void setQuestionRecordId(long questionRecordId) {
		_questionRecordId = questionRecordId;
	}

	public String getQuestionRecordVersion() {
		return _questionRecordVersion;
	}

	public void setQuestionRecordVersion(String questionRecordVersion) {
		_questionRecordVersion = questionRecordVersion;
	}

	private long _examRecordId;
	private long _questionRecordId;
	private String _questionRecordVersion;
}