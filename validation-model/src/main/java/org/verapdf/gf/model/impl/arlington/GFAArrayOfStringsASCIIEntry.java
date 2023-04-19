package org.verapdf.gf.model.impl.arlington;

import org.verapdf.cos.*;
import org.verapdf.model.GenericModelObject;
import org.verapdf.model.alayer.*;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.tools.StaticResources;
import java.util.*;
import org.verapdf.pd.*;
import org.verapdf.as.ASAtom;
import java.util.stream.Collectors;
import org.verapdf.pd.structure.PDNumberTreeNode;
import org.verapdf.model.tools.constants.Operators;
import org.verapdf.operator.Operator;
import org.verapdf.as.io.ASInputStream;
import org.verapdf.parser.PDFStreamParser;
import org.verapdf.pd.structure.NameTreeIterator;
import java.io.IOException;

public class GFAArrayOfStringsASCIIEntry extends GFAObject implements AArrayOfStringsASCIIEntry {

	private String collectionName;

	public GFAArrayOfStringsASCIIEntry(COSBase baseObject, COSBase parentObject, String collectionName, String keyName) {
		super(baseObject, parentObject, keyName, "AArrayOfStringsASCIIEntry");
		this.collectionName = collectionName;
	}

	@Override
	public Boolean getHasTypeStringAscii() {
		COSObject object = new COSObject(this.baseObject);
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isASCIIString();
	}

}