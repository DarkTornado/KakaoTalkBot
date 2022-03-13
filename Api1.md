# 채팅 자동응답 봇 레거시 API 레퍼런스
* 채팅 자동응답 봇 개발자가 이상한 사람이라 `레거시 API`와 [API2](Api2.md)를 동시에 사용할 수 있어요.
* 이 곳에 있지만 지금 사용중인 앱에서는 작동하지 않는 API가 있다면, 구버전을 사용하고 계시거나 개발자가 곧 추가될 API를 미리 적어둔거에요.

<hr>

## 이벤트 리스너

### function response(String room, String msg, String sender, boolean isGroupChat, Replier replier, ImageDB imageDB, String packageName)
* 채팅이 수신되면 호출되는 이벤트 리스너
```javascript
function response(room, msg, sender, isGroupChat, replier, ImageDB, packageName) {
/*
 * room - 채팅이 수신된 채팅방의 방 이름. 1:1채팅방이라면 채팅을 보낸 사람의 닉네임
 * msg - 수신된 채팅 내용
 * sender - 채팅을 보낸 사람의 닉네임
 * isGroupChat - 단체채팅방이면 true, 1:1 채팅방이면 false
 * replier - 채팅방에 응답을 보낼 때 사용하는 객체
   - .reply(String msg); - 채팅이 수신된 채팅방으로 응답 전송 
   - .reply(String room, String msg); - 해당 채팅방으로 응답 전송 
   - .reply(String room, String msg, String packageName); - 해당 메신저 앱의 해당 채팅방으로 응답 전송
   - .replier.replyDelayed(String msg, long ms); - ms 밀리초 뒤에 채팅이 수신된 채팅방으로 응답 전송 
   - .replier.replyDelayed(String room, String msg, long ms); - ms 밀리초 뒤에 해당 채팅방으로 응답 전송 
   - .replier.markAsRead(); - 채팅이 수신된 채팅방에 응답을 보내지 않고 읽음으로 처리
   - .replier.markAsRead(String room); - 해당 채팅방에 응답을 보내지 않고 읽음으로 처리
   - .replier.markAsRead(String room, String packageName); - 해당 앱의 해당 채팅방에 응답을 보내지 않고 읽음으로 처리
 * imageDB - 이미지 정보가 담겨 있는 객체
   - .getProfileImage(); - 채팅을 보낸 사람의 프로필 사진을 Base64로 인코딩된 문자열로 가지고 옴
   - .getProfileImageBitmap(); - 채팅을 보낸 사람의 프로필 사진을 android.graphics.Bitmap 인스턴스로 가지고 옴
   - .getProfileBitmap(); - imageDB.getProfileImageBitmap();과 동일
   - .getProfileHash(); - 채팅을 보낸 사람의 프로필 사진을 Base64로 인코딩된 문자열에 java.lang.String.hashCode(); 메서드를 실행한 결과를 가지고 옴
   - .getImage(); - 사진이 수신된 경우, 해당 사진을 Base64로 인코딩된 문자열로 가지고 옴
   - .getImageBitmap(); - 사진이 수신된 경우, 해당 사진을 android.graphics.Bitmap 인스턴스로 가지고 옴
 * packageName - 채팅이 수신된 앱의 패키지명
 */
}
```

### function onStartCompile()
* 스크립트가 리로드되기 직전에 호출되는 이벤트 리스너
```javascript
function onStartCompile() {
/* 매개변수 없음 */
}
```

### function onLoaded(Context ctx)
* 리로드 버튼을 눌렀을 때, 스크립트 리로드가 끝나면 호출되는 이벤트 리스너
```javascript
function onLoaded(ctx) {
/*
 * ctx - 현재 액티비티의 android.content.Context
 */
}
```

### function secondTick()
* 1초마다 호출되는 이벤트 리스너
```javascript
function secondTick() {
/* 매개변수 없음 */
}
```

### function onNotificationPosted(StatusBarNotification sbn, SessionManager sm)
* 알림을 읽도록 설정한 앱에서 알림이 뜨면 호출되는 리스너
```javascript
function onNotificationPosted(sbn, sm) {
/*
 * sbn - NofiticationListenerService에 있는 onNotificationPosted의 매개변수로 넘어오는 StatusBarNotification 인스턴스
 * sm - 동적으로 세션을 등록할 수 있게 해주는 객체
   - .bindSession(String packageName, String room, Notification.Action action);
   - .bindSession(String room, Notification.Action action);
 */
}
```
<hr>

