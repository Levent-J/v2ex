package com.levent_j.v2ex.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import org.reactivestreams.Publisher;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.functions.Predicate;
import io.reactivex.subjects.BehaviorSubject;

/**
 * @auther : levent_j on 2018/2/1.
 * @desc :
 */

public class RxActivity extends AppCompatActivity {
    private BehaviorSubject<ActivityEvent> behaviorSubject = BehaviorSubject.create();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        behaviorSubject.onNext(ActivityEvent.CREATE);
    }

    @Override
    protected void onStart() {
        super.onStart();
        behaviorSubject.onNext(ActivityEvent.START);
    }

    @Override
    protected void onResume() {
        super.onResume();
        behaviorSubject.onNext(ActivityEvent.RESUME);
    }

    @Override
    protected void onPause() {
        super.onPause();
        behaviorSubject.onNext(ActivityEvent.PAUSE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        behaviorSubject.onNext(ActivityEvent.STOP);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        behaviorSubject.onNext(ActivityEvent.DESTROY);
    }

    public  <T> FlowableTransformer<T,T> bindUntilEvent(final ActivityEvent event){
        final Flowable<ActivityEvent> flowable = behaviorSubject.filter(new Predicate<ActivityEvent>() {
            @Override
            public boolean test(ActivityEvent activityEvent) throws Exception {
                return activityEvent.equals(event);
            }
        }).toFlowable(BackpressureStrategy.BUFFER);

        return new FlowableTransformer<T, T>() {
            @Override
            public Publisher<T> apply(Flowable<T> upstream) {
                return upstream.takeUntil(flowable);
            }
        };
    }
}
