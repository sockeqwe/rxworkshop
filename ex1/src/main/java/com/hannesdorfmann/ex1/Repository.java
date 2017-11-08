package com.hannesdorfmann.ex1;

import io.reactivex.Observable;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

public class Repository {
    private final View view;
    private final Backend backend;

    public Repository(View view, Backend backend) {
        this.view = view;
        this.backend = backend;
    }

    public Observable<List<Person>> loadPersons() {

        //
        // TODO: Load the list of persons on each button click from the view. So basically
        //
        // return view.buttonClicks().<-- your code to somehow load data from backend-->
        //
        //

        throw new RuntimeException("Not implemented");
    }
}
