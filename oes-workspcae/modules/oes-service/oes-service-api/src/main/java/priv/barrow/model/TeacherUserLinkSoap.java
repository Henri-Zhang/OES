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
public class TeacherUserLinkSoap implements Serializable {
	public static TeacherUserLinkSoap toSoapModel(TeacherUserLink model) {
		TeacherUserLinkSoap soapModel = new TeacherUserLinkSoap();

		soapModel.setTeacherNumber(model.getTeacherNumber());
		soapModel.setUserId(model.getUserId());

		return soapModel;
	}

	public static TeacherUserLinkSoap[] toSoapModels(TeacherUserLink[] models) {
		TeacherUserLinkSoap[] soapModels = new TeacherUserLinkSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TeacherUserLinkSoap[][] toSoapModels(
		TeacherUserLink[][] models) {
		TeacherUserLinkSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TeacherUserLinkSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TeacherUserLinkSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TeacherUserLinkSoap[] toSoapModels(
		List<TeacherUserLink> models) {
		List<TeacherUserLinkSoap> soapModels = new ArrayList<TeacherUserLinkSoap>(models.size());

		for (TeacherUserLink model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TeacherUserLinkSoap[soapModels.size()]);
	}

	public TeacherUserLinkSoap() {
	}

	public long getPrimaryKey() {
		return _teacherNumber;
	}

	public void setPrimaryKey(long pk) {
		setTeacherNumber(pk);
	}

	public long getTeacherNumber() {
		return _teacherNumber;
	}

	public void setTeacherNumber(long teacherNumber) {
		_teacherNumber = teacherNumber;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	private long _teacherNumber;
	private long _userId;
}