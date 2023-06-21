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

public class GFAArrayOfArraysXPTSValuesEntry extends GFAObject implements AArrayOfArraysXPTSValuesEntry {

	private COSBase parentParentObject;
	private String collectionName;

	public GFAArrayOfArraysXPTSValuesEntry(COSBase baseObject, COSBase parentObject, COSBase parentParentObject, String collectionName, String keyName) {
		super(baseObject, parentObject, keyName, "AArrayOfArraysXPTSValuesEntry");
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

	private List<AArrayOfXPTSValues> getEntry() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getEntry1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfXPTSValues> getEntry1_7() {
		COSObject object = new COSObject(this.baseObject);
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfXPTSValues> list = new ArrayList<>(1);
			list.add(new GFAArrayOfXPTSValues((COSArray)object.getDirectBase(), this.parentObject, keyName));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	public COSObject getValue() {
		COSObject object = new COSObject(this.baseObject);
		return object;
	}

	@Override
	public Boolean getHasTypeArray() {
		COSObject object = getValue();
		return getHasTypeArray(object);
	}

	@Override
	public Long getArraySize() {
		COSObject object = getValue();
		return getArraySize(object);
	}

	@Override
	public Long getparentNamesArraySize() {
		if (this.parentParentObject == null || !this.parentParentObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject Names = this.parentParentObject.getKey(ASAtom.getASAtom("Names"));
		return getArraySize(Names);
	}

	@Override
	public Boolean getparentNamesHasTypeArray() {
		if (this.parentParentObject == null || !this.parentParentObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject Names = this.parentParentObject.getKey(ASAtom.getASAtom("Names"));
		return getHasTypeArray(Names);
	}

	@Override
	public Boolean gethasExtensionADBE_Extn3() {
		return false;
	}

}
