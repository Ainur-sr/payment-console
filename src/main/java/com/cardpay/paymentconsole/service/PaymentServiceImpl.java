package com.cardpay.paymentconsole.service;


import com.cardpay.paymentconsole.dictionary.FileType;
import com.cardpay.paymentconsole.domain.Payment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PaymentServiceImpl implements PaymentService {

    private final PaymentCsvService paymentCsvService;
    private final PaymentJsonService paymentJsonService;


    @Override
    public void parseFiles(String... args) {
        Map<FileType, List<File>> filesMap = getExistFiles(args);
        if (!CollectionUtils.isEmpty(filesMap)) {
            for (FileType type : FileType.values()) {
                switch (type) {
                    case CSV:
                        List<File> csvFiles = filesMap.get(type);
                        if (!CollectionUtils.isEmpty(csvFiles)) {
                            for (File file : csvFiles) {
                                try {
                                    printResults(paymentCsvService.getPaymentList(file));
                                } catch (IOException e) {
                                    log.error("Error on fetch data", e);
                                    e.printStackTrace();
                                }
                            }
                        }
                        break;

                    case JSON:
                        List<File> jsonFiles = filesMap.get(type);
                        if (!CollectionUtils.isEmpty(jsonFiles)) {
                            for (File file : jsonFiles) {
                                try {
                                    printResults(paymentJsonService.getPaymentList(file));
                                } catch (IOException e) {
                                    log.error("Error on fetch data", e);
                                    e.printStackTrace();
                                }
                            }
                        }
                }
            }
        }
    }


    private Map<FileType, List<File>> getExistFiles(String... args) {
        Map<FileType, List<File>> resultMap = new EnumMap<>(FileType.class);

        for (String arg : args) {
            if (!StringUtils.isEmpty(arg)) {
                File file = new File(arg);
                if (file.exists()) {
                    String ext = getFileExtension(arg);
                    FileType type = FileType.of(ext);
                    switch (type) {
                        case CSV:
                            setFileToMap(resultMap, FileType.CSV, file);
                            break;

                        case JSON:
                            setFileToMap(resultMap, FileType.JSON, file);
                    }
                } else {
                    RuntimeException e = new RuntimeException("File " + arg + "isn't exist.");
                    log.error("File " + arg + "isn't exist.", e);
                    throw e;
                }
            } else {
                RuntimeException e = new RuntimeException("File name is empty");
                log.error("File name is empty", e);
                throw e;
            }
        }

        return resultMap;
    }

    private String getFileExtension(String fileName) {
        String resultStr = null;
        if (!StringUtils.isEmpty(fileName)) {
            int index = fileName.lastIndexOf('.');
            resultStr = index == -1 ? null : fileName.substring(index);
        }
        return resultStr;
    }

    private void setFileToMap(Map<FileType, List<File>> resultMap, FileType type, File file) {
        List<File> files = resultMap.get(type);
        if (!CollectionUtils.isEmpty(files)) {
            files.add(file);
        } else {
            files = new ArrayList<>();
            files.add(file);
            resultMap.put(type, files);
        }
    }

    private void printResults(List<Payment> paymentList) {
        paymentList.forEach(System.out::println);
    }
}
