package it.seda.security.sign.out;

import it.seda.security.cas.CASParametersURL;
import it.seda.security.domain.Ticket;
import it.seda.security.persistence.ManagerMapper;
import it.seda.security.service.ManagerService;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogoutUtils {
	
	
	
	private static  final Logger logger = LoggerFactory.getLogger(LogoutUtils.class);
	private static String ID_TICKET=CASParametersURL.ID_TICKET.getParameterName();
	
	@Autowired  ManagerMapper managerMapper;
	//@Autowired  ManagerService managerService;
	final static String CAS_LOGOUT_URL="j_spring_security_cas_logout";
	
	public  boolean performCASLogout(List<Ticket>  ticketsList){
		if(ticketsList==null||ticketsList.size()==0){
			logger.debug("No tickets available for log out ....");
			return false;
		}
		for (Ticket ticket : ticketsList) {
			try{
			sendLogoutMessage(ticket);
			}catch(Exception e){
				logger.debug("Errors while sending log out request for ticket "+ticket);
				logger.debug(e.getMessage());
				
			}
			
		}
		return true;
	}
	
	public   void sendLogoutMessage(Ticket ticket) throws Exception{
		String ticketId=ticket.getChiavePrimariaDellaTabellaDeiTicket();
		String url=managerMapper.getURLbackByTicket(ticket);
		url=url.concat("/").concat(CAS_LOGOUT_URL);
		sendPost(url,ticketId);
		
	}
	

	
	public static void sendPost(String url,String ticketId) throws Exception {
	 
			
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	 
			//add reuqest header
			con.setRequestMethod("POST");
			con.setRequestProperty("User-Agent", "SEDA_CAS");
			con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
	 
			String urlParameters = ID_TICKET.concat("=").concat(ticketId);
	 
			// Send post request
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();
	 
			int responseCode = con.getResponseCode();
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
	 
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

		}
	 


}
