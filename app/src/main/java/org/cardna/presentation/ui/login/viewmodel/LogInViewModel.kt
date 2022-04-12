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
import org.cardna.presentation.ui.login.LoginActivity
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

    private val _signInWithNaverSuccess = MutableLiveData<Boolean>(false)
    val signInWithNaverSuccess: LiveData<Boolean> = _signInWithNaverSuccess

    private val _signUpWithNaverSuccess = MutableLiveData<Boolean>(false)
    val signUpWithNaverSuccess: LiveData<Boolean> = _signUpWithNaverSuccess

    private val _setNameSuccess = MutableLiveData<Boolean>(false)
    val setNameSuccess: LiveData<Boolean> = _setNameSuccess

    //카카오로 가입 또는 재가입
    fun signUpWithKakao(kakaoAccessToken: String) {
        Log.d("ㅡㅡㅡㅡㅡㅡsignUpWithKakaoㅡㅡㅡㅡㅡㅡㅡ", "카카오로 가입")

        viewModelScope.launch {
            runCatching {
                CardNaRepository.userToken = kakaoAccessToken  //일단 레파지토리에 카카오에서 준 토큰 저장함->인터셉트 하도록
                authRepository.getSignUp(LoginActivity.KAKAO) //회원가입 서버통신
            }.onSuccess {
                it.data.run {
                    CardNaRepository.userUuid = uuid
                    CardNaRepository.userSocial = social

                    _signUpWithKakaoSuccess.value = true
                }
            }.onFailure {
                _signUpWithKakaoSuccess.value = false
                Timber.e(it.toString())
            }
        }
    }

    //네이버로 가입 또는 재가입
    fun signUpWithNaver(naverAccessToken: String) {
        Log.d("ㅡㅡㅡㅡㅡㅡsignUpWithNaverㅡㅡㅡㅡㅡㅡㅡ", "네이버로 가입")
        viewModelScope.launch {
            runCatching {
                CardNaRepository.userToken = naverAccessToken  //일단 레파지토리에 카카오에서 준 토큰 저장함->인터셉트 하도록
                authRepository.getSignUp(LoginActivity.NAVER) //회원가입 서버통신
            }.onSuccess {
                it.data.run {
                    CardNaRepository.userUuid = uuid
                    CardNaRepository.userSocial = social

                    _signUpWithNaverSuccess.value = true
                }
            }.onFailure {
                _signUpWithNaverSuccess.value = false
                Timber.e(it.toString())
            }
        }
    }

    //카카오로 재로그인
    fun signInWithKakao(kakaoAccessToken: String) {
        viewModelScope.launch {
            runCatching {
                CardNaRepository.userToken = kakaoAccessToken  //일단 레파지토리에 유저토큰 저장함->인터셉트 하도록
                authRepository.getSignIn(LoginActivity.KAKAO) //로그인 서버통신
            }.onSuccess {
                it.data.run {
                    CardNaRepository.kakaoUserToken = accessToken  //유저코튼갱신
                    CardNaRepository.kakaoUserRefreshToken = refreshToken  //유저리프레시토큰갱신
                    CardNaRepository.userToken = accessToken //인터셉트 토큰 초기화
                    CardNaRepository.userSocial = LoginActivity.KAKAO
                    CardNaRepository.kakaoUserlogOut = false //로그아웃 초기화

                    _signInWithKakaoSuccess.value = true
                }
            }.onFailure {
                _signInWithKakaoSuccess.value = false
                Timber.e(it.toString())
            }
        }
    }

    //다시 로그인하는 경우
    fun signInWithNaver(naverAccessToken: String) {
        viewModelScope.launch {
            runCatching {
                CardNaRepository.userToken = naverAccessToken  //일단 레파지토리에 유저토큰 저장함->인터셉트 하도록
                authRepository.getSignIn(LoginActivity.NAVER) //로그인 서버통신
            }.onSuccess {
                it.data.run {
                    CardNaRepository.naverUserToken = accessToken  //유저코튼갱신
                    CardNaRepository.naverUserRefreshToken = refreshToken  //유저리프레시토큰갱신
                    CardNaRepository.userToken = accessToken //인터셉트 토큰 초기화
                    CardNaRepository.userSocial = LoginActivity.NAVER
                    CardNaRepository.naverUserlogOut = false //로그아웃 초기화

                    _signInWithNaverSuccess.value = true
                }
            }.onFailure {
                _signInWithNaverSuccess.value = false
                Timber.e(it.toString())
            }
        }
    }


    //회원가입 완료하기->찐 accessToken, refreshToken 얻어오기
    fun postAuth(lastName: String, firstName: String) {
        viewModelScope.launch {
            runCatching {
                authRepository.postAuth(
                    RequestAuthData(
                        lastName = lastName,  //이름 뷰에서 받아옴
                        firstName = firstName  //이름 뷰에서 바다옴
                    )
                )
            }.onSuccess {
                it.data.run {
                    when (CardNaRepository.userSocial) {
                        "kakao" -> {
                            CardNaRepository.kakaoUserToken = accessToken  //서버가 준 찐 토큰으로 갱신->어차피 리프레시로 재발급받을거긴 한데 일단..
                            CardNaRepository.kakaoUserRefreshToken = refreshToken  //서버가 준 찐 리프레시 토큰으로 갱신
                            CardNaRepository.kakaoUserfirstName = name
                        }
                        "naver" -> {
                            CardNaRepository.naverUserToken = accessToken  //서버가 준 찐 토큰으로 갱신->어차피 리프레시로 재발급받을거긴 한데 일단..
                            CardNaRepository.naverUserRefreshToken = refreshToken  //서버가 준 찐 리프레시 토큰으로 갱신
                            CardNaRepository.naverUserfirstName = name  //이름 완전히 들어가면 가입된 사람이란거임
                        }
                    }

                    CardNaRepository.userToken = it.data.accessToken       //최종적으로 인터셉트하면서 서버 통신할 토큰
                    _setNameSuccess.value = true

                    Log.d("ㅡㅡㅡㅡㅡㅡㅡㅡ토큰ㅡㅡㅡㅡㅡㅡㅡ", CardNaRepository.kakaoUserToken)
                    Log.d("ㅡㅡㅡㅡㅡㅡpostAuthvvvvvㅡㅡㅡㅡㅡㅡㅡㅡ", it.message)
                    Log.d("ㅡㅡㅡㅡㅡㅡpostAuthvvvvvㅡㅡㅡㅡㅡㅡㅡㅡ", it.data.name)
                    Log.d("ㅡㅡㅡㅡㅡpostAuthvvvvㅡㅡㅡㅡㅡㅡㅡㅡㅡ", it.data.code)
                    Log.d("ㅡㅡㅡㅡㅡㅡpostAuthvvvㅡㅡㅡㅡㅡㅡㅡㅡ", it.data.accessToken)
                    Log.d("ㅡㅡㅡㅡㅡㅡpostAuthvvvㅡㅡㅡㅡㅡㅡㅡㅡ", it.data.refreshToken)

                }
            }.onFailure {
                _setNameSuccess.value = false
                Timber.e(it.toString())
            }
        }
    }
}