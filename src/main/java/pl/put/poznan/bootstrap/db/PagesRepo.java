package pl.put.poznan.bootstrap.db;

import pl.put.poznan.bootstrap.dto.PageData;

public interface PagesRepo {

    PageData getPageData(String uuid);

    String savePageData(PageData pageData);

    boolean deletePageData(String uuid);//może zwracać uuid lub pageData
}
