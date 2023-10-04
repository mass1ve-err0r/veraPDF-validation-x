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

public class GFATrailerIDArray extends GFAObject implements ATrailerIDArray {

	public GFATrailerIDArray(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ATrailerIDArray");
	}

	public COSObject getentry0Value() {
		if (this.baseObject.size() <= 0) {
			return null;
		}
		COSObject object = this.baseObject.at(0);
		return object;
	}

	@Override
	public Boolean getisentry0Indirect() {
		COSObject entry0 = getentry0Value();
		return getisIndirect(entry0);
	}

	@Override
	public Boolean getentry0HasTypeStringByte() {
		COSObject entry0 = getentry0Value();
		return getHasTypeStringByte(entry0);
	}

	public COSObject getentry1Value() {
		if (this.baseObject.size() <= 1) {
			return null;
		}
		COSObject object = this.baseObject.at(1);
		return object;
	}

	@Override
	public Boolean getisentry1Indirect() {
		COSObject entry1 = getentry1Value();
		return getisIndirect(entry1);
	}

	@Override
	public Boolean getentry1HasTypeStringByte() {
		COSObject entry1 = getentry1Value();
		return getHasTypeStringByte(entry1);
	}

	public COSObject gettrailerValue() {
		COSObject trailer = StaticResources.getDocument().getDocument().getTrailer().getObject();
		return trailer;
	}

	@Override
	public Boolean getcontainstrailerEncrypt() {
		COSObject trailer = gettrailerValue();
		return trailer.knownKey(ASAtom.getASAtom("Encrypt"));
	}

}