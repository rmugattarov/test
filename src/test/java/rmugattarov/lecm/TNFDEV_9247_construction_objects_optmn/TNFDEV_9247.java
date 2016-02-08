package rmugattarov.lecm.TNFDEV_9247_construction_objects_optmn;

import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileInputStream;
import org.apache.commons.io.input.BOMInputStream;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;
import java.io.*;
import java.util.List;

/**
 * Created by rmugattarov on 05.02.2016.
 */
public class TNFDEV_9247 {

    @Test
    public void test_SMB() throws IOException, JAXBException {
        NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication("tn.fntst.ru", "cpe_bootstrap@tn.fntst.ru", "o9p0[-]=");
        try (BOMInputStream inputStream = new BOMInputStream(new BufferedInputStream(new SmbFileInputStream(new SmbFile("smb://172.28.24.185/tstxml/KatStroy.XML", auth))))) {
            JAXBContext jaxbContext = JAXBContext.newInstance(ConstructionObjectsImportFile.class);
            ConstructionObjectsImportFile constructionObjectsImportFile = (ConstructionObjectsImportFile) jaxbContext.createUnmarshaller().unmarshal(inputStream);
            System.out.printf("constructionObjectsImportFile:\n%s", constructionObjectsImportFile);
        }
    }

    @Test
    public void test_local() throws JAXBException, IOException {
        try (BOMInputStream inputStream = new BOMInputStream(new FileInputStream("D://KatStroy.XML"))) {
            JAXBContext jaxbContext = JAXBContext.newInstance(ConstructionObjectsImportFile.class);
            ConstructionObjectsImportFile constructionObjectsImportFile = (ConstructionObjectsImportFile) jaxbContext.createUnmarshaller().unmarshal(inputStream);
            List<ConstructionObjectsImportFile.ConstructionObject> constructionObjects = constructionObjectsImportFile.getConstructionObjects();
            int maxCode = 0;
            int maxName = 0;
            int maxKod = 0;
            int maxAbbr = 0;
            int maxParentCode = 0;
            for (ConstructionObjectsImportFile.ConstructionObject constructionObject : constructionObjects) {
                List<ConstructionObjectsImportFile.ConstructionObjectField> constructionObjectFields = constructionObject.getConstructionObjectFields();
                for (ConstructionObjectsImportFile.ConstructionObjectField constructionObjectFieldDto : constructionObjectFields) {
                    ConstructionObjectField constructionObjectField = ConstructionObjectField.fromImportName(constructionObjectFieldDto.getName());
                    switch (constructionObjectField) {
                        case ABBREVIATION:
                            maxAbbr = Math.max(maxAbbr,constructionObjectFieldDto.getValue().length());
                            break;
                        case CODE:
                            maxCode = Math.max(maxCode,constructionObjectFieldDto.getValue().length());
                            break;
                        case KOD:
                            maxKod = Math.max(maxKod,constructionObjectFieldDto.getValue().length());
                            break;
                        case NAME:
                            maxName = Math.max(maxName,constructionObjectFieldDto.getValue().length());
                            break;
                        case PARENTCODE:
                            maxParentCode = Math.max(maxParentCode,constructionObjectFieldDto.getValue().length());
                            break;
                    }
                }
            }
            System.out.printf("\nmaxCode : %d\nmaxName : %d\nmaxKod: %d\nmaxAbbr: %d\nmaxParentCode: %d\n", maxCode, maxName, maxKod, maxAbbr, maxParentCode);
        }
    }

    @XmlRootElement(name = "TABLE")
    private static class ConstructionObjectsImportFile {
        private static final long serialVersionUID = -755588742704172438L;

        @XmlElement(name = "RECORD")
        protected List<ConstructionObject> constructionObjects;

        protected ConstructionObjectsImportFile() {
        }

        @Override
        public String toString() {
            return " ConstructionObjectsImportFile {" +
                    "constructionObjects : " + constructionObjects +
                    "} ";
        }

        public List<ConstructionObject> getConstructionObjects() {
            return constructionObjects;
        }

        public static class ConstructionObject {
            private static final long serialVersionUID = 2773335779701858739L;

            @XmlElement(name = "FIELD")
            protected List<ConstructionObjectField> constructionObjectFields;

            protected ConstructionObject() {
            }

            @Override
            public String toString() {
                return " ConstructionObject {constructionObjectFields : " + constructionObjectFields + "} ";
            }

            public List<ConstructionObjectField> getConstructionObjectFields() {
                return constructionObjectFields;
            }
        }

        public static class ConstructionObjectField {
            private static final long serialVersionUID = -3282718524729860767L;

            @XmlAttribute(name = "NAME")
            protected String name;
            @XmlValue
            protected String value;

            protected ConstructionObjectField() {
            }

            @Override
            public String toString() {
                return " ConstructionObjectField {" +
                        "name : " + name + ", " +
                        "value : " + value +
                        "} ";
            }

            public String getName() {
                return name;
            }

            public String getValue() {
                return value;
            }
        }
    }

    enum ConstructionObjectField {
        ABBREVIATION("AGENTABBR"), CODE("AGENTCODE"), KOD("AGENTKOD"), NAME("AGENTNAME"), PARENTCODE("PARENTAGENTCODE");
        private String importName;

        private ConstructionObjectField(String importName) {
            this.importName = importName;
        }

        public String getImportName() {
            return importName;
        }

        public static ConstructionObjectField fromImportName(String importName) {
            ConstructionObjectField result = null;
            for (ConstructionObjectField constructionObjectField : ConstructionObjectField.values()) {
                if (constructionObjectField.getImportName().equalsIgnoreCase(importName)) {
                    result = constructionObjectField;
                    break;
                }
            }
            if (result == null) {
                throw new IllegalArgumentException("importName " + importName + " does not correspond to any enum value!");
            } else {
                return result;
            }
        }
    }
}
