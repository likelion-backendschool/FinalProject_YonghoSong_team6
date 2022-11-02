**[접근 방법]**

2주차와 같은 방식으로 진행하려 하였으나, (테스트 - 서비스 - 컨트롤러)  배치와 스케줄러 부분은 시간 의존적(?) 이라서 테스트 할 방법을 마땅히 생각해내지 못했습니다. 

**[진행 현황]**

 - [x] 관리자 회원
 - [x] 관리자 페이지
 - [x] 정산데이터 생성
 - [x] 정산처리
 - [ ] 정산처리 배치 (실패)
 - [x] 스케줄링
 - [ ] 출금신청
 - [ ] 출금처리 관리

**[특이사항]**
구현 과정에서 아쉬웠던 점 / 궁금했던 점을 정리합니다.

- 배치와 스케줄링의 좀더 자세한 작동방식과, 문법을 익힐 필요가 있어 보였습니다.
	-  기존의 로직과는 다른 구조를 가지고 있고, Bean 구조등이 복잡하게 얽혀있어, 다른 사람의 코드를 참고하는데엔 한계가 있는 것 같습니다.
- Chunk 방식의 배치를 만들면 매개변수를 받게 되는데, 그 매개변수 때문에 스케줄 쪽에서 호출할 수 없는 문제가 있었습니다. 이 부분은 개인적으로 질문할 예정입니다.
    
 **[Refactoring]**
 
- 배치 부분을 만들면서 발생한 의문의 Sql 오류를 고칩니다. 
```
Caused by: org.springframework.jdbc.BadSqlGrammarException: PreparedStatementCallback; bad SQL grammar [SELECT JOB_INSTANCE_ID, JOB_NAME from BATCH_JOB_INSTANCE where JOB_NAME = ? and JOB_KEY = ?]; nested exception is java.sql.SQLSyntaxErrorException: (conn=58) Table 'books3__final__dev.batch_job_instance' doesn't exist
Caused by: java.sql.SQLSyntaxErrorException: (conn=58) Table 'books3__final__dev.batch_job_instance' doesn't exist

DB 옵션이 Create 면 테이블이 없을때는 자동으로 만들어 줄 텐데 그렇지 않는 문제가 있습니다.
```
-  배치와 스케줄링 부분의 코드를 다듬에서 완성합니다.
