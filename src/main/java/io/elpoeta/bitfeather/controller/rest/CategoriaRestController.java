
package io.elpoeta.bitfeather.controller.rest;

import io.elpoeta.bitfeather.domain.Categoria;
import io.elpoeta.bitfeather.service.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author elpoeta
 */
@RestController
@RequestMapping("api/categoria")
public class CategoriaRestController {
    private CategoriaService categoriaService;
    
    @Autowired
    public void setCategoriaService(CategoriaService categoriaService){
        this.categoriaService = categoriaService;
    }
    
    @GetMapping("/categorias")
    public List<Categoria> traerCategorias(){
        List<Categoria> categorias = categoriaService.buscarTodas();
        return categorias;
    }
}
