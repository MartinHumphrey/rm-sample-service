package uk.gov.ons.ctp.response.party.endpoint;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Qualifier;

import lombok.extern.slf4j.Slf4j;
import uk.gov.ons.ctp.common.endpoint.CTPEndpoint;
import uk.gov.ons.ctp.common.error.CTPException;
import uk.gov.ons.ctp.common.rest.RestClient;
import uk.gov.ons.ctp.response.party.representation.PartyDTO;

/**
 * The Mock REST endpoint controller for Party Service.
 */
@Path("/party")
@Produces({"application/json"})
@Slf4j
public class PartyEndpoint implements CTPEndpoint {

  @Inject
  @Qualifier("sampleServiceClient")
  private RestClient sampleServiceClient;

  /**
   * POST to update state for a specified PartyDTO.
   *
   * @param partyDTO partyDTO to be updated
   * @throws CTPException if update operation fails
   * @return Response PartyDTO that has been updated
   */
  @POST
  @Path("/events")
  public Response createCaseEvent(final PartyDTO partyDTO) throws CTPException {

    log.info(partyDTO.getForename());
    log.info(partyDTO.getPostion() + " / " + partyDTO.getSize());
    log.info(Integer.toString(partyDTO.getSampleId()));
    log.info(Boolean.toString(sampleServiceClient == null));
    if (partyDTO.getPostion() == partyDTO.getSize()) {
      sampleServiceClient.putResource("/samples/" + partyDTO.getSampleId(), partyDTO.getSampleId(), Integer.class);
      return Response.ok(partyDTO).status(Status.OK).build();
    }
    return Response.ok(partyDTO).status(Status.CREATED).build();

  }

  /**
   * GET to retrieve party info
   * @return Response confirmation
   */
  @GET
  @Path("/events")
  public Response up() {
    log.info("party up");
    return Response.ok().status(Status.CREATED).build();

  }

}
