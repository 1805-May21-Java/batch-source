package com.revature;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.aws.GetObject;
import com.revature.aws.PutObject;

public class S3Test {

	@BeforeClass
	public static void putObject() {
		PutObject.main(null);
	}
	
	@Before
	public void getObject() {
		GetObject.main(null);
	}
	
	@Test
	public void testPutGet() throws IOException {
		File file1 = new File("C:\\Users\\nickc\\Downloads\\hades.png");
		File file2 = new File("C:\\Users\\nickc\\Desktop\\hades.png");
		assertTrue(FileUtils.contentEquals(file1, file2));
	}
}
