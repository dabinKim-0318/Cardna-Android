<br />
<p align='center'>
🃏내가 소개하는 나와 남이 소개하는 나를 통해 다양한 나를 소개하는 서비스의  앱🃏
 </p>
<p align='center'>
<img width="800" alt="01" src="https://user-images.githubusercontent.com/84564695/188057657-e3a046da-66b9-4bb3-ae4b-d31c978ff6c0.png">
 </p>
 

 <p align='center'>
 <a href='https://play.google.com/store/apps/details?id=org.cardna'><img height="60px" src='https://play.google.com/intl/en/badges/images/generic/ko_badge_web_generic.png'/></a>
 </p>
 
<p align='center'>
    <img src="https://img.shields.io/badge/kotlin-v1.6.21-blue?logo=kotlin"/>
    <img src="https://img.shields.io/badge/Retrofit2-v2.9.0-green?logo=Retrofit2"/>
    <img src="https://img.shields.io/badge/Hilt-v2.40.5-yellow?logo=Hilt"/>
 </p>
<p align='center'>
    <img src="https://img.shields.io/badge/Moshi-v1.12.0-brightgreen?logo=Moshi"/>
    <img src="https://img.shields.io/badge/Lifecycle-v2.4.1-blue?logo=Lifecycle"/>
    <img src="https://img.shields.io/badge/OkHttp-v4.9.2-orange?logo=OkHttp"/>
    <img src="https://img.shields.io/badge/Timber-v5.0.1-blue?logo=Ttimber">
</p>

<br>


# 📌 [목차](#index) <a name = "index"></a>

