package com.hannesdorfmann.observable;

public class TakeObservable<T> extends Observable<T> {

    private Observable<T> inputObservable;
    private int amountOfOnNextEvents;
    private int emittedEventsCount = 0;
    private boolean completed = false;

    public TakeObservable(int amountOfOnNextEvents, Observable<T> inputObservable) {
        this.inputObservable = inputObservable;
        this.amountOfOnNextEvents = amountOfOnNextEvents;
    }

    @Override
    public void subscribe(Observer<T> observer) {
        inputObservable.subscribe(new Observer<T>() {
            @Override
            public void onNext(T item) {
                if (emittedEventsCount < amountOfOnNextEvents) {
                    observer.onNext(item);
                    emittedEventsCount++;

                    if (emittedEventsCount == amountOfOnNextEvents) {
                        observer.onComplete();
                        completed = true;
                    }
                }
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
