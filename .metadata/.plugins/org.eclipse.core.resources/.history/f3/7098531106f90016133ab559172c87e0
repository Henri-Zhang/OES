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

package priv.barrow.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the QuestionRecordLink service. Represents a row in the &quot;OES_QuestionRecordLink&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see QuestionRecordLinkModel
 * @see priv.barrow.model.impl.QuestionRecordLinkImpl
 * @see priv.barrow.model.impl.QuestionRecordLinkModelImpl
 * @generated
 */
@ImplementationClassName("priv.barrow.model.impl.QuestionRecordLinkImpl")
@ProviderType
public interface QuestionRecordLink extends QuestionRecordLinkModel,
	PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link priv.barrow.model.impl.QuestionRecordLinkImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<QuestionRecordLink, Long> QUESTION_ORDER_ACCESSOR =
		new Accessor<QuestionRecordLink, Long>() {
			@Override
			public Long get(QuestionRecordLink questionRecordLink) {
				return questionRecordLink.getQuestionOrder();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<QuestionRecordLink> getTypeClass() {
				return QuestionRecordLink.class;
			}
		};
}