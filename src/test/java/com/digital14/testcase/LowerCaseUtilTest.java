package com.digital14.testcase;
import com.digital14.impl.StringWriter;
import com.digital14.utils.LowerCaseUtil;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import java.io.IOException;


public class LowerCaseUtilTest {
    @Test
    public void testWrite() throws IOException {
        LowerCaseUtil writer = new LowerCaseUtil(new StringWriter());
        writer.writeToWriter("Burj Khalifa");
        assertEquals("burj khalifa", writer.toString());
    }
    
    @Test
    public void testWriteMultiple() throws IOException{
        LowerCaseUtil writer = new LowerCaseUtil(new StringWriter());
        writer.writeToWriter("Burj ");
        writer.writeToWriter("Khalifa ");
        writer.writeToWriter("Dubai");
        assertEquals("burj khalifa dubai", writer.toString());
    }
    
    @Test
    public void testCloseWrite() throws IOException{
        LowerCaseUtil writer = new LowerCaseUtil(new StringWriter());
        writer.writeToWriter("Burj");
        writer.close();
        writer.writeToWriter("Khalifa");
        assertEquals("burj", writer.toString());
    }
}
