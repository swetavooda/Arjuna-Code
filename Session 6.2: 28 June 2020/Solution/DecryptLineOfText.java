/*


Encrypting and Decrypting text is a common activity. Replacing a letter with another letter is insecure.
One of the secure methods is follow dynamic letter replacement such that no two letters are replaced
by the same letter. A line of text encrypted through the following rules.

1. From the input words, a dictionary of known-words is created.
2. All input words are in lower case, one word per line and are arranged in alphabetical order
3. The encrypted lines consists of words from the dictionary of known-words only.
4. There would not be more than 1000 words in the dictionary.
5. A word shall have less than 16 characters.
6. The input encrypted line contain only lower case letters and spaces and shall not exceed more
than 80 characters.

Write a program to decrypt a line of text, assuming that line uses a different set
of replacements, and that all words in the decrypted text are from a dictionary of known-words. If there
is no matching, replace every letter of the alphabet by an asterisk.

Input :
5
alice
in
land
the
wonder
xopkm pt ajm bltymv oxty

Output :
alice in the wonder land


Input :
5
alice
in
land
the
wonder
ab ijkl mno

Output :
** **** ***

Explanation :
-> Use backtracking to map encoded characters to decoded characters.
-> Compare each dictionary word with the current encoded word to see if it's a possible
match, and recurse further if it works.
-> Try to match larger words first, as they will determine more information.
-> Note that your mapping must be one-to-one.


case = 1
input =5
and
dick
jane
puff
spot
bjvg xsb hxsn xsb qymm xsb rqat
output =dick and jane and puff and spot

case = 2
input =5
and
dick
jane
puff
spot
bjvg xsb hxsn xsb qymm xsb rqxt
output =**** *** **** *** **** *** ****


case = 3
input =5
and
dick
jane
puff
spot
bjvg hxsn xsb xsb rqat
output =dick jane and and spot

case = 4
input =4
dick
jane
puff
spot
bjvg xsb hxsn
output =**** *** ****

case = 5
input =5
alice
in
land
the
wonder
xopkm pt ajm bltymv oxty
output =alice in the wonder land


*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DecryptLineOfText {
	static Map<Integer, List<String>> encryptedWordsMap = null, dictionary = null;
	static BufferedReader br = null;
	static final int MAX_SIZE = 512;
	static int lastPoint = 0, lastReadAmount = 0;
	static byte[] data = new byte[MAX_SIZE];
	static char[][] cm = null;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = in.readLine();
		dictionary = new HashMap<Integer, List<String>>();

		int nDictionaryWords = Integer.parseInt(line);

		for (int i = 0; i < nDictionaryWords; i++) {
			line = in.readLine().trim();
			if (line.length() == 0) {
				i--;
				continue;
			}

			if (!dictionary.containsKey(line.length()))
				dictionary.put(line.length(), new ArrayList<String>());
			dictionary.get(line.length()).add(line);
		}

		line = in.readLine();
		while (line != null) {
			if (line.length() == 0) {
				break;
			}
			String[] encryptedWords = line.split("\\s");
			encryptedWordsMap = new HashMap<Integer, List<String>>();
			for (int i = 0; i < encryptedWords.length; i++) {
				String currentEncryptedWord = encryptedWords[i].trim();
				if (!encryptedWordsMap.containsKey(currentEncryptedWord.length()))
					encryptedWordsMap.put(currentEncryptedWord.length(), new ArrayList<String>());
				if (!encryptedWordsMap.get(currentEncryptedWord.length()).contains(currentEncryptedWord))
					encryptedWordsMap.get(currentEncryptedWord.length()).add(currentEncryptedWord);
			}
			char[][] charMap = new char[2][26];
			Arrays.fill(charMap[0], (char) 0);
			Arrays.fill(charMap[1], (char) 0);

			Integer[] keys = new Integer[encryptedWordsMap.size()];
			encryptedWordsMap.keySet().toArray(keys);
			Arrays.sort(keys);
			boolean ret = recurseThrough(charMap, keys, keys.length - 1);
			if (!ret)
				Arrays.fill(charMap[1], '*');
			else
				charMap = cm;
			String output = "";

			for (int i = 0; i < line.length(); i++) {
				char printChar = line.charAt(i);
				if (printChar >= 'a' && printChar <= 'z') {
					printChar = charMap[1][printChar - 'a'];
				}
				output += printChar;
			}
			System.out.println(output);
			line = in.readLine();
		}
		in.close();
	}

	static boolean recurseThrough(char[][] charMap, Integer[] keys, int currIndex) {
		if (currIndex < 0) {
			cm = charMap;
			return true;
		}
		int size = keys[currIndex];
		int comb = encryptedWordsMap.get(size).size(), nDictionaryWords = dictionary.get(size).size();
		boolean[] used = new boolean[nDictionaryWords];
		if (comb > nDictionaryWords) {
			return false;
		}
		return internalRecurse(charMap, size, used, 0, keys, currIndex);
	}

	static boolean internalRecurse(char[][] charMap, int key, boolean[] used, int pos, Integer[] keys, int currIndex) {
		int sz = dictionary.get(key).size();
		int cz = encryptedWordsMap.get(key).size();
		if (pos >= cz) {
			return recurseThrough(charMap, keys, currIndex - 1);
		}
		for (int i = 0; i < sz; i++) {
			boolean doCall = true;
			if (used[i])
				continue;
			used[i] = true;
			char[][] test = new char[2][];
			test[0] = Arrays.copyOf(charMap[0], charMap[0].length);
			test[1] = Arrays.copyOf(charMap[1], charMap[1].length);
			String encWord = encryptedWordsMap.get(key).get(pos), dictWord = dictionary.get(key).get(i);
			for (int j = 0; j < encWord.length(); j++) {
				int encInd = encWord.charAt(j) - 'a';
				int dictInd = dictWord.charAt(j) - 'a';
				if ((test[0][dictInd] != 0 && test[0][dictInd] != encWord.charAt(j))
						|| (test[1][encInd] != 0 && test[1][encInd] != dictWord.charAt(j))) {
					doCall = false;
					break;
				}
				test[0][dictInd] = encWord.charAt(j);
				test[1][encInd] = dictWord.charAt(j);
			}
			if (doCall)
				if (internalRecurse(test, key, used, pos + 1, keys, currIndex)) {
					return true;
				}
			used[i] = false;
		}
		return false;
	}
}
