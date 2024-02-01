package com.example.musictherapy.data.repository

import com.example.musictherapy.data.Resources
import com.example.musictherapy.domain.repository.AuthRepository
import com.example.musictherapy.utils.await
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val firebaseUser: FirebaseAuth,
) : AuthRepository {

    override val currentUser: FirebaseUser?
        get() = firebaseUser.currentUser

    override suspend fun signInWithEmailAndPassword(
        email: String,
        password: String
    ): Resources<FirebaseUser> {
        return try {
            val result = firebaseUser.signInWithEmailAndPassword(email , password).await()
            Resources.Success(result.user!!)
        }
        catch (e : Exception){
            e.printStackTrace()
            Resources.Failure(e)
        }
    }

    override suspend fun signUpWithEmailAndPassword(
        name: String,
        email: String,
        password: String
    ): Resources<FirebaseUser> {
        return try {
            val result = firebaseUser.createUserWithEmailAndPassword(email , password).await()
            result?.user?.updateProfile(UserProfileChangeRequest.Builder().setDisplayName(name).build())?.await()
            Resources.Success(result.user!!)
        }
        catch (e : Exception){
            e.printStackTrace()
            Resources.Failure(e)
        }
    }

    override fun signOut() {
        return firebaseUser.signOut()
    }

}