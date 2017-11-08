package com.hannesdorfmann.ex1

import io.reactivex.Observable

class TestView() : View {

    override fun buttonClicked(): Observable<Boolean> = Observable.just(true)
}