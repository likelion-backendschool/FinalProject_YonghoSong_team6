# 할일리스트

- [x] 관리자 회원
- [x] 관리자페이지
- [x] 정산데이터 생성
- [x] 건별정산처리
- [x] 전체정산처리
- [x] 정산데이터를 배치로 생성
    - [x] 스프링 내장 스케쥴러를 이용해서 배치가 매달 15일 새벽 4시에 실행되도록
    - [x] `@EnableScheduling` 사용
- [x] 출금신청기능(사용자기능)
- [x] 출금처리기능(관리자기능)
- [x] 결제가 된 주문품목은 정산품목으로 생성될 수 있다.
- [x] 관리자만 관리자 페이지에 접속할 수 있다.
- [x] 개발자가 회원중 임의로 1명을 골라서 관리자로 지정
    - [x] authLevel 을 7로 지정
- [x] 정산비율은 판매자와 멋북스가 5:5로 나눈다.
- [x] 편의상 PG 수수료는 0원으로 가정하고 진행한다.
- [x] 사용자는 본인이 보유한 예치금에 대해서 출금신청을 할 수 있다.
- [x] 신청시에는 금액과 통장, 계좌번호를 입력한다.
- [x] 관리자만 관리자페이지에서 출금신청목록을 볼 수 있다.
- [x] 출금 수수료도 없다고 가정한다.
- [x] GET /adm/home/main
- [x] GET /adm/rebate/makeData
- [x] POST /adm/rebate/makeData
- [x] GET /adm/rebate/rebateOrderItemList
- [x] POST /adm/rebate/rebate
- [x] POST /adm/rebate/rebateOne/{id}
- [x] GET /withdraw/apply
- [x] POST /withdraw/apply
- [x] GET /adm/withdraw/applyList
- [x] POST /adm/withdraw/{withdrawApplyId}
- [] JWT 로그인 구현(POST /api/v1/member/login)
- [] 내 도서 리스트 구현(GET /api/v1/myBooks)
- [] 내 도서 상세정보 구현(GET /api/v1/myBooks/{id})
- [] 로그인 한 회원의 정보 구현(GET /api/v1/member/me)
- [] Spring Doc 으로 API 문서화(크롬 /swagger-ui/index.html )

- `` {
"resultCode": "S-1",
"msg": "성공",
"data": {
"myBooks": [
{
"id": 4,
"createDate": [
2022,
11,
3,
17,
3,
22,
162538000
],
"modifyDate": [
2022,
11,
3,
17,
3,
22,
162538000
],
"ownerId": 2,
"product": {
"id": 3,
"createDate": [
2022,
11,
3,
17,
3,
22,
62061000
],
"modifyDate": [
2022,
11,
3,
17,
3,
22,
62061000
],
"authorId": 1,
"authorName": "user1",
"subject": "상품명3"
}
},
{
"id": 5,
"createDate": [
2022,
11,
3,
17,
3,
22,
162538000
],
"modifyDate": [
2022,
11,
3,
17,
3,
22,
162538000
],
"ownerId": 2,
"product": {
"id": 4,
"createDate": [
2022,
11,
3,
17,
3,
22,
66057000
],
"modifyDate": [
2022,
11,
3,
17,
3,
22,
66057000
],
"authorId": 2,
"authorName": "홍길순",
"subject": "상품명4"
}
}
]
},
"fail": false,
"success": true
}``