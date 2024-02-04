package dna;

public class SlowStringDNAStrand extends DNAStrand {

    // A StringBuilder to store the recombinant DNA
    private StringBuilder recombinantDNA;

    // Create a new SlowStringDNAStrand with the original DNA sequence
    // @param dna the sequence of nucleotides

    public SlowStringDNAStrand(String dna) {
        super(dna);
        recombinantDNA = new StringBuilder();
    }

    // Append the DNA snippet to the recombinant sequence.
    // @param dna the piece of DNA to add

    protected void append(String dna) {
        recombinantDNA.append(dna);
    }

    // Returns the number of nucleotides in the strand.

    public long size() {
        return recombinantDNA.length();
    }

    // Returns the recombinant DNA as a single string.

    public String toString() {
        return recombinantDNA.toString();
    }

}
