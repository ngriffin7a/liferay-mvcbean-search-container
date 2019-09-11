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

import javax.portlet.RenderRequest;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.util.ParamUtil;

import com.liferay.portlet.view.state.SearchContainerViewState;
import com.liferay.portlet.view.state.SearchContainerViewStateFactory;


/**
 * @author  Neil Griffin
 */
@Component(service = SearchContainerViewStateFactory.class)
public class SearchContainerViewStateFactoryImpl implements SearchContainerViewStateFactory {

	@Override
	public SearchContainerViewState create(String orderByColDefault, String orderByTypeDefault,
		RenderRequest renderRequest) {

		int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM,
				SearchContainer.DEFAULT_DELTA);
		int currentPage = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM,
				SearchContainer.DEFAULT_CUR);
		int start = ((currentPage > 0) ? (currentPage - 1) : 0) * delta;
		int end = start + delta;

		return create(ParamUtil.getInteger(renderRequest, "cur", SearchContainer.DEFAULT_CUR),
				ParamUtil.getInteger(renderRequest, "delta", SearchContainer.DEFAULT_DELTA),
				ParamUtil.getString(renderRequest, "displayStyle", "list"), end,
				ParamUtil.getString(renderRequest, "keywords"),
				ParamUtil.getString(renderRequest, "orderByCol", orderByColDefault),
				ParamUtil.getString(renderRequest, "orderByType", orderByTypeDefault),
				ParamUtil.getBoolean(renderRequest, "resetCur"), start);
	}

	@Override
	public SearchContainerViewState create(int cur, int delta, String displayStyle, int end, String keywords,
		String orderByCol, String orderByType, boolean resetCur, int start) {
		return new SearchContainerViewStateImpl(cur, delta, displayStyle, end, keywords, orderByCol, orderByType,
				resetCur, start);
	}
}
