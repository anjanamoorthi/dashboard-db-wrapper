/**
 * @author Moorthi Rajan
 * @version 0.0.1
 * @since 03/10/2020
 */

package com.invenco.dashboardAPIHandler.DBWrapper.rest.api;

import com.google.gson.*;
import com.invenco.dashboardAPIHandler.DBWrapper.rest.model.Release;
import com.invenco.dashboardAPIHandler.DBWrapper.rest.service.ReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import java.lang.reflect.Type;


@RestController
@RequestMapping("/release")
public class ReleaseController {

    @Autowired
    private ReleaseService service;

    //Gson gson = new Gson();

    private final Gson gson = new GsonBuilder()
            .registerTypeAdapter(Json.class, new SpringfoxJsonToGsonAdapter())
            .create();

    private static class SpringfoxJsonToGsonAdapter implements JsonSerializer<Json> {
        @Override
        public JsonElement serialize(Json json, Type type, JsonSerializationContext context) {
            final JsonParser parser = new JsonParser();
            return parser.parse(json.value());
        }
    }


    @PostMapping
    public ResponseEntity<String> saveReleaseData(@RequestBody String data) {
        // JSONObject jobj = (JSONObject) new JSONParser().parse(data);
        JsonElement jsonElem = new JsonParser().parse(data);
        JsonObject jobj = jsonElem.getAsJsonObject();
        String action = jobj.get("action").getAsString();
        Release relData = gson.fromJson(jobj.get("release").toString(), Release.class);
        if (action.equals("add") || action.equals("update")) {
            return service.saveReleaseData(relData);
        } else if (action.equals("delete")) {
            return service.deleteReleaseData(relData);
        }
        return new ResponseEntity<>("Database Manipulation has failed", HttpStatus.BAD_REQUEST);
    }

}
