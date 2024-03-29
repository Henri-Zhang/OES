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

package priv.barrow.service.impl;

import java.util.List;

import aQute.bnd.annotation.ProviderType;
import priv.barrow.model.TeacherUserLink;
import priv.barrow.service.base.TeacherUserLinkLocalServiceBaseImpl;

/**
 * The implementation of the teacher user link local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link priv.barrow.service.TeacherUserLinkLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TeacherUserLinkLocalServiceBaseImpl
 * @see priv.barrow.service.TeacherUserLinkLocalServiceUtil
 */
@ProviderType
public class TeacherUserLinkLocalServiceImpl extends TeacherUserLinkLocalServiceBaseImpl {

    @Override
    public List<TeacherUserLink> searchTeacherUsers(String keyword, long start, long end) {
        return getTeacherUserLinkFinder().searchTeacherUsers(keyword, start, end);
    }

    @Override
    public int countSearchTeacherUsers(String keyword) {
        return getTeacherUserLinkFinder().countSearchTeacherUsers(keyword);
    }

}