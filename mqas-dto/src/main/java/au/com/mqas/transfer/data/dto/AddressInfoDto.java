package au.com.mqas.transfer.data.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressInfoDto {
	private String id;
	private String version;
	private String root;
	private String nestPath;

	private String text;

	private String addressDetailPid;

	private String streetLocalityPid;

	private String localityPid;

	private String buildingName;

	private String lotNumberPrefix;

	private String lotNumber;

	private String lotNumberSuffix;

	private String flatType;

	private String flatNumberPrefix;

	private String flatNumber;

	private String flatNumberSuffix;

	private String levelType;

	private String levelNumberPrefix;

	private String levelNumber;

	private String levelNumberSuffix;

	private String numberFirstPrefix;

	private String numberFirst;

	private String numberFirstSuffix;

	private String numberLastPrefix;

	private String numberLast;

	private String numberLastSuffix;

	private String streetName;

	private String streetClassCode;

	private String streetClassType;

	private String streetTypeCode;

	private String streetSuffixCode;

	private String streetSuffixType;

	private String localityName;

	private String stateAbbreviation;

	private String postcode;

	private String latitude;

	private String longitude;

	private String geocode_type;

	private String confidence;

	private String aliasPrincipal;

	private String primarySecondary;

	private String legalParcelId;

}
