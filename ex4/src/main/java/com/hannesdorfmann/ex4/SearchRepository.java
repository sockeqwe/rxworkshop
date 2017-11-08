package com.hannesdorfmann.ex4;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchRepository {
    private View view;
    private Backend backend;

    public SearchRepository(View view, Backend backend) {
        this.view = view;
        this.backend = backend;
    }


    public Observable<List<Person>> search(){

        //
        // TODO: implement the search call according the follwing criterias:
        //  - The search query string must contain at least 3 characters
        //  - To save backend trafic: only search if searchquery hasn't changed within the last 300 ms
        //  - If the user is typing fast "Hannes" and than deletes and types "Hannes" again (exceeding 300 ms) the search should not execute twice.
        //

        throw new RuntimeException("Not implemented");
    }
}
