package util_Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import util.DataLoader;

class DataLoaderTest {

	@Test
	void testReadObject() {
		String s = (String) DataLoader.readObject("tests/hello.dat");
		assertEquals(s, "Hello!");
	}
}
