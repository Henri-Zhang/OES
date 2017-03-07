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

package priv.barrow.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class StudentExamLinkPK implements Comparable<StudentExamLinkPK>,
	Serializable {
	public long examRecordId;
	public long studentId;

	public StudentExamLinkPK() {
	}

	public StudentExamLinkPK(long examRecordId, long studentId) {
		this.examRecordId = examRecordId;
		this.studentId = studentId;
	}

	public long getExamRecordId() {
		return examRecordId;
	}

	public void setExamRecordId(long examRecordId) {
		this.examRecordId = examRecordId;
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	@Override
	public int compareTo(StudentExamLinkPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (examRecordId < pk.examRecordId) {
			value = -1;
		}
		else if (examRecordId > pk.examRecordId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (studentId < pk.studentId) {
			value = -1;
		}
		else if (studentId > pk.studentId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StudentExamLinkPK)) {
			return false;
		}

		StudentExamLinkPK pk = (StudentExamLinkPK)obj;

		if ((examRecordId == pk.examRecordId) && (studentId == pk.studentId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, examRecordId);
		hashCode = HashUtil.hash(hashCode, studentId);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("examRecordId");
		sb.append(StringPool.EQUAL);
		sb.append(examRecordId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("studentId");
		sb.append(StringPool.EQUAL);
		sb.append(studentId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}