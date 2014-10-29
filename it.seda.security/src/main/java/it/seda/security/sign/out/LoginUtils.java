package it.seda.security.sign.out;

import it.seda.security.cas.CASParametersURL;
import it.seda.security.domain.Application;
import it.seda.security.domain.CustomerCodeApplication;
import it.seda.security.domain.Ticket;
import it.seda.security.persistence.ManagerMapper;
import it.seda.security.service.SecurityService;
import it.seda.security.service.TicketService;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginUtils {

	private static String ID_TICKET=CASParametersURL.ID_TICKET.getParameterName();
	
	private static  final Logger logger = LoggerFactory.getLogger(LoginUtils.class);
	
	
	@Autowired  SecurityService securityService;
	@Autowired  TicketService ticketService;
	

	public static int sendGet(String url,String ticketId) throws Exception {
		url=url.concat("?").concat(ID_TICKET+"="+ticketId);
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", "SEDA_CAS");
		int responseCode = con.getResponseCode();
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
 
		return responseCode;
 
	}
	
	
	public void sendLoginRequest(String username,String customerId,List<Application> applicationList){
		String urlBack="";
		CustomerCodeApplication customerCodeApplication = new CustomerCodeApplication(); 
		customerCodeApplication.setCustomerId(customerId);
		Ticket generatedTicket=null;
		int responseCode=0;
		for (Application application : applicationList) {
			customerCodeApplication.setChiavePrimariaDelleApplicazioni(application.getChiavePrimariaDelleApplicazioni());
			urlBack=securityService.findURLBackByCustumerCodeApplication(customerCodeApplication);
			generatedTicket=ticketService.generate(username,customerId,application.getChiavePrimariaDelleApplicazioni());
			try {
				responseCode=sendGet(urlBack,generatedTicket.getChiavePrimariaDellaTabellaDeiTicket());
			} catch (Exception e) {
				logger.error("Login failed for url: "+urlBack+" responseCode:"+responseCode);
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String args[]){
		LoginUtils lgu=new LoginUtils();
		int rc=0;
		try {
			rc=sendGet("http://localhost:8080/it.seda.example.springProject/manager","8c379652-41fa-4e8c-87fa-0a130e10a8ed");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
