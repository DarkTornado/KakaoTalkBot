---
layout: default
title: FileStream
parent: Legacy API
---

# FileStream
* 구버전 호환을 위해 `File`도 남아는 있으나, `FileStream`을 사용하는 것을 권장해요.
* 이 API 증 일부는 `메신저봇`에도 있어요.

## void append(String path, String value);
* 경로가 `path`인 파일에 저장되어 있는 내용의 뒤에 `value`를 붙여서 저장해요.
* `메신저봇`에서도 사용할 수 있어요.

## String read(String path);
* 경로가 `path`인 파일에 저장된 내용을 읽어와요.
* `메신저봇`에서도 사용할 수 있어요.

## object readJson(String path);
* 경로가 `path`인 파일에 저장된 내용을 읽고, 그 내용이 `JSON` 형식이라고 가정하고 자바스크립트에 있는 객체로 바꿔서 반환해요.

## void write(String path, String value);
* `FileStream.save(path, value);`와 동일
* `메신저봇`에서도 사용할 수 있어요.

## void writeJson(String path, object json);
* `FileStream.saveJson(path, json);`과 동일

## boolean remove(String path);
* 해당 경로에 있는 파일을 삭제해요.
* `메신저봇`에서도 사용할 수 있어요.


## boolean copyFile(String path1, String path2);
* 파일 복사. 복사 성공시 `true`를 반환해요

## boolean createDir(String path);
* 폴더 생성.

## String getSdcardPath();
* 내장메모리 최상위 경로 반환

## String moveFile(String path1, String path2);
* 파일 이동

## void save(String path, String value);
* 경로가 `path`인 파일에 `value`를 저장해요. 이미 파일이 존재한다면 덮어쓰기

## void save(String path, String value, boolean append);
* 경로가 `path`인 파일에 `value`를 저장해요.
* `append`가 `true`면 이미 저장되어 있는 내용 뒤에 붙이고, `false`라면 기존 내용은 사라지고 `value`로 대체

## void saveJson(String path, object json);
* 자바스크립트 객체인 `json`를 JSON 형식 문자열로 바꿔서 경로가 `path`인 파일에 저장해요.