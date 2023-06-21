package org.verapdf.gf.model.impl.arlington;

import org.verapdf.cos.*;
import org.verapdf.model.alayer.*;
import org.verapdf.model.GenericModelObject;
import org.verapdf.pd.PDDocument;
import org.verapdf.pd.PDCatalog;
import org.verapdf.pd.PDNamesDictionary;
import org.verapdf.tools.StaticResources;
import java.util.*;
import org.verapdf.pd.PDNameTreeNode;
import org.verapdf.as.ASAtom;
import java.util.stream.Collectors;

public class GFAObject extends GenericModelObject implements AObject {

	private final static List<String> standardFonts = new LinkedList<>();
	private static final ThreadLocal<Set<COSKey>> keysSet = new ThreadLocal<>();
	protected static final String PDF_DATE_FORMAT_REGEX = "(D:)?(\\d\\d){2,7}(([Z+-]\\d\\d'(\\d\\d'?)?)?|Z)";
	protected final COSBase baseObject;
	protected COSBase parentObject;
	protected String keyName;

	public GFAObject(COSBase baseObject, COSBase parentObject, String objectType) {
		super(objectType);
		this.baseObject = baseObject;
		this.parentObject = parentObject;
	}

	public GFAObject(COSBase baseObject, COSBase parentObject, String keyName, String objectType) {
		this(baseObject, parentObject, objectType);
		this.keyName = keyName;
	}

	@Override
	public String getID() {
		COSKey key = baseObject.getObjectKey();
		return key != null ? (getObjectType() + " " + key.toString()) : null;
	}

	@Override
	public String getExtraContext() {
		return keyName == null || keyName.isEmpty() ? null : keyName;
	}

	@Override
	public Long getsize() {
		return (long)baseObject.size();
	}

	@Override
	public String getkeyName() {
		return this.keyName;
	}

	@Override
	public String getkeysString() {
		return getkeysString(new COSObject(this.baseObject));
	}

	@Override
	public Long getnumberOfPages() {
		return (long) StaticResources.getDocument().getPages().size();
	}

	@Override
	public Long getfileSize() {
		return StaticResources.getDocument().getDocument().getFileSize();
	}

	@Override
	public Boolean getisPDFTagged() {
		PDDocument document = StaticResources.getDocument();
		PDCatalog catalog = document.getCatalog();
		if (catalog == null) {
			return false;
		}
		COSObject markInfoObject = catalog.getKey(ASAtom.MARK_INFO);
		if (markInfoObject == null || markInfoObject.empty()) {
			return false;
		}
		COSBase markInfo = markInfoObject.getDirectBase();
		if (markInfo.getType() == COSObjType.COS_DICT) {
			return Objects.equals(markInfo.getBooleanKey(ASAtom.MARKED), true);
		}
		return false;
	}

	@Override
	public Boolean getnotStandard14Font() {
		COSObject type = baseObject.getKey(ASAtom.TYPE);
		if (type == null || type.getType() != COSObjType.COS_NAME || type.getName() != ASAtom.FONT) {
			return false;
		}
		COSObject subtype = baseObject.getKey(ASAtom.SUBTYPE);
		if (subtype == null || subtype.getType() != COSObjType.COS_NAME || subtype.getName() != ASAtom.TYPE1) {
			return false;
		}
		COSObject baseFont = baseObject.getKey(ASAtom.BASE_FONT);
		if (baseFont == null || baseFont.getType() != COSObjType.COS_NAME) {
			return true;
		}
		return !standardFonts.contains(baseFont.getString());
	}

	public static Double getRectHeight(COSObject object) {
		if (object == null || object.getType() != COSObjType.COS_ARRAY || object.size() != 4) {
			return null;
		}
		COSObject bottom = object.at(1);
		COSObject top = object.at(3);
		if (bottom == null || (bottom.getType() != COSObjType.COS_INTEGER && bottom.getType() != COSObjType.COS_REAL)) {
			return null;
		}
		if (top == null || (top.getType() != COSObjType.COS_INTEGER && top.getType() != COSObjType.COS_REAL)) {
			return null;
		}
		return top.getReal() - bottom.getReal();
	}

	public static Double getRectWidth(COSObject object) {
		if (object == null || object.getType() != COSObjType.COS_ARRAY || object.size() != 4) {
			return null;
		}
		COSObject left = object.at(0);
		COSObject right = object.at(2);
		if (left == null || (left.getType() != COSObjType.COS_INTEGER && left.getType() != COSObjType.COS_REAL)) {
			return null;
		}
		if (right == null || (right.getType() != COSObjType.COS_INTEGER && right.getType() != COSObjType.COS_REAL)) {
			return null;
		}
		return right.getReal() - left.getReal();
	}

	public static Boolean getisIndirect(COSObject object) {
		return object != null && object.get() != null && object.get().isIndirect();
	}

	public static Long getArraySize(COSObject object) {
		if (object != null && object.getType() == COSObjType.COS_ARRAY) {
			return (long) object.size();
		}
		return null;
	}

	public static Boolean getisArraySortAscending(COSObject object, int number) {
		if (object == null || object.getType() != COSObjType.COS_ARRAY) {
			return false;
		}
		Long previousNumber = null;
		for (int i = 0; i < object.size(); i += number) {
			COSObject elem = object.at(i);
			if (elem == null || elem.getType() != COSObjType.COS_INTEGER) {
				return false;
			}
			if (previousNumber != null && previousNumber > elem.getInteger()) {
				return false;
			}
			previousNumber = elem.getInteger();
		}
		return true;
	}

