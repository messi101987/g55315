/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g55315.humbug;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author oscartison
 */
public class Json {

    public static void main(String[] args) throws IOException {
        var objectMapper = new ObjectMapper();
        var file = new File("src/main/resources/data/test.json");
        var jsonNode = objectMapper.readTree(file);
        System.out.println(jsonNode);
        System.out.println("Value: " + jsonNode.get("key").asText());
    }
}
