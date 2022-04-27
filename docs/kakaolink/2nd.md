---
layout: default
title: 모듈 다운로드 및 적용
parent: 카카오링크
nav_order: 2
---

# 모듈 다운로드 및 적용

* 카카오링크 모듈은 총 4가지가 있지만, 그 중 최초 버전을 열심히 컨닝하면서 만든 제 모듈을 기준으로 설명할거에요.

## kaling.js
* 해당 파일은 카카오링크 자동 전송 모듈이에요.

## crypto.js
* 해당 파일은 `kaling.js`가 필요로 하는 모듈이에요.

## 모듈 다운로드
* [이 부분을 눌러서 해당 레포지토리로 이동](https://github.com/DarkTornado/KakaoLink.js)한 뒤에, `kaling.js` 파일과 `crypto.js` 파일을 다운로드 받아주세요.

## 모듈 적용

### 채팅 자동응답 봇
* `kaling.js` 파일과 `crypto.js` 파일을 `/내장메모리/ChatBot/module/` 폴더에 넣고, 환경 설정에서 언어 버전을 `ECMA Script 6`으로 변경하면 되는거에요.
* 비교적 최근에 `채팅 자동응답 봇`을 설치하셨다면, 이미 언어 버전이 `ECMA Script 6`로 되어있을거에요.

### 메신저봇
* 앱 최초 실행시에 선택하셨던 봇 데이터가 저장되는 폴더가 있을거에요.
* 그 폴더 안에 있는 `global_modules` 폴더에 `kaling.js` 파일과 `crypto.js` 파일을 넣으시면 되는거에요.
* 또는 봇마다 있는 `modules` 폴더에 넣으셔도 되지만, 그러면 해당 봇에서만 사용할 수 있어요.