package org.cardna.presentation.ui.login.viewmodel

import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.annotations.SerializedName
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.cardna.data.local.singleton.CardNaRepository
import org.cardna.data.remote.model.auth.RequestAuthData
import org.cardna.data.remote.model.auth.RequestLoginData
import org.cardna.domain.repository.AuthRepository
import org.cardna.domain.repository.CardRepository
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class LogInViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _kakaoLoginSuccess = MutableLiveData<Boolean>(false)
    val kakaoLoginSuccess: LiveData<Boolean> = _kakaoLoginSuccess

    fun loginWithKakao(accessToken: String, platForm: String) {

        viewModelScope.launch {
            runCatching {
                CardNaRepository.userToken = accessToken  //일단 레파지토리에 유저토큰 저장함->인터셉트 하도록
                authRepository.getLogin(platForm) //로그인 서버통신
            }.onSuccess {
                Log.d("ㅡㅡㅡㅡㅡㅡㅡㅡ토큰ㅡㅡㅡㅡㅡㅡㅡ", CardNaRepository.userToken)
                Log.d("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ", it.message)
                Log.d("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ", it.data.type ?: "fsfs")
                Log.d("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ", it.data.uuid ?: "fddd")

                _kakaoLoginSuccess.value = true
                it.run {
                    CardNaRepository.uuId = data.uuid  //유저아이디 저장
                    CardNaRepository.social = data.social  //소셜타입저장
                    Log.d("ㅡㅡㅡㅡㅡㅡㅡ  CardNaRepository.uuIdㅡㅡㅡㅡㅡㅡㅡ", CardNaRepository.uuId.toString())
                    Log.d("ㅡㅡㅡㅡㅡㅡCardNaRepository.socialㅡㅡㅡㅡㅡㅡㅡㅡ", CardNaRepository.social)

                }
            }.onFailure {
                _kakaoLoginSuccess.value = false
                Timber.e(it.toString())
            }
        }
    }

    fun postAuth() {
        viewModelScope.launch {
            runCatching {
                authRepository.postAuth(
                    //리퀘스트 데이터 나머지부분은 쉐프에 꽂아둔거 바로 박아둠
                    RequestAuthData(
                        lastName = "박",  //이름 뷰에서 받아옴
                        firstName = "종찬"  //이름 뷰에서 바다옴
                    )
                )
            }.onSuccess {
                CardNaRepository.userToken = it.data.accessToken  //서버가 준 토큰으로 갱신
                CardNaRepository.firstName = it.data.name  //서버가 준 토큰으로 갱신
            //    CardNaRepository.lastName = it.data.name  //서버가 준 토큰으로 갱신
                Log.d("ㅡㅡㅡㅡㅡㅡㅡㅡ토큰ㅡㅡㅡㅡㅡㅡㅡ", CardNaRepository.userToken)
                Log.d("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ", it.message)
                Log.d("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ", it.data.name)
                Log.d("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ", it.data.code)
                Log.d("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ", it.data.accessToken)

            }.onFailure {
                Timber.e(it.toString())
            }
        }
    }
}