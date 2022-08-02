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
import javax.portlet.RenderResponse;
import javax.portlet.RenderURL;

/**
 * @author Neil Griffin
 */
public interface ManagementToolbarViewStateFactory {

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
		RenderURL sortingURLReverse);

	public ManagementToolbarViewState create(
		String addEntryMessage, String defaultDisplayStyle,
		String defaultNavigation, String defaultOrderByCol,
		String defaultOrderByType, RenderRequest renderRequest,
		RenderResponse renderResponse, boolean showAdvancedSearch,
		boolean showCreationMenu, boolean showDisplayStyleCard,
		boolean showDisplayStyleList, boolean showDisplayStyleTable,
		boolean showInfoButton, boolean showSearch, boolean showSort);

	public ManagementToolbarViewState create(
		String addEntryMessage, String defaultDisplayStyle,
		String defaultNavigation, String defaultOrderByCol,
		String defaultOrderByType, RenderRequest renderRequest,
		RenderResponse renderResponse, String searchFormMethod,
		String searchFormName, String searchInputName, String searchValue,
		boolean showAdvancedSearch, boolean showCreationMenu,
		boolean showDisplayStyleCard, boolean showDisplayStyleList,
		boolean showDisplayStyleTable, boolean showInfoButton,
		boolean showSearch, boolean showSort);

}