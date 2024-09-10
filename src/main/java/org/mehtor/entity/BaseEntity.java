package org.mehtor.entity;

public class BaseEntity {
	private Integer state;
	
		public BaseEntity() {
		}
		
		public BaseEntity(Integer state) {
			this.state = state;
		}
		
		public Integer getState() {
			return state;
		}
		
		public void setState(Integer state) {
			this.state = state;
		}
		
	}