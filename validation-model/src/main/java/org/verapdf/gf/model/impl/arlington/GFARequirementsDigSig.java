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

public class GFARequirementsDigSig extends GFAObject implements ARequirementsDigSig {

	public GFARequirementsDigSig(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ARequirementsDigSig");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "DigSig":
				return getDigSig();
			case "RH":
				return getRH();
			case "V":
				return getV();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<org.verapdf.model.baselayer.Object> getDigSig() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getDigSig2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getDigSig2_0() {
		COSObject object = getDigSigValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getDigSigDictionary2_0(object.getDirectBase(), "DigSig");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getDigSigDictionary2_0(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("Type"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue) {
			case "DocTimeStamp":
				return new GFADocTimeStamp(base, this.baseObject, keyName);
			case "Sig":
				return new GFASignature(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<org.verapdf.model.baselayer.Object> getRH() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getRH2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getRH2_0() {
		COSObject object = getRHValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfRequirementsHandlers> list = new ArrayList<>(1);
			list.add(new GFAArrayOfRequirementsHandlers((COSArray)object.getDirectBase(), this.baseObject, "RH"));
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ARequirementsHandler> list = new ArrayList<>(1);
			list.add(new GFARequirementsHandler((COSDictionary)object.getDirectBase(), this.baseObject, "RH"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AExtensions> getV() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getV2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<AExtensions> getV2_0() {
		COSObject object = getVValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AExtensions> list = new ArrayList<>(1);
			list.add(new GFAExtensions((COSDictionary)object.getDirectBase(), this.baseObject, "V"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsDigSig() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DigSig"));
	}

	public COSObject getDigSigValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DigSig"));
		return object;
	}

	@Override
	public Boolean getDigSigHasTypeDictionary() {
		COSObject DigSig = getDigSigValue();
		return getHasTypeDictionary(DigSig);
	}

	@Override
	public Boolean getcontainsPenalty() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Penalty"));
	}

	public COSObject getPenaltyDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return COSInteger.construct(100L);
		}
		return null;
	}

	public COSObject getPenaltyValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Penalty"));
		if (object == null || object.empty()) {
			object = getPenaltyDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getPenaltyHasTypeInteger() {
		COSObject Penalty = getPenaltyValue();
		return getHasTypeInteger(Penalty);
	}

	@Override
	public Long getPenaltyIntegerValue() {
		COSObject Penalty = getPenaltyValue();
		return getIntegerValue(Penalty);
	}

	@Override
	public Boolean getcontainsRH() {
		return this.baseObject.knownKey(ASAtom.getASAtom("RH"));
	}

	public COSObject getRHValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("RH"));
		return object;
	}

	@Override
	public Boolean getRHHasTypeArray() {
		COSObject RH = getRHValue();
		return getHasTypeArray(RH);
	}

	@Override
	public Boolean getRHHasTypeDictionary() {
		COSObject RH = getRHValue();
		return getHasTypeDictionary(RH);
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

	@Override
	public Boolean getcontainsV() {
		return this.baseObject.knownKey(ASAtom.getASAtom("V"));
	}

	public COSObject getVValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("V"));
		return object;
	}

	@Override
	public Boolean getVHasTypeDictionary() {
		COSObject V = getVValue();
		return getHasTypeDictionary(V);
	}

	@Override
	public Boolean getVHasTypeName() {
		COSObject V = getVValue();
		return getHasTypeName(V);
	}

}