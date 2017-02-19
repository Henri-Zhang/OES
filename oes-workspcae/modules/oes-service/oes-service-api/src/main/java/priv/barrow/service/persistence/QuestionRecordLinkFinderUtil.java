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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class QuestionRecordLinkFinderUtil {
	public static java.util.List<priv.barrow.model.QuestionRecordLink> finderRecentUpdateQuestionRecordLinks(
		int count) {
		return getFinder().finderRecentUpdateQuestionRecordLinks(count);
	}

	public static QuestionRecordLinkFinder getFinder() {
		if (_finder == null) {
			_finder = (QuestionRecordLinkFinder)PortletBeanLocatorUtil.locate(priv.barrow.service.ClpSerializer.getServletContextName(),
					QuestionRecordLinkFinder.class.getName());

			ReferenceRegistry.registerReference(QuestionRecordLinkFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(QuestionRecordLinkFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(QuestionRecordLinkFinderUtil.class,
			"_finder");
	}

	private static QuestionRecordLinkFinder _finder;
}