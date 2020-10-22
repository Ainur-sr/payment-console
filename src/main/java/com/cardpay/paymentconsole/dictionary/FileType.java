package com.cardpay.paymentconsole.dictionary;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.Stream;

@Slf4j
public enum FileType {
    CSV(1, "csv"),
    JSON(2, "json");

    private final Integer id;
    private final String name;

    FileType(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static FileType of(Integer id) {
        return Stream.of(FileType.values())
                .filter(x -> id.equals(x.getId()))
                .findFirst()
                .orElseThrow(() -> {
                    IllegalArgumentException e = new IllegalArgumentException("Wrong id");
                    log.error("Wrong id", e);
                    return e;
                });
    }

    public static FileType of(String name) {
        return Stream.of(FileType.values())
                .filter(x -> name.equals(x.name))
                .findFirst()
                .orElseThrow(() -> {
                    IllegalArgumentException e = new IllegalArgumentException("Wrong file extension");
                    log.error("Wrong file extension", e);
                    return e;
                });
    }



}
