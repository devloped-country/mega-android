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

### ⭐️ 유저 로그인 페이지

- 보안을 위해 sha256 암호화 방식을 사용하여 db에 유저 정보를 저장하였습니다. 또한 salt를 추가하여 해시 대상 값의 복잡도를 높혔습니다.

### ⭐️ 단위기간 설정

- 달력에서 년도와 달을 가져오고, 단위기간 TABLE 에서 ID 칼럼 1 에 해당하는 DURATION 칼럼의 값(일자)를 가져옵니다. 둘을 합쳐 날짜를 생성하고, 이를 기준으로 SQL 의 'LIMIT? OFFSET?' 문을 사용하여 단위 기간 내의 회원의 출결 상황을 볼 수 있도록 구현하였습니다.

### ⭐️ 회원명 검색 기능

- 회원명 검색 기능은 USER TABLE 에서 SQL 의 'LIKE' 구문을 활용하여 회원명 또는 그 일부를 검색하더라도 검색 결과를 볼 수 있도록 구현하였습니다.

### ⭐️ 출결관리 및 출결관리 상세 페이지 페이지네이션 기능

- 페이지네이션 기능은 한 페이지에 5 BLOCK 을 기준으로 9 개의 게시물이 보이도록 만들었습니다. 여기서 1 BLOCK 을 제외하고는 다음 페이지로 이동하는 버튼과 마지막 페이지로 이동하는 버튼이 보이도록 하였고, 마지막 BLOCK 을 제외하고는 이전 페이지로 이동하는 버튼과 1 페이지로 이동하는 버튼이 보이도록 구현하였습니다. 해당 페이지를 알 수 있도록 페이지 BLOCK 에 색을 칠해 구분하였습니다.

### ⭐️ 커리큘럼 조회, 추가, 수정, 삭제

- 교육생들이 웹앱을 통해 강의 커리큘럼을 쉽게 조회할 수 있도록 구현하였습니다. 매니저는 어드민 페이지를 통해 커리큘럼을 추가, 수정, 삭제할 수 있습니다. 커리큘럼은 한 과목당 여러 상세교과를 가질 수 있습니다. 이에 따라 상세 교과의 갯수를 동적으로 추가할 수 있습니다. 커리큘럼 수정 시에는 과목 수정, 상세 교과 삭제, 추가, 수정이 동시에 이루어지도록 하였습니다.

### ⭐️ 회원 가입

- 회원 가입시 기존에 등록된 이메일이 있으면 중복 체크를 합니다. 또한 이메일, 비밀번호, 비밀번호 확인, 휴대폰에 대한 유효성 검사를 진행합니다. 프론트 단에서 뿐만 아니라, 백엔드에서 해당 필드에 대해 원자적으로 유효성 검사를 하여 안정적인 회원 가입 기능을 구현하였습니다.

### ⭐️ 관리자 로그인 페이지

- 관리자 로그인 페이지는 세션인증방식을 통해 구현하였고, sha256처리후 salt를 적용하여 보안처리를 하였습니다. 로그아웃시는 우선 세션을 무효화시키고 XMLHttpRequest 객체의 상태와 HTTP 응답 상태 코드를 체크후 실행되도록 만들었습니다.

### ⭐️ 회원관리 페이지
- 회원목록를 조회할수있고 가입상태가 미가입자일 경우에만 가입승인버튼이 활성화되며 가입승인을 누르면 회원의 회원상태정보를 가입상태로 변경하여 유저페이지 로그인이 가능합니다. 회원탈퇴버튼은 추가적인 모달창을 통해서 회원삭제로직을 실행하며 회원정보가 출결정보와 연동 되어있어 출결정보를 삭제후 회원정보를 삭제하도록 구현하였습니다. 마지막으로 하단에 페이지네이션을 구현하였습니다.

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
