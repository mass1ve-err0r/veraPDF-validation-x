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

public class GFASignatureBuildPropDict extends GFAObject implements ASignatureBuildPropDict {

	public GFASignatureBuildPropDict(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ASignatureBuildPropDict");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "App":
				return getApp();
			case "Filter":
				return getFilter();
			case "PubSec":
				return getPubSec();
			case "SigQ":
				return getSigQ();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<ASignatureBuildDataAppDict> getApp() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getApp1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<ASignatureBuildDataAppDict> getApp1_5() {
		COSObject object = getAppValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ASignatureBuildDataAppDict> list = new ArrayList<>(1);
			list.add(new GFASignatureBuildDataAppDict((COSDictionary)object.getDirectBase(), this.baseObject, "App"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ASignatureBuildDataDict> getFilter() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getFilter1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<ASignatureBuildDataDict> getFilter1_5() {
		COSObject object = getFilterValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ASignatureBuildDataDict> list = new ArrayList<>(1);
			list.add(new GFASignatureBuildDataDict((COSDictionary)object.getDirectBase(), this.baseObject, "Filter"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ASignatureBuildDataDict> getPubSec() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getPubSec1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<ASignatureBuildDataDict> getPubSec1_5() {
		COSObject object = getPubSecValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ASignatureBuildDataDict> list = new ArrayList<>(1);
			list.add(new GFASignatureBuildDataDict((COSDictionary)object.getDirectBase(), this.baseObject, "PubSec"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ASignatureBuildDataSigQDict> getSigQ() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getSigQ1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<ASignatureBuildDataSigQDict> getSigQ1_5() {
		COSObject object = getSigQValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ASignatureBuildDataSigQDict> list = new ArrayList<>(1);
			list.add(new GFASignatureBuildDataSigQDict((COSDictionary)object.getDirectBase(), this.baseObject, "SigQ"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsApp() {
		return this.baseObject.knownKey(ASAtom.getASAtom("App"));
	}

	public COSObject getAppValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("App"));
		return object;
	}

	@Override
	public Boolean getisAppIndirect() {
		COSObject object = getAppValue();
		return getisIndirect(object);
	}

	@Override
	public Boolean getAppHasTypeDictionary() {
		COSObject object = getAppValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getcontainsFilter() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Filter"));
	}

	public COSObject getFilterValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Filter"));
		return object;
	}

	@Override
	public Boolean getisFilterIndirect() {
		COSObject object = getFilterValue();
		return getisIndirect(object);
	}

	@Override
	public Boolean getFilterHasTypeDictionary() {
		COSObject object = getFilterValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getcontainsPubSec() {
		return this.baseObject.knownKey(ASAtom.getASAtom("PubSec"));
	}

	public COSObject getPubSecValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PubSec"));
		return object;
	}

	@Override
	public Boolean getisPubSecIndirect() {
		COSObject object = getPubSecValue();
		return getisIndirect(object);
	}

	@Override
	public Boolean getPubSecHasTypeDictionary() {
		COSObject object = getPubSecValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getcontainsSigQ() {
		return this.baseObject.knownKey(ASAtom.getASAtom("SigQ"));
	}

	public COSObject getSigQValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SigQ"));
		return object;
	}

	@Override
	public Boolean getisSigQIndirect() {
		COSObject object = getSigQValue();
		return getisIndirect(object);
	}

	@Override
	public Boolean getSigQHasTypeDictionary() {
		COSObject object = getSigQValue();
		return getHasTypeDictionary(object);
	}

}
