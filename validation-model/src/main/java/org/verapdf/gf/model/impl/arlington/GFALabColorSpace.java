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

public class GFALabColorSpace extends GFAObject implements ALabColorSpace {

	public GFALabColorSpace(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ALabColorSpace");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "entry1":
				return getentry1();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<ALabDict> getentry1() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getentry11_1();
			default:
				return Collections.emptyList();
		}
	}

	private List<ALabDict> getentry11_1() {
		if (this.baseObject.size() < 1) {
			return Collections.emptyList();
		}
		COSObject object = this.baseObject.at(1);
		if (object.getType() == COSObjType.COS_DICT) {
			List<ALabDict> list = new ArrayList<>(1);
			list.add(new GFALabDict((COSDictionary)object.getDirectBase(), this.baseObject, "1"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getentry0HasTypeName() {
		if (this.baseObject.size() <= 0) {
			return null;
		}
		COSObject object = this.baseObject.at(0);
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getentry0NameValue() {
		if (this.baseObject.size() <= 0) {
			return null;
		}
		COSObject object = this.baseObject.at(0);
		if (object == null || object.empty()) {
			return getentry0NameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getentry0NameDefaultValue() {
		return null;
	}

	@Override
	public Boolean getentry1HasTypeDictionary() {
		if (this.baseObject.size() <= 1) {
			return null;
		}
		COSObject object = this.baseObject.at(1);
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

}