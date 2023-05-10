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

public class GFAFileSpecEF extends GFAObject implements AFileSpecEF {

	public GFAFileSpecEF(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AFileSpecEF");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "F":
				return getF();
			case "UF":
				return getUF();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AEmbeddedFileStream> getF() {
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

	private List<AEmbeddedFileStream> getF1_3() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("F"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AEmbeddedFileStream> list = new ArrayList<>(1);
			list.add(new GFAEmbeddedFileStream((COSStream)object.getDirectBase(), this.baseObject, "F"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AEmbeddedFileStream> getUF() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getUF1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AEmbeddedFileStream> getUF1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("UF"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AEmbeddedFileStream> list = new ArrayList<>(1);
			list.add(new GFAEmbeddedFileStream((COSStream)object.getDirectBase(), this.baseObject, "UF"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsF() {
		return this.baseObject.knownKey(ASAtom.getASAtom("F"));
	}

	@Override
	public Boolean getisFIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("F"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getFHasTypeStream() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("F"));
		return object != null && object.getType() == COSObjType.COS_STREAM;
	}

	@Override
	public Boolean getcontainsUF() {
		return this.baseObject.knownKey(ASAtom.getASAtom("UF"));
	}

	@Override
	public Boolean getisUFIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("UF"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getUFHasTypeStream() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("UF"));
		return object != null && object.getType() == COSObjType.COS_STREAM;
	}

}
