package com.hannesdorfmann.observable;

import java.util.function.Consumer;

public class CreateObservable<T> extends Observable<T> {

    private Consumer<Observer<T>> createFunc;
    private boolean errorReached = false;

    public CreateObservable(Consumer<Observer<T>> createFunc) {
        this.createFunc = createFunc;
    }

    @Override
    public void subscribe(Observer<T> observer) {
        createFunc.accept(observer);
    }
}
