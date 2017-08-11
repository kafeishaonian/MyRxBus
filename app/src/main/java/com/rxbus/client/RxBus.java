package com.rxbus.client;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/**
 * Created by 64860 on 2017/8/4.
 */

public class RxBus {

    private static volatile RxBus mInstance;
    private final Subject mSubjec;

    public RxBus(){
        mSubjec = new SerializedSubject(PublishSubject.create());
    }

    public static RxBus getInstance(){
        if (mInstance == null){
            synchronized (RxBus.class){
                if (mInstance == null){
                    mInstance = new RxBus();
                }
            }
        }
        return mInstance;
    }

    public void post(Object object){
        mSubjec.onNext(object);
    }


    public <T> Observable<T> getObservable(Class<T> eventType){
        return mSubjec.ofType(eventType);
    }

}
