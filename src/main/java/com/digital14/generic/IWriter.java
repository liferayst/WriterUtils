package com.digital14.generic;

import java.io.IOException;

public interface IWriter {

    public void writeToWriter(String data) throws IOException;

    public void close() throws IOException;
}
