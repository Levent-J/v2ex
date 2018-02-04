package com.levent_j.v2ex.net;

import com.levent_j.v2ex.data.NodeModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * @auther : levent_j on 2018/2/1.
 * @desc :
 */

public class ApiService {
    private static final String BASE_URL="https://www.v2ex.com/";
    private static ApiService mInstance;
    private Api client;

    public ApiService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        client = retrofit.create(Api.class);
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

    public Flowable<List<NodeModel>> getNodeList(){
        //test
        final List<NodeModel> list = new ArrayList<>();
        list.add(new NodeModel());
        list.add(new NodeModel());
        list.add(new NodeModel());
        list.add(new NodeModel());
        list.add(new NodeModel());
        list.add(new NodeModel());
        list.add(new NodeModel());
        list.add(new NodeModel());
        list.add(new NodeModel());
        list.add(new NodeModel());

        return Flowable.create(new FlowableOnSubscribe<List<NodeModel>>() {
            @Override
            public void subscribe(FlowableEmitter<List<NodeModel>> emitter) throws Exception {
                emitter.onNext(list);
            }
        }, BackpressureStrategy.BUFFER);
//        return client.getNodeList();
    }

    interface Api{
        @GET("api/topics/latest.json")
        Flowable<List<NodeModel>> getNodeList();
    }
}
