package com.hannesdorfmann.ex2;

import io.reactivex.Observable;

import java.util.List;
import java.util.Map;

public interface Backend {
    Observable<Person> loadPerson(int personId);
    Observable<Address> loadAddress(int personId);
}
