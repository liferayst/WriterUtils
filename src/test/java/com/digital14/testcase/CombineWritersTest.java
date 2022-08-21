package com.digital14.testcase;

import com.digital14.generic.IWriter;
import com.digital14.impl.FileWriter;
import com.digital14.impl.StringWriter;
import com.digital14.utils.DuplicateRemoverUtil;
import com.digital14.utils.LowerCaseUtil;
import com.digital14.utils.StupidRemoverUtil;
import com.digital14.utils.UpperCaseUtil;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class CombineWritersTest {

	@Test
	public void testLowerCaseDuplicateAndStupidRemover() throws IOException {
		StupidRemoverUtil stupidRemoverUtil = new StupidRemoverUtil(new StringWriter());
		DuplicateRemoverUtil duplicateRemoverUtil = new DuplicateRemoverUtil(stupidRemoverUtil);
		IWriter combinedWriter = new LowerCaseUtil(duplicateRemoverUtil);
		combinedWriter.writeToWriter("DO NOT LIVE A STUPID STUPID LIFE");
		assertEquals("do not live a s***** life", combinedWriter.toString());
	}

	@Test
	public void testDuplicateAndStupidRemoverUpperCase() throws IOException {
		StringWriter stringWriter = new StringWriter();
		UpperCaseUtil upperCaseUtil = new UpperCaseUtil(stringWriter);
		StupidRemoverUtil stupidRemoverUtil = new StupidRemoverUtil(upperCaseUtil);
		IWriter combinedWriter = new DuplicateRemoverUtil(stupidRemoverUtil);
		combinedWriter.writeToWriter("goodbye stupid stupid people");
		assertEquals("GOODBYE S***** PEOPLE", combinedWriter.toString());
	}

			
	@Test
	public void testDuplicateAndStupidRemover() throws IOException {
		StringWriter stringWriter = new StringWriter();
		StupidRemoverUtil stupidRemoverUtil = new StupidRemoverUtil(stringWriter);
		DuplicateRemoverUtil combinedWriter = new DuplicateRemoverUtil(stupidRemoverUtil);
		combinedWriter.writeToWriter("goodbye stupid people people");
		assertEquals("goodbye s***** people", combinedWriter.toString());
	}

	@Test
	public void testFileWriterStupidRemoverLowerCase() throws IOException {
		FileWriter fileWriter = new FileWriter("d:/testfolder1/sample.txt");//Please create a file
		LowerCaseUtil lowerCaseUtil = new LowerCaseUtil(fileWriter);
		StupidRemoverUtil stupidRemover = new StupidRemoverUtil(lowerCaseUtil);
		IWriter combinedWriter = new DuplicateRemoverUtil(stupidRemover);
		combinedWriter.writeToWriter("goodbye stupid stupid people");
		assertEquals("goodbye s***** people", new FileWriterTest().readFile());
	}

}
