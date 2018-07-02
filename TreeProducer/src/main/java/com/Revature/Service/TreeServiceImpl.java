package com.Revature.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Revature.Beans.Tree;
import com.Revature.Repository.TreeRepository;

@Service
@Transactional
public class TreeServiceImpl implements TreeService {

	@Autowired
	TreeRepository treeRepo;

	@Override
	public Tree findTreeById(int id) {
		return treeRepo.getOne(id);
	}

	@Override
	public List<Tree> findAllTrees() {
		// TODO Auto-generated method stub
		return treeRepo.findAll();
	}

	@Override
	public Tree createTree(Tree t) {
		// TODO Auto-generated method stub
		return treeRepo.save(t);
	}

	@Override
	public Tree updateTree(Tree t) {
		// TODO Auto-generated method stub
		return treeRepo.save(t);
	}

	@Override
	public Tree deleteTree(Tree t) {
		treeRepo.delete(t);
		return t;
	}

}
