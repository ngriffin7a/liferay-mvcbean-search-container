/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package com.liferay.view.state;

import javax.portlet.RenderRequest;

/**
 * @author Neil Griffin
 */
public interface SearchContainerViewStateFactory {

	public SearchContainerViewState create(
		int cur, int delta, String displayStyle, int end, String keywords,
		String navigation, String orderByCol, String orderByType,
		boolean resetCur, int start);

	public SearchContainerViewState create(
		long categoryId, int cur, int delta, String displayStyle, int end,
		String keywords, String navigation, String orderByCol,
		String orderByType, boolean resetCur, int start, String tag);

	public SearchContainerViewState create(
		String defaultDisplayStyle, String defaultNavigation,
		String defaultOrderByCol, String defaultOrderByType,
		RenderRequest renderRequest, String[] validOrderByCols);

}