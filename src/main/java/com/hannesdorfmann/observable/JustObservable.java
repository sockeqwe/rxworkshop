package com.hannesdorfmann.observable;

public class JustObservable<T> extends Observable<T> {

    private Iterable<T> items;

    public JustObservable(Iterable<T> items) {
        this.items = items;
    }

    @Override
    public void subscribe(Observer<T> observer) {
        items.forEach(item -> observer.onNext(item));
        observer.onComplete();
    }
}
