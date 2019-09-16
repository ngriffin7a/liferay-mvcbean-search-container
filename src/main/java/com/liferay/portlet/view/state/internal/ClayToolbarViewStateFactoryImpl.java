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

import javax.portlet.RenderParameters;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.RenderURL;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.util.GetterUtil;

import com.liferay.portlet.view.state.ClayToolbarViewState;
import com.liferay.portlet.view.state.ClayToolbarViewStateFactory;
import com.liferay.portlet.view.state.SearchContainerURLFactory;


/**
 * @author  Neil Griffin
 */
@Component(service = ClayToolbarViewStateFactory.class)
public class ClayToolbarViewStateFactoryImpl implements ClayToolbarViewStateFactory {

	@Reference
	private SearchContainerURLFactory _searchContainerURLFactory;

	@Override
	public ClayToolbarViewState create(String addEntryMessage, String defaultDisplayStyle, String defaultOrderByCol,
		String defaultOrderByType, RenderRequest renderRequest, RenderResponse renderResponse, boolean showCreationMenu,
		boolean showDisplayStyleCard, boolean showDisplayStyleList, boolean showDisplayStyleTable) {
		return create(addEntryMessage, defaultDisplayStyle, defaultOrderByCol, defaultOrderByType, renderRequest,
				renderResponse, null, null, null, null, showCreationMenu, showDisplayStyleCard, showDisplayStyleList,
				showDisplayStyleTable);
	}

	@Override
	public ClayToolbarViewState create(String addEntryMessage, String defaultDisplayStyle, String defaultOrderByCol,
		String defaultOrderByType, RenderRequest renderRequest, RenderResponse renderResponse, String searchFormMethod,
		String searchFormName, String searchInputName, String searchValue, boolean showCreationMenu,
		boolean showDisplayStyleCard, boolean showDisplayStyleList, boolean showDisplayStyleTable) {

		RenderParameters renderParameters = renderRequest.getRenderParameters();

		int cur = GetterUtil.getInteger(renderParameters.getValue(SearchContainer.DEFAULT_CUR_PARAM),
				SearchContainer.DEFAULT_CUR);

		int delta = GetterUtil.getInteger(renderParameters.getValue(SearchContainer.DEFAULT_DELTA_PARAM),
				SearchContainer.DEFAULT_DELTA);

		String displayStyle = GetterUtil.getString(renderParameters.getValue("displayStyle"), defaultDisplayStyle);

		String keywords = renderParameters.getValue("keywords");

		String orderByCol = GetterUtil.getString(renderParameters.getValue("orderByCol"), defaultOrderByCol);

		String orderByType = GetterUtil.getString(renderParameters.getValue("orderByType"), defaultOrderByType);

		boolean resetCur = GetterUtil.getBoolean(renderParameters.getValue("resetCur"));

		return create(addEntryMessage,
				_searchContainerURLFactory.create(SearchContainerURLFactory.Type.ADD_ENTRY,
					renderResponse::createRenderURL, cur, delta, displayStyle, keywords, orderByCol, orderByType,
					resetCur),
				_searchContainerURLFactory.create(SearchContainerURLFactory.Type.CLEAR_RESULTS,
					renderResponse::createRenderURL, cur, delta, displayStyle, keywords, orderByCol, orderByType,
					resetCur), displayStyle,
				_searchContainerURLFactory.create(SearchContainerURLFactory.Type.DISPLAY_STYLE,
					renderResponse::createRenderURL, cur, delta, displayStyle, keywords, orderByCol, orderByType,
					resetCur), searchFormMethod, searchFormName, searchInputName,
				_searchContainerURLFactory.create(SearchContainerURLFactory.Type.SEARCH,
					renderResponse::createRenderURL, cur, delta, displayStyle, keywords, orderByCol, orderByType,
					resetCur), searchValue, showCreationMenu, showDisplayStyleCard, showDisplayStyleList,
				showDisplayStyleTable, orderByType,
				_searchContainerURLFactory.create(SearchContainerURLFactory.Type.CURRENT_SORT,
					renderResponse::createRenderURL, cur, delta, displayStyle, keywords, orderByCol, orderByType,
					resetCur),
				_searchContainerURLFactory.create(SearchContainerURLFactory.Type.REVERSE_SORT,
					renderResponse::createRenderURL, cur, delta, displayStyle, keywords, orderByCol, orderByType,
					resetCur));
	}

	@Override
	public ClayToolbarViewState create(String addEntryMessage, RenderURL addEntryURL, RenderURL clearResultsURL,
		String displayStyle, RenderURL displayStyleURL, String searchFormMethod, String searchFormName,
		String searchInputName, RenderURL searchURL, String searchValue, boolean showCreationMenu,
		boolean showDisplayStyleCard, boolean showDisplayStyleList, boolean showDisplayStyleTable, String sortingOrder,
		RenderURL sortingURLCurrent, RenderURL sortingURLReverse) {
		return new ClayToolbarViewStateImpl(addEntryMessage, addEntryURL, clearResultsURL, displayStyle,
				displayStyleURL, searchFormMethod, searchFormName, searchInputName, searchURL, searchValue,
				showCreationMenu, showDisplayStyleCard, showDisplayStyleList, showDisplayStyleTable, sortingOrder,
				sortingURLCurrent, sortingURLReverse);
	}
}
