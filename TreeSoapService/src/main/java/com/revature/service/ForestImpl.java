package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.exception.TreeTooOldException;
import com.revature.models.Tree;

public class ForestImpl implements Forest {

	@Override
	public List<Tree> getALlTreess() {
		List<Tree> forest = new ArrayList<Tree>();

		forest.add(new Tree(1, 200, "red", 2));
		forest.add(new Tree(2, 10000, "green", 200));
		forest.add(new Tree(3, 200000000, "yellow", 1000));
		return forest;
	}

	@Override
	public String plantTree(int id, int numberOfLeaves, String color, int ageInYears) throws TreeTooOldException {
		Tree tree = new Tree(id, numberOfLeaves, color, ageInYears);
		if (tree.getAgeInYears() > 10) {
			throw new TreeTooOldException();
		}
		return "You planted a tree! " + tree.toString();
	}

}
