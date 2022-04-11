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

    private val _signUpWithKakaoSuccess = MutableLiveData<Boolean>(false)
    val signUpWithKakaoSuccess: LiveData<Boolean> = _signUpWithKakaoSuccess

    private val _signInWithKakaoSuccess = MutableLiveData<Boolean>(false)
    val signInWithKakaoSuccess: LiveData<Boolean> = _signInWithKakaoSuccess

    private val _loginWithNaverSuccess = MutableLiveData<Boolean>(false)
    val loginWithNaverSuccess: LiveData<Boolean> = _loginWithNaverSuccess

    private val _setNameSuccess = MutableLiveData<Boolean>(false)
    val setNameSuccess: LiveData<Boolean> = _setNameSuccess

    //새로운 유저 가입 또는 탈퇴한 유저 재가입
    fun signUpWithKakao(accessToken: String) {
        Log.d("ㅡㅡㅡㅡㅡㅡsignUpWithKakaoㅡㅡㅡㅡㅡㅡㅡ", "가입")
        viewModelScope.launch {
            runCatching {
                CardNaRepository.userToken = accessToken  //일단 레파지토리에 유저토큰 저장함->인터셉트 하도록
                authRepository.getSignUp("kakao") //로그인 서버통신
            }.onSuccess {
                it.run {
                    CardNaRepository.uuId = data.uuid  //유저아이디 저장
                    CardNaRepository.social = data.social  //소셜타입저장

                    Log.d("ㅡㅡㅡㅡㅡㅡsignUpWithKakaoㅡㅡㅡㅡㅡㅡㅡ", CardNaRepository.uuId.toString())
                    Log.d("ㅡㅡㅡㅡㅡㅡsignUpWithKakaoㅡㅡㅡㅡㅡㅡㅡ", CardNaRepository.social)
                    Log.d("ㅡㅡㅡㅡㅡㅡsignUpWithKakaoㅡㅡㅡㅡㅡㅡㅡ", CardNaRepository.userToken)

                    _signUpWithKakaoSuccess.value = true
                }
            }.onFailure {
                _signUpWithKakaoSuccess.value = false
                Timber.e(it.toString())
            }
        }
    }

    //다시 로그인하는 경우
    fun signInWithKakao(accessToken: String) {
        viewModelScope.launch {
            runCatching {
                CardNaRepository.userToken = accessToken  //일단 레파지토리에 유저토큰 저장함->인터셉트 하도록
                authRepository.getSignIn("kakao") //로그인 서버통신
            }.onSuccess {
                it.run {
                    CardNaRepository.userToken = data.accessToken  //유저코튼갱신
                    CardNaRepository.logOut = false
                    _signInWithKakaoSuccess.value = true
                }
            }.onFailure {
                _signInWithKakaoSuccess.value = false
                Timber.e(it.toString())
            }
        }
    }


    //AAAAO8FQZvgkBh1wAAHKWSHuTUvIMtWyAP2OgPgKQkX/GSGSNYzD98XpW0iDVaerjXojlWE+mh3GBVZ3lRvuMDxQqnw=
    fun loginWithNaver(accessToken: String) {
        Log.d("ㅡㅡㅡㅡㅡㅡㅡㅡloginWithNaverㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ", accessToken.toString())
        viewModelScope.launch {
            runCatching {
                CardNaRepository.userToken = "AAAAO36E2O3Sxr8epGZ1gNQL5Yw+1iogn32zl44wHAc/dHDcKx1wKw75xQjcq/apNmFhwTjRD3zYmnL+M3Z4s2/78O4="  //일단 레파지토리에 유저토큰 저장함->인터셉트 하도록
                Log.d("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ", accessToken.toString())
                authRepository.getSignUp("naver") //로그인 서버통신
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
        Log.d("ㅡㅡㅡㅡㅡㅡpostAuthㅡㅡㅡㅡㅡㅡㅡ", lastName + firstName)
        Log.d("ㅡㅡㅡㅡㅡㅡpostAuthㅡㅡㅡㅡㅡㅡㅡ", CardNaRepository.fireBaseToken)
        Log.d("ㅡㅡㅡㅡㅡㅡpostAuthㅡㅡㅡㅡㅡㅡㅡ", CardNaRepository.social)
        Log.d("ㅡㅡㅡㅡㅡㅡpostAuthㅡㅡㅡㅡㅡㅡㅡ", CardNaRepository.userToken)
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
                Log.d("ㅡㅡㅡㅡㅡㅡpostAuthvvvvvㅡㅡㅡㅡㅡㅡㅡㅡ", it.message)
                Log.d("ㅡㅡㅡㅡㅡㅡpostAuthvvvvvㅡㅡㅡㅡㅡㅡㅡㅡ", it.data.name)
                Log.d("ㅡㅡㅡㅡㅡpostAuthvvvvㅡㅡㅡㅡㅡㅡㅡㅡㅡ", it.data.code)
                Log.d("ㅡㅡㅡㅡㅡㅡpostAuthvvvㅡㅡㅡㅡㅡㅡㅡㅡ", it.data.accessToken)

            }.onFailure {
                _setNameSuccess.value = false
                Timber.e(it.toString())
            }
        }
    }
}