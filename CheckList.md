# 봇 구동 체크리스트

* 무작정 안된다고만 하면 무엇이 원인인지 알 수 없는거에요.
* 봇 구동 앱이 작동하지 않는다면 읽어보는 것을 권장하는거에요.

<hr>

## 0. 봇 구동 앱을 깔았는데 채팅방에 봇이 없어요.
* 원래 없는게 정상이에요. 본인이 카톡을 보고 있지 않는 동안 봇 구동 앱이 대신 답장을 보내주는 방식이에요.
* [이 게시글](https://blog.naver.com/dt3141592/221552431910)을 읽어주세요.

<hr>

## 1. 봇 자체가 작동하지 않아요.
* 봇 구동 앱 자체가 작동하지 않는 것 같은 경우.

### 1-1. 카톡 알림은 켰나요?
* 봇 구동 앱은 상단바에 카톡 알림이 떠야 카톡 수신을 인식할 수 있어요.
* 따라서, 상단바에 카톡 알림이 뜨지 않는다면 카톡이 온걸 인식하지 못하기에, 봇이 작동하지 않아요.

### 1-2. 알림 접근 허용을 했나요?
* 봇 구동 앱이 상단바에 뜬 알림에 접근할 수 있어야, 채팅이 수신된 것을 인식할 수 있어요.
* `채팅 자동응답 봇`의 경우, 알림 접근을 허용하지 않으면 봇 사용 자체를 막아버린거에요.

### 1-3. 안드로이드 웨어 (Wear OS)를 설치했나요?
* 안드로이드 7.0 미만인 경우,
  * 봇 구동 앱은 해당 앱을 통해서 답장을 전송하기 때문에, 해당 앱을 설치해야 봇이 말을 할 수 있어요.
  * 설치만 하면 되는거에요. 별도의 설정을 할 필요는 없어요.
* 안드로이드 7.0 이상인 경우,
  * 설치하지 않아도 잘 작동하는거에요.
  * 만약 모든 항목들을 확인하였어도 작동하지 않는다면 설치해보시는 것을 권장하는거에요.
  * 만약, 이미 설치하셨고, 봇이 두 번씩 답한다면, 삭제해보시는 것을 권장하는거에요.

### 1-4. 봇은 켰나요?
* 각각의 봇들을 on/off 시키는 스위치도 있고, 봇 작동 자체를 on/off 시키는 스위치도 있어요. 둘 다 켜야 작동하는거에요.
* 봇을 꺼놓고 안된다고 하면 개발자가 때릴지도 몰라요?

### 1-5. 알림을 읽을 앱은 설정했나요?
* 카카오톡이 아닌 다른 앱에 반응하도록 설정했는지 확인해주세요.
* 기본적으로, `채팅 자동응답 봇`과  `메신저봇`은 카카오톡에 반응하도록 설정되어있어요.

### 1-6. 봇이 할 말은 설정했나요?
* 봇이 아무말도 하지 않도록 설정 또는 프로그래밍 해두고, 작동하지 않는다고 하시면 개발자가 때릴지도 몰라요?
* 특정 조건을 만족하면 봇이 반응하도록 구현했지만, 그 조건을 절대로 만족할 수 없는 조건이거나, 그 조건을 만족하도록 사용한 적이 없는 경우도 있어요.
  * ex1) 상대방이 보낸 채팅이 `실험`임과 동시에 `테스트`여야 작동하도록 한 경우
  * ex2) 방 이름이 `봇 테스트 방`일 때만 작동하도록 해두고, 방 이름이 `봇 테스트 방`이 아닌 방에서 봇 작동을 테스트한 경우

### 1-7. `단순 자동응답`, 특정 방에서만/사람에게만 작동.
* `채팅 자동응답 봇`의 `단순 자동응답` 기능에는 특정 방에서만 또는 특정한 사람이게만 반응하도록 하는 기능이 있어요.
* 해당 조건을 만족해야 작동하도록 설정해두고, 실제로는 만족하지 못하도록 만드신건 아닌지 확인해보세요.

### 1-8. `자바스크립트` 등, 리로드를 안한 경우
* 리로드를 하지 않으면 입력하신 소스 코드를 기계어로 번역하는 과정을 진행하지 않았기에 봇이 작동하지 않아요.
* 일반 자동응답 기능 역시 리로드가 필요해요. 리로드 버튼을 누르면 설정한 내용에 해당하는 소스 코드가 생성되고, 그 소스 코드를 기계어로 번역해서 반영하는 방식이에요.

### 1-9. `자바스크립트` 등, 리로드시 오류가 발생한 경우
* 프로그래밍을 통해 카톡봇을 만드는 경우, 본인이 작성한 소스에 오류가 있다면 작동하지 않는게 정상이에요
* 오류를 찾아서 소스를 올바르게 수정하시면 되는거에요.

<hr>

## 2. 봇이 디버깅 룸에서만 작동해요.

### 2-1. 본인이 보낸 채팅은 상단바에 알림이 뜨지 않아요.
* 상단바에 알림이 뜨지 않으니, 봇 구동 앱이 카톡 수신을 인식하지 못해서 봇이 작동하지 않아요

