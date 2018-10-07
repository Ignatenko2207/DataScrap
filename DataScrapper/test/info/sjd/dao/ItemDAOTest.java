package info.sjd.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import info.sjd.entity.Item;

public class ItemDAOTest {

	@Test
	public void testSaveAndGetOne() {

		Item item = new Item();
		
		item.setAsin("test_asin");
		item.setName("test_name");
		item.setPrice(1599);
		item.setItemLink("test_link");
		item.setGroup("test_group");
		
		Item itemInDB = ItemDAO.save(item);
		
		assertNotNull(itemInDB);
		assertEquals("test_asin", itemInDB.getAsin());
		
		itemInDB = ItemDAO.getOne(item.getAsin());
		
		assertNotNull(itemInDB);
		assertEquals("test_asin", itemInDB.getAsin());
	}

}
