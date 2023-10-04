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

public class GFACertSeedValue extends GFAObject implements ACertSeedValue {

	public GFACertSeedValue(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ACertSeedValue");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Issuer":
				return getIssuer();
			case "KeyUsage":
				return getKeyUsage();
			case "OID":
				return getOID();
			case "SignaturePolicyCommitmentType":
				return getSignaturePolicyCommitmentType();
			case "Subject":
				return getSubject();
			case "SubjectDN":
				return getSubjectDN();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOfStringsByte> getIssuer() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getIssuer1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfStringsByte> getIssuer1_5() {
		COSObject object = getIssuerValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfStringsByte> list = new ArrayList<>(1);
			list.add(new GFAArrayOfStringsByte((COSArray)object.getDirectBase(), this.baseObject, "Issuer"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfStringsASCII> getKeyUsage() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getKeyUsage1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfStringsASCII> getKeyUsage1_7() {
		COSObject object = getKeyUsageValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfStringsASCII> list = new ArrayList<>(1);
			list.add(new GFAArrayOfStringsASCII((COSArray)object.getDirectBase(), this.baseObject, "KeyUsage"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfStringsByte> getOID() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getOID1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfStringsByte> getOID1_5() {
		COSObject object = getOIDValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfStringsByte> list = new ArrayList<>(1);
			list.add(new GFAArrayOfStringsByte((COSArray)object.getDirectBase(), this.baseObject, "OID"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfStringsASCII> getSignaturePolicyCommitmentType() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getSignaturePolicyCommitmentType2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfStringsASCII> getSignaturePolicyCommitmentType2_0() {
		COSObject object = getSignaturePolicyCommitmentTypeValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfStringsASCII> list = new ArrayList<>(1);
			list.add(new GFAArrayOfStringsASCII((COSArray)object.getDirectBase(), this.baseObject, "SignaturePolicyCommitmentType"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfStringsByte> getSubject() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getSubject1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfStringsByte> getSubject1_5() {
		COSObject object = getSubjectValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfStringsByte> list = new ArrayList<>(1);
			list.add(new GFAArrayOfStringsByte((COSArray)object.getDirectBase(), this.baseObject, "Subject"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfSubjectDN> getSubjectDN() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getSubjectDN1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfSubjectDN> getSubjectDN1_7() {
		COSObject object = getSubjectDNValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfSubjectDN> list = new ArrayList<>(1);
			list.add(new GFAArrayOfSubjectDN((COSArray)object.getDirectBase(), this.baseObject, "SubjectDN"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsFf() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Ff"));
	}

	public COSObject getFfDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSInteger.construct(0L);
		}
		return null;
	}

	public COSObject getFfValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Ff"));
		if (object == null || object.empty()) {
			object = getFfDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getFfHasTypeBitmask() {
		COSObject Ff = getFfValue();
		return getHasTypeBitmask(Ff);
	}

	@Override
	public Long getFfBitmaskValue() {
		COSObject Ff = getFfValue();
		return getBitmaskValue(Ff);
	}

	@Override
	public Boolean getcontainsIssuer() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Issuer"));
	}

	public COSObject getIssuerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Issuer"));
		return object;
	}

	@Override
	public Boolean getIssuerHasTypeArray() {
		COSObject Issuer = getIssuerValue();
		return getHasTypeArray(Issuer);
	}

	@Override
	public Boolean getcontainsKeyUsage() {
		return this.baseObject.knownKey(ASAtom.getASAtom("KeyUsage"));
	}

	public COSObject getKeyUsageValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("KeyUsage"));
		return object;
	}

	@Override
	public Boolean getKeyUsageHasTypeArray() {
		COSObject KeyUsage = getKeyUsageValue();
		return getHasTypeArray(KeyUsage);
	}

	@Override
	public Boolean getcontainsOID() {
		return this.baseObject.knownKey(ASAtom.getASAtom("OID"));
	}

	public COSObject getOIDValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OID"));
		return object;
	}

	@Override
	public Boolean getOIDHasTypeArray() {
		COSObject OID = getOIDValue();
		return getHasTypeArray(OID);
	}

	@Override
	public Boolean getcontainsSignaturePolicyCommitmentType() {
		return this.baseObject.knownKey(ASAtom.getASAtom("SignaturePolicyCommitmentType"));
	}

	public COSObject getSignaturePolicyCommitmentTypeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SignaturePolicyCommitmentType"));
		return object;
	}

	@Override
	public Boolean getSignaturePolicyCommitmentTypeHasTypeArray() {
		COSObject SignaturePolicyCommitmentType = getSignaturePolicyCommitmentTypeValue();
		return getHasTypeArray(SignaturePolicyCommitmentType);
	}

	@Override
	public Boolean getcontainsSignaturePolicyHashAlgorithm() {
		return this.baseObject.knownKey(ASAtom.getASAtom("SignaturePolicyHashAlgorithm"));
	}

	public COSObject getSignaturePolicyHashAlgorithmValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SignaturePolicyHashAlgorithm"));
		return object;
	}

	@Override
	public Boolean getSignaturePolicyHashAlgorithmHasTypeName() {
		COSObject SignaturePolicyHashAlgorithm = getSignaturePolicyHashAlgorithmValue();
		return getHasTypeName(SignaturePolicyHashAlgorithm);
	}

	@Override
	public String getSignaturePolicyHashAlgorithmNameValue() {
		COSObject SignaturePolicyHashAlgorithm = getSignaturePolicyHashAlgorithmValue();
		return getNameValue(SignaturePolicyHashAlgorithm);
	}

	@Override
	public Boolean getcontainsSignaturePolicyHashValue() {
		return this.baseObject.knownKey(ASAtom.getASAtom("SignaturePolicyHashValue"));
	}

	public COSObject getSignaturePolicyHashValueValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SignaturePolicyHashValue"));
		return object;
	}

	@Override
	public Boolean getSignaturePolicyHashValueHasTypeString() {
		COSObject SignaturePolicyHashValue = getSignaturePolicyHashValueValue();
		return getHasTypeString(SignaturePolicyHashValue);
	}

	@Override
	public Boolean getcontainsSignaturePolicyOID() {
		return this.baseObject.knownKey(ASAtom.getASAtom("SignaturePolicyOID"));
	}

	public COSObject getSignaturePolicyOIDValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SignaturePolicyOID"));
		return object;
	}

	@Override
	public Boolean getSignaturePolicyOIDHasTypeStringAscii() {
		COSObject SignaturePolicyOID = getSignaturePolicyOIDValue();
		return getHasTypeStringAscii(SignaturePolicyOID);
	}

	@Override
	public Boolean getcontainsSubject() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Subject"));
	}

	public COSObject getSubjectValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Subject"));
		return object;
	}

	@Override
	public Boolean getSubjectHasTypeArray() {
		COSObject Subject = getSubjectValue();
		return getHasTypeArray(Subject);
	}

	@Override
	public Boolean getcontainsSubjectDN() {
		return this.baseObject.knownKey(ASAtom.getASAtom("SubjectDN"));
	}

	public COSObject getSubjectDNValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SubjectDN"));
		return object;
	}

	@Override
	public Boolean getSubjectDNHasTypeArray() {
		COSObject SubjectDN = getSubjectDNValue();
		return getHasTypeArray(SubjectDN);
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
		COSObject Type = getTypeValue();
		return getHasTypeName(Type);
	}

	@Override
	public String getTypeNameValue() {
		COSObject Type = getTypeValue();
		return getNameValue(Type);
	}

	@Override
	public Boolean getcontainsURL() {
		return this.baseObject.knownKey(ASAtom.getASAtom("URL"));
	}

	public COSObject getURLValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("URL"));
		return object;
	}

	@Override
	public Boolean getURLHasTypeStringAscii() {
		COSObject URL = getURLValue();
		return getHasTypeStringAscii(URL);
	}

	@Override
	public Boolean getcontainsURLType() {
		return this.baseObject.knownKey(ASAtom.getASAtom("URLType"));
	}

	public COSObject getURLTypeDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("Browser");
		}
		return null;
	}

	public COSObject getURLTypeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("URLType"));
		if (object == null || object.empty()) {
			object = getURLTypeDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getURLTypeHasTypeName() {
		COSObject URLType = getURLTypeValue();
		return getHasTypeName(URLType);
	}

	@Override
	public String getURLTypeNameValue() {
		COSObject URLType = getURLTypeValue();
		return getNameValue(URLType);
	}

}
