package com.javi.Get;

//nuevos imports
import com.fasterxml.jackson.databind.ObjectMapper;

import com.javi.ProjectoFinal.MineSquare;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;


public class GetsAndPostsOfTheAPIREST {

    // one instance, reuse
    private final CloseableHttpClient httpClient = HttpClients.createDefault();

    public static void main(String[] args) throws Exception {

        GetsAndPostsOfTheAPIREST obj = new GetsAndPostsOfTheAPIREST();

        try {
            /*System.out.println("Testing 1 - Send Http GET request");
            MineSquare[][] mineSquare = obj.getGameGrid();

            System.out.println("Array Columnas 1: " + mineSquare[0].length);
            System.out.println("Array Filas 2: " + mineSquare.length);
            System.out.println("Minesquare Tamanio 2: " + mineSquare[0][0].getSquareState());
            */
            //System.out.println("Testing 2 - Send Http POST CREATE GAME request");
            //obj.PostCreateGame();

            /*X X X X X
            X X X X X
            X X X X X 40x50
            X X X X X
            X X X X X*/

            //System.out.println("Testing 3 - Send Http POST CREATE-CUSTOM-GAME");
            //obj.PostCreateCustomGame();

            //System.out.println("Testing 4 - Send Http GET RESTORE GAME request");
            //obj.sendGetRestoreGame();
        } finally {
            obj.close();
        }
    }

    private void close() throws Exception {
        httpClient.close();
    }

    public MineSquare[][] getGameGrid() throws Exception {
        HttpGet request = new HttpGet("https://bucaminasprueba.herokuapp.com/get-game-grid?user=1");

        // add request headers
        System.out.println("request headers?");
        request.addHeader("custom-key", "mkyong");
        request.addHeader(HttpHeaders.USER_AGENT, "Googlebot");

        try (CloseableHttpResponse response = httpClient.execute(request)) {
            /*
            System.out.println("STATUS");
            System.out.println(response.getStatusLine().toString());
            */
            HttpEntity entity = response.getEntity();
            /*
            Header headers = entity.getContentType();
            System.out.println(headers);
            */
            if (entity != null) {
                
                String result = EntityUtils.toString(entity);
                /*
                System.out.println("NUEVO RESULT");
                System.out.println(restoreGameGridJson(result));
                System.out.println("RESULT EN LENGHT");
                System.out.println(restoreGameGridJson(result).length);
                */
                return restoreGameGridJson(result);
            }
        }
        return null;
    }

    private MineSquare[][] restoreGameGridJson(String gameGridJson) throws Exception{
        ObjectMapper mapper = new ObjectMapper(); //ES UTILIZADO PARA TRANSFORMAR UN VALOR EN UN OBJETO, YA DEBEN EXISTIR LAS CARACTERISTICAS DE DICHO OBJETO PARA ESTE PROCESO
        return mapper.readValue(gameGridJson,MineSquare[][].class);
    }

    private void PostCreateGame() throws Exception {

        HttpPost post = new HttpPost("https://bucaminasprueba.herokuapp.com/create-game?user=1");

        // add request parameter, form parameters
        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("username", "abc"));
        urlParameters.add(new BasicNameValuePair("password", "123"));
        urlParameters.add(new BasicNameValuePair("custom", "secret"));

        post.setEntity(new UrlEncodedFormEntity(urlParameters));

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post)) {

            System.out.println("Respues de entity");
            System.out.println(EntityUtils.toString(response.getEntity()));
        }

    }
    private void PostCreateCustomGame() throws Exception {
        HttpPost postCCG = new HttpPost("https://minesweeper-api-game.herokuapp.com/create-custom-game?cols=5&rows=5&totalMines=1&user=Javier");
        try (CloseableHttpClient httpClient = HttpClients.createDefault();CloseableHttpResponse response = httpClient.execute(postCCG)) {
            System.out.println("Respuesta CCG");
            System.out.println(EntityUtils.toString(response.getEntity()));
        }
    }

    public void getRedMark(int i, int j) throws Exception {
        HttpGet request = new HttpGet("https://bucaminasprueba.herokuapp.com/square-selection-red-mark?col=" + j + "&row=" + i + "&user=1");

        try (CloseableHttpResponse response = httpClient.execute(request)) {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String result = EntityUtils.toString(entity);
            }
        }
    }
    public void getQuestionMark(int i, int j) throws Exception {
        HttpGet request = new HttpGet("https://bucaminasprueba.herokuapp.com/square-selection-question-mark?col=" + j + "&row=" + i + "&user=1");

        try (CloseableHttpResponse response = httpClient.execute(request)) {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String result = EntityUtils.toString(entity);
            }
        }
    }
    public void getSquareReveal(int i, int j) throws Exception {
        HttpGet request = new HttpGet("https://bucaminasprueba.herokuapp.com/square-selection-reveal?col=" + j + "&row=" + i + "&user=1");

        try (CloseableHttpResponse response = httpClient.execute(request)) {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String result = EntityUtils.toString(entity);
            }
        }
    }
    
    //agregar getSquaredNotRevealMark

}