package ru.job4j.cache;

import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<K, V> {

    private final Map<K, SoftReference<V>> cache = new HashMap<>();

    public final void put(K key, V value) {
        cache.put(key, new SoftReference<>(value));
    }

    public final V get(K key) throws IOException {
        V result = null;
        if (!cache.containsKey(key)) {
            result = load(key);
            put(key, result);
            return result;
        } else {
            SoftReference<V> softReference = cache.get(key);
            if (softReference != null) {
                result = softReference.get();
            }
            if (result == null) {
                result = load(key);
                put(key, result);
            }
        }

        return result;
    }

    protected abstract V load(K key) throws IOException;

}