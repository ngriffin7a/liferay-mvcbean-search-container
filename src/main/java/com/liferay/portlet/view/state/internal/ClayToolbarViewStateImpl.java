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

import java.util.List;

import javax.portlet.RenderURL;

import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenu;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.ViewTypeItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.ViewTypeItemList;

import com.liferay.portlet.view.state.ClayToolbarViewState;


/**
 * @author  Neil Griffin
 */
public class ClayToolbarViewStateImpl implements ClayToolbarViewState {

	private String _addEntryMessage;
	private RenderURL _addEntryURL;
	private CreationMenu _creationMenu;
	private String _displayStyle;
	private RenderURL _displayStyleURL;
	private RenderURL _searchURL;
	private boolean _showCreationMenu;
	private String _sortingOrder;
	private RenderURL _sortingURLCurrent;
	private RenderURL _sortingURLReverse;
	private ViewTypeItemList _viewTypeItems;

	public ClayToolbarViewStateImpl(String addEntryMessage, RenderURL addEntryURL, String displayStyle,
		RenderURL displayStyleURL, RenderURL searchURL, boolean showCreationMenu, String sortingOrder,
		RenderURL sortingURLCurrent, RenderURL sortingURLReverse) {

		_addEntryMessage = addEntryMessage;
		_addEntryURL = addEntryURL;
		_displayStyle = displayStyle;
		_displayStyleURL = displayStyleURL;
		_searchURL = searchURL;
		_showCreationMenu = showCreationMenu;
		_sortingOrder = sortingOrder;
		_sortingURLCurrent = sortingURLCurrent;
		_sortingURLReverse = sortingURLReverse;
	}

	@Override
	public String getAddEntryMessage() {
		return _addEntryMessage;
	}

	@Override
	public RenderURL getAddEntryURL() {
		return _addEntryURL;
	}

	@Override
	public String getClearResultsURL() {
		return _searchURL.toString();
	}

	@Override
	public CreationMenu getCreationMenu() {

		if (_creationMenu == null) {
			_creationMenu = new CreationMenu();

			_creationMenu.addDropdownItem(dropdownItem -> {
				dropdownItem.setHref(_addEntryURL);
				dropdownItem.setLabel(_addEntryMessage);
			});
		}

		return _creationMenu;
	}

	@Override
	public String getDisplayStyle() {
		return _displayStyle;
	}

	@Override
	public RenderURL getDisplayStyleURL() {
		return _displayStyleURL;
	}

	@Override
	public String getSearchActionURL() {
		return _searchURL.toString();
	}

	@Override
	public String getSearchFormName() {
		return "search";
	}

	@Override
	public RenderURL getSearchURL() {
		return _searchURL;
	}

	@Override
	public String getSortingOrder() {
		return _sortingOrder;
	}

	@Override
	public String getSortingURL() {
		return _sortingURLReverse.toString();
	}

	@Override
	public RenderURL getSortingURLCurrent() {
		return _sortingURLCurrent;
	}

	@Override
	public RenderURL getSortingURLReverse() {
		return _sortingURLReverse;
	}

	@Override
	public List<ViewTypeItem> getViewTypeItems() {

		if (_viewTypeItems == null) {
			_viewTypeItems = new ViewTypeItemList(_displayStyleURL, _displayStyle);

			if (isShowDisplayStyleCard()) {
				_viewTypeItems.addCardViewTypeItem();
			}

			if (isShowDisplayStyleList()) {
				_viewTypeItems.addListViewTypeItem();
			}

			if (isShowDisplayStyleTable()) {
				_viewTypeItems.addTableViewTypeItem();
			}
		}

		return _viewTypeItems;
	}

	@Override
	public Boolean isShowCreationMenu() {
		return _showCreationMenu;
	}

	@Override
	public boolean isShowDisplayStyleCard() {
		return true;
	}

	@Override
	public boolean isShowDisplayStyleList() {
		return true;
	}

	@Override
	public boolean isShowDisplayStyleTable() {
		return true;
	}
}
