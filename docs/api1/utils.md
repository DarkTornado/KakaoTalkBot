---
layout: default
title: Utils
parent: Legacy API
---

# Utils
* 이 API 중 일부는 `메신저봇`에도 있어요.

## String getWebText(String url, boolean removeTags);
* `jsoup` 라이브러리를 통해 해당 `url`의 소스를 긁어서 문자열로 반환해요.
* `removeTags`가 `true`라면 HTML 태그들을 모두 삭제한 결과를 반환해요.

## String getWebText2(String url, String encoding);
* `java.net` 패키지를 통해 해당 `url`의 소스를 긁어와요.

## Document parse(String url);
* `jsoup` 라이브러리를 통해 해당 `url`의 소스를 긁어서 `Document` 인스턴스로 반환해요.


## String compress(String value);
* 투명문자 1000개를 반환해요.

## void copyToClipboard(String value);
* `value`를 복사해요.

## void delay(int mil);
* `mil`밀리초 동안 딜레이

## String getHtmlFromWeb(String url);
* `Utils.getWebText2(url, "UTF-8");` 과 동일해요.
* 구버전 호환을 위해 남아있는 함수로, 사용하지 않는 것을 권장해요.

## String getWeatherJSON(String location);
* 기상청에서 `location`의 날씨 정보를 가져와요.
* 일부 지역만 지원해요.

## String getWeatherJSON(String zoneId);
* 기상청에서 행정구역코드가 `zoneId`인 위치의 날씨 정보를 가져와요.
* 국내 지역만 지원해요.

## String getZoneIdByName(String location);
* `location`의 행정구역코드를 가지고와요.

## String removeRLO(String str);
* 반전문자 삭제

## String removeTags(String html);
* 인자로 넘긴 문자열에 있는 HTML 태그들을 지워요.

## void sleep(int mil);
* `Utils.delay(mil);`과 동일

## void toast(String msg);
* 토스트 메시지로 `msg`를 출력해요.

## void vibrate(double sec);
* `sec`초 동안 진동

## String getJosa(word, josa);
* {{ site.misc.alert_not_added }}
* `word` 마지막 음절의 받침 여부에 따라 적절한 조사를 반환해요.


## String translate(String lang1, String lang2, String value);
* <span style="color:red">더 이상 작동하지 않는 번역 함수에요.</span>
* `Api.papagoTranslate();` 함수를 사용해주세요.