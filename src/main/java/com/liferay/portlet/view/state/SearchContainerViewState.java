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

/**
 * @author  Neil Griffin
 */
public interface SearchContainerViewState {

	public int getCur();

	public int getDelta();

	public String getDisplayStyle();

	public int getEnd();

	public String getKeywords();

	public String getOrderByCol();

	public String getOrderByType();

	public boolean getResetCur();

	public int getStart();

}
