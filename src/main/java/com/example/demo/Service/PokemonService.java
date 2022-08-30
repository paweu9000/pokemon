package com.example.demo.Service;

import com.example.demo.Repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PokemonService {

    @Autowired
    PokemonRepository pokemonRepository;
}
