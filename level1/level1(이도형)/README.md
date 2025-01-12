# 온보딩

### 1. 객체지향 프로그래밍이란?
객체지향 프로그래밍이란 프로그래밍에서 필요한 데이터를 추상화시켜 상태와 행위를 가진 객체로 만들고, 객체들간 상호작용을 통해 로직을 구현하는 것입니다.

### 2. 객체지향 프로그래밍의 장, 단점
객체지향 프로그래밍의 장, 단점은 대표적으로 각각 3가지를 들 수 있습니다.


장점
- 클래스 단위로 모듈화시켜서 개발하기 때문에 업무 분담이 편리하고 대규모 소프트웨어 개발에 적합합니다.
- 클래스 단위로 수정이 가능하기 때문에 유지보수가 편리합니다.
- 클래스를 재사용하거나 상속을 통해 확장함으로써 코드 재사용이 용이합니다.


단점
- 처리속도가 상대적으로 느립니다.
- 객체의 수가 많아짐에 따라 용량이 커질 수 있습니다.
- 설계 시 많은 시간과 노력이 필요하게 될 수 있습니다.

### 3. 절차지향과 객체지향의 차이
절차지향과 객체 지향의 차이라고 하면은 먼저 절차지향은 프로그램을 순차적인 절차로 구성하고, 함수와 데이터를 별도로 취급하며 주로 함수단위로 
재사용한다는 특징이 있는 반면, 객체 지향은 프로그램을 객체로 구성하고, 데이터와 기능을 객체 내부에 통합하며, 재사용을 위해
상속, 다형성을 사용한다는 점에서 차이를 보이고 있습니다.
### 4. 클래스와 객체

- 클래스란?
변수와 메소드를 가지고 있는 집합이자, 객체를 생성하기 위한 틀이라고 할 수 있습니다. 
- 객체란? 
객체는 프로그램에서 사용되는 데이터 또는 식별자에 의해 참조되는 공간을 의미하며 값을 저장할 변수와 작업을 수행할 메소드를 서로 연관된 
것들끼리 묶어서 만든 것을 객체라고 할 수 있습니다.
- 클래스와 객체의 차이: 클래스는 객체를 만들기 위한 설계도이며, 데이터와 메소드의 구조를 정의합니다. 
하지만 객체는 클래스에서 생성된 실체 즉 인스턴스이며, 클래스의 구조를 기반으로 만들어진 개별적인 존재라는 점에서 차이점을 보이고 있습니다.
- 인스턴스란? 클래스로부터 만들어진 객체를 인스턴스라고 합니다.

### 5. 추상화란?
// 추상 클래스 정의
abstract class Animal {
// 추상 메서드 (구현 없음)
abstract void makeSound();

    // 일반 메서드 (구현 있음)
    void eat() {
        System.out.println("This animal eats food.");
    }
}

// 구체적인 클래스: Dog
class Dog extends Animal {
@Override
void makeSound() {
System.out.println("Woof! Woof!");
}
}

// 구체적인 클래스: Cat
class Cat extends Animal {
@Override
void makeSound() {
System.out.println("Meow! Meow!");
}
}

// 테스트 클래스
public class Main {
public static void main(String[] args) {
Animal dog = new Dog(); // 업캐스팅
Animal cat = new Cat(); // 업캐스팅

        dog.makeSound(); // 출력: Woof! Woof!
        dog.eat();       // 출력: This animal eats food.

        cat.makeSound(); // 출력: Meow! Meow!
        cat.eat();       // 출력: This animal eats food.
    }
}
이처럼 코드에서 볼 수 있듯이 동물이라는 공통된 속성과 메소드를 정의한 추상클래스와 이것을 구체적으로 구현하는 클래스에서 볼 수 있듯이
추상화는 객체에서 공통된 속성과 행위를 추출하고, 공통의 속성과 행위를 찾아서 타입을 정의하는 과정을 의미합니다.
또한 추상화는 불필요한 정보는 숨기고 중요한 정보만을 표현함으로써 프로그램을 간단하게 만드는 것을 의미합니다.

### 6. 캡슐화란?
class BankAccount {
// private 접근 제어자로 데이터 보호
private String accountNumber;
private double balance;

    // 생성자
    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            System.out.println("Initial balance cannot be negative. Setting to 0.");
            this.balance = 0;
        }
    }

    // Getter: 계좌번호 반환 (읽기 전용)
    public String getAccountNumber() {
        return accountNumber;
    }

    // Getter: 잔액 반환
    public double getBalance() {
        return balance;
    }

    // Setter: 입금 (양수만 허용)
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + " deposited. New balance: " + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Setter: 출금 (잔액 부족 시 처리)
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(amount + " withdrawn. New balance: " + balance);
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }
}

