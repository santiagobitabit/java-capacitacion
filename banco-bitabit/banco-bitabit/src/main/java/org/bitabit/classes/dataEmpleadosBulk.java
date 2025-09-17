package org.bitabit.classes;

import java.io.FileReader;
import java.io.Reader;
import java.util.Map;


import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class dataEmpleadosBulk {
    Banco banco;

    public dataEmpleadosBulk(Banco banco){
        this.banco = banco;
    }

    public void ingresarEmpleadosCsv(String path){

        try (Reader reader = new FileReader(path);
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                     .withFirstRecordAsHeader() // Indica que la primera fila son las cabeceras
                     .withIgnoreHeaderCase() // Ignora mayúsculas/minúsculas en los nombres de las columnas
                     .withTrim())) { // Elimina espacios en blanco

            // Obtener el mapa de cabeceras (columna -> índice)
            Map<String, Integer> headers = csvParser.getHeaderMap();
            // Iterar sobre cada registro (fila) del CSV
            DB_Connection conexionDB = new DB_Connection();
            for (CSVRecord csvRecord : csvParser) {
                // Obtener valores por nombre de columna
                String nombre = csvRecord.get("nombre");
                String apellido = csvRecord.get("apellido");
                String email = csvRecord.get("email");
                String edad = csvRecord.get("edad");
                String telefono = csvRecord.get("telefono");
                Integer sueldo = Integer.parseInt(csvRecord.get("sueldo"));
                try{


                    Empleado empleadoNuevo =  new Empleado(nombre,apellido,Integer.parseInt(edad),email,telefono,sueldo,this.banco);
                    if (empleadoNuevo != null) conexionDB.addEmpleado_DB(empleadoNuevo);
                } catch (Exception e){
                    e.printStackTrace();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
