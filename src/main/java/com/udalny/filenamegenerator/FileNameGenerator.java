package com.udalny.filenamegenerator;

public abstract class FileNameGenerator {

    protected String extension;

    FileNameGenerator(String extension) {
        this.extension = extension;
    }

    public String generate() {
        return String.format("%s.%s", generateName(), extension);
    }

    protected abstract String generateName();
}
