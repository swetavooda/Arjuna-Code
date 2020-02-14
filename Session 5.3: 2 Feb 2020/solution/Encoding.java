import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

/*
 * 
Given a non-empty string, encode the string such that its encoded length is the shortest.
The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is
being repeated exactly k times.

Note:
ï‚· k will be a positive integer and encoded string will not be empty or have extra space.
ï‚· You may assume that the input string contains only lowercase English letters. The
string's length is at most 160.
ï‚· If an encoding process does not make the string shorter, then do not encode it, return
same input string. If there are several solutions, return any of them is fine.
Sample Input: aaa
Sample Output: aaa
Explanation: There is no way to encode it such that it is shorter than the input string, 
so we do not encode it.
 


Sample Input: aaaaa
Sample Output: 5[a]
Explanation: "5[a]" is shorter than "aaaaa" by 1 character.
 


==============================================================================

input= bb
output= bb


input= bbbbbb
output=6[b]


input=bbbbbbbbbb
output=b9[b]
output=10[b]
output=9[b]b
 

input= aabcdaabcde
output= 2[aabcd]e


input= abbbabbbcabbbabbbcabbbabbbcabbbabbbc
output= 4[2[abbb]c]


 * 
 */
public class ShortestEncodedString {
	
	public static String encode(String s) {
		int n = s.length();
        HashMap[] reps = new HashMap[n];
        String[] words = new String[n];
        int bound = -1;
        for (int i = 0; i < n; i++) {
            reps[i] = new HashMap<String, Integer>();
            words[i] = "";
            for (int j = i; j >= 0; j--) {
                String tmp = s.substring(j, i + 1);
                if (j > 0 && reps[j - 1].containsKey(tmp)) {
                    if (j - 1 > bound || tmp.length() >= words[bound].length()) {
                        reps[i].put(tmp, (int)reps[j - 1].get(tmp) + 1);
                    } else {
                        reps[i].put(tmp, 1);
                    }
                    if (tmp.split(words[i]).length > 0) {
                        words[i] = tmp;
                        bound = i;
                    }
                } else {
                    reps[i].put(tmp, 1);
                }               
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            if (words[i].length() > 0 && words[i].length() * (int)reps[i].get(words[i]) > 4) {
                sb.insert(0, (int)reps[i].get(words[i]) + "[" + encode(words[i]) + "]");
                i = i - words[i].length() * (int)reps[i].get(words[i]) + 1;
            } else {
                sb.insert(0, s.charAt(i));
            }
        }
        
        return sb.toString();

	}

	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		System.out.println(encode(str));

	}
}
/*
The basic idea is use an array of hashmap to record which substring repeated how many time up until current index,
 and another String array record the longest repeated substring up until current index. 
 Then start from the end build the string and recursively do that for substring. 
 Also, we have a global hashmap to record computed results for better performance. 
 There are some edge cases need to be considered:

"abab" should not replace "ab" as the longest repeated substring
If there is an overlap for two different repeated substring, you should choose the longest one, 
for example "abcdefabcdefffff", you should let the middle 'f' belong to 'abcdef' instead of 'fffff'.
*/

