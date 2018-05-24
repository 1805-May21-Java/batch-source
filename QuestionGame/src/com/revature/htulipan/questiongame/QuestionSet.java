package com.revature.htulipan.questiongame;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class QuestionSet implements Set {

	private ArrayList<String> unusedQuestionList;
	private ArrayList<String> usedQuestionList;
	private HashSet<String> questionSet;
	
	public QuestionSet() {
		super();
		this.unusedQuestionList = new ArrayList<>();
		this.usedQuestionList = new ArrayList<>();
		this.questionSet = new HashSet<>();
		
	}
	
	public QuestionSet(File inputFile) {
		this.unusedQuestionList = new ArrayList<>();
		this.usedQuestionList = new ArrayList<>();
		this.questionSet = new HashSet<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(inputFile));
			String line = br.readLine();
			while (line != null) {
				this.unusedQuestionList.add(line);
				this.questionSet.add(line);
				line = br.readLine();
			}
			br.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	@Override
	public int size() {
		return this.questionSet.size();
	}

	@Override
	public boolean isEmpty() {
		return this.questionSet.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		if (o == null)
			return false;
		if ("".getClass() != o.getClass())
			return false;
		
		String name = (String) o;
		
		return this.questionSet.contains(name);
	}

	@Override
	public Iterator iterator() {
		Iterator<String> iter = this.unusedQuestionList.iterator();
		for (String s : this.unusedQuestionList) {
			this.usedQuestionList.add(s);
		}
		this.unusedQuestionList.clear();
		return iter;
	}

	@Override
	public Object[] toArray() {
		return this.questionSet.toArray();
	}

	@Override
	public Object[] toArray(Object[] a) {
		return this.questionSet.toArray(a);
	}

	@Override
	public boolean add(Object e) {
		if (e == null)
			return false;
		if ("".getClass() != e.getClass())
			return false;
		
		String name = (String) e;
		
		boolean success = questionSet.add(name);
		if (success) unusedQuestionList.add(name);
		return success;
	}

	@Override
	public boolean remove(Object o) {
		if (o == null)
			return false;
		if ("".getClass() != o.getClass())
			return false;
		
		String name = (String) o;
		
		boolean success = questionSet.remove(name);
		if (success) {
			if (this.unusedQuestionList.contains(name)) this.unusedQuestionList.remove(name);
			else this.usedQuestionList.remove(name);
		}
		return success;
	}

	@Override
	public boolean containsAll(Collection c) {
		return this.questionSet.containsAll(c);
	}

	@Override
	public boolean addAll(Collection c) {
		boolean success = true;
		for (Object o : c) {
			success = success && add(o);
		}
		return success;
	}

	@Override
	public boolean retainAll(Collection c) {
		return this.questionSet.retainAll(c);
	}

	@Override
	public boolean removeAll(Collection c) {
		boolean success = true;
		for (Object o : c) {
			success = success && remove(o);
		}
		return success;
	}

	@Override
	public void clear() {
		this.unusedQuestionList.clear();
		this.usedQuestionList.clear();
		this.questionSet.clear();
	}
	
	public void reset() {
		for (String s : this.usedQuestionList) {
			this.unusedQuestionList.add(s);
		}
		this.usedQuestionList.clear();
	}
	
	public String getRandom() {
		if (this.unusedQuestionList.isEmpty()) {
			reset();
		}
		
		int idx = (int) (Math.random() * this.unusedQuestionList.size());
		String result = this.unusedQuestionList.get(idx);
		this.unusedQuestionList.remove(idx);
		this.usedQuestionList.add(result);
		
		return result;
	}
	
	public boolean moreQuestions() {
		return !this.unusedQuestionList.isEmpty();
	}

}
