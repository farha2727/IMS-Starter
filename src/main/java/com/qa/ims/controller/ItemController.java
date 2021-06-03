package com.qa.ims.controller;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

public class ItemController implements CrudController<Item> {
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	private ItemDAO ItemDAO;
	private Utils utils;
	public ItemController(ItemDAO itemDAO, Utils utils) {
		super();
		this.ItemDAO = itemDAO;
		this.utils = utils;
	}
	
	@Override
	public List<Item> readAll() {
		List<Item> items = ItemDAO.readAll();
		for (Item item : items) {
			LOGGER.info(item);
		}
		return items;
	}
	@Override
	public Item create() {
		LOGGER.info("Please enter item name");
		String name = utils.getString();
		LOGGER.info("Please enter value");
		double value = utils.getDouble();
		Item item = ItemDAO.create(new Item(name, value));
		LOGGER.info("Item created");
		return item;
	}
	@Override
	public Item update() {
		LOGGER.info("Please enter the id of the item you would like to update");
		Long id = utils.getLong();
		LOGGER.info("Please enter item name");
		String name = utils.getString();
		LOGGER.info("Please enter value");
		double value = utils.getDouble();
		Item item = ItemDAO.update(new Item(id, name, value));
		LOGGER.info("Item Updated");
		return item;
	}
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the Item you would like to delete");
		Long Item_id = utils.getLong();
		int item = ItemDAO.delete(Item_id);
		LOGGER.info("Item Deleted");
		return item;
	}
}
