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

import priv.barrow.model.QuestionRecordLink;

import priv.barrow.service.persistence.QuestionRecordLinkPersistence;

import java.util.Set;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class QuestionRecordLinkFinderBaseImpl extends BasePersistenceImpl<QuestionRecordLink> {
	@Override
	public Set<String> getBadColumnNames() {
		return getQuestionRecordLinkPersistence().getBadColumnNames();
	}

	/**
	 * Returns the question record link persistence.
	 *
	 * @return the question record link persistence
	 */
	public QuestionRecordLinkPersistence getQuestionRecordLinkPersistence() {
		return questionRecordLinkPersistence;
	}

	/**
	 * Sets the question record link persistence.
	 *
	 * @param questionRecordLinkPersistence the question record link persistence
	 */
	public void setQuestionRecordLinkPersistence(
		QuestionRecordLinkPersistence questionRecordLinkPersistence) {
		this.questionRecordLinkPersistence = questionRecordLinkPersistence;
	}

	@BeanReference(type = QuestionRecordLinkPersistence.class)
	protected QuestionRecordLinkPersistence questionRecordLinkPersistence;
}