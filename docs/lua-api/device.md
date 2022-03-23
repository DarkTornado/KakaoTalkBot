---
layout: default
title: Device
parent: Lua API
---

# Device

## String getAndroidVersion();
* 봇을 구동하고 있는 기기의 안드로이드 버전을 반환해요.

## int getApiLevel();
* 봇을 구동하고 있는 기기의 API 레벨을 반환해요.

## int getBatteryLevel();
* 봇을 구동하고 있는 기기의 배터리의 잔량을 반환해요. 단위는 %.

## double getBatteryTemp();
* 봇을 구동하고 있는 기기의 배터리의 온도을 반환해요. 단위는 ℃.

## String getModelName();
* 봇을 구동하고 있는 기기의 모델명을 반환해요.
