package com.digital14.utils;

import com.digital14.generic.IWriter;
import java.io.IOException;

public class UpperCaseUtil implements IWriter {

    private IWriter writer;

    public UpperCaseUtil(IWriter iWriter) {
        writer = iWriter;
    }

    @Override
    public void close() throws IOException {
        writer.close();
    }

    @Override
    public String toString() {
        return writer.toString();
    }

    @Override
    public void writeToWriter(String data) throws IOException {
        writer.writeToWriter(convert(data));
    }
    
    public String convert(String data) {
        if(data==null){
            return "";
        }
        return data.toUpperCase();
    }
}
