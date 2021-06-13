package com.github.hatimiti.gamiedx.type;

public abstract class BaseType<T> {

    public abstract T value();

    @Override
    public boolean equals(Object obj) {
        if (!isIncetanceOf(obj)) {
            return false;
        }
        return value().equals(((BaseType<T>) obj).value());
    }

    @Override
    public int hashCode() {
        return value().hashCode();
    }

    protected boolean isIncetanceOf(final Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return this.getClass().equals(obj.getClass());
        } catch (Throwable t) {
            return false;
        }
    }

    @Override
    public String toString() {
        return value().toString();
    }
}
