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

public class GFASigFieldSeedValue extends GFAObject implements ASigFieldSeedValue {

	public GFASigFieldSeedValue(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ASigFieldSeedValue");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Cert":
				return getCert();
			case "DigestMethod":
				return getDigestMethod();
			case "LegalAttestation":
				return getLegalAttestation();
			case "MDP":
				return getMDP();
			case "Reasons":
				return getReasons();
			case "SubFilter":
				return getSubFilter();
			case "TimeStamp":
				return getTimeStamp();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<ACertSeedValue> getCert() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getCert1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<ACertSeedValue> getCert1_5() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Cert"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ACertSeedValue> list = new ArrayList<>(1);
			list.add(new GFACertSeedValue((COSDictionary)object.getDirectBase(), this.baseObject, "Cert"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfDigestMethod> getDigestMethod() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getDigestMethod1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfDigestMethod> getDigestMethod1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DigestMethod"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfDigestMethod> list = new ArrayList<>(1);
			list.add(new GFAArrayOfDigestMethod((COSArray)object.getDirectBase(), this.baseObject, "DigestMethod"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfStringsText> getLegalAttestation() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getLegalAttestation1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfStringsText> getLegalAttestation1_6() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("LegalAttestation"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfStringsText> list = new ArrayList<>(1);
			list.add(new GFAArrayOfStringsText((COSArray)object.getDirectBase(), this.baseObject, "LegalAttestation"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AMDPDict> getMDP() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getMDP1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<AMDPDict> getMDP1_6() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("MDP"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AMDPDict> list = new ArrayList<>(1);
			list.add(new GFAMDPDict((COSDictionary)object.getDirectBase(), this.baseObject, "MDP"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfStringsText> getReasons() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getReasons1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfStringsText> getReasons1_5() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Reasons"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfStringsText> list = new ArrayList<>(1);
			list.add(new GFAArrayOfStringsText((COSArray)object.getDirectBase(), this.baseObject, "Reasons"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfSignatureSubFilterNames> getSubFilter() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getSubFilter1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfSignatureSubFilterNames> getSubFilter1_5() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SubFilter"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfSignatureSubFilterNames> list = new ArrayList<>(1);
			list.add(new GFAArrayOfSignatureSubFilterNames((COSArray)object.getDirectBase(), this.baseObject, "SubFilter"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ATimeStampDict> getTimeStamp() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getTimeStamp1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<ATimeStampDict> getTimeStamp1_6() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TimeStamp"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ATimeStampDict> list = new ArrayList<>(1);
			list.add(new GFATimeStampDict((COSDictionary)object.getDirectBase(), this.baseObject, "TimeStamp"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsAddRevInfo() {
		return this.baseObject.knownKey(ASAtom.getASAtom("AddRevInfo"));
	}

	public COSObject getAddRevInfoValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AddRevInfo"));
		return object;
	}

	@Override
	public Boolean getAddRevInfoHasTypeBoolean() {
		COSObject object = getAddRevInfoValue();
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getcontainsAppearanceFilter() {
		return this.baseObject.knownKey(ASAtom.getASAtom("AppearanceFilter"));
	}

	public COSObject getAppearanceFilterValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AppearanceFilter"));
		return object;
	}

	@Override
	public Boolean getAppearanceFilterHasTypeStringText() {
		COSObject object = getAppearanceFilterValue();
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsCert() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Cert"));
	}

	public COSObject getCertValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Cert"));
		return object;
	}

	@Override
	public Boolean getCertHasTypeDictionary() {
		COSObject object = getCertValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsDigestMethod() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DigestMethod"));
	}

	public COSObject getDigestMethodValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DigestMethod"));
		return object;
	}

	@Override
	public Boolean getDigestMethodHasTypeArray() {
		COSObject object = getDigestMethodValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsFf() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Ff"));
	}

	public COSObject getFfDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSInteger.construct(0L);
		}
		return null;
	}

	public COSObject getFfValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Ff"));
		if (object == null || object.empty()) {
			object = getFfDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getFfHasTypeBitmask() {
		COSObject object = getFfValue();
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getFfBitmaskValue() {
		COSObject object = getFfValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	@Override
	public Boolean getcontainsFilter() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Filter"));
	}

	public COSObject getFilterValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Filter"));
		return object;
	}

	@Override
	public Boolean getFilterHasTypeName() {
		COSObject object = getFilterValue();
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public Boolean getcontainsLegalAttestation() {
		return this.baseObject.knownKey(ASAtom.getASAtom("LegalAttestation"));
	}

	public COSObject getLegalAttestationValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("LegalAttestation"));
		return object;
	}

	@Override
	public Boolean getLegalAttestationHasTypeArray() {
		COSObject object = getLegalAttestationValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsLockDocument() {
		return this.baseObject.knownKey(ASAtom.getASAtom("LockDocument"));
	}

	public COSObject getLockDocumentValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("LockDocument"));
		return object;
	}

	@Override
	public Boolean getLockDocumentHasTypeName() {
		COSObject object = getLockDocumentValue();
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getLockDocumentNameValue() {
		COSObject object = getLockDocumentValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	@Override
	public Boolean getcontainsMDP() {
		return this.baseObject.knownKey(ASAtom.getASAtom("MDP"));
	}

	public COSObject getMDPValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("MDP"));
		return object;
	}

	@Override
	public Boolean getMDPHasTypeDictionary() {
		COSObject object = getMDPValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsReasons() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Reasons"));
	}

	public COSObject getReasonsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Reasons"));
		return object;
	}

	@Override
	public Boolean getReasonsHasTypeArray() {
		COSObject object = getReasonsValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsSubFilter() {
		return this.baseObject.knownKey(ASAtom.getASAtom("SubFilter"));
	}

	public COSObject getSubFilterValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SubFilter"));
		return object;
	}

	@Override
	public Boolean getSubFilterHasTypeArray() {
		COSObject object = getSubFilterValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsTimeStamp() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TimeStamp"));
	}

	public COSObject getTimeStampValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TimeStamp"));
		return object;
	}

	@Override
	public Boolean getTimeStampHasTypeDictionary() {
		COSObject object = getTimeStampValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
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
		return object != null && object.getType() == COSObjType.COS_NAME;
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
	public Boolean getVHasTypeInteger() {
		COSObject object = getVValue();
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getVIntegerValue() {
		COSObject object = getVValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

}
