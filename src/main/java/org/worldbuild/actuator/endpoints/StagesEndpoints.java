package org.worldbuild.actuator.endpoints;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "stages")
public class StagesEndpoints {

	private Map<String, Stage> stages = new ConcurrentHashMap<>();

	@ReadOperation
	public Map<String, Stage> getStages() {
		return stages;
	}
	
	@ReadOperation
	public Stage getStages(@Selector String name) {
		return stages.get(name);
	}

	@WriteOperation
	public void setStages(@Selector String name, int value) {
		this.stages.put(name, new Stage(name,value));
	}

	static class Stage {

		private String name;
		private int value;

		public Stage(String name, int value) {
			this.name=name;
			this.value=value;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}
	}

}
