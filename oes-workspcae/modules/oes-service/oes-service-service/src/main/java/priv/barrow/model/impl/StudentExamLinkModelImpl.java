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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import priv.barrow.model.StudentExamLink;
import priv.barrow.model.StudentExamLinkModel;

import priv.barrow.service.persistence.StudentExamLinkPK;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the StudentExamLink service. Represents a row in the &quot;OES_StudentExamLink&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link StudentExamLinkModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link StudentExamLinkImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StudentExamLinkImpl
 * @see StudentExamLink
 * @see StudentExamLinkModel
 * @generated
 */
@ProviderType
public class StudentExamLinkModelImpl extends BaseModelImpl<StudentExamLink>
	implements StudentExamLinkModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a student exam link model instance should use the {@link StudentExamLink} interface instead.
	 */
	public static final String TABLE_NAME = "OES_StudentExamLink";
	public static final Object[][] TABLE_COLUMNS = {
			{ "examRecordId", Types.BIGINT },
			{ "studentId", Types.BIGINT },
			{ "inProgress", Types.BOOLEAN },
			{ "done", Types.BOOLEAN }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("examRecordId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("studentId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("inProgress", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("done", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE = "create table OES_StudentExamLink (examRecordId LONG not null,studentId LONG not null,inProgress BOOLEAN,done BOOLEAN,primary key (examRecordId, studentId))";
	public static final String TABLE_SQL_DROP = "drop table OES_StudentExamLink";
	public static final String ORDER_BY_JPQL = " ORDER BY studentExamLink.id.examRecordId ASC, studentExamLink.id.studentId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY OES_StudentExamLink.examRecordId ASC, OES_StudentExamLink.studentId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(priv.barrow.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.priv.barrow.model.StudentExamLink"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(priv.barrow.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.priv.barrow.model.StudentExamLink"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(priv.barrow.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.priv.barrow.model.StudentExamLink"),
			true);
	public static final long DONE_COLUMN_BITMASK = 1L;
	public static final long EXAMRECORDID_COLUMN_BITMASK = 2L;
	public static final long INPROGRESS_COLUMN_BITMASK = 4L;
	public static final long STUDENTID_COLUMN_BITMASK = 8L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(priv.barrow.service.util.ServiceProps.get(
				"lock.expiration.time.priv.barrow.model.StudentExamLink"));

	public StudentExamLinkModelImpl() {
	}

	@Override
	public StudentExamLinkPK getPrimaryKey() {
		return new StudentExamLinkPK(_examRecordId, _studentId);
	}

	@Override
	public void setPrimaryKey(StudentExamLinkPK primaryKey) {
		setExamRecordId(primaryKey.examRecordId);
		setStudentId(primaryKey.studentId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new StudentExamLinkPK(_examRecordId, _studentId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((StudentExamLinkPK)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return StudentExamLink.class;
	}

	@Override
	public String getModelClassName() {
		return StudentExamLink.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("examRecordId", getExamRecordId());
		attributes.put("studentId", getStudentId());
		attributes.put("inProgress", getInProgress());
		attributes.put("done", getDone());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long examRecordId = (Long)attributes.get("examRecordId");

		if (examRecordId != null) {
			setExamRecordId(examRecordId);
		}

		Long studentId = (Long)attributes.get("studentId");

		if (studentId != null) {
			setStudentId(studentId);
		}

		Boolean inProgress = (Boolean)attributes.get("inProgress");

		if (inProgress != null) {
			setInProgress(inProgress);
		}

		Boolean done = (Boolean)attributes.get("done");

		if (done != null) {
			setDone(done);
		}
	}

	@Override
	public long getExamRecordId() {
		return _examRecordId;
	}

	@Override
	public void setExamRecordId(long examRecordId) {
		_columnBitmask |= EXAMRECORDID_COLUMN_BITMASK;

		if (!_setOriginalExamRecordId) {
			_setOriginalExamRecordId = true;

			_originalExamRecordId = _examRecordId;
		}

		_examRecordId = examRecordId;
	}

	public long getOriginalExamRecordId() {
		return _originalExamRecordId;
	}

	@Override
	public long getStudentId() {
		return _studentId;
	}

	@Override
	public void setStudentId(long studentId) {
		_columnBitmask |= STUDENTID_COLUMN_BITMASK;

		if (!_setOriginalStudentId) {
			_setOriginalStudentId = true;

			_originalStudentId = _studentId;
		}

		_studentId = studentId;
	}

	public long getOriginalStudentId() {
		return _originalStudentId;
	}

	@Override
	public boolean getInProgress() {
		return _inProgress;
	}

	@Override
	public boolean isInProgress() {
		return _inProgress;
	}

	@Override
	public void setInProgress(boolean inProgress) {
		_columnBitmask |= INPROGRESS_COLUMN_BITMASK;

		if (!_setOriginalInProgress) {
			_setOriginalInProgress = true;

			_originalInProgress = _inProgress;
		}

		_inProgress = inProgress;
	}

	public boolean getOriginalInProgress() {
		return _originalInProgress;
	}

	@Override
	public boolean getDone() {
		return _done;
	}

	@Override
	public boolean isDone() {
		return _done;
	}

	@Override
	public void setDone(boolean done) {
		_columnBitmask |= DONE_COLUMN_BITMASK;

		if (!_setOriginalDone) {
			_setOriginalDone = true;

			_originalDone = _done;
		}

		_done = done;
	}

	public boolean getOriginalDone() {
		return _originalDone;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public StudentExamLink toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (StudentExamLink)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		StudentExamLinkImpl studentExamLinkImpl = new StudentExamLinkImpl();

		studentExamLinkImpl.setExamRecordId(getExamRecordId());
		studentExamLinkImpl.setStudentId(getStudentId());
		studentExamLinkImpl.setInProgress(getInProgress());
		studentExamLinkImpl.setDone(getDone());

		studentExamLinkImpl.resetOriginalValues();

		return studentExamLinkImpl;
	}

	@Override
	public int compareTo(StudentExamLink studentExamLink) {
		StudentExamLinkPK primaryKey = studentExamLink.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StudentExamLink)) {
			return false;
		}

		StudentExamLink studentExamLink = (StudentExamLink)obj;

		StudentExamLinkPK primaryKey = studentExamLink.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		StudentExamLinkModelImpl studentExamLinkModelImpl = this;

		studentExamLinkModelImpl._originalExamRecordId = studentExamLinkModelImpl._examRecordId;

		studentExamLinkModelImpl._setOriginalExamRecordId = false;

		studentExamLinkModelImpl._originalStudentId = studentExamLinkModelImpl._studentId;

		studentExamLinkModelImpl._setOriginalStudentId = false;

		studentExamLinkModelImpl._originalInProgress = studentExamLinkModelImpl._inProgress;

		studentExamLinkModelImpl._setOriginalInProgress = false;

		studentExamLinkModelImpl._originalDone = studentExamLinkModelImpl._done;

		studentExamLinkModelImpl._setOriginalDone = false;

		studentExamLinkModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<StudentExamLink> toCacheModel() {
		StudentExamLinkCacheModel studentExamLinkCacheModel = new StudentExamLinkCacheModel();

		studentExamLinkCacheModel.studentExamLinkPK = getPrimaryKey();

		studentExamLinkCacheModel.examRecordId = getExamRecordId();

		studentExamLinkCacheModel.studentId = getStudentId();

		studentExamLinkCacheModel.inProgress = getInProgress();

		studentExamLinkCacheModel.done = getDone();

		return studentExamLinkCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{examRecordId=");
		sb.append(getExamRecordId());
		sb.append(", studentId=");
		sb.append(getStudentId());
		sb.append(", inProgress=");
		sb.append(getInProgress());
		sb.append(", done=");
		sb.append(getDone());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("priv.barrow.model.StudentExamLink");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>examRecordId</column-name><column-value><![CDATA[");
		sb.append(getExamRecordId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>studentId</column-name><column-value><![CDATA[");
		sb.append(getStudentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>inProgress</column-name><column-value><![CDATA[");
		sb.append(getInProgress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>done</column-name><column-value><![CDATA[");
		sb.append(getDone());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = StudentExamLink.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			StudentExamLink.class
		};
	private long _examRecordId;
	private long _originalExamRecordId;
	private boolean _setOriginalExamRecordId;
	private long _studentId;
	private long _originalStudentId;
	private boolean _setOriginalStudentId;
	private boolean _inProgress;
	private boolean _originalInProgress;
	private boolean _setOriginalInProgress;
	private boolean _done;
	private boolean _originalDone;
	private boolean _setOriginalDone;
	private long _columnBitmask;
	private StudentExamLink _escapedModel;
}