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
package com.liferay.portlet.view.state.internal;

import com.liferay.portlet.view.state.SearchContainerViewState;


/**
 * @author  Neil Griffin
 */
public class SearchContainerViewStateImpl implements SearchContainerViewState {

	private int _cur;
	private int _delta;
	private String _displayStyle;
	private int _end;
	private String _keywords;
	private String _orderByCol;
	private String _orderByType;
	private boolean _resetCur;
	private int _start;

	public SearchContainerViewStateImpl(int cur, int delta, String displayStyle, int end, String keywords,
		String orderByCol, String orderByType, boolean resetCur, int start) {

		_cur = cur;
		_delta = delta;
		_displayStyle = displayStyle;
		_end = end;
		_keywords = keywords;
		_orderByCol = orderByCol;
		_orderByType = orderByType;
		_resetCur = resetCur;
		_start = start;
	}

	@Override
	public int getCur() {
		return _cur;
	}

	@Override
	public int getDelta() {
		return _delta;
	}

	@Override
	public String getDisplayStyle() {
		return _displayStyle;
	}

	@Override
	public int getEnd() {
		return _end;
	}

	@Override
	public String getKeywords() {
		return _keywords;
	}

	@Override
	public String getOrderByCol() {
		return _orderByCol;
	}

	@Override
	public String getOrderByType() {
		return _orderByType;
	}

	@Override
	public boolean getResetCur() {
		return _resetCur;
	}

	@Override
	public int getStart() {
		return _start;
	}

}
