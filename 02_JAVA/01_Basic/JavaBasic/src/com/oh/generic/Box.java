package com.oh.generic;

public class Box<T> {
	private T value;
	private T[] arr;
	public Box() {
		super();
	}
	public Box(T value, T[] arr) {
		super();
		this.value = value;
		this.arr = arr;
	}
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	public T[] getArr() {
		return arr;
	}
	public void setArr(T[] arr) {
		this.arr = arr;
	}
	
}
