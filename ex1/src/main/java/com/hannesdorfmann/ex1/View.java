package com.hannesdorfmann.ex1;

import io.reactivex.Observable;

public interface View {

    Observable<Boolean> buttonClicked();

}
