
package ues.occ.edu.sv.ingenieria.prn335.control;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import ues.occ.edu.sv.ingenieria.prn335.cinedatalib.entities.Director;

public class DirectorBean {
protected EntityManager em; 
final static EntityManagerFactory EMF=Persistence.createEntityManagerFactory("cinePU");
    
    public void iniciarEm(){
        this.em=EMF.createEntityManager();
    }

    public EntityTransaction getTx(){
        if (this.em!=null){
            return this.em.getTransaction();
        }
        return null;
    }

    /**
     * Metodo para agregar Director a la base
     * @param d 
     */
    public void crear (Director d){

        EntityTransaction tx = this.getTx();
        this.em.persist(d);
        
        tx.commit();
    }
    
    /**
     * Metodo para eliminar Director a la base
     * @param d 
     */
    public void eliminar(Director d) {
        EntityTransaction tx = this.getTx();
        tx.begin();
        this.em.remove(d);
        tx.commit();

    }
    
    /**
     * Metodo que devolverá el nombre con la primera letra mayúscula y el resto
     * minúscula. Ejemplo: si se envía como parámetro ​ luis o luiS ​ el método retornará
     * Luis ​ . Igualmente si envía ​ luis miguel deberá retornar Luis Miguel.
     * 
     * @param Nombre
     * @return cadena de texto modificada
     */
    public String formatoNombre(String Nombre){
        if (!(Nombre.isEmpty() || Nombre.equals(""))) {
            char[] caracteres = Nombre.toCharArray();
            String salida="";
            caracteres[0] = Character.toUpperCase(caracteres[0]);
            salida+=caracteres[0];
            
            for(int i=1; i<Nombre.length(); i++){
                caracteres[i]=Character.toLowerCase(caracteres[i]);
            }
            
            
            for(int i=1; i<Nombre.length(); i++){
                if (caracteres[i] == ' ' || caracteres[i] == '.' || caracteres[i] == ','){
                // Reemplazamos
                caracteres[i + 1] = Character.toUpperCase(caracteres[i + 1]);
                    }
                salida+=caracteres[i];
                }
            return salida;
        }
        
        return Nombre;
    }
    
}
