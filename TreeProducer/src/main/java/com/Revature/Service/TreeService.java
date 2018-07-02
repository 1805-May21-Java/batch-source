package com.Revature.Service;

import java.util.List;

import com.Revature.Beans.Tree;

public interface TreeService {

	public Tree findTreeById(int id);

	public List<Tree> findAllTrees();

	public Tree createTree(Tree t);

	public Tree updateTree(Tree t);

	public Tree deleteTree(Tree t);

}
