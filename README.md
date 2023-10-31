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

/* 
*   23 -10 - 30
*   **JPA 학습**
*
 */

상속관계 매핑

1. 조인전략

2. 단일테이블전략

@Inheritance
strategy default 싱글테이블 전략

@DiscriminatorColumn 
각 테이블을 구분할 수 있는 값을 넣는 컬럼
default값은 DTYPE

@DiscriminatorValue
각 테이블에서 구분할 값을 지정해주는 어노테이션


프록시 기초

em.getReference() 

1. 초기화요청-> 영속성 컨텍스트 -> 실제 entity생성 -> proxy객체에 저장

2. proxy는 원본 엔티티를 상속받음으로 타입체크시 유의
== 이 아닌 instance of로 체크

3. 영속성 컨텍스트에 찾는 엔티티가 있다면 getReference를 호출해도
실제 엔티티를 반환한다. 
이미 프록시로 조회한 값이 존재한다면 find를 해도 proxy객체를 반환한다.

4. 영속성 컨텍스트의 도움을 받을 수 없을 떄 프록시 초기화 시 문제발생
em.close(), em.clear(), em.detach() 등

5. EntityMangerFactory.getPersistenceUnitUtil().isLoaded()
프록시가 초기화 되었는지 확인

6. Hibernate.initialize();
프록시를 강제로 초기화
