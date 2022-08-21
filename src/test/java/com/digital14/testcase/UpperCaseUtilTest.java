package com.digital14.testcase;

import com.digital14.impl.StringWriter;
import com.digital14.utils.UpperCaseUtil;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class UpperCaseUtilTest {

    @Test
    public void testWrite() throws IOException {
        UpperCaseUtil writer = new UpperCaseUtil(new StringWriter());
        writer.writeToWriter("Burj Khalifa");
        assertEquals("BURJ KHALIFA", writer.toString());
    }

    @Test
    public void testWriteMultiple() throws IOException {
        UpperCaseUtil writer = new UpperCaseUtil(new StringWriter());
        writer.writeToWriter("Burj ");
        writer.writeToWriter("Khalifa ");
        writer.writeToWriter("Dubai");
        assertEquals("BURJ KHALIFA DUBAI", writer.toString());
    }

    @Test
    public void testCloseWrite() throws IOException {
        UpperCaseUtil writer = new UpperCaseUtil(new StringWriter());
        writer.writeToWriter("Burj");
        writer.close();
        writer.writeToWriter("Khalifa");
        assertEquals("BURJ", writer.toString());
    }
}
