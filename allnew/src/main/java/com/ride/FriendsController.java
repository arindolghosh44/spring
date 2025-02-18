package com.ride;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FriendsController {

	@Autowired
	Friends fr;

	@RequestMapping("/friends")
	public List<String> getAllFreinds() {

		return fr.getAll();
	}

	@RequestMapping("/friends/count")
	public int getAllFreindsCount() {

		return fr.getAllCount();
	}

	@RequestMapping("/friends/add/{name}")
	public List<String> addAllFreinds(@PathVariable(name = "name") String name) {

		fr.addAllfrriends(name);

		return fr.getAll();
	}
	
	
	

}
