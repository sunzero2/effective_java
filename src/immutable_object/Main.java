package immutable_object;

import java.util.regex.Pattern;

public class Main {
    private static final Pattern ROMAN = Pattern.compile("^(?=.)M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

    public static void main(String[] args) {
        // 실행될 때마다 String 인스턴스를 새로 만듦.
        // 쓸데없는 행위!
        String s1 = new String("bikini");

        // 하나의 String 인스턴스를 사용.
        // 같은 VM 안에서 이와 똑같은 문자열 리터럴을 사용하는 모든 코드가 같은 객체를 재사용함을 보장
        String s2 = "bikini";
    }

    static boolean isRomanNumeral(String s) {
        // String.matches : 이 메서드의 내부에서 생성하는 Pattern 인스턴스는 한 번 쓰고 버려짐.
        //                  --> 곧바로 가비지 컬렉션 대상이 됨. Pattern은 정규표현식에 해당하는 유한 상태 머신을 만들기 때문에 생성 비용이 높음
        //                  성능을 개선하려면 불변 Pattern 인스턴스를 클래스 초기화 과정에서 직접 생성해 캐싱해두고 호출될 때마다 이 인스턴스를 재사용 해야 함.
        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }

    static boolean isRomanNumeral2(String s) {
        return ROMAN.matcher(s).matches();
    }
}
