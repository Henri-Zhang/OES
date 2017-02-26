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
public class StudentTeacherLinkSoap implements Serializable {
	public static StudentTeacherLinkSoap toSoapModel(StudentTeacherLink model) {
		StudentTeacherLinkSoap soapModel = new StudentTeacherLinkSoap();

		soapModel.setStudentId(model.getStudentId());
		soapModel.setTeacherId(model.getTeacherId());

		return soapModel;
	}

	public static StudentTeacherLinkSoap[] toSoapModels(
		StudentTeacherLink[] models) {
		StudentTeacherLinkSoap[] soapModels = new StudentTeacherLinkSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StudentTeacherLinkSoap[][] toSoapModels(
		StudentTeacherLink[][] models) {
		StudentTeacherLinkSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StudentTeacherLinkSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StudentTeacherLinkSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StudentTeacherLinkSoap[] toSoapModels(
		List<StudentTeacherLink> models) {
		List<StudentTeacherLinkSoap> soapModels = new ArrayList<StudentTeacherLinkSoap>(models.size());

		for (StudentTeacherLink model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StudentTeacherLinkSoap[soapModels.size()]);
	}

	public StudentTeacherLinkSoap() {
	}

	public long getPrimaryKey() {
		return _studentId;
	}

	public void setPrimaryKey(long pk) {
		setStudentId(pk);
	}

	public long getStudentId() {
		return _studentId;
	}

	public void setStudentId(long studentId) {
		_studentId = studentId;
	}

	public long getTeacherId() {
		return _teacherId;
	}

	public void setTeacherId(long teacherId) {
		_teacherId = teacherId;
	}

	private long _studentId;
	private long _teacherId;
}