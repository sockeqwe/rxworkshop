package com.hannesdorfmann.ex4;

import io.reactivex.Observable;

import java.util.List;

public interface Backend {

    Observable<List<Person>> searchfor(String searchFor);
}
