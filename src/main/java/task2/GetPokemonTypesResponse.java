package task2;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetPokemonTypesResponse {
    private int count;
    private List<PokemonType> results;
    private String next;
    private String previous;

    public int getCount() {
        return count;
    }

    public GetPokemonTypesResponse setCount(int count) {
        this.count = count;
        return this;
    }

    public List<PokemonType> getResults() {
        return results;
    }

    public GetPokemonTypesResponse setResults(List<PokemonType> results) {
        this.results = results;
        return this;
    }

    public String getNext() {
        return next;
    }

    public GetPokemonTypesResponse setNext(String next) {
        this.next = next;
        return this;
    }

    public String getPrevious() {
        return previous;
    }

    public GetPokemonTypesResponse setPrevious(String previous) {
        this.previous = previous;
        return this;
    }
}
