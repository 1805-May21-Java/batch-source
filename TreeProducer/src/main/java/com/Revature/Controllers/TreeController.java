package com.Revature.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Revature.Beans.Tree;
import com.Revature.Service.TreeService;

@RestController
@RequestMapping("/trees")
public class TreeController {

	@Autowired
	TreeService treeService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Tree> getAllTrees() {
		return treeService.findAllTrees();
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Tree getTreeById(@PathVariable("id") int id) {
		return treeService.findTreeById(id);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Tree createTree(@RequestBody Tree tree) {
		return treeService.createTree(tree);
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Tree updateTree(@RequestBody Tree tree) {
		return treeService.updateTree(tree);
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Tree deleteTree(@PathVariable("id") int id) {
		Tree tree = treeService.findTreeById(id);
		if (tree != null) {
			treeService.deleteTree(tree);
		}
		return tree;
	}

}
