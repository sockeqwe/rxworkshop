package com.hannesdorfmann.ex3;

import io.reactivex.Observable;

import java.util.Set;

public interface ContactsDatabase {

    /**
     * Returns the ids of the favorite contacts of the users.
     * Since it is an observable, it can change over time.
     *
     * @return
     */
    Observable<Set<Integer>> favoriteContacts();
}
