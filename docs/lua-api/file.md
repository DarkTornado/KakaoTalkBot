---
layout: default
title: File
parent: Lua API
---

# File

## void createFolder(String path);
* 폴더 생성

## int getFileCount();
* 당 경로에 있는 파일들의 개수 반환

## String getSdcardPath();
* 내장메모리 최상위 경로 반환

## String read(String path);
* 경로가 `path`인 파일에 저장된 내용을 읽어와요.

## void remove(String path);
* 해당 경로에 있는 파일 삭제

## void save(String path, String value, boolean isAppend);
* 경로가 `path`인 파일에 `value`를 저장해요.
* `append`가 `true`면 이미 저장되어 있는 내용 뒤에 붙이고, `false`라면 기존 내용은 사라지고 `value`로 대체. 생략시 `false`로 간주