## Api
### boolean canReply(String room, String pack);
* 해당 채팅방으로 채팅을 보낼 수 있는지 반환해요. 
### boolean compile(String botName);
* `Api.reload();`와 동일
### void gc();
* 가비지 콜랙터를 강제로 실행해요.
* 사실 `java.lang.System.gc();` 호출이에요.
### android.content.Content getContext();
* 봇 구동 서비스의 Context를 반환해요.
### String getLastImage();
* 가장 최근에 수신된 것 같은 이미지를 `Base64 문자열`로 인코딩해서 가지고 와요.
* 옛날 방식을 사용하기 때문에, 안드로이드 10 이하에서만 작동해요.
### android.graphics.Bitmap getLastImageBitmap();
* 가장 최근에 수신된 것 같은 이미지를 `android.graphics.Bitmap` 인스턴스로 가지고 와요.
* 옛날 방식을 사용하기 때문에, 안드로이드 10 이하에서만 작동해요.
### String[] getRoomList(String packageName);
* 모든 방 목록(정확히는 응답 전송이 가능한 방 목록)을 불러와요.
* `packageName` 생략시 가장 최근에 알림이 수신된 메신저 앱을 기준으로 작동해요.
### String[] getScriptNames();
* 모든 봇 목록을 불러와요.
### boolean isOn(String botName);
* 해당 이름을 가진 봇이 켜졌는지 확인해요.
### boolean markAsRead(String room, String packageName);
* 해당 패키지명을 가진 메신저 앱의 해당 채팅방의 채팅을 읽음처리 해요.
* `packageName` 생략시 가장 최근에 알림이 수신된 메신저 앱을 기준으로 작동해요.
### String papagoTranslate(String lang1, String lang2, String value);
* 파파고 번역.
* `value`의 언어를 `lang1`이라고 가정하고, `lang2` 언어로 번역해요.
### String papagoTranslate(String lang1, String lang2, String value, String id, String secret);
* 위와 동일하지만, 사용자가 발급받은 `Client Id`와 `Client Secret`를 사용할 수 있어요.
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

## Bridge
### boolean isAllowed(String botName);
* 해당 봇의 전역 스코프에 `Bridge`로 접근할 수 있는지 반환해요.
### ScriptableObject getScopeOf(String botName);
* 해당 봇의 전역 스코프를 가지고와요.
### boolean evaluateStringIn(String botName, String src);
* 해당 봇의 전역 스코프에서 해당 소스를 실행해요.
### String getGlobalVariable(String name);
* `단순 자동응답` 기능에 있는 해당 이름을 가진 `[[전체변수]]`에 저장된 값을 가지고와요.
### String getVariable(String room, String name);
* `단순 자동응답` 기능에 있는 해당 이름을 가진 `[[변수]]`에 저장된 값을 가지고와요.
* `[[변수]]` 태그는 방마다 따로따로 처리되기 때문에 방 이름도 함께 넘겨야 해요.
### String setGlobalVariable(String name, String value);
* `단순 자동응답` 기능에 있는 해당 이름을 가진 `[[전체변수]]`에 `value`를 저장해요.
### String setVariable(String room, String name, String value);
* `단순 자동응답` 기능에 있는 해당 이름을 가진 `[[변수]]`에  `value`를 저장해요.
* `[[변수]]` 태그는 방마다 따로따로 처리되기 때문에 방 이름도 함께 넘겨야 해요.

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

## FileStream
* 구버전 호환을 위해 `File`도 남아는 있으나, `FileStream`을 사용하는 것을 권장합니다.
### void append(String path, String value);
* 경로가 `path`인 파일의 뒤에 `value`를 붙여요.
### String read(String path);
* 경로가 `path`인 파일에 저장된 내용을 읽어와요.
### object readJson(String path);
* 경로가 `path`인 파일에 저장된 내용을 읽고, 그 내용이 `JSON` 형식이라고 가정하고 자바스크립트에 있는 객체로 바꿔서 반환해요.
### void write(String path, String value);
* `FileStream.save(path, value);`와 동일
### void writeJson(String path, object json);
* `FileStream.saveJson(path, json);`과 동일
### boolean remove(String path);
* 해당 파일 삭제
### boolean copyFile(String path1, String path2);
* 파일 복사. 복사 성공시 `true`를 반환해요
### boolean createDir(String path);
* 폴더 생성.
### String getSdcardPath();
* 내장메모리 최상위 경로 반환
### String moveFile(String path1, String path2);
* 파일 삭제
### void save(String path, String value);
* 경로가 `path`인 파일에 `value`를 저장해요. 이미 파일이 존재한다면 덮어쓰기
### void save(String path, String value, boolean append);
* 경로가 `path`인 파일에 `value`를 저장해요.
* `append`가 `true`면 이미 저장되어 있는 내용 뒤에 붙이고, `false`라면 기존 내용은 사라지고 `value`로 대체
### void saveJson(String path, object json);
* 자바스크립트 객체인 `json`를 JSON 형식 문자열로 바꿔서 경로가 `path`인 파일에 저장해요.

## Log
* 각각 Log.d();, Log.e();, Log.i();로도 사용할 수 있어요.
### void debug(String log, boolean isGlobal);
* 로거에 로그를 기록해요.
* `isGlobal`가 `true`라면 글로벌 로그로 기록해요.
### void error(String log, boolean isGlobal, boolean hideToast);
* 로거에 로그를 기록해요.
* `isGlobal`가 `true`라면 글로벌 로그로 기록해요.
* `hideToast`가 `true`라면 오류가 발생했다는 문구를 토스트 메시지로는 출력하지 않아요.
### void info(String log, boolean isGlobal);
* 로거에 로그를 기록해요.
* `isGlobal`가 `true`라면 글로벌 로그로 기록해요.