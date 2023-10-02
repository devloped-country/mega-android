# 💻 개발도상국

![logo](https://github.com/devloping-country/mega-admin/assets/132139751/ad19ceec-3edd-40c7-a309-74b72c8020c0)

## 📛 Mega App v1.0

> **클라우드 네이티브 애플리케이션 개발자 양성과정(메가존 클라우드) 1차 프로젝트** <br /> **프로젝트 기간 : 2023.09.14 ~ 2023.09.27**

## 🏃🏃🏃🏃🏃 인원

<table>
<tr>
    <td align="center">
    <a href="https://github.com/kimub">
    <img src="https://avatars.githubusercontent.com/u/132139751?v=4" width="100px;" alt="kimub"/>         
    <br /><b>kimub</b><br />
    </a>
     <b>김유범</b>
    </td>
    <td align="center">
    <a href="https://github.com/chomy12">
    <img src="https://avatars.githubusercontent.com/u/136536632?v=4" width="100px;" alt="chomy12"/>         
    <br /><b>chomy12</b><br>
    </a>
     <b>옥승철</b>
    </td>
    <td align="center">
    <a href="https://github.com/shshe22">
    <img src="https://avatars.githubusercontent.com/u/136536558?v=4" width="100px;" alt="shshe22"/>         
    <br /><b>shshe22</b><br>
    </a>
     <b>박소희</b>
    </td>
    <td align="center">
    <a href="https://github.com/rubberramen">
    <img src="https://avatars.githubusercontent.com/u/96553431?v=4" width="100px;" alt="rubberramen"/>         
    <br /><b>rubberramen</b><br>
    </a>
    <b>왕찬현</b>
    </td>
    <td align="center">
    <a href="https://github.com/CDDcookie">
    <img src="https://avatars.githubusercontent.com/u/131220863?v=4" width="100px;" alt="CDDcookie"/>         
    <br /><b>CDDcookie</b><br>
    </a>
    <b>전진우</b>
    </td>
</tr>
</table>

## 🏊 🏊 🏊 🏊 🏊 역할

### ⭐️ 김유범

- User Page
  - 로그인, 홈, QR
- Admin Page
  - 홈, QR, 출결 관리(통계)

### ⭐️ 옥승철

- User Page
  - 마이페이지
- Admin Page
  - 공지사항

### ⭐️ 박소희

- User Page
  - 공지사항
- Admin Page
  - 출결관리(회원)

### ⭐️ 왕찬현

- User Page
  - 회원가입, 커리큘럼, 자주 묻는 질문
- Admin Page
  - 커리큘럼

### ⭐️ 전진우

- Admin Page
  - 로그인, 회원관리

## 🙋 프로젝트 소개

메가존 클라우드에서 클라우드 네이티브 애플리케이션 개발자 양성과정 교육을 들으면서 느낀 불편한 점들을 개선하기 위해 만들어졌습니다. Mega App에서는 교육생의 출결정보, 공지사항, 커리큘럼, 자주 묻는 질문, 위치 기반의 QR 출석 인증 기능들을 제공합니다. 또한 Mega Admin에서는 관리자에게 교육생들의 출결정보, 공지사항 관리, 커리큘럼 관리, 회원 관리, QR 생성 기능들을 제공합니다.

## 📺 시연 영상

[![Video Label](http://img.youtube.com/vi/aea1v5ZCKHQ/0.jpg)](https://youtu.be/aea1v5ZCKHQ)

## 📦 기능

### ⭐️ 위치기반 QR 출석 인증

- 위치기반 로직은 자바스크립트의 지오로케이션 API를 활용하여 사용자 위치를 파악하는 기능을 제공하였습니다. 그리고 QR 출석 인증 로직은 관리자가 QR을 발급할시 Redis에 발급된 QR ID 값을 저장하고 사용자가 QR 읽었을때 사용자의 계정과 QR ID 값을 서버에 요청합니다. 서버는 QR ID 값과 Redis에 저장된 QR ID와 값을 비교하고 일치할 경우 사용자의 출석 정보를 갱신하도록 구현하였습니다.

### ⭐️ JWT 토큰 기반 로그인 구현

- 쿠키, 세션 인증에 비해 보안 또는 성능에 이점이 있는 JWT 토큰 방식을 채택하여 인증으로 구현하였고 만료기간 10분의 AccessToken과 만료기간 2주의 RefreshToken을 발급하여 사용자의 로컬스토리지에 저장하여 API 요청을 할 때 토큰을 통해 인가를 받도록 하였습니다. 또한 사용자가 인가를 받을 때 AccessToken이 만료되었고 RefreshToken의 만료기간이 1시간 이하로 남았을 때는 RefreshToken을 재발급 받게 설정함으로써 자동 로그인이 끊기지 않게 구현하였습니다.

## 🧑‍💻 기술 스택

![skills](https://github.com/devloping-country/mega-user-fe/assets/132139751/d1f85430-6570-4006-92bd-37736c8b0276)

## 🧵 ERD

<img width="1529" alt="erd" src="https://github.com/devloping-country/mega-user-fe/assets/132139751/06fad666-15d9-4015-9751-09a0b7a7276c">

## 📝 유스케이스

![mega-usecase](https://github.com/devloping-country/mega-user-fe/assets/132139751/41b4ee1a-74cd-44a1-bd18-0b25e96ffb55)

## 🧑‍🔧 아키텍처

![architecture](https://github.com/devloping-country/mega-user-fe/assets/132139751/4b4f8dbb-1f06-4bb8-a38d-44fcea73797a)

## 📁 디렉토리 구조

### 📂 User-FE

```
├── README.md
│
├── .eslintrc.cjs
├── vite.config.js
│
└── src/
    ├── api/
    │   └── api.js
    │
    ├── assets/
    │   ├── css/
    │   │   ├── fonts.css
    │   │   ├── reset.css
    │   │   └── theme.css
    │   │
    │   ├── fonts/
    │   │   ├── Pretendar-Black.subset.woff
    │   │   ├── Pretendar-Black.subset.woff2
    │   │   ├── Pretendar-Black.subset.ttf
    │   │   └── ...
    │   │
    │   └── images/
    │       ├── angle-small-down.svg
    │       ├── arrow-left.svg
    │       └── ...
    │
    ├── components/
    │   ├── Calendar/
    │   │   ├── Calendar.css
    │   │   └── Calendar.vue
    │   │
    │   │── CalendarNav/
    │   │   ├── CalendarNav.css
    │   │   └── CalendarNav.vue
    │   │
    │   └── ...
    │
    ├── composables/
    │   ├── fetch.js
    │   ├── fetchs.js
    │   ├── footer.js
    │   ├── index.js
    │   └── mutation.js
    │
    ├── layout/
    │   ├── Footer/
    │   │   ├── Footer.css
    │   │   └── Footer.vue
    │   │
    │   └── Header/
    │       ├── Header.css
    │       └── Header.vue
    │
    ├── router/
    │   └── index.js
    │
    ├── teleport/
    │   └── Modal/
    │       ├── Modal.css
    │       └── Modal.vue
    │
    ├── util/
    │   ├── crypto.js
    │   └── format.js
    │
    ├── views/
    │   ├── CurriculumView/
    │   │   ├── CurriculumView.css
    │   │   └── CurriculumView.vue
    │   │
    │   ├── FailView/
    │   │   ├── FailView.css
    │   │   └── FailView.vue
    │   │
    │   └── ...
    │
    ├── App.vue
    │
    └── main.js
```

### 📂 User-BE

```
├── README.md
│
├── pom.xml
│
├── src/main/java/com/mega/
│   ├── biz/
│   │   ├── auth/
│   │   │   ├── controller/
│   │   │   │   ├── AuthController.class
│   │   │   │   └── NameController.class
│   │   │   │
│   │   │   ├── model/
│   │   │   │   ├── dto/
│   │   │   │   │   ├── AuthDTO.class
│   │   │   │   │   ├── NameDTO.class
│   │   │   │   │   └── TokenDTO.class
│   │   │   │   │
│   │   │   │   ├── AuthDAO.class
│   │   │   │   └── AuthQuery.enum
│   │   │   │
│   │   │   └── service/
│   │   │       └── AuthService.class
│   │   ├── curriculum/
│   │   │   ├── controller/
│   │   │   │   └── CurriculumController.class
│   │   │   │
│   │   │   ├── model/
│   │   │   │   ├── dto/
│   │   │   │   │   ├── CurriculumWithDetailDTO.class
│   │   │   │   │   └── DetailSubjectDTO.class
│   │   │   │   │
│   │   │   │   ├── CurriculumDAO.class
│   │   │   │   └── CurriculumQuery.enum
│   │   │   │
│   │   │   └── service/
│   │   │       └── CurriculumService.class
│   │   │
│   │   └── ...
│   │
│   ├── common/
│   │   ├── controller/
│   │   │   ├── Controller.interface
│   │   │   ├── ControllerUtils.class
│   │   │   ├── HandlerMapping.class
│   │   │   └── ViewResolver.class
│   │   │
│   │   ├── filter/
│   │   │   ├── CharacterEncodingFilter.class
│   │   │   └── CORSFilter.class
│   │   │
│   │   └── ...
│   │
│   └── config/database/
│       ├── JDBCUtils.class
│       └── JedisUtils.class
│
├── src/main/resources/
│   ├── jdbc.properties
│   └── jedis.properties
│
│
└── src/main/webapp/
    └── WEB-INF/
        └── web.xml
```

### 📂 Admin

```
├── README.md
│
├── pom.xml
│
├── src/main/java/com/mega/
│   ├── biz/
│   │   ├── attendance/
│   │   │   ├── controller/
│   │   │   │   ├── AttendanceStatController.class
│   │   │   │   ├── GetAttendanceDetailListController.class
│   │   │   │   ├── GetAttendanceListController.class
│   │   │   │   ├── SetDurationController.class
│   │   │   │   └── UpdateAttendanceController.class
│   │   │   │
│   │   │   ├── model/
│   │   │   │   ├── dto/
│   │   │   │   │   ├── AttendanceDateDTO.class
│   │   │   │   │   ├── AttendanceDatesDTO.class
│   │   │   │   │   ├── AttendanceDetailInfoDTO.class
│   │   │   │   │   ├── AttendanceDTO.class
│   │   │   │   │   ├── AttendanceInfoDTO.class
│   │   │   │   │   ├── AttendanceInfosDTO.class
│   │   │   │   │   ├── AttendanceStatDTO.class
│   │   │   │   │   ├── AttendanceUserDTO.class
│   │   │   │   │   └── PageDTO.class
│   │   │   │   │
│   │   │   │   ├── dao/
│   │   │   │   │   ├── AttendanceDAO.class
│   │   │   │   │   └── AttendanceStatDAO.class
│   │   │   │   │
│   │   │   │   ├── AttendanceQuery.enum
│   │   │   │   └── AttendanceStatQuery.enum
│   │   │   │
│   │   │   ├── service/
│   │   │   │   ├── AttendanceStatService.class
│   │   │   │   └── AttendanceService.class
│   │   │   │
│   │   │   ├── AttendanceDispatcherServlet.class
│   │   │   └── AttendanceHandlerMapping.class
│   │   │
│   │   ├── curriculum/
│   │   │   ├── controller/
│   │   │   │   ├── CreateCurriculumController.class
│   │   │   │   ├── CreateCurriculumFormController.class
│   │   │   │   ├── DeleteCurriculumController.class
│   │   │   │   ├── GetCurriculumListController.class
│   │   │   │   ├── UpdateCurriculumController.class
│   │   │   │   └── UpdateCurriculumFormController.class
│   │   │   │
│   │   │   ├── model/
│   │   │   │   ├── dto/
│   │   │   │   │   ├── CurriculumDTO.class
│   │   │   │   │   ├── CurriculumWithDetailDTO.class
│   │   │   │   │   └── DetailSubjectDTO.class
│   │   │   │   │
│   │   │   │   ├── CurriculumDAO.class
│   │   │   │   └── CurriculumQuery.enum
│   │   │   │
│   │   │   ├── service/
│   │   │   │   └── CurriculumService.class
│   │   │   │
│   │   │   ├── CurriculumDispatcherServlet.class
│   │   │   └── CurriculumHandlerMapping.class
│   │   │
│   │   └── ...
│   │
│   ├── common/
│   │   ├── controller/
│   │   │   ├── Controller.interface
│   │   │   ├── DispatcherServletSample.class
│   │   │   ├── HandlerMapping.class
│   │   │   └── ViewResolver.class
│   │   │
│   │   ├── filter/
│   │   │   ├── AuthenticationFilter.class
│   │   │   ├── CharacterEncodingFilter.class
│   │   │   └── CORSFilter.class
│   │   │
│   │   ├── qr/
│   │   │   └── QRUtils.class
│   │   │
│   │   └── ...
│   │
│   └── config/database/
│       ├── JDBCUtils.class
│       └── JedisUtils.class
│
├── src/main/resources/
│   ├── jdbc.properties
│   └── jedis.properties
│   └── lucy-xss-servlet-filter-rule.xml
│
│
└── src/main/webapp/
    ├── images/
    │   ├── angle-double-small-left.svg
    │   ├── angle-double-small-right.svg
    │   └── ...
    │
    ├── style/
    │   ├── attendance.css
    │   ├── header.css
    │   ├── footer.css
    │   ├── qr.css
    │   └── ...
    │
    └── WEB-INF/
        ├── errors/
        │   └── error.jsp
        │
        ├── layout/
        │   ├── footer.jsp
        │   └── header.jsp
        │
        └── view/
            ├── attendance/
            │   ├── attendanceDetailList.jsp
            │   ├── attendanceList.jsp
            │   └── attendanceStat.jsp
            │
            ├── curriculum/
            │   ├── createForm.jsp
            │   ├── curriculumList.jsp
            │   └── updateForm.jsp
            │
            ├── notice.jsp
            │   ├── createNotice.class
            │   ├── detailNotice.class
            │   ├── noticeList.class
            │   └── updateNotice.class
            │
            └── ...
```
