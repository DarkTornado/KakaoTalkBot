---
layout: default
title: Security
parent: API 2
---

# Security
* 암호화, 복호화와 관련된 함수들이 들어있어요.
* `메신저봇`에는 있지만 아직 `채팅 자동응답 봇`에는 구현되어 있지 않은 함수들도 있어요.

## int hashCode(String value);
* `value`의 해시 코드를 가지고와요.
* `java.lang.String` 클래스에 있는 `.hashCode();` 메서드를 호출한 그 결과물 맞아요.

## String aesEncode(String key, String initVector, String value);
* `value`를 AES 암호화한 값을 반환헤요.

## String aesDecode(String key, String initVector, String value);
* `value`를 AES 복호화한 값을 반환헤요.

## String ariaEncode(String key, String value);
* `value`를 ARIA 암호화한 값을 반환헤요.
* 이론상 `전자정부 표준프레임워크`와 호환될텐데, 확인해본건 아니에요.

## String ariaDecode(String key, String value);
* `value`를 ARIA 복호화한 값을 반환헤요.
* 이론상 `전자정부 표준프레임워크`와 호환될텐데, 확인해본건 아니에요.

## String base32Encode(String value);
* `value`를 Base32 암호화한 값을 반환헤요.

## String base32Decode(String value);
* `value`를 Base32 복호화한 값을 반환헤요.

## String base64Encode(String value);
* `value`를 Base64 암호화한 값을 반환헤요.

## String base64Decode(String value);
* `value`를 Base64 복호화한 값을 반환헤요.