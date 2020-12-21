package pl.put.poznan.bootstrap.dto;

import lombok.Data;

@Data
public class PageData {
    String header;
    String paragraph;
    Nav nav;
    Head head;
    Body body;
}