public class Main {
public static void main(String[] args) {
// 계좌 생성
BankAccount account = new BankAccount("123-456-789", 1000);

        // 정보 조회
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Balance: " + account.getBalance());

        // 입금 및 출금
        account.deposit(500);   // 출력: 500 deposited. New balance: 1500
        account.withdraw(200);  // 출력: 200 withdrawn. New balance: 1300
        account.withdraw(2000); // 출력: Insufficient balance.
    }
}
계좌번호같은 개인의 민감한 정보를 접근제한자 private을 사용하여 데이터의 무결성과 보안을 유지하는 것을 보여줍니다. 또한 getter와 setter메소드를
통해 데이터를 처리하는 방식을 외부에 드러내는 것이 아닌, 객체 스스로 처리하는 것을 보여줍니다. 
즉 캡슐화는 데이터 구조와 데이터를 다루는 방법들을 결합시켜 묶는 것, 그리고 외부에는 그 행위를 보여주지 않는 것을 의미합니다. 

- 적절한 접근 제어자를 사용해야 하는 이유:
적절한 접근 제어자를 사용해야하는 이유는 소프트웨어 개발의 안전성, 보안성, 유지보수성을 높이기 위해서입니다.
### 7.  상속이란?
// 부모 클래스 (Super Class)
class Animal {
// 속성
String name;

    // 생성자
    public Animal(String name) {
        this.name = name;
    }

    // 메서드
    public void eat() {
        System.out.println(name + " is eating.");
    }

    public void sleep() {
        System.out.println(name + " is sleeping.");
    }
}

// 자식 클래스 (Sub Class): Animal을 상속받음
class Dog extends Animal {
// 생성자: 부모 클래스의 생성자를 호출
public Dog(String name) {
super(name); // 부모 클래스의 생성자 호출
}

    // 메서드 오버라이딩
    @Override
    public void eat() {
        System.out.println(name + " is eating dog food.");
    }

    // 새로운 메서드
    public void bark() {
        System.out.println(name + " says Woof!");
    }
}

// 또 다른 자식 클래스
class Cat extends Animal {
public Cat(String name) {
super(name);
}

    @Override
    public void eat() {
        System.out.println(name + " is eating cat food.");
    }

    public void meow() {
        System.out.println(name + " says Meow!");
    }
}

// 실행 클래스
public class Main {
public static void main(String[] args) {
// Dog 객체 생성
Dog dog = new Dog("Buddy");
dog.eat();    // 출력: Buddy is eating dog food.
dog.sleep();  // 출력: Buddy is sleeping.
dog.bark();   // 출력: Buddy says Woof!

        // Cat 객체 생성
        Cat cat = new Cat("Kitty");
        cat.eat();    // 출력: Kitty is eating cat food.
        cat.sleep();  // 출력: Kitty is sleeping.
        cat.meow();   // 출력: Kitty says Meow!

        // 업캐스팅 (Animal 타입으로 참조)
        Animal animal = new Dog("Charlie");
        animal.eat();  // 출력: Charlie is eating dog food.
        animal.sleep(); // 출력: Charlie is sleeping.

        // animal.bark(); // 오류: Animal 타입에서는 bark() 사용 불가
    }
}
이 예제 코드를 보면, Animal이라는 부모 클래스가 모든 동물의 속성과 메소드를 정의하고 있고, 하위 클래스들이 이의 공통속성을 공유하고
메소드를 각각 동물에 맞게 재정의하는 것을 볼 수 있습니다.
즉 상속이란 클래스의 속성과 행위를 하위 클래스에 물려주거나, 하위클래스가 상위클래스의 속성과 행위를 물려받는 것, 그리고 새로운
클래스가 기존의 클래스의 데이터와 연산을 이용할 수 있게 하는 기능을 의미합니다. 
### 8. 다형성이란?
// 부모 클래스
class Animal {
public void makeSound() {
System.out.println("Some generic animal sound");
}

    public void eat() {
        System.out.println("This animal eats food.");
    }
}

// 자식 클래스: Dog
class Dog extends Animal {
@Override
public void makeSound() {
System.out.println("Woof! Woof!");
}

    public void fetch() {
        System.out.println("The dog is fetching a ball.");
    }
}

// 자식 클래스: Cat
class Cat extends Animal {
@Override
public void makeSound() {
System.out.println("Meow! Meow!");
}

    public void scratch() {
        System.out.println("The cat is scratching the furniture.");
    }
}

