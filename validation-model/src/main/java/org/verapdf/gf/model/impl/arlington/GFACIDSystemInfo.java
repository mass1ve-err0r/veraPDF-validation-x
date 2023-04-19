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

public class GFACIDSystemInfo extends GFAObject implements ACIDSystemInfo {

	public GFACIDSystemInfo(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ACIDSystemInfo");
	}

	@Override
	public Boolean getcontainsOrdering() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Ordering"));
	}

	@Override
	public Boolean getOrderingHasTypeStringAscii() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Ordering"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isASCIIString();
	}

	@Override
	public Boolean getcontainsRegistry() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Registry"));
	}

	@Override
	public Boolean getRegistryHasTypeStringAscii() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Registry"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isASCIIString();
	}

	@Override
	public Boolean getcontainsSupplement() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Supplement"));
	}

	@Override
	public Boolean getSupplementHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Supplement"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

}