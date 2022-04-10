package org.cardna.presentation.ui.login.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.cardna.data.local.singleton.CardNaRepository
import org.cardna.data.remote.model.auth.RequestLoginData
import org.cardna.domain.repository.AuthRepository
import org.cardna.domain.repository.CardRepository
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class LogInViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _kakaoLoginSuccessWithName = MutableLiveData<Pair<Boolean, String?>>(false to null)
    val kakaoLoginSuccessWithName: LiveData<Pair<Boolean, String?>> = _kakaoLoginSuccessWithName

    private val _kakaoLogInSuccess = MutableLiveData<Boolean>()
    val kakaoLogInSuccess: LiveData<Boolean> = _kakaoLogInSuccess

    fun loginWithKakao(accessToken: String) {

        viewModelScope.launch {
            runCatching {
                CardNaRepository.userToken = accessToken
                authRepository.getLogin("kakao")
            }.onSuccess {
                Log.d("ㅡㅡㅡㅡㅡㅡㅡㅡ토큰ㅡㅡㅡㅡㅡㅡㅡ", CardNaRepository.userToken)
                Log.d("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ", it.message)
                Log.d("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ", it.data.type ?: "fsfs")
                Log.d("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ", it.data.uuid ?: "fddd")
                _kakaoLogInSuccess.value = true
            }.onFailure {
                _kakaoLogInSuccess.value = false
                Timber.e(it.toString())
            }
        }
    }

}