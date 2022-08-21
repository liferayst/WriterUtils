package com.digital14.testcase;

import com.digital14.impl.StringWriter;
import com.digital14.utils.DuplicateRemoverUtil;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DuplicateRemoverTest {

    DuplicateRemoverUtil duplicateRemoverUtil;

    @Before
    public void init() {
        duplicateRemoverUtil = new DuplicateRemoverUtil(new StringWriter());
    }

    @Test
    public void testDuplicate() throws IOException {
        String data = "Today is a sunny sunny Day!";
        String dataAfterConversion = "Today is a sunny Day!";
        String convertedString = duplicateRemoverUtil.convert(data);
        assertTrue(convertedString.equals(dataAfterConversion));
    }

    @Test
    public void testClose() throws IOException {
        DuplicateRemoverUtil duplicateRemover = new DuplicateRemoverUtil(new StringWriter());
        duplicateRemover.writeToWriter("Today is a sunny Day!");
        duplicateRemover.close();
        duplicateRemover.writeToWriter("UAE");
        assertEquals("Today is a sunny Day!", duplicateRemover.toString());
    }
}
