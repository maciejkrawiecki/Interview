package task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;

public class App {

    private static final double DOUBLE = 2.0;
    private static final double HALF = 0.5;
    private static final double NO = 0.0;

    private static String get(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");

        if (connection.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + connection.getResponseCode());
        } else {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            return content.toString();
        }
    }

    private static List<String> getPokemonTypes() throws IOException {
        var pokemonTypesResponseBodyString = get("https://pokeapi.co/api/v2/type");
        var getPokemonTypesResponse = new ObjectMapper().readValue(pokemonTypesResponseBodyString, GetPokemonTypesResponse.class);
        return getPokemonTypesResponse.getResults().stream().map(PokemonType::getName).collect(Collectors.toList());
    }

    private static void getAllDamageTypes(List<String> types, Map<String,Double> damages) throws IOException {
        for (String type : types) {
            var pokemonTypeResponseBodyString = get("https://pokeapi.co/api/v2/type/" + type);
            var getPokemonTypeResponse = new ObjectMapper().readValue(pokemonTypeResponseBodyString, GetPokemonTypeResponse.class);

            var damageRelations = getPokemonTypeResponse.getDamageRelations();
            damageRelations.getDoubleDamageFrom().forEach(damage -> {
                damages.put(String.format("%s:%s", damage.getName(), type), DOUBLE);
            });
            damageRelations.getDoubleDamageTo().forEach(damage -> {
                damages.put(String.format("%s:%s", type, damage.getName()), DOUBLE);
            });
            damageRelations.getHalfDamageFrom().forEach(damage -> {
                damages.put(String.format("%s:%s", damage.getName(), type), HALF);
            });
            damageRelations.getHalfDamageTo().forEach(damage -> {
                damages.put(String.format("%s:%s", type, damage.getName()), HALF);
            });
            damageRelations.getNoDamageFrom().forEach(damage -> {
                damages.put(String.format("%s:%s", damage.getName(), type), NO);
            });
            damageRelations.getNoDamageTo().forEach(damage -> {
                damages.put(String.format("%s:%s", type, damage.getName()), NO);
            });
        }
    }

    public static void main(String[] args) throws IOException {
        Map<String, Double> damages = new HashMap<>();
        var types = getPokemonTypes();
        getAllDamageTypes(types, damages);

        Scanner scan = new Scanner(System.in);
        while(true) {
            System.out.println("Please provide type of attack:");
            String attackType = scan.nextLine();
            System.out.println("Please provide pokemon types (eg. fire grass poison)");
            String pokemonTypesString = scan.nextLine();

            List<String> pokemonTypes = Arrays.asList(pokemonTypesString.split(" "));

            double attackMultiplier = pokemonTypes
                    .stream()
                    .mapToDouble(pokemonType -> damages.get(String.format("%s:%s", attackType, pokemonType)))
                    .reduce(1.0, (a, b) -> a * b);

            System.out.printf("Your multiplier is: %.2f%n", attackMultiplier);
        }
    }
}
