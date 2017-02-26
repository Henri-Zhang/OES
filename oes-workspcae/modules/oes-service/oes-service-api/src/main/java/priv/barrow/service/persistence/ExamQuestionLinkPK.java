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
public class ExamQuestionLinkPK implements Comparable<ExamQuestionLinkPK>,
	Serializable {
	public long examRecordId;
	public long questionRecordId;

	public ExamQuestionLinkPK() {
	}

	public ExamQuestionLinkPK(long examRecordId, long questionRecordId) {
		this.examRecordId = examRecordId;
		this.questionRecordId = questionRecordId;
	}

	public long getExamRecordId() {
		return examRecordId;
	}

	public void setExamRecordId(long examRecordId) {
		this.examRecordId = examRecordId;
	}

	public long getQuestionRecordId() {
		return questionRecordId;
	}

	public void setQuestionRecordId(long questionRecordId) {
		this.questionRecordId = questionRecordId;
	}

	@Override
	public int compareTo(ExamQuestionLinkPK pk) {
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

		if (questionRecordId < pk.questionRecordId) {
			value = -1;
		}
		else if (questionRecordId > pk.questionRecordId) {
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

		if (!(obj instanceof ExamQuestionLinkPK)) {
			return false;
		}

		ExamQuestionLinkPK pk = (ExamQuestionLinkPK)obj;

		if ((examRecordId == pk.examRecordId) &&
				(questionRecordId == pk.questionRecordId)) {
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
		hashCode = HashUtil.hash(hashCode, questionRecordId);

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
		sb.append("questionRecordId");
		sb.append(StringPool.EQUAL);
		sb.append(questionRecordId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}