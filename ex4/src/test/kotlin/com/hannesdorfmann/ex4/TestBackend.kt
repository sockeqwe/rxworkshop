package com.hannesdorfmann.ex4

import io.reactivex.Observable
import java.util.concurrent.CopyOnWriteArrayList
import java.util.concurrent.CopyOnWriteArraySet

class TestBackend : Backend {

    val PEOPLE = listOf(Person("Franz", "Beckenbauer"),
            Person("Franz", "Kafka"),
            Person("Thomas", "Müller")
    )

    val queries = CopyOnWriteArrayList<String>()

    override fun searchfor(searchFor: String): Observable<List<Person>> = Observable.create { emmiter ->
        queries += searchFor
        println("backend: >> start searching for $searchFor")
        try {
            Thread.sleep(400)
        } catch (t : Throwable){
        }
        if (!emmiter.isDisposed) {
            println("backend << result for $searchFor")
            emmiter.onNext(search(searchFor))
            emmiter.onComplete()
        }
    }

    fun search(searchFor  : String) = PEOPLE.filter { it.firstname.startsWith(searchFor) }
}