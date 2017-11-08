package com.hannesdorfmann.ex3

import io.reactivex.Observable

class TestBackend : Backend {
    companion object {
        val PERSON_DATA = listOf(Person(1, "Franz", "Beckenbauer"), Person(2, "Mats", "Hummels"))
        val ADDRESS_DATA = mapOf(2 to Address("Kronprinzstraße 2", "Dortmund"), 1 to Address("Kaiserallee 52", "Munich") )
        val all = listOf(PersonWithAddress(PERSON_DATA[0], ADDRESS_DATA[1]!!), PersonWithAddress(PERSON_DATA[1], ADDRESS_DATA[2]!!))
    }

    override fun loadAllPersons(): Observable<List<PersonWithAddress>> = Observable.fromCallable {
        println("Backend: >> Loading all persons")
        Thread.sleep(200)
        println("Backend: << Response all Persons")
        all
    }
}