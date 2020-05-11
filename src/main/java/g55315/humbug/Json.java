package g55315.humbug;

import com.fasterxml.jackson.databind.ObjectMapper;
import g55315.humbug.model.Position;
import java.io.IOException;

/**
 *
 * @author oscartison
 */
public class Json {

    public static void main(String[] args) throws IOException {
        var objectMapper = new ObjectMapper();
        var in = Json.class.getResourceAsStream("/data/position.json"); 
        Position position = objectMapper.readValue(in, Position.class); 
        System.out.println("Position read: " + position);
    }
}
