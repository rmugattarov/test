package rmugattarov.persongenes;

public class Person {
    //static Random rand = new Random();
    //private Person mother;
    //private Person father;
    //private String genes;
    //private char sex;
    //private int age, numKids;
    //
    //public Person() {
    //    mother = null;
    //    father = null;
    //    genes = createGenes();
    //    if (rand.nextDouble() <= 0.5)
    //        sex = 'm';
    //    else
    //        sex = 'f';
    //    age = 18;
    //    numKids = 0;
    //}
    //
    //public Person(Person m, Person f) {
    //    mother = m;
    //    father = f;
    //    genes = inheritGenes(m, f);
    //    if (rand.nextDouble() <= 0.5)
    //        sex = 'm';
    //    else
    //        sex = 'f';
    //    age = 0;
    //}
    ////create genes for original Persons
    //private String createGenes() {
    //    String genetics = "";
    //
    //    double first = rand.nextDouble();
    //    double second = rand.nextDouble();
    //    double third = rand.nextDouble();
    //    double fourth = rand.nextDouble();
    //
    //    if (first <= 0.25)
    //        genetics += "G";
    //    else if (first <= 0.68)
    //        genetics += "Z";
    //    else if (first <= 0.9)
    //        genetics += "N";
    //    else
    //        genetics += "F";
    //
    //    if (second <= 0.65)
    //        genetics += "A";
    //    else if (second <= 0.79)
    //        genetics += "T";
    //    else if (second <= 0.85)
    //        genetics += "C";
    //    else
    //        genetics += "G";
    //
    //    if (third <= 0.64)
    //        genetics += "B";
    //    else if (third <= 0.95)
    //        genetics += "F";
    //    else if (third <= 0.98)
    //        genetics += "Q";
    //    else
    //        genetics += "N";
    //
    //    if (fourth <= 0.37)
    //        genetics += "A";
    //    else if (fourth <= 0.58)
    //        genetics += "C";
    //    else if (fourth <= 0.63)
    //        genetics += "T";
    //    else
    //        genetics += "E";
    //    return genetics;
    //
    //}
    ////inherit genes from parents for new Persons
    //public String inheritGenes(Person m, Person f) {
    //    String genetics = "";
    //    double first = rand.nextDouble();
    //    double second = rand.nextDouble();
    //    double third = rand.nextDouble();
    //    double fourth = rand.nextDouble();
    //
    //    if (first < 0.5) {
    //        genetics += m.getGenes().charAt(0);
    //    } else
    //        genetics += f.getGenes().charAt(0);
    //
    //    if (second < 0.5) {
    //        genetics += m.getGenes().charAt(1);
    //    } else
    //        genetics += f.getGenes().charAt(1);
    //
    //    if (third < 0.5) {
    //        genetics += m.getGenes().charAt(2);
    //    } else
    //        genetics += f.getGenes().charAt(2);
    //
    //    if (fourth < 0.5) {
    //        genetics += m.getGenes().charAt(3);
    //    } else
    //        genetics += f.getGenes().charAt(3);
    //
    //    return genetics;
    }
