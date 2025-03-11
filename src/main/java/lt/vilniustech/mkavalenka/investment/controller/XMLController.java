package lt.vilniustech.mkavalenka.investment.controller;


import lt.vilniustech.mkavalenka.investment.service.XmlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/xml")
public class XMLController {
    @Autowired
    private XmlService xmlService;

    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> getAllData() {
        String path = xmlService.transformToXML();
        return ResponseEntity.ok(path);
    }

}
