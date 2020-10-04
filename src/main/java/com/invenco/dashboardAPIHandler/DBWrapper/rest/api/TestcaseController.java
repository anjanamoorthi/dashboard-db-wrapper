package com.invenco.dashboardAPIHandler.DBWrapper.rest.api;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.invenco.dashboardAPIHandler.DBWrapper.rest.model.Testcase;
import com.invenco.dashboardAPIHandler.DBWrapper.rest.service.TestcaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/testcase")
public class TestcaseController {

    @Autowired
    private TestcaseService testcaseService;

    Gson gson = new Gson();

    @PostMapping
    public @ResponseBody String saveTestcaseData(@RequestBody String data) {
        // JSONObject jobj = (JSONObject) new JSONParser().parse(data);
        JsonElement jsonElem = new JsonParser().parse(data);
        JsonObject jobj = jsonElem.getAsJsonObject();
        String action = jobj.get("action").getAsString();
        if (action.equals("add")) {
            //JSONObject jobj = jsonElem.parse(data);
            Testcase tcData = gson.fromJson(jobj.get("test").toString(), Testcase.class);
            return testcaseService.saveTestcaseData(tcData);
        }
        return "Failed to Save Testcase specific Details into DB";
    }

    @PostMapping("/delete")
    public @ResponseBody String deleteTestCaseData(@RequestBody String data) {
        JsonElement jsonElem = new JsonParser().parse(data);
        JsonObject jobj = jsonElem.getAsJsonObject();
        String action = jobj.get("action").getAsString();
        if (action.equals("delete")) {
            Testcase tcData = gson.fromJson(jobj.get("test").toString(), Testcase.class);
            return testcaseService.deleteTestcaseData(tcData);
        }
        return "Failed to Delete test case entry from DB";
    }
}
