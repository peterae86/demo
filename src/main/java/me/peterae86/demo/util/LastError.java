package me.peterae86.demo.util;

/**
 * User: tongjie.yang Date: 1/6/14 Time: 8:51 PM
 */
public class LastError {

    private static ThreadLocal<Error> errorHolder = new ThreadLocal<Error>();

    public static Error getError() {
        return errorHolder.get();
    }

    public static void setError(Error error) {
        errorHolder.set(error);
    }
}
