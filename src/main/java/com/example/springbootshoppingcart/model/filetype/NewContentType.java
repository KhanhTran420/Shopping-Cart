package com.example.springbootshoppingcart.model.filetype;

public enum NewContentType {
    VIDEO("video"),
    IMAGE("anh");

    public final String type;

    NewContentType(String type) {
        this.type = type;
    }
}
