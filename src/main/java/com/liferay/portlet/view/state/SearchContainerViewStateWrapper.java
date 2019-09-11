/**
 * Copyright (c) 2000-2019 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
package com.liferay.portlet.view.state;

/**
 * @author  Neil Griffin
 */
public class SearchContainerViewStateWrapper implements SearchContainerViewState {

	private SearchContainerViewState _wrapped;

	public SearchContainerViewStateWrapper(SearchContainerViewState searchContainerViewState) {
		_wrapped = searchContainerViewState;
	}

	@Override
	public int getCur() {
		return _wrapped.getCur();
	}

	@Override
	public int getDelta() {
		return _wrapped.getDelta();
	}

	@Override
	public String getDisplayStyle() {
		return _wrapped.getDisplayStyle();
	}

	@Override
	public int getEnd() {
		return _wrapped.getEnd();
	}

	@Override
	public String getKeywords() {
		return _wrapped.getKeywords();
	}

	@Override
	public String getOrderByCol() {
		return _wrapped.getOrderByCol();
	}

	@Override
	public String getOrderByType() {
		return _wrapped.getOrderByType();
	}

	@Override
	public boolean getResetCur() {
		return _wrapped.getResetCur();
	}

	@Override
	public int getStart() {
		return _wrapped.getStart();
	}

	public SearchContainerViewState getWrapped() {
		return _wrapped;
	}
}
