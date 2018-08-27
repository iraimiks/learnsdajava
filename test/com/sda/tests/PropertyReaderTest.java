package com.sda.tests;

import org.junit.Test;

import com.sda.utils.PropertyReader;

public class PropertyReaderTest {

	@Test
	public void testReadPropertyFile(){
		PropertyReader.loadPropertyValues();
		System.out.println("Hero base name is: "+System.getProperty("config.superHeroBaseName"));
	}
}
