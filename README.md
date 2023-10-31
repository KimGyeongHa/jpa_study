# jpa_study

/* 
*   23 -10 - 23
*   **JPA 복습**
*
 */

mappedby는 읽기전용으로 사용
양방향 연관관계에서 나오는 특이점 해결을 위해사용

외래키가 있는 곳을 주인으로 

양방향 연관관계일시 양방향에 값 세팅
setter에서 양방향 설정

oneToMany
mappedBy
ArrayList로 초기화가 일반적

다대일 단방향
다쪽에서 @ManyToOne @JoinColumn 일쪽 키값 설정 

다대일 양방향
일쪽에서 OneToMany 설정 후 Mappedby 다쪽 객체이름 삽입

다대일은 연관관계의 주인테이블

일대다(1:N 에서 1이 연관관계 주인)
N쪽에 외래키가 있음
@JoinColumn을 꼭 사용, 미사용시 조인 테이블 방식사용

조인테이블
일쪽 테이블의 값과 다 쪽 테이블값을 가진 중간테이블을 생성

양방향 설정 시 JoinColumn에 insertable, updatable false로
읽기전용으로 사용

결론 -> 다대일 양방향 사용

일대일
외래키가 있는곳이 연관관계주인
반대편은 mapperdBy적용
주테이블에 외래키 설정
단점 -> 외래키가 있는곳에 null값이 허용된다.


다대다
연결테이블을 엔티티로 만든다.
일대다 or 다대일로 정의하기
