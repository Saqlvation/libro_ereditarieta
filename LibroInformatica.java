   public class LibroInformatica extends Libro {
      private String argomento;

    public LibroInformatica(String titolo, String autore, int numeroPagine, String argomento){
        super(titolo,autore,numeroPagine);
        this.argomento = argomento;
    }
    public void setArgomento(String argomento){
        this.argomento = argomento;

      }


    public boolean equals(Object altroObject){
        boolean sonoUguali = false;
        if(super.equals(altroObject)){
            if(!(altroObject instanceof LibroInformatica))
                return sonoUguali;
        LibroInformatica otherL = (LibroInformatica)altroObject;
            return (argomento.equalsIgnoreCase(otherL.argomento));
        }   
        else return sonoUguali;
    }
    public static void main(String[] args) {
       
        LibroInformatica x = new LibroInformatica("java per stupidi", "michele", 67, "java");
        LibroInformatica y = new LibroInformatica("java per stupidi", "michele", 67, "java");
        System.out.println(x.equals(y));
       }
   }
