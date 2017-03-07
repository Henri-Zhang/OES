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

import priv.barrow.service.persistence.StudentExamLinkPK;

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
public class StudentExamLinkSoap implements Serializable {
	public static StudentExamLinkSoap toSoapModel(StudentExamLink model) {
		StudentExamLinkSoap soapModel = new StudentExamLinkSoap();

		soapModel.setExamRecordId(model.getExamRecordId());
		soapModel.setStudentId(model.getStudentId());
		soapModel.setInProgress(model.getInProgress());
		soapModel.setDone(model.getDone());

		return soapModel;
	}

	public static StudentExamLinkSoap[] toSoapModels(StudentExamLink[] models) {
		StudentExamLinkSoap[] soapModels = new StudentExamLinkSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StudentExamLinkSoap[][] toSoapModels(
		StudentExamLink[][] models) {
		StudentExamLinkSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StudentExamLinkSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StudentExamLinkSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StudentExamLinkSoap[] toSoapModels(
		List<StudentExamLink> models) {
		List<StudentExamLinkSoap> soapModels = new ArrayList<StudentExamLinkSoap>(models.size());

		for (StudentExamLink model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StudentExamLinkSoap[soapModels.size()]);
	}

	public StudentExamLinkSoap() {
	}

	public StudentExamLinkPK getPrimaryKey() {
		return new StudentExamLinkPK(_examRecordId, _studentId);
	}

	public void setPrimaryKey(StudentExamLinkPK pk) {
		setExamRecordId(pk.examRecordId);
		setStudentId(pk.studentId);
	}

	public long getExamRecordId() {
		return _examRecordId;
	}

	public void setExamRecordId(long examRecordId) {
		_examRecordId = examRecordId;
	}

	public long getStudentId() {
		return _studentId;
	}

	public void setStudentId(long studentId) {
		_studentId = studentId;
	}

	public boolean getInProgress() {
		return _inProgress;
	}

	public boolean isInProgress() {
		return _inProgress;
	}

	public void setInProgress(boolean inProgress) {
		_inProgress = inProgress;
	}

	public boolean getDone() {
		return _done;
	}

	public boolean isDone() {
		return _done;
	}

	public void setDone(boolean done) {
		_done = done;
	}

	private long _examRecordId;
	private long _studentId;
	private boolean _inProgress;
	private boolean _done;
}