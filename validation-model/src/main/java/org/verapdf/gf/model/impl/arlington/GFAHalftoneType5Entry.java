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

public class GFAHalftoneType5Entry extends GFAObject implements AHalftoneType5Entry {

	private COSBase parentParentObject;
	private String collectionName;

	public GFAHalftoneType5Entry(COSBase baseObject, COSBase parentObject, COSBase parentParentObject, String collectionName, String keyName) {
		super(baseObject, parentObject, keyName, "AHalftoneType5Entry");
		this.parentParentObject = parentParentObject;
		this.collectionName = collectionName;
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Entry":
				return getEntry();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<org.verapdf.model.baselayer.Object> getEntry() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
				return getEntry1_2();
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getEntry1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getEntry1_2() {
		COSObject object = new COSObject(this.baseObject);
		if (object.getType() == COSObjType.COS_DICT) {
			List<AHalftoneType1> list = new ArrayList<>(1);
			list.add(new GFAHalftoneType1((COSDictionary)object.getDirectBase(), this.parentObject, keyName));
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			org.verapdf.model.baselayer.Object result = getEntryStream1_2(object.getDirectBase(), keyName);
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getEntryStream1_2(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("HalftoneType"));
		if (subtype == null) {
			return null;
		}
		Long subtypeValue = subtype.getInteger();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue.intValue()) {
			case 6:
				return new GFAHalftoneType6(base, this.baseObject, keyName);
			case 10:
				return new GFAHalftoneType10(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<org.verapdf.model.baselayer.Object> getEntry1_3() {
		COSObject object = new COSObject(this.baseObject);
		if (object.getType() == COSObjType.COS_DICT) {
			List<AHalftoneType1> list = new ArrayList<>(1);
			list.add(new GFAHalftoneType1((COSDictionary)object.getDirectBase(), this.parentObject, keyName));
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			org.verapdf.model.baselayer.Object result = getEntryStream1_3(object.getDirectBase(), keyName);
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getEntryStream1_3(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("HalftoneType"));
		if (subtype == null) {
			return null;
		}
		Long subtypeValue = subtype.getInteger();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue.intValue()) {
			case 16:
				return new GFAHalftoneType16(base, this.baseObject, keyName);
			case 6:
				return new GFAHalftoneType6(base, this.baseObject, keyName);
			case 10:
				return new GFAHalftoneType10(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	@Override
	public Boolean getisIndirect() {
		COSObject object = new COSObject(this.baseObject);
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getHasTypeDictionary() {
		COSObject object = new COSObject(this.baseObject);
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getHasTypeStream() {
		COSObject object = new COSObject(this.baseObject);
		return object != null && object.getType() == COSObjType.COS_STREAM;
	}

}
