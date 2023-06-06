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

public class GFAOptContentExport extends GFAObject implements AOptContentExport {

	public GFAOptContentExport(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AOptContentExport");
	}

	@Override
	public Boolean getcontainsExportState() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ExportState"));
	}

	public COSObject getExportStateValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ExportState"));
		return object;
	}

	@Override
	public Boolean getExportStateHasTypeName() {
		COSObject object = getExportStateValue();
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getExportStateNameValue() {
		COSObject object = getExportStateValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

}