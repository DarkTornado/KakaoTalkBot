---
layout: default
title: Database
parent: API 2
---

# Database
* `/내장메모리/ChatBot/database/` 폴더 내부에 파일 입/출력을 해줘요.
* 상위호환인 [FileStream]({{ site.url }}{{ site.baseurl }}/docs/api1/file-stream.md)도 있어요.

## boolean exists(String fileName);
* 해당 파일이 존재하는지 반환해요.

## Object readObject(String fileName);
* 해당 파일의 내용(JSON)을 읽어서 자바스크립트 객체로 저장해요.

## String readString(String fileName);
* 해당 파일의 내용(문자열)을 읽어요.

## Object writeObject(String fileName, Object object);
* 해당 파일에 자바스크립트 객체를 JSON 문자열로 변환해서 저장해요.

## String writeString(String fileName, String value);
* 해당 파일에 해당 내용(문자열)을 저장해요.
