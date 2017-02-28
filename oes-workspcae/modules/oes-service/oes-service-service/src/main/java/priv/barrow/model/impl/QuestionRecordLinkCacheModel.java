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

import priv.barrow.model.QuestionRecordLink;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing QuestionRecordLink in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see QuestionRecordLink
 * @generated
 */
@ProviderType
public class QuestionRecordLinkCacheModel implements CacheModel<QuestionRecordLink>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof QuestionRecordLinkCacheModel)) {
			return false;
		}

		QuestionRecordLinkCacheModel questionRecordLinkCacheModel = (QuestionRecordLinkCacheModel)obj;

		if (questionOrder == questionRecordLinkCacheModel.questionOrder) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, questionOrder);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{questionOrder=");
		sb.append(questionOrder);
		sb.append(", ddlRecordId=");
		sb.append(ddlRecordId);
		sb.append(", active=");
		sb.append(active);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public QuestionRecordLink toEntityModel() {
		QuestionRecordLinkImpl questionRecordLinkImpl = new QuestionRecordLinkImpl();

		questionRecordLinkImpl.setQuestionOrder(questionOrder);
		questionRecordLinkImpl.setDdlRecordId(ddlRecordId);
		questionRecordLinkImpl.setActive(active);

		questionRecordLinkImpl.resetOriginalValues();

		return questionRecordLinkImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		questionOrder = objectInput.readLong();

		ddlRecordId = objectInput.readLong();

		active = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(questionOrder);

		objectOutput.writeLong(ddlRecordId);

		objectOutput.writeBoolean(active);
	}

	public long questionOrder;
	public long ddlRecordId;
	public boolean active;
}