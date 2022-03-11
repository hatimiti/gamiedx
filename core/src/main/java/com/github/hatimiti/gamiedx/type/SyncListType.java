package com.github.hatimiti.gamiedx.type;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class SyncListType<O> extends ListType<O> {

	@Override
	protected List<O> createNewList() {
		return Collections.synchronizedList(new ArrayList<>());
	}

	@Override
	protected List<O> createList(final List<O> orig) {
		return Collections.synchronizedList(new ArrayList<>(orig));
	}
}
