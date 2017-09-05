package com.greendao3demo;

import java.util.List;

/**
 * Created by pesu on 2017/9/5.
 */

public class AppDbhelper {
    //
    private final DaoSession mDaoSession;

    public AppDbhelper(DbOpenHelper dbOpenHelper) {
        this.mDaoSession = new DaoMaster(dbOpenHelper.getWritableDb()).newSession();
    }

    public long insetUser(User user) {
        return mDaoSession.getUserDao().insert(user);
    }

    public void updateUser(User user) {
        mDaoSession.getUserDao().update(user);
    }

    public List<User> getUsers() {
        return mDaoSession.getUserDao().loadAll();
    }

    public void insertQuest(Question question) {
        mDaoSession.getQuestionDao().insert(question);
    }

    public void insertOption(Option option) {
        mDaoSession.getOptionDao().insert(option);
    }

    public List<Question> getAllQuestion() {
        return mDaoSession.getQuestionDao().loadAll();
    }


}
