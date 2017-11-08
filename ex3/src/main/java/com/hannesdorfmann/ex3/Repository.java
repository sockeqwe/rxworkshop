package com.hannesdorfmann.ex3;

import io.reactivex.Observable;

import java.util.List;
import java.util.stream.Collectors;

public class Repository {
    private final Backend backend;
    private final ContactsDatabase contactsDatabase;

    public Repository(Backend backend, ContactsDatabase contactsDatabase) {
        this.backend = backend;
        this.contactsDatabase = contactsDatabase;
    }


    public Observable<List<PersonWithAddress>> loadFavorites() {
        //
        // TODO: Provide an observable that only emits a list of PersonWithAddress if they are marked as favorite ones.
        //
        // return <-- your code to somehow load all Persons + Addresses from backend, You also need to load the favorites from contactsDatabase -->
        //
        //
        throw new RuntimeException("Not implemented");
    }


}
