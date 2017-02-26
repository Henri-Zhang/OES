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

package priv.barrow.service.persistence.impl;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;

import priv.barrow.model.TeacherUserLink;

import priv.barrow.service.persistence.TeacherUserLinkPersistence;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TeacherUserLinkFinderBaseImpl extends BasePersistenceImpl<TeacherUserLink> {
	/**
	 * Returns the teacher user link persistence.
	 *
	 * @return the teacher user link persistence
	 */
	public TeacherUserLinkPersistence getTeacherUserLinkPersistence() {
		return teacherUserLinkPersistence;
	}

	/**
	 * Sets the teacher user link persistence.
	 *
	 * @param teacherUserLinkPersistence the teacher user link persistence
	 */
	public void setTeacherUserLinkPersistence(
		TeacherUserLinkPersistence teacherUserLinkPersistence) {
		this.teacherUserLinkPersistence = teacherUserLinkPersistence;
	}

	@BeanReference(type = TeacherUserLinkPersistence.class)
	protected TeacherUserLinkPersistence teacherUserLinkPersistence;
}