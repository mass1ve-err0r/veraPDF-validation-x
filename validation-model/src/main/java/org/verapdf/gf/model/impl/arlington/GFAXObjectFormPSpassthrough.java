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

public class GFAXObjectFormPSpassthrough extends GFAObject implements AXObjectFormPSpassthrough {

	public GFAXObjectFormPSpassthrough(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AXObjectFormPSpassthrough");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "DecodeParms":
				return getDecodeParms();
			case "F":
				return getF();
			case "FDecodeParms":
				return getFDecodeParms();
			case "FFilter":
				return getFFilter();
			case "Filter":
				return getFilter();
			case "Level1":
				return getLevel1();
			case "PS":
				return getPS();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<org.verapdf.model.baselayer.Object> getDecodeParms() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_1:
				return getDecodeParms1_1();
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
				return getDecodeParms1_2();
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getDecodeParms1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getDecodeParms1_1() {
		COSObject object = getDecodeParmsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfDecodeParams> list = new ArrayList<>(1);
			list.add(new GFAArrayOfDecodeParams((COSArray)object.getDirectBase(), this.baseObject, "DecodeParms"));
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AFilterLZWDecode> list = new ArrayList<>(1);
			list.add(new GFAFilterLZWDecode((COSDictionary)object.getDirectBase(), this.baseObject, "DecodeParms"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.baselayer.Object> getDecodeParms1_2() {
		COSObject object = getDecodeParmsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfDecodeParams> list = new ArrayList<>(1);
			list.add(new GFAArrayOfDecodeParams((COSArray)object.getDirectBase(), this.baseObject, "DecodeParms"));
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getDecodeParmsDictionary1_2(object.getDirectBase(), "DecodeParms");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getDecodeParmsDictionary1_2(COSBase base, String keyName) {
		COSObject subtype = this.baseObject.getKey(ASAtom.getASAtom("Filter"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue) {
			case "FlateDecode":
				return new GFAFilterFlateDecode(base, this.baseObject, keyName);
			case "LZWDecode":
				return new GFAFilterLZWDecode(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<org.verapdf.model.baselayer.Object> getDecodeParms1_5() {
		COSObject object = getDecodeParmsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfDecodeParams> list = new ArrayList<>(1);
			list.add(new GFAArrayOfDecodeParams((COSArray)object.getDirectBase(), this.baseObject, "DecodeParms"));
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getDecodeParmsDictionary1_5(object.getDirectBase(), "DecodeParms");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getDecodeParmsDictionary1_5(COSBase base, String keyName) {
		COSObject subtype = this.baseObject.getKey(ASAtom.getASAtom("Filter"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue) {
			case "Crypt":
				return new GFAFilterCrypt(base, this.baseObject, keyName);
			case "FlateDecode":
				return new GFAFilterFlateDecode(base, this.baseObject, keyName);
			case "LZWDecode":
				return new GFAFilterLZWDecode(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<AFileSpecification> getF() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getF1_1();
			default:
				return Collections.emptyList();
		}
	}

	private List<AFileSpecification> getF1_1() {
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

	private List<org.verapdf.model.baselayer.Object> getFDecodeParms() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getFDecodeParms1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getFDecodeParms1_2() {
		COSObject object = getFDecodeParmsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfDecodeParams> list = new ArrayList<>(1);
			list.add(new GFAArrayOfDecodeParams((COSArray)object.getDirectBase(), this.baseObject, "FDecodeParms"));
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getFDecodeParmsDictionary1_2(object.getDirectBase(), "FDecodeParms");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getFDecodeParmsDictionary1_2(COSBase base, String keyName) {
		COSObject subtype = this.baseObject.getKey(ASAtom.getASAtom("FFilter"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue) {
			case "FlateDecode":
				return new GFAFilterFlateDecode(base, this.baseObject, keyName);
			case "LZWDecode":
				return new GFAFilterLZWDecode(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<AArrayOfCompressionFilterNames> getFFilter() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getFFilter1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfCompressionFilterNames> getFFilter1_2() {
		COSObject object = getFFilterValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfCompressionFilterNames> list = new ArrayList<>(1);
			list.add(new GFAArrayOfCompressionFilterNames((COSArray)object.getDirectBase(), this.baseObject, "FFilter"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfCompressionFilterNames> getFilter() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getFilter1_1();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfCompressionFilterNames> getFilter1_1() {
		COSObject object = getFilterValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfCompressionFilterNames> list = new ArrayList<>(1);
			list.add(new GFAArrayOfCompressionFilterNames((COSArray)object.getDirectBase(), this.baseObject, "Filter"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AStream> getLevel1() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getLevel11_1();
			default:
				return Collections.emptyList();
		}
	}

	private List<AStream> getLevel11_1() {
		COSObject object = getLevel1Value();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AStream> list = new ArrayList<>(1);
			list.add(new GFAStream((COSStream)object.getDirectBase(), this.baseObject, "Level1"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AStream> getPS() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getPS1_1();
			default:
				return Collections.emptyList();
		}
	}

	private List<AStream> getPS1_1() {
		COSObject object = getPSValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AStream> list = new ArrayList<>(1);
			list.add(new GFAStream((COSStream)object.getDirectBase(), this.baseObject, "PS"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsBBox() {
		return this.baseObject.knownKey(ASAtom.getASAtom("BBox"));
	}

	public COSObject getBBoxDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSArray.construct(4, new double[]{0,0,0,0});
		}
		return null;
	}

	public COSObject getBBoxValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BBox"));
		if (object == null || object.empty()) {
			object = getBBoxDefaultValue();
		}
		return object;
	}

	@Override
	public String getBBoxType() {
		COSObject BBox = getBBoxValue();
		return getObjectType(BBox);
	}

	@Override
	public Boolean getBBoxHasTypeRectangle() {
		COSObject BBox = getBBoxValue();
		return getHasTypeRectangle(BBox);
	}

	@Override
	public Boolean getcontainsDecodeParms() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DecodeParms"));
	}

	public COSObject getDecodeParmsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DecodeParms"));
		return object;
	}

	@Override
	public String getDecodeParmsType() {
		COSObject DecodeParms = getDecodeParmsValue();
		return getObjectType(DecodeParms);
	}

	@Override
	public Boolean getDecodeParmsHasTypeArray() {
		COSObject DecodeParms = getDecodeParmsValue();
		return getHasTypeArray(DecodeParms);
	}

	@Override
	public Boolean getDecodeParmsHasTypeDictionary() {
		COSObject DecodeParms = getDecodeParmsValue();
		return getHasTypeDictionary(DecodeParms);
	}

	@Override
	public Long getDecodeParmsArraySize() {
		COSObject DecodeParms = getDecodeParmsValue();
		return getArraySize(DecodeParms);
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
	public Boolean getcontainsFDecodeParms() {
		return this.baseObject.knownKey(ASAtom.getASAtom("FDecodeParms"));
	}

	public COSObject getFDecodeParmsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FDecodeParms"));
		return object;
	}

	@Override
	public String getFDecodeParmsType() {
		COSObject FDecodeParms = getFDecodeParmsValue();
		return getObjectType(FDecodeParms);
	}

	@Override
	public Boolean getFDecodeParmsHasTypeArray() {
		COSObject FDecodeParms = getFDecodeParmsValue();
		return getHasTypeArray(FDecodeParms);
	}

	@Override
	public Boolean getFDecodeParmsHasTypeDictionary() {
		COSObject FDecodeParms = getFDecodeParmsValue();
		return getHasTypeDictionary(FDecodeParms);
	}

	@Override
	public Long getFDecodeParmsArraySize() {
		COSObject FDecodeParms = getFDecodeParmsValue();
		return getArraySize(FDecodeParms);
	}

	@Override
	public Boolean getcontainsFFilter() {
		return this.baseObject.knownKey(ASAtom.getASAtom("FFilter"));
	}

	public COSObject getFFilterValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FFilter"));
		return object;
	}

	@Override
	public String getFFilterType() {
		COSObject FFilter = getFFilterValue();
		return getObjectType(FFilter);
	}

	@Override
	public Boolean getFFilterHasTypeArray() {
		COSObject FFilter = getFFilterValue();
		return getHasTypeArray(FFilter);
	}

	@Override
	public Boolean getFFilterHasTypeName() {
		COSObject FFilter = getFFilterValue();
		return getHasTypeName(FFilter);
	}

	@Override
	public String getFFilterNameValue() {
		COSObject FFilter = getFFilterValue();
		return getNameValue(FFilter);
	}

	@Override
	public Long getFFilterArraySize() {
		COSObject FFilter = getFFilterValue();
		return getArraySize(FFilter);
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
	public String getFilterType() {
		COSObject Filter = getFilterValue();
		return getObjectType(Filter);
	}

	@Override
	public Boolean getFilterHasTypeArray() {
		COSObject Filter = getFilterValue();
		return getHasTypeArray(Filter);
	}

	@Override
	public Boolean getFilterHasTypeName() {
		COSObject Filter = getFilterValue();
		return getHasTypeName(Filter);
	}

	@Override
	public String getFilterNameValue() {
		COSObject Filter = getFilterValue();
		return getNameValue(Filter);
	}

	@Override
	public Long getFilterArraySize() {
		COSObject Filter = getFilterValue();
		return getArraySize(Filter);
	}

	@Override
	public Boolean getcontainsFormType() {
		return this.baseObject.knownKey(ASAtom.getASAtom("FormType"));
	}

	public COSObject getFormTypeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FormType"));
		return object;
	}

	@Override
	public String getFormTypeType() {
		COSObject FormType = getFormTypeValue();
		return getObjectType(FormType);
	}

	@Override
	public Boolean getFormTypeHasTypeInteger() {
		COSObject FormType = getFormTypeValue();
		return getHasTypeInteger(FormType);
	}

	@Override
	public Long getFormTypeIntegerValue() {
		COSObject FormType = getFormTypeValue();
		return getIntegerValue(FormType);
	}

	@Override
	public Boolean getcontainsLength() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Length"));
	}

	public COSObject getLengthValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Length"));
		return object;
	}

	@Override
	public String getLengthType() {
		COSObject Length = getLengthValue();
		return getObjectType(Length);
	}

	@Override
	public Boolean getLengthHasTypeInteger() {
		COSObject Length = getLengthValue();
		return getHasTypeInteger(Length);
	}

	@Override
	public Boolean getcontainsLevel1() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Level1"));
	}

	public COSObject getLevel1Value() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Level1"));
		return object;
	}

	@Override
	public Boolean getisLevel1Indirect() {
		COSObject Level1 = getLevel1Value();
		return getisIndirect(Level1);
	}

	@Override
	public String getLevel1Type() {
		COSObject Level1 = getLevel1Value();
		return getObjectType(Level1);
	}

	@Override
	public Boolean getLevel1HasTypeStream() {
		COSObject Level1 = getLevel1Value();
		return getHasTypeStream(Level1);
	}

	@Override
	public Boolean getcontainsMatrix() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Matrix"));
	}

	public COSObject getMatrixDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSArray.construct(6, new double[]{1,0,0,1,0,0});
		}
		return null;
	}

	public COSObject getMatrixValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Matrix"));
		if (object == null || object.empty()) {
			object = getMatrixDefaultValue();
		}
		return object;
	}

	@Override
	public String getMatrixType() {
		COSObject Matrix = getMatrixValue();
		return getObjectType(Matrix);
	}

	@Override
	public Boolean getMatrixHasTypeMatrix() {
		COSObject Matrix = getMatrixValue();
		return getHasTypeMatrix(Matrix);
	}

	@Override
	public Boolean getcontainsPS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("PS"));
	}

	public COSObject getPSValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PS"));
		return object;
	}

	@Override
	public Boolean getisPSIndirect() {
		COSObject PS = getPSValue();
		return getisIndirect(PS);
	}

	@Override
	public String getPSType() {
		COSObject PS = getPSValue();
		return getObjectType(PS);
	}

	@Override
	public Boolean getPSHasTypeStream() {
		COSObject PS = getPSValue();
		return getHasTypeStream(PS);
	}

	@Override
	public Boolean getcontainsSubtype() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Subtype"));
	}

	public COSObject getSubtypeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Subtype"));
		return object;
	}

	@Override
	public String getSubtypeType() {
		COSObject Subtype = getSubtypeValue();
		return getObjectType(Subtype);
	}

	@Override
	public Boolean getSubtypeHasTypeName() {
		COSObject Subtype = getSubtypeValue();
		return getHasTypeName(Subtype);
	}

	@Override
	public String getSubtypeNameValue() {
		COSObject Subtype = getSubtypeValue();
		return getNameValue(Subtype);
	}

	@Override
	public Boolean getcontainsSubtype2() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Subtype2"));
	}

	public COSObject getSubtype2Value() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Subtype2"));
		return object;
	}

	@Override
	public String getSubtype2Type() {
		COSObject Subtype2 = getSubtype2Value();
		return getObjectType(Subtype2);
	}

	@Override
	public Boolean getSubtype2HasTypeName() {
		COSObject Subtype2 = getSubtype2Value();
		return getHasTypeName(Subtype2);
	}

	@Override
	public String getSubtype2NameValue() {
		COSObject Subtype2 = getSubtype2Value();
		return getNameValue(Subtype2);
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
	public String getTypeType() {
		COSObject Type = getTypeValue();
		return getObjectType(Type);
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
