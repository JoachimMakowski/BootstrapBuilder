package pl.put.poznan.bootstrap.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.bootstrap.logic.BootstrapBuilder;

import java.util.Arrays;


@RestController
@RequestMapping("/pages")
public class BootstrapBuilderController {

    private static final Logger logger = LoggerFactory.getLogger(BootstrapBuilderController.class);

    @RequestMapping(value = "/{uuid}",method = RequestMethod.GET)
    public String get(@PathVariable String text,
                              @RequestParam(value="transforms", defaultValue="upper,escape") String[] transforms) {
        //find uuid
        //fetch pageData
        //build pageData
        //return page
        // log the parameters
        logger.debug(text);
        logger.debug(Arrays.toString(transforms));

        // perform the transformation, you should run your logic here, below is just a silly example
        BootstrapBuilder transformer = new BootstrapBuilder(transforms);
        return transformer.transform(text);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public String post(@RequestBody String pageDataJson) {
        //object mapper(jackson) ->PageData
        //save pageData in DB
        //UUID(it is a class in Java)
        //return object mapper - json with uuid and pageData
        //install postman
        // log the parameters

        logger.debug(pageDataJson);

        // perform the transformation, you should run your logic here, below is just a silly example

        return pageDataJson;
    }

    @RequestMapping(value = "/{uuid}",method =  RequestMethod.DELETE)
    public void delete(@PathVariable String uuid){
        //find uuid
        //delete pageData

    }



}


