public class Libro {
      
   private String titolo;
   private String autore;
   private int numeroPagine;
   private static double costoPagina = 0.05; //N.B. Attributo Statico o di classe
   private static final double COSTO_FISSO = 5.5;

   public Libro(String titolo, String autore, int numeroPagine) {
      this.titolo = titolo;
      this.autore = autore;
      this.numeroPagine = numeroPagine;
   }

   public Libro(Libro libro) {
      this("Errore", "Errore", -1);
      if (libro != null) {
         this.titolo = libro.getTitolo();
         this.autore = libro.getAutore();
         this.numeroPagine = libro.getNumeroPagine();
      }
   }

   public String getTitolo() {
      return titolo;
   }

   public void setTitolo(String titolo) {
      this.titolo = titolo;
   }

   public String getAutore() {
      return autore;
   }

   public void setAutore(String autore) {
      this.autore = autore;
   }

   public int getNumeroPagine() {
      return numeroPagine;
   }

   public void setNumeroPagine(int numeroPagine) {
      this.numeroPagine = numeroPagine;
   }

   /**
    * Calcola il prezzo del libro
    * @return il prezzo del libro
    */
   public double prezzo() {
      return COSTO_FISSO + numeroPagine*costoPagina;
   }

   /**
    * Metodo statico che imposta il nuovo costo pagina per tutti i libri.
    * @param nuovoCostoPag il nuovo costo pagina per tutti i libri
    */
   public static void setCostoPagina(double nuovoCostoPag){
      costoPagina = nuovoCostoPag;
   }
   /**
    * @return la rappresentazione Stringa del libro
    */
   @Override
   public String toString() {
      double prezzo;
      prezzo = ((double)(Math.round(prezzo() * 100)) / 100);//riduco le cifre decimali a 2
      return ("Titolo: " + titolo +"\tAutore: " + autore + "\tPagine: " +
      numeroPagine +"\tPrezzo: " + prezzo + "€");
   }

   /**
    * @param l'oggetto da confrontare con questo libro
    * @return true se i due oggetti sono uguali, false altrimenti
    */
   @Override
   public boolean equals(Object otherO) {
      if (otherO == null)
         return false;
      if (otherO == this)
         return true;
      if (!(otherO instanceof Libro)) {           
         return false;
         }

      Libro otherL = (Libro)otherO;
      return (titolo.equalsIgnoreCase(otherL.titolo) && autore.equalsIgnoreCase(otherL.autore) &&
            numeroPagine == otherL.numeroPagine);
   }
   
   /**
    * Piccolo test della classe Libro
    * @param args eventuali argomenti della linea di comando
    */
   public static void main (String[] args){
      Libro l1 = new Libro("Pinocchio", "C. Collodi", 150);
      Libro l2 = new Libro("Pollicino", "C. Perrault", 80);
      System.out.println(l1.getTitolo()+": "+l1.prezzo());
      System.out.println(l2.getTitolo()+": "+l2.prezzo());
      Libro.setCostoPagina(0.1);
      System.out.println(l1.getTitolo()+": "+l1.prezzo());
      System.out.println(l2.getTitolo()+": "+l2.prezzo());
   }
}