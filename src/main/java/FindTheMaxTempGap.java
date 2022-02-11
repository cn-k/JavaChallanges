import java.util.*;

public class FindTheMaxTempGap {
    /**
     * there is a given array contains element.
     * every quarter of elements demonstrates a season
     * for example
     * [1,4,9,6,1,11,12,8]
     * [1,4] -> winter
     * [9,6] -> spring
     * [1,11] -> summer
     * [12,8] -> autumn
     * find the season have biggest temp gap
     * in this case summer 11-1=10
     */
    public static void main(String[] args) {

        solution();
    }
    public static String  solution() {
        Integer[] arry = new Integer[] {10,50,30,80,50,60,70,10};
        var lst = Arrays.asList(arry);
        var res = devideArray(lst );

        var winter = res.get(0);
        var spring = res.get(1);
        var summer = res.get(2);
        var autumn = res.get(3);


        Collections.sort(winter);
        Collections.sort(spring);
        Collections.sort(summer);
        Collections.sort(autumn);

        System.out.println("winter   : " + winter);
        System.out.println("spring   : " + spring);
        System.out.println("summer   : " + summer);
        System.out.println("autumn   : " + autumn);

        var winterDifference = winter.get(winter.size()-1) - winter.get(0);
        var springDifference = spring.get(spring.size()-1) - spring.get(0);
        var summerDifference = summer.get(summer.size()-1) - summer.get(0);
        var autumnDifference = autumn.get(autumn.size()-1) - autumn.get(0);


        Map<String, Integer> map = new HashMap();

        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();

        map.put("winter", winterDifference);
        map.put("spring", springDifference);
        map.put("summer", summerDifference);
        map.put("autumn", autumnDifference);

        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
        System.out.println("Sorted Map   : " + sortedMap);
        Map.Entry<String, Integer> lastElement = null;
        var iterator = sortedMap.entrySet().iterator();
        while (iterator.hasNext()) {
            lastElement = iterator.next();
        }

        return lastElement.getKey();

    }
    public static List<List<Integer>> devideArray(List<Integer> originalList) {
        int partitionSize = originalList.size()/4;
        System.out.println("partitionSize"+ partitionSize);
        List<List<Integer>> partitions = new LinkedList<List<Integer>>();
        for (int i = 0; i < originalList.size(); i += partitionSize) {
            partitions.add(originalList.subList(i,
                    Math.min(i + partitionSize, originalList.size())));
        }
        return partitions;
    }
}
