package singleton;

// 이게 가장 바람직한 싱글톤 방식이다.
// 직렬화나 리플랙션에도 제 2의 인스턴스가 생기는 일을 막아준다.
public enum EnumSingleton {
    INSTANCE;
}
