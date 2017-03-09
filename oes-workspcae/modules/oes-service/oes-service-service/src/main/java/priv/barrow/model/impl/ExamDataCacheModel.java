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
import com.liferay.portal.kernel.util.StringPool;

import priv.barrow.model.ExamData;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ExamData in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see ExamData
 * @generated
 */
@ProviderType
public class ExamDataCacheModel implements CacheModel<ExamData>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ExamDataCacheModel)) {
			return false;
		}

		ExamDataCacheModel examDataCacheModel = (ExamDataCacheModel)obj;

		if (PK == examDataCacheModel.PK) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, PK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{PK=");
		sb.append(PK);
		sb.append(", examId=");
		sb.append(examId);
		sb.append(", studentId=");
		sb.append(studentId);
		sb.append(", questionOrder=");
		sb.append(questionOrder);
		sb.append(", result=");
		sb.append(result);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ExamData toEntityModel() {
		ExamDataImpl examDataImpl = new ExamDataImpl();

		examDataImpl.setPK(PK);
		examDataImpl.setExamId(examId);
		examDataImpl.setStudentId(studentId);
		examDataImpl.setQuestionOrder(questionOrder);

		if (result == null) {
			examDataImpl.setResult(StringPool.BLANK);
		}
		else {
			examDataImpl.setResult(result);
		}

		examDataImpl.resetOriginalValues();

		return examDataImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		PK = objectInput.readLong();

		examId = objectInput.readLong();

		studentId = objectInput.readLong();

		questionOrder = objectInput.readLong();
		result = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(PK);

		objectOutput.writeLong(examId);

		objectOutput.writeLong(studentId);

		objectOutput.writeLong(questionOrder);

		if (result == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(result);
		}
	}

	public long PK;
	public long examId;
	public long studentId;
	public long questionOrder;
	public String result;
}