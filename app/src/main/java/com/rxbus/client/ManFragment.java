package com.rxbus.client;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import rx.functions.Action1;

/**
 * Created by 64860 on 2017/8/4.
 */

public class ManFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_man, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RxBus.getInstance().post(new SubEvent("张三", "23"));
            }
        });

        RxBus.getInstance().getObservable(SubEvent.class)
                .subscribe(new Action1<SubEvent>() {
                    @Override
                    public void call(SubEvent subEvent) {
                        Log.e("TAG", "啦啦啦啦" + subEvent.getAge() + subEvent.getName());
                    }
                });
    }
}
