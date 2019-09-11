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

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.RenderURL;


/**
 * @author  Neil Griffin
 */
public interface ClayToolbarViewStateFactory {

	public ClayToolbarViewState create(String addEntryMessage, RenderRequest renderRequest,
		RenderResponse renderResponse, boolean showCreationMenu);

	public ClayToolbarViewState create(String addEntryMessage, RenderURL addEntryURL, String displayStyle,
		RenderURL displayStyleURL, RenderURL searchURL, boolean showCreationMenu, String sortingOrder,
		RenderURL sortingURLCurrent, RenderURL sortingURLReverse);
}
