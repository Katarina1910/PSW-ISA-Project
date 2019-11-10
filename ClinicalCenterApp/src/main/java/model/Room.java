package model;

enum Type {examination, operation}

public class Room {
	private Type type;
	private boolean isFree;
	private String name;
	
	public Room() {
		super();
	}

	public Room(Type type, boolean isFree, String name) {
		super();
		this.type = type;
		this.isFree = isFree;
		this.name = name;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public boolean isFree() {
		return isFree;
	}

	public void setFree(boolean isFree) {
		this.isFree = isFree;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
