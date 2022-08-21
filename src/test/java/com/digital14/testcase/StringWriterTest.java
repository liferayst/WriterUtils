package com.digital14.testcase;

import java.io.IOException;

import com.digital14.generic.IWriter;
import com.digital14.impl.StringWriter;

public class StringWriterTest extends WriterTest{

    @Override
    protected IWriter createWriter() throws IOException {
        return new StringWriter();
    }

    @Override
    protected String getData() {
        return getWriter().toString();
    }
}