package com.github.hatimiti.gamiedx.type;

import java.util.ArrayList;
import java.util.List;

public abstract class ArrayListType<O> extends ListType<O> {

	@Override
	protected List<O> createNewList() {
		return new ArrayList<>();
	}

	@Override
	protected List<O> createList(List<O> orig) {
		return new ArrayList<>(orig);
	}

}
