package com.digital14.testcase;

import com.digital14.impl.StringWriter;
import com.digital14.utils.StupidRemoverUtil;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class StupidRemoverTest {

    static StupidRemoverUtil stupidRemoverUtil;

    @Before
    public void setup() {
        stupidRemoverUtil = new StupidRemoverUtil();
    }

    @Test
    public void testStupidRemover() throws IOException {
        String data = "We live in the era of smart phones and stupid people";
        String dataAfterConversion = "We live in the era of smart phones and s***** people";
        String convertedString = stupidRemoverUtil.convert(data);
        assertTrue(convertedString.equals(dataAfterConversion));
    }

    @Test
    public void testStupidRemoverClose() throws IOException {
        StupidRemoverUtil stupidRemoverUtil1 = new StupidRemoverUtil(new StringWriter());
        stupidRemoverUtil1.writeToWriter("It was a stupid");
		stupidRemoverUtil1.close();
		stupidRemoverUtil1.writeToWriter("bug");
        assertEquals("It was a s*****", stupidRemoverUtil1.toString());
    }
}
