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

package com.liferay.view.state.internal;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.util.GetterUtil;

import javax.portlet.RenderParameters;
import javax.portlet.RenderRequest;

import com.liferay.view.state.SearchContainerViewState;
import com.liferay.view.state.SearchContainerViewStateFactory;
import org.osgi.service.component.annotations.Component;

/**
 * @author  Neil Griffin
 */
@Component(service = SearchContainerViewStateFactory.class)
public class SearchContainerViewStateFactoryImpl
	implements SearchContainerViewStateFactory {

	@Override
	public SearchContainerViewState create(
		int cur, int delta, String displayStyle, int end, String keywords,
		String navigation, String orderByCol, String orderByType,
		boolean resetCur, int start) {

		return new SearchContainerViewStateImpl(
			GetterUtil.DEFAULT_LONG, cur, delta, displayStyle, end, keywords,
			navigation, orderByCol, orderByType, resetCur, start,
			GetterUtil.DEFAULT_STRING);
	}

	@Override
	public SearchContainerViewState create(
		long categoryId, int cur, int delta, String displayStyle, int end,
		String keywords, String navigation, String orderByCol,
		String orderByType, boolean resetCur, int start, String tag) {

		return new SearchContainerViewStateImpl(
			categoryId, cur, delta, displayStyle, end, keywords, navigation,
			orderByCol, orderByType, resetCur, start, tag);
	}

	@Override
	public SearchContainerViewState create(
		String defaultDisplayStyle, String defaultNavigation,
		String defaultOrderByCol, String defaultOrderByType,
		RenderRequest renderRequest, String[] validOrderByCols) {

		RenderParameters renderParameters = renderRequest.getRenderParameters();

		int delta = GetterUtil.getInteger(
			renderParameters.getValue(SearchContainer.DEFAULT_DELTA_PARAM),
			SearchContainer.DEFAULT_DELTA);

		int currentPage = GetterUtil.getInteger(
			renderParameters.getValue(SearchContainer.DEFAULT_CUR_PARAM),
			SearchContainer.DEFAULT_CUR);

		int start = ((currentPage > 0) ? (currentPage - 1) : 0) * delta;

		int end = start + delta;

		boolean valid = false;

		String orderByCol = GetterUtil.getString(
			renderParameters.getValue("orderByCol"));

		for (String validOrderByCol : validOrderByCols) {
			if (validOrderByCol.equals(orderByCol)) {
				valid = true;

				break;
			}
		}

		if (!valid) {
			orderByCol = defaultOrderByCol;
		}

		return create(
			GetterUtil.getLong(renderParameters.getValue("categoryId")),
			GetterUtil.getInteger(
				renderParameters.getValue("cur"), SearchContainer.DEFAULT_CUR),
			GetterUtil.getInteger(
				renderParameters.getValue("delta"),
				SearchContainer.DEFAULT_DELTA),
			GetterUtil.getString(
				renderParameters.getValue("displayStyle"), defaultDisplayStyle),
			end, GetterUtil.getString(renderParameters.getValue("keywords")),
			GetterUtil.getString(
				renderParameters.getValue("navigation"), defaultNavigation),
			orderByCol,
			GetterUtil.getString(
				renderParameters.getValue("orderByType"), defaultOrderByType),
			GetterUtil.getBoolean(renderParameters.getValue("resetCur")), start,
			GetterUtil.getString(renderParameters.getValue("tag")));
	}

}