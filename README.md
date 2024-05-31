# jpa_study

# 연관관계 매핑 

1. 다대일

		  다대일 단방향
		        
		  ManyToOne
		  JoinColumn
		        
		  다대일 양방향
		        
		  다 쪽이 연관관계의 주인이 된다.
		  OneToMany(mappedby = "연관관계의 주인 객체를 매핑")

2. 일대다

		일대다 단방향
		OneToMany
		JoinColumn
		  
		일대다 양방향 -> 공식적으로 존재하지않는다.
		  
		일대다의 경우 외래키가 다 쪽에 있어  다 쪽 테이블에 update쿼리가 나가야함으로 불필요한 쿼리발생
		
		ManyToOne
		@JoinColumn(insertable=false,updatable=false) 로 읽기전용으로 필드를 사용한다.

3. 일대일

   		일대일 단방향
		OneToOne
		JoinColumn
		  
		대상테이블에 외래키를 관리하지못한다.
		  
		일대일 양방향
		  
		OneToOne
		Mappedby
				  
		주테이블에 외래키는 유니크제약조건을 사용한다.
				  
		해당 Entity를 주테이블로 만들고 대상테이블의 외래키를 관리
				  
		객체지향적으로 봤을떈 주테이블에 외래키를 놓는것이 맞으며 db관점에서 봤을땐 
		대상테이블에 키를 놓는게 좋다고 본다. 


5. 다대다

		쓰지말자
				  
		ManyToMany 중간테이블을 만들어 각자의 키값으로 서로 매핑한다.
  
  

마무리

	  1. mappedby는 연관관계 주인이 누구인지 설정하기 위하여 사용
	  2. mappedby는 양방향 연관관계에서 나오는 특이점 해결을 위해사용
	  3. 양방향 연관관계일시 1)연관관계 편의메서드를 사용

   	1) 연관관계 편의메서드

	양방향관계를 맺어주어 객체상태에서도 오류없이 작동하기 위해 사용

***

# 기본키매핑

	GeneratedValue 자동 기본키생성
	
	옵션1.
	strategy = GenerationType.IDENTITY
	기본키 생성을 데이터베이스에 위임
	
	해당 전략사용 시 트랜잭션 Commit이전에 insert가 되고 영속성컨텍스트로 반환되어 바로 값 조회시 select쿼리가 나오지 않는다.
	
	해당 키로는 쓰기 지연 저장소에 모아두었다 Commit은 불가능하다.
	
	옵션2.
	strategy = GenerationType.SEQUENCE
	시퀀스생성하여 기본키생성
	영속성 컨텍스트에 시퀀스 값만 미리 가져오며 Commit시점에 insert쿼리
	
	allocationSize로 계속하여 생성되어 불러오는 시퀀스값을 해결할 수 있다.

***

# 상속관계 매핑

1. 조인전략
   
		@Inheritance(strategy = InheritanceType.JOINED)
		
		구분타입을 두어 구분하여 각각 테이블로 매핑된다
		
		@DiscirminationColumn을 생략하면 구분 컬럼이 안들어간다.

2. 단일테이블전략

		@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
		
		모든 값을 한 테이블에 모아두어 구현
		@DiscirminationColumn을 생략해도 구분컬럼이 들어간다

***

# 매핑 정보 상속

	@MappedSuperClass
			
	반복되는 컬럼들을 모아놓은 클래스로 상속받아 사용하면
	반복을 줄일 수 있다.
			
	모든 클래스에 각각의 값을 넣어 구현


***

# 프록시 기초

	1. 초기화요청-> 영속성 컨텍스트 -> 실제 entity -> proxy객체에 저장
			
	2. proxy는 실제 Entity 를 상속받음, proxy != Entity 으로 타입체크시 유의
			
	3. 영속성 컨텍스트에 찾는 엔티티가 있다면 getReference를 호출해도
	실제 엔티티를 반환한다. 
	이미 프록시로 조회한 값이 존재한다면 find를 해도 proxy객체를 반환한다.
			
	4. 영속성 컨텍스트의 도움을 받을 수 없을 떄 프록시 초기화 시 문제발생
	em.close(), em.clear(), em.detach() 등
			
	5. EntityMangerFactory.getPersistenceUnitUtil().isLoaded()
	프록시가 초기화 되었는지 확인
			
	6. Hibernate.initialize();
	프록시를 강제로 초기화

***

# 지연로딩 ,즉시로딩

	fetch = FetchType.LAZY
	
	지연로딩을 사용하여 프록시로 조회
	
	
	FecthType.EAGER
	
	즉시로딩
	
	즉시로딩 사용 시 쿼리가 N + 1만큼 나옴으로 사용 X
	
	@ManyToOne , @OneToOne 
	
	default EAGER -> LAZY로 설정필요
	
	@OneToMany , @ManyToMany 
	
	default 가 LAZY
	
	CASCADE
	
	종속적으로 단일테이블 연결시에만 사용
	
	고아객체
	
	orphanRemoveal = true
	
	연관된 값이 빠지면 delete쿼리출력
	
	CASCADE.ALL & orphanRemoveal = true
	
	부모엔티티에서 자식의 생명주기 관리가능

 ***
 
# 값타입

	1. 기본
	
		int, double, String ,Integer, Long 등 
	
	2. 임베디드
	
		기본생성자 필수
		
		@Embeddable 값타입을 정의하는 클래스에 표시
		
		@Embedded 값타입을 사용하는 Entity에 표시
		
		같은 클래스를 매핑하고 싶다면 
		
		@AttributeOverrides() -여러개일 경우 각각의 값 매핑
		
		@AttributeOveride로 
		각각의 값에 컬럼명을 다르게 지정 해줘야한다. 
		
		실제 인스턴스 값을 공유해야만한다.
		
		생성 시점 이후 절대 값을 변경할 수 없는 객체로 생성
		
		생성자로만 값을 생성
		
		수정 시 생성자에 새로운 값을 모두넣어 교체해야한다.
		
		인스턴스 값을 비교할떈 equals를 재정의하여 값을 비교하여야한다.
		equals 기본값은 == 
	 
	3. 컬렉션
	
		@ElementCollection
		@CollectionTable(name,joinColumn)
		
		update 시 모든 값을 삭제 후 다시등록
		
		DB에 컬렉션을 저장할 수 없으니
		
		일대다형식으로 풀어 DB에 값을 저장
		
		새로운 테이블을 생성하며 키로연결
		
		값 타입은 정말 값 타입 일때만 사용 
		
		값타입과 비슷하게 사용하고자 한다면
		
		컬레션타입은 사용을 지양하고 써야한다면  
		
		oneToMany(CascadeType.ALL,orphanRemoval = true)
		를 사용하자.
  ***
  # fetch join 페이징

	컬렉션 페치 조인을 사용하면 페이징불가
	컬렉션 페치조인은 1개만 사용하자, 컬렉션 둘 이상의 페치조인은 사용 X 
	
	
	toOne관계는 fetch join 으로 가져오고,
	컬렉션은 지연로딩으로 조회하면 페이징 가능 
	
	application.yml에서 default_batch_fetch_size값 설정 또는 @BatchSize로 해결
	
	@BatchSize 컬렉션에는 해당 컬럼위에 
	Entity의 경우에는 class위에 @BatchSize를 이용
	
	@BatchSize를 사용 시
	컬렉션 또는 프록시 객체를 한꺼번에 설정한 size만큼 IN쿼리로 조회
