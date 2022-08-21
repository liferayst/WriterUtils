package com.digital14.impl;

import com.digital14.generic.IWriter;

public class StringWriter implements IWriter {

    private StringBuilder data = new StringBuilder();
    private boolean isOpen = true;

    @Override
    public void writeToWriter(String string) {
        if (isOpen) {
            data = data.append(string);
        }
    }

    @Override
    public String toString() {
        return data.toString();
    }

    @Override
    public void close() {
        isOpen = false;
    }
}
