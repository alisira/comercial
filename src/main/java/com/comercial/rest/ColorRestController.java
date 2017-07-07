package com.comercial.rest;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.comercial.dto.ColorDto;
import com.comercial.service.ColorService;
import com.itextpdf.text.DocumentException;

@RestController
@RequestMapping("/color")
public class ColorRestController {

	@Autowired
	ColorService colorService;

	@RequestMapping( method = RequestMethod.POST)
    public String save(@RequestBody ColorDto color, UriComponentsBuilder ucBuilder) {

    	color.setCreatedAt(new Date());
    	color.setUpdatedAt(new Date());

    	ColorDto colorBack = colorService.save(color);

		Map<String, Number> toParse = new HashMap<String, Number>();
	    toParse.put("id", colorBack.getIdColor());
		JSONObject jsonObject = new JSONObject(toParse);

		return jsonObject.toJSONString();       
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody String findAll(@RequestParam Map<String,String> requestParams) {

		String resp = colorService.findAll(requestParams);

		return resp;

    }

	@RequestMapping(value = "/count", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String countByParam(@RequestParam Map<String,String> requestParams) {

	    Map<String, Number> toParse = new HashMap<String, Number>();
	    toParse.put("count", colorService.count(requestParams));	    
		JSONObject jsonObject = new JSONObject(toParse);

	    return jsonObject.toJSONString();

	}

    @RequestMapping(method = RequestMethod.PUT)
    public String update(@RequestBody ColorDto color, UriComponentsBuilder ucBuilder){

    	color.setUpdatedAt(new Date());
    	ColorDto colorRes = colorService.save(color);

		Map<String, Number> toParse = new HashMap<String, Number>();
	    toParse.put("id", colorRes.getIdColor());	    

		JSONObject jsonObject = new JSONObject(toParse);

		return jsonObject.toJSONString();
    }

	@RequestMapping(value = "/print", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String print(@RequestParam Map<String,String> requestParams) throws IOException, DocumentException {
		System.out.println(112233);

		ParseHtml.main(new String[]{"a","b","c"});

	    Map<String, Number> toParse = new HashMap<String, Number>();
	    toParse.put("count", colorService.count(requestParams));	    
		JSONObject jsonObject = new JSONObject(toParse);

	    return jsonObject.toJSONString();

	}
}

