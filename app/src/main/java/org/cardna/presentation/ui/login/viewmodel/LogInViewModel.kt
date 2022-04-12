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

    //새로운 유저 가입 또는 탈퇴한 유저 재가입 -> firstName이 없는 경우임
    fun signUpWithKakao(accessToken: String) {
        Log.d("ㅡㅡㅡㅡㅡㅡsignUpWithKakaoㅡㅡㅡㅡㅡㅡㅡ", "가입")
        viewModelScope.launch {
            runCatching {
                CardNaRepository.userToken = accessToken  //일단 레파지토리에 카카오에서 준 토큰 저장함->인터셉트 하도록
                authRepository.getSignUp("kakao") //로그인 서버통신
            }.onSuccess {
                it.run {
                    //   CardNaRepository.kakaoUuId = data.uuid  //서버에서 준 유저아이디 저장
                    //    CardNaRepository.kakaoSocial = data.social  //서버에서 준 소셜타입저장
                    CardNaRepository.userUuid = data.uuid
                    CardNaRepository.userSocial = data.social
                    Log.d("ㅡㅡㅡㅡㅡㅡsignUpWithKakaoㅡㅡㅡㅡㅡㅡㅡ", CardNaRepository.userUuid)
                    Log.d("ㅡㅡㅡㅡㅡㅡsignUpWithKakaoㅡㅡㅡㅡㅡㅡㅡ", CardNaRepository.userSocial)

                    _signUpWithKakaoSuccess.value = true
                }
            }.onFailure {
                _signUpWithKakaoSuccess.value = false
                Timber.e(it.toString())
            }
        }
    }

    //새로운 유저 가입 또는 탈퇴한 유저 재가입 -> firstName이 없는 경우임
    fun signUpWithNaver(accessToken: String) {
        Log.d("ㅡㅡㅡㅡㅡㅡsignUpWithNaverㅡㅡㅡㅡㅡㅡㅡ", "가입")
        viewModelScope.launch {
            runCatching {
                CardNaRepository.kakaoUserToken = accessToken  //일단 레파지토리에 카카오에서 준 토큰 저장함->인터셉트 하도록
                authRepository.getSignUp("naver") //로그인 서버통신
            }.onSuccess {
                it.run {
                    CardNaRepository.kakaoUuId = data.uuid  //서버에서 준 유저아이디 저장
                    CardNaRepository.kakaoSocial = data.social  //서버에서 준 소셜타입저장
                    //여기까지 하면 유저아이디, 소셜타입 저장되어있음 -> RequestAuthData 에 필요한 애들 저장 끝.
                    Log.d("ㅡㅡㅡㅡㅡㅡsignUpWithNaverㅡㅡㅡㅡㅡㅡㅡ", CardNaRepository.kakaoUuId.toString())
                    Log.d("ㅡㅡㅡㅡㅡㅡsignUpWithNaverㅡㅡㅡㅡㅡㅡㅡ", CardNaRepository.kakaoSocial)
                    Log.d("ㅡㅡㅡㅡㅡㅡsignUpWithNaverㅡㅡㅡㅡㅡㅡㅡ", CardNaRepository.kakaoUserToken)

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
                    CardNaRepository.kakaoUserToken = data.accessToken  //유저코튼갱신
                    CardNaRepository.kakaoUserRefreshToken = data.refreshToken  //유저리프레시토큰갱신
                    CardNaRepository.kakaoUserlogOut = false //로그아웃 초기화
                    CardNaRepository.userToken = data.accessToken //인터셉트 토큰 초기화
                    CardNaRepository.userSocial = "kakao" //최종 소셜 업데이트
                    _signInWithKakaoSuccess.value = true
                }
            }.onFailure {
                _signInWithKakaoSuccess.value = false
                Timber.e(it.toString())
            }
        }
    }

    //다시 로그인하는 경우
    fun signInWithNaver(accessToken: String) {
        viewModelScope.launch {
            runCatching {
                CardNaRepository.kakaoUserToken = accessToken  //일단 레파지토리에 유저토큰 저장함->인터셉트 하도록
                authRepository.getSignIn("naver") //로그인 서버통신
            }.onSuccess {
                it.run {
                    CardNaRepository.kakaoUserToken = data.accessToken  //유저코튼갱신
                    CardNaRepository.kakaoUserToken = data.refreshToken  //유저리프레시토큰갱신
                    CardNaRepository.kakaoUserlogOut = false
                    CardNaRepository.kakaoSocial = "naver"
                    _signInWithKakaoSuccess.value = true
                }
            }.onFailure {
                _signInWithKakaoSuccess.value = false
                Timber.e(it.toString())
            }
        }
    }


    //회원가입 완료하기->찐 accessToken, refreshToken 얻어오기
    fun postAuth(lastName: String, firstName: String) {
        Log.d("ㅡㅡㅡㅡㅡㅡpostAuthㅡㅡㅡㅡㅡㅡㅡ", lastName + firstName)
        Log.d("ㅡㅡㅡㅡㅡㅡpostAuthㅡㅡㅡㅡㅡㅡㅡ", CardNaRepository.fireBaseToken)
        Log.d("ㅡㅡㅡㅡㅡㅡpostAuthㅡㅡㅡㅡㅡㅡㅡ", CardNaRepository.userSocial)
        Log.d("ㅡㅡㅡㅡㅡㅡpostAuthㅡㅡㅡㅡㅡㅡㅡ", CardNaRepository.userUuid)
        viewModelScope.launch {
            runCatching {
                authRepository.postAuth(
                    RequestAuthData(
                        lastName = lastName,  //이름 뷰에서 받아옴
                        firstName = firstName  //이름 뷰에서 바다옴
                    )
                )
            }.onSuccess {
                CardNaRepository.kakaoUserToken = it.data.accessToken  //서버가 준 찐 토큰으로 갱신
                CardNaRepository.kakaoUserRefreshToken = it.data.refreshToken  //서버가 준 찐 리프레시 토큰으로 갱신
                CardNaRepository.kakaoUserfirstName = it.data.name  //이름 완전히 들어가면 가입된 사람이란거임
                CardNaRepository.userToken = it.data.accessToken    //최종적으로 인터셉트할 토큰
                Log.d("ㅡㅡㅡㅡㅡㅡㅡㅡ토큰ㅡㅡㅡㅡㅡㅡㅡ", CardNaRepository.kakaoUserToken)
                Log.d("ㅡㅡㅡㅡㅡㅡpostAuthvvvvvㅡㅡㅡㅡㅡㅡㅡㅡ", it.message)
                Log.d("ㅡㅡㅡㅡㅡㅡpostAuthvvvvvㅡㅡㅡㅡㅡㅡㅡㅡ", it.data.name)
                Log.d("ㅡㅡㅡㅡㅡpostAuthvvvvㅡㅡㅡㅡㅡㅡㅡㅡㅡ", it.data.code)
                Log.d("ㅡㅡㅡㅡㅡㅡpostAuthvvvㅡㅡㅡㅡㅡㅡㅡㅡ", it.data.accessToken)
                Log.d("ㅡㅡㅡㅡㅡㅡpostAuthvvvㅡㅡㅡㅡㅡㅡㅡㅡ", it.data.refreshToken)

                _setNameSuccess.value = true
            }.onFailure {
                _setNameSuccess.value = false
                Timber.e(it.toString())
            }
        }
    }
}