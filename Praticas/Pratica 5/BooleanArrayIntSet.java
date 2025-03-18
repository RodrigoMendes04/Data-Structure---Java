public class BooleanArrayIntSet implements IntSet {
    private int size;
    public int maxSize; // Numero de elementos do conjunto
    
    private boolean elem[]; // Array que contem os elementos em si
        BooleanArrayIntSet(int maxSize){//com ajuda
            this.maxSize = maxSize;
            elem = new boolean[this.maxSize+1];
            size = 0;
        }
    
    public boolean contains(int x){
        if (elem[x] == true){
            return true;
        }else{
            return false;
        }
    } // Retorna true se x esta no conjunto
    
    public boolean add(int x){
        if (elem[x] == true){
            return false;
        }else{
            elem[x] = true;
            size++;
            return true;
        }
    } // Adiciona x ao conjunto (devolve true se conseguir)
    
    public boolean remove(int x){
        if (elem[x] == true){
            size--;
            elem[x] = false;
            return true;
        }else{
            return false;
        }
    } // Remove x do conjunto (devolve true se conseguir)
    
    public int size(){
        return size;
    } // Retorna o numero de elementos do conjunto
    
    public void clear(){
        size=0;
        for (int i=0; i < maxSize; i++){
            if(elem[i] == true) {
                elem[i] = false;
                //com ajuda
            }
        }
    } // Limpa o conjunto (torna-o vazio)
    
    public boolean equals(IntSet s) {
        if(size != s.size()) {
            return false;
        }
        for(int i=0; i < maxSize; i++) {
            if(!(s.contains(i) == contains(i))) {
                return false;
            }
        }
        return true;
    }
    // Retorna true se ambos os conjuntos sao iguais
    
    public IntSet intersection(IntSet s) {
        IntSet inter = new BooleanArrayIntSet(maxSize-1);
        for(int i=0; i < maxSize; i++) {
            if(s.contains(i) && contains(i)) {
                inter.add(i);
            }
        }
        return inter;
    }
    
    @Override
    public String toString() {
        String res = "{";
        for (int i=0; i<size; i++) {
            if (i>0) res += ",";
                res += elem[i];
        }
        res += "}";
        return res;
    }
}