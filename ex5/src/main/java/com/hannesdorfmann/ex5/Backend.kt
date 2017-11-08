package com.hannesdorfmann.ex5

import io.reactivex.Observable
import java.time.LocalDateTime
import java.util.concurrent.atomic.AtomicInteger

class Backend {
    private val tries = AtomicInteger()

    fun getSalt() : Observable<String> = Observable.fromCallable {
        println("Backend: >> received at "+LocalDateTime.now())
        if (tries.getAndIncrement() < 3)
            throw Exception("Fake Exception")

        "Some random salt"
    }

}