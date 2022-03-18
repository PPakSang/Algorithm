# Singleton

서비스 내에서 객체 별 **단 하나의 인스턴스만이 존재하는 것을 보장**하기 위해서 사용하는 것이 **Singleton Pattern** 이다.

DataBase Connection pool, log 를 기록하고 관리하는 객체, 웹페이지의 단일 옵션 등 서비스 내에서 여러개의 객체가 필요없는 경우에 사용하여 동일한 객체를 반환하는 것을 보장하고, 메모리 낭비를 줄인다.

다만 Thread-safe 를 고려하지 않고 Singleton Pattern 을 구현하려고 했을 때 문제가 발생하는데, Singleton pattern 은 구현했지만 Thread-safe 하지 않는 경우가 있기 때문이다.

**그렇다면 어떻게 Singleton Pattern 을 Thread-safe 하게 구현할 수 있을까?**

아래 크게 4가지 방법에 대해서 알아보자

## Eager Initialization

![](https://images.velog.io/images/park9910/post/a6e5e7f7-e478-4874-b8e2-1aedda15f93a/image.png)

위 코드는 클래스로더에 의해 SingletonEager 클래스가 로드될 때 static 제어자로 명시된 instance 가 미리 생성되는 방식이다.

해당 방식은 Thread-safe 하기는 하지만 instance 가 사용되지도 않는데도 미리 생성하여 메모리를 차지하고 있는 것이 매우 비효율적인 것을 알 수 있다.

## Lazy Initialization

![](https://images.velog.io/images/park9910/post/3d48a2c5-8d8e-444b-9082-d0a60105857b/image.png)

위 코드에 대한 대안으로 instance 의 초기화 시점을 뒤로 미루는 Lazy Initialization 방식을 채택할 수 있는데

이 방식을 통해 instance 가 필요한 시점에 초기화를 할 수 있다.

다만 Thread-safe 하지 않다는 단점이 있는데, 가령 getInstance() 두개의 Thread 가 동시에 진입하면 두개의 서로다른 instance 가 생성된다.

## Double Checked Locking

![](https://images.velog.io/images/park9910/post/2645cf5a-43a3-49b4-8dbd-4aa408fb080f/image.png)

지난 코드들의 문제점들을 보안한 것이 이 **Double Checked Locking** 형태이다.

Double Checked Locking 은 기존 Lazy-Initialization 방식에서 instance 가 존재하지 않을 때만 synchronized 문을 통해 lock 을 생성하여 오버헤드가 발생하지 않도록 하며 Thread-safe 함을 보장한다.

다만 Double Checked Locking 또한 완전히 Thread-safe 하진 못하는데, 가령 첫번째 Thread 가 인스턴스를 생성을 완료하기 전 메모리에 할당하는 과정이 있는데, 이 synchronized 는 메모리 할당이 이루어지고 난 후에 lock 을 넘겨주므로 인스턴스가 초기화되기 전 찰나의 순간에 다른 Thread 가 진입하면 서로 다른 객체를 넘겨받게 된다.

즉 메모리를 효율적으로 관리하는 Singleton 코드에 적절한 동기화를 기대할 수 있는 코드이지만 여전히 완벽하지는 않다.

## Holder

가장 쉽게 같은 객체를 보장하는 방법은 클래스가 로딩되는 시점에서 static field 를 사용하는 것이다. 클래스가 로딩하고 초기화 되는 시점에서 static field 를 호출하는 과정은 Thread-safe 함을 보장하기 때문에 객체를 static final 형태로 저장하고 반환해주면 문제가 해결이 될 것이다.

여기서 한가지 의문점은 위 과정을 대충 생각해보면 Eager initialization 에서 사용한 방법과 유사하다고 생각할 수 있는데, 반은 맞고 반은 틀리다. 왜냐하면 Eager init 에서 메모리 점유 문제를 해결하면서도 static final field 를 생성해야 하는 것이 관건이기 때문이다.

### inner class

이렇게 생각해보자
1. class 로딩 시점에 static field 가 호출되는 과정이 thread-safe 하다 ?
2. 그럼 런타임에서 필요한 시점에 class 가 로딩되면 메모리도 효율적이게 사용할 것(lazy init)이고, thread-safe 도 보장할 수 있을 것이다.

그 때 사용할 수 있는 것이 **inner class** 이다.

![](https://images.velog.io/images/park9910/post/2482ac37-31f0-409a-b692-4913d50d3631/image.png)

class A 내부에 class B 를 작성하게 되면 최초 class B 의 생성자, 메소드, 필드가 호출될 때 class B 가 로딩되는데 이 점을 이용해서 getInstance() 메소드를 Holder class 의 instance 를 반환하도록 한다. 단, instance 는 static final 데이터로써 단 한번만 호출하도록 하고 최초 초기화 된 객체로 항상 초기화 되도록 설계한다.

따라서 inner-class load(thread-safe) - static final(only one) 을 구현할 수 있다.

위 Holder pattern 이 Singleton 에서 가장 보편적으로 쓰이는 방식이라고 한다.