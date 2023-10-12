package ch.heig.dai.lab.fileio.simeline;

public class Transformer {

    private final String newName;
    private final int numWordsPerLine;

    /**
     * Constructor
     * Initialize the Transformer with the name to replace "Chuck Norris" with 
     * and the number of words per line to use when wrapping the text.
     * @param newName the name to replace "Chuck Norris" with
     * @param numWordsPerLine the number of words per line to use when wrapping the text
     */
    public Transformer(String newName, int numWordsPerLine) {
        this.newName = newName;
        this.numWordsPerLine = numWordsPerLine;
    }

    /**
     * Replace all occurrences of "Chuck Norris" with the name given in the constructor.
     * @param source the string to transform
     * @return the transformed string
     */
    public String replaceChuck(String source) {
        return source.replaceAll("Chuck Norris", newName);
    }

    /**
     * Capitalize the first letter of each word in the string.
     * @param source the string to transform
     * @return the transformed string
     */
    public String capitalizeWords(String source) {

        StringBuilder output = new StringBuilder();

        String[] mots = source.split(" ");
        // //s inclut tous les caractères d'espacement \n

        for (String m: mots) {
            output.append(m.substring(0, 1).toUpperCase()).append(m.substring(1)).append(" ");
        }
        // .trim(): Cette méthode supprime les espaces en début et en fin de chaîne.
        return output.toString().trim();
    }

    /**
     * Wrap the text so that there are at most numWordsPerLine words per line.
     * Number the lines starting at 1.
     * @param source the string to transform
     * @return the transformed string
     */
    public String wrapAndNumberLines(String source) {
        // TODO: Implement the method body here.
        // Use the StringBuilder class to build the result string.

        StringBuilder output = new StringBuilder();
        String[] mots = source.split("\\s");

        int wordCount = 0;
        int numberOfLine = 1;

        for (String m : mots) {

            if (wordCount++ == 0) {
                output.append(numberOfLine).append(".");
            }

            if (wordCount != numWordsPerLine) {
                output.append(" ").append(m);
            }

            else {
                output.append(" ").append(m).append("\n");
                wordCount = 0;
                numberOfLine++;
            }
        }

        return output.append("\n").toString();
    }
}   