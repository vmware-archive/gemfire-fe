package io.pivotal.bds.gemfire.util;

public class Assert {

    public static void notNull(Object o, String f, Object... args) {
        if (o == null) {
            throw new IllegalArgumentException(String.format(f, args));
        }
    }

    public static void isNull(Object o, String f, Object... args) {
        if (o != null) {
            throw new IllegalArgumentException(String.format(f, args));
        }
    }

    public static void isTrue(Boolean b, String f, Object... args) {
        if (!Boolean.TRUE.equals(b)) {
            throw new IllegalArgumentException(String.format(f, args));
        }
    }

    public static void isFalse(Boolean b, String f, Object... args) {
        if (!Boolean.FALSE.equals(b)) {
            throw new IllegalArgumentException(String.format(f, args));
        }
    }

    public static void hasText(String s, String f, Object... args) {
        if (s == null || s.trim().length() == 0) {
            throw new IllegalArgumentException(String.format(f, args));
        }
    }

    private Assert() {
    }
}
