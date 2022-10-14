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
package org.verapdf.gf.model.impl.sa;

import org.verapdf.model.GenericModelObject;
import org.verapdf.model.salayer.SAObject;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Maxim Plushchov
 */
public class GFSAObject extends GenericModelObject implements SAObject {

	private final Set<Integer> errorCodes = new HashSet<>();
	private final List<List<java.lang.Object>> errorArguments = new LinkedList<>();

	public GFSAObject(String type) {
		super(type);
	}

	@Override
	public String getstructureID() {
		return null;
	}

	@Override
	public String geterrorCodes() {
		return errorCodes.stream().map(Objects::toString).collect(Collectors.joining(","));
	}

	public Set<Integer> getErrorCodes() {
		return errorCodes;
	}

	public List<List<Object>> getErrorArguments() {
		return errorArguments;
	}

	@Override
	public String geterrorArguments() {
		StringBuilder string = new StringBuilder();
		for (List<java.lang.Object> arguments : errorArguments) {
			string.append(arguments.stream().map(java.lang.Object::toString).collect(Collectors.joining(";")));
			string.append(";;");
		}
		return string.toString();
	}
}
