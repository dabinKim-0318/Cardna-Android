package org.cardna.presentation.ui.login.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.cardna.data.local.singleton.CardNaRepository
import org.cardna.data.remote.model.auth.RequestAuthData
import org.cardna.domain.repository.AuthRepository
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class LogInViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _loginWithKakaoSuccess = MutableLiveData<Boolean>(false)
    val loginWithKakaoSuccess: LiveData<Boolean> = _loginWithKakaoSuccess

    private val _loginWithNaverSuccess = MutableLiveData<Boolean>(false)
    val loginWithNaverSuccess: LiveData<Boolean> = _loginWithNaverSuccess

    private val _setNameSuccess = MutableLiveData<Boolean>(false)
    val setNameSuccess: LiveData<Boolean> = _setNameSuccess

    fun loginWithKakao(accessToken: String) {

        viewModelScope.launch {
            runCatching {
                CardNaRepository.userToken = accessToken  //일단 레파지토리에 유저토큰 저장함->인터셉트 하도록
                authRepository.getLogin("kakao") //로그인 서버통신
            }.onSuccess {
                Log.d("ㅡㅡㅡㅡㅡㅡㅡㅡ토큰ㅡㅡㅡㅡㅡㅡㅡ", CardNaRepository.userToken)
                Log.d("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ", it.message)
                Log.d("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ", it.data.type ?: "fsfs")
                Log.d("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ", it.data.uuid ?: "fddd")

                _loginWithKakaoSuccess.value = true
                it.run {
                    CardNaRepository.uuId = data.uuid  //유저아이디 저장
                    CardNaRepository.social = data.social  //소셜타입저장
                    Log.d("ㅡㅡㅡㅡㅡㅡㅡ  CardNaRepository.uuIdㅡㅡㅡㅡㅡㅡㅡ", CardNaRepository.uuId.toString())
                    Log.d("ㅡㅡㅡㅡㅡㅡCardNaRepository.socialㅡㅡㅡㅡㅡㅡㅡㅡ", CardNaRepository.social)

                }
            }.onFailure {
                _loginWithKakaoSuccess.value = false
                Timber.e(it.toString())
            }
        }
    }
    //AAAAO8FQZvgkBh1wAAHKWSHuTUvIMtWyAP2OgPgKQkX/GSGSNYzD98XpW0iDVaerjXojlWE+mh3GBVZ3lRvuMDxQqnw=
    fun loginWithNaver(accessToken: String) {
        Log.d("ㅡㅡㅡㅡㅡㅡㅡㅡloginWithNaverㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ",accessToken.toString())
        viewModelScope.launch {
            runCatching {
                CardNaRepository.userToken = accessToken  //일단 레파지토리에 유저토큰 저장함->인터셉트 하도록
                Log.d("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ",accessToken.toString())
                authRepository.getLogin("naver") //로그인 서버통신
            }.onSuccess {
                Log.d("ㅡㅡㅡㅡㅡㅡㅡㅡ토큰ㅡㅡㅡㅡㅡㅡㅡ", CardNaRepository.userToken)
                Log.d("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ", it.message)
                Log.d("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ", it.data.type ?: "fsfs")
                Log.d("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ", it.data.uuid ?: "fddd")

                _loginWithNaverSuccess.value = true
                it.run {
                    CardNaRepository.uuId = data.uuid  //유저아이디 저장
                    CardNaRepository.social = data.social  //소셜타입저장
                    Log.d("ㅡㅡㅡㅡㅡㅡㅡ  CardNaRepository.uuIdㅡㅡㅡㅡㅡㅡㅡ", CardNaRepository.uuId.toString())
                    Log.d("ㅡㅡㅡㅡㅡㅡCardNaRepository.socialㅡㅡㅡㅡㅡㅡㅡㅡ", CardNaRepository.social)

                }
            }.onFailure {
                _loginWithNaverSuccess.value = false
                Timber.e(it.toString())
            }
        }
    }


    fun postAuth(lastName: String, firstName: String) {
        viewModelScope.launch {
            runCatching {
                authRepository.postAuth(
                    //리퀘스트 데이터 나머지부분은 쉐프에 꽂아둔거 바로 박아둠
                    RequestAuthData(
                        lastName = lastName,  //이름 뷰에서 받아옴
                        firstName = firstName  //이름 뷰에서 바다옴
                    )
                )
            }.onSuccess {
                _setNameSuccess.value = true
                CardNaRepository.userToken = it.data.accessToken  //서버가 준 토큰으로 갱신
                CardNaRepository.firstName = it.data.name  //이름 완전히 들어가면 가입된 사람이란거임
                //    CardNaRepository.lastName = it.data.name  //서버가 준 토큰으로 갱신
                Log.d("ㅡㅡㅡㅡㅡㅡㅡㅡ토큰ㅡㅡㅡㅡㅡㅡㅡ", CardNaRepository.userToken)
                Log.d("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ", it.message)
                Log.d("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ", it.data.name)
                Log.d("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ", it.data.code)
                Log.d("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ", it.data.accessToken)

            }.onFailure {
                _setNameSuccess.value = false
                Timber.e(it.toString())
            }
        }
    }
}