package ir.hatami.persian.scheduler;


import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.FacesComponent;
import javax.faces.component.NamingContainer;
import javax.faces.component.UIComponentBase;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import java.io.IOException;
import java.util.Map;

/**
 * @Author : Hamed Hatami
 */

@FacesComponent("ir.hatami.persian.scheduler.PersianScheduler")
@ResourceDependencies({
        @ResourceDependency(name = "lib/moment.min.js", target = "head"),
        @ResourceDependency(name = "lib/jquery.min.js", target = "head"),
        @ResourceDependency(name = "fullcalendar.css", target = "head"),
        @ResourceDependency(name = "fullcalendar.min.js", target = "head")
})
public class PersianScheduler extends UIInput implements NamingContainer {

    public PersianScheduler() {
        setRendererType(null);
    }

    @Override
    public String getFamily() {
        return "javax.faces.NamingContainer";
    }

    @Override
    public void encodeBegin(FacesContext context) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        String clientId = getClientId(context);
        encodeInputField(writer, clientId);
    }

    @Override
    public void decode(javax.faces.context.FacesContext context) {
        Map<String, String> requestMap = context.getExternalContext().getRequestParameterMap();
        String clientId = getClientId(context);
        try {
            String submittedValue = (String) requestMap.get(clientId);
            setSubmittedValue(submittedValue);
            setValid(true);
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            setSubmittedValue((String) requestMap.get(clientId));
        }
    }

    private void encodeInputField(ResponseWriter writer, String clientId) throws IOException {
        String content = "";
        writer.startElement("input", this);
        writer.writeAttribute("name", clientId, "clientId");
        writer.writeAttribute("id", clientId, "clientId");
        writer.writeAttribute("type", "hidden", "type");
        Object value = getValue();
        if (value != null) {
            content = (String) value;
            writer.writeAttribute("value", content, "value");
        }
        writer.endElement("input");

        writer.write("<script>$(document).ready(function() {$('#calendar_" + clientId + "').fullCalendar({" + content + "});</script>");
        writer.write("<div id='calendar_" + clientId + "'/>");

        writer.flush();
        writer.close();

    }
}
