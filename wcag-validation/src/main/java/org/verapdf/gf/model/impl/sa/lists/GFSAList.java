/**
 * This file is part of veraPDF Validation, a module of the veraPDF project.
 * Copyright (c) 2015, veraPDF Consortium <info@verapdf.org>
 * All rights reserved.
 *
 * veraPDF Validation is free software: you can redistribute it and/or modify
 * it under the terms of either:
 *
 * The GNU General public license GPLv3+.
 * You should have received a copy of the GNU General Public License
 * along with veraPDF Validation as the LICENSE.GPL file in the root of the source
 * tree.  If not, see http://www.gnu.org/licenses/ or
 * https://www.gnu.org/licenses/gpl-3.0.en.html.
 *
 * The Mozilla Public License MPLv2+.
 * You should have received a copy of the Mozilla Public License along with
 * veraPDF Validation as the LICENSE.MPL file in the root of the source tree.
 * If a copy of the MPL was not distributed with this file, you can obtain one at
 * http://mozilla.org/MPL/2.0/.
 */
package org.verapdf.gf.model.impl.sa.lists;

import org.verapdf.model.GenericModelObject;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.salayer.SAList;
import org.verapdf.model.salayer.SAListItem;
import org.verapdf.wcag.algorithms.entities.lists.ListItem;
import org.verapdf.wcag.algorithms.entities.lists.PDFList;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Maxim Plushchov
 */
public class GFSAList extends GenericModelObject implements SAList {

	public static final String LIST_ITEMS = "items";

	public static final String LIST_TYPE = "SAList";

	private final PDFList list;

	public GFSAList(PDFList list) {
		super(LIST_TYPE);
		this.list = list;
	}

	@Override
	public List<? extends Object> getLinkedObjects(String link) {
		switch (link) {
			case LIST_ITEMS:
				return getListItems();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<SAListItem> getListItems() {
		List<SAListItem> rows = new ArrayList<>();
		for (ListItem item : list.getListItems()) {
			rows.add(new GFSAListItem(item));
		}
		return rows;
	}

	@Override
	public String getContext() {
		return list.getBoundingBox().getLocation();
	}
}
