package com.digital14.utils;

import com.digital14.generic.IWriter;
import java.io.IOException;

public class LowerCaseUtil implements IWriter {

    private final IWriter writer;

    public LowerCaseUtil(IWriter iWriter) {
        writer = iWriter;
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
    
    public String convert(String data) {
        if(data==null){
            return "";
        }
        return data.toLowerCase();
    }
}
