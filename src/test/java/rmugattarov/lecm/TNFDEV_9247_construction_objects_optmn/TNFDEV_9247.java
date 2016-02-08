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
            System.out.printf("constructionObjectsImportFile:\n%s", constructionObjectsImportFile);
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
        }
    }
}
