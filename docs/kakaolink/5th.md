---
layout: default
title: 기본 템플릿 전송
parent: 카카오링크
nav_order: 5
---

# 기본 템플릿 전송

* 기본 템플릿에는 총 4가지가 있지만, 여기서는 `FEED`라는 템플릿만 전송해볼거에요.
* 이후에 다룰 커스텀 템플릿과는 달리, 기본 템플릿은 API 키에 관계 없이 사용할 수 있는지라, 다른 사람이 발급받은 키를 훔쳐서 쓴다면 카카오 디벨로퍼스에 가입하지 않고도 사용할 수 있어요.

## FEED 템플릿

* `FEED` 템플릿은 이렇게 생겼어요.

![]({{ site.imageurl }}kakaolink/9.png)


* 지금은 사라진 어느 강좌글에 따르면 다음과 같이 쓰면 된다고 했어요.

```javascript
Kakao.send("방 이름", {
    "link_ver": "4.0",
    "template_object": {
        "object_type": "feed",
        "button_title": "이곳에 버튼명을 입력하세요.",

        "content": {
            "title": "이곳에 제목을 입력하세요.",
            "image_url": "이곳에 이미지 링크를 입력하세요.",
            "link": {
                "web_url": "이곳에 웹 링크를 입력하세요.",
                "mobile_web_url": "이곳에 모바일 웹 링크를 입력하세요."
            },
            "description": "이곳에 설명을 입력하세요."
        },

        "buttons": [{
            "title": "이곳에 제목을 입력하세요.",
            "link": {
                "web_url": "이곳에 웹 링크를 입력하세요.",
                "mobile_web_url": "이곳에 모바일 웹 링크를 입력하세요."
            }
        }]

    }
});
```


* 일부 항목들을 생략한다면 표시되지 않아요. 위에 보이는 예시같은 경우는 대충 다음과 같아요.

```javascript
Kakao.send(room, {
    "link_ver": "4.0",
    "template_object": {
        "object_type": "feed",
        "button_title": "",
        "content": {
            "title": "Lv.255 DarkTornado",
            "image_url": "캐릭터 이미지 주소",
            "link": {},
            "description": "서버 : 루나, 직업 : 나이트로드\n랭킹 : 85,015위",
        },
        "buttons": [{
            "title": "",
            "link": {}
        }]

    }
});
```

* 아무튼 해당 카카오링크를 보낸 소스는 [이곳을 눌러서 확인 가능](https://github.com/DarkTornado/KakaoTalkBot-Examples/blob/master/MapleStoryCharInfo.js)