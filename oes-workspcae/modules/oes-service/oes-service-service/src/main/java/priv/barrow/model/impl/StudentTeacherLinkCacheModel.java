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

package priv.barrow.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import priv.barrow.model.StudentTeacherLink;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing StudentTeacherLink in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see StudentTeacherLink
 * @generated
 */
@ProviderType
public class StudentTeacherLinkCacheModel implements CacheModel<StudentTeacherLink>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StudentTeacherLinkCacheModel)) {
			return false;
		}

		StudentTeacherLinkCacheModel studentTeacherLinkCacheModel = (StudentTeacherLinkCacheModel)obj;

		if (studentId == studentTeacherLinkCacheModel.studentId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, studentId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{studentId=");
		sb.append(studentId);
		sb.append(", teacherId=");
		sb.append(teacherId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public StudentTeacherLink toEntityModel() {
		StudentTeacherLinkImpl studentTeacherLinkImpl = new StudentTeacherLinkImpl();

		studentTeacherLinkImpl.setStudentId(studentId);
		studentTeacherLinkImpl.setTeacherId(teacherId);

		studentTeacherLinkImpl.resetOriginalValues();

		return studentTeacherLinkImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		studentId = objectInput.readLong();

		teacherId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(studentId);

		objectOutput.writeLong(teacherId);
	}

	public long studentId;
	public long teacherId;
}