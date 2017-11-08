package com.hannesdorfmann.ex2;

import io.reactivex.Observable;

public interface View {

    /**
     * Emittes the id of the person
     */
    Observable<Integer> onPersonClicked();

}
