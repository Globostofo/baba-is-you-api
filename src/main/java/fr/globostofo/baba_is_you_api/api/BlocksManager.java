package fr.globostofo.baba_is_you_api.api;

import fr.globostofo.baba_is_you_api.api.blocks.Block;

import java.util.*;

public class BlocksManager<K, V extends Block> {

    private final Map<K, Set<V>> map = new HashMap<>();

    public void put(K key, V value) {
        if (map.containsKey(key)) map.get(key).add(value);
        else map.put(key, new HashSet<>() {{add(value);}});
    }

    public void putAll(K key, Collection<V> c) {
        map.get(key).addAll(c);
    }

    public void removeAll(K key) {
        map.get(key).clear();
    }

    public Set<V> getAll(K key) {
        return map.get(key);
    }

}
