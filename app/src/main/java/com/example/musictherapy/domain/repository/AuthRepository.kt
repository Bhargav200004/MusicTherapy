package com.example.musictherapy.domain.repository

import com.example.musictherapy.data.Resources
import com.google.firebase.auth.FirebaseUser

interface AuthRepository {

    val currentUser : FirebaseUser?

    suspend fun signInWithEmailAndPassword(email : String , password : String) : Resources<FirebaseUser>

    suspend fun signUpWithEmailAndPassword(name : String , email : String , password: String) : Resources<FirebaseUser>

    fun signOut()
}