package com.hannesdorfmann;

import com.hannesdorfmann.observable.Observable;
import com.hannesdorfmann.observable.Observer;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Integer> data = Arrays.asList(10, 20, 30);
        Observable.from(data)
                .map( item -> item / 10)
                .map(item -> " Hello "+item)
                .subscribe(new Observer<String>() {
                    @Override
                    public void onNext(String item) {
                        System.out.println(item);
                    }

                    @Override
                    public void onError(Throwable error) {
                        System.out.println("on error");
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("completed");
                    }
                });
    }

}

