package com.rxbus.client;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import rx.Subscription;
import rx.functions.Action1;
import rx.subscriptions.CompositeSubscription;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private Subscription stringObservable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        stringObservable = RxBus.getInstance().getObservable(SubEvent.class)
                .subscribe(new Action1<SubEvent>() {
                    @Override
                    public void call(SubEvent subEvent) {
                        Log.e(TAG, "啦啦啦啦" + subEvent.getAge() + subEvent.getName());
                    }
                });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (!stringObservable.isUnsubscribed()){
            stringObservable.unsubscribe();
        }
    }

    private void init(){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        ManFragment fragment = (ManFragment) Fragment.instantiate(this, ManFragment.class.getName());
        transaction.replace(R.id.frame, fragment);
        transaction.commitAllowingStateLoss();
    }
}
