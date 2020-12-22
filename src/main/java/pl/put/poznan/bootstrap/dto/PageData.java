package pl.put.poznan.bootstrap.dto;

import lombok.Data;

/**
 * Class created to pass HTML elements from .json to head and body classes
 *
 * @author JoachimMakowski
 * @version 1.0
 */

@Data
public class PageData {
    /**
     * Takes page's head and body; rest of parameters are for testing only
     */

    String paragraph;
    Nav nav;
    Head head;
    Body body;
}
