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

import priv.barrow.model.ExamQuestionLink;

import priv.barrow.service.persistence.ExamQuestionLinkPK;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ExamQuestionLink in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see ExamQuestionLink
 * @generated
 */
@ProviderType
public class ExamQuestionLinkCacheModel implements CacheModel<ExamQuestionLink>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ExamQuestionLinkCacheModel)) {
			return false;
		}

		ExamQuestionLinkCacheModel examQuestionLinkCacheModel = (ExamQuestionLinkCacheModel)obj;

		if (examQuestionLinkPK.equals(
					examQuestionLinkCacheModel.examQuestionLinkPK)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, examQuestionLinkPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{examRecordId=");
		sb.append(examRecordId);
		sb.append(", questionRecordId=");
		sb.append(questionRecordId);
		sb.append(", questionRecordVersion=");
		sb.append(questionRecordVersion);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ExamQuestionLink toEntityModel() {
		ExamQuestionLinkImpl examQuestionLinkImpl = new ExamQuestionLinkImpl();

		examQuestionLinkImpl.setExamRecordId(examRecordId);
		examQuestionLinkImpl.setQuestionRecordId(questionRecordId);

		if (questionRecordVersion == null) {
			examQuestionLinkImpl.setQuestionRecordVersion(StringPool.BLANK);
		}
		else {
			examQuestionLinkImpl.setQuestionRecordVersion(questionRecordVersion);
		}

		examQuestionLinkImpl.resetOriginalValues();

		return examQuestionLinkImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		examRecordId = objectInput.readLong();

		questionRecordId = objectInput.readLong();
		questionRecordVersion = objectInput.readUTF();

		examQuestionLinkPK = new ExamQuestionLinkPK(examRecordId,
				questionRecordId);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(examRecordId);

		objectOutput.writeLong(questionRecordId);

		if (questionRecordVersion == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(questionRecordVersion);
		}
	}

	public long examRecordId;
	public long questionRecordId;
	public String questionRecordVersion;
	public transient ExamQuestionLinkPK examQuestionLinkPK;
}