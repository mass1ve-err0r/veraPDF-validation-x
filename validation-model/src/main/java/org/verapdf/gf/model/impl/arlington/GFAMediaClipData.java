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

public class GFAMediaClipData extends GFAObject implements AMediaClipData {

	public GFAMediaClipData(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AMediaClipData");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Alt":
				return getAlt();
			case "BE":
				return getBE();
			case "D":
				return getD();
			case "MH":
				return getMH();
			case "P":
				return getP();
			case "PL":
				return getPL();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOfStringsText> getAlt() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getAlt1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfStringsText> getAlt1_5() {
		COSObject object = getAltValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfStringsText> list = new ArrayList<>(1);
			list.add(new GFAArrayOfStringsText((COSArray)object.getDirectBase(), this.baseObject, "Alt"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AMediaClipDataMHBE> getBE() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getBE1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AMediaClipDataMHBE> getBE1_5() {
		COSObject object = getBEValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AMediaClipDataMHBE> list = new ArrayList<>(1);
			list.add(new GFAMediaClipDataMHBE((COSDictionary)object.getDirectBase(), this.baseObject, "BE"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.baselayer.Object> getD() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getD1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getD1_5() {
		COSObject object = getDValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AFileSpecification> list = new ArrayList<>(1);
			list.add(new GFAFileSpecification((COSDictionary)object.getDirectBase(), this.baseObject, "D"));
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AXObjectFormType1> list = new ArrayList<>(1);
			list.add(new GFAXObjectFormType1((COSStream)object.getDirectBase(), this.baseObject, "D"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AMediaClipDataMHBE> getMH() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getMH1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AMediaClipDataMHBE> getMH1_5() {
		COSObject object = getMHValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AMediaClipDataMHBE> list = new ArrayList<>(1);
			list.add(new GFAMediaClipDataMHBE((COSDictionary)object.getDirectBase(), this.baseObject, "MH"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AMediaPermissions> getP() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getP1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AMediaPermissions> getP1_5() {
		COSObject object = getPValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AMediaPermissions> list = new ArrayList<>(1);
			list.add(new GFAMediaPermissions((COSDictionary)object.getDirectBase(), this.baseObject, "P"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AMediaPlayers> getPL() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getPL1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AMediaPlayers> getPL1_5() {
		COSObject object = getPLValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AMediaPlayers> list = new ArrayList<>(1);
			list.add(new GFAMediaPlayers((COSDictionary)object.getDirectBase(), this.baseObject, "PL"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsAlt() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Alt"));
	}

	public COSObject getAltValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Alt"));
		return object;
	}

	@Override
	public Boolean getAltHasTypeArray() {
		COSObject Alt = getAltValue();
		return getHasTypeArray(Alt);
	}

	@Override
	public Boolean getcontainsBE() {
		return this.baseObject.knownKey(ASAtom.getASAtom("BE"));
	}

	public COSObject getBEValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BE"));
		return object;
	}

	@Override
	public Boolean getBEHasTypeDictionary() {
		COSObject BE = getBEValue();
		return getHasTypeDictionary(BE);
	}

	@Override
	public Boolean getcontainsCT() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CT"));
	}

	public COSObject getCTValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CT"));
		return object;
	}

	@Override
	public Boolean getCTHasTypeStringAscii() {
		COSObject CT = getCTValue();
		return getHasTypeStringAscii(CT);
	}

	@Override
	public Boolean getcontainsD() {
		return this.baseObject.knownKey(ASAtom.getASAtom("D"));
	}

	public COSObject getDValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("D"));
		return object;
	}

	@Override
	public Boolean getisDIndirect() {
		COSObject D = getDValue();
		return getisIndirect(D);
	}

	@Override
	public Boolean getDHasTypeDictionary() {
		COSObject D = getDValue();
		return getHasTypeDictionary(D);
	}

	@Override
	public Boolean getDHasTypeStream() {
		COSObject D = getDValue();
		return getHasTypeStream(D);
	}

	@Override
	public Boolean getDHasTypeString() {
		COSObject D = getDValue();
		return getHasTypeString(D);
	}

	@Override
	public Boolean getcontainsMH() {
		return this.baseObject.knownKey(ASAtom.getASAtom("MH"));
	}

	public COSObject getMHValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("MH"));
		return object;
	}

	@Override
	public Boolean getMHHasTypeDictionary() {
		COSObject MH = getMHValue();
		return getHasTypeDictionary(MH);
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
	public Boolean getNHasTypeStringText() {
		COSObject N = getNValue();
		return getHasTypeStringText(N);
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
	public Boolean getPHasTypeDictionary() {
		COSObject P = getPValue();
		return getHasTypeDictionary(P);
	}

	@Override
	public Boolean getcontainsPL() {
		return this.baseObject.knownKey(ASAtom.getASAtom("PL"));
	}

	public COSObject getPLValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PL"));
		return object;
	}

	@Override
	public Boolean getPLHasTypeDictionary() {
		COSObject PL = getPLValue();
		return getHasTypeDictionary(PL);
	}

	@Override
	public Boolean getcontainsS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("S"));
	}

	public COSObject getSValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("S"));
		return object;
	}

	@Override
	public Boolean getSHasTypeName() {
		COSObject S = getSValue();
		return getHasTypeName(S);
	}

	@Override
	public String getSNameValue() {
		COSObject S = getSValue();
		return getNameValue(S);
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

}
