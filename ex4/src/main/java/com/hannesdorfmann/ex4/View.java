package com.hannesdorfmann.ex4;

import io.reactivex.Observable;

public interface View {

    Observable<String> onSearchTextchanged();
}
