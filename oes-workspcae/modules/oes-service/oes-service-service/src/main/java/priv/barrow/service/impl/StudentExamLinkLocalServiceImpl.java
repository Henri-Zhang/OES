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
import priv.barrow.model.StudentExamLink;
import priv.barrow.service.base.StudentExamLinkLocalServiceBaseImpl;

/**
 * The implementation of the student exam link local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link priv.barrow.service.StudentExamLinkLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StudentExamLinkLocalServiceBaseImpl
 * @see priv.barrow.service.StudentExamLinkLocalServiceUtil
 */
@ProviderType
public class StudentExamLinkLocalServiceImpl extends StudentExamLinkLocalServiceBaseImpl {

    @Override
    public List<StudentExamLink> findByExamRecordId(long examRecordId) {
        return getStudentExamLinkPersistence().findByExamRecordId(examRecordId);
    }

    @Override
    public List<StudentExamLink> findByStudentId(long studentId) {
        return getStudentExamLinkPersistence().findByStudentId(studentId);
    }

    @Override
    public List<StudentExamLink> findByStudentIdAndStatus(long studentId, boolean inProgress, boolean done) {
        return getStudentExamLinkPersistence().findByStudentIdAndStatus(studentId, inProgress, done);
    }

    @Override
    public List<StudentExamLink> findByExamRecordIdAndStudentId(long examRecordId, long studentId) {
        return getStudentExamLinkPersistence().findByExamRecordIdAndStudentId(examRecordId, studentId);
    }

    @Override
    public List<StudentExamLink> findByExamRecordIdAndDone(long examRecordId, boolean done) {
        return getStudentExamLinkPersistence().findByExamRecordIdAndDone(examRecordId, done);
    }

}