# 미션 - 자동차 경주 게임 MVC 패턴 연습

### 진행 방식

- 미션은 **과제 진행 요구사항**, **기능 요구사항**, **프로그래밍 요구사항** 세 가지로 구성되어 있다.
- 세 개의 요구사항을 만족하기 위해 노력한다. **특히 기능을 구현하기 전에 기능 목록을 만들고, 기능 단위로 커밋하는 방식으로 진행한다.**
- 기능 요구사항에 기재되지 않은 내용은 스스로 판단하여 구현한다.
- **과제 기간은 2/3 ~ 2/16 이다. 단, 2/9에 필수적으로 진행된 부분까지 PR을 올려야 한다.**

### 미션 제출 방법

- 미션 구현을 완료한 후 GitHub을 통해 제출해야 한다.
- PR comment에 과제를 수행하면서 궁금한 점, 느낀 점, 배운 점, 많은 시간을 투자한 부분 등 자유롭게 작성한다.
- PR comment에는 필히 자신이 구현한 클래스 다이어그램 사진을 제출해야 한다.
- 또한 어떤 기능을 구현하였는지, 자신의 README에 작성하여 제출해야한다.


## ✔️ 과제 제출 전 체크리스트 - 0점 방지

- 터미널에서 `java -version`을 실행해 자바 21인지 확인한다. 또는 Eclipse, IntelliJ IDEA와 같은 IDE의 자바 21로 실행하는지 확인한다.
- 터미널에서 맥 또는 리눅스 사용자의 경우 `./gradlew clean test`, 윈도우 사용자의 경우 `gradlew.bat clean test` 명령을 실행했을 때 모든 테스트가 아래와 같이 통과하는지
  확인한다.

```
BUILD SUCCESSFUL in 0s
```

---

## 🚀 기능 요구사항

초간단 자동차 경주 게임을 구현한다.

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
- 아래의 프로그래밍 실행 결과 예시와 동일하게 입력과 출력이 이루어져야 한다.

<br>

## ✍🏻 입출력 요구사항

### ⌨️ 입력

- 경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)

```
pobi,woni,jun
```

- 시도할 회수

```
5
```

### 🖥 출력

- 각 차수별 실행 결과

```
pobi : --
woni : ----
jun : ---
```

- 단독 우승자 안내 문구

```
최종 우승자 : pobi
```

- 공동 우승자 안내 문구

```
최종 우승자 : pobi, jun
```

- 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 [ERROR] 로 시작해야 한다.

```
[ERROR] 시도 횟수는 숫자여야 한다.
```

### 💻 프로그래밍 실행 결과 예시

```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,woni,jun
시도할 회수는 몇회인가요?
5

실행 결과
pobi : -
woni : 
jun : -

pobi : --
woni : -
jun : --

pobi : ---
woni : --
jun : ---

pobi : ----
woni : ---
jun : ----

pobi : -----
woni : ----
jun : -----

최종 우승자 : pobi, jun
```

<br>

## 🎱 프로그래밍 요구사항

- 프로그램을 실행하는 시작점은 `Application`의 `main()`이다.
- JDK 11 버전에서 실행 가능해야 한다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
    - https://naver.github.io/hackday-conventions-java
- indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
    - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메소드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- 프로그래밍 요구사항에서 별도로 변경 불가 안내가 없는 경우 파일 수정과 패키지 이동을 자유롭게 할 수 있다.

### 추가된 요구사항
- else 예약어를 쓰지 않는다.
    - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
    - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
- 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
- 함수(또는 메서드)의 길이가 10라인을 넘어가지 않도록 구현한다.
    - 함수(또는 메소드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- 배열 대신 컬렉션을 사용한다.
- 변수명, 함수명을 줄여 쓰지 않는다(축약 금지).
- (권장, 선택) front controller패턴을 적용한다.

### 프로그래밍 요구사항 - Car 객체

- 다음 Car 객체를 활용해 구현해야 한다.
- Car 기본 생성자를 추가할 수 없다.
- name, position 변수의 접근 제어자인 private을 변경할 수 없다.
- 가능하면 setPosition(int position) 메소드를 추가하지 않고 구현한다.

```java
public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	// 추가 기능 구현
}
```

### 프로그래밍 요구사항 - Randoms, Console

- JDK에서 기본 제공하는 Random, Scanner API 대신 `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms`, `Console` API를 활용해 구현해야 한다.
    - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.
- 프로그램 구현을 완료했을 때 `src/test/java` 디렉터리의 `ApplicationTest`에 있는 모든 테스트 케이스가 성공해야 한다.
  <br>

---

## 📈 과제 진행 요구사항

- **기능을 구현하기 전에 practice-mvc-racing/docs/README.md 파일에 구현할 기능 목록을 정리**해 추가한다.
- **Git의 커밋 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위**로 추가한다.
    - [AngularJS Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) 참고해 commit log를
      남긴다.
      <br>

[reference]
우아한 테크코스
