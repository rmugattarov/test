package rmugattarov.search;

public class TestInvertedIndexes {
    private static final String doc1 = "One morning, when Gregor Samsa woke from troubled dreams, he found himself transformed in his " +
            "bed into a horrible vermin. He lay on his armour-like back, and if he lifted his head a little he " +
            "could see his brown belly, slightly domed and divided by arches into stiff sections.";
    private static final String doc2 = "The bedding was hardly able to cover it and seemed ready to slide off any moment. His many " +
            "legs, pitifully thin compared with the size of the rest of him, waved about helplessly as he looked." +
            " \"What's happened to me?\" he thought.";
    private static final String doc3 = "It wasn't a dream. His room, a proper human room although a little too small, lay peacefully " +
            "between its four familiar walls. A collection of textile samples lay spread out on the table - " +
            "Samsa was a travelling salesman - and above it there hung a picture that he had recently cut out of " +
            "an illustrated magazine and housed in a nice, gilded frame.";

    public static void main(String[] args) {
        InvertedIndex index = new InvertedIndex();
        Parser.parse(index, new Document(1, doc1));
        Parser.parse(index, new Document(2, doc2));
        Parser.parse(index, new Document(3, doc3));
        Search.proximitySearch("and a", 4, index);
    }
}
