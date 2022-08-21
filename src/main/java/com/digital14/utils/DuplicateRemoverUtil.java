package com.digital14.utils;

import com.digital14.generic.IWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class DuplicateRemoverUtil implements IWriter {    

    private final IWriter writer;

    public DuplicateRemoverUtil(IWriter iWriter) {
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
        StringBuilder resultStr = new StringBuilder();
        String currentWord = "";
        StringTokenizer words = new StringTokenizer(data);
        while (words.hasMoreElements()) {
            String nextWord = words.nextToken();
            if (!currentWord.equals(nextWord)) {
                resultStr.append(nextWord).append(" ");
                currentWord = nextWord;
            }
        }
        return resultStr.toString().trim();
    }
}
