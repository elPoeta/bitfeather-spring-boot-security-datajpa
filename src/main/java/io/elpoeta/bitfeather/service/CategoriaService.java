
package io.elpoeta.bitfeather.service;

import io.elpoeta.bitfeather.domain.Categoria;
import java.util.List;

/**
 *
 * @author elpoeta
 */
public interface CategoriaService {
    
    Categoria buscarCategoriaPorId(Integer id); 
    List<Categoria> buscarTodas();
}
