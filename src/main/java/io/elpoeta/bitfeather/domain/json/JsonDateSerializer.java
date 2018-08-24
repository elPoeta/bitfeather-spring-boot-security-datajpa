
package io.elpoeta.bitfeather.domain.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author elpoeta
 */
public class JsonDateSerializer extends JsonSerializer<LocalDateTime>  {
    private static final  DateTimeFormatter formatoFeha = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	@Override
	public void serialize(LocalDateTime fecha, JsonGenerator gen, SerializerProvider provider) throws IOException {
		
		String fechaFormateada = fecha.format(formatoFeha);
		gen.writeString(fechaFormateada);
		
	}
    
}
