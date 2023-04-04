package orbartal.springbootdemosqltester.demo.util;

import orbartal.springbootdemosqltester.demo.DemoDto;

public class DemoDtoFactory {

	static public DemoDto buildDemoDto(String key, String value) {
		DemoDto entity = new DemoDto();
		entity.setKey(key);
		entity.setValue(value);
		return entity;
	}

}
