# 채팅 자동응답 봇 레거시 API 레퍼런스
* 채팅 자동응답 봇 개발자가 이상한 사람이라 `레거시 API`와 [API2](Api2.md)를 동시에 사용할 수 있어요.

## Api
### boolean canReply(String room, String pack);
* 해당 채팅방으로 채팅을 보낼 수 있는지 반환해요. 
### boolean compile(String botName);
* `Api.reload();`와 동일
### void gc();
* 가비지 콜랙터를 강제로 실행해요.
### android.content.Content getContext();
* 봇 구동 서비스의 Context를 반환해요.
### String[] getRoomList(String packageName);
* 모든 방 목록을 불러와요.
* `packageName` 생략시 가장 최근에 알림이 수신된 메신저 앱을 기준으로 작동해요.
### String[] getScriptNames();
* 모든 봇 목록을 불러와요.
### boolean isOn(String botName);
* 해당 이름을 가진 봇이 켜졌는지 확인해요.
### boolean markAsRead(String room, String packageName);
* 해당 패키지명을 가진 메신저 앱의 해당 채팅방의 채팅을 읽음처리 해요.
* `packageName` 생략시 가장 최근에 알림이 수신된 메신저 앱을 기준으로 작동해요.
### String papagoTranslate(String lang1, String lang2, String value);
* 파파고 번역
### String papagoTranslate(String lang1, String lang2, String value, String id, String secret);
* 파파고 번역
### int prepare(String botName);
* 해당 이름을 가진 봇이 리로드된 적이 없다면 리로드해요. 리로드 된 적이 없으면 2, 리로드 성공시 1, 리로드 실패시 0을 반환해요.
### void off(String botName);
* 해당 이름을 가진 봇을 꺼요.
### void on(String botName);
* 해당 이름을 가진 봇을 켜요.
### boolean reload(String botName);
* 해당 이름을 가진 봇을 리로드해요.
### boolean replyRoom(String room, String msg, String pack);
* 이름이 `room`인 채팅방으로 `msg`를 보내요.
* `packageName` 생략시 가장 최근에 알림이 수신된 메신저 앱을 기준으로 작동해요.
### void showToast(String msg, int leng);
* `msg`를 토스트 메시지로 출력해요.
### void UIThread(Function func);
* UI 쓰레드에서 해당 함수를 실행해요
### boolean unload(String botName);
* 해당 이름을 가진 봇의 리로드를 풀어요.

## Bot
### android.content.Content getContext();
* 봇 구동 서비스의 Context를 반환해요.
### String getJsVersion();
* 자바스크립트의 버전을 반환해요
### String getVersion();
* 채팅 자동응답 봇의 버전을 반환해요
### void off(String botName);
* 해당 이름을 가진 봇을 꺼요.
### void on(String botName);
* 해당 이름을 가진 봇을 켜요.
### boolean reload(String botName);
* `Api.reload();`와 동일
### void runOnUiThread(final String name, final Function func);
* 해당 봇의 UI 쓰레드에서 `func`를 실행해요.
### boolean send(String room, String msg, String packageName);
* `Api.replyRoom();`와 동일

## Device
### String getAndroidVersion();
* 봇을 구동하고 있는 기기의 안드로이드 버전을 반환해요.
### String getAndroidVersionName();
* Device.getAndroidVersion();와 동일
### String getApiLevel();
* 봇을 구동하고 있는 기기의 API 레벨을 반환해요.
### String getAndroidVersionCode();
* Device.getApiLevel();와 동일
### String getBatteryHealth();
* 봇을 구동하고 있는 기기의 배터리의 건강 상태를 반환해요.
### android.content.Intent getBatteryIntent();
* 봇을 구동하고 있는 기기의 배터리 관련 Intent를 반환해요.
### String getBatteryLevel();
* 봇을 구동하고 있는 기기의 배터리의 잔량을 반환해요. 단위는 %.
### String getBatteryStatus();
* 봇을 구동하고 있는 기기의 배터리의 상태를 반환해요.
### String getBatteryTemp();
* 봇을 구동하고 있는 기기의 배터리의 온도을 반환해요. 단위는 ℃.
### int getBatteryVoltage();
* 봇을 구동하고 있는 기기의 배터리의 전압을 반환해요.
### android.os.Build getBuild();
* android.os.Build();의 값 반환해요.
### String getModelName();
* 봇을 구동하고 있는 기기의 모델명을 반환해요.
### String getPhoneModel();
* Device.getModelName();와 동일
### String getPhoneBrand();
* 봇을 구동하고 있는 기기를 만든 제조사를 반환해요.
### boolean isCharging();
* 봇을 구동하고 있는 기기의 배터리가 충전중인지 아닌지 반환해요.
