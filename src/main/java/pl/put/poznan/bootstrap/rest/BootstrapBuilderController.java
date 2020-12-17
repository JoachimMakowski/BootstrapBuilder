package pl.put.poznan.bootstrap.rest;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.bootstrap.db.DataBase;
import pl.put.poznan.bootstrap.dto.PageData;
import pl.put.poznan.bootstrap.logic.BootstrapBuilder;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/pages")
public class BootstrapBuilderController {
    DataBase dataBase = new DataBase();

    private static final Logger logger = LoggerFactory.getLogger(BootstrapBuilderController.class);

    @RequestMapping(value = "/{uuid}",method = RequestMethod.GET)
    public String get(@PathVariable String uuid,
                              @RequestParam(value="transforms", defaultValue="upper,escape") String[] transforms) {
        //find uuid
        //fetch pageData
        //build pageData
        //return page
        // log the parameters
        logger.debug(uuid);
        // perform the transformation, you should run your logic here, below is just a silly example
        BootstrapBuilder bootstrapBuilder;
        PageData pageData = dataBase.getPageData(uuid);
        if(pageData!=null){
            bootstrapBuilder = new BootstrapBuilder(pageData);
            return bootstrapBuilder.toHTML();
        }else logger.debug("Nie ma w bazie danych strony z uuid:"+uuid);

        // perform the transformation, you should run your logic here, below is just a silly example
        return null;
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public String post(@RequestBody String pageDataJson) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        PageData pageData;
        try {
            pageData = objectMapper.readValue(pageDataJson, PageData.class);
            System.out.println(pageData.getTitle());
            System.out.println(pageData.getNav().getLinks().get(0).getName());
            String uuid = dataBase.savePageData(pageData);
            System.out.println(uuid);
            return objectMapper.writeValueAsString(Map.of("uuid",uuid));
        } catch (IOException e) {
            e.printStackTrace();
        }

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
        if(dataBase.deletePageData(uuid)){
            System.out.println("Z bazy danych usunięto stronę o uuid:"+uuid);
        }
        else System.out.println("W bazie nie ma strony o uuid:"+uuid);
    }

}


