package webserver.http;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class HttpSession implements Session {
	private final String id;
	private final Map<String, Object> attribute;

	public HttpSession() {
		this.id = UUID.randomUUID().toString();
		this.attribute = new HashMap<>();
	}

	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public Object getAttribute(final String name) {
		return this.attribute.get(name);
	}

	@Override
	public void setAttribute(final String name, Object value) {
		this.attribute.put(name, value);
	}

	@Override
	public void removeAttribute(final String name) {
		this.attribute.remove(name);
	}

	@Override
	public void invalidate() {
		this.attribute.clear();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		HttpSession that = (HttpSession) o;
		return Objects.equals(id, that.id) && Objects.equals(attribute, that.attribute);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, attribute);
	}
}
