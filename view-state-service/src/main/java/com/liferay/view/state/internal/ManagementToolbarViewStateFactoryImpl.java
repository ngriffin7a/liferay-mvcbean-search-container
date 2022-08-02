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

import javax.portlet.RenderParameters;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.RenderURL;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.view.state.ManagementToolbarViewState;
import com.liferay.view.state.ManagementToolbarViewStateFactory;
import com.liferay.view.state.SearchContainerURLFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author  Neil Griffin
 */
@Component(service = ManagementToolbarViewStateFactory.class)
public class ManagementToolbarViewStateFactoryImpl
	implements ManagementToolbarViewStateFactory {

	@Override
	public ManagementToolbarViewState create(
		String addEntryMessage, RenderURL addEntryURL,
		RenderURL clearResultsURL, String displayStyle,
		RenderURL displayStyleURL, String searchFormMethod,
		String searchFormName, String searchInputName, RenderURL searchURL,
		String searchValue, boolean showAdvancedSearch,
		boolean showCreationMenu, boolean showDisplayStyleCard,
		boolean showDisplayStyleList, boolean showDisplayStyleTable,
		boolean showInfoButton, boolean showSearch, boolean showSort,
		String sortingOrder, RenderURL sortingURLCurrent,
		RenderURL sortingURLReverse) {

		return new ManagementToolbarViewStateImpl(
			addEntryMessage, addEntryURL, clearResultsURL, displayStyle,
			displayStyleURL, searchFormMethod, searchFormName, searchInputName,
			searchURL, searchValue, showAdvancedSearch, showCreationMenu,
			showDisplayStyleCard, showDisplayStyleList, showDisplayStyleTable,
			showInfoButton, showSearch, showSort, sortingOrder,
			sortingURLCurrent, sortingURLReverse);
	}

	@Override
	public ManagementToolbarViewState create(
		String addEntryMessage, String defaultDisplayStyle,
		String defaultNavigation, String defaultOrderByCol,
		String defaultOrderByType, RenderRequest renderRequest,
		RenderResponse renderResponse, boolean showAdvancedSearch,
		boolean showCreationMenu, boolean showDisplayStyleCard,
		boolean showDisplayStyleList, boolean showDisplayStyleTable,
		boolean showInfoButton, boolean showSearch, boolean showSort) {

		return create(
			addEntryMessage, defaultDisplayStyle, defaultNavigation,
			defaultOrderByCol, defaultOrderByType, renderRequest,
			renderResponse, null, null, null, null, showAdvancedSearch,
			showCreationMenu, showDisplayStyleCard, showDisplayStyleList,
			showDisplayStyleTable, showInfoButton, showSearch, showSort);
	}

	@Override
	public ManagementToolbarViewState create(
		String addEntryMessage, String defaultDisplayStyle,
		String defaultNavigation, String defaultOrderByCol,
		String defaultOrderByType, RenderRequest renderRequest,
		RenderResponse renderResponse, String searchFormMethod,
		String searchFormName, String searchInputName, String searchValue,
		boolean showAdvancedSearch, boolean showCreationMenu,
		boolean showDisplayStyleCard, boolean showDisplayStyleList,
		boolean showDisplayStyleTable, boolean showInfoButton,
		boolean showSearch, boolean showSort) {

		RenderParameters renderParameters = renderRequest.getRenderParameters();

		long categoryId = GetterUtil.getLong(
			renderParameters.getValue("categoryId"));

		int cur = GetterUtil.getInteger(
			renderParameters.getValue(SearchContainer.DEFAULT_CUR_PARAM),
			SearchContainer.DEFAULT_CUR);

		int delta = GetterUtil.getInteger(
			renderParameters.getValue(SearchContainer.DEFAULT_DELTA_PARAM),
			SearchContainer.DEFAULT_DELTA);

		String displayStyle = GetterUtil.getString(
			renderParameters.getValue("displayStyle"), defaultDisplayStyle);

		String keywords = renderParameters.getValue("keywords");

		String navigation = GetterUtil.getString(
			renderParameters.getValue("navigation"), defaultNavigation);

		String orderByCol = GetterUtil.getString(
			renderParameters.getValue("orderByCol"), defaultOrderByCol);

		String orderByType = GetterUtil.getString(
			renderParameters.getValue("orderByType"), defaultOrderByType);

		boolean resetCur = GetterUtil.getBoolean(
			renderParameters.getValue("resetCur"));

		String tag = GetterUtil.getString(renderParameters.getValue("tag"));

		return create(
			addEntryMessage,
			_searchContainerURLFactory.create(
				categoryId, cur, delta, displayStyle, keywords, navigation,
				orderByCol, orderByType, renderResponse::createRenderURL,
				resetCur, tag, SearchContainerURLFactory.Type.ADD_ENTRY),
			_searchContainerURLFactory.create(
				categoryId, cur, delta, displayStyle, keywords, navigation,
				orderByCol, orderByType, renderResponse::createRenderURL,
				resetCur, tag, SearchContainerURLFactory.Type.CLEAR_RESULTS),
			displayStyle,
			_searchContainerURLFactory.create(
				categoryId, cur, delta, displayStyle, keywords, navigation,
				orderByCol, orderByType, renderResponse::createRenderURL,
				resetCur, tag, SearchContainerURLFactory.Type.DISPLAY_STYLE),
			searchFormMethod, searchFormName, searchInputName,
			_searchContainerURLFactory.create(
				categoryId, cur, delta, displayStyle, keywords, navigation,
				orderByCol, orderByType, renderResponse::createRenderURL,
				resetCur, tag, SearchContainerURLFactory.Type.SEARCH),
			searchValue, showAdvancedSearch, showCreationMenu,
			showDisplayStyleCard, showDisplayStyleList, showDisplayStyleTable,
			showInfoButton, showSearch, showSort, orderByType,
			_searchContainerURLFactory.create(
				categoryId, cur, delta, displayStyle, keywords, navigation,
				orderByCol, orderByType, renderResponse::createRenderURL,
				resetCur, tag, SearchContainerURLFactory.Type.CURRENT_SORT),
			_searchContainerURLFactory.create(
				categoryId, cur, delta, displayStyle, keywords, navigation,
				orderByCol, orderByType, renderResponse::createRenderURL,
				resetCur, tag, SearchContainerURLFactory.Type.REVERSE_SORT));
	}

	@Reference
	private SearchContainerURLFactory _searchContainerURLFactory;

}