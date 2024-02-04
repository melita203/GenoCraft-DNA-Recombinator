package dna;

import java.util.LinkedList;

public class LinkedListDNAStrand extends DNAStrand {
    // A linked list to store DNA chunks
    private LinkedList<String> recombinantDNANodes;

    // New LinkedListDNAStrand with the original DNA sequence
    // @param dna the sequence of nucleotides that make up the DNA.

    public LinkedListDNAStrand(String dna) {
        super(dna);
        recombinantDNANodes = new LinkedList<>();
    }

    // Append the given DNA to the recombinant sequence

    protected void append(String dna) {
        recombinantDNANodes.addLast(dna);
    }

    // Returns the number of nucleotides in the strand
    public long size() {
        long size = 0;
        for (String node : recombinantDNANodes) {
            size += node.length();
        }
        return size;
    }

    // Return the recombinant DNA as a single string
    public String toString() {
        StringBuilder recombinantDNA = new StringBuilder();
        for (String node : recombinantDNANodes) {
            recombinantDNA.append(node);
        }
        return recombinantDNA.toString();
    }
}
