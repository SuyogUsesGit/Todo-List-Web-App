package com.suyoggaikwad.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.suyoggaikwad.dao.TodoItemDao;
import com.suyoggaikwad.domain.TodoItem;

@Controller
public class WebAppController {
	
	@Autowired
	TodoItemDao todoItemDao;
	
	
	@ModelAttribute("myList")
	public List<TodoItem> getTodoData() {
		return todoItemDao.readAll();
	}
	
	@RequestMapping("/showList")
	public String home() {
		return "items_list";
	}
	
	@RequestMapping("/viewItem")
	public String viewItem(@RequestParam int id, Model model) {
		TodoItem todoItem = todoItemDao.read(id);
        model.addAttribute("todoItem", todoItem);
        return "view_item";
	}
	
	@RequestMapping("/deleteItem")
	public String deleteItem(@RequestParam int id) {
		todoItemDao.delete(id);
		return "redirect:/showList";
	}
	
	@RequestMapping(value="/addItem", method=RequestMethod.GET)
    public String addOrEditItem(@RequestParam(required = false, defaultValue = "-1") int id, Model model) {
		TodoItem todoItem = null;
		try {
			 todoItem = todoItemDao.read(id);	
		} catch(EmptyResultDataAccessException e) {
			todoItem = new TodoItem("", "", LocalDate.now());
		}

        model.addAttribute("todoItem", todoItem);
        return "add_item";
    }
	
	 @RequestMapping(value="/addItem", method=RequestMethod.POST)
	    public String processItem(TodoItem todoItem) {

	        if(todoItem.getId() == 0) {
	            todoItemDao.insert(todoItem);
	        } else {
	            todoItemDao.update(todoItem);
	        }

	        return "redirect:/showList";
	    }
	
}
