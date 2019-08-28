
package ues.occ.edu.sv.ingenieria.prn335.control;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ues.occ.edu.sv.ingenieria.prn335.cinedatalib.entities.Director;

/**
 *
 * @author melvin
 */
@ExtendWith(MockitoExtension.class)
public class DirectorBeanTest {
    
    /**
     * Test de metodo crear
     */
    @Test
    public void crearTest(){
        System.out.println("crear");
        EntityManager mockEM = Mockito.mock(EntityManager.class);
        EntityTransaction mockTX = Mockito.mock(EntityTransaction.class);
        DirectorBean cut = new DirectorBean();
        Mockito.when(mockEM.getTransaction()).thenReturn(mockTX);
        cut.em=mockEM;
        Director dir = new Director();
        dir.setActivo(true);
        dir.setApellido("Apellido");
        dir.setIdDirector(1);
        dir.setNombre("Nombre");
        cut.crear(dir);
        Mockito.verify(mockEM, Mockito.times(1)).persist(Mockito.any());

    }

    /**
     * Test de eliminar
     */
    @Test
    public void testEliminar() {
        System.out.println("eliminar");
        EntityManager mockEM = Mockito.mock(EntityManager.class);
        EntityTransaction mockTx = Mockito.mock(EntityTransaction.class);
        Mockito.when(mockEM.getTransaction()).thenReturn(mockTx);
        DirectorBean cut = new DirectorBean();
        cut.em=mockEM;
        Director dir = new Director();
        dir.setIdDirector(1);
        dir.setNombre("Nombre");
        dir.setApellido("Apellido");
        dir.setActivo(true);
        cut.eliminar(dir);
        Mockito.verify(mockEM,Mockito.times(1)).remove(Mockito.any());
    }

    /**
     * Test de formatoNombre
     */
    @Test
    public void testformatoNombre(){
       System.out.println("formatoMombre");
       DirectorBean cut = new DirectorBean(); 
       String nombre ="nOmbrE aPelliDo";
       String expResult = "Nombre Apellido";
       String result = cut.formatoNombre(nombre);
       Assert.assertTrue(expResult.equals(result));
    }
    
}
