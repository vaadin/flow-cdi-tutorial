package org.vaadin.cdi.tutorial;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import com.vaadin.cdi.CdiVaadinServlet;
import com.vaadin.flow.server.CustomizedSystemMessages;
import com.vaadin.flow.server.SystemMessages;
import com.vaadin.flow.server.SystemMessagesInfo;
import com.vaadin.flow.server.SystemMessagesProvider;

@WebServlet(urlPatterns = {"/*","/frontend/*"}, asyncSupported = true)
public class MyServlet extends CdiVaadinServlet {

    @Override
    protected void servletInitialized() throws ServletException
    {
        super.servletInitialized();

        this.getService().setSystemMessagesProvider(new SystemMessagesProvider() {
			
            @Override
            public SystemMessages getSystemMessages(SystemMessagesInfo systemMessagesInfo) {
    			CustomizedSystemMessages messages = new CustomizedSystemMessages();
				messages.setSessionExpiredCaption("Sitzung abgelaufen");
				messages.setSessionExpiredMessage("Bitte notieren Sie ungespeicherte Daten und <u>klicken Sie hier</u> oder drücken Sie die ESC-Taste...");
				messages.setSessionExpiredNotificationEnabled(true);
		        messages.setInternalErrorCaption("Kommunikationsfehler");
		        messages.setInternalErrorMessage("Bitte notieren Sie ungespeicherte Daten und <u>klicken Sie hier</u> oder drücken Sie die ESC-Taste...");
		        messages.setInternalErrorNotificationEnabled(true);
		        messages.setCookiesDisabledCaption("Cookies sind abgeschaltet");
		        messages.setCookiesDisabledMessage("Diese Anwendung benötigt Cookies, um korrekt zu funktionieren.<br>Bitte schalten Sie Cookies in Ihrem Browser ein und <u>klicken Sie hier</u> oder drücken Sie die ESC-Taste...");
		        messages.setCookiesDisabledNotificationEnabled(true);
		        messages.setInternalErrorCaption("Interner Fehler");
		        messages.setInternalErrorMessage("Informieren Sie Ihren Anwendungsbetreuer.<br/>Bitte notieren Sie ungespeicherte Daten und <u>klicken Sie hier</u> oder drücken Sie die ESC-Taste...");
		        messages.setInternalErrorNotificationEnabled(true);
		        return messages;
            }
        });
    }
}
