---
layout: default
title: Device
parent: Legacy API
---

# Device
* 이 API 중 일부는 `메신저봇`에도 있어요.

## String getAndroidVersion();
* 봇을 구동하고 있는 기기의 안드로이드 버전을 반환해요.

## String getAndroidVersionName();
* Device.getAndroidVersion();와 동일
* {{ site.misc.msgbot }}

## int getApiLevel();
* 봇을 구동하고 있는 기기의 API 레벨을 반환해요.

## int getAndroidVersionCode();
* Device.getApiLevel();와 동일
* {{ site.misc.msgbot }}

## int getBatteryHealth();
* 봇을 구동하고 있는 기기의 배터리의 건강 상태를 반환해요.
* {{ site.misc.msgbot }}

## android.content.Intent getBatteryIntent();
* 봇을 구동하고 있는 기기의 배터리 관련 Intent를 반환해요.
* {{ site.misc.msgbot }}

## String getBatteryLevel();
* 봇을 구동하고 있는 기기의 배터리의 잔량을 반환해요. 단위는 %.
* {{ site.misc.msgbot }}

## int getBatteryStatus();
* 봇을 구동하고 있는 기기의 배터리의 상태를 반환해요.
* {{ site.misc.msgbot }}

## double getBatteryTemp();
* 봇을 구동하고 있는 기기의 배터리의 온도을 반환해요. 단위는 ℃.
* {{ site.misc.msgbot }}

## int getBatteryVoltage();
* 봇을 구동하고 있는 기기의 배터리의 전압을 반환해요.

## android.os.Build getBuild();
* android.os.Build();의 값을 반환해요.
* {{ site.misc.msgbot }}

## String getModelName();
* 봇을 구동하고 있는 기기의 모델명을 반환해요.

## String getPhoneModel();
* Device.getModelName();와 동일
* {{ site.misc.msgbot }}

## String getPhoneBrand();
* 봇을 구동하고 있는 기기를 만든 제조사를 반환해요.
* {{ site.misc.msgbot }}

## boolean isCharging();
* 봇을 구동하고 있는 기기의 배터리가 충전중인지 아닌지 반환해요.
* {{ site.misc.msgbot }}