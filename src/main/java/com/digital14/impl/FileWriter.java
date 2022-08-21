package com.digital14.impl;

import com.digital14.generic.IWriter;
import java.io.IOException;

public class FileWriter implements IWriter {

    java.io.FileWriter fileWriter;
    private boolean isOpen = true;

    public FileWriter(String file) throws IOException {
        fileWriter = new java.io.FileWriter(file);
    }

    @Override
    public void writeToWriter(String string) throws IOException {
        if (isOpen) {
            fileWriter.write(string);
            fileWriter.flush();
        }
    }

    @Override
    public void close() {
    	isOpen = !isOpen;
    }
}
