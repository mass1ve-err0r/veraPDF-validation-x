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

public class GFAArrayOf_4ColourSpaceEntries extends GFAObject implements AArrayOf_4ColourSpaceEntries {

	public GFAArrayOf_4ColourSpaceEntries(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AArrayOf_4ColourSpaceEntries");
	}

	public COSObject getentry0Value() {
		if (this.baseObject.size() <= 0) {
			return null;
		}
		COSObject object = this.baseObject.at(0);
		return object;
	}

	@Override
	public Boolean getentry0HasTypeName() {
		COSObject object = getentry0Value();
		return getHasTypeName(object);
	}

	@Override
	public String getentry0NameValue() {
		COSObject object = getentry0Value();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public COSObject getentry1Value() {
		if (this.baseObject.size() <= 1) {
			return null;
		}
		COSObject object = this.baseObject.at(1);
		return object;
	}

	@Override
	public Boolean getentry1HasTypeNumber() {
		COSObject object = getentry1Value();
		return getHasTypeNumber(object);
	}

	@Override
	public Double getentry1NumberValue() {
		COSObject object = getentry1Value();
		if (object != null && object.getType().isNumber()) {
			return object.getReal();
		}
		return null;
	}

	public COSObject getentry2Value() {
		if (this.baseObject.size() <= 2) {
			return null;
		}
		COSObject object = this.baseObject.at(2);
		return object;
	}

	@Override
	public Boolean getentry2HasTypeNumber() {
		COSObject object = getentry2Value();
		return getHasTypeNumber(object);
	}

	@Override
	public Double getentry2NumberValue() {
		COSObject object = getentry2Value();
		if (object != null && object.getType().isNumber()) {
			return object.getReal();
		}
		return null;
	}

	public COSObject getentry3Value() {
		if (this.baseObject.size() <= 3) {
			return null;
		}
		COSObject object = this.baseObject.at(3);
		return object;
	}

	@Override
	public Boolean getentry3HasTypeNumber() {
		COSObject object = getentry3Value();
		return getHasTypeNumber(object);
	}

	@Override
	public Double getentry3NumberValue() {
		COSObject object = getentry3Value();
		if (object != null && object.getType().isNumber()) {
			return object.getReal();
		}
		return null;
	}

}
