package pl.put.poznan.bootstrap.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.bootstrap.db.DataBase;
import pl.put.poznan.bootstrap.dto.PageData;
import pl.put.poznan.bootstrap.logic.BootstrapBuilder;

import java.io.IOException;
import java.util.Map;

/**
 * Class created to control REST API
 *
 * @author JoachimMakowski
 * @version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/pages")
public class BootstrapBuilderController {
    DataBase dataBase = new DataBase();

    BootstrapBuilder bootstrapBuilder;

    static final ObjectMapper objectMapper = new ObjectMapper().disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

    /**
     * Creates new BootstrapBuilder and returns HTML code
     *
     * @param uuid unique key identifying page in data base
     * @return html code
     */
    @RequestMapping(value = "/{uuid}",method = RequestMethod.GET)
    public String get(@PathVariable String uuid) {
        log.debug("Get request with {}", uuid);
        PageData pageData = dataBase.getPageData(uuid);
        if(pageData!=null){
            bootstrapBuilder = new BootstrapBuilder(pageData);
            return bootstrapBuilder.toHTML();
        }else log.debug("There is no uuid: {} in DataBase", uuid);

        return null;
    }
    /**
     * Creates new PageData object and send it to DataBase class to store
     *
     * @param pageDataJson JSON file with special values
     * @return uuid identifying PageData object stored in DataBase
     */
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public String post(@RequestBody String pageDataJson) throws JsonProcessingException {
        try {
            log.debug(pageDataJson);
            PageData pageData = objectMapper.readValue(pageDataJson, PageData.class);
            String uuid = dataBase.savePageData(pageData);
            log.info(uuid);
            return objectMapper.writeValueAsString(Map.of(uuid, pageData));
        } catch (IOException e) {
            log.error("Invalid input {}", pageDataJson);
            throw e;
        }

    }
    /**
     * Sends request for deleting pageDate from DataBase
     *
     * @param uuid unique key identifying page in data base
     */
    @RequestMapping(value = "/{uuid}",method =  RequestMethod.DELETE)
    public void delete(@PathVariable String uuid){
        if(dataBase.deletePageData(uuid)){
            log.info("Deleted pageData with uuid: {}", uuid);
        }
        else log.debug("There is no uuid: {} in DataBase", uuid);
    }

}


