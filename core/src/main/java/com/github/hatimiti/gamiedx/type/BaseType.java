package com.github.hatimiti.gamiedx.type;

import javax.annotation.Nullable;

public abstract class BaseType<T> {

    protected abstract T value();

    @Override
    public boolean equals(Object obj) {
        if (!isInstanceOf(obj)) {
            return false;
        }
        return value().equals(((BaseType<T>) obj).value());
    }

    @Override
    public int hashCode() {
        return value().hashCode();
    }

    protected boolean isInstanceOf(@Nullable final Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        try {
            return this.getClass().isAssignableFrom(obj.getClass());
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return value().toString();
    }
}
