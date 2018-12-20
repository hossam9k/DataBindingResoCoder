package com.mvvm.job

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.util.*

object FakeRepository {

    private val fruitNames = listOf(
        "Apple", "Banana", "Orange", "Kiwi", "Grapes", "Fig",
        "Pear", "Strawberry", "Gooseberry", "Raspberry"
    )

    //because we don't want to expose mutable live data outside classes
    // because mutable live data  value can be changed we only want to
    // expose live data which value cannot be changed
    //we want to change it from FakeRepository not from outside
    private val _currentRandomFruitName = MutableLiveData<String>()
    //val currentRandomFruitName = _currentRandomFruitName as LiveData<String>
    //Automatically cast to LiveData
    val currentRandomFruitName: LiveData<String>
    get() = _currentRandomFruitName

    init {
        _currentRandomFruitName.value = fruitNames.first()
    }

    fun getRandomFruitName(): String{
        val random = Random()
        return fruitNames[random.nextInt(fruitNames.size)]
    }

    fun changeCurrentRandomFruitName(){
        _currentRandomFruitName.value = getRandomFruitName()
    }
}



























