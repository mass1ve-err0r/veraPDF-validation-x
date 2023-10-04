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

public class GFAOptContentLanguage extends GFAObject implements AOptContentLanguage {

	public GFAOptContentLanguage(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AOptContentLanguage");
	}

	@Override
	public Boolean getcontainsLang() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Lang"));
	}

	public COSObject getLangValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Lang"));
		return object;
	}

	@Override
	public Boolean getLangHasTypeString() {
		COSObject Lang = getLangValue();
		return getHasTypeString(Lang);
	}

	@Override
	public Boolean getcontainsPreferred() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Preferred"));
	}

	public COSObject getPreferredDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("OFF");
		}
		return null;
	}

	public COSObject getPreferredValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Preferred"));
		if (object == null || object.empty()) {
			object = getPreferredDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getPreferredHasTypeName() {
		COSObject Preferred = getPreferredValue();
		return getHasTypeName(Preferred);
	}

	@Override
	public String getPreferredNameValue() {
		COSObject Preferred = getPreferredValue();
		return getNameValue(Preferred);
	}

}