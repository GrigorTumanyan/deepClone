package org.example;

import java.util.List;

class Man {

	private String name;
	private int age;
	private List<String> favoriteBooks;

	public Man(String name, int age, List<String> favoriteBooks) {
		this.name = name;
		this.age = age;
		this.favoriteBooks = favoriteBooks;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<String> getFavoriteBooks() {
		return favoriteBooks;
	}

	public void setFavoriteBooks(List<String> favoriteBooks) {
		this.favoriteBooks = favoriteBooks;
	}

	public Man deepCopy() {
		List<String> copiedBooks = favoriteBooks.stream().map(String::new).toList();
		return new Man(this.name, this.age, copiedBooks);
	}

	public static void main(String[] args) {
		Man man = new Man("A", 52, List.of("First ", "Second ", "Third" ));

		Man man1 = man.deepCopy();

		System.out.println(man == man1);
		System.out.println(man.favoriteBooks == man1.getFavoriteBooks());

		man.setFavoriteBooks(List.of("Agata ", "Steven ", "Robert "));
		man.favoriteBooks.forEach(System.out::print);
		System.out.println();
		man1.favoriteBooks.forEach(System.out::print);

	}

}