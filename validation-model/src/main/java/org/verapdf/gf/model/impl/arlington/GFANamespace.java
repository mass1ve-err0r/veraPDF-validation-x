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

public class GFANamespace extends GFAObject implements ANamespace {

	public GFANamespace(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ANamespace");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "RoleMapNS":
				return getRoleMapNS();
			case "Schema":
				return getSchema();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<ARoleMapNS> getRoleMapNS() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getRoleMapNS2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<ARoleMapNS> getRoleMapNS2_0() {
		COSObject object = getRoleMapNSValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ARoleMapNS> list = new ArrayList<>(1);
			list.add(new GFARoleMapNS((COSDictionary)object.getDirectBase(), this.baseObject, "RoleMapNS"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AFileSpecification> getSchema() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getSchema2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<AFileSpecification> getSchema2_0() {
		COSObject object = getSchemaValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AFileSpecification> list = new ArrayList<>(1);
			list.add(new GFAFileSpecification((COSDictionary)object.getDirectBase(), this.baseObject, "Schema"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsNS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("NS"));
	}

	public COSObject getNSValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("NS"));
		return object;
	}

	@Override
	public Boolean getNSHasTypeStringText() {
		COSObject object = getNSValue();
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsRoleMapNS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("RoleMapNS"));
	}

	public COSObject getRoleMapNSValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("RoleMapNS"));
		return object;
	}

	@Override
	public Boolean getRoleMapNSHasTypeDictionary() {
		COSObject object = getRoleMapNSValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsSchema() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Schema"));
	}

	public COSObject getSchemaValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Schema"));
		return object;
	}

	@Override
	public Boolean getSchemaHasTypeDictionary() {
		COSObject object = getSchemaValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getSchemaHasTypeString() {
		COSObject object = getSchemaValue();
		return object != null && object.getType() == COSObjType.COS_STRING;
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

}