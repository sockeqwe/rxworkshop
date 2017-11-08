package com.hannesdorfmann.ex3

import io.reactivex.Observable
import io.reactivex.observers.TestObserver
import io.reactivex.subjects.PublishSubject
import org.junit.Assert
import org.junit.Test
import kotlin.system.measureTimeMillis

class RepositoryTest {

    @Test
    fun loadPersons() {

        val favs = PublishSubject.create<Set<Int>>()

        val db = object : ContactsDatabase {

            override fun favoriteContacts() =
                    favs.doOnNext { println("Favorite contacts changed: $it") }
        }


        val subscriber = TestObserver<List<PersonWithAddress>>()

        val repo = Repository(TestBackend(), db)
        repo.loadFavorites().subscribeWith(subscriber)
        favs.onNext(emptySet())
        Thread.sleep(500)
        favs.onNext(setOf(1))
        Thread.sleep(200)
        favs.onNext(emptySet())
        favs.onNext(setOf(1,2))
        favs.onComplete()

        subscriber.awaitTerminalEvent()

        subscriber.assertComplete()
        subscriber.assertNoErrors()
        Assert.assertEquals(listOf(
                emptyList(),
                listOf( PersonWithAddress(TestBackend.PERSON_DATA[0], TestBackend.ADDRESS_DATA[1]!!)),
                emptyList(),
                listOf(
                PersonWithAddress(TestBackend.PERSON_DATA[0], TestBackend.ADDRESS_DATA[1]!!),
                PersonWithAddress(TestBackend.PERSON_DATA[1], TestBackend.ADDRESS_DATA[2]!!)
        )),
                subscriber.values())

    }

}