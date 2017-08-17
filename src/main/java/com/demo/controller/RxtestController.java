package com.demo.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by shixiaoqi on 2017/8/14.
 */
@Controller
public class RxtestController {

//    public static void main(String[] args) {
////        RxTest1();
////        RxTest2();
////        RxTest3();
//        for (int i = 0; i < 9; i++) {
//            System.out.println("----"+i);
//            RxTest4();
//        }
//    }

    public static void RxTest1(){
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onNext(String s) {
                System.out.println(s+"---");
            }
        };

        Observable observable = Observable.create(new Observable.OnSubscribe<String>(){
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("hello");
                subscriber.onNext("hehe");
                subscriber.onNext("xixi");
                subscriber.onCompleted();
            }
        });
        observable.subscribe(observer);
    }

    public static void RxTest2(){
        Action1 action1 = new Action1<String>() {
            @Override
            public void call(String o) {
                System.out.println(o);
            }
        };
        String [] words = {"Hello", "World"};
        Observable.from(words).subscribe(action1);
    }

    public static void RxTest3(){
        Action1 action1 = new Action1<Integer>() {
            @Override
            public void call(Integer o) {
                System.out.println(o);
            }
        };
        Observable.from("11111","22222","3333").map(
                new Func1<String, Integer>() {
                    @Override
                    public Integer call(String s) {
                        return Integer.parseInt(s);
                    }
                }
        ).subscribe(action1);
    }

    public static void RxTest4(){
        Action1 action1 = new Action1<Integer>() {
            @Override
            public void call(Integer o) {
                System.out.println(o);
            }
        };

        Observable.from(1,2,3)
                .subscribeOn(Schedulers.newThread())
                .map(new Func1<Integer, Integer>() {
                    @Override
                    public Integer call(Integer integer) {
                        return integer;
                    }
                })
                .subscribe(action1);

    }


}

