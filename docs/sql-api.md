---
layout: default
title: SQL API
nav_order: 5
---

# SQLManager
* DB에 값을 저장할 때 사용하는 클래스 비슷한거에요.
* 이름만 `Database`인 다른 친구들과는 달리 진짜로 DB에다가 값을 저장하며, 내부는 `SQLite`로 돌아가요.
* `SQL 인젝션` 같은건 알아서 막으세요.
* 미래의 내가 설명 적어주겠지?

# SQLDataType
* `SQLManager.prototype.createTable();` 메서드를 호출할 때, 각 컬럼의 데이터 타입을 정할 때 사용하는 상수들이에요.

## String BLOB = "BLOB"
* `BLOB`형

## String INTEGER = "INTEGER"
* `INTEGER`형

## String NULL = "NULL"
* `NULL`형

## String REAL = "REAL"
* `REAL`형

## String TEXT = "TEXT"
* `TEXT`형
