package priv.barrow.service.persistence.impl;

import java.util.List;

import priv.barrow.model.QuestionRecordLink;
import priv.barrow.service.persistence.QuestionRecordLinkFinder;

public class QuestionRecordLinkFinderImpl
    extends QuestionRecordLinkFinderBaseImpl implements QuestionRecordLinkFinder {

    @Override
    public List<QuestionRecordLink> findRecentUpdateQuestionRecordLinks(int count) {
        return null;
    }

}
