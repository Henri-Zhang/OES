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

import priv.barrow.model.StudentExamLink;

import priv.barrow.service.persistence.StudentExamLinkPK;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing StudentExamLink in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see StudentExamLink
 * @generated
 */
@ProviderType
public class StudentExamLinkCacheModel implements CacheModel<StudentExamLink>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StudentExamLinkCacheModel)) {
			return false;
		}

		StudentExamLinkCacheModel studentExamLinkCacheModel = (StudentExamLinkCacheModel)obj;

		if (studentExamLinkPK.equals(
					studentExamLinkCacheModel.studentExamLinkPK)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, studentExamLinkPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{examRecordId=");
		sb.append(examRecordId);
		sb.append(", studentId=");
		sb.append(studentId);
		sb.append(", inProgress=");
		sb.append(inProgress);
		sb.append(", done=");
		sb.append(done);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public StudentExamLink toEntityModel() {
		StudentExamLinkImpl studentExamLinkImpl = new StudentExamLinkImpl();

		studentExamLinkImpl.setExamRecordId(examRecordId);
		studentExamLinkImpl.setStudentId(studentId);
		studentExamLinkImpl.setInProgress(inProgress);
		studentExamLinkImpl.setDone(done);

		studentExamLinkImpl.resetOriginalValues();

		return studentExamLinkImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		examRecordId = objectInput.readLong();

		studentId = objectInput.readLong();

		inProgress = objectInput.readBoolean();

		done = objectInput.readBoolean();

		studentExamLinkPK = new StudentExamLinkPK(examRecordId, studentId);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(examRecordId);

		objectOutput.writeLong(studentId);

		objectOutput.writeBoolean(inProgress);

		objectOutput.writeBoolean(done);
	}

	public long examRecordId;
	public long studentId;
	public boolean inProgress;
	public boolean done;
	public transient StudentExamLinkPK studentExamLinkPK;
}