package cgg.java8lab;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LambdaExercise {

	private static List<String> countries;
	private static Map<String,String> countryCapitals;
	
	static {
		countries= new ArrayList<>();
		countries.add("India");
		countries.add("USA");
		countries.add("Australia");
		countries.add("Pakistan");
		countries.add("New Zeland");
		
		
		countryCapitals= new HashMap<>();
		countryCapitals.put("India", "Delhi");
		countryCapitals.put("USA", "Washington DC");
		countryCapitals.put("Australia", "Canberra");
		countryCapitals.put("Pakistan", "Islamabad");
		countryCapitals.put("New Zeland", "Wellington");
		
	}
	
	public static void main(String[] args) {
		displayCountries();
		displayCountryCapitals();
		sortCountriesByNameDesc();
		sortCountriesByNameAsc();
		sortCountriesByLength();
		removeCountry("country");
		
		
	}
	
	
	public static void displayCountries() {
		System.out.println("Countries");
		countries.forEach(System.out::println);
		System.out.println("-------------------------------------");
	}
	
	public static void displayCountryCapitals() {
		countryCapitals.forEach((c,p)->System.out.println("Country:"+c+"\t Capital:"+p));
		System.out.println("-------------------------------------");
	}
	
	public static void sortCountriesByNameDesc() {
		System.out.println("Countries sorted in reverse aplhabtical order:");
		countries.sort((a,b)->b.compareTo(a));
		countries.forEach(System.out::println);
		System.out.println("--------------------------");
	}
	
	public static void sortCountriesByNameAsc() {
		System.out.println("Countries sorted in aplhabtical order:");
		countries.sort((a,b)->a.compareTo(b));
		countries.forEach(System.out::println);
		System.out.println("--------------------------");
	}

	public static void sortCountriesByLength() {
		System.out.println("Countries sorted by length:");
		countries.sort(Comparator.comparingInt(String::length));
		countries.forEach(System.out::println);
	}
	
	public static void removeCountry(String name) {
		System.out.println("Countries after removing:");
		countries.removeIf(n->n.length()>6);
		countries.forEach(System.out::println);
		
	}
	
	
	
}