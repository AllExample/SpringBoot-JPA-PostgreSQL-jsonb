package com.meike.station;

import com.google.common.collect.Lists;
import com.meike.station.common.modle.jsonb.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {


	@Autowired
	JSONBRepository jsonbRepository;



	@Test
	public void contextLoads() {
	}

	@Test
	public void jsonbcrud(){

		JSONBEntity je1 = new JSONBEntity();

		JSONType doc1 = new JSONBDocument(new Date(),"this is test description");

		JSONBAttachment doc2 = new JSONBAttachment();
		doc2.setName("doc2");

		List doc2values = Lists.newArrayList();
		doc2values.add("string");
		doc2values.add(new SimpleDateFormat().format(new Date()));
		doc2values.add(String.valueOf(15));
		doc2values.add(String.valueOf(15l));
		doc2.setValues(doc2values);

		List list = Lists.newArrayList();
		list.add(doc1);
		list.add(doc2);
		je1.setDocuments(list);
		jsonbRepository.save(je1);

		List<JSONBEntity> jsonbEntityList = jsonbRepository.findAll();
		System.out.println("------------------"+jsonbEntityList.size());
		assertEquals(1,jsonbEntityList.size());
	}

}
