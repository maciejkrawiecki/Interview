package task2;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DamageRelations {
    @JsonProperty("double_damage_from")
    private List<DamageRelation> doubleDamageFrom;

    @JsonProperty("double_damage_to")
    private List<DamageRelation> doubleDamageTo;

    @JsonProperty("half_damage_from")
    private List<DamageRelation> halfDamageFrom;

    @JsonProperty("half_damage_to")
    private List<DamageRelation> halfDamageTo;

    @JsonProperty("no_damage_from")
    private List<DamageRelation> noDamageFrom;

    @JsonProperty("no_damage_to")
    private List<DamageRelation> noDamageTo;

    public List<DamageRelation> getDoubleDamageFrom() {
        return doubleDamageFrom;
    }

    public DamageRelations setDoubleDamageFrom(List<DamageRelation> doubleDamageFrom) {
        this.doubleDamageFrom = doubleDamageFrom;
        return this;
    }

    public List<DamageRelation> getDoubleDamageTo() {
        return doubleDamageTo;
    }

    public DamageRelations setDoubleDamageTo(List<DamageRelation> doubleDamageTo) {
        this.doubleDamageTo = doubleDamageTo;
        return this;
    }

    public List<DamageRelation> getHalfDamageFrom() {
        return halfDamageFrom;
    }

    public DamageRelations setHalfDamageFrom(List<DamageRelation> halfDamageFrom) {
        this.halfDamageFrom = halfDamageFrom;
        return this;
    }

    public List<DamageRelation> getHalfDamageTo() {
        return halfDamageTo;
    }

    public DamageRelations setHalfDamageTo(List<DamageRelation> halfDamageTo) {
        this.halfDamageTo = halfDamageTo;
        return this;
    }

    public List<DamageRelation> getNoDamageFrom() {
        return noDamageFrom;
    }

    public DamageRelations setNoDamageFrom(List<DamageRelation> noDamageFrom) {
        this.noDamageFrom = noDamageFrom;
        return this;
    }

    public List<DamageRelation> getNoDamageTo() {
        return noDamageTo;
    }

    public DamageRelations setNoDamageTo(List<DamageRelation> noDamageTo) {
        this.noDamageTo = noDamageTo;
        return this;
    }
}
