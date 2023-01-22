package api;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


public class SendSMSResource {
    //tryout only deleted later and implemented in OrderResoruce
    public static final String ACCOUNT_SID = System.getenv("AC8cc7955e2ce369ae27a1977f3f784782");
    public static final String AUTH_TOKEN = System.getenv("adcbca6bbfe79d9eed6cc573cd83513e");

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("+4369919083352"),
                new com.twilio.type.PhoneNumber("+15632278282"),
                "Does Twilio from Pick'n'Go work? Maybe.")
                .create();

        System.out.println(message.getSid());
    }



}