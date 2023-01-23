package com.dexstris.springbootdailycodebuffer.exception;

public class DepartmentEntityNotFoundException extends  Exception{
    public DepartmentEntityNotFoundException() {
        super();
    }

    public DepartmentEntityNotFoundException(String message) {
        super(message);
    }

    public DepartmentEntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DepartmentEntityNotFoundException(Throwable cause) {
        super(cause);
    }

    protected DepartmentEntityNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
