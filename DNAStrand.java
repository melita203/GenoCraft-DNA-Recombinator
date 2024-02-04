package dna;

/**
 * Interface for DNA/strand experiments
 * 
 * @author Barbara Lerner. Inspired by an assignment created by Owen Astrachan.
 */
public abstract class DNAStrand {

	// The original DNA before doing cut-and-splice.
	private String originalDNA;

	// Number of splices performed
	private int numSplices = 0;

	/**
	 * Create a new DNA strand
	 * 
	 * @param dna the sequence of nucleotides that make up the DNA. The only
	 *            characters legal in the dna are A, C, T, and G.
	 */
	public DNAStrand(String dna) {
		this.originalDNA = dna;

	}

	/**
	 * Cut this strand at every occurrence of enzyme, replacing
	 * every occurrence of enzyme with splicee. If the strand consists of
	 * more than one node, throws IllegalStateException.
	 * 
	 * @param enzyme  is the pattern/strand searched for and replaced
	 * @param splicee is the pattern/strand replacing each occurrence of enzyme
	 */
	public void cutAndSplice(String enzyme, String splicee) {
		// Find the start of the first occurrence of the enzyme
		int enzymeStart = originalDNA.indexOf(enzyme, 0);

		int enzymeEnd = 0;

		// For each occurrence of the enzyme, repace it with the splicee

		while (enzymeStart >= 0) {

			// Add the section of the DNA since the end of the last occurrence of the enzyme
			// up to the start of the next occurrence of the enzyme to the edited DNA
			append(originalDNA.substring(enzymeEnd, enzymeStart));

			// Add in the splicee that replaces the enzyme
			append(splicee);

			// Update enzymeEnd to skip over the enzyme that was just replaced
			enzymeEnd = enzymeStart + enzyme.length();

			// Search for the start of the next occurrence of the enzyme
			enzymeStart = originalDNA.indexOf(enzyme, enzymeEnd);

			// Update count of number of splices
			numSplices++;
		}
		// Add in the piece of DNA that occurs after the end of the final occurrence of
		// the enzyme.
		String remainingDNA = originalDNA.substring(enzymeEnd);
		append(remainingDNA);
	}

	/**
	 * @return the number of splices performed on the DNA strand
	 */
	public int getNumSplices() {
		return numSplices;
	}

	/**
	 * Adds a piece of dna to the end of the recombinant dna
	 * 
	 * @param dna the piece of dna to add. Should not be null.
	 */
	protected abstract void append(String dna);

	/**
	 * Returns the number of nucleotides in the strand.
	 * 
	 * @return the number of base-pairs in this DnaStrand
	 */
	public abstract long size();

	// Return the recombinant DNA as a single string
	public abstract String toString();
}