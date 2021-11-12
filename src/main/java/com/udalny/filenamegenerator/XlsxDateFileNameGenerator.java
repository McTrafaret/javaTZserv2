package com.udalny.filenamegenerator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class XlsxDateFileNameGenerator
        extends FileNameGenerator {

    private final SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy-HH:mm:ss");

    @Value("${xlsx.save.filename}")
    private String name;

    public XlsxDateFileNameGenerator() {
        super("xlsx");
    }

    @Override
    protected String generateName() {
        Date date = new Date();
        return String.format("%s_%s", name, formatter.format(date));
    }
}
