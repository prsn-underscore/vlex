package com.pearson.underscore.vlex.domain.internal;

import com.pearson.underscore.vlex.domain.internal.DictionaryResult;

import java.util.List;


public class DictionaryDefinitions {

	private int count;
	private int total;
	private List<DictionaryResult> results;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<DictionaryResult> getResults() {
		return results;
	}

	public void setResults(List<DictionaryResult> results) {
		this.results = results;
	}
}
