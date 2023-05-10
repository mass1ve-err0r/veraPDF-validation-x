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

public class GFAFieldTx extends GFAObject implements AFieldTx {

	public GFAFieldTx(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AFieldTx");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "AA":
				return getAA();
			case "DV":
				return getDV();
			case "Kids":
				return getKids();
			case "Parent":
				return getParent();
			case "RV":
				return getRV();
			case "V":
				return getV();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AAddActionFormField> getAA() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getAA1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AAddActionFormField> getAA1_3() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AA"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AAddActionFormField> list = new ArrayList<>(1);
			list.add(new GFAAddActionFormField((COSDictionary)object.getDirectBase(), this.baseObject, "AA"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AStream> getDV() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getDV1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AStream> getDV1_2() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DV"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AStream> list = new ArrayList<>(1);
			list.add(new GFAStream((COSStream)object.getDirectBase(), this.baseObject, "DV"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfFields> getKids() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getKids1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfFields> getKids1_2() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Kids"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfFields> list = new ArrayList<>(1);
			list.add(new GFAArrayOfFields((COSArray)object.getDirectBase(), this.baseObject, "Kids"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.baselayer.Object> getParent() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
				return getParent1_2();
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getParent1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getParent1_2() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Parent"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getParentDictionary1_2(object.getDirectBase(), "Parent");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getParentDictionary1_2(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("FT"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return new GFAField(base, this.baseObject, keyName);
		}
		switch (subtypeValue) {
			case "Tx":
				return new GFAFieldTx(base, this.baseObject, keyName);
			case "Ch":
				return new GFAFieldChoice(base, this.baseObject, keyName);
			case "Btn":
				return getParentDictionaryBtn1_2(base, keyName);
			default:
				return null;
		}
	}

	private org.verapdf.model.baselayer.Object getParentDictionaryBtn1_2(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("Ff"));
		if (subtype == null) {
			return null;
		}
		Long subtypeValue = subtype.getInteger();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue.intValue() >> 17) {
			case 0:
				return getParentDictionary01_2(base, keyName);
			case 1:
				return new GFAFieldBtnPush(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private org.verapdf.model.baselayer.Object getParentDictionary01_2(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("Ff"));
		if (subtype == null) {
			return null;
		}
		Long subtypeValue = subtype.getInteger();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue.intValue() >> 16) {
			case 0:
				return new GFAFieldBtnCheckbox(base, this.baseObject, keyName);
			case 1:
				return new GFAFieldBtnRadio(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<org.verapdf.model.baselayer.Object> getParent1_3() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Parent"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getParentDictionary1_3(object.getDirectBase(), "Parent");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getParentDictionary1_3(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("FT"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return new GFAField(base, this.baseObject, keyName);
		}
		switch (subtypeValue) {
			case "Sig":
				return new GFAFieldSig(base, this.baseObject, keyName);
			case "Tx":
				return new GFAFieldTx(base, this.baseObject, keyName);
			case "Ch":
				return new GFAFieldChoice(base, this.baseObject, keyName);
			case "Btn":
				return getParentDictionaryBtn1_3(base, keyName);
			default:
				return null;
		}
	}

	private org.verapdf.model.baselayer.Object getParentDictionaryBtn1_3(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("Ff"));
		if (subtype == null) {
			return null;
		}
		Long subtypeValue = subtype.getInteger();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue.intValue() >> 17) {
			case 0:
				return getParentDictionary01_3(base, keyName);
			case 1:
				return new GFAFieldBtnPush(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private org.verapdf.model.baselayer.Object getParentDictionary01_3(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("Ff"));
		if (subtype == null) {
			return null;
		}
		Long subtypeValue = subtype.getInteger();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue.intValue() >> 16) {
			case 0:
				return new GFAFieldBtnCheckbox(base, this.baseObject, keyName);
			case 1:
				return new GFAFieldBtnRadio(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<AStream> getRV() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getRV1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AStream> getRV1_5() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("RV"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AStream> list = new ArrayList<>(1);
			list.add(new GFAStream((COSStream)object.getDirectBase(), this.baseObject, "RV"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AStream> getV() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getV1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AStream> getV1_2() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("V"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AStream> list = new ArrayList<>(1);
			list.add(new GFAStream((COSStream)object.getDirectBase(), this.baseObject, "V"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsAA() {
		return this.baseObject.knownKey(ASAtom.getASAtom("AA"));
	}

	@Override
	public Boolean getAAHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AA"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsDA() {
		COSObject currentObject = new COSObject(this.baseObject);
		while (currentObject != null && !currentObject.empty() && !currentObject.knownKey(ASAtom.getASAtom("DA"))) {
			currentObject = currentObject.getKey(ASAtom.getASAtom("Parent"));
		}
		if (currentObject == null || currentObject.empty()) {
			return false;
		}
		return currentObject.knownKey(ASAtom.getASAtom("DA"));
	}

	@Override
	public Boolean getDAHasTypeString() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DA"));
		COSObject currentObject = this.baseObject.getKey(ASAtom.getASAtom("Parent"));
		while ((object == null || object.empty()) && (currentObject != null && !currentObject.empty())) {
			object = currentObject.getKey(ASAtom.getASAtom("DA"));
			currentObject = currentObject.getKey(ASAtom.getASAtom("Parent"));
		}
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

	@Override
	public Boolean getcontainsDS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DS"));
	}

	@Override
	public Boolean getDSHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DS"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsDV() {
		COSObject currentObject = new COSObject(this.baseObject);
		while (currentObject != null && !currentObject.empty() && !currentObject.knownKey(ASAtom.getASAtom("DV"))) {
			currentObject = currentObject.getKey(ASAtom.getASAtom("Parent"));
		}
		if (currentObject == null || currentObject.empty()) {
			return false;
		}
		return currentObject.knownKey(ASAtom.getASAtom("DV"));
	}

	@Override
	public Boolean getisDVIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DV"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getDVHasTypeStream() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DV"));
		COSObject currentObject = this.baseObject.getKey(ASAtom.getASAtom("Parent"));
		while ((object == null || object.empty()) && (currentObject != null && !currentObject.empty())) {
			object = currentObject.getKey(ASAtom.getASAtom("DV"));
			currentObject = currentObject.getKey(ASAtom.getASAtom("Parent"));
		}
		return object != null && object.getType() == COSObjType.COS_STREAM;
	}

	@Override
	public Boolean getDVHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DV"));
		COSObject currentObject = this.baseObject.getKey(ASAtom.getASAtom("Parent"));
		while ((object == null || object.empty()) && (currentObject != null && !currentObject.empty())) {
			object = currentObject.getKey(ASAtom.getASAtom("DV"));
			currentObject = currentObject.getKey(ASAtom.getASAtom("Parent"));
		}
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsFT() {
		COSObject currentObject = new COSObject(this.baseObject);
		while (currentObject != null && !currentObject.empty() && !currentObject.knownKey(ASAtom.getASAtom("FT"))) {
			currentObject = currentObject.getKey(ASAtom.getASAtom("Parent"));
		}
		if (currentObject == null || currentObject.empty()) {
			return false;
		}
		return currentObject.knownKey(ASAtom.getASAtom("FT"));
	}

	@Override
	public Boolean getFTHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FT"));
		COSObject currentObject = this.baseObject.getKey(ASAtom.getASAtom("Parent"));
		while ((object == null || object.empty()) && (currentObject != null && !currentObject.empty())) {
			object = currentObject.getKey(ASAtom.getASAtom("FT"));
			currentObject = currentObject.getKey(ASAtom.getASAtom("Parent"));
		}
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getFTNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FT"));
		COSObject currentObject = this.baseObject.getKey(ASAtom.getASAtom("Parent"));
		while ((object == null || object.empty()) && (currentObject != null && !currentObject.empty())) {
			object = currentObject.getKey(ASAtom.getASAtom("FT"));
			currentObject = currentObject.getKey(ASAtom.getASAtom("Parent"));
		}
		if (object == null || object.empty()) {
			return getFTNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getFTNameDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsFf() {
		COSObject currentObject = new COSObject(this.baseObject);
		while (currentObject != null && !currentObject.empty() && !currentObject.knownKey(ASAtom.getASAtom("Ff"))) {
			currentObject = currentObject.getKey(ASAtom.getASAtom("Parent"));
		}
		if (currentObject == null || currentObject.empty()) {
			return false;
		}
		return currentObject.knownKey(ASAtom.getASAtom("Ff"));
	}

	@Override
	public Boolean getFfHasTypeBitmask() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Ff"));
		COSObject currentObject = this.baseObject.getKey(ASAtom.getASAtom("Parent"));
		while ((object == null || object.empty()) && (currentObject != null && !currentObject.empty())) {
			object = currentObject.getKey(ASAtom.getASAtom("Ff"));
			currentObject = currentObject.getKey(ASAtom.getASAtom("Parent"));
		}
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getFfBitmaskValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Ff"));
		COSObject currentObject = this.baseObject.getKey(ASAtom.getASAtom("Parent"));
		while ((object == null || object.empty()) && (currentObject != null && !currentObject.empty())) {
			object = currentObject.getKey(ASAtom.getASAtom("Ff"));
			currentObject = currentObject.getKey(ASAtom.getASAtom("Parent"));
		}
		if (object == null || object.empty()) {
			return getFfBitmaskDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getFfBitmaskDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsKids() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Kids"));
	}

	@Override
	public Boolean getKidsHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Kids"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsMaxLen() {
		COSObject currentObject = new COSObject(this.baseObject);
		while (currentObject != null && !currentObject.empty() && !currentObject.knownKey(ASAtom.getASAtom("MaxLen"))) {
			currentObject = currentObject.getKey(ASAtom.getASAtom("Parent"));
		}
		if (currentObject == null || currentObject.empty()) {
			return false;
		}
		return currentObject.knownKey(ASAtom.getASAtom("MaxLen"));
	}

	@Override
	public Boolean getMaxLenHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("MaxLen"));
		COSObject currentObject = this.baseObject.getKey(ASAtom.getASAtom("Parent"));
		while ((object == null || object.empty()) && (currentObject != null && !currentObject.empty())) {
			object = currentObject.getKey(ASAtom.getASAtom("MaxLen"));
			currentObject = currentObject.getKey(ASAtom.getASAtom("Parent"));
		}
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getMaxLenIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("MaxLen"));
		COSObject currentObject = this.baseObject.getKey(ASAtom.getASAtom("Parent"));
		while ((object == null || object.empty()) && (currentObject != null && !currentObject.empty())) {
			object = currentObject.getKey(ASAtom.getASAtom("MaxLen"));
			currentObject = currentObject.getKey(ASAtom.getASAtom("Parent"));
		}
		if (object == null || object.empty()) {
			return getMaxLenIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getMaxLenIntegerDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsParent() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Parent"));
	}

	@Override
	public Boolean getParentHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Parent"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsQ() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Q"));
	}

	@Override
	public Boolean getQHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Q"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getQIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Q"));
		if (object == null || object.empty()) {
			return getQIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getQIntegerDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return 0L;
		}
		return null;
	}

	@Override
	public Boolean getcontainsRV() {
		return this.baseObject.knownKey(ASAtom.getASAtom("RV"));
	}

	@Override
	public Boolean getisRVIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("RV"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getRVHasTypeStream() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("RV"));
		return object != null && object.getType() == COSObjType.COS_STREAM;
	}

	@Override
	public Boolean getRVHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("RV"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsT() {
		return this.baseObject.knownKey(ASAtom.getASAtom("T"));
	}

	@Override
	public Boolean getTHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("T"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsTM() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TM"));
	}

	@Override
	public Boolean getTMHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TM"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsTU() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TU"));
	}

	@Override
	public Boolean getTUHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TU"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsV() {
		COSObject currentObject = new COSObject(this.baseObject);
		while (currentObject != null && !currentObject.empty() && !currentObject.knownKey(ASAtom.getASAtom("V"))) {
			currentObject = currentObject.getKey(ASAtom.getASAtom("Parent"));
		}
		if (currentObject == null || currentObject.empty()) {
			return false;
		}
		return currentObject.knownKey(ASAtom.getASAtom("V"));
	}

	@Override
	public Boolean getisVIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("V"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getVHasTypeStream() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("V"));
		COSObject currentObject = this.baseObject.getKey(ASAtom.getASAtom("Parent"));
		while ((object == null || object.empty()) && (currentObject != null && !currentObject.empty())) {
			object = currentObject.getKey(ASAtom.getASAtom("V"));
			currentObject = currentObject.getKey(ASAtom.getASAtom("Parent"));
		}
		return object != null && object.getType() == COSObjType.COS_STREAM;
	}

	@Override
	public Boolean getVHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("V"));
		COSObject currentObject = this.baseObject.getKey(ASAtom.getASAtom("Parent"));
		while ((object == null || object.empty()) && (currentObject != null && !currentObject.empty())) {
			object = currentObject.getKey(ASAtom.getASAtom("V"));
			currentObject = currentObject.getKey(ASAtom.getASAtom("Parent"));
		}
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

}
