package org.example;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws Exception {

        URL urlObj = new URL("https://api.agify.io/?name=Rockefeller");
        HttpURLConnection conexao = (HttpURLConnection) urlObj.openConnection();
        conexao.setRequestMethod("GET");
        int resposta = conexao.getResponseCode();

        if (resposta == HttpURLConnection.HTTP_OK) {
            BufferedReader receber = new BufferedReader(new InputStreamReader(conexao.getInputStream()));

            String leitura;
            StringBuffer respons = new StringBuffer();

            while ((leitura = receber.readLine()) != null) {
                respons.append(leitura);
            }
            receber.close();

            JSONObject json = new JSONObject(respons.toString());

            String nome = json.getString("name");
            int idade = json.getInt("age");

            Pessoa pessoa = new Pessoa();
            pessoa.setNome(nome);
            pessoa.setIdade(idade);

            System.out.println("[Resposta da API] ---> " + pessoa);

        } else {
            System.out.println("API Indisponivel no momento");
        }
    }
}