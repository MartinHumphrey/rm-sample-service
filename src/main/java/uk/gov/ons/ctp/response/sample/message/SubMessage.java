package uk.gov.ons.ctp.response.sample.message;

public class SubMessage {
  
  
  private String name;

  public SubMessage(String name) {
      this.name = name;
  }

  public void makeCoffee(Object request) {
     System.out.println(String.format("%s making coffee order [%s]", name, request.toString()));
  }

}
