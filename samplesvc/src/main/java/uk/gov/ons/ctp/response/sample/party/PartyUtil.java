package uk.gov.ons.ctp.response.sample.party;

import uk.gov.ons.ctp.response.party.definition.Party;
import uk.gov.ons.ctp.response.party.definition.PartyAttributeMap;
import uk.gov.ons.ctp.response.party.representation.PartyCreationRequestDTO;
import uk.gov.ons.ctp.response.sample.definition.SampleUnitBase;
import uk.gov.ons.ctp.response.sample.xml.JaxbAnnotatedTypeUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Util for the Party Service
 */
public class PartyUtil {

  /**
   * Util method to convert from any of the SampleUnitBase subtypes to the Generic PartyService Party type.
   * All fields other than identity fields will be collected into a key:value map in Party.attributes.
   * @param unit the SampleUnitBase subtype for a Census, Business or Social SampleUnit
   * @return the created Party object
   * @throws Exception unlikely, but indicated something really wrong
   */
  public static Party convertToParty(SampleUnitBase unit) throws Exception {
    Party p = new Party();
    p.setSampleUnitType(unit.getSampleUnitType());
    p.setSampleUnitRef(unit.getSampleUnitRef());

    PartyAttributeMap partyAttribs = new PartyAttributeMap();
    partyAttribs.putAll(JaxbAnnotatedTypeUtil.extractXmlProperties(unit));
    p.setAttributes(partyAttribs);
    return p;
  }

  public static PartyCreationRequestDTO createPartyCreationRequestDTO(Party party){
    PartyCreationRequestDTO partyCreationRequestDTO = new PartyCreationRequestDTO();
    partyCreationRequestDTO.setSampleUnitRef(party.getSampleUnitRef());
    partyCreationRequestDTO.setSampleUnitType(party.getSampleUnitType());
    Map<String, String> attMap = new HashMap<>();
    attMap.putAll(party.getAttributes());
    partyCreationRequestDTO.setAttributes(attMap);

    return partyCreationRequestDTO;
  }
}
