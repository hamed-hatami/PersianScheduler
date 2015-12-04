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
        StringBuilder finalContent = new StringBuilder();
        String events = "";
        String defaultDate = "";
        String editable = "";
        String eventLimit = "";
        writer.startElement("input", this);
        writer.writeAttribute("name", clientId, "clientId");
        writer.writeAttribute("id", clientId, "clientId");
        writer.writeAttribute("type", "hidden", "type");

        if (getAttributes().get("events") instanceof String) {
            if (!getAttributes().get("events").toString().isEmpty()) {
                events = getAttributes().get("events").toString();
                writer.writeAttribute("events", getAttributes().get("events").toString(), "events");
            }
        }

        if (getAttributes().get("defaultDate") instanceof String) {
            if (!getAttributes().get("defaultDate").toString().isEmpty()) {
                defaultDate = getAttributes().get("defaultDate").toString();
                writer.writeAttribute("defaultDate", getAttributes().get("defaultDate").toString(), "defaultDate");
            }
        }

        if (getAttributes().get("editable") instanceof String) {
            if (!getAttributes().get("editable").toString().isEmpty()) {
                editable = getAttributes().get("editable").toString();
                writer.writeAttribute("editable", getAttributes().get("editable").toString(), "editable");
            }
        }

        if (getAttributes().get("eventLimit") instanceof String) {
            if (!getAttributes().get("eventLimit").toString().isEmpty()) {
                eventLimit = getAttributes().get("eventLimit").toString();
                writer.writeAttribute("eventLimit", getAttributes().get("eventLimit").toString(), "eventLimit");
            }
        }

        writer.endElement("input");

        finalContent.append("defaultDate:")
                .append("'" + defaultDate + "'")
                .append(",")
                .append("editable:")
                .append(editable)
                .append(",")
                .append("eventLimit:")
                .append(eventLimit)
                .append(",")
                .append("events:")
                .append(events)
                .append("});");

        writer.write("<script>$(document).ready(function() {$('#calendar_" + clientId + "').fullCalendar({" + finalContent.toString() + "});</script>");
        writer.write("<div id='calendar_" + clientId + "'/>");

        writer.flush();
        writer.close();

    }
}
