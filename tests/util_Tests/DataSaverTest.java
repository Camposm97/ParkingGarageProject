package util_Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import util.DataSaver;

class DataSaverTest {

	@Test
	void testWriteObject() {
		String s = "Hello!";
		assertTrue(DataSaver.writeObject(s, "tests/hello.dat"));
	}
}
