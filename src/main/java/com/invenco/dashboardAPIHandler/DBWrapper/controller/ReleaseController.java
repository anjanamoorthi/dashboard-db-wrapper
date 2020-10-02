package com.invenco.dashboardAPIHandler.DBWrapper.controller;

import com.invenco.dashboardAPIHandler.DBWrapper.model.Release;
import com.invenco.dashboardAPIHandler.DBWrapper.service.ReleaseManagementService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DulaniK
 * @version 0.0.1
 * @since 25/09/2020
 */
@RestController
@RequestMapping("/release")
//@Api(value = "release", tags = "Release Controller")
public class ReleaseController {

    private static final Logger logger = LogManager.getLogger(ReleaseController.class);

    @Autowired
    ReleaseManagementService rm_service;

    @PostMapping(path = "/add", consumes = {"application/json;charset=UTF-8"})
//    @ApiOperation(value = "Add release information", notes = "add release information to the system", responseContainer = "success or fail code")
    public ResponseEntity<Object> addNewUser(@RequestBody Release release) {

        rm_service.add(release);
        return new ResponseEntity<>("Release info added successfully", HttpStatus.OK);
    }


}
