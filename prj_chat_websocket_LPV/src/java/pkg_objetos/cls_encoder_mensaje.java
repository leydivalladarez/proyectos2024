package pkg_objetos;

import java.io.IOException;
import java.io.Writer;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

/**
 *
 * @author User
 */
public class cls_encoder_mensaje implements Encoder.TextStream<cls_mensaje> {

    @Override
    public void encode(cls_mensaje object, Writer writer) throws EncodeException, IOException {
        JsonObject json = Json.createObjectBuilder()
                .add("nombre", object.getNombre())
                .add("mensaje", object.getMensaje())
                .build();
        try (JsonWriter jsonWriter = Json.createWriter(writer)) {
            jsonWriter.writeObject(json);
        }
    }

    @Override
    public void init(EndpointConfig config) {
    }

    @Override
    public void destroy() {
    }
}
