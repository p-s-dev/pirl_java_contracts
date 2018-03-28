package com.psdev.pirl;

import org.junit.Test;
import rx.Completable;
import rx.Observable;
import rx.Subscriber;

import java.util.Arrays;

public class TestObservable {


    @Test
    public void testThis() {
        Completable.fromObservable(Observable.from(Arrays.asList(1,2,3))).doOnCompleted(() -> {
            System.out.println("test");
        }).subscribe(new Subscriber<Integer>() {

            @Override
            public void onCompleted() {
                System.out.println("test");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("test");
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("test");
            }
        });

    }
}
