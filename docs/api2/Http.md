---
layout: default
title: Http
parent: API 2
---

# Http
* 웹 서버에 HTTP 요청을 넣을 때 사용할 수 있어요.
* 웹사이트의 소스를 긁는 용도로도 쓸 수 있고, RESTFul API에 요청을 넣을 때 사용할 수도 있어요.
* 내부는 자바로 구현된 라이브러리인 `jsoup`으로 구현되어 있어요.

## void request(String url, Function callBack);
* 해당 `url`에 HTTP 요청을 비동기로 넣어요.
* 비동기로 요청을 넣은 결과는 `callBack`으로 넘어와요

## void request(object option, Function callBack);
* `option`이라는 객체에 담긴 내용에 따라 HTTP 요청을 비동기로 넣어요.
* 비동기로 요청을 넣은 결과는 `callBack`으로 넘어와요

## org.jsoup.nodes.Document requestSync(String url);
* 해당 `url`에 HTTP 요청을 동기로 넣어요.
* 동기로 요청을 넣은 결과는 이 함수의 반환값으로 넘어와요.

## org.jsoup.nodes.Document requestSync(object option);
* `option`이라는 객체에 담긴 내용에 따라 HTTP 요청을 동기로 넣어요.
* 동기로 요청을 넣은 결과는 이 함수의 반환값으로 넘어와요.


## callback 인자 정보

```javascript
function (e, res, doc) {
/*
 * e - 정상적으로 요청되지 않은 경우에만 값이 넘어오며, 요청을 넣는 과정에서 발생한 java.lang.Exception
 * res - 정상적으로 요청된 경우에만 값이 넘어오며, 요청을 넣은 결과 org.jsoup.Connection.Response
 * doc - res에 .parse(); 메서드를 호출한 org.jsoup.nodes.Document
 */
}
```

## option 구조

```javascript
{
    "url": String, //요청을 보낼 url
    "timeout": Number, // 타임아웃 (단위: 밀리초, 기본값: 3000)
    "method": String, //  메소드 (기본값: "GET". GET, POST, DELETE, PATCH, TRACE, PUT, OPTIONS 사용 가능)
    "headers": { /* Header */ } // 헤더 정보
}
```
