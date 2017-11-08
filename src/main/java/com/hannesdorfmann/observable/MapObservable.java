package com.hannesdorfmann.observable;

import java.util.function.Function;

public class MapObservable<I, O> extends Observable<O> {

    private Function<I, O> mapperFunc;
    private Observable<I> inputObservable;

    public MapObservable(Function<I, O> mapperFunc, Observable<I> inputObservable) {
        this.mapperFunc = mapperFunc;
        this.inputObservable = inputObservable;
    }

    @Override
    public void subscribe(Observer<O> observer) {
        inputObservable.subscribe(new Observer<I>() {
            @Override
            public void onNext(I item) {
                O result = mapperFunc.apply(item);
                observer.onNext(result);
            }

            @Override
            public void onError(Throwable error) {
                observer.onError(error);
            }

            @Override
            public void onComplete() {
                observer.onComplete();
            }
        });
    }
}
