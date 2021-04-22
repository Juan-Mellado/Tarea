package testClases;
import ChileAutos.Inicio;
import ChileAutos.AutosVehiculos;
import ChileAutos.Vehiculo;

import java.io.IOException;

public class ChileAutos {
    public void mostrarAutos() throws IOException {
        Inicio inicio=new Inicio();
        AutosVehiculos autosVehiculos=new AutosVehiculos();
        Vehiculo vehiculo=new Vehiculo();

        inicio.presionaBtnBuscar();
        autosVehiculos.datosPrimerVehiculo();
        vehiculo.datosVehiculos();

    }
}
