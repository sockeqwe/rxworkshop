package com.hannesdorfmann.ex3;

import io.reactivex.Observable;

import java.util.List;

public interface Backend {
    Observable<List<PersonWithAddress>> loadAllPersons();
}
