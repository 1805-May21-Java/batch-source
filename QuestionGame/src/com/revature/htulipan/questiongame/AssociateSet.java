package com.revature.htulipan.questiongame;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class AssociateSet implements Set {
	private HashSet<String> associatePool;
	
	public AssociateSet() {
		super();
		this.associatePool = new HashSet<>();
	}
	
	public AssociateSet(File inputFile) {
		this.associatePool = new HashSet<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(inputFile));
			String line = br.readLine();
			while (line != null) {
				this.associatePool.add(line);
				line = br.readLine();
			}
			br.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	@Override
	public int size() {
		return associatePool.size();
	}

	@Override
	public boolean isEmpty() {
		return associatePool.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		if (o == null)
			return false;
		if ("".getClass() != o.getClass())
			return false;
		
		String name = (String) o;
		
		return this.associatePool.contains(name);
	}

	@Override
	public Iterator iterator() {
		return this.associatePool.iterator();
	}

	@Override
	public Object[] toArray() {
		return this.associatePool.toArray();
	}

	@Override
	public Object[] toArray(Object[] a) {
		return this.associatePool.toArray(a);
	}

	@Override
	public boolean add(Object e) {
		if (e == null)
			return false;
		if ("".getClass() != e.getClass())
			return false;
		
		String name = (String) e;
		
		return this.associatePool.add(name);
	}

	@Override
	public boolean remove(Object o) {
		if (o == null)
			return false;
		if ("".getClass() != o.getClass())
			return false;
		
		String name = (String) o;
		
		return this.associatePool.remove(name);
	}

	@Override
	public boolean containsAll(Collection c) {
		return this.associatePool.containsAll(c);
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
		return this.associatePool.retainAll(c);
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
		this.associatePool.clear();
	}
	
	public String getRandom() {
		Iterator<String> iter = this.associatePool.iterator();
		int rand = (int) (Math.random() * this.associatePool.size());
		String name = iter.next();
		for(int i = 0; i < rand; i++) {
			name = iter.next();
		}
		return name;
	}
	
}
