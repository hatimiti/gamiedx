package com.github.hatimiti.gamiedx.type;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import javax.annotation.Nullable;

public abstract class BiValueType<F, S> {

    protected abstract F val1();
    protected abstract S val2();

    @Override
    public boolean equals(@Nullable Object obj) {
        if (!isIncetanceOf(obj)) {
            return false;
        }
        return val1().equals(((BiValueType<F, S>) obj).val1())
            && val2().equals(((BiValueType<F, S>) obj).val2());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(val1(), val2());
    }

    protected boolean isIncetanceOf(@Nullable final Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        try {
            return this.getClass().equals(obj.getClass());
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("val1", val1())
                .add("val2", val2())
                .toString();
    }
}
