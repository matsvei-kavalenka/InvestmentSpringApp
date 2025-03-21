package lt.vilniustech.mkavalenka.investment.controller;


import lt.vilniustech.mkavalenka.investment.model.InvestorWrapper;
import lt.vilniustech.mkavalenka.investment.service.XmlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/xml")
public class XMLController {
    @Autowired
    private XmlService xmlService;

    /**
     * Generates an XML file containing a list of investors and returns the file path.
     * <p>
     * This endpoint retrieves all investors, converts them into an XML file,
     * and returns the absolute file path in the response.
     * </p>
     *
     * @param fileName The name of the XML file (default: "data.xml").
     * @param encoding The character encoding for the XML file (default: "UTF-8").
     * @return A {@link ResponseEntity} containing the absolute file path of the generated XML file.
     *
     * @see XmlService#transformToXML(String, String)
     */
    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> getAllData(@RequestParam(defaultValue = "data.xml") String fileName,
                                             @RequestParam(defaultValue = "UTF-8") String encoding){
        String path = xmlService.transformToXML(fileName, encoding);
        return ResponseEntity.ok(path);
    }

}
