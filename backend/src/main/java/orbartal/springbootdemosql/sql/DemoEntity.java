
package orbartal.springbootdemosql.sql;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="demo")
public class DemoEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "demo_id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "demo_key", updatable = false, nullable = false)
    private String key;
    
    @Column(name = "demo_value", updatable = true, nullable = false)
    private String value;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "DemoEntity [id=" + id + ", key=" + key + ", value=" + value + "]";
	}

}
