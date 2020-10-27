/**
 * @author Moorthi Rajan
 * @version 0.0.1
 * @since 03/10/2020
 */

package com.invenco.dashboardAPIHandler.DBWrapper.rest.api;

import com.google.gson.*;
import com.invenco.dashboardAPIHandler.DBWrapper.rest.dao.Release_DAO;
import com.invenco.dashboardAPIHandler.DBWrapper.rest.service.ProductService;
import com.invenco.dashboardAPIHandler.DBWrapper.rest.service.ReleaseService;
import com.invenco.dashboardAPIHandler.DBWrapper.rest.service.ReleaseStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import javax.validation.Valid;
import java.lang.reflect.Type;


@RestController
@RequestMapping("/release")
public class ReleaseController {

    @Autowired
    private ReleaseService service;

    @Autowired
    private ProductService prodService;

    @Autowired
    private ReleaseStatusService relStatusService;

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


    @PostMapping("/add")
    public ResponseEntity<String> saveReleaseData(@Valid @RequestBody Release_DAO releaseData) {

        try {
            service.saveReleaseData(releaseData);
        } catch (Exception e) {
            return new ResponseEntity<>("Database Manipulation has failed", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Successfully saved", HttpStatus.OK);
    }


}
