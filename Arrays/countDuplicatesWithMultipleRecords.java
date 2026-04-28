/*
Problem: Count Duplicate Records with Multiple Fields
Platform: Basic DSA / HashMap Problem
Difficulty: Easy

Approach:
We are given a 2D array where each row represents
a record containing multiple fields.

The task is to count how many records are duplicated.

Since each record contains multiple values,
we combine all fields into a single unique string key.
This allows us to store and compare complete records
using a HashMap.

Steps:
1. Create a HashMap where:
   - Key   = combined record string
   - Value = frequency of that record

2. Traverse through every row of the 2D array:
   - Combine all fields using a separator (#)
     to create a unique key.
   Example:
     {"Ball", "1", "1"}
     becomes
     "Ball#1#1"

3. Check if the key already exists in the map:
   - If yes, increase its frequency.
   - Otherwise, insert it with frequency 1.

4. Traverse through all frequencies in the map:
   - If frequency > 1,
     it means that record is duplicated.
   - Increase duplicate count.

5. Print the total number of duplicate records.

Example:
Input Records:
{"Ball", "1", "1"}
{"Ball", "2", "3"}
{"Ball", "3", "2"}
{"Bat",  "1", "1"}
{"Ball", "1", "1"}
{"Bat",  "1", "1"}

Frequencies:
"Ball#1#1" -> 2
"Ball#2#3" -> 1
"Ball#3#2" -> 1
"Bat#1#1"  -> 2

Duplicate records count = 2

Output:
2

Time Complexity: O(n)
- One traversal for storing records
- One traversal for checking frequencies

Space Complexity: O(n)
- HashMap stores all unique records.

Pattern:
HashMap / Frequency Counting / Composite Key
*/

import java.util.*;

public class stock {
    public static void main(String[] args) {
        String[][] items = {
                {"Ball", "1", "1"},
                {"Ball", "2", "3"},
                {"Ball", "3", "2"},
                {"Bat",  "1", "1"},
                {"Ball", "1", "1"},
                {"Bat",  "1", "1"}
        };
        countRecordwithMultipleField(items);
    }

    static void countRecordwithMultipleField(String[][] items) {
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<items.length;i++){
            String key = items[i][0] + "#" + items[i][1] + "#" + items[i][2] ;
            if(map.containsKey(key)){
                map.put(key,map.get(key)+1);
            }
            else{
                map.put(key,1);
            }
        }
        int duplicates = 0;
        for(int value : map.values()){
            if(value > 1){
                duplicates++;
            }
        }
        System.out.println(duplicates);
    }
}
