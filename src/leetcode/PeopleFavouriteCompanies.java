/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author salipuri
 * 
 * Given the array favoriteCompanies where favoriteCompanies[i] is the list of favorites companies for the ith person (indexed from 0).

Return the indices of people whose list of favorite companies is not a subset of any other list of favorites companies. You must return the indices in increasing order.

 

Example 1:

Input: favoriteCompanies = [["leetcode","google","facebook"],["google","microsoft"],["google","facebook"],["google"],["amazon"]]
Output: [0,1,4] 
Explanation: 
Person with index=2 has favoriteCompanies[2]=["google","facebook"] which is a subset of favoriteCompanies[0]=["leetcode","google","facebook"] corresponding to the person with index 0. 
Person with index=3 has favoriteCompanies[3]=["google"] which is a subset of favoriteCompanies[0]=["leetcode","google","facebook"] and favoriteCompanies[1]=["google","microsoft"]. 
Other lists of favorite companies are not a subset of another list, therefore, the answer is [0,1,4].
Example 2:

Input: favoriteCompanies = [["leetcode","google","facebook"],["leetcode","amazon"],["facebook","google"]]
Output: [0,1] 
Explanation: In this case favoriteCompanies[2]=["facebook","google"] is a subset of favoriteCompanies[0]=["leetcode","google","facebook"], therefore, the answer is [0,1].
Example 3:

Input: favoriteCompanies = [["leetcode"],["google"],["facebook"],["amazon"]]
Output: [0,1,2,3]
 

Constraints:

1 <= favoriteCompanies.length <= 100
1 <= favoriteCompanies[i].length <= 500
1 <= favoriteCompanies[i][j].length <= 20
All strings in favoriteCompanies[i] are distinct.
All lists of favorite companies are distinct, that is, If we sort alphabetically each list then favoriteCompanies[i] != favoriteCompanies[j].
All strings consist of lowercase English letters only.
 *
 */
public class PeopleFavouriteCompanies {

	/**
	 * @param args
	 */
	
	public static List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        
		List<Integer> result = new ArrayList<Integer>();
        HashMap<String,List<Integer>> companyMap = new HashMap<>();
        HashSet<Integer> uncomparedCompany = new HashSet<>();
		
        int i=0;
		for(List<String> list: favoriteCompanies) {
			for(String company: list) {
				if(companyMap.get(company)==null) {
					companyMap.put(company, new ArrayList<>());
				}
				companyMap.get(company).add(i);
			}
			i++;
		}
		
		for(int j=0;j<favoriteCompanies.size();j++) {
            uncomparedCompany = new HashSet<>();
			uncomparedCompany.addAll(companyMap.get(favoriteCompanies.get(j).get(0)));
			for(int k=1;k<favoriteCompanies.get(j).size();k++) {
				Set<Integer> nextSet = companyMap.get(favoriteCompanies.get(j).get(k)).stream().collect(Collectors.toSet());
				uncomparedCompany.retainAll(nextSet);
				if(uncomparedCompany.size()==1) {
					break;
				}
			}
			if(uncomparedCompany.size()==1) {
				result.add(j);
			}
		}
		
		return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//System.out.println(peopleIndexes(favoriteCompanies));
	}

}
