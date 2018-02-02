package com.levent_j.v2ex.net;

import com.levent_j.v2ex.data.bean.Node;

import org.reactivestreams.Subscriber;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @auther : levent_j on 2018/2/1.
 * @desc :
 */

public class ApiService {
    private static final String BASE_URL="";
    private static ApiService mInstance;
    private Retrofit client;

    public ApiService() {
//        client = new Retrofit.Builder()
//                .baseUrl(BASE_URL)
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
    }

    public static ApiService getInstance(){
        if (mInstance == null) {
            synchronized (ApiService.class){
                if (mInstance == null) {
                    mInstance = new ApiService();
                }
            }
        }
        return mInstance;
    }

    public Flowable<List<Node>> getNodeList(){
        final List<Node> list = new ArrayList<>();
        list.add(new Node());
        list.add(new Node());
        list.add(new Node());
        return Flowable.create(new FlowableOnSubscribe<List<Node>>() {
            @Override
            public void subscribe(FlowableEmitter<List<Node>> emitter) throws Exception {
                emitter.onNext(list);
            }
        }, BackpressureStrategy.BUFFER);
    }
}
