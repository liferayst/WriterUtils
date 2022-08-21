package com.digital14.testcase;

import com.digital14.generic.IWriter;
import com.digital14.impl.FileWriter;
import static java.util.stream.Collectors.joining;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileWriterTest extends WriterTest{

    String filepath = "d:/testfolder1/sample.txt";

    public String readFile() throws IOException {
        return Files.lines(Paths.get(filepath)).collect(joining(""));
    }

    @Override
    protected IWriter createWriter() throws IOException {
        return new FileWriter(filepath);
    }

    @Override
    protected String getData() throws IOException {
        return Files.newBufferedReader(Paths.get(filepath)).readLine();
    }
}