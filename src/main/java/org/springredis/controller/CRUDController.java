package org.springredis.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springredis.services.CRUDService;

import java.util.Set;

@RestController
@Api(value = "Redis Crud Controller", description = "This allows to perform CRUD operations on Redis along with searching keys")
public class CRUDController {

    @Autowired
    CRUDService crudService;

    @ApiOperation("This will get the value of the rediskey passed in the url")
    @GetMapping(value = "/get/{rediskey}")
    public String getKeyValue(@PathVariable("rediskey") String redisKey) {
        return this.crudService.getKeyValue(redisKey);
    }

    @ApiOperation("This is set the value for rediskey as redisvalue")
    @PutMapping(value = "/set/{rediskey}/{redisvalue}")
    public boolean setKeyValue(@PathVariable("rediskey") String redisKey, @PathVariable("redisvalue") String redisValue) {
        return this.crudService.setKeyValue(redisKey, redisValue);
    }

    @ApiOperation("This will check if the given key is present in Redis")
    @GetMapping("/has/{rediskey}")
    public boolean hasKeyValue(@PathVariable("rediskey") String redisKey) {
        return this.crudService.containsKeyValue(redisKey);
    }

    @ApiOperation("This will delete the rediskey passed in the url")
    @PutMapping(value = "/delete/{rediskey}")

    public boolean deleteKey(@PathVariable("rediskey") String redisKey) {
        return this.crudService.deleteKeyValue(redisKey);
    }

    @ApiOperation("This will list all the keys present in redis")
    @GetMapping(value = "/keys")
    public Set<String> listKeysDefault() {
        final String pattern = "*";
        return this.crudService.listKeys(pattern);
    }

    @ApiOperation("This will list all the keys present in redis for the given pattern")
    @GetMapping(value = "/keys/{pattern}")
    @CrossOrigin
    public Set<String> listKeysPattern(@PathVariable("pattern") String pattern) {
        return this.crudService.listKeys(pattern);
    }
}
