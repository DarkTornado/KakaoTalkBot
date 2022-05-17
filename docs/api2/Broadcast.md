---
layout: default
title: Broadcast
parent: API 2
---

# Broadcast
* 모든 봇 스크립트를 대상으로 메시지를 보내면서 값을 넘기는 방식(브로드케스팅)을 통해 봇 스크립트간 값을 주고받을 수 있도록 해줘요.
* `메신저봇`과는 달리 반환값이 있어요.

## int send(String broadcastName, Object value);
* 모든 봇 스크립트들을 대상으로 `value`라는 값을  `broadcastName`이라는 이름으로 브로드케스팅해요.

## boolean register(String broadcastName, Function callBack);
* `broadcastName`이라는 Broadcast가 발생하면 호출될 함수인 `callBack`을 등록해요.
* 등록에 성공하면 `true`, 등록에 실패하면 `false`를 반환하지만, 정상적인 환경에서는 `false`가 반환될 일이 없어요.

## boolean unregister(String broadcastName);
* `broadcastName`이라는 Broadcast에 반응하도록 되어있는 함수의 등록을 해제해요.
* 등록에 성공하면 `true`, 등록에 실패하면 `false`를 반환하지만, 정상적인 환경에서는 `false`가 반환될 일이 없어요.

## boolean unregisterAll();
* Broadcast에 반응하도록 되어있는 모든 함수들을 등록 해제해요.
* 등록에 성공하면 `true`, 등록에 실패하면 `false`를 반환하지만, 정상적인 환경에서는 `false`가 반환될 일이 없어요.
