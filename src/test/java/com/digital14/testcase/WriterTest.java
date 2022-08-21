package com.digital14.testcase;

import com.digital14.generic.IWriter;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public abstract class WriterTest {

	private IWriter iWriter;

	@Before
	public void init() throws IOException {
		iWriter = createWriter();
	}

	public IWriter getWriter() {
		return iWriter;
	}

	@Test
	public void testWrite() throws IOException {
		iWriter.writeToWriter("Dubai");
		assertEquals("Dubai", getData());
	}

	@Test
	public void testWriteMultiple() throws IOException {
		iWriter.writeToWriter("Hello");
		iWriter.writeToWriter("Dubai");
		iWriter.writeToWriter("People");
		assertEquals("HelloDubaiPeople", getData());
	}

	@Test
	public void testClose() throws IOException {
		iWriter.writeToWriter("Hello");
		iWriter.writeToWriter("Dubai");
		iWriter.close();
		iWriter.writeToWriter("People");
		assertEquals("HelloDubai", getData());
	}

	protected abstract IWriter createWriter() throws IOException;

	protected abstract String getData() throws IOException;
}
