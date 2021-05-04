package builder;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public abstract class Pizza {
    public enum Topping {
        HAM, MUSHROOM, ONION, PEPPER, SAUSAGE
    }

    final Set<Topping> toppings;

    abstract static class Builder<T extends Builder<T>> {
        // EnumSet.noneOf : 매개변수로 전달한 Enum 클래스 타입으로 빈 Set을 만듦.
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
        public T addToping(Topping topping) {
            // Objects.requireNonNull : 매개변수로 전달한 topping이 null인지 확인하고, null이면 NullPointerException을 발생시킨다.
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract Pizza build();
        protected abstract T self();
    }

    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone();
    }
}
