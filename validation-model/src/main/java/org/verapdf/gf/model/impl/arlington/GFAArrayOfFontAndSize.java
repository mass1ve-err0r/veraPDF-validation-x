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

public class GFAArrayOfFontAndSize extends GFAObject implements AArrayOfFontAndSize {

	public GFAArrayOfFontAndSize(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AArrayOfFontAndSize");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "entry0":
				return getentry0();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<org.verapdf.model.baselayer.Object> getentry0() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getentry01_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getentry01_3() {
		COSObject object = getentry0Value();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getentry0Dictionary1_3(object.getDirectBase(), "0");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getentry0Dictionary1_3(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("Subtype"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue) {
			case "CIDFontType0":
				return new GFAFontCIDType0(base, this.baseObject, keyName);
			case "CIDFontType2":
				return new GFAFontCIDType2(base, this.baseObject, keyName);
			case "MMType1":
				return new GFAFontMultipleMaster(base, this.baseObject, keyName);
			case "TrueType":
				return new GFAFontTrueType(base, this.baseObject, keyName);
			case "Type0":
				return new GFAFontType0(base, this.baseObject, keyName);
			case "Type1":
				return new GFAFontType1(base, this.baseObject, keyName);
			case "Type3":
				return new GFAFontType3(base, this.baseObject, keyName);
			default:
				return null;
		}
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
	public Boolean getentry0HasTypeDictionary() {
		COSObject entry0 = getentry0Value();
		return getHasTypeDictionary(entry0);
	}

	public COSObject getentry1Value() {
		if (this.baseObject.size() <= 1) {
			return null;
		}
		COSObject object = this.baseObject.at(1);
		return object;
	}

	@Override
	public Boolean getentry1HasTypeNumber() {
		COSObject entry1 = getentry1Value();
		return getHasTypeNumber(entry1);
	}

}