- [프로젝트 동기](#reason)
- [아이디어/개요](#outline)
- [아키텍처](#structure)
- [사용한 기술에 대한 근거](#why)
- [결과물](#outputs)
- [회고 및 배운점](#learn)

# 📌Documents

| 기획              |       안드로이드       |    서버      |  디자인
| ------------------------------------------------------- | -------------------------------------------------------- | --------------------------------------------------------- | --------------------------------------------------------- |
| [카드나 핵심가치](https://www.notion.so/Long-ver-be5ebd6b990d4c56849d98cfc898f28b) | [회의록](https://different-beauty-15c.notion.site/dac2e48d5b81462f92d2a3cf3b051d14) |  [API문서](https://www.notion.so/New-API-Docs-294e926f6a5d4e7cb394106ef2f34ce4)  | [결과물](https://www.figma.com/file/4t3K5qxeRuRuPJtHksqCkB/CARDNA_forRelease?node-id=2112%3A6244)   |
| [솔루션](https://different-beauty-15c.notion.site/22-01-07-_-247ef96112ff4e339eb2fab905e82609) | [백로그](https://different-beauty-15c.notion.site/3d9c76d3cf454423bf73f0e281e58f2c) |  [테스트 보고서](https://different-beauty-15c.notion.site/d91ef35f23124bb9bfcce894b8c864ef)  | [브랜딩](https://www.figma.com/file/n3qiBYZdQSJvC0PZpdE7nD/CARDNA_Branding?node-id=0%3A1) |
| [기능명세서](https://different-beauty-15c.notion.site/22-01-07-_-247ef96112ff4e339eb2fab905e82609) | [팀 규칙](https://different-beauty-15c.notion.site/11457041511e438fa090ffe75309273c) |  [디버깅 보고서](https://different-beauty-15c.notion.site/d4236b72f27643569f34e416bfc9a736)  | [인스타그램 광고](https://www.figma.com/file/UMsF9GhB4TTNXZJ6w5ySTx/%EC%9D%B8%EC%8A%A4%ED%83%80-%ED%99%8D%EB%B3%B4-%EC%9D%B4%EB%AF%B8%EC%A7%80?node-id=0%3A1) |
| [IA](https://www.figma.com/file/yFDoaIbeHDp2UiI8wCWUJI/CARDNA_IA?node-id=0%3A1) | [추억모음](https://different-beauty-15c.notion.site/578607f2e513416d90792f4d1d622403?v=99f328cd0d0e406ba27d8f035fbdfbeb) |   [회고](https://different-beauty-15c.notion.site/73b76775ff9e49148458191784fc8657) | [스크린샷](https://www.figma.com/file/2QeO2Pd0V5cwpsK7MJLUN4/CARDNA_Screenshot?node-id=0%3A1) |
| [와이어프레임](https://www.figma.com/file/RaCTGRNPmp0e69uLAodMo5/CARDNA_wireframe) | [회고](https://www.notion.so/2-50d943e8c0e241b591e002cd9afbfd7a) |    |  


***

# 📌함께하는 사람들

| [김다빈](https://github.com/dabinKim-0318)                | [이종찬](https://github.com/oxix97)                | [박민우](https://github.com/MinwooP)                | 
| ------------------------------------------------------- | -------------------------------------------------------- | --------------------------------------------------------- |
| <img src="https://user-images.githubusercontent.com/84564695/190450439-e798897d-8049-421e-b54c-919a582a6c5d.png" width="100"> | <img src="https://user-images.githubusercontent.com/84564695/188060617-9cc2fc03-7b57-4c75-8495-84a5ac9289c1.png" width="100"> | <img src="https://user-images.githubusercontent.com/84564695/188060581-71acc75f-cbeb-45aa-b1d9-569ec568fe98.jpg" width="100"> | 


본 README는 [dabinKim-0318(김다빈)](https://github.com/dabinKim-0318)이 프로젝트를 회고하며,      
공부하고 배운점을 기록하기 위해 작성된 README입니다.    
upstream repository는 [이곳](https://github.com/TeamCARDNA/Cardna-Android)을 참고해주세요😊    


<br />

# 0️⃣ 프로젝트 동기 <a name = "reason"></a>
<details>
   <summary> Click 🙋‍♀️</summary>
<br />

- 안드로이드 개발자가 되겠다고 결심한 이후, 패스트캠퍼스 강의를 들으면 안드로이드 개발을 독학하고 있었습니다. 혼자 공부하는 것에 한계를 느껴 여러 개발 블로그들을 찾아보는데 많은 개발자 분들이 SOPT29기를 수료하셨던 걸 봤고, SOPT가 굉장히 크고 좋은 IT연합 동아리라는걸 알게되었습니다. 

- 이후 감사하게도 SOPT29기 안드로이드 파트에서 활동할 수 있게되었습니다. 남들보다 늦게 개발을 시작했다고 생각했기 때문에 더 열심히 하고 싶었습니다. 매주 세미나를 듣고 과제를 제출해야하는데 매번 배우는 새로운 기술을 직접 구현하고 바로바로 결과물을 볼 수 있는게 재미있어서 LEVEL3 과제까지 매번 하곤 했습니다. 코드리뷰도 받아보고 리뷰 반영도 하면서 점점 성장하는 제 자신을 보는게 뿌듯했고, 안드로이드 개발도 즐거워서 열심히 하다보니 과제 제출 2등이라는 결실도 얻었습니다. 
- 과제를 통해 빠르게 안드로이드 개발 실력을 쌓을 수 있었고 SOPT 장기 해커톤인 APPJAM에서 개발 리더를 맡게될 만큼 성장할 수 있었습니다. 평소 콘텐츠가 중심이 되는 서비스를 개발해보고 싶다고 생각했기 때문에 이미지형 콘텐츠를 만들고 공유하는 '카드나' 프로젝트에 합류하기로 결정했습니다. 
 

 </details>

<br>

# 1️⃣ 아이디어/개요 <a name = "outline"></a>

<details>
   <summary> Click 🙋‍♀️</summary>
<br />
 
![Menu tree](https://user-images.githubusercontent.com/84564695/188065643-00edaa66-ff4b-4ed0-8603-c2b0f43a09fb.png)


카드나는, 
내가 소개하는 나와 남이 소개하는 나를 통해 다양한 나를 발견하는 서비스입니다.

현재 제공 되는 4가지 핵심 기능은 다음과 같습니다.

✔ 카드나 작성: 내가 아는 다양한 나를 카드로 만들어 표현합니다   
✔ 카드너 작성: 타인이 나에 대한 카드를 만들어줍니다   
✔ 대표카드: 카드나, 카드너 중 7장의 카드를 골라 대표카드로 설정합니다   
✔ 인사이트: 가장 많은 공감버튼을 받은 카드를 통해 나에 대해 알 수 있습니다    



</details>

<br>

# 2️⃣ 아키텍처  <a name = "structure"></a>

<details>
   <summary> Click 🙋‍♀️</summary>
<br />

  <img width="300" src = "https://user-images.githubusercontent.com/84564695/184577351-59081ffd-2860-47b7-9da2-f093c633d71a.JPG" />
  <img width="400" src = "https://user-images.githubusercontent.com/84564695/184577995-8802595a-c1b9-40ec-8d6f-693666478756.png" />   


- 모바일 앱 사용자 환경을 올바르게 제공하기 위해 안드로이드 권장 아키텍쳐를 참고    
- data / domain / presentation 로 layer를 나누고 패키징을 통해 관심사 분리    
- Repository Pattern 을 사용해 DataSource 캡슐화
- ViewModel, LiveData 등의 Jetpack Component를 활용해 UI Controller의 과도한 책임을 막고 역할 분리

</details>

<br>

# 3️⃣ 사용한 기술에 대한 근거  <a name = "why"></a>

<details>
   <summary> Click 🙋‍♀️</summary>
<br />

- 각 Stack의 링크를 클릭하시면 공부하며 작성했던 포스팅으로 이동합니다!

| Category | Stack  | Reason |
|:---|:---|:---|
| Jetpack Components | [Room](https://velog.io/@dabin/%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9CSQLite) | 유저가 삭제한 카드의 id를 저장 후 컨텐츠를 필터링하기 위해 Room을 사용했습니다. 신고한 유저가 없을 경우 반드시 서버에서 데이터를 요청할 필요가 없기 때문에 local에 데이터를 저장해 사용하기로 결정했습니다. 신고 횟수에 제한이 없고 저장해야할 id의 수가 많아질 수 있다는 점을 고려해 sharedPreferences 대신 Room을 선택했습니다. |
| |[LiveData](https://velog.io/@dabin/%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-%EA%B3%B5%EC%8B%9D%EB%AC%B8%EC%84%9C-%ED%8C%8C%ED%97%A4%EC%B9%98%EA%B8%B0-LiveData%EC%9D%98-%EB%AA%A8%EB%93%A0-%EA%B2%83) | 최신 data가 생명주기에 따라 자동으로 업데이트 되도록하기 위해 LiveData를 사용했습니다  |
| |[ViewModel](https://velog.io/@dabin/%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9CviewModel-%EC%83%9D%EC%84%B1%EC%97%90-%EB%8C%80%ED%95%9C-%EA%B3%A0%EC%B0%B0) | 인스턴스가 소멸된 후 다시 onCreate 가 호출되며 인스턴스로 새로 생성되어도 데이터가 초기화되지 않도록 ViewModel을 사용했습니다. onSaveInstanceState()로 UI Data를 저장할 수도 있었겠지만, 대량의 UI Data를 복원하기에 적합하지 않다고 판단했습니다. 또한 서버, 데이터베이스에 접근하는 코드를 UI Controller와 분리하기 위해 ViewModel을 사용했습니다.
| |[DataBinding](https://velog.io/@dabin/%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9CDataBinding) | findViewById 메서드에 비해, null safety, type safety 부분에서 장점이 있는 DataBinding을 사용했습니다. ViewBinding이 DataBinding보다 퍼포먼스 효율, 용량 측면에서 장점이 있지만 DataBinding은 ViewBinding역할을 할 수 있을 뿐더러, 레이아웃에서 데이터 연결 작업을 통한 역할 분리를 위해 DataBinding을 선택했습니다. |
| Dependency Injection | [Hilt](https://velog.io/@dabin/%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-HiltRepository%ED%8C%A8%ED%84%B4) | 클래스간 결합도를 낮추고 원활한 리팩토링을 위해 DI를 적용했습니다. ViewModel에 대한 의존성 주입을 구현하기 편리하고 각 컴포넌트의 라이프 사이클을 자동으로 관리해주는 Hilt를 DI Framework로 활용했습니다. Hilt가 Dagger2를 기반으로 만들어졌기 때문에 Hilt에 대한 이해를 높이기 위해 Dagger2도 함께 공부할 계획입니다 |
| Network | [Retrofit2](https://velog.io/@dabin/%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-Android-%ED%86%B5%EC%8B%A0-%EB%9D%BC%EC%9D%B4%EB%B8%8C%EB%9F%AC%EB%A6%AC%EC%9D%98-%EC%97%AD%EC%82%AC#%EA%B3%B5%EB%B6%80%EB%B0%B0%EA%B2%BD) | 안드로이드 통신 라이브러리의 역사를 공부하면서 Deprecated된 라이브러리들과(HttpClient 등) Volley, OkHttp, Retrofit의 장단점을 비교하며 공부했습니다. 그 결과 개인적으로는 Annotation으로 HTTP 메소드를 정의해서 사용하는 Retrofit이 전체 구조를 파악하기 더 좋은 것 같아 Retrofit을 선택했습니다. JSON을 파싱해주는 Converter 연동을 지원해주기 때문에 Gson 라이브러리와 함께 사용하기 위해 선택했습니다.    |
|  |[OkHttp3](https://velog.io/@dabin/%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-Android-%ED%86%B5%EC%8B%A0-%EB%9D%BC%EC%9D%B4%EB%B8%8C%EB%9F%AC%EB%A6%AC%EC%9D%98-%EC%97%AD%EC%82%AC#android-%ED%86%B5%EC%8B%A0-%EB%9D%BC%EC%9D%B4%EB%B8%8C%EB%9F%AC%EB%A6%AC%EC%9D%98-%EC%97%AD%EC%82%AC) |  Intercepter를 통해 API가 통신되는 모든 활동을 모니터링하고, 서버 통신 시간을 조절하기 위해 사용했습니다. 또한 Retrofit2을 사용했기 때문에, Retrofit2가 의존하는 OkHttp3를 함께 사용하는게 좋겠다고 생각했습니다. |
| Asynchronous Processing | [Coroutine](https://velog.io/@dabin/%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-%EC%BD%94%EB%A3%A8%ED%8B%B4-%EC%8B%A4%EC%8A%B5) | api요청 시 callback을 사용하지 않고 비동기 처리를 하기 위해 Coroutine을 사용했습니다.  직관적인 함수 사용을 통해 코드의 가독성도 높일 수 있었습니다 |
| Third Party Library | Social Login | 사용자의 회원가입 과정의 번거로움을 피하기 위해 네이버, 카카오 SDK를 사용해 소셜 로그인을 구현했습니다. |
|  | Lottie | 스플래시 화면에서 애니메이션 처리가 필요했고, 고품질 애니메이션을 처리할 때 발생할 수 있는 OOM을 피하기 위해 애니메이션 라이브러리를 사용하기로 결정했습니다. 그중 백터 기반이라 용량이 적고 적용이 간단한 Lottie라이브러리를 활용했습니다. |
|  |Timber | 릴리즈 버전에서 로그를 출력하지 않고, 태그를 별도로 입력하지 않아도 되는 Timber을 사용해 Log를 남겼습니다 |
|  |Gson | Json형식인 응답 데이터를 java로 파싱하기 위해 Gson라이브러리를 사용했습니다.  |
| CI/CD | GitHub Action| Github Action으로 Build 과정을 검사했습니다. develop 브랜치로 병합 이후 발생한 손상을 즉시 해결 함으로 추후 손상을 해결하는 시간을 줄였습니다. |
| Other Tool | Slack, Notion, Figma, Postman | 팀원간 이슈 알림을 위해 Slack을 사용했고, 작업 진행상황공유와 디자인 작업, 백엔드 파트원과의 커뮤니케이션 등을 위해 해당 Tool들을 사용했습니다 |

</details>


<br>

# 4️⃣ 결과물  <a name = "outputs"></a>

<details>
   <summary> Click 🙋‍♀️</summary>
<br />
 

### ✔ 회원가입

<img width="220" src = "https://user-images.githubusercontent.com/84564695/188070317-4f1eb7b0-569c-4206-9494-eb580a51653b.png" /><img width="200" src = "https://user-images.githubusercontent.com/84564695/188070662-c442b337-30ab-4feb-84ca-4d7a4c625c1c.png" /> <img width="198" src = "https://user-images.githubusercontent.com/84564695/188070802-a0586548-0130-461e-89aa-d613c68e2c4b.png" /> <img width="200" src = "https://user-images.githubusercontent.com/84564695/188070798-8e2d7f48-3548-40ac-82ff-eb0e2736ccef.png" /> 
  
 - Naver, Kakao 소셜로그인
 - 이름 입력 후 회원가입
 - 온보딩
 - 대표카드 만들어보기

 ### ✔ 대표카드
<img width="220" src = "https://user-images.githubusercontent.com/84564695/188071076-ad795785-1f17-47ae-8094-8f5c0b6b28d6.png" /> <img width="198" src = "https://user-images.githubusercontent.com/84564695/188071984-cb726227-b512-43d9-b814-9979b982a347.png" /> <img width="200" src = "https://user-images.githubusercontent.com/84564695/188072008-d8380f1f-e852-41b3-8447-3e3262fd63f6.png" /> 

  - 대표카드 7장 보기
  - 대표카드 수정
  - 친구요청, 취소
 
 <br/><br/>  

  ### ✔ 카드팩
<img width="220" src = "https://user-images.githubusercontent.com/84564695/188072174-7a2e5019-3c5f-4cfe-943b-874a23df8356.png" /> <img width="200" src = "https://user-images.githubusercontent.com/84564695/188072348-23475c05-32d2-4e01-bdb1-ba977f850b50.png" /> <img width="200" src = "https://user-images.githubusercontent.com/84564695/188072358-424fdd2a-0f0e-45f1-9b00-dd80a305e92c.png" />
 
  - 내가 작성한 카드 모아보기
  - 타인이 작성한 카드 모아보기
  - 카드 작성하기
 
 <br/><br/>  



### ✔ 카드 상세보기
<img width="220" src = "https://user-images.githubusercontent.com/84564695/188072464-aefe5408-ae40-4e48-8d7c-64fd8005829d.png" /> <img width="178" src = "https://user-images.githubusercontent.com/84564695/188073573-f1775752-ec5b-4707-a78d-6c363ca49824.png" /> <img width="200" src = "https://user-images.githubusercontent.com/84564695/188072609-ff12b9f5-2350-4242-9859-10b82c03ae21.png" />

  - 작성인, 작성날짜, 내용 상세보기
  - 카드 공유하기(카카오톡, 인스타그램 등)
  - 갤러리에 저장하기

   <br/><br/>  

 
### ✔ 인사이트
<img width="220" src = "https://user-images.githubusercontent.com/84564695/188073040-eb636ed0-2809-44fc-bc58-0bab04f6e5a7.png" />  <img width="200" src = "https://user-images.githubusercontent.com/84564695/188073582-27470cec-8fe4-4cfd-8aae-85be70b27773.png" /> <img width="198" src = "https://user-images.githubusercontent.com/84564695/188073097-4c149711-61ad-473b-a8be-9c98c0ef02f4.png" />
 
  - 내가 작성한 카드 중 가장 공감을 많이 받은 카드 보기
  - 타인이 작성한 카드 중 가장 공감을 많이 받은 카드 보기
  - 카드너 보관함 리스트 보기
  
 <br/><br/>  


### ✔ 카드작성
<img width="220" src = "https://user-images.githubusercontent.com/84564695/188074104-6146af7e-305b-49ba-aab2-9cd8b3f81f91.png" /> <img width="200" src = "https://user-images.githubusercontent.com/84564695/188074158-8cebb183-b9ca-480e-afff-dd3a427fc437.png" /> <img width="176" src = "https://user-images.githubusercontent.com/84564695/188074160-9f8ad4bc-15aa-4ba2-83d1-8c4261d8980c.png" />
  

  - 사진 선택하기
  - 작성자 이름
  - 내용

### ✔ 마이페이지
<img width="220" src = "https://user-images.githubusercontent.com/84564695/188074490-f2f20f15-1c4f-4d1e-aa06-debeab10bf72.png" />  <img width="200" src = "https://user-images.githubusercontent.com/84564695/188074639-a1e4c930-f0af-4b9a-b668-dee6c0b83fd5.png" /> <img width="198" src = "https://user-images.githubusercontent.com/84564695/188074633-a060985e-152b-43dd-a5e6-f976b1827def.png" />
  
  - 내 정보 보기
  - 친구 리스트 보기
  - 친구 코드로 검색하기 


### ✔ 설정
<img width="220" src = "https://user-images.githubusercontent.com/84564695/188074498-55960716-bc9e-4cd2-9081-266f73a7b6bc.png" /> <img width="200" src = "https://user-images.githubusercontent.com/84564695/188074817-1ac3c8d7-147a-48c0-944f-724f262d2759.png" /> <img width="198" src = "https://user-images.githubusercontent.com/84564695/188074822-0c6890f7-a853-4f16-9b30-f3ad87d270ed.png" />
  

  - 로그인 정보
  - 버전 정보
  - 탈퇴
  - 로그아웃

</details>


<br>

# 5️⃣ 회고 및 배운 점 <a name = "learn"></a>
<details>
   <summary> Click 🙋‍♀️</summary>
<br />

## ✔ 커뮤니케이션 부분

<img width="220" alt="화면 캡처 2022-09-02 222217" src="https://user-images.githubusercontent.com/84564695/188155124-7ade7072-18b2-40f7-9e94-3892fe7b182f.png">

<img width="600" alt="화면 캡처 2022-09-02 222437" src="https://user-images.githubusercontent.com/84564695/188155889-55eedc8c-9486-4615-adb8-611f0d0b9567.png">

### ◼ 안드로이드 파트 리더
카드나 프로젝트에서 안드로이드 파트 리더로서 팀을 이끄는 역할을 했습니다. 당시 개발 프로젝트가 처음인 상황에서 리더 역할을 맡게되어 팀을 잘 이끌 수 있을까 많은 걱정을 했습니다. 2주간 합숙을 하면서 하나의 서비스를 완성하게 되는데, 합숙 전 안드로이드 팀원들끼리 친해지는 게 이후 소통에서도 매우 중요할 것이라 생각했습니다. 그래서 서로 친해질 수 있는 계기를 만들기 위해 노력했고, 이후 프로젝트를 진행하면서 서로의 의견을 나누고 소통하는 데 큰 도움이 됐습니다. 정해진 기한 내에 안드로이드 파트가 개발을 다 끝내지 못하면 기획, iOS, 백엔드 파트원들의 일정에도 영향이 가기 때문에 책임감있게 팀을 이끌기 위해 노력했습니다. 원활한 작업을 위해 역할분담, 이슈관리 등 타임라인에 맞춰 작업이 원활히 진행되도록 전체적인 일정을 관리했습니다. 특히 다른 팀원들이 해결하기 어려워하는 문제가 있거나 지식 공유가 필요한 순간이 많았습니다. 합숙을 할 땐 바로 옆에서 같이 고민하고, 제가 아는 내용도 잘 설명해줄 수 있었지만 합숙 이후 온라인으로 소통해야 할 땐 소통에 한계가 있었습니다. 그래서 바로바로 의견을 나누고 지식을 공유할 수 있도록 '질문밖에 안드'라는 채팅방을 만들었습니다. 덕분에 오프라인만큼 활발하게 의견이 오고갈 수 있었고, 저도 팀원들이 질문해주는 내용을 통해 제가 아는 내용을 점검하고 몰랐던 부분도 알게되는 등 많은 도움을 받았습니다. 이를 통해 지식 공유는 단순히 지식을 나누는 것을 넘어 같이 배우고 성장할 수 있는 방법이라는 것을 알게되었습니다



<br>

## ✔ 기술적인 부분
### ◼ MVC -> MVVM 리팩토링
공식적인 개발 프로젝트 기간인 2주동안은 MVC패턴으로 프로젝트를 완성했습니다. 최종 발표까지 마친 이후 릴리즈 준비를 위한 기간에 팀원 간 회의를 통해 원활한 유지보수, 성능최적화 등을 위해 MVVM아키텍쳐로 리팩토링하기로 했습니다. MVC패턴을 사용했을 땐 UI컨트롤러가 UI Data를 모두 보유하고 있었기 때문에 코드를 읽기 어려웠고 관심사 분리가 되지 않아 컴포넌트 별 의존성 또한 매우 높은 상태였습니다. MVVM으로 리팩토링을 하면서 StateHolder의 필요성을 가장 크게 느꼈습니다.ViewModel을 사용한 덕분에 UI Controller의 수명주기가 끝나도 UI Data는 초기화되지 않아 원활한 사용자 흐름을 제공할 수 있었기 때문입니다. DataBinding을 통해 View의 의존성을 낮췄고, LiveData사용으로 UI Data업데이트 관리도 수월하게 할 수 있었습니다. MVVM패턴이나 해당 Jetpack component들을 처음부터 사용했으면 이같은 기능의 등장배경, 필요성을 공감하기 어려웠을 것이란 생각이 들었습니다. 리팩토링을 한 덕분에 릴리즈 이후 유지보수를 하는 데 큰 도움이 되었고 안드로이드 권장 아키텍쳐에 대해 깊게 공부한 계기가 되기도 했습니다

<br>

### ◼ 공식문서를 보는 습관
카드에 들어가는 이미지를 서버와 주고받기 위해 Multipart타입을 이용했고, 회원가입 과정의 편리함을 위해 네이버, 카카오 소셜로그인을 구현했습니다. Multipart, Kakao SDK, Naver SDK를 처음 사용해보면서 새로운 기술에 대한 두려움 때문에 잘 구현할 수 있을 지 막막하기도 했습니다. 이해가 되지 않는 부분은 공식문서를 포함해 다양한 개발 블로그를 참고해 직접 해결하기 위해 노력했고 그래도 이해가 되지 않으면  안드로이드 공식 유튜브, 미디엄 등을 참고해 꼼꼼히 공부했습니다. 이외에도 크고 작은 이슈와 오류들을 마주할 때 포기하지 않고 해결하기 위해 노력하면서 "공식문서를 가장 먼저 보는 습관"이 매우 중요하다는 것을 알게됐습니다. 다른 사람이 작성한 개발 문서를 보는 것도 도움이 되지만 틀린 내용이 있을 수 있고, 보통 중요 내용만 요약된 정보들이 많이 때문에 세세한 동작원리나 구체적인 내용을 알기엔 한계가 있었기 때문입니다. 현재 안드로이드 공식문서를 분석하고 제 언어로 정리한 ['Android Developers 파헤치기 시리즈'](https://velog.io/@dabin/series/Android-Developers-%ED%8C%8C%ED%97%A4%EC%B9%98%EA%B8%B0)를 연재하고 있습니다. 직접 문서를 해석하고 정리하니 기억에 더 잘 남았고 기초적인 부분도 한번 더 학습하고 복습할 수 있었습니다.

<br>

### ◼ 프로젝트 중에 생긴 기술적 어려움
<img width="260" alt="화면 캡처 2022-09-02 222437" src="https://user-images.githubusercontent.com/84564695/191574083-cc90e058-cfa2-4806-a8d1-f42e9a9da130.png">



알림 뷰에서는 최근 알림 3개만 보여지고 상단 버튼을 눌러 리스트를 접고 펼쳐볼 수 있도록 구현해야 했습니다. 해당 리스트가 RecyclerView로 구성되어 있기 때문에 item 개수가 정해진 RecyclerView구현이 필요했는데 기존에 개발해본 적 없던 방식이라 어떻게 해야할 지 고민이 들었습니다. 고민 끝에 Adapter에서 리스트의 상태 변경을 나타내는 status를 선언해 해결해보았습니다!

```kotlin
class FriendRequestAdapter() : androidx.recyclerview.widget.ListAdapter<ResponseGetAlarmData.Data.Request.Requester, FriendRequestAdapter.FriendRequestViewHolder>(diffUtil) {
  
  var loadStatus = true  //처음엔 접힌 상태로 시작
  
   override fun getItemCount() =
        if (loadStatus) {  //접힌 상태
            if (AlarmActivity.DEFAULT_COUNT > currentList.size) {
                currentList.size
            } else {
                AlarmActivity.DEFAULT_COUNT
            }
        } else {
            currentList.size  //펼친 상태라면 모든 아이템을 그린다
        }
```

- Adapter의 getItemCount()를 오버라이딩 할 때 사용자의 클릭 이벤트에 따라 loadStatus가 true/false로 변경되도록 선언 한 뒤 접힌상태인지 아닌지에 따라 리턴되는 아이템 개수를 변경했습니다.

```kotlin
    private fun setUnfoldListener(adapter: FriendRequestAdapter) {

        binding.tvAlarmFriendViewAll.setOnClickListener {
            if (adapter.loadStatus) {
                binding.tvAlarmFriendViewAll.text = COLLAPSE_LIST
                adapter.loadStatus = false
            } else {
                binding.tvAlarmFriendViewAll.text = VIEW_ALL
                adapter.loadStatus = true
            }
            friendRequestAdapter.notifyDataSetChanged()  //리스트 크기 매번 변경해야함으로 사용
        }
    }
```
- AlarmActivity에서는 adapter의 loadStatus에 따라 버튼의 TEXT를 접기/펼치기로 바꾸고 loadStatus 값을 초기화했습니다

<br>

## ✔ 개인적인 성장
### ◼ 개발 프로젝트 진행 과정

<img width="860" alt="화면 캡처 2022-09-02 222437" src="https://user-images.githubusercontent.com/84564695/191571534-a28ea897-acf3-4eaa-b8f5-4c133bd0a313.png">



카드나 프로젝트 시작 전까지 혼자 패스트캠퍼스 강의, SOPT과제, 개인 프로젝트를 통해 안드로이드 개발을 해왔었습니다. 때문에 다른 안드로이드 팀원, 파트원들과 협업하는 프로젝트는 처음이었습니다. 소프트웨어 공학 수업을 들으면서 이론으로만 배웠던 스크럼 회의, 유지보수 등을 실제로 경험하니 하나의 서비스가 만들어지는 과정을 깊이 알게됐습니다. 카드나 프로젝트를 통해 기획, 디자인, 브랜딩, 개발 시작단계와 릴리즈 이후 프로젝트 전반에 걸쳐 해야할 일과 일정을 관리하는 법을 배울 수 있었습니다. 특히 기간 안에 API를 연결해본 경험이 없었기 때문에, 연결해야할 API가 몇개 쯤일 때 작업시간이 어느정도 걸리겠다와 같은 예상이 가지 않았는데 이번 프로젝트 이후로 작업 난이도, 작업 시간 등을 예상할 수 있게 되었고 이에 따라 일정을 조율하는 방법도 알게되었습니다.

<br>

### ◼ 디자이너, 서버개발자, 기획자와의 첫 협업

<img width="860" alt="화면 캡처 2022-09-02 222437" src="https://user-images.githubusercontent.com/84564695/191575147-9877669b-8c47-4263-8d61-1cab7d8cffef.png">

개발자는 기능명세서, IA, 와이어 프레임을 보고 바로 개발을 시작할 수 있다고 생각했습니다. 하지만 개발자는 기획단계에서 기획자만큼 서비스의 플로우를 잘 알아야 하고 단순히 IA, 와이어프레임을 보고 개발만 하는게 아니라 기간 내에 가능한 기능인지, 가능하지 않다면 어떤 대안이 있는지 등을 함께 고민하고 제안해야 한다는 것을 알게됐습니다. 또한 기획자에게 더 좋은 유저플로우를 제안할 수도 있을 만큼 기획 의도를 깊이 이해하고 있어야 한다고 생각했습니다. 안드로이드 개발자처럼 프론트엔드 개발자는 디자이너와의 소통도 매우 중요하다는 것을 느꼈습니다. 에셋 네이밍 규칙이나 스크롤, 픽스 영역 표시 등 작은 부분도 맞춰가야 디자이너가 의도했던 레이아웃을 빠르고 정확하게 구현할 수 있기 때문입니다. 더불어 API문서를 만들기에 앞서 백엔드 개발자와 데이터 형식, 엔드포인트 등을 함께 협의했고 이에 맞춰 미리 비즈니스 로직을 작성한 덕분에 작업효율을 향상시킬 수 있었습니다

<br>

### ◼ git Flow 사용
git flow를 활용하는 것은 이번이 처음이었는데, 협업에서 git Flow가 얼마나 중요한 지 알게되었씁니다. 처음에 develop브랜치를 만들고 팀원들은 개발 시에 feature 브런치를 만들어 그곳에 작업을 한 후 최종 develop브랜치에 머지하는 과정을 거쳤습니다. pr을 보내고 코드리뷰를 하는 과정, 머지 과정에서 발생하는 conflict를 해결하고, 다른 팀원이 만든 코드를 받으면서 어떤식으로 협업하는 지 잘 알게 되었습니다. 특히 저희 프로젝트는 fork 기능을 활용해 develop브랜치에 불필요한 기록이 남도록 하였는데 이 부분이 develop브랜치를 관리하는 데 매우 유용하고 편리한 방법이라고 느꼈습니다.

<br>

### ◼ 사용자 관점에서 개선하기 위한 노력

<img width="220" src = "https://user-images.githubusercontent.com/84564695/188072464-aefe5408-ae40-4e48-8d7c-64fd8005829d.png" />

서비스 이용자 관점에서 카드 상세 페이지를 봤을 때, 기존 디자인에선 공감버튼 아이콘과 개수를 나타내는 textView 에 테두리가 없어서 배경 이미지가 검은색일 경우 해당 View들이 가려지는 현상이 있었습니다. 그래서 디자이너 파트원들에게 View와 배경과 구분될 수 있는 테두리를 넣는게 어떨지 제안했습니다. 디자인 파트원들이 생각지 못했던 좋은 부분이라고 말해주며 디자인을 개선해 주었습니다. View에 테두리를 그리기 위해선 커스텀 뷰를 사용해야하는 번거러움이 있지만 사용자 관점에서 조금이라도 불편한 점이 있으면 먼저 제안하고 함께 개선하기 위해 노력하려 했습니다. 이를 통해 안드로이드 개발자는 개발자임과 동시에 서비스 이용자가 되어야 한다는 것을 배웠고, 앞으로도 사소하다고 생각되는 부분도 개선하기 위해 더 나은 방향을 제안해야 겠다고 생각했습니다.

</details>

<br>


