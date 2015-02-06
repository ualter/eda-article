package br.com.ujr.isus.sales.center.services.mini.js.bam.services;

import java.util.ArrayList;

import javax.enterprise.inject.Default;
import javax.inject.Named;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Named
public class MiniJsBamServices implements IMiniJsBamServices {

	public String ping() {
		String result = "";

		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		mapper.enable(SerializationFeature.CLOSE_CLOSEABLE);
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, true);

		ArrayList<String> str = new ArrayList<String>();
		str.add("UALTER");
		str.add("EDUARDO");
		try {
			result = mapper.writeValueAsString(str);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}

		return result;
	}

}
