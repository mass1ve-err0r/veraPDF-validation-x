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

public class GFACharProcMap extends GFAObject implements ACharProcMap {

	public GFACharProcMap(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ACharProcMap");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Entries":
				return getEntries();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<ACharProcMapEntry> getEntries() {
		return getEntries1_0();
	}

	private List<ACharProcMapEntry> getEntries1_0() {
		List<ACharProcMapEntry> list = new LinkedList<>();
		for (ASAtom key : baseObject.getKeySet()) {
			COSObject object = this.baseObject.getKey(key);
			list.add(new GFACharProcMapEntry(object != null ? object.get() : null, this.baseObject, this.parentObject, keyName, key.getValue()));
		}
		return Collections.unmodifiableList(list);
	}

}