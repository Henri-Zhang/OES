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

import priv.barrow.model.TeacherUserLink;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing TeacherUserLink in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see TeacherUserLink
 * @generated
 */
@ProviderType
public class TeacherUserLinkCacheModel implements CacheModel<TeacherUserLink>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TeacherUserLinkCacheModel)) {
			return false;
		}

		TeacherUserLinkCacheModel teacherUserLinkCacheModel = (TeacherUserLinkCacheModel)obj;

		if (teacherNumber == teacherUserLinkCacheModel.teacherNumber) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, teacherNumber);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{teacherNumber=");
		sb.append(teacherNumber);
		sb.append(", userId=");
		sb.append(userId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TeacherUserLink toEntityModel() {
		TeacherUserLinkImpl teacherUserLinkImpl = new TeacherUserLinkImpl();

		teacherUserLinkImpl.setTeacherNumber(teacherNumber);
		teacherUserLinkImpl.setUserId(userId);

		teacherUserLinkImpl.resetOriginalValues();

		return teacherUserLinkImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		teacherNumber = objectInput.readLong();

		userId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(teacherNumber);

		objectOutput.writeLong(userId);
	}

	public long teacherNumber;
	public long userId;
}