	public static String getkeysString(COSObject object) {
		return object.getKeySet().stream()
				.map(ASAtom::getValue)
				.collect(Collectors.joining("&"));
	}

	@Override
	public Boolean getisEncryptedWrapper() {
		PDDocument document = StaticResources.getDocument();
		if (document == null) {
			return false;
		}
		PDCatalog catalog = document.getCatalog();
		if (catalog == null) {
			return false;
		}
		PDNamesDictionary names = catalog.getNamesDictionary();
		if (names == null) {
			return false;
		}
		PDNameTreeNode embeddedFiles = names.getEmbeddedFiles();
		if (embeddedFiles == null) {
			return false;
		}
		for (COSObject embeddedFile : embeddedFiles) {
			COSObject relationship = embeddedFile.getKey(ASAtom.AF_RELATIONSHIP);
			if (relationship != null && relationship.getType() == COSObjType.COS_NAME &&
					relationship.getName() == ASAtom.getASAtom("EncryptedPayload")) {
				return true;
			}
		}
		return false;
	}

	public static Boolean hasCycle(COSObject object, ASAtom entryName) {
		if (object == null) {
			return false;
		}
		Set<COSKey> visitedKeys = new HashSet<>();
		while (object.knownKey(entryName)) {
			if (object.getKey() != null) {
				if (visitedKeys.contains(object.getKey())) {
					return true;
				}
				visitedKeys.add(object.getKey());
			}
			object = object.getKey(entryName);
		}
		return false;
	}

	protected static COSObject getPageObject(COSObject object) {
		Long pageNumber = null;
		if (object != null && object.getType() == COSObjType.COS_STRING) {
			PDNamesDictionary names = StaticResources.getDocument().getCatalog().getNamesDictionary();
			if (names == null) {
				return null;
			}
			PDNameTreeNode dests = names.getDests();
			if (dests == null) {
				return null;
			}
			object = dests.getObject(object.getString());
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			pageNumber = object.getInteger();
		}
		if (pageNumber == null || pageNumber >= StaticResources.getDocument().getPages().size()) {
			return null;
		}
		return StaticResources.getDocument().getPages().get(pageNumber.intValue()).getObject();
	}

	public static Boolean getHasTypeArray(COSObject object) {
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	public static Boolean getHasTypeBitmask(COSObject object) {
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	public static Boolean getHasTypeBoolean(COSObject object) {
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	public static Boolean getHasTypeDate(COSObject object) {
		return object != null && object.getType() == COSObjType.COS_STRING && object.getString().matches(PDF_DATE_FORMAT_REGEX);
	}

	public static Boolean getHasTypeDictionary(COSObject object) {
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	public static Boolean getHasTypeInteger(COSObject object) {
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	public static Boolean getHasTypeMatrix(COSObject object) {
		if (object == null || object.getType() != COSObjType.COS_ARRAY || object.size() != 6) {
			return false;
		}
		for (COSObject elem : (COSArray)object.getDirectBase()) {
			if (elem == null || (elem.getType() != COSObjType.COS_REAL && elem.getType() != COSObjType.COS_INTEGER)) {
				return false;
			}
		}
		return true;
	}

	public static Boolean getHasTypeName(COSObject object) {
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	public static Boolean getHasTypeNameTree(COSObject object) {
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	public static Boolean getHasTypeNull(COSObject object) {
		return object != null && object.getType() == COSObjType.COS_NULL;
	}

	public static Boolean getHasTypeNumber(COSObject object) {
		return object != null && object.getType().isNumber();
	}

	public static Boolean getHasTypeNumberTree(COSObject object) {
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	public static Boolean getHasTypeRectangle(COSObject object) {
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

	public static Boolean getHasTypeStream(COSObject object) {
		return object != null && object.getType() == COSObjType.COS_STREAM;
	}

	public static Boolean getHasTypeString(COSObject object) {
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

	public static Boolean getHasTypeStringAscii(COSObject object) {
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isASCIIString();
	}

	public static Boolean getHasTypeStringByte(COSObject object) {
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

	public static Boolean getHasTypeStringText(COSObject object) {
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	public static Set<COSKey> getKeysSet() {
		if (keysSet.get() == null) {
			keysSet.set(new HashSet<>());
		}
		return keysSet.get();
	}

	public static void setKeysSet(Set<COSKey> keysSet) {
		GFAObject.keysSet.set(keysSet);
	}

	public static void clearAllContainers() {
		keysSet.set(new HashSet<>());
	}

	static {
		standardFonts.add("Times-Roman");
		standardFonts.add("Helvetica");
		standardFonts.add("Courier");
		standardFonts.add("Symbol");
		standardFonts.add("Times-Bold");
		standardFonts.add("Helvetica-Bold");
		standardFonts.add("Courier-Bold");
		standardFonts.add("ZapfDingbats");
		standardFonts.add("Times-Italic");
		standardFonts.add("Helvetica-Oblique");
		standardFonts.add("Courier-Oblique");
		standardFonts.add("Times-BoldItalic");
		standardFonts.add("Helvetica-BoldOblique");
		standardFonts.add("Courier-BoldOblique");
	}

}

