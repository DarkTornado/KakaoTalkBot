---
layout: default
title: AppData
parent: API 2
---

# AppData
* 루트 경로에 값을 저장해요.
* `SharedPreferences`에 저장하는 그거 맞아요.

## boolean getBoolean(String key, boolean defaultValue);
* 해당 `key`로 저장되어 있는 `boolean` 값을 불러와요.
* 해당 `key`로 저장되어 있는 값이 없다면 `defaultValue`를 반환해요.
* `defaultValue`가 없다면 `false`를 반환해요.

## int getInt(String key, int defaultValue);
* 해당 `key`로 저장되어 있는 `int` 값을 불러와요.
* 해당 `key`로 저장되어 있는 값이 없다면 `defaultValue`를 반환해요.
* `defaultValue`가 없다면 `0`를 반환해요.

## String getString(String key, String defaultValue);
* 해당 `key`로 저장되어 있는 `String` 값을 불러와요.
* 해당 `key`로 저장되어 있는 값이 없다면 `defaultValue`를 반환해요.
* `defaultValue`가 없다면 `null`를 반환해요.
* `메신저봇`은 `undefined`라는 문자열을 반환하니 참고.

## void putBoolean(String key, boolean value);
* 해당 `key`로 `boolean` 값을 저장해요.

## void putInt(String key, int value);
* 해당 `key`로 `int` 값을 저장해요.

## void putString(String key, String value);
* 해당 `key`로 `String` 값을 저장해요.

## void remove(String key);
* 해당 `key`로 저장된 값을 삭제해요.

## void clear();
* `AppData`로 저장했던 모든 값들을 삭제해요.
