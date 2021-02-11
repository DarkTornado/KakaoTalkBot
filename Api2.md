# 채팅 자동응답 봇 API2 레퍼런스

## App
### android.content.Content getContext();
* 봇 구동 서비스의 Context를 반환해요.
### void runOnUiThread(Function func);
* UI 쓰레드에서 해당 함수를 실행해요

## Bot
* BotManager 클래스를 통해 가지고온 Bot 인스턴스에서 사용할 수 있는 method들이에요.
### void addEventListener(String eventName, Function listener);
* 이벤트 리스너를 등록하는거에요.
### boolean canReply(String room\[, String packageName\]);
* 해당 방으로 채팅을 보낼 수 있는지 반환해요.
* `packageName` 생략시 가장 최근에 알림이 수신된 메신저 앱을 기준으로 작동해요.
### boolean compile();
* 현재 봇을 리로드(컴파일)시켜요.
* 성공시 true, 실패시 false를 반환해요.
### String getName();
* 현재 봇의 이름을 반환해요.
### boolean getPower();
* 현재 봇이 켜져있는지 반환해요.
### markAsRead(String room\[, String packageName\]);
* 해당 패키지명을 가진 메신저 앱의 해당 채팅방의 채팅을 읽음처리 해요.
* `packageName` 생략시 가장 최근에 알림이 수신된 메신저 앱을 기준으로 작동해요.
### void removeAllEventListener(String eventName, Function listener);
* 등록된 모든 이벤트 리스너를 삭제하는거에요.
### void removeEventListener(String eventName, Function listener);
* 등록된 이벤트 리스너를 삭제하는거에요.
### void setCommandPrefix(String prefix);
* 명령어의 시작 문자열을 설정해요.
* 수신된 채팅 내용이 prefix로 시작하면 `Event.COMMAND` 이벤트가 발생해요.
### void setPower(boolean isOn);
* 봇을 키거나 꺼요.
### boolean send(String room, String msg\[, String packageName\]);
* 해당 패키지명을 가진 메신저 앱의 해당 채팅방으로 채팅을 보내요.
* `packageName` 생략시 가장 최근에 알림이 수신된 메신저 앱을 기준으로 작동해요.

## BotManager
### boolean compile(String botName);
* 해당 봇을 리로드(컴파일)시켜요.
* 성공시 true, 실패시 false를 반환해요.
### Bot getBot(String botName);
* 해당 이름을 가진 봇의 Bot 인스턴스를 반환해요.
### Bot[] getBotList();
* 모든 봇들의 Bot 인스턴스들을 배열로 반환해요.
### Bot getCurrentBot();
* 현재 봇의 Bot 인스턴스를 반환해요.
### boolean getPower(String botName);
* 해당 봇이 켜져있는지 반환해요.
### String[] getRooms(\[String packageName\]);
* 해당 패키지명을 가진 메신저 앱에서 채팅 전송이 가능한 채팅방 목록을 반환해요.
* `packageName` 생략시 가장 최근에 알림이 수신된 메신저 앱을 기준으로 작동해요.
### void setPower(String botName, boolean isOn);
* 해당 봇을 키거나 꺼요.

## Database
* `내장메모리/ChatBot/database/` 폴더 내부에 파일 입/출력을 해줘요.
### boolean exists(String fileName);
* 해당 파일이 존재하는지 반환해요.
### Object readObject(String fileName);
* 해당 파일의 내용(JSON)을 읽어서 자바스크립트 객체로 저장해요.
### String readString(String fileName);
* 해당 파일의 내용(문자열)을 읽어요.
### Object writeObject(String fileName, Object object);
* 해당 파일에 자바스크립트 객체를 JSON 문자열로 변환해서 저장해요.
### String writeString(String fileName, String value);
* 해당 파일에 해당 내용(문자열)을 저장해요.

## Event
* 이벤트 리스너들에 사용되는 `Event`들의 상수값을 가지고 있어요.
### String MESSAGE = "message"
* 채팅이 수신되면 발생하는 이벤트에요.
### String COMMAND = "command"
* `Bot#setCommandPrefix(String prefix);`으로 설정한 문자열로 시작하는 채팅이 수신되면 발생하는 이벤트에요.
### String START_COMPILE = "startCompile"
* 봇 컴파일이 시작되면 발생하는 이벤트에요.
### String MEMBER_COUNT_CHANGED = "memberChanged"
* 오픈채팅방 입퇴장 API 사용시 방 인원수가 변하면 발생하는 이벤트에요.
