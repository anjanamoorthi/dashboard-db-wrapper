/**
 * JSON Object for POST Message is as shown below
 *
 *  <PRE>
 *   {
 *     "name" : "123ABC",
 *     "iteration" : 2,
 *     "start_date" : "2020-10-10",
 *     "end_date" : "2020-10-15",
 *     "release_status" : "ON_HOLD",
 *     "product_name":"G7"
 *        }
 *   </PRE>
 * @author Moorthi Rajan
 * @version 0.0.1
 * @since 03/10/2020
 */

package com.invenco.dashboardAPIHandler.DBWrapper.rest.api;

import com.google.gson.*;
import com.invenco.dashboardAPIHandler.DBWrapper.rest.dao.Release_DAO;
import com.invenco.dashboardAPIHandler.DBWrapper.rest.dto.Release_DTO;
import com.invenco.dashboardAPIHandler.DBWrapper.rest.service.ProductService;
import com.invenco.dashboardAPIHandler.DBWrapper.rest.service.ReleaseService;
import com.invenco.dashboardAPIHandler.DBWrapper.rest.service.ReleaseStatusService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import javax.validation.Valid;
import java.lang.reflect.Type;


@RestController
@RequestMapping("/release")
public class ReleaseController {

    Logger logger = LogManager.getLogger(ReleaseController.class);

    @Autowired
    private ReleaseService service;

    @Autowired
    private ProductService prodService;

    @Autowired
    private ReleaseStatusService relStatusService;

    @PostMapping("/add")
    public @ResponseBody HttpEntity<Object> saveReleaseData(@Valid @RequestBody Release_DAO releaseData) {
        Release_DTO releaseDto;
        try {
            releaseDto = service.saveReleaseData(releaseData);
        } catch (Exception e) {
            return new ResponseEntity<>("Invalid DB Operation", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(releaseDto, HttpStatus.OK);
    }




}
