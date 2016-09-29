package com.example.chen.memo.presenter;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.example.chen.memo.R;
import com.example.chen.memo.model.CreateDataModelImpl;
import com.example.chen.memo.view.diary.DiaryActivity;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by cdc on 16-9-27.
 */

public class DiaryPresenterImpl implements IDiaryPresenter {

    private CreateDataModelImpl createDataModel;
    private DiaryActivity diaryActivity;
    private String diaryContent;
    private String nowTime;


    public DiaryPresenterImpl(DiaryActivity diaryActivity) {
        this.diaryActivity = diaryActivity;

    }



    public void createDiary(Bundle bundle) {
        diaryContent = bundle.getString(DiaryActivity.EDIT_TEXT_DIARY, "");
        //nowTime = bundle.getString("now_time","");      //未获取到当前时间
        if (!diaryContent.equals("")){
            createDataModel = new CreateDataModelImpl();
            createDataModel.createDiaryData(diaryActivity, bundle);

        }else{
            this.diaryActivity.onToastMessage(String.valueOf(R.string.not_finish_diary));
        }

    }


}