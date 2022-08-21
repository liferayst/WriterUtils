package com.digital14.utils;

import com.digital14.generic.IWriter;
import java.io.IOException;

public class StupidRemoverUtil implements IWriter {

    private IWriter writer;

    public StupidRemoverUtil(IWriter iWriter) {
        writer = iWriter;
    }

    public StupidRemoverUtil() {
    }

    public String convert(String data) {
        return data.replaceAll("stupid", "s*****");
    }

    @Override
    public void writeToWriter(String data) throws IOException {
        writer.writeToWriter(convert(data));
    }

    @Override
    public void close() throws IOException {
        writer.close();
    }

    @Override
    public String toString() {
        return writer.toString();
    }
}
