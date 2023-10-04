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

public class GFAOptContentMembership extends GFAObject implements AOptContentMembership {

	public GFAOptContentMembership(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AOptContentMembership");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "OCGs":
				return getOCGs();
			case "VE":
				return getVE();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<org.verapdf.model.baselayer.Object> getOCGs() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getOCGs1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getOCGs1_5() {
		COSObject object = getOCGsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfOCG> list = new ArrayList<>(1);
			list.add(new GFAArrayOfOCG((COSArray)object.getDirectBase(), this.baseObject, "OCGs"));
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AOptContentGroup> list = new ArrayList<>(1);
			list.add(new GFAOptContentGroup((COSDictionary)object.getDirectBase(), this.baseObject, "OCGs"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AVisibilityExpressionArray> getVE() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getVE1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<AVisibilityExpressionArray> getVE1_6() {
		COSObject object = getVEValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AVisibilityExpressionArray> list = new ArrayList<>(1);
			list.add(new GFAVisibilityExpressionArray((COSArray)object.getDirectBase(), this.baseObject, "VE"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsOCGs() {
		return this.baseObject.knownKey(ASAtom.getASAtom("OCGs"));
	}

	public COSObject getOCGsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OCGs"));
		return object;
	}

	@Override
	public Boolean getOCGsHasTypeArray() {
		COSObject OCGs = getOCGsValue();
		return getHasTypeArray(OCGs);
	}

	@Override
	public Boolean getOCGsHasTypeDictionary() {
		COSObject OCGs = getOCGsValue();
		return getHasTypeDictionary(OCGs);
	}

	@Override
	public Boolean getOCGsHasTypeNull() {
		COSObject OCGs = getOCGsValue();
		return getHasTypeNull(OCGs);
	}

	@Override
	public Boolean getcontainsP() {
		return this.baseObject.knownKey(ASAtom.getASAtom("P"));
	}

	public COSObject getPDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("AnyOn");
		}
		return null;
	}

	public COSObject getPValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("P"));
		if (object == null || object.empty()) {
			object = getPDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getPHasTypeName() {
		COSObject P = getPValue();
		return getHasTypeName(P);
	}

	@Override
	public String getPNameValue() {
		COSObject P = getPValue();
		return getNameValue(P);
	}

	@Override
	public Boolean getcontainsType() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Type"));
	}

	public COSObject getTypeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Type"));
		return object;
	}

	@Override
	public Boolean getTypeHasTypeName() {
		COSObject Type = getTypeValue();
		return getHasTypeName(Type);
	}

	@Override
	public String getTypeNameValue() {
		COSObject Type = getTypeValue();
		return getNameValue(Type);
	}

	@Override
	public Boolean getcontainsVE() {
		return this.baseObject.knownKey(ASAtom.getASAtom("VE"));
	}

	public COSObject getVEValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("VE"));
		return object;
	}

	@Override
	public Boolean getVEHasTypeArray() {
		COSObject VE = getVEValue();
		return getHasTypeArray(VE);
	}

}