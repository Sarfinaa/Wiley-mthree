import java.util.*;
import java.io.*;
import java.util.stream.*;

public class TFIDF {
    public static String[] removePunctuation(StringBuilder[] sdata) {
        String str = "‘!”#$%&'()*+,-./:;?@[]^_`{|}~’";
        String[] ndata = new String[sdata.length];
        for (int i = 0; i < ndata.length; i++) {
            StringBuilder data = sdata[i];
            for (int j = data.length() - 1; j >= 0; j--) {
                if (str.contains(data.charAt(j) + "")) {
                    data.deleteCharAt(j);
                }
            }
            ndata[i] = data.toString();
        }
        return ndata;
    }

    public static void Lowercase(String[] str) {
        for (int i = 0; i < str.length; i++) {
            str[i] = str[i].toLowerCase();
        }
    }

    public static List<List<String>> tokenization(String[] data) {
        List<List<String>> list = new ArrayList<>();
        for (String str : data) {
            String[] arr = str.split(" ");
            list.add(new ArrayList<>(Arrays.asList(arr)));
        }
        return list;
    }

    public static void stopWordRemoval(List<List<String>> list) {
        String stopWord = "i, a, is, me, by, my, of, myself, we, our, ours, ourselves, you, you’re, you’ve, you’ll, you’d, your, yours, yourself, yourselves, he, most, other, some, such, no, nor, not, only, own, same, so, then, too, very, s, t, can, will, just, don, don’t, should, should’ve, now, d, ll, m, o, re, ve, y, ain, aren’t, could, couldn’t, didn’t, didn’t";
        for (int i = 0; i < list.size(); i++) {
            List<String> l = list.get(i).stream().filter(word -> !stopWord.contains(word)).collect(Collectors.toList());
            list.set(i, l);
        }
    }

    public static String[] getUniqueWords(List<List<String>> list) {
        Set<String> set = new HashSet();
        for (List<String> l : list) {
            for (String str : l) {
                set.add(str);
            }
        }
        return set.toArray(new String[set.size()]);
    }

    public static double countWords(String word, List<String> words) {
        double ans = 0;
        for (String str : words) {
            if (str.equals(word)) {
                ans++;
            }
        }
        return ans;
    }

    public static double[] generateTFAndIdf(double[][] matrix, String[] uniqueWords, List<List<String>> list) {
        double[] idf = new double[uniqueWords.length];
        for (int j = 0; j < matrix[0].length; j++) {
            String word = uniqueWords[j];
            double noOfTimesTOccured = 0;
            for (int i = 0; i < matrix.length; i++) {
                List<String> words = list.get(i);
                matrix[i][j] = countWords(word, words) / words.size();
                if (matrix[i][j] > 0) {
                    noOfTimesTOccured++;
                }
            }
            idf[j] = Math.log10(matrix.length / noOfTimesTOccured);

        }
        return idf;
    }

    public static void printMatrix(double[][] matrix, String[] uniqueWords) {
        System.out.print("Document| ");
        for (String word : uniqueWords)
            System.out.print(word + " ");
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("file" + (i + 1) + "   | ");
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(String.format("%.3f ", matrix[i][j]));
            }
            System.out.println();
        }
    }

    public static void calculateTFIDF(double[][] matrix, double[] idf) {
        for (int j = 0; j < matrix[0].length; j++) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][j] *= idf[j];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String[] files = { "file1.txt", "file2.txt", "file3.txt", "file4.txt" };
        StringBuilder[] data = new StringBuilder[files.length];

        for (int i = 0; i < files.length; i++) {
            Scanner s = new Scanner(new File(files[i]));
            while (s.hasNextLine()) {
                data[i] = new StringBuilder(s.nextLine());
            }
        }
        String[] ndata = removePunctuation(data);
        Lowercase(ndata);
        List<List<String>> list = tokenization(ndata);
        stopWordRemoval(list);
        String[] uniqueWords = getUniqueWords(list);
        double[][] matrix = new double[files.length][uniqueWords.length];
        double[] idf = generateTFAndIdf(matrix, uniqueWords, list);
        calculateTFIDF(matrix, idf);
        printMatrix(matrix, uniqueWords);

    }

}