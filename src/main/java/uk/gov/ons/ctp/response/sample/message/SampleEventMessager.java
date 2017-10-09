package uk.gov.ons.ctp.response.sample.message;

/**
 * 
 * Created by Chris hardman 25/09/2017
 *
 */

public interface SampleEventMessager {
    /**
     * send sample to collection exercise queue
     * @param sampleUnit to be sent
     */
  String send(String event);
}
