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

public class GFABeadFirst extends GFAObject implements ABeadFirst {

	public GFABeadFirst(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ABeadFirst");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "N":
				return getN();
			case "P":
				return getP();
			case "T":
				return getT();
			case "V":
				return getV();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<org.verapdf.model.baselayer.Object> getN() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getN1_1();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getN1_1() {
		COSObject object = getNValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getNDictionary1_1(object.getDirectBase(), "N");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getNDictionary1_1(COSBase base, String keyName) {
		switch (keyName) {
			case "0":
				return new GFABeadFirst(base, this.baseObject, keyName);
			default:
				return new GFABead(base, this.baseObject, keyName);
		}
	}

	private List<APageObject> getP() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getP1_1();
			default:
				return Collections.emptyList();
		}
	}

	private List<APageObject> getP1_1() {
		COSObject object = getPValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<APageObject> list = new ArrayList<>(1);
			list.add(new GFAPageObject((COSDictionary)object.getDirectBase(), this.baseObject, "P"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AThread> getT() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getT1_1();
			default:
				return Collections.emptyList();
		}
	}

	private List<AThread> getT1_1() {
		COSObject object = getTValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AThread> list = new ArrayList<>(1);
			list.add(new GFAThread((COSDictionary)object.getDirectBase(), this.baseObject, "T"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.baselayer.Object> getV() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getV1_1();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getV1_1() {
		COSObject object = getVValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getVDictionary1_1(object.getDirectBase(), "V");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getVDictionary1_1(COSBase base, String keyName) {
		switch (keyName) {
			case "0":
				return new GFABeadFirst(base, this.baseObject, keyName);
			default:
				return new GFABead(base, this.baseObject, keyName);
		}
	}

	@Override
	public Boolean getcontainsN() {
		return this.baseObject.knownKey(ASAtom.getASAtom("N"));
	}

	public COSObject getNValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("N"));
		return object;
	}

	@Override
	public Boolean getisNIndirect() {
		COSObject object = getNValue();
		return getisIndirect(object);
	}

	@Override
	public Boolean getNHasTypeDictionary() {
		COSObject object = getNValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getcontainsP() {
		return this.baseObject.knownKey(ASAtom.getASAtom("P"));
	}

	public COSObject getPValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("P"));
		return object;
	}

	@Override
	public Boolean getisPIndirect() {
		COSObject object = getPValue();
		return getisIndirect(object);
	}

	@Override
	public Boolean getPHasTypeDictionary() {
		COSObject object = getPValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getcontainsR() {
		return this.baseObject.knownKey(ASAtom.getASAtom("R"));
	}

	public COSObject getRValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("R"));
		return object;
	}

	@Override
	public Boolean getRHasTypeRectangle() {
		COSObject object = getRValue();
		return getHasTypeRectangle(object);
	}

	@Override
	public Boolean getcontainsT() {
		return this.baseObject.knownKey(ASAtom.getASAtom("T"));
	}

	public COSObject getTValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("T"));
		return object;
	}

	@Override
	public Boolean getisTIndirect() {
		COSObject object = getTValue();
		return getisIndirect(object);
	}

	@Override
	public Boolean getTHasTypeDictionary() {
		COSObject object = getTValue();
		return getHasTypeDictionary(object);
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
		COSObject object = getTypeValue();
		return getHasTypeName(object);
	}

	@Override
	public String getTypeNameValue() {
		COSObject object = getTypeValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	@Override
	public Boolean getcontainsV() {
		return this.baseObject.knownKey(ASAtom.getASAtom("V"));
	}

	public COSObject getVValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("V"));
		return object;
	}

	@Override
	public Boolean getisVIndirect() {
		COSObject object = getVValue();
		return getisIndirect(object);
	}

	@Override
	public Boolean getVHasTypeDictionary() {
		COSObject object = getVValue();
		return getHasTypeDictionary(object);
	}

}