### 2-2. 자기 자신이 봇이 되는거에요.
* **[2-1.](https://github.com/DarkTornado/KakaoTalkBot/blob/master/CheckList.md#2-1-%EB%B3%B8%EC%9D%B8%EC%9D%B4-%EB%B3%B4%EB%82%B8-%EC%B1%84%ED%8C%85%EC%9D%80-%EC%83%81%EB%8B%A8%EB%B0%94%EC%97%90-%EC%95%8C%EB%A6%BC%EC%9D%B4-%EB%9C%A8%EC%A7%80-%EC%95%8A%EC%95%84%EC%9A%94)** 항목 및 [이 게시글](https://blog.naver.com/dt3141592/221552431910)을 참고해주세요.

### 2-3. 채팅방을 보고 있으면 봇이 작동하지 않아요.
* 채팅방 화면에 들어와있으면 카톡 알림이 뜨지 않으니, 봇 역시 작동하지 않아요.
* 봇 구동 앱은, 본인이 카톡을 보고 있지 않는 동안 대신 답장을 보내주는거에요.

### 2-4. 봇을 끄면 디버깅 룸에서만 작동해요.
* **[1-4.](https://github.com/DarkTornado/KakaoTalkBot/blob/master/CheckList.md#1-4-%EB%B4%87%EC%9D%80-%EC%BC%B0%EB%82%98%EC%9A%94)** 항목을 참고해주세요.

### 2-5. 지금 이 순간에 상단바에 카톡 알림이 뜨고 있는지 확인해주세요.
* 앱을 강제로 종료하거나, RAM을 정리하는 경우, 카톡 앱을 실행할 때 까지 상단바에 카톡 알림이 뜨지 않는 경우도 있어요.
* **[1-1.](https://github.com/DarkTornado/KakaoTalkBot/blob/master/CheckList.md#1-1-%EC%B9%B4%ED%86%A1-%EC%95%8C%EB%A6%BC%EC%9D%80-%EC%BC%B0%EB%82%98%EC%9A%94)** 항목을 참고해주세요.

### 2-6. 카톡 알림 내용을 숨기셨나요?
* 상단바에 뜬 카톡 알림에 누가 어디서 뭐라고 보냈는지 뜨지 않으면, 봇 구동 앱이 누가 어디서 뭐라고 보냈는지 알 수 없기에, 봇이 작동하지 않을 수 있어요.
* 정확히는, 알림 내용을 숨기면 알림을 통해 응답을 보내는 기능도 비활성화되면서, 봇 구동 앱이 카카오톡 알림 자체를 읽지 않아요.

### 2-7. 복제된 카카오톡에 반응하도록 했나요?
* 복제 방식에 따라, 봇 구동이 가능할 수도 있고 불가능할 수도 있어요.
* [이 게시글](https://blog.naver.com/dt3141592/221552431910)을 읽어주세요.

### 2-8. 봇 구동 앱이 메신저 앱에 반응하지 않도록 설정을 바꾸셨나요?
* 기본적으로 `채팅 자동응답 봇`은 `카카오톡`에, `메신저봇`은 `카카오톡`과 `페이스북 메신저`에 반응하도록 설정되어 있어요.
* 종종 그 설정을 건들여서 `카카오톡` 또는 `페이스북 메신저`에 반응하지 않도록 바꿔놓고 작동하지 않는다고 하는 경우가 있어요.
  * ex1) `채팅 자동응답 봇`에서 원래 적혀있던 `카카오톡의 패키지명(com.kakao.talk)`을 지우고 `앱 이름(카카오톡)`을 적는 경우
  * ex2) 그 어떠한 앱에도 반응하지 않도록 설정하는 경우

<hr>

## 3. 봇 구동 자체가 힘들거나 어려운 경우

### 3-1. 일부 기기 또는 환경에서는 상단바 자체가 존재하지 않거나, 존재해도 요상하게 작동하는거에요.
* 불행히도, 상단바의 상태가 똥망이거나 아예 없는지라, 봇 구동 앱 사용 자체가 불가능한거에요.

### 3-2. 일부 기기에서는 알림이 너무 많은 경우에 상단바에 뜨지 않아요.
* 즉, 카톡이 와도 시스템상에서 카톡이 왔다고 알려주지 않아서 봇 구동 앱이 반응하지 못해요.
* 채팅이 일정 횟수 이상 쌓이면 자동으로 읽는 기능을 구현하면 구동할 수 있는거에요.

### 3-3. 카톡 또는 봇 구동 앱이 죽은 경우
* 운영제체에 의하여 앱이 절전당할 수 있으니, 절전 대상에서 제외시켜보세요.

<hr>

## 4. 기타

### 4-1. 아무것도 하지 않은 경우
* `봇 구동 앱`은 달랑 앱 하나만 설치하면 본인이 상상했던 기능들이 자동으로 완성되는 마법 또는 그에 준하는 해킹을 보여주는 앱이 아니에요.

### 4-2. 사용자가 봇 구동 방식을 마음대로 상상하였는데, 그 상상이 현실과 다른 경우
* [Google Play 스토어](https://play.google.com/store/apps/details?id=com.darktornado.chatbot)에 있는 앱 설명 및 이 `체크리스트`를 읽어보세요.

### 4-3. 리로드시 무조건 앱이 종료되는 경우
* 저도 왜 그러는지는 모르겠는데, 가끔 그러는 일이 있는거에요.
* 기기 재부팅시 해결되었던거에요.

### 4-4. `단순자동응답`, 동일한 채팅을 연속으로 보내면 작동하지 않아요.
* 동일한 채팅이 연속으로 수신되면 가볍게 무시하는 기능인 `도배 방지` 기능은 기본적으로 활성화되는거에요.
* 봇마다 있는 봇 설정에서 끌 수 있는거에요.
