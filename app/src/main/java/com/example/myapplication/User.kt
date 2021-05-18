package com.example.myapplication

data class User (
    val name: String,
    val id: Int,
    val available: Boolean,
    val msgCount: Int
){
    constructor (name: String) :  this(name,-1,false,-1)
}

