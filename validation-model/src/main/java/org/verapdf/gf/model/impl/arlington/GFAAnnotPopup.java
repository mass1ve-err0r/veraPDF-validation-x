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

public class GFAAnnotPopup extends GFAObject implements AAnnotPopup {

	public GFAAnnotPopup(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AAnnotPopup");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "AF":
				return getAF();
			case "AP":
				return getAP();
			case "Border":
				return getBorder();
			case "C":
				return getC();
			case "OC":
				return getOC();
			case "P":
				return getP();
			case "Parent":
				return getParent();
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AF"));
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

	private List<AAppearance> getAP() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getAP1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AAppearance> getAP1_3() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AP"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AAppearance> list = new ArrayList<>(1);
			list.add(new GFAAppearance((COSDictionary)object.getDirectBase(), this.baseObject, "AP"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOf_4AnnotBorderCharacteristics> getBorder() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getBorder1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_4AnnotBorderCharacteristics> getBorder1_3() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Border"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf_4AnnotBorderCharacteristics> list = new ArrayList<>(1);
			list.add(new GFAArrayOf_4AnnotBorderCharacteristics((COSArray)object.getDirectBase(), this.baseObject, "Border"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOf_4NumbersColorAnnotation> getC() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getC1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_4NumbersColorAnnotation> getC1_3() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("C"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf_4NumbersColorAnnotation> list = new ArrayList<>(1);
			list.add(new GFAArrayOf_4NumbersColorAnnotation((COSArray)object.getDirectBase(), this.baseObject, "C"));
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OC"));
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

	private List<APageObject> getP() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getP1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<APageObject> getP1_3() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("P"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<APageObject> list = new ArrayList<>(1);
			list.add(new GFAPageObject((COSDictionary)object.getDirectBase(), this.baseObject, "P"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.baselayer.Object> getParent() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
				return getParent1_3();
			case ARLINGTON1_4:
				return getParent1_4();
			case ARLINGTON1_5:
				return getParent1_5();
			case ARLINGTON1_6:
				return getParent1_6();
			case ARLINGTON1_7:
				return getParent1_7();
			case ARLINGTON2_0:
				return getParent2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getParent1_3() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Parent"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getParentDictionary1_3(object.getDirectBase(), "Parent");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getParentDictionary1_3(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("Subtype"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue) {
			case "Circle":
				return new GFAAnnotCircle(base, this.baseObject, keyName);
			case "Movie":
				return new GFAAnnotMovie(base, this.baseObject, keyName);
			case "StrikeOut":
				return new GFAAnnotStrikeOut(base, this.baseObject, keyName);
			case "Highlight":
				return new GFAAnnotHighlight(base, this.baseObject, keyName);
			case "Stamp":
				return new GFAAnnotStamp(base, this.baseObject, keyName);
			case "Ink":
				return new GFAAnnotInk(base, this.baseObject, keyName);
			case "FileAttachment":
				return new GFAAnnotFileAttachment(base, this.baseObject, keyName);
			case "Widget":
				return new GFAAnnotWidget(base, this.baseObject, keyName);
			case "Text":
				return new GFAAnnotText(base, this.baseObject, keyName);
			case "Sound":
				return new GFAAnnotSound(base, this.baseObject, keyName);
			case "Square":
				return new GFAAnnotSquare(base, this.baseObject, keyName);
			case "FreeText":
				return new GFAAnnotFreeText(base, this.baseObject, keyName);
			case "Line":
				return new GFAAnnotLine(base, this.baseObject, keyName);
			case "Underline":
				return new GFAAnnotUnderline(base, this.baseObject, keyName);
			case "Popup":
				return new GFAAnnotPopup(base, this.baseObject, keyName);
			case "Link":
				return new GFAAnnotLink(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<org.verapdf.model.baselayer.Object> getParent1_4() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Parent"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getParentDictionary1_4(object.getDirectBase(), "Parent");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getParentDictionary1_4(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("Subtype"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue) {
			case "Circle":
				return new GFAAnnotCircle(base, this.baseObject, keyName);
			case "Movie":
				return new GFAAnnotMovie(base, this.baseObject, keyName);
			case "StrikeOut":
				return new GFAAnnotStrikeOut(base, this.baseObject, keyName);
			case "Highlight":
				return new GFAAnnotHighlight(base, this.baseObject, keyName);
			case "Stamp":
				return new GFAAnnotStamp(base, this.baseObject, keyName);
			case "Ink":
				return new GFAAnnotInk(base, this.baseObject, keyName);
			case "FileAttachment":
				return new GFAAnnotFileAttachment(base, this.baseObject, keyName);
			case "Widget":
				return new GFAAnnotWidget(base, this.baseObject, keyName);
			case "Text":
				return new GFAAnnotText(base, this.baseObject, keyName);
			case "Sound":
				return new GFAAnnotSound(base, this.baseObject, keyName);
			case "Square":
				return new GFAAnnotSquare(base, this.baseObject, keyName);
			case "FreeText":
				return new GFAAnnotFreeText(base, this.baseObject, keyName);
			case "Line":
				return new GFAAnnotLine(base, this.baseObject, keyName);
			case "PrinterMark":
				return new GFAAnnotPrinterMark(base, this.baseObject, keyName);
			case "Underline":
				return new GFAAnnotUnderline(base, this.baseObject, keyName);
			case "Popup":
				return new GFAAnnotPopup(base, this.baseObject, keyName);
			case "Link":
				return new GFAAnnotLink(base, this.baseObject, keyName);
			case "Squiggly":
				return new GFAAnnotSquiggly(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<org.verapdf.model.baselayer.Object> getParent1_5() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Parent"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getParentDictionary1_5(object.getDirectBase(), "Parent");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getParentDictionary1_5(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("Subtype"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue) {
			case "Circle":
				return new GFAAnnotCircle(base, this.baseObject, keyName);
			case "Movie":
				return new GFAAnnotMovie(base, this.baseObject, keyName);
			case "StrikeOut":
				return new GFAAnnotStrikeOut(base, this.baseObject, keyName);
			case "Highlight":
				return new GFAAnnotHighlight(base, this.baseObject, keyName);
			case "Stamp":
				return new GFAAnnotStamp(base, this.baseObject, keyName);
			case "Screen":
				return new GFAAnnotScreen(base, this.baseObject, keyName);
			case "Ink":
				return new GFAAnnotInk(base, this.baseObject, keyName);
			case "FileAttachment":
				return new GFAAnnotFileAttachment(base, this.baseObject, keyName);
			case "Widget":
				return new GFAAnnotWidget(base, this.baseObject, keyName);
			case "Text":
				return new GFAAnnotText(base, this.baseObject, keyName);
			case "Sound":
				return new GFAAnnotSound(base, this.baseObject, keyName);
			case "Square":
				return new GFAAnnotSquare(base, this.baseObject, keyName);
			case "FreeText":
				return new GFAAnnotFreeText(base, this.baseObject, keyName);
			case "Line":
				return new GFAAnnotLine(base, this.baseObject, keyName);
			case "PrinterMark":
				return new GFAAnnotPrinterMark(base, this.baseObject, keyName);
			case "Underline":
				return new GFAAnnotUnderline(base, this.baseObject, keyName);
			case "Popup":
				return new GFAAnnotPopup(base, this.baseObject, keyName);
			case "Polygon":
				return new GFAAnnotPolygon(base, this.baseObject, keyName);
			case "Link":
				return new GFAAnnotLink(base, this.baseObject, keyName);
			case "Caret":
				return new GFAAnnotCaret(base, this.baseObject, keyName);
			case "Squiggly":
				return new GFAAnnotSquiggly(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<org.verapdf.model.baselayer.Object> getParent1_6() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Parent"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getParentDictionary1_6(object.getDirectBase(), "Parent");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getParentDictionary1_6(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("Subtype"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue) {
			case "Circle":
				return new GFAAnnotCircle(base, this.baseObject, keyName);
			case "Movie":
				return new GFAAnnotMovie(base, this.baseObject, keyName);
			case "StrikeOut":
				return new GFAAnnotStrikeOut(base, this.baseObject, keyName);
			case "Highlight":
				return new GFAAnnotHighlight(base, this.baseObject, keyName);
			case "Stamp":
				return new GFAAnnotStamp(base, this.baseObject, keyName);
			case "Screen":
				return new GFAAnnotScreen(base, this.baseObject, keyName);
			case "Ink":
				return new GFAAnnotInk(base, this.baseObject, keyName);
			case "FileAttachment":
				return new GFAAnnotFileAttachment(base, this.baseObject, keyName);
			case "Widget":
				return new GFAAnnotWidget(base, this.baseObject, keyName);
			case "Text":
				return new GFAAnnotText(base, this.baseObject, keyName);
			case "Sound":
				return new GFAAnnotSound(base, this.baseObject, keyName);
			case "Square":
				return new GFAAnnotSquare(base, this.baseObject, keyName);
			case "FreeText":
				return new GFAAnnotFreeText(base, this.baseObject, keyName);
			case "Line":
				return new GFAAnnotLine(base, this.baseObject, keyName);
			case "PrinterMark":
				return new GFAAnnotPrinterMark(base, this.baseObject, keyName);
			case "3D":
				return new GFAAnnot3D(base, this.baseObject, keyName);
			case "Underline":
				return new GFAAnnotUnderline(base, this.baseObject, keyName);
			case "Popup":
				return new GFAAnnotPopup(base, this.baseObject, keyName);
			case "Polygon":
				return new GFAAnnotPolygon(base, this.baseObject, keyName);
			case "Watermark":
				return new GFAAnnotWatermark(base, this.baseObject, keyName);
			case "Link":
				return new GFAAnnotLink(base, this.baseObject, keyName);
			case "Caret":
				return new GFAAnnotCaret(base, this.baseObject, keyName);
			case "Squiggly":
				return new GFAAnnotSquiggly(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<org.verapdf.model.baselayer.Object> getParent1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Parent"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getParentDictionary1_7(object.getDirectBase(), "Parent");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getParentDictionary1_7(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("Subtype"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue) {
			case "Circle":
				return new GFAAnnotCircle(base, this.baseObject, keyName);
			case "Movie":
				return new GFAAnnotMovie(base, this.baseObject, keyName);
			case "StrikeOut":
				return new GFAAnnotStrikeOut(base, this.baseObject, keyName);
			case "Highlight":
				return new GFAAnnotHighlight(base, this.baseObject, keyName);
			case "Stamp":
				return new GFAAnnotStamp(base, this.baseObject, keyName);
			case "Screen":
				return new GFAAnnotScreen(base, this.baseObject, keyName);
			case "Ink":
				return new GFAAnnotInk(base, this.baseObject, keyName);
			case "FileAttachment":
				return new GFAAnnotFileAttachment(base, this.baseObject, keyName);
			case "Widget":
				return new GFAAnnotWidget(base, this.baseObject, keyName);
			case "Text":
				return new GFAAnnotText(base, this.baseObject, keyName);
			case "Sound":
				return new GFAAnnotSound(base, this.baseObject, keyName);
			case "Redact":
				return new GFAAnnotRedact(base, this.baseObject, keyName);
			case "Square":
				return new GFAAnnotSquare(base, this.baseObject, keyName);
			case "FreeText":
				return new GFAAnnotFreeText(base, this.baseObject, keyName);
			case "Line":
				return new GFAAnnotLine(base, this.baseObject, keyName);
			case "PrinterMark":
				return new GFAAnnotPrinterMark(base, this.baseObject, keyName);
			case "3D":
				return new GFAAnnot3D(base, this.baseObject, keyName);
			case "Underline":
				return new GFAAnnotUnderline(base, this.baseObject, keyName);
			case "Popup":
				return new GFAAnnotPopup(base, this.baseObject, keyName);
			case "Polygon":
				return new GFAAnnotPolygon(base, this.baseObject, keyName);
			case "Watermark":
				return new GFAAnnotWatermark(base, this.baseObject, keyName);
			case "Link":
				return new GFAAnnotLink(base, this.baseObject, keyName);
			case "Caret":
				return new GFAAnnotCaret(base, this.baseObject, keyName);
			case "Squiggly":
				return new GFAAnnotSquiggly(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<org.verapdf.model.baselayer.Object> getParent2_0() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Parent"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getParentDictionary2_0(object.getDirectBase(), "Parent");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getParentDictionary2_0(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("Subtype"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue) {
			case "Highlight":
				return new GFAAnnotHighlight(base, this.baseObject, keyName);
			case "Screen":
				return new GFAAnnotScreen(base, this.baseObject, keyName);
			case "Ink":
				return new GFAAnnotInk(base, this.baseObject, keyName);
			case "FileAttachment":
				return new GFAAnnotFileAttachment(base, this.baseObject, keyName);
			case "Widget":
				return new GFAAnnotWidget(base, this.baseObject, keyName);
			case "Projection":
				return new GFAAnnotProjection(base, this.baseObject, keyName);
			case "Underline":
				return new GFAAnnotUnderline(base, this.baseObject, keyName);
			case "Popup":
				return new GFAAnnotPopup(base, this.baseObject, keyName);
			case "Polygon":
				return new GFAAnnotPolygon(base, this.baseObject, keyName);
			case "Circle":
				return new GFAAnnotCircle(base, this.baseObject, keyName);
			case "Movie":
				return new GFAAnnotMovie(base, this.baseObject, keyName);
			case "StrikeOut":
				return new GFAAnnotStrikeOut(base, this.baseObject, keyName);
			case "Stamp":
				return new GFAAnnotStamp(base, this.baseObject, keyName);
			case "Text":
				return new GFAAnnotText(base, this.baseObject, keyName);
			case "Sound":
				return new GFAAnnotSound(base, this.baseObject, keyName);
			case "Redact":
				return new GFAAnnotRedact(base, this.baseObject, keyName);
			case "Square":
				return new GFAAnnotSquare(base, this.baseObject, keyName);
			case "FreeText":
				return new GFAAnnotFreeText(base, this.baseObject, keyName);
			case "Line":
				return new GFAAnnotLine(base, this.baseObject, keyName);
			case "PrinterMark":
				return new GFAAnnotPrinterMark(base, this.baseObject, keyName);
			case "3D":
				return new GFAAnnot3D(base, this.baseObject, keyName);
			case "RichMedia":
				return new GFAAnnotRichMedia(base, this.baseObject, keyName);
			case "Watermark":
				return new GFAAnnotWatermark(base, this.baseObject, keyName);
			case "Link":
				return new GFAAnnotLink(base, this.baseObject, keyName);
			case "Caret":
				return new GFAAnnotCaret(base, this.baseObject, keyName);
			case "Squiggly":
				return new GFAAnnotSquiggly(base, this.baseObject, keyName);
			default:
				return null;
		}
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
		COSObject object = getAFValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getAFHasTypeDictionary() {
		COSObject object = getAFValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsAP() {
		return this.baseObject.knownKey(ASAtom.getASAtom("AP"));
	}

	public COSObject getAPValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AP"));
		return object;
	}

	@Override
	public Boolean getAPHasTypeDictionary() {
		COSObject object = getAPValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsAS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("AS"));
	}

	public COSObject getASValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AS"));
		return object;
	}

	@Override
	public Boolean getASHasTypeName() {
		COSObject object = getASValue();
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public Boolean getcontainsBM() {
		return this.baseObject.knownKey(ASAtom.getASAtom("BM"));
	}

	public COSObject getBMDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return COSName.construct("Normal");
		}
		return null;
	}

	public COSObject getBMValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BM"));
		if (object == null || object.empty()) {
			object = getBMDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getBMHasTypeName() {
		COSObject object = getBMValue();
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getBMNameValue() {
		COSObject object = getBMValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	@Override
	public Boolean getcontainsBorder() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Border"));
	}

	public COSObject getBorderValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Border"));
		return object;
	}

	@Override
	public Boolean getBorderHasTypeArray() {
		COSObject object = getBorderValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsC() {
		return this.baseObject.knownKey(ASAtom.getASAtom("C"));
	}

	public COSObject getCValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("C"));
		return object;
	}

	@Override
	public Boolean getCHasTypeArray() {
		COSObject object = getCValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsCA() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CA"));
	}

	public COSObject getCADefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return COSReal.construct(1.0D);
		}
		return null;
	}

	public COSObject getCAValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CA"));
		if (object == null || object.empty()) {
			object = getCADefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getCAHasTypeNumber() {
		COSObject object = getCAValue();
		return object != null && object.getType().isNumber();
	}

	@Override
	public Double getCANumberValue() {
		COSObject object = getCAValue();
		if (object != null && object.getType().isNumber()) {
			return object.getReal();
		}
		return null;
	}

	@Override
	public Boolean getcontainsContents() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Contents"));
	}

	public COSObject getContentsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Contents"));
		return object;
	}

	@Override
	public Boolean getContentsHasTypeStringText() {
		COSObject object = getContentsValue();
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsF() {
		return this.baseObject.knownKey(ASAtom.getASAtom("F"));
	}

	public COSObject getFDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSInteger.construct(0L);
		}
		return null;
	}

	public COSObject getFValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("F"));
		if (object == null || object.empty()) {
			object = getFDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getFHasTypeBitmask() {
		COSObject object = getFValue();
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getFBitmaskValue() {
		COSObject object = getFValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	@Override
	public Boolean getcontainsLang() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Lang"));
	}

	public COSObject getLangValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Lang"));
		return object;
	}

	@Override
	public Boolean getLangHasTypeStringText() {
		COSObject object = getLangValue();
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsM() {
		return this.baseObject.knownKey(ASAtom.getASAtom("M"));
	}

	public COSObject getMValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("M"));
		return object;
	}

	@Override
	public Boolean getMHasTypeDate() {
		COSObject object = getMValue();
		return object != null && object.getType() == COSObjType.COS_STRING && object.getString().matches(GFAObject.PDF_DATE_FORMAT_REGEX);
	}

	@Override
	public Boolean getMHasTypeStringText() {
		COSObject object = getMValue();
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsNM() {
		return this.baseObject.knownKey(ASAtom.getASAtom("NM"));
	}

	public COSObject getNMValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("NM"));
		return object;
	}

	@Override
	public Boolean getNMHasTypeStringText() {
		COSObject object = getNMValue();
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
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
		COSObject object = getOCValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsOpen() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Open"));
	}

	public COSObject getOpenDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSBoolean.construct(false);
		}
		return null;
	}

	public COSObject getOpenValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Open"));
		if (object == null || object.empty()) {
			object = getOpenDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getOpenHasTypeBoolean() {
		COSObject object = getOpenValue();
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getcontainsP() {
		return this.baseObject.knownKey(ASAtom.getASAtom("P"));
	}

	public COSObject getPValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("P"));
		return object;
	}

	@Override
	public Boolean getisPIndirect() {
		COSObject object = getPValue();
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getPHasTypeDictionary() {
		COSObject object = getPValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsParent() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Parent"));
	}

	public COSObject getParentValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Parent"));
		return object;
	}

	@Override
	public Boolean getParentHasTypeDictionary() {
		COSObject object = getParentValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsRect() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Rect"));
	}

	public COSObject getRectValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Rect"));
		return object;
	}

	@Override
	public Boolean getRectHasTypeRectangle() {
		COSObject object = getRectValue();
		if (object == null || object.getType() != COSObjType.COS_ARRAY || object.size() != 4) {
			return false;
		}
		for (COSObject elem : (COSArray)object.getDirectBase()) {
			if (elem == null || (elem.getType() != COSObjType.COS_REAL && elem.getType() != COSObjType.COS_INTEGER)) {
				return false;
			}
		}
		return true;
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
		COSObject object = getStructParentValue();
		return object != null && object.getType() == COSObjType.COS_INTEGER;
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
		COSObject object = getSubtypeValue();
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getSubtypeNameValue() {
		COSObject object = getSubtypeValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
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

	@Override
	public Boolean getcontainsca() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ca"));
	}

	public COSObject getcaDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return COSReal.construct(1.0D);
		}
		return null;
	}

