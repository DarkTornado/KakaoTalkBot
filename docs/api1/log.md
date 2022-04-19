---
layout: default
title: Log
parent: Legacy API
---

# Log
* 채팅 자동응답 봇 `5.0 beta 2`부터 메신저봇과 사용법이 동일하게 수정되었어요.

## void info(String log, boolean showToast);
* 로그를 기록해요. `Log.i();`로도 사용할 수 있어요.
* `showToast`가 `true`라면 로그가 토스트 메시지로도 출력될거에요.

## void debug(String log, boolean showToast);
* 녹색 글씨로 로그를 기록해요. `Log.d();`로도 사용할 수 있어요.
* `showToast`가 `true`라면 로그가 토스트 메시지로도 출력될거에요.

## void error(String log, boolean showToast);
* 빨간색 글씨로 로그를 기록해요. `Log.e();`로도 사용할 수 있어요.
* `showToast`가 `true`라면 로그가 토스트 메시지로도 출력될거에요.

## void clear();
* 기록되어 있는 글로벌 로그를 삭제해요.

***

# 옛날 Log
* 채팅 자동응답 봇 `5.0 beta`이하 버전에서는 메신저봇과 사용법이 조금 달랐어요.
* 글로벌 로그를 남기고 싶으시다면, `GlobalLog`를 참고해주세요.

## void info(String log, boolean isGlobal);
* 로거에 로그를 기록해요.
* `isGlobal`가 `true`라면 글로벌 로그로 기록해요.

## void debug(String log, boolean isGlobal);
* 로거에 로그를 기록해요.
* `isGlobal`가 `true`라면 글로벌 로그로 기록해요.

## void error(String log, boolean isGlobal, boolean hideToast);
* 로거에 로그를 기록해요.
* `isGlobal`가 `true`라면 글로벌 로그로 기록해요.
* `hideToast`가 `true`라면 오류가 발생했다는 문구를 토스트 메시지로는 출력하지 않아요.
