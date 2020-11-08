package com.example.ecommerce.firebase

import android.content.Context
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.preference.PreferenceManager
import com.example.ecommerce.R
import kotlin.random.Random

class LoginViewModel : ViewModel() {

    companion object {
        val androidFacts = arrayOf("little sweets that amaze you",
                                                "a little sugar to wake up the taste buds",
                                                "sugar your life")

    }

    enum class AuthenticationState {
        AUTHENTICATED, UNAUTHENTICATED, INVALID_AUTHENTICATION
    }

    val authenticationState = Transformations.map(FirebaseUserLiveData()){ user ->
        if (user != null) {
            AuthenticationState.AUTHENTICATED
        } else {
            AuthenticationState.UNAUTHENTICATED
        }
    }


    fun getFactToDisplay(context: Context): String {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        val factTypePreferenceKey = context.getString(R.string.preference_fact_type_key)
        val defaultFactType = context.resources.getStringArray(R.array.fact_type)[0]
        val funFactType = sharedPreferences.getString(factTypePreferenceKey, defaultFactType)

        return androidFacts[Random.nextInt(0, androidFacts.size)]
    }
}