package orbartal.springbootdemosql.data;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import orbartal.springbootdemosql.model.DemoDto;
import orbartal.springbootdemosql.sql.DemoEntity;
import orbartal.springbootdemosql.sql.DemoRepository;

@Transactional
@Component
public class DemoData {

	@Autowired
	private DemoRepository demoRepository;

	static final Comparator<DemoDto> keyComparator = (a, b) -> a.getKey().compareTo(b.getKey());

	@Transactional(readOnly = true)
	public synchronized List<DemoDto> readAll() {
		List<DemoEntity> entities = demoRepository.findAll();
		return entities.stream().map(e -> buildDemoDto(e)).sorted(keyComparator).toList();
	}

	@Transactional(readOnly = true)
	public synchronized DemoDto readByKey(String key) {
		DemoEntity entitiy = demoRepository.findByKey(key);
		return (entitiy != null) ? buildDemoDto(entitiy) : null;
	}

	@Transactional(readOnly = false)
	public synchronized DemoDto create(DemoDto input) {
		String key = input.getKey();
		String value = input.getValue();
		DemoEntity oldEntitiy = demoRepository.findByKey(key);
		if (oldEntitiy != null) {
			throw new RuntimeException("Duplicate key: " + key);
		}
		DemoEntity newEntitiy = new DemoEntity();
		newEntitiy.setKey(key);
		newEntitiy.setValue(value);
		demoRepository.save(newEntitiy);
		return buildDemoDto(newEntitiy);
	}

	@Transactional(readOnly = false)
	public synchronized DemoDto update(DemoDto input) {
		String key = input.getKey();
		String value = input.getValue();
		DemoEntity entitiy = demoRepository.findByKey(key);
		if (entitiy == null) {
			throw new RuntimeException("Missing key: " + key);
		}
		entitiy.setValue(value);
		demoRepository.save(entitiy);
		return buildDemoDto(entitiy);
	}

	private DemoDto buildDemoDto(DemoEntity e) {
		DemoDto dto = new DemoDto();
		dto.setId(e.getId());
		dto.setKey(e.getKey());
		dto.setValue(e.getValue());
		return dto;
	}

	@Transactional(readOnly = false)
	public synchronized void deleteByKey(String key) {
		DemoEntity entity = demoRepository.findByKey(key);
		if (entity == null) {
			throw new RuntimeException("Missing key: " + key);
		}
		demoRepository.delete(entity);
	}

	@Transactional(readOnly = false)
	public synchronized void deleteAll() {
		demoRepository.deleteAll();
	}

}
