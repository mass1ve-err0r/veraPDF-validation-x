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

public class GFAXObjectFormTrapNet extends GFAObject implements AXObjectFormTrapNet {

	public GFAXObjectFormTrapNet(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AXObjectFormTrapNet");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "AF":
				return getAF();
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
			case "Group":
				return getGroup();
			case "Measure":
				return getMeasure();
			case "Metadata":
				return getMetadata();
			case "OC":
				return getOC();
			case "OPI":
				return getOPI();
			case "PieceInfo":
				return getPieceInfo();
			case "PtData":
				return getPtData();
			case "Ref":
				return getRef();
			case "Resources":
				return getResources();
			case "SeparationColorNames":
				return getSeparationColorNames();
			case "TrapRegions":
				return getTrapRegions();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<org.verapdf.model.baselayer.Object> getAF() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getAF2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getAF2_0() {
		COSObject object = getAFValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfFileSpecifications> list = new ArrayList<>(1);
			list.add(new GFAArrayOfFileSpecifications((COSArray)object.getDirectBase(), this.baseObject, "AF"));
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AFileSpecification> list = new ArrayList<>(1);
			list.add(new GFAFileSpecification((COSDictionary)object.getDirectBase(), this.baseObject, "AF"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.baselayer.Object> getDecodeParms() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
				return getDecodeParms1_3();
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getDecodeParms1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getDecodeParms1_3() {
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
			org.verapdf.model.baselayer.Object result = getDecodeParmsDictionary1_3(object.getDirectBase(), "DecodeParms");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getDecodeParmsDictionary1_3(COSBase base, String keyName) {
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
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getF1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AFileSpecification> getF1_3() {
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
			case ARLINGTON1_3:
			case ARLINGTON1_4:
				return getFDecodeParms1_3();
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getFDecodeParms1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getFDecodeParms1_3() {
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
			org.verapdf.model.baselayer.Object result = getFDecodeParmsDictionary1_3(object.getDirectBase(), "FDecodeParms");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getFDecodeParmsDictionary1_3(COSBase base, String keyName) {
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

	private List<org.verapdf.model.baselayer.Object> getFDecodeParms1_5() {
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
			org.verapdf.model.baselayer.Object result = getFDecodeParmsDictionary1_5(object.getDirectBase(), "FDecodeParms");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getFDecodeParmsDictionary1_5(COSBase base, String keyName) {
		COSObject subtype = this.baseObject.getKey(ASAtom.getASAtom("FFilter"));
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

	private List<AArrayOfCompressionFilterNames> getFFilter() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getFFilter1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfCompressionFilterNames> getFFilter1_3() {
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
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getFilter1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfCompressionFilterNames> getFilter1_3() {
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

	private List<AGroupAttributes> getGroup() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getGroup1_4();
			default:
				return Collections.emptyList();
		}
	}

	private List<AGroupAttributes> getGroup1_4() {
		COSObject object = getGroupValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AGroupAttributes> list = new ArrayList<>(1);
			list.add(new GFAGroupAttributes((COSDictionary)object.getDirectBase(), this.baseObject, "Group"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AMeasureRL> getMeasure() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getMeasure1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AMeasureRL> getMeasure1_7() {
		COSObject object = getMeasureValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AMeasureRL> list = new ArrayList<>(1);
			list.add(new GFAMeasureRL((COSDictionary)object.getDirectBase(), this.baseObject, "Measure"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AMetadata> getMetadata() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getMetadata1_4();
			default:
				return Collections.emptyList();
		}
	}

	private List<AMetadata> getMetadata1_4() {
		COSObject object = getMetadataValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AMetadata> list = new ArrayList<>(1);
			list.add(new GFAMetadata((COSStream)object.getDirectBase(), this.baseObject, "Metadata"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.baselayer.Object> getOC() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getOC1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getOC1_5() {
		COSObject object = getOCValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getOCDictionary1_5(object.getDirectBase(), "OC");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getOCDictionary1_5(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("Type"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue) {
			case "OCG":
				return new GFAOptContentGroup(base, this.baseObject, keyName);
			case "OCMD":
				return new GFAOptContentMembership(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<org.verapdf.model.baselayer.Object> getOPI() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getOPI1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getOPI1_3() {
		COSObject object = getOPIValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getOPIDictionary1_3(object.getDirectBase(), "OPI");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getOPIDictionary1_3(COSBase base, String keyName) {
		if (base.knownKey(ASAtom.getASAtom("1.3"))) {
			return new GFAOPIVersion13(base, this.baseObject, keyName);
		}
		if (base.knownKey(ASAtom.getASAtom("2.0"))) {
			return new GFAOPIVersion20(base, this.baseObject, keyName);
		}
		return null;
	}

	private List<APagePiece> getPieceInfo() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getPieceInfo1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<APagePiece> getPieceInfo1_3() {
		COSObject object = getPieceInfoValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<APagePiece> list = new ArrayList<>(1);
			list.add(new GFAPagePiece((COSDictionary)object.getDirectBase(), this.baseObject, "PieceInfo"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<APointData> getPtData() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getPtData1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<APointData> getPtData1_7() {
		COSObject object = getPtDataValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<APointData> list = new ArrayList<>(1);
			list.add(new GFAPointData((COSDictionary)object.getDirectBase(), this.baseObject, "PtData"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AReference> getRef() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getRef1_4();
			default:
				return Collections.emptyList();
		}
	}

	private List<AReference> getRef1_4() {
		COSObject object = getRefValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AReference> list = new ArrayList<>(1);
			list.add(new GFAReference((COSDictionary)object.getDirectBase(), this.baseObject, "Ref"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AResource> getResources() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getResources1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AResource> getResources1_3() {
		COSObject object = getResourcesValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AResource> list = new ArrayList<>(1);
			list.add(new GFAResource((COSDictionary)object.getDirectBase(), this.baseObject, "Resources"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfNamesGeneral> getSeparationColorNames() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getSeparationColorNames1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfNamesGeneral> getSeparationColorNames1_3() {
		COSObject object = getSeparationColorNamesValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfNamesGeneral> list = new ArrayList<>(1);
			list.add(new GFAArrayOfNamesGeneral((COSArray)object.getDirectBase(), this.baseObject, "SeparationColorNames"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfTrapRegions> getTrapRegions() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getTrapRegions1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfTrapRegions> getTrapRegions1_3() {
		COSObject object = getTrapRegionsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfTrapRegions> list = new ArrayList<>(1);
			list.add(new GFAArrayOfTrapRegions((COSArray)object.getDirectBase(), this.baseObject, "TrapRegions"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsAF() {
		return this.baseObject.knownKey(ASAtom.getASAtom("AF"));
	}

	public COSObject getAFValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AF"));
		return object;
	}

	@Override
	public Boolean getAFHasTypeArray() {
		COSObject AF = getAFValue();
		return getHasTypeArray(AF);
	}

	@Override
	public Boolean getAFHasTypeDictionary() {
		COSObject AF = getAFValue();
		return getHasTypeDictionary(AF);
	}

	@Override
	public Boolean getcontainsBBox() {
		return this.baseObject.knownKey(ASAtom.getASAtom("BBox"));
	}

	public COSObject getBBoxValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BBox"));
		return object;
	}

	@Override
	public Boolean getBBoxHasTypeRectangle() {
		COSObject BBox = getBBoxValue();
		return getHasTypeRectangle(BBox);
	}

	@Override
	public Boolean getcontainsDL() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DL"));
	}

	public COSObject getDLValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DL"));
		return object;
	}

	@Override
	public Boolean getDLHasTypeInteger() {
		COSObject DL = getDLValue();
		return getHasTypeInteger(DL);
	}

	@Override
	public Long getDLIntegerValue() {
		COSObject DL = getDLValue();
		return getIntegerValue(DL);
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
	public Boolean getcontainsGroup() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Group"));
	}

	public COSObject getGroupValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Group"));
		return object;
	}

	@Override
	public Boolean getGroupHasTypeDictionary() {
		COSObject Group = getGroupValue();
		return getHasTypeDictionary(Group);
	}

	@Override
	public Boolean getcontainsLastModified() {
		return this.baseObject.knownKey(ASAtom.getASAtom("LastModified"));
	}

	public COSObject getLastModifiedValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("LastModified"));
		return object;
	}

	@Override
	public Boolean getLastModifiedHasTypeDate() {
		COSObject LastModified = getLastModifiedValue();
		return getHasTypeDate(LastModified);
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
	public Boolean getLengthHasTypeInteger() {
		COSObject Length = getLengthValue();
		return getHasTypeInteger(Length);
	}

	@Override
	public Boolean getcontainsMatrix() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Matrix"));
	}

	public COSObject getMatrixDefaultValue() {
		switch (StaticContainers.getFlavour()) {
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
	public Boolean getMatrixHasTypeMatrix() {
		COSObject Matrix = getMatrixValue();
		return getHasTypeMatrix(Matrix);
	}

	@Override
	public Boolean getcontainsMeasure() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Measure"));
	}

	public COSObject getMeasureValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Measure"));
		return object;
	}

	@Override
	public Boolean getMeasureHasTypeDictionary() {
		COSObject Measure = getMeasureValue();
		return getHasTypeDictionary(Measure);
	}

	@Override
	public Boolean getcontainsMetadata() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Metadata"));
	}

	public COSObject getMetadataValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Metadata"));
		return object;
	}

	@Override
	public Boolean getisMetadataIndirect() {
		COSObject Metadata = getMetadataValue();
		return getisIndirect(Metadata);
	}

	@Override
	public Boolean getMetadataHasTypeStream() {
		COSObject Metadata = getMetadataValue();
		return getHasTypeStream(Metadata);
	}

	@Override
	public Boolean getcontainsName() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Name"));
	}

	public COSObject getNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Name"));
		return object;
	}

	@Override
	public Boolean getNameHasTypeName() {
		COSObject Name = getNameValue();
		return getHasTypeName(Name);
	}

	@Override
	public Boolean getcontainsOC() {
		return this.baseObject.knownKey(ASAtom.getASAtom("OC"));
	}

	public COSObject getOCValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OC"));
		return object;
	}

	@Override
	public Boolean getOCHasTypeDictionary() {
		COSObject OC = getOCValue();
		return getHasTypeDictionary(OC);
	}

	@Override
	public Boolean getcontainsOPI() {
		return this.baseObject.knownKey(ASAtom.getASAtom("OPI"));
	}

	public COSObject getOPIValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OPI"));
		return object;
	}

	@Override
	public Boolean getOPIHasTypeDictionary() {
		COSObject OPI = getOPIValue();
		return getHasTypeDictionary(OPI);
	}

	@Override
	public Boolean getcontainsPCM() {
		return this.baseObject.knownKey(ASAtom.getASAtom("PCM"));
	}

	public COSObject getPCMValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PCM"));
		return object;
	}

	@Override
	public Boolean getPCMHasTypeName() {
		COSObject PCM = getPCMValue();
		return getHasTypeName(PCM);
	}

	@Override
	public String getPCMNameValue() {
		COSObject PCM = getPCMValue();
		return getNameValue(PCM);
	}

	@Override
	public Boolean getcontainsPieceInfo() {
		return this.baseObject.knownKey(ASAtom.getASAtom("PieceInfo"));
	}

	public COSObject getPieceInfoValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PieceInfo"));
		return object;
	}

	@Override
	public Boolean getPieceInfoHasTypeDictionary() {
		COSObject PieceInfo = getPieceInfoValue();
		return getHasTypeDictionary(PieceInfo);
	}

	@Override
	public Boolean getcontainsPtData() {
		return this.baseObject.knownKey(ASAtom.getASAtom("PtData"));
	}

	public COSObject getPtDataValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PtData"));
		return object;
	}

	@Override
	public Boolean getPtDataHasTypeDictionary() {
		COSObject PtData = getPtDataValue();
		return getHasTypeDictionary(PtData);
	}

	@Override
	public Boolean getcontainsRef() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Ref"));
	}

	public COSObject getRefValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Ref"));
		return object;
	}

	@Override
	public Boolean getRefHasTypeDictionary() {
		COSObject Ref = getRefValue();
		return getHasTypeDictionary(Ref);
	}

	@Override
	public Boolean getcontainsResources() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Resources"));
	}

	public COSObject getResourcesValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Resources"));
		return object;
	}

	@Override
	public Boolean getResourcesHasTypeDictionary() {
		COSObject Resources = getResourcesValue();
		return getHasTypeDictionary(Resources);
	}

	@Override
	public Boolean getcontainsSeparationColorNames() {
		return this.baseObject.knownKey(ASAtom.getASAtom("SeparationColorNames"));
	}

	public COSObject getSeparationColorNamesValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SeparationColorNames"));
		return object;
	}

	@Override
	public Boolean getSeparationColorNamesHasTypeArray() {
		COSObject SeparationColorNames = getSeparationColorNamesValue();
		return getHasTypeArray(SeparationColorNames);
	}

	@Override
	public Boolean getcontainsStructParent() {
		return this.baseObject.knownKey(ASAtom.getASAtom("StructParent"));
	}

	public COSObject getStructParentValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("StructParent"));
		return object;
	}

	@Override
	public Boolean getStructParentHasTypeInteger() {
		COSObject StructParent = getStructParentValue();
		return getHasTypeInteger(StructParent);
	}

	@Override
	public Boolean getcontainsStructParents() {
		return this.baseObject.knownKey(ASAtom.getASAtom("StructParents"));
	}

	public COSObject getStructParentsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("StructParents"));
		return object;
	}

	@Override
	public Boolean getStructParentsHasTypeInteger() {
		COSObject StructParents = getStructParentsValue();
		return getHasTypeInteger(StructParents);
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
	public Boolean getcontainsTrapRegions() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TrapRegions"));
	}

	public COSObject getTrapRegionsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TrapRegions"));
		return object;
	}

	@Override
	public Boolean getTrapRegionsHasTypeArray() {
		COSObject TrapRegions = getTrapRegionsValue();
		return getHasTypeArray(TrapRegions);
	}

	@Override
	public Boolean getcontainsTrapStyles() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TrapStyles"));
	}

	public COSObject getTrapStylesValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TrapStyles"));
		return object;
	}

	@Override
	public Boolean getTrapStylesHasTypeStringText() {
		COSObject TrapStyles = getTrapStylesValue();
		return getHasTypeStringText(TrapStyles);
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
	public Boolean gethasExtensionADBE_Extn3() {
		return false;
	}

}