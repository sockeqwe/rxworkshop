package com.hannesdorfmann.ex1;

import io.reactivex.Observable;

import java.util.List;

public interface Backend {
    Observable<List<Person>> loadPersons();
}
