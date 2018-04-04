package com.designpatterns;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sbansal
 * Prototype pattern (C) demo
 */
abstract class Color implements Cloneable {

	protected String colorName;

	abstract void fillColor();

	public Object clone() {

		Object clone = null;
		try {
			clone = super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clone;
	}
}

class RedColor extends Color {

	public RedColor() {
		this.colorName = "RED";
	}

	@Override
	void fillColor() {
		System.out.println("filling red color...");
	}
}

class GreenColor extends Color {

	public GreenColor() {
		this.colorName = "Green";
	}

	@Override
	void fillColor() {
		System.out.println("filling green color...");
	}
}

class ColorStore {

	private static Map<String, Color> colorMap = new HashMap<String, Color>();

	static {
		colorMap.put("red", new RedColor());
		colorMap.put("green", new GreenColor());
	}

	public static Color getColor(String colorName) {

		return (Color) colorMap.get(colorName).clone();
	}
}

public class PrototypePattern {
	public static void main(String a[]) {
		ColorStore.getColor("red").fillColor();
		ColorStore.getColor("green").fillColor();
		ColorStore.getColor("green").fillColor();
		ColorStore.getColor("red").fillColor();
	}
}