// 실행 클래스
public class Main {
public static void main(String[] args) {
// 부모 타입으로 자식 객체 참조 (업캐스팅)
Animal animal1 = new Dog();
Animal animal2 = new Cat();

        // 다형성을 통한 메서드 호출
        animal1.makeSound(); // 출력: Woof! Woof!
        animal2.makeSound(); // 출력: Meow! Meow!

        animal1.eat();       // 출력: This animal eats food.
        animal2.eat();       // 출력: This animal eats food.

        // animal1.fetch();  // 오류: 부모 타입에서는 fetch() 메서드 호출 불가
        // animal2.scratch(); // 오류: 부모 타입에서는 scratch() 메서드 호출 불가

        // 명시적 다운캐스팅으로 자식 클래스의 메서드 사용
        if (animal1 instanceof Dog) {
            Dog dog = (Dog) animal1;
            dog.fetch();    // 출력: The dog is fetching a ball.
        }

        if (animal2 instanceof Cat) {
            Cat cat = (Cat) animal2;
            cat.scratch();  // 출력: The cat is scratching the furniture.
        }

        // 배열로 다형성 활용
        Animal[] animals = {new Dog(), new Cat()};
        for (Animal animal : animals) {
            animal.makeSound();
        }
        // 출력:
        // Woof! Woof!
        // Meow! Meow!
    }
}
이 코드를 보면 자식 클래스인 Dog와 Cat에서 makeSound()의 메서드를 오버라이딩을 함으로써 객체의 타입에 따라 적절한 메소드가 호출될 수 있게 해주고
있습니다.
즉 다형성이란 하나의 객체가 여러 형태를 가질 수 있는 성질을 의미합니다. 
→ 5,6,7,8 코드 예시 하나 들어 정확한 이해를 자신의 말로 설명하기

### 9. 객체지향적 설계 원칙 (SOLID)
- 단일 책임 원칙 : 하나의 클래스는 단 하나의 책임을 가져야하며, 단일 책임 원칙을 지키지 않을 경우, 다른 코드에 영향이 갈 수 있다.
- 개방-폐쇄 원칙 : 소프트웨어 요소는 확장에는 열려있으나 변경에는 닫혀 있어야하며, 기능을 변경하거나 확장할 수 있으면서
기능을 사용하는 코드는 수정하지 않는다.
- 리스코프 치환 원칙 : 프로그램 객체는 프로그램의 정확성을 꺠뜨리지 않으면서 하위 타입의 인스턴스로 바꿀 수 있어야 하며,
상위 타입의 객체를 하위 타입의 객체로 치환해도, 상취 타입을 사용하는 프로그램은 정상적으로 동작해야 합니다.
- 인터페이스 분리 원칙 : 범용 인터페이스 하나보다 클라이언트를 위한 여러 개의 인터페이스로 구성하는 것이 좋으며
인터페이스는 인터페이스를 사용하는 클라이언트를 기준으로 분리해야 합니다. 그리고 클라이언트가 필요로 하는 인터페이스로 분리함으로써 각 클라이언트가
사용하지 않는 인터페이스에 변경이 있어도 영향을 받지 않도록 만들어야합니다.
- 의존 관계 역전 원칙 : 추상화에 의존해야지 구체화에 의존하면 안되며, 고수준 모듈은 저수준 모듈의 구현에 의존해서는 안되며 저수준 모듈은
고수준 모듈에서 정의한 추상 타입에 의존해야합니다ㅣ.
### 10. 인터페이스와 추상클래스

- 인터페이스란? 객체의 동장을 정의하는 완전한 추상화 구조를 의미합니다.
- 추상클래스란? 일부 메서드만 구현되어 있거나, 추상 메소드를 포함한 클래스를 의미합니다.ㅣ
- 인터페이스와 추상클래스 차이점: 인터페이스는 객체의 행위를 정의하고, 다중 구현이 가능한 반면
추상 클래스는 공통된 기능 제공, 세부 구현을 강제하고, 단일 상속만 가능하다는 점에서 차이를 보이고 있습니다. 

### 10. 클린 코드란 무엇이며, 지켜야할 점들이 어떤 것들이 있는가?
클린코드란 원하는 로직을 빠르게 찾을 수 있는 코드, 모든 팀원이 이해하기 쉽도록 작성된 코드라고 정의할 수 있습니다. 
클린 코드에서 지켜야 할 것들은 다음과 같이 5개가 있습니다.
- 코딩 표준, 아키텍처 표준 및 설계 가이드를 준수해야 합니다
- 단순한 것이 효율적이며, 복잡함을 최소화해야합니다.
- 참조되거나 수정되는 코드는 원래보다 클린해야합니다. 그리고 자신이 담당하기 이전의 코드보다 더 클린하게 만들어야합니다.
- 항상 근본적인 원인을 찾아야합니다. 
- 하나의 파일은 하나의 언어로 작성해야합니다. 