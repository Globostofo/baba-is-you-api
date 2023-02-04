package fr.globostofo.baba_is_you_api.api;

import fr.globostofo.baba_is_you_api.api.blocks.types.AttributeType;
import fr.globostofo.baba_is_you_api.api.blocks.types.EntityType;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RulesManager {

    private final Map<EntityType, Set<AttributeType>> map = new HashMap<>();
    private final Set<EntityType> youEntities = new HashSet<>();

    public void addRule(EntityType e, AttributeType a) {
        if (a == AttributeType.YOU) youEntities.add(e);
        if (map.containsKey(e)) map.get(e).add(a);
        else map.put(e, new HashSet<>() {{add(a);}});
    }

    public void removeRule(EntityType e, AttributeType a) {
        if (a == AttributeType.YOU) youEntities.remove(e);
        map.get(e).remove(a);
    }

    public Set<EntityType> getYouEntities() {
        return youEntities;
    }

}
