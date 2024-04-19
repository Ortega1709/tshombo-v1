package com.ortega.tshombo.feature.auth.domain.useCase

import com.ortega.tshombo.core.utils.PreferencesManager
import com.ortega.tshombo.core.utils.Resource
import javax.inject.Inject

class UserLogout @Inject constructor(private val preferencesManager: PreferencesManager) {

    operator fun invoke(onSuccess: () -> Unit) {
        preferencesManager.clearData()
        onSuccess()
    }

}