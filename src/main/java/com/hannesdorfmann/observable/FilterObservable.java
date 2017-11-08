package com.hannesdorfmann.observable;

import java.util.function.Function;

public class FilterObservable<I> extends Observable<I> {

    private Function<I, Boolean> filterFunc;
    private Observable<I> inputObservable;

    public FilterObservable(Function<I, Boolean> filterFunc, Observable<I> inputObservable) {
        this.filterFunc = filterFunc;
        this.inputObservable = inputObservable;
    }

    @Override
    public void subscribe(Observer<I> observer) {
        inputObservable.subscribe(new Observer<I>() {
            @Override
            public void onNext(I item) {
                Boolean isPassing = filterFunc.apply(item);
                if (isPassing)
                    observer.onNext(item);
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
