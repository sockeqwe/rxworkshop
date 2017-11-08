package com.hannesdorfmann.ex2

import io.reactivex.Observable

class TestBackend : Backend {
    companion object {
        val PERSON_DATA = listOf(Person(1, "Franz", "Beckenbauer"), Person(2, "Mats", "Hummels"))
        val ADDRESS_DATA = mapOf(2 to Address("Kronprinzstraße 2", "Dortmund"), 1 to Address("Kaiserallee 52", "Munich") )
    }

    override fun loadPerson(personId : Int): Observable<Person> = Observable.fromCallable {
        println("Backend: >> Loading Person with id = $personId")
        Thread.sleep(800)
        println("Backend: << Response for Person with id = $personId")
        PERSON_DATA.find { it.id == personId }
    }

    override fun loadAddress(personId : Int): Observable<Address> = Observable.fromCallable {
        println("Backend: >> Loading Address for Person with id = $personId")
        Thread.sleep(800)
        println("Backend: << Response for Address for Person with id = $personId")
        ADDRESS_DATA[personId]!!
    }
}