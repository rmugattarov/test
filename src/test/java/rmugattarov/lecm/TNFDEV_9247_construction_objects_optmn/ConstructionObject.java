package rmugattarov.lecm.TNFDEV_9247_construction_objects_optmn;

import java.io.Serializable;

/**
 * Created by rmugattarov on 05.02.2016.
 */
public class ConstructionObject implements Serializable {
    private static final long serialVersionUID = 760287915515211993L;

    private String agentCode;
    private String agentName;
    private String agentKod;
    private String agentAbbr;
    private String parentAgentCode;

    @Override
    public String toString() {
        return "\n\tConstructionObject {\n\t\t" +
                "agentCode : " + agentCode + ",\n\t\t" +
                "agentName : " + agentName + ",\n\t\t" +
                "agentKod : " + agentKod + ",\n\t\t" +
                "agentAbbr : " + agentAbbr + ",\n\t\t" +
                "parentAgentCode : " + parentAgentCode + "\n\t" +
                "}\n";
    }

    public void setField(String fieldName, String fieldValue) {
        switch (fieldName) {
            case "AGENTCODE":
                agentCode = fieldValue;
                break;
            case "AGENTNAME":
                agentName = fieldValue;
                break;
            case "AGENTKOD":
                agentKod = fieldValue;
                break;
            case "AGENTABBR":
                agentAbbr = fieldValue;
                break;
            case "PARENTAGENTCODE":
                parentAgentCode = fieldValue;
                break;
        }
    }
}
