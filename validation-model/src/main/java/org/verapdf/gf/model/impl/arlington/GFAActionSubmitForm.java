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

public class GFAActionSubmitForm extends GFAObject implements AActionSubmitForm {

	public GFAActionSubmitForm(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AActionSubmitForm");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "F":
				return getF();
			case "Fields":
				return getFields();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AFileSpecification> getF() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getF1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AFileSpecification> getF1_2() {
		COSObject object = getFValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AFileSpecification> list = new ArrayList<>(1);
			list.add(new GFAFileSpecification((COSDictionary)object.getDirectBase(), this.baseObject, "F"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfFieldID> getFields() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getFields1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfFieldID> getFields1_2() {
		COSObject object = getFieldsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfFieldID> list = new ArrayList<>(1);
			list.add(new GFAArrayOfFieldID((COSArray)object.getDirectBase(), this.baseObject, "Fields"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsCharSet() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CharSet"));
	}

	public COSObject getCharSetValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CharSet"));
		return object;
	}

	@Override
	public String getCharSetType() {
		COSObject CharSet = getCharSetValue();
		return getObjectType(CharSet);
	}

	@Override
	public Boolean getCharSetHasTypeString() {
		COSObject CharSet = getCharSetValue();
		return getHasTypeString(CharSet);
	}

	@Override
	public String getCharSetStringValue() {
		COSObject CharSet = getCharSetValue();
		return getStringValue(CharSet);
	}

	@Override
	public Boolean getcontainsF() {
		return this.baseObject.knownKey(ASAtom.getASAtom("F"));
	}

	public COSObject getFValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("F"));
		return object;
	}

	@Override
	public String getFType() {
		COSObject F = getFValue();
		return getObjectType(F);
	}

	@Override
	public Boolean getFHasTypeDictionary() {
		COSObject F = getFValue();
		return getHasTypeDictionary(F);
	}

	@Override
	public Boolean getFHasTypeString() {
		COSObject F = getFValue();
		return getHasTypeString(F);
	}

	@Override
	public Boolean getcontainsFields() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Fields"));
	}

	public COSObject getFieldsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Fields"));
		return object;
	}

	@Override
	public String getFieldsType() {
		COSObject Fields = getFieldsValue();
		return getObjectType(Fields);
	}

	@Override
	public Boolean getFieldsHasTypeArray() {
		COSObject Fields = getFieldsValue();
		return getHasTypeArray(Fields);
	}

	@Override
	public Boolean getcontainsFlags() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Flags"));
	}

	public COSObject getFlagsDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSInteger.construct(0L);
		}
		return null;
	}

	public COSObject getFlagsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Flags"));
		if (object == null || object.empty()) {
			object = getFlagsDefaultValue();
		}
		return object;
	}

	@Override
	public String getFlagsType() {
		COSObject Flags = getFlagsValue();
		return getObjectType(Flags);
	}

	@Override
	public Boolean getFlagsHasTypeBitmask() {
		COSObject Flags = getFlagsValue();
		return getHasTypeBitmask(Flags);
	}

	@Override
	public Long getFlagsBitmaskValue() {
		COSObject Flags = getFlagsValue();
		return getBitmaskValue(Flags);
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
	public String getSType() {
		COSObject S = getSValue();
		return getObjectType(S);
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

}
