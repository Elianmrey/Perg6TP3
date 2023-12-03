package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pessoa {

    @JsonProperty("name")
    private String nome;

    @JsonProperty("age")
    private int idade;

    @Override
    public String toString()
    {
        return "Nome: " + nome + " Idade: " + idade;
    }

}
