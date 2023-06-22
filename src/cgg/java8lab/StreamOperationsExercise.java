package cgg.java8lab;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOperationsExercise {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Player> players=Arrays.asList(
				new Player("Rohit Sharma",145,7000,263,new Country(1,"India")),
				new Player("Virat Kohli",154,12000,183,new Country(1,"India")),
				new Player("Maxwell",122,4000,153,new Country(2,"Australia")),
				new Player("AB Devilliers",174,11000,173,new Country(3,"South Africa")),
				new Player("Kane Williamson",134,6000,142,new Country(4,"New Zeland")),
				new Player("Moen Ali",75,2000,75,new Country(5,"England")),
				new Player("Sachin",200,17000,200,new Country(1,"India")),
				new Player("Gayle",176,11000,214,new Country(6,"WestIndies")),
				new Player("MS Dhoni",178,10600,183,new Country(1,"India")),
				new Player("Steve Smith",114,8000,134,new Country(2,"Australia"))
				);
		 
		
		
		displayPlayers(players);
		System.out.println("------------------------------------");
		System.out.println("Enter country to get names of players whose highest score is more than 100");
		String c=sc.nextLine();
		displayPlayersForCountry(players, c);
		System.out.println("------------------------------------");
		getPlayerNames(players);
		System.out.println("------------------------------------");
		System.out.println("Enter country to get names of players whose highest score is more than 100");
		String ch=sc.nextLine();
		getAverageRunsByCountry(players,ch);
		//getPlayerNamesSorted();
		
		
		
		
		
		
	}





	private static void getPlayerNames(List<Player> players) {
		LinkedList<String> collect = players.stream().filter(player -> player.getRuns() > 5000)
        .sorted((p1, p2) -> p2.getPlayerName().compareTo(p1.getPlayerName()))
        .map(Player::getPlayerName)
        .collect(Collectors.toCollection(LinkedList::new));
		collect.forEach(System.out::println);
	}


	


	private static void displayPlayersForCountry(List<Player> players, String c) {
		Stream<String> playerName = players.stream().filter(player->player.getCountry().getCountryName().equals(c)).filter(player->player.getHighestScore()>100).map(Player::getPlayerName);
		playerName.forEach(System.out::println);
	}
	 

	private static void displayPlayers(List<Player> players) {
		Stream<String> playerNames = players.stream().map(Player::getPlayerName);
		playerNames.forEach(System.out::println);
	}
	private static void getAverageRunsByCountry(List<Player> players,String ch) {
		double Avg = players.stream().filter(player -> player.getCountry().getCountryName().equals(ch))
		        .mapToInt(Player::getRuns)
		        .average()
		        .orElse(0.0);
				System.out.println(Avg);
	}
	
//	public static List<String> getPlayerNamesSorted() {
//        return players.stream()
//            .sorted((p1, p2) -> {
//                if (p1.getCountry().getCountryName().equals(p2.getCountry().getCountryName())) {
//                    return Integer.compare(p2.getMatchesPlayed(), p1.getMatchesPlayed());
//                }
//                return p1.getCountry().getCountryName().compareTo(p2.getCountry().getCountryName());
//            })
//            .map(Player::getPlayerName)
//            .collect(Collectors.toList());
//    }

}
