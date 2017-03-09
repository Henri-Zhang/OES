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
public class ExamDataSoap implements Serializable {
	public static ExamDataSoap toSoapModel(ExamData model) {
		ExamDataSoap soapModel = new ExamDataSoap();

		soapModel.setPK(model.getPK());
		soapModel.setExamId(model.getExamId());
		soapModel.setStudentId(model.getStudentId());
		soapModel.setQuestionOrder(model.getQuestionOrder());
		soapModel.setResult(model.getResult());

		return soapModel;
	}

	public static ExamDataSoap[] toSoapModels(ExamData[] models) {
		ExamDataSoap[] soapModels = new ExamDataSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ExamDataSoap[][] toSoapModels(ExamData[][] models) {
		ExamDataSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ExamDataSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ExamDataSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ExamDataSoap[] toSoapModels(List<ExamData> models) {
		List<ExamDataSoap> soapModels = new ArrayList<ExamDataSoap>(models.size());

		for (ExamData model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ExamDataSoap[soapModels.size()]);
	}

	public ExamDataSoap() {
	}

	public long getPrimaryKey() {
		return _PK;
	}

	public void setPrimaryKey(long pk) {
		setPK(pk);
	}

	public long getPK() {
		return _PK;
	}

	public void setPK(long PK) {
		_PK = PK;
	}

	public long getExamId() {
		return _examId;
	}

	public void setExamId(long examId) {
		_examId = examId;
	}

	public long getStudentId() {
		return _studentId;
	}

	public void setStudentId(long studentId) {
		_studentId = studentId;
	}

	public long getQuestionOrder() {
		return _questionOrder;
	}

	public void setQuestionOrder(long questionOrder) {
		_questionOrder = questionOrder;
	}

	public String getResult() {
		return _result;
	}

	public void setResult(String result) {
		_result = result;
	}

	private long _PK;
	private long _examId;
	private long _studentId;
	private long _questionOrder;
	private String _result;
}