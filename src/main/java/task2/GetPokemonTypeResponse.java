package task2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetPokemonTypeResponse {
    @JsonProperty("damage_relations")
    private DamageRelations damageRelations;

    public DamageRelations getDamageRelations() {
        return damageRelations;
    }

    public GetPokemonTypeResponse setDamageRelations(DamageRelations damageRelations) {
        this.damageRelations = damageRelations;
        return this;
    }
}
