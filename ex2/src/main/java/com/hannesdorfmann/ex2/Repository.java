package com.hannesdorfmann.ex2;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.List;

public class Repository {
    private final View view;
    private final Backend backend;

    public Repository(View view, Backend backend) {
        this.view = view;
        this.backend = backend;
    }

    public Observable<PersonWithAddress> loadPersons() {

        //
        // TODO: From the view layer a user of our app can click on a person to laod the details and address about this person.
        //
        // return view.onPersonClicked().<-- your code to somehow load data from backend. Use backend.loadPerson(personId) and loadAddress(personId) -->
        //
        //
        throw new RuntimeException("Not implemented");
    }

}
