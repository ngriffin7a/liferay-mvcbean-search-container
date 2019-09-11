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

import java.util.Objects;
import java.util.function.Supplier;

import javax.portlet.MutableRenderParameters;
import javax.portlet.RenderURL;

import org.osgi.service.component.annotations.Component;

import com.liferay.portlet.view.state.SearchContainerURLFactory;


/**
 * @author  Neil Griffin
 */
@Component(service = SearchContainerURLFactory.class)
public class SearchContainerURLFactoryImpl implements SearchContainerURLFactory {

	@Override
	public RenderURL create(Type type, Supplier<RenderURL> renderURLSupplier, int cur, int delta, String displayStyle,
		String orderByCol, String orderByType, boolean resetCur) {

		RenderURL renderURL = renderURLSupplier.get();

		MutableRenderParameters renderParameters = renderURL.getRenderParameters();

		renderParameters.setValue("cur", String.valueOf(cur));
		renderParameters.setValue("delta", String.valueOf(delta));
		renderParameters.setValue("displayStyle", displayStyle);
		renderParameters.setValue("orderByCol", orderByCol);

		if (type == Type.REVERSE_SORT) {
			renderParameters.setValue("orderByType", Objects.equals(orderByType, "asc") ? "desc" : "asc");
		}
		else {
			renderParameters.setValue("orderByType", orderByType);
		}

		renderParameters.setValue("resetCur", String.valueOf(resetCur));

		return renderURL;
	}
}
