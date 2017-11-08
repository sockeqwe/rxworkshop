package com.hannesdorfmann.observable;

import java.util.function.Consumer;
import java.util.function.Function;

public abstract class Observable<T> {

    public static <T> Observable<T> from(Iterable<T> data){
        return new JustObservable<T>(data);
    }

    public static <T> Observable<T> create(Consumer<Observer<T>> createFunction){
        return new CreateObservable<>(createFunction);
    }

    public abstract void subscribe(Observer<T> observer);

    public <O> Observable<O> map(Function<T, O> mapperFunc){
        return new MapObservable<T, O>(mapperFunc, this);
    }

    public Observable<T> filter(Function<T, Boolean> filterFunc){
        return new FilterObservable<T>(filterFunc, this);
    }

    public Observable<T> take(int count){
        return new TakeObservable<T>(count, this);
    }
}
