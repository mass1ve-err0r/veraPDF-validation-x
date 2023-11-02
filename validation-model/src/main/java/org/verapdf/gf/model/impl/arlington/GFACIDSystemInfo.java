package org.verapdf.gf.model.impl.arlington;

import org.verapdf.cos.*;
import org.verapdf.model.alayer.*;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.tools.StaticResources;
import java.util.*;
import org.verapdf.pd.PDNameTreeNode;
import org.verapdf.as.ASAtom;
import java.util.stream.Collectors;
import org.verapdf.pd.structure.PDNumberTreeNode;

public class GFACIDSystemInfo extends GFAObject implements ACIDSystemInfo {

	public GFACIDSystemInfo(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ACIDSystemInfo");
	}

	@Override
	public Boolean getcontainsOrdering() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Ordering"));
	}

	public COSObject getOrderingValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Ordering"));
		return object;
	}

	@Override
	public String getOrderingType() {
		COSObject Ordering = getOrderingValue();
		return getObjectType(Ordering);
	}

	@Override
	public Boolean getOrderingHasTypeStringAscii() {
		COSObject Ordering = getOrderingValue();
		return getHasTypeStringAscii(Ordering);
	}

	@Override
	public Boolean getcontainsRegistry() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Registry"));
	}

	public COSObject getRegistryValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Registry"));
		return object;
	}

	@Override
	public String getRegistryType() {
		COSObject Registry = getRegistryValue();
		return getObjectType(Registry);
	}

	@Override
	public Boolean getRegistryHasTypeStringAscii() {
		COSObject Registry = getRegistryValue();
		return getHasTypeStringAscii(Registry);
	}

	@Override
	public Boolean getcontainsSupplement() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Supplement"));
	}

	public COSObject getSupplementValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Supplement"));
		return object;
	}

	@Override
	public String getSupplementType() {
		COSObject Supplement = getSupplementValue();
		return getObjectType(Supplement);
	}

	@Override
	public Boolean getSupplementHasTypeInteger() {
		COSObject Supplement = getSupplementValue();
		return getHasTypeInteger(Supplement);
	}

}
