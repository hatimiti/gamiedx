package com.github.hatimiti.gamiedx.type;

import java.util.Collections;
import java.util.List;

public abstract class SyncListType<O> extends ArrayListType<O> {

	@Override
	protected List<O> createNewList() {
		return Collections.synchronizedList(super.createNewList());
	}

	@Override
	protected List<O> createList(final List<O> orig) {
		return Collections.synchronizedList(super.createList(orig));
	}

}
