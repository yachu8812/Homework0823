import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        /** 以 List<Map<String, String>> 物件初始化一個 animalList */

        String aArray[][] = {{"shark","ocean"},{"bear","land"},{"moose","land"},
                            {"frog","swamp"},{"jelly fish","ocean"},{"heron","swamp"},{"whale","ocean"}};

        List<Map<String, String>> animalList = new ArrayList<>();
        Map<String, String> amap = new HashMap<>();
        for (int i = 0; i < aArray.length; i++) {
            amap = Map.of("name", aArray[i][0], "habitat", aArray[i][1]);
            animalList.add(amap);
        }

        //System.out.println("animalList :" + animalList);


        /** 將 animalList 重新包裝為 Map<String, List<String>> 物件 */

        Map<String, List<String>> habitatList = new HashMap<>();
        //Map<String, String> map = new HashMap<>();
        habitatList = animalList.stream().collect(Collectors.groupingBy(map -> map.get("habitat").toString(),
                                            Collectors.mapping(map -> map.get("name").toString(),Collectors.toList())));

        for(String key : habitatList.keySet()){
            System.out.printf(key + ": ");
            //接著進行取list值
            List<String> lisMap = new ArrayList<String>();
            lisMap = habitatList.get(key);
            for (int i = 0 ; i< lisMap.size() ; i++){
                System.out.printf(lisMap.get(i).toString());
                if((i+1) < lisMap.size()){
                    System.out.printf(", ");
                }
            }
            System.out.println();
        }

        /** 以 Map<String, String> 物件初始化一個 capitalMap */

        String bArray[][] = {{"USA","Washington"},{"Japan","Tokyo"},{"Thailand","Bangkok"},
                {"UK","London"},{"Australia","Canberra"},{"Denmark","Copenhagen"},{"Egypt","Cairo"},
                {"Vietnam","Hanoi"},{"Italy","Rome"},{"Brazil","Brazilia"}};

        Map<String, String> capitalMap = new HashMap<>();

        for (int i = 0; i < bArray.length; i++) {
            capitalMap.put(bArray[i][0],bArray[i][1]);
        }

        for(String key : capitalMap.keySet()){
            System.out.println(key + ": " + capitalMap.get(key));
        }
    }
}