package cn.zhengzb.lambda;

import java.util.function.Consumer;

/**
 * if else
 */
public final class Lambda4<T> {

    private T value;

    public Lambda4() {
        value = null;
    }

    private Lambda4(T value) {
        this.value = value;
    }

    public static <T> Lambda4<T> of(T value) {
        return new Lambda4<>(value);
    }

    public Lambda4 ifExit(Consumer<Lambda4> consumer) {
        if (null != value) {
            consumer.accept(this);
        }
        return this;
    }

    public Lambda4 ifNotExit(Consumer<Lambda4> consumer) {
        if (null == value) {
            consumer.accept(this);
        }
        return this;
    }
}
