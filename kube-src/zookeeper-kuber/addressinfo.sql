-- Table: gnaf_home.address_info

-- DROP TABLE gnaf_home.address_info;

CREATE TABLE gnaf_home.address_info
(
    address_detail_pid character varying(15) COLLATE pg_catalog."default",
    street_locality_pid character varying(15) COLLATE pg_catalog."default",
    locality_pid character varying(15) COLLATE pg_catalog."default",
    building_name character varying(200) COLLATE pg_catalog."default",
    lot_number_prefix character varying(2) COLLATE pg_catalog."default",
    lot_number character varying(5) COLLATE pg_catalog."default",
    lot_number_suffix character varying(2) COLLATE pg_catalog."default",
    flat_type character varying(50) COLLATE pg_catalog."default",
    flat_number_prefix character varying(2) COLLATE pg_catalog."default",
    flat_number numeric(5,0),
    flat_number_suffix character varying(2) COLLATE pg_catalog."default",
    level_type character varying(50) COLLATE pg_catalog."default",
    level_number_prefix character varying(2) COLLATE pg_catalog."default",
    level_number numeric(3,0),
    level_number_suffix character varying(2) COLLATE pg_catalog."default",
    number_first_prefix character varying(3) COLLATE pg_catalog."default",
    number_first numeric(6,0),
    number_first_suffix character varying(2) COLLATE pg_catalog."default",
    number_last_prefix character varying(3) COLLATE pg_catalog."default",
    number_last numeric(6,0),
    number_last_suffix character varying(2) COLLATE pg_catalog."default",
    street_name character varying(100) COLLATE pg_catalog."default",
    street_class_code character(1) COLLATE pg_catalog."default",
    street_class_type character varying(50) COLLATE pg_catalog."default",
    street_type_code character varying(15) COLLATE pg_catalog."default",
    street_suffix_code character varying(15) COLLATE pg_catalog."default",
    street_suffix_type character varying(50) COLLATE pg_catalog."default",
    locality_name character varying(100) COLLATE pg_catalog."default",
    state_abbreviation character varying(3) COLLATE pg_catalog."default",
    postcode character varying(4) COLLATE pg_catalog."default",
    latitude numeric(10,8),
    longitude numeric(11,8),
    geocode_type character varying(50) COLLATE pg_catalog."default",
    confidence numeric(1,0),
    alias_principal character(1) COLLATE pg_catalog."default",
    primary_secondary character varying(1) COLLATE pg_catalog."default",
    legal_parcel_id character varying(20) COLLATE pg_catalog."default",
    date_created date,
	CONSTRAINT address_info_pk PRIMARY KEY (address_detail_pid)
)

TABLESPACE pg_default;

ALTER TABLE gnaf_home.address_info
    OWNER to postgres;
	
insert into address_info

 SELECT ad.address_detail_pid,
    ad.street_locality_pid,
    ad.locality_pid,
    ad.building_name,
    ad.lot_number_prefix,
    ad.lot_number,
    ad.lot_number_suffix,
    fta.name AS flat_type,
    ad.flat_number_prefix,
    ad.flat_number,
    ad.flat_number_suffix,
    lta.name AS level_type,
    ad.level_number_prefix,
    ad.level_number,
    ad.level_number_suffix,
    ad.number_first_prefix,
    ad.number_first,
    ad.number_first_suffix,
    ad.number_last_prefix,
    ad.number_last,
    ad.number_last_suffix,
    sl.street_name,
    sl.street_class_code,
    sca.name AS street_class_type,
    sl.street_type_code,
    sl.street_suffix_code,
    ssa.name AS street_suffix_type,
    l.locality_name,
    st.state_abbreviation,
    ad.postcode,
    adg.latitude,
    adg.longitude,
    gta.name AS geocode_type,
    ad.confidence,
    ad.alias_principal,
    ad.primary_secondary,
    ad.legal_parcel_id,
    ad.date_created
   FROM gnaf_home.address_detail ad
     LEFT JOIN gnaf_home.flat_type_aut fta ON ad.flat_type_code::text = fta.code::text
     LEFT JOIN gnaf_home.level_type_aut lta ON ad.level_type_code::text = lta.code::text
     JOIN gnaf_home.street_locality sl ON ad.street_locality_pid::text = sl.street_locality_pid::text
     LEFT JOIN gnaf_home.street_suffix_aut ssa ON sl.street_suffix_code::text = ssa.code::text
     LEFT JOIN gnaf_home.street_class_aut sca ON sl.street_class_code = sca.code
     LEFT JOIN gnaf_home.street_type_aut sta ON sl.street_type_code::text = sta.code::text
     JOIN gnaf_home.locality l ON ad.locality_pid::text = l.locality_pid::text
     JOIN gnaf_home.address_default_geocode adg ON ad.address_detail_pid::text = adg.address_detail_pid::text
     LEFT JOIN gnaf_home.geocode_type_aut gta ON adg.geocode_type_code::text = gta.code::text
     LEFT JOIN gnaf_home.geocoded_level_type_aut glta ON ad.level_geocoded_code = glta.code
     JOIN gnaf_home.state st ON l.state_pid::text = st.state_pid::text
  WHERE 
  ad.confidence > '-1'::integer::numeric
  AND ad.date_retired IS NULL 
  AND (ad.primary_secondary IS NULL OR ad.primary_secondary::text = 'S'::text) 
  AND ad.alias_principal = 'P'::bpchar; 
  
  