	public COSObject getcaValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ca"));
		if (object == null || object.empty()) {
			object = getcaDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getcaHasTypeNumber() {
		COSObject object = getcaValue();
		return object != null && object.getType().isNumber();
	}

	@Override
	public Double getcaNumberValue() {
		COSObject object = getcaValue();
		if (object != null && object.getType().isNumber()) {
			return object.getReal();
		}
		return null;
	}

	@Override
	public Boolean getcontainsAPNAny() {
		if (this.baseObject == null || !this.baseObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject AP = this.baseObject.getKey(ASAtom.getASAtom("AP"));
		if (AP == null || !AP.getType().isDictionaryBased()) {
			return null;
		}
		COSObject N = AP.getKey(ASAtom.getASAtom("N"));
		return N.getKeySet() != null && !N.getKeySet().isEmpty();
	}

	@Override
	public Boolean getcontainsAPRAny() {
		if (this.baseObject == null || !this.baseObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject AP = this.baseObject.getKey(ASAtom.getASAtom("AP"));
		if (AP == null || !AP.getType().isDictionaryBased()) {
			return null;
		}
		COSObject R = AP.getKey(ASAtom.getASAtom("R"));
		return R.getKeySet() != null && !R.getKeySet().isEmpty();
	}

	@Override
	public Boolean getcontainsAPDAny() {
		if (this.baseObject == null || !this.baseObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject AP = this.baseObject.getKey(ASAtom.getASAtom("AP"));
		if (AP == null || !AP.getType().isDictionaryBased()) {
			return null;
		}
		COSObject D = AP.getKey(ASAtom.getASAtom("D"));
		return D.getKeySet() != null && !D.getKeySet().isEmpty();
	}

}
