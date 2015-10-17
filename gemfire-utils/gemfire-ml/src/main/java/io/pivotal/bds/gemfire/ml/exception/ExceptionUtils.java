package io.pivotal.bds.gemfire.ml.exception;

public class ExceptionUtils {

    public static void checkNotFound(Object o, String msg, Object... args) {
        if (o == null) {
            throw new NotFoundException(String.format(msg, args));
        }
    }

    public static void checkDuplicate(Object o, String msg, Object... args) {
        if (o != null) {
            throw new DuplicateException(String.format(msg, args));
        }
    }
}
