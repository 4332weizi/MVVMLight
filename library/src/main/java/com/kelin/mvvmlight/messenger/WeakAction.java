package com.kelin.mvvmlight.messenger;

import com.kelin.mvvmlight.command.consumer.Consumer0;

import java.lang.ref.WeakReference;

import io.reactivex.functions.Consumer;

/**
 * Created by kelin on 15-8-14.
 */
public class WeakAction<T> {
    private Consumer0 consumer0;
    private Consumer<T> consumer;
    private boolean isLive;
    private Object target;
    private WeakReference reference;

    public WeakAction(Object target, Consumer0 consumer) {
        reference = new WeakReference(target);
        this.consumer0 = consumer;

    }

    public WeakAction(Object target, Consumer<T> consumer) {
        reference = new WeakReference(target);
        this.consumer = consumer;
    }

    public void execute() {
        if (consumer0 != null && isLive()) {
            try {
                consumer0.accept();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void execute(T parameter) {
        if (consumer != null
                && isLive()) {
            try {
                consumer.accept(parameter);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void markForDeletion() {
        reference.clear();
        reference = null;
        consumer0 = null;
        consumer = null;
    }

    public Consumer0 getConsumer0() {
        return consumer0;
    }

    public Consumer<T> getConsumer() {
        return consumer;
    }

    public boolean isLive() {
        if (reference == null) {
            return false;
        }
        if (reference.get() == null) {
            return false;
        }
        return true;
    }


    public Object getTarget() {
        if (reference != null) {
            return reference.get();
        }
        return null;
    }
}
