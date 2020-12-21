package pl.put.poznan.bootstrap.db;

import pl.put.poznan.bootstrap.dto.PageData;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
/**
 * Implements DataBase
 *
 * @author JoachimMakowski
 * @version 1.0
 */
public class DataBase implements PagesRepo{
    private Map<String, PageData> db = new HashMap<>();

    @Override
    public PageData getPageData(String uuid) {
        return db.get(uuid);
    }

    @Override
    public String savePageData(PageData pageData) {
        String uuid = UUID.randomUUID().toString();
        db.put(uuid, pageData);
        return uuid;
    }

    @Override
    public boolean deletePageData(String uuid) {
        if (db.containsKey(uuid)) {
            PageData pageData = db.remove(uuid);
            return true;//change to pageData
        }else return false;
    }
}
