package priv.barrow.service.persistence.impl;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

import com.liferay.portal.dao.orm.custom.sql.CustomSQLUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import priv.barrow.model.QuestionRecordLink;
import priv.barrow.model.impl.QuestionRecordLinkImpl;
import priv.barrow.service.persistence.QuestionRecordLinkFinder;

public class QuestionRecordLinkFinderImpl extends QuestionRecordLinkFinderBaseImpl implements QuestionRecordLinkFinder {

    private Log LOG = LogFactoryUtil.getLog(QuestionRecordLinkFinderImpl.class);
    private final String ENTITY_NAME = "QuestionRecordLink";
    private final String FIND_RECENT_UPDATE_QUESTION_REOCRD_LINKS = QuestionRecordLinkFinder.class.getName()
            + ".findRecentUpdateQuestionReocrdLinks";
    private final String FIND_RANDOM_QUESTION_REOCRD_LINKS = QuestionRecordLinkFinder.class.getName()
            + ".findRandomQuestionReocrdLinks";
    private final String SEARCH_QUESTION_REOCRD_LINKS = QuestionRecordLinkFinder.class.getName()
            + ".searchQuestionReocrdLinks";
    private final String COUNT_SEARCH_QUESTION_REOCRD_LINKS = QuestionRecordLinkFinder.class.getName()
            + ".countSearchQuestionReocrdLinks";

    @SuppressWarnings("unchecked")
    @Override
    public List<QuestionRecordLink> findRecentUpdateQuestionReocrdLinks(int count) {

        String sql = CustomSQLUtil.get(getClass(), FIND_RECENT_UPDATE_QUESTION_REOCRD_LINKS);
        Session session = openSession();
        List<QuestionRecordLink> questionRecordLinks = null;

        try {
            SQLQuery query = session.createSQLQuery(sql);
            query.addEntity(ENTITY_NAME, QuestionRecordLinkImpl.class);
            query.setInteger(0, count);
            questionRecordLinks = query.list();
        } catch (Exception e) {
            LOG.error(String.format("Excute sql meet an error. SQL: %s", sql), e);
        } finally {
            closeSession(session);
        }

        return questionRecordLinks;
    }

    @Override
    public List<QuestionRecordLink> findRandomQuestionReocrdLinks(int count) {
        String sql = CustomSQLUtil.get(getClass(), FIND_RANDOM_QUESTION_REOCRD_LINKS);
        Session session = openSession();
        List<QuestionRecordLink> questionRecordLinks = null;

        try {
            SQLQuery query = session.createSQLQuery(sql);
            query.addEntity(ENTITY_NAME, QuestionRecordLinkImpl.class);
            query.setInteger(0, count);
            questionRecordLinks = query.list();
        } catch (Exception e) {
            LOG.error(String.format("Excute sql meet an error. SQL: %s", sql), e);
        } finally {
            closeSession(session);
        }

        return questionRecordLinks;
    }

    @Override
    public List<QuestionRecordLink> searchQuestionReocrdLinks(
            long questionOrderStart,
            long questionOrderEnd,
            Timestamp updateDateStart,
            Timestamp updateDateEnd,
            String questionKeyword,
            String userNameKeyword) {

        String sql = CustomSQLUtil.get(getClass(), SEARCH_QUESTION_REOCRD_LINKS);
        Session session = openSession();
        List<QuestionRecordLink> questionRecordLinks = null;

        try {
            SQLQuery query = session.createSQLQuery(sql);
            query.addEntity(ENTITY_NAME, QuestionRecordLinkImpl.class);
            query.setLong(0, questionOrderStart);
            query.setLong(1, questionOrderEnd);
            query.setTimestamp(2, updateDateStart);
            query.setTimestamp(3, updateDateEnd);
            query.setString(4, "%" + questionKeyword + "%");
            query.setString(5, "%" + userNameKeyword + "%");
            query.setLong(6, 100);
            query.setLong(7, 0);
            questionRecordLinks = query.list();
        } catch (Exception e) {
            LOG.error(String.format("Excute sql meet an error. SQL: %s", sql), e);
        } finally {
            closeSession(session);
        }

        return questionRecordLinks;
    }

    @Override
    public int countSearchQuestionReocrdLinks(
            long questionOrderStart,
            long questionOrderEnd,
            Timestamp updateDateStart,
            Timestamp updateDateEnd,
            String questionKeyword,
            String userNameKeyword) {

        String sql = CustomSQLUtil.get(getClass(), COUNT_SEARCH_QUESTION_REOCRD_LINKS);
        Session session = openSession();
        try {
            SQLQuery query = session.createSQLQuery(sql);
            query.setLong(0, questionOrderStart);
            query.setLong(1, questionOrderEnd);
            query.setTimestamp(2, updateDateStart);
            query.setTimestamp(3, updateDateEnd);
            query.setString(4, "%" + questionKeyword + "%");
            query.setString(5, "%" + userNameKeyword + "%");
            return ((BigInteger) query.uniqueResult()).intValue();
        } catch (Exception e) {
            LOG.error(String.format("Excute sql meet an error. SQL: %s", sql), e);
        } finally {
            closeSession(session);
        }

        return 0;
    }

}
