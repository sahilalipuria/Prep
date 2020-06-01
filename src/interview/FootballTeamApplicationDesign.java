/**
 * 
 */
package interview;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * @author salipuri
 *
 */

class Result{

    /*
     * Complete the 'getSelectionStatus' function below.
     *
     * The function is expected to return a 2D_STRING_ARRAY.
     * The function accepts 2D_STRING_ARRAY applications as parameter.
     */

    public static List<List<String>> getSelectionStatus(List<List<String>> applications) {

        List<List<String>> applicationStatus = new ArrayList<>();
        //System.out.println(applications);

        PriorityQueue<List<String>> qualifiedStrikerList = new PriorityQueue<>((a,b)->Integer.parseInt(b.get(3))-Integer.parseInt(a.get(3)));
        PriorityQueue<List<String>> qualifiedDefenderList = new PriorityQueue<>((a,b)->Integer.parseInt(b.get(4))-Integer.parseInt(a.get(4)));
        HashSet<String> players = new HashSet<>();
        List<List<String>> selectedPlayers = new ArrayList<>();
        PriorityQueue<List<String>> expertPlayerList = new PriorityQueue<>();

        for(List<String> player: applications){
            players.add(player.get(0));
            if((Double.parseDouble(player.get(1))>= 5.8) && Integer.parseInt(player.get(2))<=23){

                if((Integer.parseInt(player.get(3))>=50) && (Integer.parseInt(player.get(4))>=30)){
                    expertPlayerList.add(player);
                }
                else if(Integer.parseInt(player.get(3))>=50)
                    qualifiedStrikerList.add(player);

                else if(Integer.parseInt(player.get(4))>=30)
                    qualifiedDefenderList.add(player);
            }
        }

        if(!expertPlayerList.isEmpty()){
            if(qualifiedStrikerList.size()>qualifiedDefenderList.size()){
                qualifiedDefenderList.add(expertPlayerList.poll());
            }else
                qualifiedStrikerList.add(expertPlayerList.poll());
        }
        /*System.out.println("qualifiedStrikerList:"+qualifiedStrikerList);
        System.out.println("qualifiedDefenderList:"+qualifiedDefenderList);
        System.out.println("playersSet:"+players);*/

        while(!qualifiedStrikerList.isEmpty() && !qualifiedDefenderList.isEmpty()){
            List<String> selectedStriker = qualifiedStrikerList.poll();
            List<String> selectedDefender = qualifiedDefenderList.poll();

            selectedStriker = selectedStriker.subList(0, 1);
            selectedStriker.add("SELECT");
            selectedStriker.add("STRIKER");

            selectedDefender = selectedDefender.subList(0, 1);
            selectedDefender.add("SELECT");
            selectedDefender.add("DEFENDER");

            selectedPlayers.add(selectedStriker);
            selectedPlayers.add(selectedDefender);
            players.remove(selectedStriker.get(0));
            players.remove(selectedDefender.get(0));
        }

        if(selectedPlayers.isEmpty()){
            for(List<String> player: applications){
                player = player.subList(0, 1);
                player.add("REJECT");
                player.add("NA");
                applicationStatus.add(player);
            }
        }else{
            for(List<String> player: applications){
                player = player.subList(0, 1);
                if(players.contains(player.get(0))){
                    player.add("REJECT");
                    player.add("NA");
                }else{
                    for(List<String> selectedPlayer: selectedPlayers){
                        if(selectedPlayer.get(0)==player.get(0)){
                            player = selectedPlayer;
                            break;
                        }
                    }
                }
                applicationStatus.add(player);
            }
        }

        return applicationStatus;
    }

}


public class FootballTeamApplicationDesign {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		        int applicationsRows = Integer.parseInt(bufferedReader.readLine().trim());
		        int applicationsColumns = Integer.parseInt(bufferedReader.readLine().trim());

		        List<List<String>> applications = new ArrayList<>();

		        IntStream.range(0, applicationsRows).forEach(i -> {
		            try {
		                applications.add(
		                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
		                        .collect(toList())
		                );
		            } catch (IOException ex) {
		                throw new RuntimeException(ex);
		            }
		        });

		        List<List<String>> result = Result.getSelectionStatus(applications);

		        result.stream()
		            .map(
		                r -> r.stream()
		                    .collect(joining(" "))
		            )
		            .map(r -> r + "\n")
		            .collect(toList())
		            .forEach(e -> {
		                try {
		                    bufferedWriter.write(e);
		                } catch (IOException ex) {
		                    throw new RuntimeException(ex);
		                }
		            });

		        bufferedReader.close();
		        bufferedWriter.close();

	}

}
