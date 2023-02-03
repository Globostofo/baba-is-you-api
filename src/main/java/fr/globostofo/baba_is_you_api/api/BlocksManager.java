package fr.globostofo.baba_is_you_api.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlocksManager<K, V extends Block> {

    private final Map<K, List<V>> map = new HashMap<>();

    public void put(K key, V value) {
        System.out.println(map);
        if (map.containsKey(key)) map.get(key).add(value);
        else {
            map.put(key, new ArrayList<>() {{add(value);}});
        }
    }

    public List<V> getList(K key) {
        return map.get(key);
    }

}
