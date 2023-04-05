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

public class GFARichMediaSettings extends GFAObject implements ARichMediaSettings {

	public GFARichMediaSettings(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ARichMediaSettings");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Deactivation":
				return getDeactivation();
			case "Activation":
				return getActivation();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<ARichMediaDeactivation> getDeactivation() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getDeactivation1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<ARichMediaDeactivation> getDeactivation1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Deactivation"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ARichMediaDeactivation> list = new ArrayList<>(1);
			list.add(new GFARichMediaDeactivation((COSDictionary)object.getDirectBase(), this.baseObject, "Deactivation"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ARichMediaActivation> getActivation() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getActivation1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<ARichMediaActivation> getActivation1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Activation"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ARichMediaActivation> list = new ArrayList<>(1);
			list.add(new GFARichMediaActivation((COSDictionary)object.getDirectBase(), this.baseObject, "Activation"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsType() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Type"));
	}

	@Override
	public Boolean getTypeHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Type"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getTypeNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Type"));
		if (object == null || object.empty()) {
			return getTypeNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getTypeNameDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsActivation() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Activation"));
	}

	@Override
	public Boolean getActivationHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Activation"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsDeactivation() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Deactivation"));
	}

	@Override
	public Boolean getDeactivationHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Deactivation"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

}
