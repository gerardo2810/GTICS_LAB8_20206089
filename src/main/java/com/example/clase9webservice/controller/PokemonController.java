package com.example.clase9webservice.controller;

import com.example.clase9webservice.entity.Pokemon;
import com.example.clase9webservice.repository.PokemonRepository;
import com.example.clase9webservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class PokemonController {

    @Autowired
    private PokemonRepository pokemonRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/location/{pokemonName}")
    public String getLocation(@PathVariable String pokemonName) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://pokeapi.co/api/v2/pokemon/" + pokemonName + "/encounters";
        return restTemplate.getForObject(url, String.class);
    }

    @GetMapping("/capture-method/{locationId}")
    public String getCaptureMethod(@PathVariable String locationId) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://pokeapi.co/api/v2/location-area/" + locationId;
        return restTemplate.getForObject(url, String.class);
    }

    @PostMapping("/capture")
    public Pokemon capturePokemon(@RequestBody Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }
}