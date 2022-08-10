package com.test;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertFalse;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Ignore;
import org.junit.experimental.categories.Category;
import org.testng.SkipException;

public class firstTest {

	
	@Test
	public void testmethod1() throws JSONException, IOException {

		String payload = getPayload("gitLabjob.json");
		JSONObject json = new JSONObject(payload);
		System.out.println(json.get("build_id"));

		System.out.println("after update");
		json.put("build_id", 101);
		System.out.println(json.get("build_id"));
		assertTrue(true);
	}

	@Test
	public void testmethod2() {
		assertTrue(true);
	}

	public static String getPayload(final String fileNm) throws IOException, JSONException {

		final File file = new File("src/test/resources/" + fileNm);

		final Path path = file.toPath();
		System.out.println("-------------path for json file :" + file.getAbsolutePath());

		final StringBuilder sb = new StringBuilder();
		final List<String> content = Files.readAllLines(path, Charset.defaultCharset());

		for (final String string : content) {

			sb.append(string);
		}

		final String jsonstring = sb.toString();

		return jsonstring;
	}

	@Test
	public void emptytest() {

	}

	@Test
	public void failedtest() {
		assertFalse(true, "balu-test is failed");
	}

	@Ignore
	@Test()
	public void disabledtest() {
		System.out.println("disabled test");
	}

	@Test
	public void testskipped() {
		throw new SkipException("skipped");
	}
}
