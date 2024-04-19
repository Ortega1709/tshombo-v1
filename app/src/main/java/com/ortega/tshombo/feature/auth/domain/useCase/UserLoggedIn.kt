package com.ortega.tshombo.feature.auth.domain.useCase

import com.ortega.tshombo.core.utils.PreferencesManager
import javax.inject.Inject

class UserLoggedIn @Inject constructor(private val preferencesManager: PreferencesManager) {

    suspend operator fun invoke(onUser: () -> Unit, onAdmin: () -> Unit, onError: () -> Unit) {
        val userId = preferencesManager.getData("userId", "")
        val role = preferencesManager.getData("role", "")

        if (userId != "") {
            if (role == "ADMIN") {
                onAdmin()
            } else {
                onUser()
            }
        } else {
            onError()
        }
    }

}