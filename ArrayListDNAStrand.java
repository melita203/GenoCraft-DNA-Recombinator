package dna;

import java.util.ArrayList;

public class ArrayListDNAStrand extends DNAStrand {

    // ArrayList to store DNA chunks
    private ArrayList<String> recombinantDNAChunks;

    // Create a new ArrayListDNAStrand that stores the original DNA sequence
    // @param dna the sequence of nucleotides

    public ArrayListDNAStrand(String dna) {
        super(dna);
        recombinantDNAChunks = new ArrayList<>();
    }

    // Append the DNA snippet to the recombinant sequence.
    // @param dna the piece of DNA to add

    protected void append(String dna) {
        recombinantDNAChunks.add(dna);
    }

    // Returns the no of base-pairs in the strand

    public long size() {
        long size = 0;
        for (String chunk : recombinantDNAChunks) {
            size += chunk.length();
        }
        return size;
    }

    // Joins the chunks and returns the recombinant DNA as a single string

    public String toString() {
        StringBuilder recombinantDNA = new StringBuilder();
        for (String chunk : recombinantDNAChunks) {
            recombinantDNA.append(chunk);
        }
        return recombinantDNA.toString();
    }
}
