package au.com.mqas.loader.solr.domain;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@SolrDocument(collection = "locCollection")
public class SolrAddressInfo {

	@Id
	private String id;

	@Field("_version_")
	private String version;

	@Field("_root_")
	private String root;

	@Field("_nest_path_")
	private String nestPath;

	@Field("_text_")
	private String text;

	@Field("address_detail_pid")
	private String addressDetailPid;

	@Field("street_locality_pid")
	private String streetLocalityPid;

	@Field("locality_pid")
	private String localityPid;

	@Field("building_name")
	private String buildingName;

	@Field("lot_number_prefix")
	private String lotNumberPrefix;

	@Field("lot_number")
	private String lotNumber;

	@Field("lot_number_suffix")
	private String lotNumberSuffix;

	@Field("flat_type")
	private String flatType;

	@Field("flat_number_prefix")
	private String flatNumberPrefix;

	@Field("flat_number")
	private String flatNumber;

	@Field("flat_number_suffix")
	private String flatNumberSuffix;

	@Field("level_type")
	private String levelType;

	@Field("level_number_prefix")
	private String levelNumberPrefix;

	@Field("level_number")
	private String levelNumber;

	@Field("level_number_suffix")
	private String levelNumberSuffix;

	@Field("number_first_prefix")
	private String numberFirstPrefix;

	@Field("number_first")
	private String numberFirst;

	@Field("number_first_suffix")
	private String numberFirstSuffix;

	@Field("number_last_prefix")
	private String numberLastPrefix;

	@Field("number_last")
	private String numberLast;

	@Field("number_last_suffix")
	private String numberLastSuffix;

	@Field("street_name")
	private String streetName;

	@Field("street_class_code")
	private String streetClassCode;

	@Field("street_class_type")
	private String streetClassType;

	@Field("street_type_code")
	private String streetTypeCode;

	@Field("street_suffix_code")
	private String streetSuffixCode;

	@Field("street_suffix_type")
	private String streetSuffixType;

	@Field("locality_name")
	private String localityName;

	@Field("state_abbreviation")
	private String stateAbbreviation;

	private String postcode;

	private String latitude;

	private String longitude;

	@Field("geocodeType")
	private String geocode_type;

	private String confidence;

	@Field("alias_principal")
	private String aliasPrincipal;

	@Field("primary_secondary")
	private String primarySecondary;

	@Field("legal_parcel_id")
	private String legalParcelId;

}
